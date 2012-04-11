/*
 * Informe.java
 *
 * Created on 26 de marzo de 2007, 19:00
 *
 */

package server;

import java.util.*;
import java.text.*;
import java.awt.Color;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import com.lowagie.text.Chapter;
import com.lowagie.text.Document;
import com.lowagie.text.DocumentException;
import com.lowagie.text.Font;
import com.lowagie.text.FontFactory;
import com.lowagie.text.Image;
import com.lowagie.text.PageSize;
import com.lowagie.text.Paragraph;
import com.lowagie.text.Section;
import com.lowagie.text.pdf.PdfWriter;

/**
 *
 * @author Coke
 */


public class Informe {
    
    private String archivo="temp.pdf";
    
    public Informe (String file)
    {
        archivo=file;
    }
    
    public void generar(String [] data,String diag,String recom,String doctor,String numColegiado)
    {
        //Creamos el documento y asignamos margenes izq,der,arriba,abajo
        Document document = new Document(PageSize.A4, 50, 50, 50, 50);
        try{
            //Creamos el "escritor" de nuestro Documento pdf, especificando la ubicacion y nombre de este.
            PdfWriter writer = PdfWriter.getInstance(document,new FileOutputStream(archivo));
            //abrimos el escritor
            document.addTitle("Informe del paciente");
            document.open();
                        
            //Ponemos una imagen como logo al principio
            Image jpg=cargaImagen("/imagenes/logo.png");
            jpg.setAlignment(Image.LEFT);
            jpg.scalePercent(50, 50);
                        
            //Crearemos un capitulo, le pondremos un titulo y la fecha actual
            //Paragraph nos permite introducir texto, y darle formato con FontFactory.getFont
            String fecha = "";
            Date hoy = new Date();
            fecha=new SimpleDateFormat("dd-MM-yyyy").format(hoy);
            int horas=Calendar.getInstance().get(Calendar.HOUR_OF_DAY);
            int minutos=Calendar.getInstance().get(Calendar.MINUTE);
            String hora="";
            if (minutos<10)
                hora=horas+":0"+minutos;
            else
                hora=horas+":"+minutos;
            
            Paragraph titulo1 = new Paragraph("Informe de diagnóstico del paciente\n"+fecha+", "+hora,FontFactory.getFont(FontFactory.TIMES_ROMAN,18, Font.BOLDITALIC, new Color(80, 10, 255)));
            titulo1.setAlignment(Paragraph.ALIGN_RIGHT);
            Chapter capitulo1 = new Chapter(titulo1, 1);
            
            //con '0' no mostramos el numero de pagina
            capitulo1.setNumberDepth(0);
            //Añadimos la imágen
            capitulo1.add(jpg);
            
            //creamos los subtitulos
            Paragraph subTitulo1 = new Paragraph("Datos del paciente",FontFactory.getFont(FontFactory.TIMES_ROMAN, 16,Font.BOLD, new Color(200, 43, 100)));
            Paragraph subTitulo2 = new Paragraph("Sintomatología",FontFactory.getFont(FontFactory.TIMES_ROMAN, 16,Font.BOLD, new Color(200, 43, 100)));
            Paragraph subTitulo3 = new Paragraph("Diagnóstico",FontFactory.getFont(FontFactory.TIMES_ROMAN, 16,Font.BOLD, new Color(200, 43, 100)));
            Paragraph subTitulo4 = new Paragraph("Recomendaciones",FontFactory.getFont(FontFactory.TIMES_ROMAN, 16,Font.BOLD, new Color(200, 43, 100)));
            
            //agregamos el capitulo1 a la seccion1
            Section seccion1 = capitulo1.addSection(subTitulo1);
            Paragraph datosPaciente = new Paragraph("Nombre: "+data[0]+"\n Apellidos: "+data[1]+"\n Edad: "+data[2]+"\n Sexo: "+data[3]+"\n NºCredencial: "+data[4]+"",FontFactory.getFont(FontFactory.TIMES_ROMAN, 12));
            seccion1.add(datosPaciente);
            
            //agregamos otra seccion con el subtitulo2
            Section seccion2 = capitulo1.addSection(subTitulo2);
            Paragraph sintomas = new Paragraph(data[5],FontFactory.getFont(FontFactory.TIMES_ROMAN, 12));
            seccion2.add(sintomas);
            
            //agregamos otra seccion con el subtitulo3
            Section seccion3 = capitulo1.addSection(subTitulo3);
            Paragraph diagnostico = new Paragraph(diag,FontFactory.getFont(FontFactory.TIMES_ROMAN, 12));
            seccion3.add(diagnostico);
            
            //agregamos otra seccion con el subtitulo4
            Section seccion4 = capitulo1.addSection(subTitulo4);
            Paragraph recomendacion = new Paragraph(recom,FontFactory.getFont(FontFactory.TIMES_ROMAN, 12));
            seccion4.add(recomendacion);
            
            //agregamos el capitulo uno al documento
            document.add(capitulo1);
            
            Paragraph footer=new Paragraph("\n\n"+doctor+"\n Nº Colegiado: "+numColegiado,FontFactory.getFont(FontFactory.TIMES_ROMAN, 14));
            footer.setAlignment(footer.ALIGN_RIGHT);
            document.add(footer);
            //cerramos el "escritor"            
            document.close();
        }catch(DocumentException de){
            ;
        }catch(FileNotFoundException fnfe){
            System.out.println("Archivo no encontrado");
        }catch(IOException ioe){
            System.out.println("Error de entrada/salida");
        }
        
        
        System.out.println("Done!!");
    }
    
    
    /**
     * Método de apoyo para cargar imágenes que añadir al INFORME
     *
     */
    
    private Image cargaImagen(String file)
    {
        try 
        {
            java.awt.Image temp=(new javax.swing.ImageIcon(getClass().getResource(file)).getImage());
            return Image.getInstance(temp,new Color(255,255,255));
        }
        catch (Exception e)
        {
            System.err.println(e.getMessage());
            return null;
        }
        
    }
}
