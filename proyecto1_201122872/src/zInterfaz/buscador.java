/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package zInterfaz;

import java.awt.Dimension;
import java.io.File;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTextPane;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import proyecto1_201122872.CHTML.BODY.jTextPane;
import static proyecto1_201122872.Proyecto1_201122872.paginaActual;

/**
 *
 * @author Ramonella
 */
public class buscador extends javax.swing.JFrame {
    
    public int contador; 
    public NavegadorWeb listaPaginas;
    
    /**
     * Creates new form buscador
     */
    public buscador() {
        initComponents();
        contador =0;
        listaPaginas= new NavegadorWeb();
        
        listener();
      
    }

    
    void listener(){
     
       ChangeListener changeListener = new ChangeListener() {
           @Override
           public void stateChanged(ChangeEvent ce) {
               System.out.println("Tab: " + jTabbedPane1.getSelectedIndex());
               int noPestana= jTabbedPane1.getSelectedIndex();
               
               for (int i = 0; i < listaPaginas.panelesPagina.size(); i++) {
                   if(i==noPestana){
                       paginaActual=listaPaginas.panelesPagina.get(i);
                       jTextField1.setText(paginaActual.rutaPagina);
                   }
               }
               
               
              // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
           }
    
    };
       
       
       
       
       
    jTabbedPane1.addChangeListener(changeListener);
        
    }
    
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        jToolBar1 = new javax.swing.JToolBar();
        btnAtras = new javax.swing.JButton();
        btnAdelante = new javax.swing.JButton();
        btnCargar = new javax.swing.JButton();
        jTextField1 = new javax.swing.JTextField();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jToolBar2 = new javax.swing.JToolBar();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("USAC-WEB");

        jPanel2.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jToolBar1.setRollover(true);

