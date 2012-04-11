package client;

import java.awt.*;
import java.io.*;
import java.net.InetAddress;
import javax.media.*;
import javax.media.protocol.*;
import javax.media.protocol.DataSource;
import javax.media.format.*;
import javax.media.control.TrackControl;
import javax.media.control.QualityControl;
import javax.media.rtp.*;
import javax.media.rtp.rtcp.*;
import com.sun.media.rtp.*;

public class AVTransmitter {

    // Entrada MediaLocator
    // Podría ser un archivo,o http o fuente de captura
    private MediaLocator locator1,locator2;       //Si transmitimos audio y video tendremos dos fuentes de captura
    private String ipAddress;
    private int portBase;
    
    private Player localPlayer;             //Nos servirá para visualizar nuestro propio video.
    private Processor processor = null;
    private RTPManager rtpMgrs[];
    private DataSource dataOutput = null;
    private DataSource ds;                  //Será la datasource original
    
    private boolean audioVideo;            //Esta variable nos señalará si vamos a transmitir audio y video simultáneamente.
    
    
    //Constructor para cuando tenemos sólo una fuente de captura (puede ser audio o video)
    public AVTransmitter(MediaLocator locator,
			 String ipAddress,
			 String pb,
			 Format format) {
	
	locator1 = locator;
	this.ipAddress = ipAddress;
	Integer integer = Integer.valueOf(pb);
	if (integer != null)
	    this.portBase = integer.intValue();
        audioVideo=false;    //Sólo transmitimos un medio
    }
    
    //Constructor para cuando tenemos dos fuentes de captura (audio + video)
    public AVTransmitter(MediaLocator locatorAudio,
                         MediaLocator locatorVideo,
			 String ipAddress,
			 String pb,
			 Format format) {
	
	locator1 = locatorAudio;
        locator2= locatorVideo;
	this.ipAddress = ipAddress;
	Integer integer = Integer.valueOf(pb);
	if (integer != null)
	    this.portBase = integer.intValue();
        audioVideo=true;
    }

    /**
     * Inicia la transmisión. Devuelve null si la transmisión inició correctamente.
     * Si no, devuelve un String con el motivo del fallo.
     *
     */
    public synchronized String start() {
	String result;
        
        // Crea un processor para los media locators especificados
        result = createProcessor();
	if (result != null)
	    return result;
            
        // Crea una sesión RTP para transmitir la salida del processor
        // con la IP y puertos especificados
	result = createTransmitter();
	if (result != null) {
	    processor.close();
	    processor = null;
	    return result;
	}

	// Inicia la transmisión
	processor.start();
	
	return null;
    }

    /**
     * Detiene la transmisión si ya estaba iniciada
     */
    public void stop() {
	synchronized (this) {
	    if (processor != null) {
		processor.stop();
		processor.close();
		processor = null;
		for (int i = 0; i < rtpMgrs.length; i++) {
		    rtpMgrs[i].removeTargets( "Session ended.");
		    rtpMgrs[i].dispose();
		}
	    }
	}
    }

