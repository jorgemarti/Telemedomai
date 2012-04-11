/*
 * Captura.java
 *
 * Clase auxiliar creada para la captura de una imagen estática
 * desde una cámara web, tras la inicialización de ésta.
 */

package client;

import javax.media.*;
import javax.media.control.*;
import javax.media.util.*;
import javax.media.format.*;
import javax.imageio.*;
import java.io.*;
import java.awt.*;
import java.awt.image.*;

public class Captura{

  Player player = null;
  Image img = null;
  String dispositivo = "";
  
  /**
   * Constructor de la clase, al que pasamos como parámetro
   * el dispositivo desde donde realizará la captura.
   * Ej: "vfw://"
   */
  
  public Captura (String dispositivo)
  {
      try{
          MediaLocator loc=new javax.media.MediaLocator(dispositivo);
          player = Manager.createRealizedPlayer(loc);
          player.start();
          Thread.sleep(1000);
      }
      catch (Exception e)
      {
          System.out.println("Error al iniciar el player");
      }
      
  }
  
  /**
   * Método para conseguir la componente visual
   * del reproductor, y poder mostrar el vídeo
   * en cualquier parte de una interfaz.
   */
  
  public Component getPlayer()
  {
      Component visual,contr;
      if ((visual = player.getVisualComponent()) != null)
      {
          //visual.setSize(visual.getPreferredSize());
          visual.setSize(352,288);
          return visual;
      }
      return null;
  }
  
  /**
   * Método que realiza la captura de la imagen estática
   */
  
  public String capturaImagen()
  {
      FrameGrabbingControl fgc = (FrameGrabbingControl)
      player.getControl("javax.media.control.FrameGrabbingControl");
      Buffer buf = fgc.grabFrame();
      // creamos la imagen awt
      BufferToImage btoi = new BufferToImage((VideoFormat)buf.getFormat());
      img = btoi.createImage(buf);
      String formato = "JPEG";
      String archivo="temp.jpg";
      File imagenArch=new File(archivo);
      imagenArch.deleteOnExit();
      try
      {
          ImageIO.write((RenderedImage) img,formato,imagenArch);
      }
      catch (IOException ioe)
      {
          System.out.println("Error al guardar la imagen");
          return null;
      }
      return archivo;
  }
  
  /**
   * Método para detener la captura de imágenes
   */
  
  public void stop()
  {
      player.stop();
      player.deallocate();
      player.close();
  }
}

