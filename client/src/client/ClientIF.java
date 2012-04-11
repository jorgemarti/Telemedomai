/*
 * ClientIF.java
 *
 * Created on 06 de marzo de 2007, 16:59
 *
 * Programa CLIENTE para el proyecto de Telemedicina del alumno Jorge Martí Coronil
 */

package client;

import com.sun.media.multiplexer.video.AVIMux;
import com.sun.media.renderer.video.Java2DRenderer;
import javax.swing.JFileChooser;
import javax.swing.UIManager;
import java.io.*;
import java.net.URL;
import java.awt.Component;
import java.awt.Image;


/**
 *
 * @author  Coke
 */
public class ClientIF extends javax.swing.JFrame {
    
    /*
     * #############   Iniciación de variables mias (las no generadas por Netbeans) ######################
     
     */
    
    private ProtocolClient protocolo;               //Encargado de las comunicaciones
    private JFileChooser imageChooser,pdfChooser;   //Para elegir la imagen que se enviará y el PDF para guardar el informe
    private AudioRecorder recorder;                 //Será el encargado de hacer grabaciones de sonido para enviar al Servidor
    private AVReceiver avr;                         //Encargado de recibir datos de conferencias, sean con video o no
    private AVTransmitter avt;                      //Encargado de transmitir el audio y el video en conferencias
    private Captura capturador;                     //Para capturar imágenes desde una cámara USB
    private boolean capturandoVideo=false;          //Nos servirá para saber si estamos utilizando la cámara USB
    private String ipServer="localhost";            //La ip por defecto es el localhost para pruebas.
    private String[] espec,ips;                     //Almacenaremos aquí la lista de centros/especialistas y sus ips correspondientes
    private tiposDatos.Datos datosPaciente;         //Donde se almacenarán los datos del paciente siendo tratado
    private int pasoMedidaPres=0;                   //Esta variable nos ayudará a saber en qué paso de la medida de presión art. estamos                     
    private boolean pulmFrente;                     //Esta variable global la utilizamos en la auscultación pulmonar
                                                    //para saber si estamos en la parte frontal o trasera
    /** 
     * #############  Constructor de la clase, que llama al método que crea el Form y sus contenidos #####
     */
    
    public ClientIF() {
        // Estas primeras lineas son sólo para adaptarse al aspecto del sistema en que se ejecute
        try {
        UIManager.setLookAndFeel(
            UIManager.getSystemLookAndFeelClassName());
        } catch (Exception e) { }
        
        //Aquí ya empezamos en serio
        initComponents();
        for (int i=1;i<jTabbedPane1.getTabCount();i++)    // Establecemos como inactivas todas las pestañas menos inicio
            jTabbedPane1.setEnabledAt(i,false);          // a la espera de contactar con el servidor           
        
        // Utilizamos esta funcion para cargar los nombres de los centros o especialistas y
        // sus IP correspondientes, desde un fichero local o desde internet, y los colocamos
        // en la combo box correspondiente.
        
        //Ejemplo de fichero local, almacenado en el directorio de configuracion "conf"
        leeIPs(getClass().getResource("/conf/ip.txt"));
        //Ejemplo de URL
        //try{
        //    URL direccion=new URL("http://www.jorgemarti.com/projects/telemedomai/ip.txt");
        //    leeIPs(direccion);
        //}catch (Exception e){}
    }
    
