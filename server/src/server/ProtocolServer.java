/*
 * ProtocolServer.java
 *
 * Created on 6 de marzo de 2007, 17:09
 *
 * Clase creada para gestionar las comunicaciones entre el
 * interfaz del programa y la red, encagada de mandar
 * los mensajes al cliente.
 *
 */

package server;

import java.net.*;
import java.io.*;
import java.security.KeyStore;
import javax.net.*;
import javax.net.ssl.*;
import javax.security.cert.X509Certificate;

/**
 *
 * @author Coke
 */
public class ProtocolServer extends Thread {
    
    private ServerIF interfaz;
    private ServerSocket serverSocket;
    private SSLSocket clientSocket;
    private InputStream input;
    private OutputStream output;
    private ObjectInputStream entradaDatos;
    private ObjectOutputStream salidaDatos;
    
    private int port=19820;              //Puerto elegido al azar entre los no ocupados
    private boolean connected,serverStarted,passwordError=false;
    
    
    /**
     * Crea una instancia de ProtocolServer
     */
    public ProtocolServer() 
    {
    }
    
    public ProtocolServer(int puerto)
    {
        port=puerto;
    }
    
    /**
     * Método que crea el socket SSL de servidor y pone el sistema a la espera de clientes.
     * Tras esto se queda en un bucle recibiendo los diferentes mensajes desde el
     * programa cliente y dándoles la respuesta adecuada, hasta que se cancela la conexión.
     *
     */
    public void run()
    {
        try
        {
            ServerSocketFactory ssf = getServerSocketFactory();
            serverSocket= ssf.createServerSocket(port);
            ((SSLServerSocket) serverSocket).setWantClientAuth(true);
            ((SSLServerSocket) serverSocket).setNeedClientAuth(true);
            connected=true;
                        
            // Se acepta una conexión con un cliente. Esta llamada se queda
            // bloqueada hasta que se arranque el cliente.
            
            System.out.println ("Esperando cliente");
            clientSocket = (SSLSocket)serverSocket.accept();
            System.out.println ("Conectado con cliente de " + clientSocket.getInetAddress());
                        
            input=clientSocket.getInputStream();
            output=clientSocket.getOutputStream();
            entradaDatos=new ObjectInputStream(input);
            salidaDatos=new ObjectOutputStream(output);
            int type;
            while (connected)
            {              
                type=typeOfDataReceived(entradaDatos);
                switch (type)
                {
                    case 0:
                        tiposDatos.Datos datos=receiveDatos(entradaDatos);
                        interfaz.setDatos(datos);
                        break;
                        
                   case 1:
                        System.out.println("El tipo de datos lo lee bien" +
                                " que es de imagen.");
                        tiposDatos.Imagen imagen=receiveImagen(entradaDatos);
                                           
                        interfaz.setImagen(imagen);
                        break;
                        
                   case 2:
                        System.out.println("El tipo de datos lo lee bien" +
                                " que es de audio.");
                        tiposDatos.Audio audio=receiveAudio(entradaDatos);
                                           
                        interfaz.setAudio(audio);
                        //connected=false;
                        break;
                        
                   case 3:
                        System.out.println("El tipo de datos lo lee bien" +
                                " que es presion arterial.");
                        tiposDatos.Presion presion=receivePresion(entradaDatos);
                        interfaz.setPresion(presion);
                        break;
                        
                   case 4:
                        System.out.println("El tipo de datos lo lee bien" +
                                " que Otras Medidas.");
                        tiposDatos.Medida medida=receiveMedida(entradaDatos);
                        interfaz.setMedida(medida);
                        break;
                        
                   case 5:
                        System.out.println("El tipo de datos lo lee bien " +
                                "que VIDEOCONFERENCIA.");
                        interfaz.setWebcam();
                        break;
                        
                    case 6:
                        System.out.println("El tipo de datos lo lee bien" +
                                " que AUDIOCONFERENCIA.");
                        interfaz.setAudioConferencia();
                        break;
                   
                   case 7:
                        System.out.println("Recibida petición de " +
                                "finalización de conferencia.");
                        interfaz.stopConferencia();
                        break;
                              
                    
                    default:
                        System.out.println("No entra bien, no pilla " +
                                "la opción que le mandamos.");
                        if (connected!=false){
                            interfaz.resetPatient(); // Si hemos entrado a                                                   
                            connected=false;}     //esta opción voluntariamente
                        break;                    // no hay que resetear
                            
                }
            }
            
        }
        catch (Exception e)
        {
            System.out.println("Error en algún punto: "+e+"\n");
            e.printStackTrace();
            passwordError=true;
            connected=false;
        }
    }

    /**
     * Método que lee de la entrada un entero para diferenciar el tipo de 
     * mensaje que nos envió el cliente.
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
     * Método para recibir un objeto de datos por parte del cliente,
     * que posteriormente será pasado al interfaz.
     */
    
    private tiposDatos.Datos receiveDatos(ObjectInputStream entrada)
    {
        try
        {
            Object aux=entrada.readObject();
            System.out.println("Llega a leeer el objeto de Datos");
            tiposDatos.Datos datos=(tiposDatos.Datos)aux;            
            return datos;
        }
        catch (Exception e)
        {
            System.out.println("Error leyendo datos de usuario: "+e);
            return null;
        }
    }
    
    /**
     * Método para recibir un objeto de IMAGEN por parte del cliente,
     * que posteriormente será pasado al interfaz.
     */
    
