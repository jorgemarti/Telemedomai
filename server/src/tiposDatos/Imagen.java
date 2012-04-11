/*
 * Imagen.java
 *
 * Created on 9 de marzo de 2007, 18:35
 *
 * Clase de datos de imagen. En ella definimos tanto las
 * características de un objeto de este tipo, como los
 * métodos utilizados para transmitirlos.
 *
 */

package tiposDatos;

import java.io.*;

/**
 *
 * @author Coke
 */
public class Imagen implements Serializable
{
    String file,descrip;
        
    /**
     * Constructor de la clase imagen, a la que se le pasa de
     * parámetros el nombre del archivo de imagen y la 
     * descripción de la misma.
     */
    
    public Imagen(String f,String d)
    {
        file=f;
        descrip=d;
    }
    
    /**
     * Como nuestro protocolo está orientado la excritura de
     * objetos en el socket, debemos definir cómo se realiza
     * esta operación en nuestro tipo de datos imagen. Se llama
     * "serializar" a esta acción.
     */
    
    private void writeObject(java.io.ObjectOutputStream out)
         throws IOException
     {
         out.writeUTF(descrip);
         
         //Después de mandar la descripcion, mandamos el archivo de 
         // imagen, 1kbyte a 1kbyte
         FileInputStream in=new FileInputStream(new File(file));
         byte[] buffer=new byte[1024];
         int len,i=1;
         while ((len=in.read(buffer))>0)
         {
             out.write(buffer,0,len);
             out.flush();
             i++;
         }
         System.out.println("Hemos escrito en la salida "+i+
                 " bufferes de 1k");
         in.close(); 
     }
    
    /**
     * Este método es el simétrico del anterior, debemos definir
     * también cómo deserializar el objeto recibido, y pasárselo
     * al programa.
     */
    
    private void readObject(java.io.ObjectInputStream in)
         throws IOException
     {
        descrip=in.readUTF();
        file="temp.jpg";
        File temporal=new File(file);
               
        // Después de recibir la descripción pasamos a escribir 
        // físicamente el archivo de imagen
        FileOutputStream out = new java.io.FileOutputStream(temporal);
        byte[] buffer = new byte[1024];
        int len;
        while ((len = in.read(buffer)) > 0) 
        {
            out.write(buffer, 0, len);
        }
        out.close();
        
        // Marcamos el archivo temporal utilizado para ser eliminado 
        // al salir del programa
        temporal.deleteOnExit();
        
       
     }
    
    /**
     * Clase auxiliar que simplemente devuelve
     * un vector con el nombre del archivo que
     * contiene la imagen y la descripción.
     */
    
    public String [] getDatos()
    {
        String [] aux=new String[2];
        aux[0]=file;
        aux[1]=descrip;
        return aux;
    }
}