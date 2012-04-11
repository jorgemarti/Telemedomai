/*
 * Presion.java
 *
 * Created on 9 de mayo de 2007, 20:12
 *
 */

package tiposDatos;

import java.io.*;

/**
 *
 * @author Coke
 */
public class Presion implements Serializable
{
    private String sistolica,diastolica;
        
    public Presion(String s,String d)
    {
        sistolica=s;
        diastolica=d;
    }
    
    private void writeObject(java.io.ObjectOutputStream out)
         throws IOException
     {
         out.writeUTF(sistolica);
         out.writeUTF(diastolica);
         out.flush();
     }
    
    private void readObject(java.io.ObjectInputStream in)
         throws IOException,ClassNotFoundException
     {
        sistolica=in.readUTF();
        diastolica=in.readUTF();
     }
    
   public String toString()
   {
       return ("La presión arterial sistólica es: "+sistolica+" y la diastólica: "+diastolica);
   }
   
   public String [] getDatos()
   {
       String [] aux=new String[2];
       aux[0]=sistolica;
       aux[1]=diastolica;
       return aux;
   }
}

