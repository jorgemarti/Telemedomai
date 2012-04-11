/*
 * Lanzador.java
 *
 * Created on 28 de marzo de 2007, 20:26
 *
 * Clase creada para lanzar la aplicación por defecto del sistema para abrir Imagenes, URLs, etc...
 *
 */


package server;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.File;

public class Lanzador {

  private String linuxDesktop=null;
  
  
  public Lanzador()
  {
  }
  
  public void abrir(String archivoURL){
      
      if((archivoURL.indexOf("http")!=-1)||(archivoURL.indexOf("mailto:")!=-1)) launchURL(archivoURL);
      else launchDefaultViewer(archivoURL);
  }

  private String getEnv(String envvar){
      try{
          Process p = Runtime.getRuntime().exec("/bin/sh echo $"+envvar);
          BufferedReader br = new BufferedReader(new InputStreamReader(p.getInputStream()));
          String value = br.readLine();
          if(value==null) return "";
          else return value.trim();
      }
      catch(Exception error){
          return "";
      }
  }

  private String getLinuxDesktop(){
      //sólo se averigua el entorno de escritorio una vez, después se almacena en la variable estática
      if(linuxDesktop!=null) return linuxDesktop;
      if(!getEnv("KDE_FULL_SESSION").equals("") || !getEnv("KDE_MULTIHEAD").equals("")){
          linuxDesktop="kde";
      }
      else if(!getEnv("GNOME_DESKTOP_SESSION_ID").equals("") || !getEnv("GNOME_KEYRING_SOCKET").equals("")){
          linuxDesktop="gnome";
      }
      else linuxDesktop="";
   
      return linuxDesktop;
  }

  private Process launchURL(String url){
      try{
          if (System.getProperty("os.name").toUpperCase().indexOf("95") != -1)
          return Runtime.getRuntime().exec( new String[]{"command.com", "/C", "start","\"dummy\"", url} );
          if (System.getProperty("os.name").toUpperCase().indexOf("WINDOWS") != -1)
          return Runtime.getRuntime().exec( new String[]{"cmd.exe", "/C", "start","\"dummy\"", url} );
          if (System.getProperty("os.name").toUpperCase().indexOf("MAC") != -1)
          return Runtime.getRuntime().exec( new String[]{"open", url} );
          if (System.getProperty("os.name").toUpperCase().indexOf("LINUX") != -1 ) {
              if(getLinuxDesktop().equals("kde"))
              return Runtime.getRuntime().exec( new String[]{"kfmclient", "exec", url} );
              else
              return Runtime.getRuntime().exec( new String[]{"gnome-open", url} );
          }
      }
      catch(IOException ioex){System.out.println(ioex);}
   
      return null;
  }

  private Process launchDefaultViewer(String filepath){
      return launchURL( new File(filepath).getAbsolutePath());
  }

}