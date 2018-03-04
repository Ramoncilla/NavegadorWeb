/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto1_201122872;

import CJS.TablaSimbolos.tablaSimbolos;
import CJS.objetoBase;
import Funciones.Funcion;
import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.LayoutManager;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.scene.control.Button;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.text.BadLocationException;
import javax.swing.text.DefaultStyledDocument;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.Style;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyledDocument;
import javax.swing.text.html.HTMLDocument;
import javax.swing.text.html.HTMLEditorKit;
import proyecto1_201122872.AnalizadorCHTML.Parser;
import proyecto1_201122872.AnalizadorCHTML.scannerCHTML;
import proyecto1_201122872.AnalizadorCJS.ParserPrimera;
import proyecto1_201122872.AnalizadorCJS.scannerCJS;
import proyecto1_201122872.CHTML.BODY.Salto;
import proyecto1_201122872.CHTML.BODY.Texto;
import proyecto1_201122872.CHTML.Chtml;
import static proyecto1_201122872.Proyecto1_201122872.erroresEjecucion;
import static proyecto1_201122872.Proyecto1_201122872.cadenaImpresion;
import static proyecto1_201122872.Proyecto1_201122872.lFunciones;

/**
 *
 * @author Ramonella
 */
public class Navegador extends javax.swing.JFrame {