  /** 
     * Método creado por NETBEANS para la incialización de todos
     * los componentes de la interfaz
     * NO MODIFICAR BAJO NINGÚN CONCEPTO
     * NO intentar leer, saltar hasta la parte de manejadores de eventos
     */
    // <editor-fold defaultstate="collapsed" desc=" Generated Code ">//GEN-BEGIN:initComponents
    private void initComponents() {
        buttonGroup1 = new javax.swing.ButtonGroup();
        buttonGroup2 = new javax.swing.ButtonGroup();
        buttonGroup3 = new javax.swing.ButtonGroup();
        jFrame1 = new javax.swing.JFrame();
        jPanel16 = new javax.swing.JPanel();
        jLabel22 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();
        jFrame2 = new javax.swing.JFrame();
        jPanel14 = new javax.swing.JPanel();
        jButton12 = new javax.swing.JButton();
        jButton13 = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jStatusBar = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel4 = new javax.swing.JPanel();
        jPanel9 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jTextField2 = new javax.swing.JTextField();
        jTextField3 = new javax.swing.JTextField();
        jTextField4 = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jRadioButton1 = new javax.swing.JRadioButton();
        jRadioButton2 = new javax.swing.JRadioButton();
        jLabel16 = new javax.swing.JLabel();
        jTextField6 = new javax.swing.JTextField();
        jPanel11 = new javax.swing.JPanel();
        jLabel11 = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox();
        jButton2 = new javax.swing.JButton();
        jPanel5 = new javax.swing.JPanel();
        jButton5 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        jButton7 = new javax.swing.JButton();
        jScrollPane5 = new javax.swing.JScrollPane();
        jTextArea5 = new javax.swing.JTextArea();
        jButton8 = new javax.swing.JButton();
        jPanel13 = new javax.swing.JPanel();
        jLabel14 = new javax.swing.JLabel();
        jRadioButton3 = new javax.swing.JRadioButton();
        jRadioButton4 = new javax.swing.JRadioButton();
        jRadioButton5 = new javax.swing.JRadioButton();
        jLabel15 = new javax.swing.JLabel();
        jRadioButton6 = new javax.swing.JRadioButton();
        jLabel13 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jTextField9 = new javax.swing.JTextField();
        jPanel7 = new javax.swing.JPanel();
        jLabel26 = new javax.swing.JLabel();
        jPanel18 = new javax.swing.JPanel();
        jLabel27 = new javax.swing.JLabel();
        jLabel28 = new javax.swing.JLabel();
        jTextField11 = new javax.swing.JTextField();
        jTextField12 = new javax.swing.JTextField();
        jLabel29 = new javax.swing.JLabel();
        jLabel30 = new javax.swing.JLabel();
        jButton14 = new javax.swing.JButton();
        jScrollPane6 = new javax.swing.JScrollPane();
        jTextArea6 = new javax.swing.JTextArea();
        jPanel6 = new javax.swing.JPanel();
        jPanel10 = new javax.swing.JPanel();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jTextField1 = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jScrollPane4 = new javax.swing.JScrollPane();
        jTextArea4 = new javax.swing.JTextArea();
        jButton11 = new javax.swing.JButton();
        jLabel12 = new javax.swing.JLabel();
        jPanel15 = new javax.swing.JPanel();
        jPanel19 = new javax.swing.JPanel();
        jLabel20 = new javax.swing.JLabel();
        jComboBox2 = new javax.swing.JComboBox();
        jTextField5 = new javax.swing.JTextField();
        jLabel21 = new javax.swing.JLabel();
        jScrollPane7 = new javax.swing.JScrollPane();
        jTextArea7 = new javax.swing.JTextArea();
        jButton15 = new javax.swing.JButton();
        jLabel24 = new javax.swing.JLabel();
        jPanel8 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTextArea2 = new javax.swing.JTextArea();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTextArea3 = new javax.swing.JTextArea();
        jButton1 = new javax.swing.JButton();
        jLabel17 = new javax.swing.JLabel();
        jTextField7 = new javax.swing.JTextField();
        jLabel18 = new javax.swing.JLabel();
        jTextField8 = new javax.swing.JTextField();
        jPanel3 = new javax.swing.JPanel();
        jPanel12 = new javax.swing.JPanel();
        jButton9 = new javax.swing.JButton();
        jButton10 = new javax.swing.JButton();
        jRadioButton7 = new javax.swing.JRadioButton();
        jRadioButton8 = new javax.swing.JRadioButton();
        jPanel17 = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        jButton16 = new javax.swing.JButton();
        jMenuBar2 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenuItem4 = new javax.swing.JMenuItem();
        jMenuItem3 = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenuItem2 = new javax.swing.JMenuItem();

        jFrame1.setTitle("Acerca de...");
        jFrame1.setAlwaysOnTop(true);
        jFrame1.setResizable(false);
        jLabel22.setForeground(new java.awt.Color(102, 153, 255));
        jLabel22.setText("cockemc@yahoo.es");
        jLabel22.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel22MouseClicked(evt);
            }
        });

        jLabel23.setText("Para cualquier duda sobre el programa:");

        jLabel25.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/logoSmall.png")));

        org.jdesktop.layout.GroupLayout jPanel16Layout = new org.jdesktop.layout.GroupLayout(jPanel16);
        jPanel16.setLayout(jPanel16Layout);
        jPanel16Layout.setHorizontalGroup(
            jPanel16Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(jPanel16Layout.createSequentialGroup()
                .add(jPanel16Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(jPanel16Layout.createSequentialGroup()
                        .addContainerGap()
                        .add(jLabel25))
                    .add(jPanel16Layout.createSequentialGroup()
                        .addContainerGap()
                        .add(jPanel16Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.TRAILING)
                            .add(jLabel22)
                            .add(jLabel23))))
                .addContainerGap(org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel16Layout.setVerticalGroup(
            jPanel16Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(jPanel16Layout.createSequentialGroup()
                .addContainerGap()
                .add(jLabel25)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(jLabel23)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(jLabel22)
                .addContainerGap(org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        org.jdesktop.layout.GroupLayout jFrame1Layout = new org.jdesktop.layout.GroupLayout(jFrame1.getContentPane());
        jFrame1.getContentPane().setLayout(jFrame1Layout);
        jFrame1Layout.setHorizontalGroup(
            jFrame1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(jFrame1Layout.createSequentialGroup()
                .addContainerGap()
                .add(jPanel16, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jFrame1Layout.setVerticalGroup(
            jFrame1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(jFrame1Layout.createSequentialGroup()
                .addContainerGap()
                .add(jPanel16, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jFrame2.setTitle("Captura de imagen");
        jFrame2.setAlwaysOnTop(true);
        jFrame2.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jFrame2.setIconImage(new javax.swing.ImageIcon(getClass().getResource("/imagenes/webcam.gif")).getImage());
        jFrame2.setResizable(false);
        jFrame2.addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                jFrame2WindowClosing(evt);
            }
        });

        jPanel14.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        org.jdesktop.layout.GroupLayout jPanel14Layout = new org.jdesktop.layout.GroupLayout(jPanel14);
        jPanel14.setLayout(jPanel14Layout);
        jPanel14Layout.setHorizontalGroup(
            jPanel14Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(0, 408, Short.MAX_VALUE)
        );
        jPanel14Layout.setVerticalGroup(
            jPanel14Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(0, 323, Short.MAX_VALUE)
        );

        jButton12.setText("Capturar");
        jButton12.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton12ActionPerformed(evt);
            }
        });

        jButton13.setText("Cancelar");
        jButton13.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton13ActionPerformed(evt);
            }
        });

        org.jdesktop.layout.GroupLayout jFrame2Layout = new org.jdesktop.layout.GroupLayout(jFrame2.getContentPane());
        jFrame2.getContentPane().setLayout(jFrame2Layout);
        jFrame2Layout.setHorizontalGroup(
            jFrame2Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(jFrame2Layout.createSequentialGroup()
                .add(jFrame2Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(jFrame2Layout.createSequentialGroup()
                        .addContainerGap()
                        .add(jPanel14, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                    .add(jFrame2Layout.createSequentialGroup()
                        .add(69, 69, 69)
                        .add(jButton12)
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                        .add(jButton13)))
                .addContainerGap(org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jFrame2Layout.linkSize(new java.awt.Component[] {jButton12, jButton13}, org.jdesktop.layout.GroupLayout.HORIZONTAL);

        jFrame2Layout.setVerticalGroup(
            jFrame2Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(jFrame2Layout.createSequentialGroup()
                .addContainerGap()
                .add(jPanel14, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED, 28, Short.MAX_VALUE)
                .add(jFrame2Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(jButton12)
                    .add(jButton13))
                .add(21, 21, 21))
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Telem\u00e9domai Client");
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setIconImage(new javax.swing.ImageIcon(getClass().getResource("/imagenes/medicina_small.png")).getImage());
        setResizable(false);
        jStatusBar.setText("Bienvenido al sistema de Telemedicina, por favor rellene sus datos personales y los del especialista.");

        org.jdesktop.layout.GroupLayout jPanel1Layout = new org.jdesktop.layout.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(jPanel1Layout.createSequentialGroup()
                .add(18, 18, 18)
                .add(jStatusBar)
                .addContainerGap(352, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(jPanel1Layout.createSequentialGroup()
                .add(jStatusBar)
                .addContainerGap(org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel2.setMaximumSize(new java.awt.Dimension(1280, 600));
        jPanel9.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Datos del paciente", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 11), new java.awt.Color(0, 0, 0)));
        jLabel3.setText("Nombre:");

        jLabel4.setText("Apellidos:");

        jLabel5.setText("Edad:");

        jLabel6.setText("Sexo (M/F):");

        jLabel7.setText("S\u00edntomas:");

        jTextArea1.setColumns(20);
        jTextArea1.setRows(4);
        jScrollPane1.setViewportView(jTextArea1);

        buttonGroup1.add(jRadioButton1);
        jRadioButton1.setText("Masculino");
        jRadioButton1.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 0, 0, 0));
        jRadioButton1.setMargin(new java.awt.Insets(0, 0, 0, 0));

        buttonGroup1.add(jRadioButton2);
        jRadioButton2.setText("Femenino");
        jRadioButton2.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 0, 0, 0));
        jRadioButton2.setMargin(new java.awt.Insets(0, 0, 0, 0));

        jLabel16.setText("Credencial:");

        jTextField6.setColumns(3);

        org.jdesktop.layout.GroupLayout jPanel9Layout = new org.jdesktop.layout.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(jPanel9Layout.createSequentialGroup()
                .addContainerGap()
                .add(jPanel9Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(jPanel9Layout.createSequentialGroup()
                        .add(10, 10, 10)
                        .add(jScrollPane1, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 356, Short.MAX_VALUE))
                    .add(jLabel7)
                    .add(jPanel9Layout.createSequentialGroup()
                        .add(jPanel9Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                            .add(jLabel16)
                            .add(jLabel4)
                            .add(jLabel3)
                            .add(jLabel5))
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                        .add(jPanel9Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                            .add(jTextField2, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 308, Short.MAX_VALUE)
                            .add(jTextField3, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 308, Short.MAX_VALUE)
                            .add(jPanel9Layout.createSequentialGroup()
                                .add(jTextField4, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 36, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED, 139, Short.MAX_VALUE)
                                .add(jLabel6)
                                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                                .add(jPanel9Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                                    .add(jRadioButton2)
                                    .add(jRadioButton1))
                                .add(9, 9, 9))
                            .add(jTextField6, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 118, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap())
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(jPanel9Layout.createSequentialGroup()
                .addContainerGap()
                .add(jPanel9Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(jLabel3)
                    .add(jTextField2, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                .add(20, 20, 20)
                .add(jPanel9Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(jLabel4)
                    .add(jTextField3, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                .add(20, 20, 20)
                .add(jPanel9Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(jLabel5)
                    .add(jLabel6)
                    .add(jRadioButton1)
                    .add(jTextField4, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                .add(jPanel9Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(jPanel9Layout.createSequentialGroup()
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                        .add(jRadioButton2))
                    .add(jPanel9Layout.createSequentialGroup()
                        .add(21, 21, 21)
                        .add(jPanel9Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                            .add(jLabel16)
                            .add(jTextField6, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED, 25, Short.MAX_VALUE)
                .add(jLabel7)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(jScrollPane1, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 128, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jLabel11.setText("Elija el especialista a consultar:");

        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/llamar.png")));
        jButton2.setMnemonic('L');
        jButton2.setText("Llamar");
        jButton2.setToolTipText("Pulse para llamar al especialista");
        jButton2.setFocusTraversalPolicyProvider(true);
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        org.jdesktop.layout.GroupLayout jPanel11Layout = new org.jdesktop.layout.GroupLayout(jPanel11);
        jPanel11.setLayout(jPanel11Layout);
        jPanel11Layout.setHorizontalGroup(
            jPanel11Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(jPanel11Layout.createSequentialGroup()
                .add(jPanel11Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(jPanel11Layout.createSequentialGroup()
                        .addContainerGap()
                        .add(jPanel11Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                            .add(jLabel11)
                            .add(jPanel11Layout.createSequentialGroup()
                                .add(10, 10, 10)
                                .add(jComboBox1, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 279, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))))
                    .add(jPanel11Layout.createSequentialGroup()
                        .add(138, 138, 138)
                        .add(jButton2)))
                .addContainerGap(103, Short.MAX_VALUE))
        );
        jPanel11Layout.setVerticalGroup(
            jPanel11Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(jPanel11Layout.createSequentialGroup()
                .addContainerGap()
                .add(jLabel11)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(jComboBox1, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED, 89, Short.MAX_VALUE)
                .add(jButton2)
                .add(47, 47, 47))
        );

        org.jdesktop.layout.GroupLayout jPanel4Layout = new org.jdesktop.layout.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(org.jdesktop.layout.GroupLayout.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .add(jPanel4Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.TRAILING)
                    .add(org.jdesktop.layout.GroupLayout.LEADING, jPanel9, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .add(org.jdesktop.layout.GroupLayout.LEADING, jPanel11, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(org.jdesktop.layout.GroupLayout.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .add(jPanel9, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(jPanel11, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jTabbedPane1.addTab("Inicio", jPanel4);

        jButton5.setMnemonic('G');
        jButton5.setText("Grabar");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        jButton6.setMnemonic('P');
        jButton6.setText("Parar");
        jButton6.setEnabled(false);
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });

        jButton7.setMnemonic('R');
        jButton7.setText("Reproducir");
        jButton7.setEnabled(false);
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });

        jTextArea5.setColumns(20);
        jTextArea5.setRows(3);
        jScrollPane5.setViewportView(jTextArea5);

        jButton8.setMnemonic('E');
        jButton8.setText("Enviar");
        jButton8.setEnabled(false);
        jButton8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton8ActionPerformed(evt);
            }
        });

        jPanel13.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jLabel14.setText("Seleccione tipo de auscultaci\u00f3n:");

        buttonGroup2.add(jRadioButton3);
        jRadioButton3.setText("Card\u00edaca");
        jRadioButton3.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 0, 0, 0));
        jRadioButton3.setMargin(new java.awt.Insets(0, 0, 0, 0));
        jRadioButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton3ActionPerformed(evt);
            }
        });

        buttonGroup2.add(jRadioButton4);
        jRadioButton4.setText("Pulmonar");
        jRadioButton4.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 0, 0, 0));
        jRadioButton4.setMargin(new java.awt.Insets(0, 0, 0, 0));
        jRadioButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton4ActionPerformed(evt);
            }
        });

        buttonGroup2.add(jRadioButton5);
        jRadioButton5.setText("Abdominal");
        jRadioButton5.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 0, 0, 0));
        jRadioButton5.setMargin(new java.awt.Insets(0, 0, 0, 0));
        jRadioButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton5ActionPerformed(evt);
            }
        });

        jLabel15.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel15.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/vitrubio.jpg")));
        jLabel15.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel15MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabel15MouseEntered(evt);
            }
        });

        buttonGroup2.add(jRadioButton6);
        jRadioButton6.setSelected(true);
        jRadioButton6.setText("Otro");
        jRadioButton6.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 0, 0, 0));
        jRadioButton6.setMargin(new java.awt.Insets(0, 0, 0, 0));
        jRadioButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton6ActionPerformed(evt);
            }
        });

        org.jdesktop.layout.GroupLayout jPanel13Layout = new org.jdesktop.layout.GroupLayout(jPanel13);
        jPanel13.setLayout(jPanel13Layout);
        jPanel13Layout.setHorizontalGroup(
            jPanel13Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(jPanel13Layout.createSequentialGroup()
                .addContainerGap()
                .add(jPanel13Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(jPanel13Layout.createSequentialGroup()
                        .add(jLabel15, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 378, Short.MAX_VALUE)
                        .addContainerGap())
                    .add(jPanel13Layout.createSequentialGroup()
                        .add(10, 10, 10)
                        .add(jRadioButton3, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 93, Short.MAX_VALUE)
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                        .add(jRadioButton4, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 93, Short.MAX_VALUE)
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                        .add(jRadioButton5, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 99, Short.MAX_VALUE)
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                        .add(jRadioButton6)
                        .add(36, 36, 36))
                    .add(jPanel13Layout.createSequentialGroup()
                        .add(jLabel14)
                        .addContainerGap(236, Short.MAX_VALUE))))
        );
        jPanel13Layout.setVerticalGroup(
            jPanel13Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(jPanel13Layout.createSequentialGroup()
                .addContainerGap()
                .add(jLabel14)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(jPanel13Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(jRadioButton3)
                    .add(jRadioButton4)
                    .add(jRadioButton5)
                    .add(jRadioButton6))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(jLabel15, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 323, Short.MAX_VALUE)
                .addContainerGap())
        );

        jLabel13.setText("Comentarios:");

        jLabel19.setText("Tipo:");

        jTextField9.setEditable(false);

        org.jdesktop.layout.GroupLayout jPanel5Layout = new org.jdesktop.layout.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(jPanel5Layout.createSequentialGroup()
                .add(jPanel5Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(jPanel5Layout.createSequentialGroup()
                        .addContainerGap()
                        .add(jPanel13, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .add(jPanel5Layout.createSequentialGroup()
                        .add(34, 34, 34)
                        .add(jPanel5Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING, false)
                            .add(jLabel13)
                            .add(jScrollPane5, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 294, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                            .add(jPanel5Layout.createSequentialGroup()
                                .add(10, 10, 10)
                                .add(jButton5)
                                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                                .add(jPanel5Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                                    .add(jButton8)
                                    .add(jPanel5Layout.createSequentialGroup()
                                        .add(jButton6)
                                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                                        .add(jButton7, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 85, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))))
                            .add(jPanel5Layout.createSequentialGroup()
                                .add(jLabel19)
                                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                                .add(jTextField9)))))
                .addContainerGap())
        );

        jPanel5Layout.linkSize(new java.awt.Component[] {jButton5, jButton6, jButton7, jButton8}, org.jdesktop.layout.GroupLayout.HORIZONTAL);

        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .add(jPanel13, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED, 40, Short.MAX_VALUE)
                .add(jPanel5Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(jLabel19)
                    .add(jTextField9, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(jLabel13)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(jScrollPane5, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 59, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .add(14, 14, 14)
                .add(jPanel5Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(jButton5)
                    .add(jButton6)
                    .add(jButton7))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(jButton8)
                .addContainerGap())
        );
        jTabbedPane1.addTab("Estetoscopia", jPanel5);

        jLabel26.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/anim/presion1.gif")));
        jLabel26.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel26MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabel26MouseEntered(evt);
            }
        });

        jPanel18.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jLabel27.setText("Presi\u00f3n arterial sist\u00f3lica:");

        jLabel28.setText("Presi\u00f3n arterial diast\u00f3lica:");

        jLabel29.setText("mmHg");

        jLabel30.setText("mmHg");

        jButton14.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/send.png")));
        jButton14.setText("Enviar");
        jButton14.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton14ActionPerformed(evt);
            }
        });

        jScrollPane6.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        jTextArea6.setColumns(20);
        jTextArea6.setEditable(false);
        jTextArea6.setRows(5);
        jTextArea6.setText("Primer paso:\nLocalizar pulso card\u00edaco utilizando dedos\n\u00edndice y coraz\u00f3n.");
        jTextArea6.setOpaque(false);
        jScrollPane6.setViewportView(jTextArea6);

        org.jdesktop.layout.GroupLayout jPanel18Layout = new org.jdesktop.layout.GroupLayout(jPanel18);
        jPanel18.setLayout(jPanel18Layout);
        jPanel18Layout.setHorizontalGroup(
            jPanel18Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(jPanel18Layout.createSequentialGroup()
                .add(jPanel18Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(jPanel18Layout.createSequentialGroup()
                        .add(137, 137, 137)
                        .add(jButton14))
                    .add(jPanel18Layout.createSequentialGroup()
                        .addContainerGap()
                        .add(jPanel18Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                            .add(jLabel28)
                            .add(jLabel27))
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                        .add(jPanel18Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING, false)
                            .add(jTextField12)
                            .add(jTextField11, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 67, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                        .add(jPanel18Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                            .add(jLabel29)
                            .add(jLabel30)))
                    .add(jPanel18Layout.createSequentialGroup()
                        .addContainerGap()
                        .add(jScrollPane6, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 378, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel18Layout.setVerticalGroup(
            jPanel18Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(org.jdesktop.layout.GroupLayout.TRAILING, jPanel18Layout.createSequentialGroup()
                .addContainerGap()
                .add(jScrollPane6, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .add(jPanel18Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(jLabel27)
                    .add(jTextField12, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(jLabel29))
                .add(16, 16, 16)
                .add(jPanel18Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(jLabel28)
                    .add(jTextField11, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(jLabel30))
                .add(19, 19, 19)
                .add(jButton14, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 37, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        org.jdesktop.layout.GroupLayout jPanel7Layout = new org.jdesktop.layout.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(jPanel7Layout.createSequentialGroup()
                .add(jPanel7Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(jPanel7Layout.createSequentialGroup()
                        .add(10, 10, 10)
                        .add(jPanel18, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .add(jPanel7Layout.createSequentialGroup()
                        .add(30, 30, 30)
                        .add(jLabel26)))
                .addContainerGap())
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(jPanel7Layout.createSequentialGroup()
                .add(jLabel26, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 354, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(jPanel18, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(28, Short.MAX_VALUE))
        );
        jTabbedPane1.addTab("Presi\u00f3n Arterial", null, jPanel7, "Presi\u00f3n o tensi\u00f3n arterial");

        jPanel10.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/folder.png")));
        jButton3.setMnemonic('S');
        jButton3.setText("Seleccionar...");
        jButton3.setToolTipText("Seleccionar una imagen almacenada...");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButton4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/send.png")));
        jButton4.setMnemonic('E');
        jButton4.setText("Enviar");
        jButton4.setEnabled(false);
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jTextField1.setEditable(false);

        jLabel9.setText("Imagen:");

        jLabel10.setText("Descripci\u00f3n:");

        jTextArea4.setColumns(20);
        jTextArea4.setRows(3);
        jScrollPane4.setViewportView(jTextArea4);

        jButton11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/webcam.gif")));
        jButton11.setText("Capturar");
        jButton11.setToolTipText("Capturar im\u00e1gen desde c\u00e1mara...");
        jButton11.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton11ActionPerformed(evt);
            }
        });

        org.jdesktop.layout.GroupLayout jPanel10Layout = new org.jdesktop.layout.GroupLayout(jPanel10);
        jPanel10.setLayout(jPanel10Layout);
        jPanel10Layout.setHorizontalGroup(
            jPanel10Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(jPanel10Layout.createSequentialGroup()
                .add(10, 10, 10)
                .add(jPanel10Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(jPanel10Layout.createSequentialGroup()
                        .add(jScrollPane4, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 378, Short.MAX_VALUE)
                        .addContainerGap())
                    .add(jPanel10Layout.createSequentialGroup()
                        .add(jLabel10)
                        .addContainerGap())
                    .add(jPanel10Layout.createSequentialGroup()
                        .add(jLabel9)
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                        .add(jPanel10Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                            .add(jPanel10Layout.createSequentialGroup()
                                .add(10, 10, 10)
                                .add(jButton3)
                                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                                .add(jButton11))
                            .add(jTextField1, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 270, Short.MAX_VALUE))
                        .add(74, 74, 74))))
            .add(jPanel10Layout.createSequentialGroup()
                .add(140, 140, 140)
                .add(jButton4)
                .addContainerGap(159, Short.MAX_VALUE))
        );
        jPanel10Layout.setVerticalGroup(
            jPanel10Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(jPanel10Layout.createSequentialGroup()
                .add(23, 23, 23)
                .add(jPanel10Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(jLabel9)
                    .add(jTextField1, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(jPanel10Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(jButton3)
                    .add(jButton11, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 47, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(jLabel10)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(jScrollPane4, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 70, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(jButton4, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 41, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .add(40, 40, 40))
        );

        jPanel10Layout.linkSize(new java.awt.Component[] {jButton11, jButton3}, org.jdesktop.layout.GroupLayout.VERTICAL);

        org.jdesktop.layout.GroupLayout jPanel6Layout = new org.jdesktop.layout.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .add(jPanel6Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(jPanel10, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .add(jLabel12, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 402, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(org.jdesktop.layout.GroupLayout.TRAILING, jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .add(jLabel12, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 319, Short.MAX_VALUE)
                .add(31, 31, 31)
                .add(jPanel10, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 250, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jTabbedPane1.addTab("Im\u00e1genes", jPanel6);

        jPanel19.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Otras mediciones", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 11), new java.awt.Color(0, 0, 0)));
        jLabel20.setText("Seleccione el tipo o escr\u00edbalo en el campo siguiente:");

        jComboBox2.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "<Tipo de Medici\u00f3n>", "Peso", "Nivel de glucosa", "Colesterol", "Triglic\u00e9ridos", "\u00c1cido l\u00e1ctico", "Hemoglobina", "Leucocitos", "Plaquetas" }));
        jComboBox2.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jComboBox2ItemStateChanged(evt);
            }
        });

        jLabel21.setText("Indique los valores obtenidos:");

        jTextArea7.setColumns(20);
        jTextArea7.setRows(5);
        jScrollPane7.setViewportView(jTextArea7);

        jButton15.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/send.png")));
        jButton15.setMnemonic('E');
        jButton15.setText("Enviar");
        jButton15.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton15ActionPerformed(evt);
            }
        });

        jLabel24.setText("Tipo de medici\u00f3n:");

        org.jdesktop.layout.GroupLayout jPanel19Layout = new org.jdesktop.layout.GroupLayout(jPanel19);
        jPanel19.setLayout(jPanel19Layout);
        jPanel19Layout.setHorizontalGroup(
            jPanel19Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(jPanel19Layout.createSequentialGroup()
                .add(jPanel19Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(jPanel19Layout.createSequentialGroup()
                        .add(135, 135, 135)
                        .add(jButton15))
                    .add(org.jdesktop.layout.GroupLayout.TRAILING, jPanel19Layout.createSequentialGroup()
                        .add(28, 28, 28)
                        .add(jScrollPane7, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 348, Short.MAX_VALUE))
                    .add(jPanel19Layout.createSequentialGroup()
                        .add(jPanel19Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.TRAILING, false)
                            .add(org.jdesktop.layout.GroupLayout.LEADING, jPanel19Layout.createSequentialGroup()
                                .add(28, 28, 28)
                                .add(jTextField5))
                            .add(org.jdesktop.layout.GroupLayout.LEADING, jPanel19Layout.createSequentialGroup()
                                .add(18, 18, 18)
                                .add(jPanel19Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                                    .add(jLabel20)
                                    .add(jPanel19Layout.createSequentialGroup()
                                        .add(10, 10, 10)
                                        .add(jComboBox2, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 273, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                                    .add(jLabel24)
                                    .add(jLabel21))))
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED, 75, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel19Layout.setVerticalGroup(
            jPanel19Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(jPanel19Layout.createSequentialGroup()
                .add(28, 28, 28)
                .add(jLabel20)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(jComboBox2, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .add(23, 23, 23)
                .add(jLabel24)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(jTextField5, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .add(18, 18, 18)
                .add(jLabel21)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(jScrollPane7, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .add(89, 89, 89)
                .add(jButton15, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 37, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(182, Short.MAX_VALUE))
        );

        org.jdesktop.layout.GroupLayout jPanel15Layout = new org.jdesktop.layout.GroupLayout(jPanel15);
        jPanel15.setLayout(jPanel15Layout);
        jPanel15Layout.setHorizontalGroup(
            jPanel15Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(jPanel15Layout.createSequentialGroup()
                .addContainerGap()
                .add(jPanel19, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel15Layout.setVerticalGroup(
            jPanel15Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(jPanel15Layout.createSequentialGroup()
                .addContainerGap()
                .add(jPanel19, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jTabbedPane1.addTab("Otros", null, jPanel15, "Otras mediciones");

        jLabel1.setText("Diagn\u00f3stico para el paciente:");

        jScrollPane2.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        jTextArea2.setColumns(20);
        jTextArea2.setEditable(false);
        jTextArea2.setRows(5);
        jTextArea2.setOpaque(false);
        jTextArea2.setVerifyInputWhenFocusTarget(false);
        jScrollPane2.setViewportView(jTextArea2);

        jLabel2.setText("Recomendaciones:");

        jScrollPane3.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        jTextArea3.setColumns(20);
        jTextArea3.setEditable(false);
        jTextArea3.setRows(5);
        jTextArea3.setOpaque(false);
        jScrollPane3.setViewportView(jTextArea3);

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/pdf.png")));
        jButton1.setMnemonic('G');
        jButton1.setText("Guardar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel17.setText("Doctor:");

        jTextField7.setEditable(false);

        jLabel18.setText("N\u00ba Colegiado:");

        jTextField8.setEditable(false);

        org.jdesktop.layout.GroupLayout jPanel8Layout = new org.jdesktop.layout.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(jPanel8Layout.createSequentialGroup()
                .add(jPanel8Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(jPanel8Layout.createSequentialGroup()
                        .addContainerGap()
                        .add(jLabel1))
                    .add(org.jdesktop.layout.GroupLayout.TRAILING, jPanel8Layout.createSequentialGroup()
                        .add(20, 20, 20)
                        .add(jScrollPane2, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 392, Short.MAX_VALUE))
                    .add(jPanel8Layout.createSequentialGroup()
                        .addContainerGap()
                        .add(jLabel2))
                    .add(org.jdesktop.layout.GroupLayout.TRAILING, jPanel8Layout.createSequentialGroup()
                        .add(20, 20, 20)
                        .add(jScrollPane3, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 392, Short.MAX_VALUE))
                    .add(jPanel8Layout.createSequentialGroup()
                        .addContainerGap()
                        .add(jPanel8Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                            .add(jPanel8Layout.createSequentialGroup()
                                .add(10, 10, 10)
                                .add(jTextField7, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 392, Short.MAX_VALUE))
                            .add(jLabel17)))
                    .add(jPanel8Layout.createSequentialGroup()
                        .addContainerGap()
                        .add(jPanel8Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                            .add(jPanel8Layout.createSequentialGroup()
                                .add(10, 10, 10)
                                .add(jTextField8, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 119, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                            .add(jLabel18)))
                    .add(jPanel8Layout.createSequentialGroup()
                        .add(148, 148, 148)
                        .add(jButton1)))
                .addContainerGap())
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(jPanel8Layout.createSequentialGroup()
                .add(43, 43, 43)
                .add(jLabel1)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(jScrollPane2, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 153, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .add(24, 24, 24)
                .add(jLabel2)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(jScrollPane3, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 61, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .add(21, 21, 21)
                .add(jLabel17)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(jTextField7, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .add(14, 14, 14)
                .add(jLabel18)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(jTextField8, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .add(18, 18, 18)
                .add(jButton1)
                .addContainerGap(29, Short.MAX_VALUE))
        );

        jPanel8Layout.linkSize(new java.awt.Component[] {jScrollPane2, jScrollPane3}, org.jdesktop.layout.GroupLayout.VERTICAL);

        jTabbedPane1.addTab("Diagn\u00f3stico", jPanel8);

        org.jdesktop.layout.GroupLayout jPanel2Layout = new org.jdesktop.layout.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .add(jTabbedPane1, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 427, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .add(jTabbedPane1, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 650, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanel3.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel3.setMaximumSize(new java.awt.Dimension(1280, 600));
        jPanel12.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        org.jdesktop.layout.GroupLayout jPanel12Layout = new org.jdesktop.layout.GroupLayout(jPanel12);
        jPanel12.setLayout(jPanel12Layout);
        jPanel12Layout.setHorizontalGroup(
            jPanel12Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(0, 361, Short.MAX_VALUE)
        );
        jPanel12Layout.setVerticalGroup(
            jPanel12Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(0, 290, Short.MAX_VALUE)
        );

        jButton9.setMnemonic('T');
        jButton9.setText("Transmitir");
        jButton9.setEnabled(false);
        jButton9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton9ActionPerformed(evt);
            }
        });

        jButton10.setMnemonic('D');
        jButton10.setText("Detener");
        jButton10.setEnabled(false);
        jButton10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton10ActionPerformed(evt);
            }
        });

        buttonGroup3.add(jRadioButton7);
        jRadioButton7.setSelected(true);
        jRadioButton7.setText("Videoconferencia");
        jRadioButton7.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 0, 0, 0));
        jRadioButton7.setEnabled(false);
        jRadioButton7.setMargin(new java.awt.Insets(0, 0, 0, 0));

        buttonGroup3.add(jRadioButton8);
        jRadioButton8.setText("Audio");
        jRadioButton8.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 0, 0, 0));
        jRadioButton8.setEnabled(false);
        jRadioButton8.setMargin(new java.awt.Insets(0, 0, 0, 0));

        jLabel8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/medicina.png")));

        org.jdesktop.layout.GroupLayout jPanel17Layout = new org.jdesktop.layout.GroupLayout(jPanel17);
        jPanel17.setLayout(jPanel17Layout);
        jPanel17Layout.setHorizontalGroup(
            jPanel17Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(org.jdesktop.layout.GroupLayout.TRAILING, jPanel17Layout.createSequentialGroup()
                .addContainerGap(26, Short.MAX_VALUE)
                .add(jLabel8)
                .add(42, 42, 42))
        );
        jPanel17Layout.setVerticalGroup(
            jPanel17Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(jPanel17Layout.createSequentialGroup()
                .addContainerGap()
                .add(jLabel8, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 267, Short.MAX_VALUE)
                .addContainerGap())
        );

        jButton16.setText("Aceptar");
        jButton16.setEnabled(false);
        jButton16.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton16ActionPerformed(evt);
            }
        });

        org.jdesktop.layout.GroupLayout jPanel3Layout = new org.jdesktop.layout.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(jPanel3Layout.createSequentialGroup()
                .add(27, 27, 27)
                .add(jPanel17, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
            .add(org.jdesktop.layout.GroupLayout.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(67, Short.MAX_VALUE)
                .add(jPanel3Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(jPanel3Layout.createSequentialGroup()
                        .add(jButton16)
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                        .add(jButton9))
                    .add(jRadioButton7))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(jPanel3Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(jRadioButton8)
                    .add(jButton10))
                .add(69, 69, 69))
            .add(org.jdesktop.layout.GroupLayout.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .add(jPanel12, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanel3Layout.linkSize(new java.awt.Component[] {jButton10, jButton16, jButton9}, org.jdesktop.layout.GroupLayout.HORIZONTAL);

        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .add(jPanel12, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .add(17, 17, 17)
                .add(jPanel3Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(jRadioButton7)
                    .add(jRadioButton8))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(jPanel3Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(jButton9)
                    .add(jButton16)
                    .add(jButton10))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(jPanel17, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        jMenu1.setMnemonic('M');
        jMenu1.setText("Menu");
        jMenuItem4.setMnemonic('N');
        jMenuItem4.setText("Nueva sesi\u00f3n...");
        jMenuItem4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem4ActionPerformed(evt);
            }
        });

        jMenu1.add(jMenuItem4);

        jMenuItem3.setMnemonic('E');
        jMenuItem3.setText("Exit");
        jMenuItem3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem3ActionPerformed(evt);
            }
        });

        jMenu1.add(jMenuItem3);

        jMenuBar2.add(jMenu1);

        jMenu2.setMnemonic('A');
        jMenu2.setText("Ayuda");
        jMenuItem1.setMnemonic('M');
        jMenuItem1.setText("Manual de usuario");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });

        jMenu2.add(jMenuItem1);

        jMenuItem2.setMnemonic('A');
        jMenuItem2.setText("Acerca de...");
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem2ActionPerformed(evt);
            }
        });

        jMenu2.add(jMenuItem2);

        jMenuBar2.add(jMenu2);

        setJMenuBar(jMenuBar2);

        org.jdesktop.layout.GroupLayout layout = new org.jdesktop.layout.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(layout.createSequentialGroup()
                .addContainerGap()
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(org.jdesktop.layout.GroupLayout.TRAILING, layout.createSequentialGroup()
                        .add(jPanel2, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                        .add(jPanel3, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                    .add(jPanel1, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(layout.createSequentialGroup()
                .addContainerGap()
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(jPanel3, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .add(jPanel2, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(jPanel1, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
        );
        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton16ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton16ActionPerformed
        String [] args={"225.0.0.1/10004","225.0.0.1/10006"};
        avr = new AVReceiver(args);
        String tipo="Videoconferencia";
	if (!avr.initialize()) {
	    System.err.println("Error al iniciar las sesiones de "+tipo);
	    changeStatusBar("Error al iniciar las sesiones de "+tipo);
            return;
	}
        /*jPanel12.removeAll();  //Eliminamos cualquier contenido anterior en el panel (otra videoconferencia,...)
        java.awt.BorderLayout layout=new java.awt.BorderLayout();
        jPanel12.setLayout(layout);*/
        jButton16.setEnabled(false);
        changeStatusBar(tipo+" iniciada...");
        jPanel12.add(avr.getPlayerComponent(),java.awt.BorderLayout.CENTER); 
        
    }//GEN-LAST:event_jButton16ActionPerformed

    private void jButton15ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton15ActionPerformed
        String tipo=jTextField5.getText();
        String medida=jTextArea7.getText();
        if (tipo.equalsIgnoreCase("")||medida.equalsIgnoreCase(""))
        {
            changeStatusBar("Por favor rellene los campos del tipo de medición y las mediciones obtenidas.");
            return;
        }
        if (protocolo.enviaMedida(tipo,medida))
            changeStatusBar("Medidas de tipo \""+tipo+"\" enviadas correctamente.");
    }//GEN-LAST:event_jButton15ActionPerformed

    private void jComboBox2ItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jComboBox2ItemStateChanged
        if(jComboBox2.getSelectedIndex()!=0){
            jTextField5.setText(jComboBox2.getSelectedItem().toString());
            jTextArea7.setText(null);}
        else
            jTextField5.setText(null);
    }//GEN-LAST:event_jComboBox2ItemStateChanged

    private void jLabel26MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel26MouseClicked
        gestionaPresionArterial();
    }//GEN-LAST:event_jLabel26MouseClicked

    private void jLabel26MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel26MouseEntered
        changeStatusBar("Haga click en la imagen para pasar al siguiente paso de la medida de presión arterial.");
    }//GEN-LAST:event_jLabel26MouseEntered

    private void jButton14ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton14ActionPerformed
        String sist=jTextField12.getText();
        String dias=jTextField11.getText();
        
        if (sist.equalsIgnoreCase("")||dias.equalsIgnoreCase(""))
        {
            changeStatusBar("Por favor agregue las medidas de presión arterial. Si no sabe cómo efectuarlas haga click en la imagen.");
            return;
        }
        if (protocolo.enviaPresion(sist,dias))
            changeStatusBar("Medidas de presión arterial enviadas correctamente.");
    }//GEN-LAST:event_jButton14ActionPerformed

    private void jFrame2WindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_jFrame2WindowClosing
        if (capturador!=null)
            capturador.stop();
        jFrame2.setVisible(false);
        capturandoVideo=false;
    }//GEN-LAST:event_jFrame2WindowClosing

    private void jButton12ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton12ActionPerformed
        String img=capturador.capturaImagen();
        jTextField1.setText(img);
        //Ahora vamos a mostrar una versión reducida de la imagen a enviar
        Image imagen = java.awt.Toolkit.getDefaultToolkit().getImage (img);
        int ancho=jPanel10.getWidth();
        int alto=ancho*3/4;
        jLabel12.setIcon(new javax.swing.ImageIcon(imagen.getScaledInstance(ancho,alto,Image.SCALE_FAST)));
        jButton4.setEnabled(true);
        
    }//GEN-LAST:event_jButton12ActionPerformed

    private void jButton13ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton13ActionPerformed
        if (capturador!=null)
            capturador.stop();
        jFrame2.setVisible(false);
        capturandoVideo=false;
    }//GEN-LAST:event_jButton13ActionPerformed

    private void jButton11ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton11ActionPerformed
        if (capturandoVideo)
        {
            changeStatusBar("El dispositivo de captura de video ya está ocupado.Desactívelo.");
            return;
        }
        capturandoVideo=true;
        capturador=new Captura("vfw://");
        Component video=capturador.getPlayer();
        jPanel14.setPreferredSize(video.getSize());
        jPanel14.add(capturador.getPlayer(),java.awt.BorderLayout.CENTER);
        jFrame2.setLocation(200,200);
        jFrame2.pack();
        jFrame2.setVisible(true);

        
        
    }//GEN-LAST:event_jButton11ActionPerformed

    private void jLabel22MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel22MouseClicked
        Lanzador launcher=new Lanzador();
        //Llama al programa por defecto del sistema para enviarme un correo
        launcher.abrir("mailto:cockemc@yahoo.es");
    }//GEN-LAST:event_jLabel22MouseClicked

    private void jMenuItem4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem4ActionPerformed
        resetConnection();
        cleanFields();
        changeStatusBar("Introduzca los datos de un nuevo paciente");
    }//GEN-LAST:event_jMenuItem4ActionPerformed

            
     /*
     * #############   Sección de manejadores de eventos ###################################
     *
     */
    
    
    private void jLabel15MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel15MouseClicked
        System.out.println("Ratón PULSÓ en "+evt.getPoint().toString());
        int X=evt.getX();
        int Y=evt.getY();
        int selected;
        int button=evt.getButton();
        
        if (jRadioButton3.isSelected())             //Seleccionada la opción de Auscultación cardíaca
            selected=1;
        else if (jRadioButton4.isSelected())        //Seleccionada la opción de Auscultación pulmonar
            selected=2;
        else if (jRadioButton5.isSelected())        //Seleccionada la opción de Auscultación abdominal
            selected=3;
        else
            selected=4;                             //Seleccionada la opción de otros
        
        //Llamamos al método de gestión de los clicks en pantalla
        gestionaAuscultacion(selected,X,Y,button);
    }//GEN-LAST:event_jLabel15MouseClicked

    private void jLabel15MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel15MouseEntered
        if(jRadioButton4.isSelected())
            changeStatusBar("Pulse con el botón derecho para cambiar de frente a espalda.");
        else if (!jRadioButton6.isSelected())
            changeStatusBar("Pulse en un punto de auscultación para seleccionarlo.");
    }//GEN-LAST:event_jLabel15MouseEntered

    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed
        jFrame1.setSize(300,225);
        jFrame1.setLocation(400,200);
        jFrame1.setVisible(true);
    }//GEN-LAST:event_jMenuItem2ActionPerformed

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        Lanzador launcher=new Lanzador();
        launcher.abrir("http://www.jorgemarti.com/projects/telemedomai");
    }//GEN-LAST:event_jMenuItem1ActionPerformed

   
    private void jRadioButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton6ActionPerformed
        jLabel15.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/vitrubio.jpg")));
        jTextArea5.setText(null);
        jTextField9.setText(null);
    }//GEN-LAST:event_jRadioButton6ActionPerformed

    private void jRadioButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton5ActionPerformed
        jLabel15.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/anim/abdominal.gif")));
        jTextArea5.setText(null);
        jTextField9.setText(null);
    }//GEN-LAST:event_jRadioButton5ActionPerformed

    private void jRadioButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton4ActionPerformed
        jLabel15.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/anim/pulmonar.gif")));
        pulmFrente=true;
        jTextArea5.setText(null);
        jTextField9.setText(null);
    }//GEN-LAST:event_jRadioButton4ActionPerformed

    private void jRadioButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton3ActionPerformed
        jLabel15.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/anim/cardiaca0.gif")));
        jTextArea5.setText(null);
        jTextField9.setText(null);
    }//GEN-LAST:event_jRadioButton3ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        if (pdfChooser == null) pdfChooser = new JFileChooser();
        pdfChooser.setDialogType(JFileChooser.SAVE_DIALOG);
        pdfChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
                
        //Añadimos un filtro de selección y desactivamos la opción de Todos Archivos
        pdfChooser.setAcceptAllFileFilterUsed(false);
        ExampleFileFilter filtro=new ExampleFileFilter();
        filtro.addExtension("pdf");
        filtro.setDescription("Archivos .PDF");
        pdfChooser.setFileFilter(filtro);
        
        int returnVal = pdfChooser.showDialog(this, "Guardar");
        if (returnVal == JFileChooser.APPROVE_OPTION) 
        {
            String file = pdfChooser.getSelectedFile().getAbsolutePath();
            if (!file.endsWith(".pdf")&&!file.endsWith(".PDF"))
                file=new String(file+".pdf");
            copiaFicheros("temp.pdf",file);
            
        }
        
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton10ActionPerformed
        avt.stop();
        protocolo.stopConferencia();
        System.out.println("Transmisión detenida...");
        changeStatusBar("Transmisión detenida...");
        if (capturandoVideo==true){
            jPanel17.remove(1);    //Eliminamos el video local
            jLabel8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/medicina.png")));}  //Reestablecemos la imagen
        capturandoVideo=false;
        jButton9.setEnabled(true);
        jButton10.setEnabled(false);
        
    }//GEN-LAST:event_jButton10ActionPerformed

    private void jButton9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton9ActionPerformed
        boolean result;
        if (jRadioButton8.isSelected())
            result=iniciaAudioConferencia();
        else
            result=iniciaVideoConferencia();
        if (result==false)
            return;
        jButton9.setEnabled(false);
        jButton10.setEnabled(true);


    }//GEN-LAST:event_jButton9ActionPerformed

    private void jButton8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton8ActionPerformed
        String description=jTextArea5.getText();
        String tipo=jTextField9.getText();
        String file="temp.wav";
        
        if (description.equalsIgnoreCase(""))
        {
           changeStatusBar("Por favor agregue una descripción al archivo de audio");
           return; 
        }
        else if (!tipo.equalsIgnoreCase(""))
            description=tipo+"\n"+description;
        
        if (protocolo.enviaAudio(file,description))
        {
            changeStatusBar("Archivo de SONIDO enviado correctamente.");
        }
        else
            changeStatusBar("ERROR al enviar el archivo de sonido.");
    }//GEN-LAST:event_jButton8ActionPerformed

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
        startPlaying();
    }//GEN-LAST:event_jButton7ActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        jButton6.setEnabled(false);
        jButton7.setEnabled(true);
        jButton8.setEnabled(true);
        stopRecording();
        jButton5.setEnabled(true);
    }//GEN-LAST:event_jButton6ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        jButton5.setEnabled(false);
        jButton6.setEnabled(true);
        if (!startRecording())
            changeStatusBar("Imposible realizar la grabación de sonido!");
    }//GEN-LAST:event_jButton5ActionPerformed

    
    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        String descripcion=jTextArea4.getText();
        String archivo=jTextField1.getText();
        if(archivo.equalsIgnoreCase(""))
            return;
        if (descripcion.equalsIgnoreCase(""))
        {
           changeStatusBar("Por favor agregue una descripción a la imagen");
           return; 
        }
        else if (protocolo.enviaImagen(archivo,descripcion))
        {
            changeStatusBar("Imagen enviada correctamente");
        }
        else
            changeStatusBar("ERROR al enviar la imagen");
            
    }//GEN-LAST:event_jButton4ActionPerformed
  
    
    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        if (imageChooser == null) imageChooser = new JFileChooser();
        imageChooser.setDialogType(JFileChooser.OPEN_DIALOG);
        imageChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
        
        
        //Añadimos un filtro de selección y desactivamos la opción de Todos Archivos
        imageChooser.setAcceptAllFileFilterUsed(false);
        ExampleFileFilter filtro=new ExampleFileFilter();
        filtro.addExtension("jpg");
        filtro.addExtension("gif");
        filtro.addExtension("png");
        filtro.setDescription("Archivos de imágenes");
        imageChooser.setFileFilter(filtro);
        
        int returnVal = imageChooser.showDialog(this, "Enviar");
        if (returnVal == JFileChooser.APPROVE_OPTION) 
        {
            String file = imageChooser.getSelectedFile().getAbsolutePath();
            jTextField1.setText(file);
            jButton4.setEnabled(true);
            jTextArea4.setText(null);
            
            //Ahora vamos a mostrar una versión reducida de la imagen a enviar
            Image imagen = java.awt.Toolkit.getDefaultToolkit().getImage (file);
            int ancho=jPanel10.getWidth();
            int alto=ancho*3/4;
            jLabel12.setIcon(new javax.swing.ImageIcon(imagen.getScaledInstance(ancho,alto,Image.SCALE_FAST)));
        }
        
        
    }//GEN-LAST:event_jButton3ActionPerformed
      
    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        
        String error=checkFields();
        if (error==null)
        {
            //Esta sería la verdadera comprobación de la IP según el especialista seleccionado
            int index=jComboBox1.getSelectedIndex();
            ipServer=ips[index];
            
            if (llamada())
            {
               for (int i=1;i<jTabbedPane1.getTabCount()-1;i++)    // Si la conexión ha sido exitosa
                    jTabbedPane1.setEnabledAt(i,true);             // el programa ya puede funcionar 100%
              
               jButton2.setEnabled(false);
               String sexo="M";                         // Por defecto seleccionamos sexo masculino (eleccion aleatoria)
               if (jRadioButton2.isSelected())
                   sexo="F"; 
               // Con la conexión al servidor mandamos los datos del paciente, y posteriormente aquí vendrá la conexion WEBCAM
               datosPaciente=new tiposDatos.Datos(jTextField2.getText(),jTextField3.getText(),jTextField4.getText(),sexo,jTextField6.getText(),jTextArea1.getText());
               protocolo.enviaDatos(datosPaciente);
               //Habilitamos el botón para iniciar videoconferencia WEBCAM
               jButton9.setEnabled(true);
               jRadioButton7.setEnabled(true);
               jRadioButton8.setEnabled(true);
            }
        }
        else
            changeStatusBar(error);
    }//GEN-LAST:event_jButton2ActionPerformed
        
    /**
     * Evento de selección del menu principal para salir
     *
     */    
    private void jMenuItem3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem3ActionPerformed
        System.out.println("Saliendo...");
        System.exit(0);
    }//GEN-LAST:event_jMenuItem3ActionPerformed

        
     /*
     * #############   Sección de métodos mios ###################################
     *
     */
    
    /**
     *  Método para comprobar que los datos son correctos
     *
     */
    
    private String checkFields()
    {
        if (jTextField2.getText().equalsIgnoreCase(""))
            return "Por favor, escriba su nombre en el campo correspondiente.";
        else if (jTextField3.getText().equalsIgnoreCase(""))
            return "Por favor, escriba sus apellidos en el campo correspondiente.";
        else if (jTextField4.getText().equalsIgnoreCase(""))
            return "Por favor, escriba su edad correctamente.";
        else try
        {
            Integer.parseInt(jTextField4.getText());
        }
        catch (Exception e)
        {
            return "Por favor escriba un número en la edad";
        }
        
        if (Integer.parseInt(jTextField4.getText())<0)
            return "Por favor, escriba su edad correctamente.";
        else if (jTextField6.getText().equalsIgnoreCase(""))
            return "Por favor, escriba su número de credencial correctamente";
        else if (!checkID(jTextField6.getText()))
            return "No introduzca ningún caracter prohibido en la credencial (\\,/,:,\",*,?,<,>,|)";
        else if (jTextArea1.getText().equalsIgnoreCase(""))
            return "Por favor, relate la sintomatología sufrida para una mejor atención.";
        else if (jComboBox1.getSelectedIndex()==0)
            return "Seleccione el especialista al que quiere consultar.";
        else{ 
            checkID("ie");
            return null;}
        
    }
    
    /**
     * Método auxiliar para comprobar que en el ID no hay ningún caracter prohibido
     *
     */
    
    private boolean checkID(String ID)
    {
        String [] forbidden={"\\","/",":","\"","*","?","<",">","|"};
        for (int i=0;i<forbidden.length;i++)
            if (ID.indexOf(forbidden[i])!=-1)        //Si encuentra una sola ocurrencia de los caracteres prohibidos devuelve falso
                return false;
        return true;
    }
    
    /**
     * Método que realiza la llamada al especialista seleccionado
     */
    
    private boolean llamada()
    {
        // Hacemos la llamada al servidor
        protocolo=new ProtocolClient(ipServer);
        //Pasamos como parámetro al protocolo el FRAME principal del programa, para que pueda actuar sobre él
        if (protocolo.startProtocol(this))
        {
            changeStatusBar("Llamada exitosa!");
            return true;
        }
        else 
        {
            changeStatusBar("Hubo un error en la conexión, el servidor no responde...");
            return false;
        }
    }
      
    private boolean iniciaVideoConferencia()
    {
        // Creamos objeto de transmisión de video y audio.
	avt = new AVTransmitter(new javax.media.MediaLocator("vfw://"),
                new javax.media.MediaLocator("dsound://"),ipServer, "10000", null);
        String result = avt.start();
        String result2=null;

	// result will be non-null if there was an error. The return
	// value is a String describing the possible error. Print it.
	if (result != null) {
	    System.err.println("Error de video: " + result);
            changeStatusBar("ERROR en la captura de video! Intente repararlo o inicie conferencia de voz");
	    return false;
	}
        if (result2 != null) {
	    System.err.println("Error de audio: " + result2);
            changeStatusBar("ERROR en la captura de audio!");
	    return false;
	}
	jLabel8.setIcon(null);
        jPanel17.add(avt.getPlayerComponent(),java.awt.BorderLayout.EAST,1);
        System.out.println("Empezamos la transmisión...");
        changeStatusBar("Transmitiendo video...");
        capturandoVideo=true;
        protocolo.enviaWebcam();
        return true;
    }
    
       private boolean iniciaAudioConferencia()
    {
        // Creamos objeto de transmisión de audio.
	avt = new AVTransmitter(new javax.media.MediaLocator("dsound://"),ipServer, "10002", null);
        // Start the transmission
	String result = avt.start();
        
	// result devuelve no nulo si hubo algún error
	// El valor devuelto es el tipo de error ocurrido.
	
        if (result != null) {
	    System.err.println("Error de audio: " + result);
            changeStatusBar("ERROR en la captura de audio!");
	    return false;
	}
	
	System.out.println("Empezamos la transmisión...");
        changeStatusBar("Transmitiendo audio...");
        protocolo.enviaAudioConferencia();
        return true;
    }
       
       
    /**
     * Método para iniciar la grabación de un archivo de sonido
     *
     */
    
    private boolean startRecording()
    {
        recorder=new AudioRecorder("temp.wav");
        recorder.start();
	changeStatusBar("Realizando grabación...");
	
        return true;
    }
    
    /**
     * Método para parar la grabación de un archivo de sonido
     *
     */
    
    private void stopRecording()
    {
        recorder.stopRecording();
        changeStatusBar("Grabación terminada.");
    }
   
    
    /**
     * Método para que suene lo que hemos grabado
     *
     */
    private void startPlaying()
    {
        AudioPlayer player=new AudioPlayer();
        changeStatusBar("Reproduciendo grabación...");
        player.play("temp.wav");
        changeStatusBar("Grabación finalizada");
        
    }
    
    /**
     * Método para cuando perdemos la conexión con el servidor, voluntaria o involuntariamente
     * Puede deberse a que iniciamos una nueva sesión, para conectar con el mismo servidor o otro
     * o bien puede ser porque el servidor cayó.
     */
    
    public void resetConnection()
    {
        //Detenemos el protocolo
        protocolo.stopProtocol(); 
        
        //Activamos el botón de llamada para que pueda realizarse una nueva conexión
        jButton2.setEnabled(true);
        //Desactivamos el resto de cosas, para llegar al estado inicial
        jRadioButton7.setEnabled(false);
        jRadioButton8.setEnabled(false);
        jButton9.setEnabled(false);
        for (int i=1;i<jTabbedPane1.getTabCount();i++)
            jTabbedPane1.setEnabledAt(i,false);
        jTabbedPane1.setSelectedIndex(0);
        jLabel15.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/vitrubio.jpg")));
        jLabel12.setIcon(null);
        jRadioButton6.setSelected(true);
        jTextField1.setText(null);
        jTextField5.setText(null);
        jTextField9.setText(null);
        jTextArea4.setText(null);
        jTextArea5.setText(null);
        jTextArea7.setText(null);
        jButton7.setEnabled(false);
        jButton8.setEnabled(false);   
        jComboBox2.setSelectedIndex(0);
        changeStatusBar("Conexión con el servidor perdida, intente realizar una nueva llamada...");
    }
    
    /**
     * Método que vacia todos los campos de texto, y reinicia el sistema al estado inicial
     */
    private void cleanFields()
    {
        jTextField1.setText(null);
        jTextField2.setText(null);
        jTextField3.setText(null);
        jTextField4.setText(null);
        jTextField6.setText(null);
        jTextField7.setText(null);
        jTextField8.setText(null);
        jTextField9.setText(null);
        jTextArea1.setText(null);
        jTextArea2.setText(null);
        jTextArea3.setText(null);
        jTextArea4.setText(null);
        jTextArea5.setText(null);
        jComboBox1.setSelectedIndex(0);        
    }

    
    /**
     *Funcion para cambiar el texto de la barra de estado
     *
     **/
    private void changeStatusBar(String status)
    {
        jStatusBar.setText(status);
    }
    
     /** 
     * Método para pedir al usuario la autorización para recibir la videoconferencia
     *
     */
    
    public void setWebcam()
    {
        changeStatusBar("Recibida petición de VIDEOCONFERENCIA desde el servidor. Pulse Aceptar para iniciarla.");
        jButton16.setEnabled(true);
    }
    
    public void stopConferencia()
    {
        jPanel12.removeAll();  //Eliminamos cualquier contenido anterior en el panel (otra videoconferencia,...)
        changeStatusBar("Conferencia detenida");
        /*jLabel21.setText(null);
        jButton7.setEnabled(false);*/
    }
    
    public void setDiagnostico(tiposDatos.Diagnostico diag)
    {
        String[] aux=diag.getDatos();
        jTextArea2.setText(aux[0]);
        jTextArea3.setText(aux[1]);
        jTextField7.setText("Doctor "+aux[2]+" "+aux[3]);
        jTextField8.setText(aux[4]);
               
        //Activamos la pestaña de diagnóstico, a partir de este momento el cliente puede leer el diagnostico
        jTabbedPane1.setEnabledAt(jTabbedPane1.getTabCount()-1,true);
                
        changeStatusBar("Recibido diagnóstico desde el doctor");
    }
   
    /**
     * Método TEDIOSO que gestiona cuando se clicka en la pantalla de estetoscopia, dependiendo del tipo de auscultación
     * Tenemos 4 tipos de auscultación: cardíaca, pulmonar, abdominal o otras. La pulmonar puede ser delantera y trasera.
     */
    
    private void gestionaAuscultacion(int tipo,int X,int Y,int boton)
    {
        switch (tipo)
        {
            case 1:
                if (java.lang.Math.abs(X-165)<10){
                    if (java.lang.Math.abs(Y-160)<10){
                        jLabel15.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/anim/cardiaca1.gif")));
                        jTextField9.setText("Auscultación cardíaca - Foco Aórtico");}}
                else if (java.lang.Math.abs(X-223)<12){
                    if (java.lang.Math.abs(Y-160)<10){
                        jLabel15.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/anim/cardiaca2.gif")));
                        jTextField9.setText("Auscultación cardíaca - Foco Pulmonar");}
                    else if (java.lang.Math.abs(Y-185)<10){
                        jLabel15.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/anim/cardiaca3.gif")));
                        jTextField9.setText("Auscultación cardíaca - Foco Pulmonar Secundario");}                   
                    else if (java.lang.Math.abs(Y-206)<10){
                        jLabel15.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/anim/cardiaca4.gif")));
                        jTextField9.setText("Auscultación cardíaca - Foco Tricúspide");}}
                if (java.lang.Math.abs(X-235)<10){
                    if (java.lang.Math.abs(Y-225)<10){
                        jLabel15.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/anim/cardiaca5.gif")));
                        jTextField9.setText("Auscultación cardíaca - Foco Apical");}}
                break;
            case 2:
                if (boton==3)
                {
                    if (pulmFrente==true){
                        jLabel15.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/anim/b_pulmonar.gif")));
                        pulmFrente=false;}
                    else{
                        jLabel15.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/anim/pulmonar.gif")));
                        pulmFrente=true;}                        
                }
                else if (pulmFrente==true){
                    if (X<190)
                        jTextField9.setText("Ausc. pulmonar - Mitad derecha frontal");
                    else
                        jTextField9.setText("Ausc. pulmonar - Mitad izquierda frontal");}
                else{
                    if(X<165)
                        jTextField9.setText("Ausc. pulmonar - Mitad izquierda espalda");
                    else
                        jTextField9.setText("Ausc. pulmonar - Mitad derecha espalda");}
                break;
                                        
           case 3:
                if (java.lang.Math.abs(X-128)<50){
                    if (java.lang.Math.abs(Y-189)<53){
                        jLabel15.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/anim/abdominal1.gif")));
                        jTextField9.setText("Ausc. abdominal - Cuadrante Superior Derecho");}
                    else if (java.lang.Math.abs(Y-293)<43){
                        jLabel15.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/anim/abdominal4.gif")));
                        jTextField9.setText("Ausc. abdominal - Cuadrante Inferior Derecho");}}                    
                else if (java.lang.Math.abs(X-243)<57){                    
                    if (java.lang.Math.abs(Y-189)<53){
                        jLabel15.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/anim/abdominal2.gif")));
                        jTextField9.setText("Ausc. abdominal - Cuadrante Superior Izquierdo");}
                    else if (java.lang.Math.abs(Y-293)<43){
                        jLabel15.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/anim/abdominal3.gif")));
                        jTextField9.setText("Ausc. abdominal - Cuadrante Inferior Izquierdo");}}
                break;
        }
                
    }
    
     /**
     * Método TEDIOSO que gestiona cuando se clicka en la pantalla de estetoscopia, dependiendo del tipo de auscultación
     * Tenemos 4 tipos de auscultación: cardíaca, pulmonar, abdominal o otras. La pulmonar puede ser delantera y trasera.
     */
    
    private void gestionaPresionArterial()
    {
        switch (pasoMedidaPres)
        {
            case 0:
                jLabel26.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/anim/presion2.gif")));
                jTextArea6.setText("Paso 2:\nColoque el manguito alrededor del brazo, entre\nel hombro y el codo.");
                pasoMedidaPres++;
                break;
                
           case 1:
                jLabel26.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/anim/presion3.gif")));
                jTextArea6.setText("Paso 3:\nBombee con rapidez para inflar el manguito\nhasta alcanzar una presión de 200-220 mmHg\nen el medidor.");
                pasoMedidaPres++;
                break;
                
           case 2:
                jLabel26.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/anim/presion4.gif")));
                jTextArea6.setText("Paso 4:\nColoque la campana del estetoscopio en la \nflexura del codo y desinfle" +
                        " el manguito \nlentamente, como 2-3 mmHg por segundo.\nCuando el latido sea audible anote " +
                        "la presión\nSISTÓLICA.");
                pasoMedidaPres++;
                break;
           
           case 3:
                jLabel26.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/anim/presion5.gif")));
                jTextArea6.setText("Paso 5:\nSiga desinflando, cuando el latido deje de\nescucharse anote" +
                        " la presión DIASTÓLICA.\nRepita de nuevo el procedimiento tras unos 3\nminutos " +
                        "para asegurarse de las lecturas.");
                pasoMedidaPres++;
                break;
           
           case 4:
                jLabel26.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/anim/presion1.gif")));
                jTextArea6.setText("Primer paso:\nLocalizar pulso cardíadaco utilizando dedos\níndice y corazón.");
                pasoMedidaPres=0;
                break;
                
        }
        
    }
    
    /**
     * Método auxiliar para leer desde un archivo de configuración la lista de centros/especialistas con sus IP correspodientes
     * El archivo puede ser leido localmente o desde un archivo almacenado en un servidor. Este archivo debe tener en cada
     * línea el nombre del doctor o centro hospitalario, separado de la IP por el carácter ":". 
     *      Ejemplo:   Doctor Antonio - Homeopatía:192.168.0.2
     */
    
    private boolean leeIPs(URL fichero)
    {   
        String temp,result="";
        int i=0;
        try
        {
            BufferedReader in=new BufferedReader(new InputStreamReader(fichero.openStream()));
            temp=in.readLine();
            while (temp!=null)
            {
                result=result+temp+"\n";
                i++;
                temp=in.readLine();
            }
        }
        catch (FileNotFoundException e)
        {
            System.out.println("Archivo no encontrado:\n"+e);
        }
        catch (IOException ioe)
        {
            System.out.println("Error de entrada/salida en lectura de texto.");
            return false;
        }     
        String [] lineas=result.split("\n");                // Primero dividimos todo el texto recibido por líneas
        espec=new String[i];
        ips=new String[i];
        String [] aux;
        for (int j=0;j<i;j++)
        {
            aux=lineas[j].split(":");                       //Después dividimos cada línea en dos partes, usando el carácter ":"
            espec[j]=aux[0];
            jComboBox1.addItem(espec[j]);
            ips[j]=aux[1];
        }   
        return true;
        
    }
    
    /**
    * Método auxiliar para copiar dos ficheros
    *
    */
    
    public void copiaFicheros (String ficheroOriginal, String ficheroCopia)
	{
		try
		{
                        // Se abre el fichero original para lectura
			FileInputStream fileInput = new FileInputStream(ficheroOriginal);
			BufferedInputStream bufferedInput = new BufferedInputStream(fileInput);
			
			// Se abre el fichero donde se hará la copia
			FileOutputStream fileOutput = new FileOutputStream (ficheroCopia);
			BufferedOutputStream bufferedOutput = new BufferedOutputStream(fileOutput);
			
			// Bucle para leer de un fichero y escribir en el otro.
			byte [] array = new byte[1000];
			int leidos = bufferedInput.read(array);
			while (leidos > 0)
			{
				bufferedOutput.write(array,0,leidos);
				leidos=bufferedInput.read(array);
			}

			// Cierre de los ficheros
			bufferedInput.close();
			bufferedOutput.close();
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
    }
    
    /*
     * #############   METODO MAIN ###################################
     *
     */
    
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ClientIF().setVisible(true);
            }
        });
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.ButtonGroup buttonGroup2;
    private javax.swing.ButtonGroup buttonGroup3;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton10;
    private javax.swing.JButton jButton11;
    private javax.swing.JButton jButton12;
    private javax.swing.JButton jButton13;
    private javax.swing.JButton jButton14;
    private javax.swing.JButton jButton15;
    private javax.swing.JButton jButton16;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JButton jButton8;
    private javax.swing.JButton jButton9;
    private javax.swing.JComboBox jComboBox1;
    private javax.swing.JComboBox jComboBox2;
    private javax.swing.JFrame jFrame1;
    private javax.swing.JFrame jFrame2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar2;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JMenuItem jMenuItem4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel13;
    private javax.swing.JPanel jPanel14;
    private javax.swing.JPanel jPanel15;
    private javax.swing.JPanel jPanel16;
    private javax.swing.JPanel jPanel17;
    private javax.swing.JPanel jPanel18;
    private javax.swing.JPanel jPanel19;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JRadioButton jRadioButton1;
    private javax.swing.JRadioButton jRadioButton2;
    private javax.swing.JRadioButton jRadioButton3;
    private javax.swing.JRadioButton jRadioButton4;
    private javax.swing.JRadioButton jRadioButton5;
    private javax.swing.JRadioButton jRadioButton6;
    private javax.swing.JRadioButton jRadioButton7;
    private javax.swing.JRadioButton jRadioButton8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JScrollPane jScrollPane7;
    private javax.swing.JLabel jStatusBar;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JTextArea jTextArea2;
    private javax.swing.JTextArea jTextArea3;
    private javax.swing.JTextArea jTextArea4;
    private javax.swing.JTextArea jTextArea5;
    private javax.swing.JTextArea jTextArea6;
    private javax.swing.JTextArea jTextArea7;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField11;
    private javax.swing.JTextField jTextField12;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JTextField jTextField4;
    private javax.swing.JTextField jTextField5;
    private javax.swing.JTextField jTextField6;
    private javax.swing.JTextField jTextField7;
    private javax.swing.JTextField jTextField8;
    private javax.swing.JTextField jTextField9;
    // End of variables declaration//GEN-END:variables
    
}
