/*
 * Datos.java
 *
 * Created on 8 de marzo de 2007, 12:12
 *
 */

package tiposDatos;

import java.io.*;

/**
 *
 * @author Coke
 */
public class Diagnostico implements Serializable
{
    private String diag,recom;
    private String[] doctor;
    private String file;
    
    public Diagnostico(String d,String r,String[] doc,String f)
    {
        diag=d;
        recom=r;
        doctor=doc;
        file=f;
    }
    
    private void writeObject(java.io.ObjectOutputStream out)
         throws IOException
     {
         out.writeUTF(diag);
         out.writeUTF(recom);
         out.writeObject(doctor);
         
         //Después de mandar los campos, mandamos el archivo PDF, 1k a 1k
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
         throws IOException,ClassNotFoundException
     {
        diag=in.readUTF();
        recom=in.readUTF();
        doctor=(String [] )in.readObject();
        
        file="temp.pdf";
        File temporal=new File(file);
        
        // Después de recibir los campos pasamos a escribir físicamente el archivo PDF
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
    
   public String toString()
   {
       return ("El diagóstico es: "+diag+" y la recomendación del doctor"+doctor+" es: "+recom);
   }
   
   public String [] getDatos()
   {
       String [] aux=new String[5];
       aux[0]=diag;
       aux[1]=recom;
       aux[2]=doctor[0];
       aux[3]=doctor[1];
       aux[4]=doctor[2];
       return aux;
   }
}