        btnAtras.setIcon(new javax.swing.ImageIcon("C:\\Users\\Ramonella\\Downloads\\left-arrow.png")); // NOI18N
        btnAtras.setFocusable(false);
        btnAtras.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnAtras.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnAtras.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAtrasActionPerformed(evt);
            }
        });
        jToolBar1.add(btnAtras);

        btnAdelante.setIcon(new javax.swing.ImageIcon("C:\\Users\\Ramonella\\Downloads\\right-arrow-forward.png")); // NOI18N
        btnAdelante.setFocusable(false);
        btnAdelante.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnAdelante.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnAdelante.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAdelanteActionPerformed(evt);
            }
        });
        jToolBar1.add(btnAdelante);

        btnCargar.setIcon(new javax.swing.ImageIcon("C:\\Users\\Ramonella\\Downloads\\reload.png")); // NOI18N
        btnCargar.setToolTipText("");
        btnCargar.setFocusable(false);
        btnCargar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnCargar.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnCargar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCargarActionPerformed(evt);
            }
        });
        jToolBar1.add(btnCargar);

        jTextField1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jTextField1.setText("C:\\Users\\Ramonella\\Documents\\Repositorios\\Proyecto1\\NavegadorWeb\\proyecto1_201122872\\ArchivosEntrada\\ejemplo2.chtml");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jToolBar1, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTextField1, javax.swing.GroupLayout.DEFAULT_SIZE, 1572, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTextField1)
            .addComponent(jToolBar1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jTabbedPane1.setAutoscrolls(true);

        jToolBar2.setRollover(true);

        jButton1.setIcon(new javax.swing.ImageIcon("C:\\Users\\Ramonella\\Downloads\\add.png")); // NOI18N
        jButton1.setFocusable(false);
        jButton1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton1.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jToolBar2.add(jButton1);

        jButton2.setIcon(new javax.swing.ImageIcon("C:\\Users\\Ramonella\\Downloads\\dark-eye.png")); // NOI18N
        jButton2.setToolTipText("");
        jButton2.setFocusable(false);
        jButton2.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton2.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jToolBar2.add(jButton2);

        jButton3.setIcon(new javax.swing.ImageIcon("C:\\Users\\Ramonella\\Downloads\\navigation-history-interface-symbol-of-a-clock-with-an-arrow.png")); // NOI18N
        jButton3.setFocusable(false);
        jButton3.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton3.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        jToolBar2.add(jButton3);

        jButton4.setIcon(new javax.swing.ImageIcon("C:\\Users\\Ramonella\\Downloads\\favorites.png")); // NOI18N
        jButton4.setFocusable(false);
        jButton4.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton4.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        jToolBar2.add(jButton4);

        jButton6.setIcon(new javax.swing.ImageIcon("C:\\Users\\Ramonella\\Downloads\\list.png")); // NOI18N
        jButton6.setFocusable(false);
        jButton6.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton6.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });
        jToolBar2.add(jButton6);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jTabbedPane1)
                    .addComponent(jToolBar2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jToolBar2, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 788, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(38, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed

        nuevaPagina();

    }//GEN-LAST:event_jButton1ActionPerformed

    private void btnCargarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCargarActionPerformed
        try {
            // TODO add your handling code here:
            String ruta= jTextField1.getText();
            CargarPagina(ruta);
        } catch (Exception ex) {
            Logger.getLogger(buscador.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnCargarActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        desplegarOpciones();
        
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
        listaPaginas.mostrarHistorial();
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // TODO add your handling code here:
        listaPaginas.agregarFavorito(paginaActual.rutaPagina);
        JOptionPane.showMessageDialog(null, "Favorito alamcenado correctamente", "USAC-WEB", JOptionPane.INFORMATION_MESSAGE);
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        // TODO add your handling code here:
        listaPaginas.mostrarFavoritos();
    }//GEN-LAST:event_jButton6ActionPerformed

    private void btnAtrasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAtrasActionPerformed
        // TODO add your handling code here:
        try{
            if(paginaActual.noBandera>0){
                String r;
                for (int i = 0; i < paginaActual.historialPagina.size(); i++) {
                    if(i==(paginaActual.noBandera-1)){
                        r= paginaActual.historialPagina.get(i);
                        CargarPagina(r); 
                    }
                        
                }
            
            }
            
            else
               JOptionPane.showMessageDialog(null,"Ya no hay mas paginas atras", "USAC-WEB", JOptionPane.INFORMATION_MESSAGE); 
            
        }catch(Exception e){
            
        }
        
        
    }//GEN-LAST:event_btnAtrasActionPerformed

    private void btnAdelanteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAdelanteActionPerformed
        // TODO add your handling code here:
             try{
            if(paginaActual.noBandera>0){
                String r;
                for (int i = 0; i < paginaActual.historialPagina.size(); i++) {
                    if(i==(paginaActual.noBandera+1)){
                        r= paginaActual.historialPagina.get(i);
                        CargarPagina(r); 
                    }
                        
                }
            
            }
            
            else
               JOptionPane.showMessageDialog(null,"Ya no hay mas paginas atras", "USAC-WEB", JOptionPane.INFORMATION_MESSAGE); 
            
        }catch(Exception e){
            
        }
        
    }//GEN-LAST:event_btnAdelanteActionPerformed

    
    
    public void desplegarOpciones(){
        
        int id = jTabbedPane1.getSelectedIndex();
        for (int i = 0; i < this.listaPaginas.panelesPagina.size(); i++) {
            if(id==this.listaPaginas.panelesPagina.get(i).idPagina){
                Opciones op = new Opciones();
                op.setPagina(listaPaginas.panelesPagina.get(i));
                op.cargarValores();
                op.setVisible(true);
            }
        }
        
        
    }
    
   public  void nuevaPagina(){
            Pagina nuevaPagina = new Pagina(contador);
            listaPaginas.agregarPagina(nuevaPagina);
            jTabbedPane1.add("Nueva "+contador, new JScrollPane(nuevaPagina.areaWeb));
            jTabbedPane1.setSelectedIndex(jTabbedPane1.getComponentCount()-1); 
            contador++;
       
    }
    
    
    public void CargarPagina(String ruta) throws Exception{
        
        File nuevo = new File(ruta);
        if(nuevo.exists() && !nuevo.isDirectory()){
            String nombrePagina = nuevo.getName();
            Pagina temporal;
            for (int i = 0; i < this.listaPaginas.panelesPagina.size(); i++) {
                temporal= this.listaPaginas.panelesPagina.get(i);
                if(temporal.idPagina==jTabbedPane1.getSelectedIndex()){
                    listaPaginas.panelesPagina.get(i).setNombrePagina(nombrePagina);
                    listaPaginas.panelesPagina.get(i).setRutaPagina(ruta);
                    String nombre=listaPaginas.panelesPagina.get(i).dibujarPagina();
                  jTabbedPane1.setTitleAt(jTabbedPane1.getSelectedIndex(), nombre);
                  listaPaginas.historialNavegador.add(ruta);
                  paginaActual.historialPagina.add(ruta);
                  paginaActual.noBandera++;
                }        
            }        
        }else{
            JOptionPane.showMessageDialog(null,"Error, ruta no valida.", "USAC-WEB", JOptionPane.INFORMATION_MESSAGE);
        }
        System.out.println("fdsfdsfd");
  
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
            java.util.logging.Logger.getLogger(buscador.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(buscador.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(buscador.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(buscador.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new buscador().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAdelante;
    private javax.swing.JButton btnAtras;
    private javax.swing.JButton btnCargar;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton6;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JToolBar jToolBar1;
    private javax.swing.JToolBar jToolBar2;
    // End of variables declaration//GEN-END:variables
}