    private String createProcessor() {
	if (locator1 == null)
	    return "El locator es nulo";

	//DataSource ds;
        DataSource source1;
        try 
        {
            source1 = javax.media.Manager.createDataSource(locator1);
	} 
        catch (Exception e) 
        {
	    return "Imposible crear la DataSource";
	}
        if (audioVideo==true){
            DataSource original,copia,source2;
            try 
            {
                source2 = javax.media.Manager.createDataSource(locator2);
                DataSource dArray[] = new DataSource[2];
		dArray[0] = source1;
		dArray[1] = source2;
		original = javax.media.Manager.createMergingDataSource(dArray);
                ds=javax.media.Manager.createCloneableDataSource(original);            
            } 
            catch (Exception e) 
            {
                return "Imposible crear la MIXED DataSource";
            }
        }
        else
        {
            ds=source1;
        }
	

	// Intenta crear un processor para manejar el media locator de entrada
	try {
	    processor = javax.media.Manager.createProcessor(ds);
            
	} catch (NoProcessorException npe) {
	    return "No se pudo crear el processor";
	} catch (IOException ioe) {
	    return "IOException creando el processor";
	} 

	// Nos quedamos a la espera de que se configure
	boolean result = waitForState(processor, Processor.Configured);
	if (result == false)
	    return "Imposible configurar el processor";

	// Obtenemos las pistas del processor
	TrackControl [] tracks = processor.getTrackControls();

	// Tenemos al menos una pista?
	if (tracks == null || tracks.length < 1)
	    return "No se encontraron pistas en el processor";

        // Establecemos el content descriptor a RAW_RTP
        // Esto limitará los formatos soportados sólo a 
        // formatos RTP validos
	ContentDescriptor cd = new ContentDescriptor(ContentDescriptor.RAW_RTP);
	processor.setContentDescriptor(cd);

	Format supported[];
	Format chosen;
	boolean atLeastOneTrack = false;

	// Programamos las pistas
	for (int i = 0; i < tracks.length; i++) {
	    Format format = tracks[i].getFormat();
	    if (tracks[i].isEnabled()) {

		supported = tracks[i].getSupportedFormats();

		// Elegimos el primer formato soportado

		if (supported.length > 0) {
		    if (supported[0] instanceof VideoFormat) {
			// Para formatos de video debemos comprobar los
                        // tamaños, pues no todos los formatos funcionan
                        // con todos los tamaños.
			chosen = checkForVideoSizes(tracks[i].getFormat(), 
							supported[0]);
		    } else
			chosen = supported[0];
		    tracks[i].setFormat(chosen);
		    System.err.println("Pista " + i + " establecida para transmitir como:");
		    System.err.println("  " + chosen);
		    atLeastOneTrack = true;
		} else
		    tracks[i].setEnabled(false);
	    } else
		tracks[i].setEnabled(false);
	}

	if (!atLeastOneTrack)
	    return "Imposible establecer ninguna pista a un formato RTP válido";

	// Realizamos el processor.
	result = waitForState(processor, Controller.Realized);
	if (result == false)
	    return "Imposible realizar processor";

	// Establecemos la calidad JPEG a .5.
	setJPEGQuality(processor, 0.5f);

	// Obtenemos la output data source del processor
	dataOutput = processor.getDataOutput();

	return null;
    }


    /**
     * Usa el API RTPManager para crear sesiones para cada pista del processor
     */
    private String createTransmitter() {

	PushBufferDataSource pbds = (PushBufferDataSource)dataOutput;
	PushBufferStream pbss[] = pbds.getStreams();

	rtpMgrs = new RTPManager[pbss.length];
	SessionAddress localAddr, destAddr;
	InetAddress ipAddr;
	SendStream sendStream;
	int port;
	SourceDescription srcDesList[];

	for (int i = 0; i < pbss.length; i++) {
	    try {
		rtpMgrs[i] = RTPManager.newInstance();	    

		// Usamos el mismo puerto tanto para la dirección local 
                // como la destino
		
		port = portBase + 2*i;
		ipAddr = InetAddress.getByName(ipAddress);

		localAddr = new SessionAddress( InetAddress.getLocalHost(),
						port);
		
		destAddr = new SessionAddress( ipAddr, port);

		rtpMgrs[i].initialize( localAddr);
		
		rtpMgrs[i].addTarget( destAddr);
		
		System.err.println( "Creada sesión RTP: " + ipAddress + " " + port);
		
		sendStream = rtpMgrs[i].createSendStream(dataOutput, i);		
		sendStream.start();
	    } catch (Exception  e) {
		return e.getMessage();
	    }
	}

	return null;
    }


