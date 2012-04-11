/*
 * Medida.java
 *
 * Created on 15 de mayo de 2007, 18:09
 *
 */

package tiposDatos;

import java.io.*;

/**
 *
 * @author Coke
 */
public class Medida implements Serializable
{
    private String tipo,medicion;
        
    public Medida(String t,String m)
    {
        tipo=t;
        medicion=m;
    }
    
    private void writeObject(java.io.ObjectOutputStream out)
         throws IOException
     {
         out.writeUTF(tipo);
         out.writeUTF(medicion);
         out.flush();
     }
    
    private void readObject(java.io.ObjectInputStream in)
         throws IOException,ClassNotFoundException
     {
        tipo=in.readUTF();
        medicion=in.readUTF();
     }
    
   public String toString()
   {
       return ("La medición de tipo: \""+tipo+"\" ha dado unos resultados de: \n"+medicion);
   }
   
   public String [] getDatos()
   {
       String [] aux=new String[2];
       aux[0]=tipo;
       aux[1]=medicion;
       return aux;
   }
}

