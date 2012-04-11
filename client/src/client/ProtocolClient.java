/*
 * ProtocolClient.java
 *
 * Created on 6 de marzo de 2007, 17:09
 *
 * Clase creada para gestionar las comunicaciones entre el
 * interfaz del programa y la red, encagada de mandar
 * los mensajes al servidor.
 *
 */

package client;

import java.net.*;
import java.io.*;

import javax.net.ssl.*;
import javax.security.cert.X509Certificate;
import java.security.KeyStore;
import javax.net.*;
/**
 *
 * @author Coke
 */
public class ProtocolClient extends Thread{
    
    private ClientIF interfaz;
    private String server="localhost";
    private SSLSocket socketCliente;
    private OutputStream output;
    private InputStream input;
    private ObjectOutputStream salidaDatos;
    private ObjectInputStream entradaDatos;
    
    private boolean connected;
    
    
    /**
     * Crea una instancia de ProtocolClient
     */
    
    public ProtocolClient()
    {
        
    }
     
    /**
     * Crea una instancia de ProtocolClient, con el servidor como par�metro.
    */
    
    public ProtocolClient(String servidor) 
    {
        server=servidor;
    }
    
    /**
     * M�todo que conecta con el servidor
     *
     */
    
    public boolean startProtocol(ClientIF iface)
    {
        interfaz=iface;
        try
        {
            SSLSocketFactory factory=getSocketFactory();
            socketCliente=(SSLSocket)factory.createSocket(server, 19820);
            
            socketCliente.startHandshake();
            
            output=socketCliente.getOutputStream();
            input=socketCliente.getInputStream();
            salidaDatos=new ObjectOutputStream(output);
            entradaDatos=new ObjectInputStream(input);
            System.out.println("Conexi�n correcta con el servidor "+socketCliente.getInetAddress());
            this.start();
            connected=true;
            return true;
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
            return false;
        }
    }
    
    /**
     * M�todo run() necesario para la clase thread.
     * Cont�nuamente realiza comprobaciones de si hemos
     * recibido alg�n mensaje desde el servidor.
     */
    
    public void run()
    {
        while (connected)
        {
            int type=typeOfDataReceived(entradaDatos);
            if (type==8)
            {
                tiposDatos.Diagnostico diag=receiveDiagnostico(entradaDatos);
                interfaz.setDiagnostico(diag);
            }
            else if (type==5)
            {
               interfaz.setWebcam(); 
            }
            else if (type==7)
            {
                interfaz.stopConferencia();
            }
            else if (type==-1)
            {
                interfaz.resetConnection();
                connected=false;
            }
                
        }
    }
    
    /**
     * M�todo para detener la conexi�n y que se dentenga el thread
     *
     */
    
    public void stopProtocol()
    {
        connected=false;
        try
        {
            output.close();
            input.close();
            salidaDatos.close();
            entradaDatos.close();
            socketCliente.close();
        }
        catch (Exception e)
        {
            System.out.println("Error cerrando la conexi�n: "+e);
        }
        
    }
    
    
    public void enviaDatos(tiposDatos.Datos d)
    {
        try
        {
            // Enviamos primero el indicador de que estamos mandando los DATOS DEL PACIENTE 
            //('0'),para que el servidor est� preparado para la recepci�n de un objeto de 
            // tipo Datos, especificado en la clase Datos.java
            salidaDatos.writeInt(0);
            
            //Y ahora mandamos los datos propiamente
            salidaDatos.writeObject(d);
            
        }
        catch (Exception e)
        {
            System.out.println("NO SE PUDO ESCRIBIR LOS DATOS");
        }
    }
    
    public boolean enviaImagen(String file,String descr)
    {
        try
        {
            // Enviamos primero el indicador de que estamos mandando UN ARCHIVO DE IMAGEN 
            //('1'),para que el servidor est� preparado para la recepci�n de un objeto de 
            // tipo imagen
            salidaDatos.writeInt(1);
            salidaDatos.flush();
           
            //Y ahora mandamos los datos propiamente
            salidaDatos.writeObject(new tiposDatos.Imagen(file,descr));
            
        }
        catch (Exception e)
        {
            System.out.println("NO SE PUDO ESCRIBIR LA IMAGEN");
            return false;
        }
        return true;
    }
    
    public boolean enviaAudio(String file,String descr)
    {
        try
        {
            // Enviamos primero el indicador de que estamos mandando UN ARCHIVO DE AUDIO 
            // ('2'),para que el servidor est� preparado para la recepci�n de un objeto 
            // de tipo AUDIO
            salidaDatos.writeInt(2);
            salidaDatos.flush();
           
            //Y ahora mandamos los datos propiamente
            salidaDatos.writeObject(new tiposDatos.Audio(file,descr));
            
        }
        catch (Exception e)
        {
            System.out.println("NO SE PUDO ESCRIBIR EL ARCHIVO DE SONIDO");
            return false;
        }
        return true;
    }
    
