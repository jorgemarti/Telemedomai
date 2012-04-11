/*
 * ServerIF.java
 *
 * Created on 25 de febrero de 2007, 16:59
 *
 * Programa servidor para el proyecto de Telemedicina del alumno Jorge Martí Coronil
 */

package server;

import com.sun.media.multiplexer.video.AVIMux;
import com.sun.media.renderer.video.Java2DRenderer;
import javax.swing.JFileChooser;
import javax.swing.UIManager;
import java.net.URL;
import java.awt.Image;
import java.io.*;


/**
 *
 * @author  Coke
 */
public class ServerIF extends javax.swing.JFrame {
    
    /*
     * #############   Iniciación de variables mias (las no generadas por Netbeans) ######################
     *
     */
    
    private String user,password;                       //Simplemente almacena el nombre del usuario "loggeado" y su contraseña
    private String [] datosPaciente;                    //Almacenará todos los datos del paciente tratado
    private String patient;                             //Almacena el número de credencial del paciente,para crearle un directorio
    private ProtocolServer protocolo;                   //Encargado de las comunicaciones
    private JFileChooser imageChooser,audioChooser;     //Para elegir dónde guardar las imagenes y los archivos de audio recibidos
    private AVReceiver avr;                             //Encargado de recibir datos de conferencias, sean con video o no
    private AVTransmitter avt;
    
    private String path=System.getProperty("user.dir");
    private String separator=System.getProperty("file.separator");
    private int numImages=0,numAudios=0,numMedidas=0;   //Para ver el número de imágenes,audios y otras medidas que hemos recibido
    private boolean pulmFrente;                         //Esta variable global la utilizamos en la auscultación pulmonar
                                                        //para saber si estamos en la parte frontal o trasera
    
    //private int paco=0;  //borrame
    
    /** 
     * #############  Constructor de la clase, que llama al método que crea el Form y sus contenidos #####
     */
    
    public ServerIF() {
        // Estas primeras lineas son sólo para adaptarse al aspecto del sistema en que se ejecute
        try {
        UIManager.setLookAndFeel(
            UIManager.getSystemLookAndFeelClassName());
        } catch (Exception e) { }
        
        //Aquí ya empezamos en serio
        initComponents();
        
        //Establecemos el icono de la ventana del programa (revisar!)
        this.setIconImage(new javax.swing.ImageIcon(getClass().getResource("/imagenes/medicina_small.png")).getImage());
    }
    