    private tiposDatos.Imagen receiveImagen(ObjectInputStream entrada)
    {
        try
        {
            Object aux=entrada.readObject();
            tiposDatos.Imagen imagen=(tiposDatos.Imagen)aux;            
            return imagen;
        }
        catch (Exception e)
        {
            System.out.println("Error leyendo el objeto imagen: "+e);
            return null;
        }
    }
     
    /**
     * Método para recibir un objeto de AUDIO por parte del cliente,
     * que posteriormente será pasado al interfaz.
     */ 
    
    private tiposDatos.Audio receiveAudio(ObjectInputStream entrada)
    {
        try
        {
            Object aux=entrada.readObject();
            tiposDatos.Audio audio=(tiposDatos.Audio)aux;            
            return audio;
        }
        catch (Exception e)
        {
            System.out.println("Error leyendo el objeto audio: "+e);
            return null;
        }
    }
     
    /**
     * Método para recibir un objeto de PRESION ARTERIAL por parte 
     * del cliente, que posteriormente será pasado al interfaz.
     */
    
    private tiposDatos.Presion receivePresion(ObjectInputStream entrada)
    {
        try
        {
            Object aux=entrada.readObject();
            tiposDatos.Presion presion=(tiposDatos.Presion)aux;            
            return presion;
        }
        catch (Exception e)
        {
            System.out.println("Error leyendo el objeto presion: "+e);
            return null;
        }
    }
    
    /**
     * Método para recibir un objeto de MEDIDA por parte del cliente,
     * que posteriormente será pasado al interfaz.
     */
      
   private tiposDatos.Medida receiveMedida(ObjectInputStream entrada)
    {
        try
        {
            Object aux=entrada.readObject();
            tiposDatos.Medida medida=(tiposDatos.Medida)aux;            
            return medida;
        }
        catch (Exception e)
        {
            System.out.println("Error leyendo el objeto medida: "+e);
            return null;
        }
    }
      
   public boolean enviaWebcam()
    {
        try
        {
            // Enviamos el indicador de petición de transmisión de webcam
            salidaDatos.writeInt(5);
            salidaDatos.flush();           
        }
        catch (Exception e)
        {
            System.out.println("Error mandando petición de videoconferencia!");
            return false;
        }
        return true;
    }
   
    public boolean enviaDiagnostico(tiposDatos.Diagnostico d)
    {
        try
        {
            // Enviamos primero el indicador de que estamos mandando 
            // EL DIAGNÓSTICO al cliente esté preparado para 
            // la recepción de un objeto de tipo Diagnóstico
            salidaDatos.writeInt(8);
            salidaDatos.flush();
            //Y ahora mandamos los datos propiamente
            salidaDatos.writeObject(d);
            return true;
            
        }
        catch (Exception e)
        {
            System.out.println("NO SE PUDO ESCRIBIR EL DIAGNÓSTICO");
            return false;
        }
    }
    
/**
 * Método para comunicar al servidor que vamos a detener la conferencia, 
 * sea webcam o sólo audio
 */
    public boolean stopConferencia()
    {
        try
        {
            // Enviamos el indicador de finalización de transmisión
            salidaDatos.writeInt(7);
            salidaDatos.flush();           
        }
        catch (Exception e)
        {
            System.out.println("Error mandando finalización de conferencia!");
            return false;
        }
        return true;
    }
    
                
    public boolean startServer(ServerIF iface)
    {
        interfaz=iface;
        this.start();
        while (!connected)     //Bloqueamos el sistema hasta que se conecta
            if (passwordError) // o nos devuelve un error de password
                return false;
       serverStarted=true;
       return true;
    }
    
       
    public void stopServer()
    {   
        connected=false;
        try
        {
            serverStarted=false;
            if(clientSocket!=null)
            {
                input.close();
                output.close();
                clientSocket.close();
            }
                        
            serverSocket.close();
            System.out.println("Conexión cerrada...");
            
        }
        catch (Exception e)
        {
            System.out.println("Problemas cerrando los sockets...");
            System.out.println(e.getMessage());
            
        }
        
    }
    
    
    public boolean isStarted()
    {
        return serverStarted;
    }
    
    public boolean isConnected()
    {
        return connected;
    }
    
 
    public Socket getClientSocket() {
        return clientSocket;
    }
    
    
    /**
     * Método auxiliar para configurar la conexión 
     * segura SSL, que lee las contraseñas del keystore
     * del usuario.
     */
    
    private ServerSocketFactory getServerSocketFactory() throws Exception
    {
        SSLServerSocketFactory ssf = null;
        String [] userPassword=interfaz.getUserPassword();
                   
        SSLContext ctx;
        KeyManagerFactory kmf;
        KeyStore ks;
        TrustManagerFactory tmf;
        char[] passphrase = userPassword[1].toCharArray();

        ctx = SSLContext.getInstance("TLS");
        kmf = KeyManagerFactory.getInstance("SunX509");
        tmf = TrustManagerFactory.getInstance("SunX509");
        ks = KeyStore.getInstance("JKS");
				
        ks.load(new FileInputStream(".//SSL/"+userPassword[0]+".keystore")
        , passphrase);
        kmf.init(ks,passphrase);
        tmf.init(ks);
            	
        ctx.init(kmf.getKeyManagers(), tmf.getTrustManagers(), null);
            
        ssf = ctx.getServerSocketFactory();
        return ssf;    
    }
}


