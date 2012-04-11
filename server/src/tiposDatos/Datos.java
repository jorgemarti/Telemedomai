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
public class Datos implements Serializable
{
    private String nombre,apellido,edad,sexo,credencial,sintomas;
    
    public Datos(String n,String a,String e,String s,String c,String sin)
    {
        nombre=n;
        apellido=a;
        edad=e;
        sexo=s;
        credencial=c;
        sintomas=sin;
    }
    
   public String toString()
   {
       return ("Los datos son: "+nombre+" "+apellido+" "+edad+" "+sexo+" "+credencial+" "+sintomas);
   }
   
   public String [] getDatos()
   {
       String [] aux=new String[6];
       aux[0]=nombre;
       aux[1]=apellido;
       aux[2]=edad;
       aux[3]=sexo;
       aux[4]=credencial;
       aux[5]=sintomas;
       return aux;
   }
}