    /**
     * Creates new form Navegador
     */
    public Navegador() {
        initComponents();
       
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTextField1 = new javax.swing.JTextField();
        jToolBar1 = new javax.swing.JToolBar();
        jButton2 = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextPane1 = new javax.swing.JTextPane();
        jPanel2 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jTabbedPane2 = new javax.swing.JTabbedPane();
        jPanel4 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTextPane2 = new javax.swing.JTextPane();
        jPanel5 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTextPane3 = new javax.swing.JTextPane();
        jPanel6 = new javax.swing.JPanel();
        jScrollPane4 = new javax.swing.JScrollPane();
        jTextPane4 = new javax.swing.JTextPane();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        jTextField1.setText("C:\\Users\\Ramonella\\Documents\\Repositorios\\Proyecto1\\NavegadorWeb\\proyecto1_201122872\\ArchivosEntrada\\ejemplo.chtml");

        jToolBar1.setRollover(true);

        jButton2.setText("Cargar");
        jButton2.setFocusable(false);
        jButton2.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton2.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jToolBar1.add(jButton2);

        jButton1.setText("Nueva");
        jButton1.setFocusable(false);
        jButton1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton1.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        jButton1.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jToolBar1.add(jButton1);

        jButton3.setText("CJS");
        jButton3.setFocusable(false);
        jButton3.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton3.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        jToolBar1.add(jButton3);

        jButton4.setText("jButton4");
        jButton4.setFocusable(false);
        jButton4.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton4.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        jToolBar1.add(jButton4);

        jButton5.setText("jButton5");
        jButton5.setFocusable(false);
        jButton5.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton5.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });
        jToolBar1.add(jButton5);

        jScrollPane1.setViewportView(jTextPane1);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 1434, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(193, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 404, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 72, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("tab1", jPanel1);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1639, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 476, Short.MAX_VALUE)
        );

        jTabbedPane1.addTab("tab2", jPanel2);

        jScrollPane2.setViewportView(jTextPane2);

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 1466, Short.MAX_VALUE)
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 197, Short.MAX_VALUE)
        );

        jTabbedPane2.addTab("Consola de Salida", jPanel4);

        jScrollPane3.setViewportView(jTextPane3);

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 1466, Short.MAX_VALUE)
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 197, Short.MAX_VALUE)
        );

        jTabbedPane2.addTab("Errores", jPanel5);

        jScrollPane4.setViewportView(jTextPane4);

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 1442, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 206, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jTabbedPane2.addTab("Tabla de Simbolos", jPanel6);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTabbedPane2)
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jTabbedPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 227, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jTextField1)
                    .addComponent(jToolBar1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jTabbedPane1, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jToolBar1, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 506, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(139, 139, 139)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(83, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
         try {
            // TODO add your handling code here:
            
            ejecutar();

        } catch (Exception ex) {
            Logger.getLogger(Navegador.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
        
        try {
            // TODO add your handling code here:
            ejecutarCJS();
        } catch (Exception ex) {
            Logger.getLogger(Navegador.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        prueba();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        try {
            // TODO add your handling code here:
            
            jTextPane1.setContentType("text/html");
            HTMLDocument doc=(HTMLDocument) jTextPane1.getStyledDocument();
             JButton j = new JButton("boton1");
                    JLabel l= new JLabel("soy un label");
                    
            String tabla="<table border=1>\n" +
                    "  <tr>\n" +
                    "    <th>Company</th>\n" +
                    "    <th>Contact</th>\n" +
                    "    <th>Country</th>\n" +
                    "  </tr>\n" +
                    "  <tr>\n" +
                    "    <td>Alfreds Futterkiste</td>\n" +
                    "    <td>Maria Anders</td>\n" +
                    "    <td>Germany</td>\n" +
                    "  </tr>\n"+
                    "  <tr>\n" +
                    "    <td>";
            doc.insertAfterEnd(doc.getCharacterElement(doc.getLength()),tabla);
            jTextPane1.setCaretPosition(jTextPane1.getStyledDocument().getLength());
            jTextPane1.insertComponent(j);
            doc.insertAfterEnd(doc.getCharacterElement(doc.getLength()),tabla);
            tabla="</td>\n" +
                    "    <td>";
            
            jTextPane1.setCaretPosition(jTextPane1.getStyledDocument().getLength());
            jTextPane1.insertComponent(l);
            doc.insertAfterEnd(doc.getCharacterElement(doc.getLength()),tabla);
            tabla="</td>\n" +
                    "    <td>Mexico</td>\n" +
                    "  </tr>\n" +
                    "  <tr>\n" +
                    "    <td>Ernst Handel</td>\n" +
                    "    <td>Roland Mendel</td>\n" +
                    "    <td>Austria</td>\n" +
                    "  </tr>\n" +
                    "</table>";
                    
doc.insertAfterEnd(doc.getCharacterElement(doc.getLength()),tabla);
                   
        } catch (BadLocationException ex) {
            Logger.getLogger(Navegador.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Navegador.class.getName()).log(Level.SEVERE, null, ex);
        }
                  
             
                    
               
            
        
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        // TODO add your handling code here:
        
     JPanel pn = new JPanel();
      JPanel pn2 = new JPanel();
       JPanel pn3 = new JPanel();
     List<JPanel> l= new ArrayList<>();
     l.add(pn);
      l.add(pn2);
       l.add(pn3);
         JButton aButton = new JButton();
         aButton.setVisible(true);
         aButton.setBounds(1000, 150, 0, 0);
        jPanel2.add(aButton);
        for (int i = 0; i < l.size(); i++) {
           jTabbedPane1.addTab("nueva "+i, l.get(i)); 
        }
       
    }//GEN-LAST:event_jButton5ActionPerformed


    
     private void ejecutarCJS() throws Exception{
        String rutaArchivo = jTextField1.getText();
        int a= 1;
        int b = a+++1;
        
        if(rutaArchivo.isEmpty()){
            System.out.println("Direccion no valida");
            return;
        }else{
          LectoArchivos lector = new LectoArchivos(rutaArchivo);
        String cadena=lector.obtenerContenidoArchivo();
        if(cadena.isEmpty()){
            System.out.println(" No es posible evaluar una cadena vacia");
            return;
        }else{
            System.out.println("Inicio de Analisis");
            
           
            scannerCJS scannerjs = new scannerCJS(new BufferedReader(new StringReader(cadena)));
            proyecto1_201122872.AnalizadorCJS.Parser parserCJS = new proyecto1_201122872.AnalizadorCJS.Parser(scannerjs);
            ParserPrimera pPrimera = new ParserPrimera(scannerjs);
            //pPrimera.parse();
            parserCJS.parse();
            
            
            objetoBase g= parserCJS.raiz;
           
            List<objetoBase> h = (ArrayList<objetoBase>)parserCJS.listaSentencias;
            tablaSimbolos tabla = new tablaSimbolos();
            objetoBase temporal; 
            Object v ;
            List<objetoBase> sentencias= new ArrayList<>();
            for (int i = 0; i < h.size(); i++) {
                temporal = h.get(i);
                
                if(temporal instanceof Funcion){
                    lFunciones.insertarFuncion((Funcion) temporal);
                }else{
                    sentencias.add(temporal);
                }
                
                
            }
            
             for (int i = 0; i < sentencias.size(); i++) {
                temporal = sentencias.get(i);
                
               v= temporal.Ejecutar(tabla, 0);
                
                
            }
            
            
            //Object v= g.Ejecutar(tabla, 0);
            /*
            System.out.println(g.Ejecutar().ValorRetorno);
           */
            jTextPane2.setContentType("text/html");
           jTextPane2.setText(cadenaImpresion);
            
           jTextPane3.setContentType("text/html");
           jTextPane3.setText(erroresEjecucion.getErroresHTML());
  
             jTextPane4.setContentType("text/html");
          jTextPane4.setText(tabla.imprimirHTML());
            
           System.out.println("Fin de analisis");  
        }  
        }
        
        
    }
    
    
    
    
    private void ejecutar() throws Exception{
        String rutaArchivo = jTextField1.getText();
        int a= 1;
        int b = a+++1;
        
        if(rutaArchivo.isEmpty()){
            System.out.println("Direccion no valida");
            return;
        }else{
          LectoArchivos lector = new LectoArchivos(rutaArchivo);
        String cadena=lector.obtenerContenidoArchivo();
        if(cadena.isEmpty()){
            System.out.println(" No es posible evaluar una cadena vacia");
            return;
        }else{
            System.out.println("Inicio de Analisis");
            scannerCHTML scannerHtml = new scannerCHTML(new BufferedReader(new StringReader(cadena)));
            Parser parserHtml = new Parser(scannerHtml);
            parserHtml.parse();
            
            Chtml  etiquet= parserHtml.codigoHTML;
            etiquet.body.imprimir();
            jTextPane1.setContentType("text/html");
            List<Object> v = (ArrayList<Object>)etiquet.body.ejecutarCuerpo();
            for (int i = 0; i < v.size(); i++) {
                if(v.get(i) instanceof JButton){
                    JButton j = (JButton) v.get(i);
                    
                  
                   jTextPane1.setCaretPosition(jTextPane1.getStyledDocument().getLength());
                    jTextPane1.insertComponent(j);
                }else if(v.get(i) instanceof JTextField){
                    JTextField j = (JTextField)v.get(i);
                    jTextPane1.setCaretPosition(jTextPane1.getStyledDocument().getLength());
                    jTextPane1.insertComponent(j);
                }else if(v.get(i) instanceof JTextArea){
                    JTextArea j = (JTextArea)v.get(i);
                    jTextPane1.setCaretPosition(jTextPane1.getStyledDocument().getLength());
                    jTextPane1.insertComponent(j);
                }else if(v.get(i) instanceof Salto){
                    jTextPane1.setCaretPosition(jTextPane1.getStyledDocument().getLength());
                    HTMLDocument doc=(HTMLDocument) jTextPane1.getStyledDocument();
                    doc.insertAfterEnd(doc.getCharacterElement(doc.getLength()),"<br>");
                                       
                   /*StyledDocument doc = jTextPane1.getStyledDocument();

                    //  Define a keyword attribute

                    SimpleAttributeSet keyWord = new SimpleAttributeSet();
                    StyleConstants.setForeground(keyWord, Color.RED);
                    StyleConstants.setBackground(keyWord, Color.YELLOW);
                    StyleConstants.setBold(keyWord, true);

                    //  Add some text

                    try
                    {
                        
                        doc.insertString(doc.getLength(), "\n",null);
                    }
                    catch(Exception e) { System.out.println(e); }*/
 
                }else if(v.get(i) instanceof JLabel){
                    JLabel j = (JLabel)v.get(i);
                    jTextPane1.setCaretPosition(jTextPane1.getStyledDocument().getLength());
                    jTextPane1.insertComponent(j);
                  
                }/*else if(v.get(i) instanceof Texto){
                    Texto txt= (Texto)v.get(i);
                    HTMLDocument doc=(HTMLDocument) jTextPane1.getStyledDocument();
                    doc.insertAfterEnd(doc.getCharacterElement(doc.getLength()),txt.cadenaHTML);
                }*/else if(v.get(i) instanceof JComboBox){
                    JComboBox j = (JComboBox)v.get(i);
                    jTextPane1.setCaretPosition(jTextPane1.getStyledDocument().getLength());
                    jTextPane1.insertComponent(j);
                }else if(v.get(i) instanceof JTextPane){
                    JTextPane j = (JTextPane)v.get(i);
                    jTextPane1.setCaretPosition(jTextPane1.getStyledDocument().getLength());
                    jTextPane1.insertComponent(j);
                 }else if(v.get(i) instanceof JScrollPane){
                    JScrollPane j = (JScrollPane)v.get(i);
                    jTextPane1.setCaretPosition(jTextPane1.getStyledDocument().getLength());
                    jTextPane1.insertComponent(j);
                }
            }
  
            
            
           System.out.println("Fin de analisis");  
        }  
        }
        
        
    }
    
    
    
    
     private void ejecutar2() throws Exception{
         jPanel2= new JPanel(new GridLayout(4,4,4,4));
        String rutaArchivo = jTextField1.getText();
        int a= 1;
        int b = a+++1;
        
        if(rutaArchivo.isEmpty()){
            System.out.println("Direccion no valida");
            return;
        }else{
          LectoArchivos lector = new LectoArchivos(rutaArchivo);
        String cadena=lector.obtenerContenidoArchivo();
        if(cadena.isEmpty()){
            System.out.println(" No es posible evaluar una cadena vacia");
            return;
        }else{
            System.out.println("Inicio de Analisis");
            scannerCHTML scannerHtml = new scannerCHTML(new BufferedReader(new StringReader(cadena)));
            Parser parserHtml = new Parser(scannerHtml);
            parserHtml.parse();
            
            Chtml  etiquet= parserHtml.codigoHTML;
            etiquet.body.imprimir();
           
            List<Object> v = (ArrayList<Object>)etiquet.body.ejecutarCuerpo();
            for (int i = 0; i < v.size(); i++) {
                if(v.get(i) instanceof JButton){
                    JButton j = (JButton) v.get(i);
                    Dimension f= j.getPreferredSize();
                    j.setBounds(f.width, f.height, 30, 40);
                    jPanel2.add(j);

                   
                }else if(v.get(i) instanceof JTextField){
                    JTextField j = (JTextField)v.get(i);
                   Dimension f= j.getPreferredSize();
                    j.setBounds(f.height, f.width, 60, 90);
                    jPanel2.add(j);
                    //jTextPane1.setCaretPosition(jTextPane1.getStyledDocument().getLength());
                  //  jTextPane1.insertComponent(j);
                }else if(v.get(i) instanceof JTextArea){
                    JTextArea j = (JTextArea)v.get(i);
                    jTextPane1.setCaretPosition(jTextPane1.getStyledDocument().getLength());
                    jPanel2.add(j);
                }else if(v.get(i) instanceof Salto){
                    //jTextPane1.setCaretPosition(jTextPane1.getStyledDocument().getLength());
                    //HTMLDocument doc=(HTMLDocument) jTextPane1.getStyledDocument();
                    //doc.insertAfterEnd(doc.getCharacterElement(doc.getLength()),"<br>");
                                       
                   /*StyledDocument doc = jTextPane1.getStyledDocument();

                    //  Define a keyword attribute

                    SimpleAttributeSet keyWord = new SimpleAttributeSet();
                    StyleConstants.setForeground(keyWord, Color.RED);
                    StyleConstants.setBackground(keyWord, Color.YELLOW);
                    StyleConstants.setBold(keyWord, true);

                    //  Add some text

                    try
                    {
                        
                        doc.insertString(doc.getLength(), "\n",null);
                    }
                    catch(Exception e) { System.out.println(e); }*/
 
                }else if(v.get(i) instanceof JLabel){
                    JLabel j = (JLabel)v.get(i);
                    jPanel2.add(j);

                  
                }else if(v.get(i) instanceof Texto){
                    Texto txt= (Texto)v.get(i);
                    

                }else if(v.get(i) instanceof JComboBox){
                    JComboBox j = (JComboBox)v.get(i);
                    jPanel2.add(j);

                }else if(v.get(i) instanceof JTextPane){
                    JTextPane j = (JTextPane)v.get(i);
                    jPanel2.add(j);

                }
            }
  
            
            
           System.out.println("Fin de analisis");  
        }  
        }
        
        
    }
    
    
    
    
    
    private void prueba(){
        jTextPane1.setContentType("text/html");
        jTextPane1.setText(
"<b>hola</b><br>" + "<i>adios</i><br>" +
"<font face=\"arial\">fuente arial</font><br>" +
"<font face=\"courier\">fuente courier</font><br>" +
"<font size=\"24\">fuente grande</font><br>" +
"<font color=\"red\">color rojo</font><br>" +
"<img  align=\"center\"; src=\"file:d:/viejo.gif\"></img>");
        
        jTextPane1.setCaretPosition(jTextPane1.getStyledDocument().getLength());

// insertamos un JButton
JButton boton = new JButton("Pulsame");
jTextPane1.insertComponent(boton);
    }
    
    
    
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Navegador.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Navegador.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Navegador.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Navegador.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Navegador().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTabbedPane jTabbedPane2;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextPane jTextPane1;
    private javax.swing.JTextPane jTextPane2;
    private javax.swing.JTextPane jTextPane3;
    private javax.swing.JTextPane jTextPane4;
    private javax.swing.JToolBar jToolBar1;
    // End of variables declaration//GEN-END:variables
}
