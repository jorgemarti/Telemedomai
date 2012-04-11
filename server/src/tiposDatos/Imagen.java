/*
 * Imagen.java
 *
 * Created on 9 de marzo de 2007, 18:35
 *
 * Clase de datos de imagen. En ella definimos tanto las
 * caracter�sticas de un objeto de este tipo, como los
 * m�todos utilizados para transmitirlos.
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
     * par�metros el nombre del archivo de imagen y la 
     * descripci�n de la misma.
     */
    
    public Imagen(String f,String d)
    {
        file=f;
        descrip=d;
    }
    
    /**
     * Como nuestro protocolo est� orientado la excritura de
     * objetos en el socket, debemos definir c�mo se realiza
     * esta operaci�n en nuestro tipo de datos imagen. Se llama
     * "serializar" a esta acci�n.
     */
    
    private void writeObject(java.io.ObjectOutputStream out)
         throws IOException
     {
         out.writeUTF(descrip);
         
         //Despu�s de mandar la descripcion, mandamos el archivo de 
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
     * Este m�todo es el sim�trico del anterior, debemos definir
     * tambi�n c�mo deserializar el objeto recibido, y pas�rselo
     * al programa.
     */
    
    private void readObject(java.io.ObjectInputStream in)
         throws IOException
     {
        descrip=in.readUTF();
        file="temp.jpg";
        File temporal=new File(file);
               
        // Despu�s de recibir la descripci�n pasamos a escribir 
        // f�sicamente el archivo de imagen
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
     * contiene la imagen y la descripci�n.
     */
    
    public String [] getDatos()
    {
        String [] aux=new String[2];
        aux[0]=file;
        aux[1]=descrip;
        return aux;
    }
}