      public boolean enviaPresion(String sist,String diast)
    {
        try
        {
            // Enviamos primero el indicador de que estamos mandando UNA MEDIDA DE PRESION
            // ARTERIAL ('3'),para que el servidor est� preparado para la recepci�n de un 
            // objeto de tipo PRESION
            salidaDatos.writeInt(3);
            salidaDatos.flush();
           
            //Y ahora mandamos los datos propiamente
            salidaDatos.writeObject(new tiposDatos.Presion(sist,diast));
            
        }
        catch (Exception e)
        {
            System.out.println("NO SE PUDO ESCRIBIR EL LOS DATOS DE PRESI�N ARTERIAL");
            return false;
        }
        return true;
    }
      
        public boolean enviaMedida(String tipo,String med)
    {
        try
        {
            // Enviamos primero el indicador de que estamos mandando OTRO TIPO DE MEDIDA 
            // ('4'),para que el servidor est� preparado para la recepci�n de un objeto 
            // de tipo MEDIDA
            salidaDatos.writeInt(4);
            salidaDatos.flush();
           
            //Y ahora mandamos los datos propiamente
            salidaDatos.writeObject(new tiposDatos.Medida(tipo,med));
            
        }
        catch (Exception e)
        {
            System.out.println("NO SE PUDO ESCRIBIR EL LOS DATOS DE MEDIDA");
            return false;
        }
        return true;
    }
    
     public boolean enviaWebcam()
    {
        try
        {
            // Enviamos el indicador de petici�n de transmisi�n de webcam
            salidaDatos.writeInt(5);
            salidaDatos.flush();           
        }
        catch (Exception e)
        {
            System.out.println("Error mandando petici�n de videoconferencia!");
            return false;
        }
        return true;
    }
     
     
    public boolean enviaAudioConferencia()
    {
        try
        {
            // Enviamos el indicador de petici�n de transmisi�n de audioconferencia
            salidaDatos.writeInt(6);
            salidaDatos.flush();           
        }
        catch (Exception e)
        {
            System.out.println("Error mandando petici�n de audioconferencia!");
            return false;
        }
        return true;
    }
/**
 * M�todo para comunicar al servidor que vamos a detener la conferencia, sea webcam o s�lo audio
 */
    public boolean stopConferencia()
    {
        try
        {
            // Enviamos el indicador de finalizaci�n de transmisi�n
            salidaDatos.writeInt(7);
            salidaDatos.flush();           
        }
        catch (Exception e)
        {
            System.out.println("Error mandando finalizaci�n de conferencia!");
            return false;
        }
        return true;
    }
        
    
    /**
     * M�todo para recibir un diagn�sito por parte del servidor, que posteriormente
     * ser� pasado al interfaz.
     */
    
    private tiposDatos.Diagnostico receiveDiagnostico(ObjectInputStream entrada)
    {
        try
        {
            Object aux=entrada.readObject();
            System.out.println("Llega a leeer el objeto de Diagn�stico");
            tiposDatos.Diagnostico diag=(tiposDatos.Diagnostico)aux;            
            return diag;
        }
        catch (Exception e)
        {
            System.out.println("Error leyendo datos de usuario: "+e);
            return null;
        }
    }
    
    /**
     * M�todo que lee de la entrada un entero para diferenciar el tipo de 
     * mensaje que nos envi� el servidor.
     */
    
     private int typeOfDataReceived(ObjectInputStream entrada)
    {
        try
        {
            return entrada.readInt();
        }
        catch (EOFException eof)
        {
            return -1;
        }
        
        catch (Exception e)
        {
            System.out.println("Error leyendo el tipo de datos: "+e);
            return -1;
        }
    }
    
    /**
     * M�todo auxiliar para configurar la conexi�n 
     * segura SSL
     */
     
    private SSLSocketFactory getSocketFactory()
    {
        SSLSocketFactory factory = null;
	try 
        {
            SSLContext ctx;
            KeyManagerFactory kmf;
            KeyStore ks;
            TrustManagerFactory tmf;
		
	
            ctx = SSLContext.getInstance("TLS");
            kmf = KeyManagerFactory.getInstance("SunX509");
            tmf = TrustManagerFactory.getInstance("SunX509");
            ks = KeyStore.getInstance("JKS");
            ks.load(new FileInputStream(".//SSL//paciente.keystore"), "pacientepassword".toCharArray());
            //OJO, REVISAR
            kmf.init(ks, "pacientepassword".toCharArray());
            tmf.init(ks);
            ctx.init(kmf.getKeyManagers(), tmf.getTrustManagers(), null);
	
            factory = ctx.getSocketFactory();
            return factory;
				
	} 
	catch (Exception e) 
	{
            System.out.println(e.getMessage());
            return null;
	}
    }
}
