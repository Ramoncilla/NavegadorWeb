/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto1_201122872.CHTML.BODY;
import java.awt.Color;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.text.BadLocationException;
import javax.swing.text.html.HTMLDocument;
import proyecto1_201122872.CHTML.Etiqueta;
import proyecto1_201122872.CHTML.listaElementos;
/**
 *
 * @author Ramonella
 */
public class Panel extends Etiqueta  {
    
    public listaElementos elementosPanel;
    public Cuerpo objetosPanel;
    private JTextPane panel;
    
    
    public Panel(Object elementos, Object cuerpo){
        this.elementosPanel= (listaElementos)elementos;
        this.objetosPanel= (Cuerpo)cuerpo;
        panel= new JTextPane();
        panel.setContentType("text/html");
    }

    @Override
    public Object retornarHtml() {
        
        List<Object> v = objetosPanel.ejecutarCuerpo();

            for (int i = 0; i < v.size(); i++) {
                if(v.get(i) instanceof JButton){
                    JButton j = (JButton)v.get(i);
                    panel.setCaretPosition(panel.getStyledDocument().getLength());
                    panel.insertComponent(j);
                  
                }else if(v.get(i) instanceof JTextField){
                    
                    JTextField j = (JTextField)v.get(i);
                    panel.setCaretPosition(panel.getStyledDocument().getLength());
                    panel.insertComponent(j);
                }else if(v.get(i) instanceof JTextArea){
                    JTextArea j = (JTextArea)v.get(i);
                    panel.setCaretPosition(panel.getStyledDocument().getLength());
                    panel.insertComponent(j);
                  
                }else if(v.get(i) instanceof Salto){
                    try {
                        panel.setCaretPosition(panel.getStyledDocument().getLength());
                        HTMLDocument doc=(HTMLDocument) panel.getStyledDocument();
                        doc.insertAfterEnd(doc.getCharacterElement(doc.getLength()),"<br>");
                    } catch (BadLocationException ex) {
                        Logger.getLogger(Panel.class.getName()).log(Level.SEVERE, null, ex);
                    } catch (IOException ex) {
                        Logger.getLogger(Panel.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }else if(v.get(i) instanceof JLabel){
                    JLabel j = (JLabel)v.get(i);
                    panel.setCaretPosition(panel.getStyledDocument().getLength());
                    panel.insertComponent(j);
                  
                }else if(v.get(i) instanceof Texto){
                    try {
                        Texto txt= (Texto)v.get(i);
                        HTMLDocument doc=(HTMLDocument) panel.getStyledDocument();
                        doc.insertAfterEnd(doc.getCharacterElement(doc.getLength()),txt.cadenaHTML);
                    } catch (BadLocationException ex) {
                        Logger.getLogger(Panel.class.getName()).log(Level.SEVERE, null, ex);
                    } catch (IOException ex) {
                        Logger.getLogger(Panel.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }else if(v.get(i) instanceof JComboBox){
                    JComboBox j = (JComboBox)v.get(i);
                    panel.setCaretPosition(panel.getStyledDocument().getLength());
                    panel.insertComponent(j);
                }else if(v.get(i) instanceof JTextPane){
                    JTextPane j = (JTextPane)v.get(i);
                    panel.setCaretPosition(panel.getStyledDocument().getLength());
                    panel.insertComponent(j);
                }
            }
  
        panel.setBackground(Color.yellow);
        return panel; 
    }
    
    
    
    
    
    
    
    
    
    
}