    /**
     * Para JPEG y H.263 necesitamos comprobar que se cumple los tamaños adecuados
     */
    Format checkForVideoSizes(Format original, Format supported) {

	int width, height;
	Dimension size = ((VideoFormat)original).getSize();
	Format jpegFmt = new Format(VideoFormat.JPEG_RTP);
	Format h263Fmt = new Format(VideoFormat.H263_RTP);

	if (supported.matches(jpegFmt)) {
	    // Para JPEG, hemos de asegurarnos que tanto altura como anchura son divisibles por 8
	    width = (size.width % 8 == 0 ? size.width :
				(int)(size.width / 8) * 8);
	    height = (size.height % 8 == 0 ? size.height :
				(int)(size.height / 8) * 8);
	} else if (supported.matches(h263Fmt)) {
	    // Para H.263 sólo son soportados algunos tamaños específicos
	    if (size.width < 128) {
		width = 128;
		height = 96;
	    } else if (size.width < 176) {
		width = 176;
		height = 144;
	    } else {
		width = 352;
		height = 288;
	    }
	} else {
	    return supported;
	}

	return (new VideoFormat(null, 
				new Dimension(width, height), 
				Format.NOT_SPECIFIED,
				null,
				Format.NOT_SPECIFIED)).intersects(supported);
    }


    /**
     * Establecemos la calidad de condificación del JPEG encoder
     * 0.5 es un buen valor
     */
    void setJPEGQuality(Player p, float val) {

	Control cs[] = p.getControls();
	QualityControl qc = null;
	VideoFormat jpegFmt = new VideoFormat(VideoFormat.JPEG);

	for (int i = 0; i < cs.length; i++) {

	    if (cs[i] instanceof QualityControl &&
		cs[i] instanceof Owned) {
		Object owner = ((Owned)cs[i]).getOwner();

		if (owner instanceof Codec) {
		    Format fmts[] = ((Codec)owner).getSupportedOutputFormats(null);
		    for (int j = 0; j < fmts.length; j++) {
			if (fmts[j].matches(jpegFmt)) {
			    qc = (QualityControl)cs[i];
	    		    qc.setQuality(val);
			    System.err.println("- Estableciendo calidad de " + 
					val + " en " + qc);
			    break;
			}
		    }
		}
		if (qc != null)
		    break;
	    }
	}
    }

    
    public Component getPlayerComponent()
    {
        Component aux;
        DataSource copia=((SourceCloneable)ds).createClone();
        
        try
        {
            localPlayer=javax.media.Manager.createRealizedPlayer(copia);
            localPlayer.getGainControl().setMute(true);    //Cancelamos el sonido para no escuchar nuestro propio audio.
            localPlayer.start();
            Thread.sleep(1000);
        }
        catch (Exception e)
        {
            System.out.println("Error creando player clonado");
        }
        if((aux=localPlayer.getVisualComponent())==null){
            System.out.println("Componente visual NULA");
            return null;
        }
        //aux.setSize(aux.getPreferredSize());
        aux.setSize (352,288);
        System.out.println(aux.getPreferredSize());
        return aux;
    }

    /**************************************************************************
     * Métodos de conveniencia para manejar cambios de estado en el processor.*
     *************************************************************************/
    
    private Integer stateLock = new Integer(0);
    private boolean failed = false;
    
    Integer getStateLock() {
	return stateLock;
    }

    void setFailed() {
	failed = true;
    }
    
    private synchronized boolean waitForState(Processor p, int state) {
	p.addControllerListener(new StateListener());
	failed = false;

	// Llama al método requerido en el processor
	if (state == Processor.Configured) {
	    p.configure();
	} else if (state == Processor.Realized) {
	    p.realize();
	}
	
	while (p.getState() < state && !failed) {
	    synchronized (getStateLock()) {
		try {
		    getStateLock().wait();
		} catch (InterruptedException ie) {
		    return false;
		}
	    }
	}

	if (failed)
	    return false;
	else
	    return true;
    }

    /****************************************************************
     * Clases internas
     ****************************************************************/

    class StateListener implements ControllerListener {

	public void controllerUpdate(ControllerEvent ce) {

	    // Si hubo un error en la configuración o
            // realización, el processor será cerrado
	    if (ce instanceof ControllerClosedEvent)
		setFailed();

	    // Todos los controllerEvents envían una notificación
            // al thread en espera del método waitForState
	    if (ce instanceof ControllerEvent) {
		synchronized (getStateLock()) {
		    getStateLock().notifyAll();
		}
	    }
	}
    }
}