    /** 
     * Método creado por NETBEANS para la incialización de todos
     * los componentes de la interfaz
     * NO MODIFICAR BAJO NINGÚN CONCEPTO
     * NO intentar leer, saltar hasta la parte de manejadores de eventos
     */
    // <editor-fold defaultstate="collapsed" desc=" Generated Code ">//GEN-BEGIN:initComponents
    private void initComponents() {
        jFrame1 = new javax.swing.JFrame();
        jPanel10 = new javax.swing.JPanel();
        jButton3 = new javax.swing.JButton();
        jPasswordField1 = new javax.swing.JPasswordField();
        jLabel10 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jFrame2 = new javax.swing.JFrame();
        jPanel15 = new javax.swing.JPanel();
        jLabel22 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();
        buttonGroup1 = new javax.swing.ButtonGroup();
        buttonGroup2 = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        jStatusBar = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel4 = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        jPanel11 = new javax.swing.JPanel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jTextField6 = new javax.swing.JTextField();
        jTextField7 = new javax.swing.JTextField();
        jTextField8 = new javax.swing.JTextField();
        jTextField9 = new javax.swing.JTextField();
        jPanel5 = new javax.swing.JPanel();
        jPanel14 = new javax.swing.JPanel();
        jButton4 = new javax.swing.JButton();
        jScrollPane5 = new javax.swing.JScrollPane();
        jTextArea5 = new javax.swing.JTextArea();
        jButton6 = new javax.swing.JButton();
        jLabel19 = new javax.swing.JLabel();
        jComboBox2 = new javax.swing.JComboBox();
        jLabel20 = new javax.swing.JLabel();
        jPanel16 = new javax.swing.JPanel();
        jRadioButton3 = new javax.swing.JRadioButton();
        jRadioButton4 = new javax.swing.JRadioButton();
        jRadioButton5 = new javax.swing.JRadioButton();
        jLabel24 = new javax.swing.JLabel();
        jRadioButton6 = new javax.swing.JRadioButton();
        jPanel7 = new javax.swing.JPanel();
        jLabel26 = new javax.swing.JLabel();
        jPanel18 = new javax.swing.JPanel();
        jLabel27 = new javax.swing.JLabel();
        jLabel28 = new javax.swing.JLabel();
        jTextField11 = new javax.swing.JTextField();
        jTextField12 = new javax.swing.JTextField();
        jLabel29 = new javax.swing.JLabel();
        jLabel30 = new javax.swing.JLabel();
        jLabel31 = new javax.swing.JLabel();
        jPanel6 = new javax.swing.JPanel();
        jPanel12 = new javax.swing.JPanel();
        jButton5 = new javax.swing.JButton();
        jLabel16 = new javax.swing.JLabel();
        jScrollPane4 = new javax.swing.JScrollPane();
        jTextArea4 = new javax.swing.JTextArea();
        jButton8 = new javax.swing.JButton();
        jComboBox1 = new javax.swing.JComboBox();
        jLabel18 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jPanel17 = new javax.swing.JPanel();
        jPanel19 = new javax.swing.JPanel();
        jTextField13 = new javax.swing.JTextField();
        jLabel33 = new javax.swing.JLabel();
        jScrollPane7 = new javax.swing.JScrollPane();
        jTextArea7 = new javax.swing.JTextArea();
        jLabel34 = new javax.swing.JLabel();
        jLabel32 = new javax.swing.JLabel();
        jComboBox3 = new javax.swing.JComboBox();
        jPanel8 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTextArea2 = new javax.swing.JTextArea();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTextArea3 = new javax.swing.JTextArea();
        jButton1 = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jPanel9 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jTextField2 = new javax.swing.JTextField();
        jTextField3 = new javax.swing.JTextField();
        jTextField4 = new javax.swing.JTextField();
        jTextField5 = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jLabel17 = new javax.swing.JLabel();
        jTextField10 = new javax.swing.JTextField();
        jPanel13 = new javax.swing.JPanel();
        jButton7 = new javax.swing.JButton();
        jLabel21 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        jButton9 = new javax.swing.JButton();
        jRadioButton1 = new javax.swing.JRadioButton();
        jRadioButton2 = new javax.swing.JRadioButton();
        jMenuBar2 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenuItem2 = new javax.swing.JMenuItem();
        jMenuItem6 = new javax.swing.JMenuItem();
        jMenuItem3 = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        jMenuItem4 = new javax.swing.JMenuItem();
        jMenuItem5 = new javax.swing.JMenuItem();

        jFrame1.setTitle("Log In");
        jFrame1.setAlwaysOnTop(true);
        jFrame1.setIconImage(new javax.swing.ImageIcon(getClass().getResource("/imagenes/login.png")).getImage());
        jFrame1.setResizable(false);
        jButton3.setMnemonic('L');
        jButton3.setText("Log In");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButton3.getAccessibleContext().setAccessibleDescription("");

        jLabel10.setText("Contrase\u00f1a:");

        jLabel9.setText("Nombre de usuario:");

        org.jdesktop.layout.GroupLayout jPanel10Layout = new org.jdesktop.layout.GroupLayout(jPanel10);
        jPanel10.setLayout(jPanel10Layout);
        jPanel10Layout.setHorizontalGroup(
            jPanel10Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(org.jdesktop.layout.GroupLayout.TRAILING, jPanel10Layout.createSequentialGroup()
                .addContainerGap()
                .add(jPanel10Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(jLabel9)
                    .add(jLabel10))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED, 18, Short.MAX_VALUE)
                .add(jPanel10Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(jButton3, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 90, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(jPanel10Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.TRAILING, false)
                        .add(org.jdesktop.layout.GroupLayout.LEADING, jPasswordField1)
                        .add(org.jdesktop.layout.GroupLayout.LEADING, jTextField1, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 143, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)))
                .add(69, 69, 69))
        );
        jPanel10Layout.setVerticalGroup(
            jPanel10Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(jPanel10Layout.createSequentialGroup()
                .add(36, 36, 36)
                .add(jPanel10Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(jTextField1, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(jLabel9))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(jPanel10Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(jPasswordField1, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(jLabel10))
                .add(17, 17, 17)
                .add(jButton3)
                .addContainerGap(21, Short.MAX_VALUE))
        );

        jPanel10Layout.linkSize(new java.awt.Component[] {jPasswordField1, jTextField1}, org.jdesktop.layout.GroupLayout.VERTICAL);

        org.jdesktop.layout.GroupLayout jFrame1Layout = new org.jdesktop.layout.GroupLayout(jFrame1.getContentPane());
        jFrame1.getContentPane().setLayout(jFrame1Layout);
        jFrame1Layout.setHorizontalGroup(
            jFrame1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(jFrame1Layout.createSequentialGroup()
                .addContainerGap()
                .add(jPanel10, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jFrame1Layout.setVerticalGroup(
            jFrame1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(jFrame1Layout.createSequentialGroup()
                .addContainerGap()
                .add(jPanel10, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jFrame2.setTitle("Acerca de...");
        jFrame2.setAlwaysOnTop(true);
        jFrame2.setResizable(false);
        jLabel22.setForeground(new java.awt.Color(102, 153, 255));
        jLabel22.setText("cockemc@yahoo.es");
        jLabel22.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel22MouseClicked(evt);
            }
        });

        jLabel23.setText("Para cualquier duda sobre el programa:");

        jLabel25.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/logoSmall.png")));

        org.jdesktop.layout.GroupLayout jPanel15Layout = new org.jdesktop.layout.GroupLayout(jPanel15);
        jPanel15.setLayout(jPanel15Layout);
        jPanel15Layout.setHorizontalGroup(
            jPanel15Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(jPanel15Layout.createSequentialGroup()
                .add(jPanel15Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(jPanel15Layout.createSequentialGroup()
                        .addContainerGap()
                        .add(jLabel25))
                    .add(jPanel15Layout.createSequentialGroup()
                        .addContainerGap()
                        .add(jPanel15Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.TRAILING)
                            .add(jLabel22)
                            .add(jLabel23))))
                .addContainerGap(org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel15Layout.setVerticalGroup(
            jPanel15Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(jPanel15Layout.createSequentialGroup()
                .addContainerGap()
                .add(jLabel25)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(jLabel23)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(jLabel22)
                .addContainerGap(org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        org.jdesktop.layout.GroupLayout jFrame2Layout = new org.jdesktop.layout.GroupLayout(jFrame2.getContentPane());
        jFrame2.getContentPane().setLayout(jFrame2Layout);
        jFrame2Layout.setHorizontalGroup(
            jFrame2Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(jFrame2Layout.createSequentialGroup()
                .addContainerGap()
                .add(jPanel15, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jFrame2Layout.setVerticalGroup(
            jFrame2Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(jFrame2Layout.createSequentialGroup()
                .addContainerGap()
                .add(jPanel15, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Telem\u00e9domai Server");
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setResizable(false);
        jStatusBar.setText("Bienvenido al sistema de Telemedicina, por favor acred\u00edtese en el Menu principal.");

        org.jdesktop.layout.GroupLayout jPanel1Layout = new org.jdesktop.layout.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(jPanel1Layout.createSequentialGroup()
                .add(18, 18, 18)
                .add(jStatusBar)
                .addContainerGap(437, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(jPanel1Layout.createSequentialGroup()
                .add(jStatusBar)
                .addContainerGap(org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel2.setMinimumSize(new java.awt.Dimension(0, 0));
        jTabbedPane1.setEnabled(false);
        jLabel8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/unknown.jpg")));
        jLabel8.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jLabel8.setMaximumSize(new java.awt.Dimension(250, 250));
        jLabel8.setMinimumSize(new java.awt.Dimension(250, 250));

        jPanel11.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Datos del especialista", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 11), new java.awt.Color(0, 0, 0)));
        jLabel11.setText("Apellidos:");

        jLabel12.setText("Nombre:");

        jLabel13.setText("N\u00ba Colegiado");

        jLabel14.setText("Especialidad:");

        jTextField6.setEditable(false);

        jTextField7.setEditable(false);

        jTextField8.setEditable(false);

        jTextField9.setEditable(false);

        org.jdesktop.layout.GroupLayout jPanel11Layout = new org.jdesktop.layout.GroupLayout(jPanel11);
        jPanel11.setLayout(jPanel11Layout);
        jPanel11Layout.setHorizontalGroup(
            jPanel11Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(jPanel11Layout.createSequentialGroup()
                .addContainerGap()
                .add(jPanel11Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.TRAILING)
                    .add(jLabel13)
                    .add(jLabel11)
                    .add(jLabel14)
                    .add(jLabel12))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(jPanel11Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(jTextField6, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 214, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(jTextField7, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 214, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(jTextField8, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 214, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(jTextField9, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 214, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(76, Short.MAX_VALUE))
        );
        jPanel11Layout.setVerticalGroup(
            jPanel11Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(jPanel11Layout.createSequentialGroup()
                .add(21, 21, 21)
                .add(jPanel11Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(jLabel13)
                    .add(jTextField6, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                .add(20, 20, 20)
                .add(jPanel11Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(jLabel12)
                    .add(jTextField7, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                .add(20, 20, 20)
                .add(jPanel11Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(jLabel11)
                    .add(jTextField8, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                .add(20, 20, 20)
                .add(jPanel11Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(jLabel14)
                    .add(jTextField9, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(70, Short.MAX_VALUE))
        );

        org.jdesktop.layout.GroupLayout jPanel4Layout = new org.jdesktop.layout.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(jPanel4Layout.createSequentialGroup()
                .add(jPanel4Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(jPanel4Layout.createSequentialGroup()
                        .addContainerGap()
                        .add(jPanel11, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .add(jPanel4Layout.createSequentialGroup()
                        .add(50, 50, 50)
                        .add(jLabel8, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(org.jdesktop.layout.GroupLayout.TRAILING, jPanel4Layout.createSequentialGroup()
                .add(77, 77, 77)
                .add(jLabel8, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 245, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED, 29, Short.MAX_VALUE)
                .add(jPanel11, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jTabbedPane1.addTab("Inicio", jPanel4);

        jPanel14.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jButton4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/sound.png")));
        jButton4.setMnemonic('R');
        jButton4.setText("Reproducir");
        jButton4.setEnabled(false);
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jTextArea5.setColumns(20);
        jTextArea5.setEditable(false);
        jTextArea5.setRows(3);
        jTextArea5.setOpaque(false);
        jScrollPane5.setViewportView(jTextArea5);

        jButton6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/folder.png")));
        jButton6.setMnemonic('G');
        jButton6.setText("Guardar");
        jButton6.setEnabled(false);
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });

        jLabel19.setText("Descripci\u00f3n:");

        jComboBox2.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jComboBox2ItemStateChanged(evt);
            }
        });

        jLabel20.setText("Archivos de audio recibidos:");

        org.jdesktop.layout.GroupLayout jPanel14Layout = new org.jdesktop.layout.GroupLayout(jPanel14);
        jPanel14.setLayout(jPanel14Layout);
        jPanel14Layout.setHorizontalGroup(
            jPanel14Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(jPanel14Layout.createSequentialGroup()
                .add(jPanel14Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(jPanel14Layout.createSequentialGroup()
                        .addContainerGap()
                        .add(jPanel14Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                            .add(jComboBox2, 0, 358, Short.MAX_VALUE)
                            .add(jLabel20)))
                    .add(jPanel14Layout.createSequentialGroup()
                        .addContainerGap()
                        .add(jPanel14Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                            .add(jScrollPane5, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 358, Short.MAX_VALUE)
                            .add(jPanel14Layout.createSequentialGroup()
                                .add(jLabel19)
                                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED, 300, Short.MAX_VALUE))))
                    .add(jPanel14Layout.createSequentialGroup()
                        .add(59, 59, 59)
                        .add(jButton4, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 123, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                        .add(jButton6)))
                .addContainerGap())
        );

        jPanel14Layout.linkSize(new java.awt.Component[] {jButton4, jButton6}, org.jdesktop.layout.GroupLayout.HORIZONTAL);

        jPanel14Layout.setVerticalGroup(
            jPanel14Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(jPanel14Layout.createSequentialGroup()
                .addContainerGap()
                .add(jLabel20)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(jComboBox2, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(jLabel19)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(jScrollPane5, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 66, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED, 12, Short.MAX_VALUE)
                .add(jPanel14Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(jButton6, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 39, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(jButton4))
                .addContainerGap())
        );

        jPanel14Layout.linkSize(new java.awt.Component[] {jButton4, jButton6}, org.jdesktop.layout.GroupLayout.VERTICAL);

        jPanel16.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        buttonGroup1.add(jRadioButton3);
        jRadioButton3.setText("Card\u00edaca");
        jRadioButton3.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 0, 0, 0));
        jRadioButton3.setMargin(new java.awt.Insets(0, 0, 0, 0));
        jRadioButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton3ActionPerformed(evt);
            }
        });

        buttonGroup1.add(jRadioButton4);
        jRadioButton4.setText("Pulmonar");
        jRadioButton4.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 0, 0, 0));
        jRadioButton4.setMargin(new java.awt.Insets(0, 0, 0, 0));
        jRadioButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton4ActionPerformed(evt);
            }
        });

        buttonGroup1.add(jRadioButton5);
        jRadioButton5.setText("Abdominal");
        jRadioButton5.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 0, 0, 0));
        jRadioButton5.setMargin(new java.awt.Insets(0, 0, 0, 0));
        jRadioButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton5ActionPerformed(evt);
            }
        });

        jLabel24.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel24.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/vitrubio.jpg")));
        jLabel24.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel24MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabel24MouseEntered(evt);
            }
        });

        buttonGroup1.add(jRadioButton6);
        jRadioButton6.setSelected(true);
        jRadioButton6.setText("Otro");
        jRadioButton6.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 0, 0, 0));
        jRadioButton6.setMargin(new java.awt.Insets(0, 0, 0, 0));
        jRadioButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton6ActionPerformed(evt);
            }
        });

        org.jdesktop.layout.GroupLayout jPanel16Layout = new org.jdesktop.layout.GroupLayout(jPanel16);
        jPanel16.setLayout(jPanel16Layout);
        jPanel16Layout.setHorizontalGroup(
            jPanel16Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(jPanel16Layout.createSequentialGroup()
                .add(19, 19, 19)
                .add(jRadioButton3, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 86, Short.MAX_VALUE)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(jRadioButton4, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 87, Short.MAX_VALUE)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(jRadioButton5, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 92, Short.MAX_VALUE)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(jRadioButton6)
                .add(37, 37, 37))
            .add(jPanel16Layout.createSequentialGroup()
                .addContainerGap()
                .add(jLabel24, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 358, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel16Layout.setVerticalGroup(
            jPanel16Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(jPanel16Layout.createSequentialGroup()
                .addContainerGap()
                .add(jPanel16Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(jRadioButton3)
                    .add(jRadioButton4)
                    .add(jRadioButton5)
                    .add(jRadioButton6))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(jLabel24, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 342, Short.MAX_VALUE)
                .addContainerGap())
        );

        org.jdesktop.layout.GroupLayout jPanel5Layout = new org.jdesktop.layout.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .add(jPanel5Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(jPanel16, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .add(jPanel14, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(jPanel5Layout.createSequentialGroup()
                .add(jPanel16, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(jPanel14, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jTabbedPane1.addTab("Estetoscopia", jPanel5);

        jLabel26.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/anim/presion.gif")));

        jPanel18.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jLabel27.setText("Presi\u00f3n arterial sist\u00f3lica:");
        jLabel27.setEnabled(false);

        jLabel28.setText("Presi\u00f3n arterial diast\u00f3lica:");
        jLabel28.setEnabled(false);

        jTextField11.setEditable(false);

        jTextField12.setEditable(false);

        jLabel29.setText("mmHg");
        jLabel29.setEnabled(false);

        jLabel30.setText("mmHg");
        jLabel30.setEnabled(false);

        jLabel31.setText("No se ha recibido a\u00fan ninguna medici\u00f3n de presi\u00f3n arterial.");

        org.jdesktop.layout.GroupLayout jPanel18Layout = new org.jdesktop.layout.GroupLayout(jPanel18);
        jPanel18.setLayout(jPanel18Layout);
        jPanel18Layout.setHorizontalGroup(
            jPanel18Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(jPanel18Layout.createSequentialGroup()
                .add(jPanel18Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(jPanel18Layout.createSequentialGroup()
                        .addContainerGap()
                        .add(jPanel18Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                            .add(jLabel28)
                            .add(jLabel27))
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                        .add(jPanel18Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING, false)
                            .add(jTextField12)
                            .add(jTextField11, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 67, Short.MAX_VALUE))
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                        .add(jPanel18Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                            .add(jLabel29)
                            .add(jLabel30)))
                    .add(jPanel18Layout.createSequentialGroup()
                        .add(33, 33, 33)
                        .add(jLabel31)))
                .addContainerGap(63, Short.MAX_VALUE))
        );
        jPanel18Layout.setVerticalGroup(
            jPanel18Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(jPanel18Layout.createSequentialGroup()
                .add(80, 80, 80)
                .add(jPanel18Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(jLabel27)
                    .add(jTextField12, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(jLabel29))
                .add(16, 16, 16)
                .add(jPanel18Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(jLabel28)
                    .add(jTextField11, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(jLabel30))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED, 65, Short.MAX_VALUE)
                .add(jLabel31)
                .add(20, 20, 20))
        );

        org.jdesktop.layout.GroupLayout jPanel7Layout = new org.jdesktop.layout.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(jPanel7Layout.createSequentialGroup()
                .add(jPanel7Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(jPanel7Layout.createSequentialGroup()
                        .add(18, 18, 18)
                        .add(jLabel26))
                    .add(jPanel7Layout.createSequentialGroup()
                        .addContainerGap()
                        .add(jPanel18, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .add(jLabel26, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 354, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(jPanel18, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jTabbedPane1.addTab("Presi\u00f3n Arterial", null, jPanel7, "Presi\u00f3n o tensi\u00f3n arterial");

        jPanel12.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jButton5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/folder.png")));
        jButton5.setMnemonic('G');
        jButton5.setText("Guardar");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        jLabel16.setText("Descripci\u00f3n:");

        jTextArea4.setColumns(20);
        jTextArea4.setEditable(false);
        jTextArea4.setRows(3);
        jTextArea4.setOpaque(false);
        jScrollPane4.setViewportView(jTextArea4);

        jButton8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/image.png")));
        jButton8.setMnemonic('b');
        jButton8.setText("Abrir");
        jButton8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton8ActionPerformed(evt);
            }
        });

        jComboBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox1ActionPerformed(evt);
            }
        });

        jLabel18.setText("Im\u00e1genes recibidas:");

        org.jdesktop.layout.GroupLayout jPanel12Layout = new org.jdesktop.layout.GroupLayout(jPanel12);
        jPanel12.setLayout(jPanel12Layout);
        jPanel12Layout.setHorizontalGroup(
            jPanel12Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(jPanel12Layout.createSequentialGroup()
                .add(68, 68, 68)
                .add(jButton8)
                .add(18, 18, 18)
                .add(jButton5)
                .add(157, 157, 157))
            .add(jPanel12Layout.createSequentialGroup()
                .addContainerGap()
                .add(jPanel12Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(jPanel12Layout.createSequentialGroup()
                        .add(jLabel18)
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED, 240, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                    .add(jPanel12Layout.createSequentialGroup()
                        .add(jLabel16)
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED, 278, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                    .add(jScrollPane4, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 336, Short.MAX_VALUE)
                    .add(jComboBox1, 0, 336, Short.MAX_VALUE))
                .addContainerGap())
        );

        jPanel12Layout.linkSize(new java.awt.Component[] {jButton5, jButton8}, org.jdesktop.layout.GroupLayout.HORIZONTAL);

        jPanel12Layout.setVerticalGroup(
            jPanel12Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(org.jdesktop.layout.GroupLayout.TRAILING, jPanel12Layout.createSequentialGroup()
                .addContainerGap()
                .add(jLabel18)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(jComboBox1, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(jLabel16)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(jScrollPane4, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 100, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(jPanel12Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(jButton8)
                    .add(jButton5))
                .addContainerGap(57, Short.MAX_VALUE))
        );

        jLabel15.setMaximumSize(new java.awt.Dimension(360, 304));

        org.jdesktop.layout.GroupLayout jPanel6Layout = new org.jdesktop.layout.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .add(jPanel6Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING, false)
                    .add(jPanel12, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 360, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(jLabel15, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 360, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        jPanel6Layout.linkSize(new java.awt.Component[] {jLabel15, jPanel12}, org.jdesktop.layout.GroupLayout.HORIZONTAL);

        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .add(jLabel15, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 304, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(jPanel12, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jTabbedPane1.addTab("Im\u00e1genes", jPanel6);

        jPanel19.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Otras mediciones", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 11), new java.awt.Color(0, 0, 0)));
        jTextField13.setEditable(false);

        jLabel33.setText("Valores obtenidos:");

        jTextArea7.setColumns(20);
        jTextArea7.setEditable(false);
        jTextArea7.setRows(5);
        jTextArea7.setOpaque(false);
        jScrollPane7.setViewportView(jTextArea7);

        jLabel34.setText("Tipo de medici\u00f3n:");

        jLabel32.setText("Medidas recibidas:");

        jComboBox3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox3ActionPerformed(evt);
            }
        });

        org.jdesktop.layout.GroupLayout jPanel19Layout = new org.jdesktop.layout.GroupLayout(jPanel19);
        jPanel19.setLayout(jPanel19Layout);
        jPanel19Layout.setHorizontalGroup(
            jPanel19Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(jPanel19Layout.createSequentialGroup()
                .add(jPanel19Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(jPanel19Layout.createSequentialGroup()
                        .add(19, 19, 19)
                        .add(jComboBox3, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 218, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                    .add(jPanel19Layout.createSequentialGroup()
                        .addContainerGap()
                        .add(jPanel19Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                            .add(org.jdesktop.layout.GroupLayout.TRAILING, jPanel19Layout.createSequentialGroup()
                                .add(10, 10, 10)
                                .add(jScrollPane7, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 348, Short.MAX_VALUE))
                            .add(jPanel19Layout.createSequentialGroup()
                                .add(jPanel19Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.TRAILING)
                                    .add(org.jdesktop.layout.GroupLayout.LEADING, jLabel34)
                                    .add(org.jdesktop.layout.GroupLayout.LEADING, jLabel33))
                                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED, 269, Short.MAX_VALUE))
                            .add(jPanel19Layout.createSequentialGroup()
                                .add(10, 10, 10)
                                .add(jTextField13, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 217, Short.MAX_VALUE)
                                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED, 131, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))))
                    .add(jPanel19Layout.createSequentialGroup()
                        .addContainerGap()
                        .add(jLabel32)))
                .addContainerGap())
        );
        jPanel19Layout.setVerticalGroup(
            jPanel19Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(jPanel19Layout.createSequentialGroup()
                .addContainerGap()
                .add(jLabel32)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(jComboBox3, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .add(18, 18, 18)
                .add(jLabel34)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(jTextField13, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .add(18, 18, 18)
                .add(jLabel33)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(jScrollPane7, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(338, Short.MAX_VALUE))
        );

        org.jdesktop.layout.GroupLayout jPanel17Layout = new org.jdesktop.layout.GroupLayout(jPanel17);
        jPanel17.setLayout(jPanel17Layout);
        jPanel17Layout.setHorizontalGroup(
            jPanel17Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(jPanel17Layout.createSequentialGroup()
                .add(jPanel19, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel17Layout.setVerticalGroup(
            jPanel17Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(jPanel17Layout.createSequentialGroup()
                .add(jPanel19, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jTabbedPane1.addTab("Otros", null, jPanel17, "Otras mediciones");

        jLabel1.setText("Diagn\u00f3stico para el paciente:");

        jScrollPane2.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        jTextArea2.setColumns(20);
        jTextArea2.setRows(5);
        jTextArea2.setVerifyInputWhenFocusTarget(false);
        jScrollPane2.setViewportView(jTextArea2);

        jLabel2.setText("Recomendaciones:");

        jScrollPane3.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        jTextArea3.setColumns(20);
        jTextArea3.setRows(5);
        jScrollPane3.setViewportView(jTextArea3);

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/send.png")));
        jButton1.setMnemonic('E');
        jButton1.setText("Enviar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        org.jdesktop.layout.GroupLayout jPanel8Layout = new org.jdesktop.layout.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(jPanel8Layout.createSequentialGroup()
                .add(jPanel8Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(jPanel8Layout.createSequentialGroup()
                        .add(20, 20, 20)
                        .add(jScrollPane3, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 372, Short.MAX_VALUE))
                    .add(org.jdesktop.layout.GroupLayout.TRAILING, jPanel8Layout.createSequentialGroup()
                        .addContainerGap()
                        .add(jPanel8Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                            .add(jLabel1)
                            .add(jLabel2)
                            .add(jPanel8Layout.createSequentialGroup()
                                .add(10, 10, 10)
                                .add(jScrollPane2, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 372, Short.MAX_VALUE))))
                    .add(jPanel8Layout.createSequentialGroup()
                        .add(151, 151, 151)
                        .add(jButton1)))
                .addContainerGap())
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(jPanel8Layout.createSequentialGroup()
                .add(98, 98, 98)
                .add(jLabel1)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(jScrollPane2, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 153, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .add(48, 48, 48)
                .add(jLabel2)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(jScrollPane3, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 61, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .add(35, 35, 35)
                .add(jButton1)
                .addContainerGap(51, Short.MAX_VALUE))
        );

        jPanel8Layout.linkSize(new java.awt.Component[] {jScrollPane2, jScrollPane3}, org.jdesktop.layout.GroupLayout.VERTICAL);

        jTabbedPane1.addTab("Diagn\u00f3stico", jPanel8);

        org.jdesktop.layout.GroupLayout jPanel2Layout = new org.jdesktop.layout.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .add(jTabbedPane1, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 407, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .add(jTabbedPane1, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 647, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanel3.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel9.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Datos del paciente", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 11), new java.awt.Color(0, 0, 0)));
        jLabel3.setText("Nombre:");

        jLabel4.setText("Apellidos:");

        jLabel5.setText("Edad:");

        jLabel6.setText("Sexo:");

        jLabel7.setText("S\u00edntomas:");

        jTextField2.setEditable(false);

        jTextField3.setEditable(false);

        jTextField4.setEditable(false);

        jTextField5.setEditable(false);

        jTextArea1.setBackground(new java.awt.Color(235, 235, 228));
        jTextArea1.setColumns(20);
        jTextArea1.setEditable(false);
        jTextArea1.setRows(4);
        jScrollPane1.setViewportView(jTextArea1);

        jLabel17.setText("Credencial:");

        jTextField10.setEditable(false);

        org.jdesktop.layout.GroupLayout jPanel9Layout = new org.jdesktop.layout.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(jPanel9Layout.createSequentialGroup()
                .add(jPanel9Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(jPanel9Layout.createSequentialGroup()
                        .addContainerGap()
                        .add(jPanel9Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                            .add(jLabel4)
                            .add(jLabel3)
                            .add(jLabel5))
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                        .add(jPanel9Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                            .add(jTextField2, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 287, Short.MAX_VALUE)
                            .add(jTextField3, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 287, Short.MAX_VALUE)
                            .add(jPanel9Layout.createSequentialGroup()
                                .add(jTextField4, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 36, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                                .add(jLabel17)
                                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                                .add(jTextField10, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 83, Short.MAX_VALUE)
                                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                                .add(jLabel6)
                                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                                .add(jTextField5, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 53, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))))
                    .add(jPanel9Layout.createSequentialGroup()
                        .addContainerGap()
                        .add(jLabel7))
                    .add(org.jdesktop.layout.GroupLayout.TRAILING, jPanel9Layout.createSequentialGroup()
                        .add(20, 20, 20)
                        .add(jScrollPane1, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 327, Short.MAX_VALUE)))
                .addContainerGap())
        );

        jPanel9Layout.linkSize(new java.awt.Component[] {jTextField4, jTextField5}, org.jdesktop.layout.GroupLayout.HORIZONTAL);

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
                .add(jPanel9Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(jPanel9Layout.createSequentialGroup()
                        .add(jPanel9Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                            .add(jLabel5)
                            .add(jTextField4, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                            .add(jTextField5, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                            .add(jLabel6))
                        .add(24, 24, 24)
                        .add(jLabel7))
                    .add(jPanel9Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                        .add(jLabel17)
                        .add(jTextField10, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(jScrollPane1, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 81, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel13.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        org.jdesktop.layout.GroupLayout jPanel13Layout = new org.jdesktop.layout.GroupLayout(jPanel13);
        jPanel13.setLayout(jPanel13Layout);
        jPanel13Layout.setHorizontalGroup(
            jPanel13Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(0, 369, Short.MAX_VALUE)
        );
        jPanel13Layout.setVerticalGroup(
            jPanel13Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(0, 292, Short.MAX_VALUE)
        );

        jButton7.setText("Aceptar");
        jButton7.setEnabled(false);
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });

        jButton2.setText("Transmitir");
        jButton2.setEnabled(false);
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton9.setText("Detener");
        jButton9.setEnabled(false);
        jButton9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton9ActionPerformed(evt);
            }
        });

        buttonGroup2.add(jRadioButton1);
        jRadioButton1.setSelected(true);
        jRadioButton1.setText("Videoconferencia");
        jRadioButton1.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 0, 0, 0));
        jRadioButton1.setEnabled(false);
        jRadioButton1.setMargin(new java.awt.Insets(0, 0, 0, 0));

        buttonGroup2.add(jRadioButton2);
        jRadioButton2.setText("Audio");
        jRadioButton2.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 0, 0, 0));
        jRadioButton2.setEnabled(false);
        jRadioButton2.setMargin(new java.awt.Insets(0, 0, 0, 0));

        org.jdesktop.layout.GroupLayout jPanel3Layout = new org.jdesktop.layout.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .add(jPanel3Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.TRAILING, false)
                    .add(jPanel13, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .add(jPanel9, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
            .add(org.jdesktop.layout.GroupLayout.TRAILING, jPanel3Layout.createSequentialGroup()
                .add(jPanel3Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.TRAILING)
                    .add(jPanel3Layout.createSequentialGroup()
                        .addContainerGap()
                        .add(jRadioButton1))
                    .add(jPanel3Layout.createSequentialGroup()
                        .add(65, 65, 65)
                        .add(jLabel21, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 51, Short.MAX_VALUE)
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                        .add(jButton7)))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(jPanel3Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(jPanel3Layout.createSequentialGroup()
                        .add(jButton2)
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                        .add(jButton9))
                    .add(jRadioButton2))
                .add(30, 30, 30))
        );

        jPanel3Layout.linkSize(new java.awt.Component[] {jButton2, jButton7, jButton9}, org.jdesktop.layout.GroupLayout.HORIZONTAL);

        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(org.jdesktop.layout.GroupLayout.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .add(jPanel13, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED, 16, Short.MAX_VALUE)
                .add(jPanel3Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(jRadioButton1)
                    .add(jRadioButton2))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(jPanel3Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.TRAILING)
                    .add(jPanel3Layout.createSequentialGroup()
                        .add(jLabel21, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 17, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                        .add(23, 23, 23))
                    .add(jPanel3Layout.createSequentialGroup()
                        .add(jPanel3Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                            .add(jButton7)
                            .add(jButton2)
                            .add(jButton9))
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)))
                .add(jPanel9, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jMenu1.setMnemonic('M');
        jMenu1.setText("Menu");
        jMenuItem1.setMnemonic('L');
        jMenuItem1.setText("Log in");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });

        jMenu1.add(jMenuItem1);

        jMenuItem2.setMnemonic('O');
        jMenuItem2.setText("Log out");
        jMenuItem2.setDisplayedMnemonicIndex(4);
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem2ActionPerformed(evt);
            }
        });

        jMenu1.add(jMenuItem2);

        jMenuItem6.setMnemonic('N');
        jMenuItem6.setText("Nuevo paciente...");
        jMenuItem6.setEnabled(false);
        jMenuItem6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem6ActionPerformed(evt);
            }
        });

        jMenu1.add(jMenuItem6);

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
        jMenuItem4.setMnemonic('M');
        jMenuItem4.setText("Manual de usuario");
        jMenuItem4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem4ActionPerformed(evt);
            }
        });

        jMenu2.add(jMenuItem4);

        jMenuItem5.setMnemonic('A');
        jMenuItem5.setText("Acerca de...");
        jMenuItem5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem5ActionPerformed(evt);
            }
        });

        jMenu2.add(jMenuItem5);

        jMenuBar2.add(jMenu2);

        setJMenuBar(jMenuBar2);

        org.jdesktop.layout.GroupLayout layout = new org.jdesktop.layout.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(layout.createSequentialGroup()
                .addContainerGap()
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(layout.createSequentialGroup()
                        .add(jPanel2, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                        .add(jPanel3, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED, 2, Short.MAX_VALUE))
                    .add(jPanel1, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(layout.createSequentialGroup()
                .addContainerGap()
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.TRAILING)
                    .add(jPanel3, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .add(jPanel2, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(jPanel1, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
        );
        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton9ActionPerformed
        avt.stop();
        protocolo.stopConferencia();
        jButton2.setEnabled(true);
        jButton9.setEnabled(false);
        System.out.println("Transmisión detenida...");
        changeStatusBar("Transmisión detenida...");
    }//GEN-LAST:event_jButton9ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        if (!iniciaVideoConferencia())
            return;
        jButton9.setEnabled(true);
        jButton2.setEnabled(false);
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jComboBox3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox3ActionPerformed
        String text=leeTexto(path+separator+patient+separator+jComboBox3.getSelectedItem()+".txt");
        if (text.equalsIgnoreCase(""))
            return;
        String [] lineas=text.split("\n");          // Primero dividimos el texto en dos lineas
        jTextArea7.setText(lineas[1]);              //El valor de las medidas es directamente la segunda línea del archivo de texto
        String [] aux=new String[3];
        aux=lineas[0].split("\"");                  //Después dividimos la primera línea,usando el carácter " que delimita el tipo de medida
        jTextField13.setText(aux[1]) ;
    }//GEN-LAST:event_jComboBox3ActionPerformed
   
             
     /*
     * #############   SECCIÓN DE MANEJADORES DE EVENTOS ###################################
     *
     */
    
    
    /**
     * Evento para cuando se selecciona una de los audios recibidos en la seccion correspondiente
     *
     */
    
    private void jComboBox2ItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jComboBox2ItemStateChanged
          
        String text=leeTexto(path+separator+patient+separator+"audios"+separator+jComboBox2.getSelectedItem()+".txt");
        jTextArea5.setText(text);
    }//GEN-LAST:event_jComboBox2ItemStateChanged

    private void jLabel24MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel24MouseClicked
        if (jRadioButton4.isSelected()&&evt.getButton()==3)
        {
            if (pulmFrente==true)
            {
                jLabel24.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/anim/b_pulmonar.gif")));
                pulmFrente=false;
            }
            else
            {
                jLabel24.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/anim/pulmonar.gif")));
                pulmFrente=true;
            }
                
        }
    }//GEN-LAST:event_jLabel24MouseClicked

    private void jLabel24MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel24MouseEntered
        if (jRadioButton4.isSelected())
            changeStatusBar("Pulse con el botón derecho para cambiar de frente a espalda.");
    }//GEN-LAST:event_jLabel24MouseEntered

    private void jRadioButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton6ActionPerformed
        jLabel24.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/vitrubio.jpg")));
    }//GEN-LAST:event_jRadioButton6ActionPerformed

    private void jRadioButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton5ActionPerformed
        jLabel24.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/anim/abdominal.gif")));
    }//GEN-LAST:event_jRadioButton5ActionPerformed

    private void jRadioButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton4ActionPerformed
        jLabel24.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/anim/pulmonar.gif")));
        pulmFrente=true;
    }//GEN-LAST:event_jRadioButton4ActionPerformed

    private void jRadioButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton3ActionPerformed
        jLabel24.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/anim/cardiaca0.gif")));
    }//GEN-LAST:event_jRadioButton3ActionPerformed

    private void jLabel22MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel22MouseClicked
        Lanzador launcher=new Lanzador();
        //Llama al programa por defecto del sistema para enviarme un correo
        launcher.abrir("mailto:cockemc@yahoo.es");
    }//GEN-LAST:event_jLabel22MouseClicked

    private void jMenuItem6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem6ActionPerformed
        resetPatient();
        changeStatusBar("Servidor reiniciando, esperando un nuevo paciente...");        
    }//GEN-LAST:event_jMenuItem6ActionPerformed
 
    /**
     * Evento para cuando se selecciona una de las imágenes recibidas en la seccion correspondiente
     *
     */
    private void jComboBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox1ActionPerformed
        String text=leeTexto(path+separator+patient+separator+"imagenes"+separator+jComboBox1.getSelectedItem()+".txt");
        String imag=path+separator+patient+separator+"imagenes"+separator+jComboBox1.getSelectedItem()+".jpg";
        jTextArea4.setText(text);
        
        //Ahora vamos a mostrar una versión reducida de la imagen seleccionada
        java.awt.Image imagen = java.awt.Toolkit.getDefaultToolkit().getImage (imag);
        int ancho=jPanel12.getWidth();   //Tomamos como referencia el ancho del panel donde se mostrará
        int alto=ancho*3/4;
        //Con esta instrucción realizamos el Thumbnail y se lo asignamos al lugar adecuado
        jLabel15.setIcon(new javax.swing.ImageIcon(imagen.getScaledInstance(ancho,alto,Image.SCALE_FAST)));
    }//GEN-LAST:event_jComboBox1ActionPerformed

/**
 * Evento para cuando se selecciona "Acerca de..." en el menú principal
 *
 */
    private void jMenuItem5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem5ActionPerformed
        jFrame2.setSize(300,225);
        jFrame2.setLocation(400,200);
        jFrame2.setVisible(true);
    }//GEN-LAST:event_jMenuItem5ActionPerformed

 /**
 * Evento para cuando se selecciona "Manual de usuario" en el menú principal
 *
 */
    private void jMenuItem4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem4ActionPerformed
        Lanzador launcher=new Lanzador();
        launcher.abrir("http://www.jorgemarti.com/projects/telemedomai");        
    }//GEN-LAST:event_jMenuItem4ActionPerformed

 /**
 * Evento para cuando se clicka el botón de "Abrir imagen" en imágenes recibidas
 *
 */
    private void jButton8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton8ActionPerformed
        Lanzador launcher=new Lanzador();
        launcher.abrir(path+separator+patient+separator+"imagenes"+separator+jComboBox1.getSelectedItem()+".jpg");
    }//GEN-LAST:event_jButton8ActionPerformed

/**
 * Evento para cuando se acepta una CONFERENCIA, bien de audio o audio/video
 *
 */
    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
        String tipo=jLabel21.getText();
        if (tipo.equalsIgnoreCase("Videoconferencia"))
        {
            String [] args={"225.0.0.1/10000","225.0.0.1/10002"};
            avr = new AVReceiver(args);
        }
            
        else if (tipo.equalsIgnoreCase("Audioconferencia"))
        {
            String [] args={"225.0.0.1/10002"};
            avr = new AVReceiver(args);
        }
        else return;
        
	if (!avr.initialize()) {
	    System.err.println("Error al iniciar las sesiones de "+tipo);
	    changeStatusBar("Error al iniciar las sesiones de "+tipo);
            return;
	}
        /*jPanel13.removeAll();  //Eliminamos cualquier contenido anterior en el panel (otra videoconferencia,...)
        java.awt.BorderLayout layout=new java.awt.BorderLayout();
        jPanel13.setLayout(layout);*/
        jButton7.setEnabled(false);
        changeStatusBar(tipo+" iniciada...");
        jPanel13.add(avr.getPlayerComponent(),java.awt.BorderLayout.CENTER);       
    }//GEN-LAST:event_jButton7ActionPerformed

/**
 * Evento para el botón de enviar DIAGNÓSTICO
 *
 */
    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        String diag=jTextArea2.getText();
        String recom=jTextArea3.getText();
        String[] doctor={jTextField7.getText(),jTextField8.getText(),jTextField6.getText()};
        
        if (diag.equalsIgnoreCase(""))
        {
           changeStatusBar("Por favor redacte claramente el diagnóstico para el paciente");
           return; 
        }
        else if (recom.equalsIgnoreCase(""))
        {
           changeStatusBar("Por favor agregue las recomendaciones necesarias para el paciente");
           return;
        }
        
        String fichero=path+separator+patient+separator+"diagnostico.pdf";
        Informe inf=new Informe(fichero);
        inf.generar(datosPaciente,diag,recom,"Doctor "+doctor[0]+" "+doctor[1],doctor[2]);
        if (protocolo.enviaDiagnostico(new tiposDatos.Diagnostico(diag,recom,doctor,fichero)))
        {
            changeStatusBar("Diagnóstico enviado correctamente.");
        }
        else
            changeStatusBar("ERROR al enviar el diagnóstico al paciente.");   
    }//GEN-LAST:event_jButton1ActionPerformed

/**
 * Evento para cuando clicka GUARDAR en el menú de archivos de AUDIO
 *
 */
    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        if (audioChooser == null) audioChooser = new JFileChooser();
        audioChooser.setDialogType(JFileChooser.SAVE_DIALOG);
        audioChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
                
        //Añadimos un filtro de selección y desactivamos la opción de Todos Archivos
        audioChooser.setAcceptAllFileFilterUsed(false);
        ExampleFileFilter filtro=new ExampleFileFilter();
        filtro.addExtension("wav");
        filtro.setDescription("Archivos .WAV");
        audioChooser.setFileFilter(filtro);
        
        int returnVal = audioChooser.showDialog(this, "Guardar");
        if (returnVal == JFileChooser.APPROVE_OPTION) 
        {
            String file = audioChooser.getSelectedFile().getAbsolutePath();
            if (!file.endsWith(".wav")&&!file.endsWith(".WAV"))
                file=new String(file+".wav");
            copiaFicheros(path+separator+patient+separator+"audios"+separator+jComboBox2.getSelectedItem()+".wav",file);
            
        } 
    }//GEN-LAST:event_jButton6ActionPerformed

 /**
 * Evento para cuando clicka REPRODUCIR en el menú de archivos de AUDIO
 *
 */
    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        String seleccion=jComboBox2.getSelectedItem().toString();
        if (!seleccion.equalsIgnoreCase(""))
            startPlaying(path+separator+patient+separator+"audios"+separator+seleccion+".wav");
    }//GEN-LAST:event_jButton4ActionPerformed

/**
 * Evento para cuando clicka GUARDAR en el menú de archivos de IMAGEN
 *
 */
    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        if (imageChooser == null) imageChooser = new JFileChooser();
        imageChooser.setDialogType(JFileChooser.SAVE_DIALOG);
        imageChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
                
        //Añadimos un filtro de selección y desactivamos la opción de Todos Archivos
        imageChooser.setAcceptAllFileFilterUsed(false);
        ExampleFileFilter filtro=new ExampleFileFilter();
        filtro.addExtension("jpg");
        filtro.setDescription("Archivos de imágenes");
        imageChooser.setFileFilter(filtro);
        
        int returnVal = imageChooser.showDialog(this, "Guardar");
        if (returnVal == JFileChooser.APPROVE_OPTION) 
        {
            String file = imageChooser.getSelectedFile().getAbsolutePath();
            if (!file.endsWith(".jpg")&&!file.endsWith(".JPG"))
                file=new String(file+".jpg");
            copiaFicheros(path+separator+patient+separator+"imagenes"+separator+jComboBox1.getSelectedItem()+".jpg",file);
            
        }     
    }//GEN-LAST:event_jButton5ActionPerformed

/**
 * Evento para cuando seleccionamos LOGOUT en el menú principal
 *
 */
    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed
    logOut();
    if (protocolo!=null)
    {
        protocolo.stopServer();
    }
    }//GEN-LAST:event_jMenuItem2ActionPerformed

 /**
 * Evento para cuando le damos a LOG IN en la ventana de loggear
 *
 */ 
    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
    
    String usr=jTextField1.getText();
    String pass=new String(jPasswordField1.getPassword());
    if (pass.equalsIgnoreCase(""))
    {
        changeStatusBar("Por favor introduzca tanto nombre de usuario como CONTRASEÑA");
        return;
    }
    boolean result=logIn(usr,pass);
    jFrame1.setVisible(false);
    //Comprobamos que no había ya un usuario loggeado o que no ha habido ningún problema
    if (result==true)
        changeStatusBar("Bienvenido doctor "+user+". Servidor iniciado,esperando conexión de cliente...");
    else
        changeStatusBar("ERROR en el nombre de usuario o contraseña.Inténtelo de nuevo.");
    
    }//GEN-LAST:event_jButton3ActionPerformed

/**
 * Evento para cuando se selecciona "Log IN" en el menú principal
 *
 */
    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
    if (loggedIn())
    {
        changeStatusBar("El sistema ya tiene un usuario. Haga log off antes de iniciar otro usuario.");
        return;
    }
    jFrame1.setSize(400,200);
    jFrame1.setLocation(400,200);
    jFrame1.setVisible(true);
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    /**
     * Evento de selección del menu principal para salir
     *
     */    
    private void jMenuItem3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem3ActionPerformed
        System.out.println("Saliendo...");
        System.exit(0);
    }//GEN-LAST:event_jMenuItem3ActionPerformed

        
     /*
     * #############   SECCIÓN DE MÉTODOS MIOS ###################################
     *
     */
    
    
     /**
      * Método para cuando son recibidos los datos de los pacientes. Crea también un directorio con la información
      * para el paciente con su número de credencial
      *
      * @param Datos Son los datos del paciente, siguiendo la estructura declarada en la clase Datos.java
      */
    public void setDatos(tiposDatos.Datos data)
    {
        datosPaciente=data.getDatos();
        jTextField2.setText(datosPaciente[0]);
        jTextField3.setText(datosPaciente[1]);
        jTextField4.setText(datosPaciente[2]);
        jTextField5.setText(datosPaciente[3]);
        patient=datosPaciente[4];
        jTextField10.setText(patient);
        jTextArea1.setText(datosPaciente[5]);
        
        //Activamos la opción de transmitir videoconferencia.
        jButton2.setEnabled(true);
        jRadioButton1.setEnabled(true);
        jRadioButton2.setEnabled(true);
        //Activamos la opción de nuevo paciente en el menu principal
        jMenuItem6.setEnabled(true);
        
        //Activamos la pestaña de diagnóstico, a partir de este momento el doctor lo puede mandar cuando quiera
        jTabbedPane1.setEnabledAt(jTabbedPane1.getTabCount()-1,true);
        //También activamos las pestañas de fonendoscopia y presión arterial, para que el doctor pueda guiar al paciente
        jTabbedPane1.setEnabledAt(1,true);
        jTabbedPane1.setEnabledAt(2,true);
        
        
        changeStatusBar("Conexión con paciente en "+protocolo.getClientSocket().getInetAddress());
        File directorio=new File(path+separator+patient);
        System.out.println("Creado directorio: "+path+separator+patient);
        directorio.mkdir();
    }
    
    /**
     * Método para cuando se recibe una imagen de alta resolución con su descripción
     *
     */
    
    public void setImagen(tiposDatos.Imagen image)
    {
        String [] aux= image.getDatos();
               
        //Creamos un directorio de imágenes en el directorio del paciente
        File directorio=new File(path+separator+patient+separator+"imagenes");
        if (!directorio.exists())
            directorio.mkdir();
        //Añadimos el nombre de la imagen a la lista de imágenes recibidas.
        jComboBox1.addItem(new String("imagen"+numImages));
        jComboBox1.setSelectedIndex(numImages);
        //Y finalmente la almacenamos en el directorio del usuario, en el apartado de imágenes,con un archivo de texto con la descripcion
        copiaFicheros(aux[0],path+separator+patient+separator+"imagenes"+separator+"imagen"+numImages+".jpg");
        escribeTexto(aux[1],path+separator+patient+separator+"imagenes"+separator+"imagen"+numImages+".txt");
        numImages++;
           
        //Ahorita vamos a mostrar una versión reducida de la imagen recibida
        java.awt.Image imagen = java.awt.Toolkit.getDefaultToolkit().getImage (aux[0]);
        int ancho=jPanel12.getWidth();   //Tomamos como referencia el ancho del panel donde se mostrará
        int alto=ancho*3/4;
        //Con esta instrucción realizamos el Thumbnail y se lo asignamos al lugar adecuado
        jLabel15.setIcon(new javax.swing.ImageIcon(imagen.getScaledInstance(ancho,alto,Image.SCALE_FAST)));
        
        //Ahora activamos la pestaña de imágenes, para que el usuario pueda verla
        jTabbedPane1.setEnabledAt(3,true);
        changeStatusBar("Recibida Imagen de alta resolución desde el paciente");
        
        //Para acabar escribimos la descripción recibida en el TextArea correspondiente
        jTextArea4.setText(aux[1]);
        
    }

    
    /**
     * Método para cuando se recibe un archivo de audio con su descripción
     *
     */
    
    public void setAudio(tiposDatos.Audio audio)
    {
        String [] aux= audio.getDatos();
        
         //Añadimos el nombre del archivo de audio a la lista de audios recibidos
        jComboBox2.addItem(new String("audio"+numAudios));
        jComboBox2.setSelectedIndex(numAudios);
               
        //Escribimos la descripción recibida en el TextArea correspondiente
        jTextArea5.setText(aux[1]);
        
        //Ahora activamos los botones de audio, para que el usuario pueda escucharlo
        jButton4.setEnabled(true);
        jButton6.setEnabled(true);
        changeStatusBar("Recibido audio desde el paciente");
        
        //Creamos un directorio de audios en el directorio del paciente
        File directorio=new File(path+separator+patient+separator+"audios");
        if (!directorio.exists())
            directorio.mkdir();
       
        //Y finalmente lo almacenamos en el directorio del usuario, en el apartado de audios
        copiaFicheros(aux[0],path+separator+patient+separator+"audios"+separator+"audio"+numAudios+".wav");
        escribeTexto(aux[1],path+separator+patient+separator+"audios"+separator+"audio"+numAudios+".txt");
        numAudios++;
    }
    
    
    /**
     * Método para cuando se recibe una medida de presión arterial
     *
     */
    
    public void setPresion(tiposDatos.Presion presion)
    {
        String [] aux= presion.getDatos();
        
        jTextField12.setText(aux[0]);
        jTextField11.setText(aux[1]);
        jLabel31.setText(null);
        jLabel27.setEnabled(true);
        jLabel28.setEnabled(true);
        jLabel29.setEnabled(true);
        jLabel30.setEnabled(true);
        
        changeStatusBar("Recibida toma de presión arterial desde el paciente.");
           
        //Y finalmente lo almacenamos en el directorio del usuario, en un archivo de texto
        escribeTexto(presion.toString(),path+separator+patient+separator+"presion.txt");
        
    }
    
     /**
     * Método para cuando se recibe otro tipo de medida
     *
     */
    
    public void setMedida(tiposDatos.Medida medida)
    {
        String [] aux= medida.getDatos();
        
        jTextField13.setText(aux[0]);
        jTextArea7.setText(aux[1]);
        changeStatusBar("Recibida medida desde el paciente.");
        //Ahora activamos la pestaña de otras medidas, para que el usuario pueda verla
        jTabbedPane1.setEnabledAt(4,true);  
        
        //Añadimos el nombre de la imagen a la lista de imágenes recibidas.
        jComboBox3.addItem(new String("medida"+numMedidas));
        jComboBox3.setSelectedIndex(numMedidas);
              
        //Y finalmente lo almacenamos en el directorio del usuario, en un archivo de texto
        escribeTexto(medida.toString(),path+separator+patient+separator+"medida"+numMedidas+".txt");
        numMedidas++;
        
    }
    
    
    /** 
     * Método para pedir al usuario la autorización para recibir la videoconferencia
     *
     */
    
    public void setWebcam()
    {
        changeStatusBar("Recibida petición de VIDEOCONFERENCIA desde paciente. Pulse Aceptar para iniciarla.");
        jButton7.setEnabled(true);
        jLabel21.setText("Videoconferencia");
    }
    
    /** 
     * Método para pedir al usuario la autorización para recibir la audioconferencia
     *
     */
    
    public void setAudioConferencia()
    {
        changeStatusBar("Recibida petición de AUDIOCONFERENCIA desde paciente. Pulse Aceptar para iniciarla.");
        jButton7.setEnabled(true);
        jLabel21.setText("Audioconferencia");
    }
     
    
    public void stopConferencia()
    {
        jPanel13.removeAll();  //Eliminamos cualquier contenido anterior en el panel (otra videoconferencia,...)
        changeStatusBar("Conferencia detenida");
        jButton7.setEnabled(false);
    }
    /**
    * Método para iniciar la reproducción del archivo de audio recibido
    *
    */
    
    private void startPlaying(String file)
    {
        AudioPlayer player=new AudioPlayer();
        changeStatusBar("Reproduciendo archivo recibido...");
        player.play(file);
        changeStatusBar("Reproducción finalizada");
        
    }
    
    
    /**
     * Método llamado para efectuar el LOG IN. ESTE MÉTODO DEBE SER REVISADO
     * @param userName Nombre de usuario
     * @param pass Password del usuario
     */
    private boolean logIn(String userName,String pass)
    {   
        boolean result;
        if (loggedIn())
        {
            return false;
        }
        user=userName;
        password=pass;
        
        // Iniciamos el servidor
        protocolo=new ProtocolServer();
        boolean temp=protocolo.startServer(this);
        //Si hubo problemas iniciando el servidor no podemos continuar
        if (!temp)
        {
            user=null;
            password=null;
            return false;                       //Si hay algún problema con la contraseña, devolvemos falso
        }
       
        // Ahora vamos a cargar los datos del doctor, desde un fichero de configuración con su nombre
        // de usuario, y terminado en '.txt', que se encuentra en el directorio 'CONF'.
        // Este fichero podemos leerlo desde esa carpeta, o desde un sitio web.
        
        // Desde carpeta de configuración:
        String [] doctor=leeDoctor(getClass().getResource("/conf/"+user+".txt"));
        
        //Desde ejemplo desde sitio web:
        //try{
        //    URL direccion=new URL("http://www.jorgemarti.com/projects/telemedomai/"+user+".txt");
        //    String [] doctor =leeDoctor(direccion);
        //}catch (Exception e){}
        
        jTextField6.setText(doctor[0]);
        jTextField7.setText(doctor[1]);
        jTextField8.setText(doctor[2]);
        jTextField9.setText(doctor[3]);
        
        try
        {
            jLabel8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/"+user.toLowerCase()+".jpg")));
        }
        catch (Exception e)
        {
            System.out.println("Imagen "+user+".jpg no encontrada.");
        }
        result=true;
     
        jTabbedPane1.setEnabled(true);
        for (int i=1;i<jTabbedPane1.getTabCount();i++)    // Establecemos como inactivas todas las pestañas menos inicio
        {                                                   // a la espera de recibir datos de cada tipo, indicados en ellas
                    jTabbedPane1.setEnabledAt(i,false);     // excepto la última que es la de diagnóstico
        }
        return result;
    }
    
    /**
     * Método para la realización del LOG OUT
     */
    private void logOut()
    {   
        if (!loggedIn())
        {
            changeStatusBar("No puedes hacer log out porque no existe ningún usuario acreditado!");
            return;
        }
        user=null;
        changeStatusBar("Bienvenido al sistema de Telemedicina, por favor acred\u00edtese en el Menu principal.");
        jLabel8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/unknown.jpg")));
        jTabbedPane1.setEnabled(false);
        jTabbedPane1.setSelectedIndex(0);
        
        //Desactivamos la opción de nuevo paciente en el menu principal
        jMenuItem6.setEnabled(false);
        cleanFields();
        
    }
    
    /**
     * Método que nos devuelve si el sistema ya tiene un usuario "loggeado"
     */
    private boolean loggedIn()
    {
        if (user!=null)
            return true;
        return false;
    }
   
    /**
     * Método para cuando, voluntaria o involuntariamente, dejamos la conexión con un paciente para esperar otro
     *
     */
    
    public void resetPatient()
    {
        //Detenemos el servidor
        if (protocolo!=null)
            protocolo.stopServer();
        datosPaciente=null;
        patient=null;
        numImages=0;
        numAudios=0;
        numMedidas=0;
        jComboBox1.removeAllItems();
        jComboBox2.removeAllItems();
        jComboBox3.removeAllItems();
        jButton2.setEnabled(false);
        jButton4.setEnabled(false);
        jButton6.setEnabled(false);
        jRadioButton1.setEnabled(false);
        jRadioButton2.setEnabled(false);
        jTextField2.setText(null);
        jTextField3.setText(null);
        jTextField4.setText(null);
        jTextField5.setText(null);
        jTextField10.setText(null);
        jTextField11.setText(null);
        jTextField12.setText(null);
        jLabel21.setText(null);
        jLabel31.setText("No se ha recibido aún ninguna medición de presión arterial.");
        jLabel27.setEnabled(false);
        jLabel28.setEnabled(false);
        jLabel29.setEnabled(false);
        jLabel30.setEnabled(false);
        jTextArea1.setText(null);
        jTextArea3.setText(null);
        jTextArea4.setText(null);
        jTextArea5.setText(null);
        jTabbedPane1.setSelectedIndex(0);
        for (int i=1;i<jTabbedPane1.getTabCount();i++)      // Establecemos como inactivas todas las pestañas menos inicio
        {                                                   // a la espera de recibir datos de cada tipo, indicados en ellas
                    jTabbedPane1.setEnabledAt(i,false);     
        }
        //Volvemos a iniciar el servidor
        protocolo=new ProtocolServer();
        protocolo.startServer(this);
        //Desactivamos la opción de reiniciar de nuevo el servidor, pues se acaba de reiniciar
        jMenuItem6.setEnabled(false);
        changeStatusBar("Hubo un PROBLEMA DE CONEXIÓN y el servidor se reinició, esperando un nuevo paciente...");
    }
    
    private boolean iniciaVideoConferencia()
    {
        // Creamos objeto de transmisión de video y audio.
	avt = new AVTransmitter(new javax.media.MediaLocator("vfw://"),
                new javax.media.MediaLocator("dsound://"),protocolo.getClientSocket().getInetAddress().getHostAddress(), "10004", null);
        String result = avt.start();
        //String result2=null;

	// result will be non-null if there was an error. The return
	// value is a String describing the possible error. Print it.
	if (result != null) {
	    System.err.println("Error de video: " + result);
            changeStatusBar("ERROR en la captura de video! Intente repararlo o inicie conferencia de voz");
	    return false;
	}
        /*if (result2 != null) {
	    System.err.println("Error de audio: " + result2);
            changeStatusBar("ERROR en la captura de audio!");
	    return false;
	}*/
	System.out.println("Empezamos la transmisión...");
        changeStatusBar("Transmitiendo video...");
        //capturandoVideo=true;
        protocolo.enviaWebcam();
        return true;
    }
    
    /**
     * Método auxiliar par escribir archivos de texto como logs en el disco duro
     *
     */
    private boolean escribeTexto(String texto,String fichero)
    {
        try
        {
            BufferedWriter out=new BufferedWriter(new OutputStreamWriter(new FileOutputStream(fichero)));
            out.write(texto);
            out.close();
            return true;
        }
        catch (FileNotFoundException e)
        {
            System.out.println("Archivo no encontrado\n"+e);
            return false;
        }
        catch (IOException ioe)
        {
            System.out.println("Error cerrando streams de escritura de fichero de texto");
            return false;
        }        
    }
    
    /**
     * Método auxiliar para leer desde archivos de texto en el disco duro
     *
     */
    private String leeTexto(String fichero)
    {   
        String temp,result="";
        try
        {
            BufferedReader in=new BufferedReader(new InputStreamReader(new FileInputStream(fichero)));
            temp=in.readLine();
            while (temp!=null)
            {
                result=result+temp+"\n";
                temp=in.readLine();
            }
        }
        catch (FileNotFoundException e)
        {
            //System.out.println("Archivo no encontrado:\n"+e);
        }
        catch (IOException ioe)
        {
            System.out.println("Error de entrada/salida en lectura de texto.");
        }        
        return result;
    }
    
    /**
     * Método que vacia todos los campos de texto, recordar revisarlo!
     */
    private void cleanFields()
    {
        jTextField1.setText(null);
        jTextField2.setText(null);
        jTextField3.setText(null);
        jTextField4.setText(null);
        jTextField5.setText(null);
        jTextField6.setText(null);
        jTextField7.setText(null);
        jTextField8.setText(null);
        jTextField9.setText(null);
        jTextField11.setText(null);
        jTextField12.setText(null);
        jTextField13.setText(null);
        jTextArea1.setText(null);
        jTextArea2.setText(null);
        jTextArea3.setText(null);
        jTextArea4.setText(null);
        jTextArea5.setText(null);
        jTextArea7.setText(null);
        jPasswordField1.setText(null);
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
     * Método para obtener cuál es usuario loggeado y su contraseña
     *
     */
    
    public String [] getUserPassword()
    {
        String [] aux={user,password};
        return aux;
    }
    
    /**
     * Método auxiliar para leer desde un archivo de configuración la lista de centros/especialistas con sus IP correspodientes
     * El archivo puede ser leido localmente o desde un archivo almacenado en un servidor. Este archivo debe tener en cada
     * línea el nombre del doctor o centro hospitalario, separado de la IP por el carácter ":". 
     *      Ejemplo:   Doctor Antonio - Homeopatía:192.168.0.2
     */
    
    private String[] leeDoctor(URL doctor)
    {   
        String temp,result="";
        int i=0;
        try
        {
            BufferedReader in=new BufferedReader(new InputStreamReader(doctor.openStream()));
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
            return null;
        }     
        String [] lineas=result.split("\n");             // Primero dividimos todo el texto recibido por líneas
        String [] datos=new String[4];
        for (int j=0;j<4;j++)                            //Después devolvemos el vector de string, eliminando la primera linea
        {
            datos[j]=lineas[j+1];
        }   
        return datos;
        
    }
    
   /**
    * Método para copiar dos ficheros
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
                new ServerIF().setVisible(true);
            }
        });
    }
    
     /*
     * #############   DECLARACIÓN DE VARIABLES DE NETBEANS, NO MODIFICAR ! ###########################
     *
     */
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.ButtonGroup buttonGroup2;
    private javax.swing.JButton jButton1;
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
    private javax.swing.JComboBox jComboBox3;
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
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel34;
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
    private javax.swing.JMenuItem jMenuItem5;
    private javax.swing.JMenuItem jMenuItem6;
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
    private javax.swing.JPasswordField jPasswordField1;
    private javax.swing.JRadioButton jRadioButton1;
    private javax.swing.JRadioButton jRadioButton2;
    private javax.swing.JRadioButton jRadioButton3;
    private javax.swing.JRadioButton jRadioButton4;
    private javax.swing.JRadioButton jRadioButton5;
    private javax.swing.JRadioButton jRadioButton6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane7;
    private javax.swing.JLabel jStatusBar;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JTextArea jTextArea2;
    private javax.swing.JTextArea jTextArea3;
    private javax.swing.JTextArea jTextArea4;
    private javax.swing.JTextArea jTextArea5;
    private javax.swing.JTextArea jTextArea7;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField10;
    private javax.swing.JTextField jTextField11;
    private javax.swing.JTextField jTextField12;
    private javax.swing.JTextField jTextField13;
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
