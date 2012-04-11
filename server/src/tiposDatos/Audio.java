/*
 * Audio.java
 *
 * Created on 14 de marzo de 2007, 17:48
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package tiposDatos;

import java.io.*;

/**
 *
 * @author Coke
 */
public class Audio implements Serializable
{
    String file,descrip;
        
    public Audio(String f,String d)
    {
        file=f;
        descrip=d;
    }
    
    private void writeObject(java.io.ObjectOutputStream out)
         throws IOException
     {
         out.writeUTF(descrip);
         
         //Después de mandar la descripcion, mandamos el archivo de sonido, 1k a 1k
         FileInputStream in=new FileInputStream(new File(file));
         byte[] buffer=new byte[1024];
         int len,i=1;
         while ((len=in.read(buffer))>0)
         {
             out.write(buffer,0,len);
             out.flush();
             i++;
         }
         System.out.println("Hemos escrito en la salida "+i+" bufferes de 1k");
         in.close(); 
     }
    
    private void readObject(java.io.ObjectInputStream in)
         throws IOException
     {
        descrip=in.readUTF();
        file="temp.wav";
        File temporal=new File(file);
        
        // Después de recibir la descripción pasamos a escribir físicamente el archivo de SONIDO
        FileOutputStream out = new java.io.FileOutputStream(temporal);
        byte[] buffer = new byte[1024];
        int len;
        while ((len = in.read(buffer)) > 0) 
        {
            out.write(buffer, 0, len);
        }
        out.close(); 
        //Marcamos el archivo temporal utilizado para ser eliminado al salir del programa
        temporal.deleteOnExit();
       
     }
    
    public String [] getDatos()
    {
        String [] aux=new String[2];
        aux[0]=file;
        aux[1]=descrip;
        return aux;
    }
}