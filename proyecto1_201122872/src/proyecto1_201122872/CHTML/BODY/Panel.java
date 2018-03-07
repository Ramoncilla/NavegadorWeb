/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto1_201122872.CHTML.BODY;
import java.awt.Color;
import java.awt.Dimension;
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
import javax.swing.SwingConstants;
import javax.swing.text.BadLocationException;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyledDocument;
import javax.swing.text.html.HTMLDocument;
import proyecto1_201122872.CHTML.ElemetoPropiedad.propiedad;
import proyecto1_201122872.CHTML.ElemetoPropiedad.propiedadAlineado;
import proyecto1_201122872.CHTML.ElemetoPropiedad.propiedadAlto;
import proyecto1_201122872.CHTML.ElemetoPropiedad.propiedadAncho;
import proyecto1_201122872.CHTML.ElemetoPropiedad.propiedadGrupo;
import proyecto1_201122872.CHTML.ElemetoPropiedad.propiedadId;
import proyecto1_201122872.CHTML.Etiqueta;
import proyecto1_201122872.CHTML.listaElementos;
import static proyecto1_201122872.Proyecto1_201122872.paginaActual;
/**
 *
 * @author Ramonella
 */
public class Panel extends Etiqueta  {

    public listaElementos elementosPanel;
    public Cuerpo objetosPanel;
    public jTextPane panel;
    public List<Etiqueta> etiquetasPanel;


    public Panel(Object elementos, Object cuerpo){
        etiquetasPanel = new ArrayList<>();
        this.elementosPanel= (listaElementos)elementos;
        this.objetosPanel= (Cuerpo)cuerpo;
        panel= new jTextPane();
        panel.setContentType("text/html");
    }


    @Override
    public Etiqueta retornarHtml() {
        agregarElementos(); 
        etiquetasPanel= objetosPanel.obtenerEtiquetasConElementos();
        asignarElementos();
        panel.setAutoscrolls(true);
        panel.setBackground(Color.MAGENTA);
        return this;
        
    }
    
    public jTextPane Dibujar(){
        
        Etiqueta temporal;
        for (int i = 0; i < this.etiquetasPanel.size(); i++) {
            temporal = this.etiquetasPanel.get(i);
            if(temporal instanceof Boton){
                JButton b= (JButton)((Boton) temporal).botonObjeto;
                 panel.setCaretPosition(panel.getStyledDocument().getLength());
                 panel.insertComponent(b);
            }else if(temporal instanceof Caja){
                JComboBox b= (JComboBox)((Caja) temporal).cajaOpciones;
                 panel.setCaretPosition(panel.getStyledDocument().getLength());
                 panel.insertComponent(b);
            }else if(temporal instanceof Enlace){
                JLabel b = (JLabel)((Enlace) temporal).link;
                 panel.setCaretPosition(panel.getStyledDocument().getLength());
                 panel.insertComponent(b);
            }else if(temporal instanceof Imagen){
                 JLabel b = (JLabel)((Imagen) temporal).imagen;
                 panel.setCaretPosition(panel.getStyledDocument().getLength());
                 panel.insertComponent(b);
            }else if(temporal instanceof Panel){
                 JTextPane b = (JTextPane)((Panel) temporal).Dibujar();
                 panel.setCaretPosition(panel.getStyledDocument().getLength());
                 panel.insertComponent(b);
            }else if(temporal instanceof Salto){
                try {
                        panel.setCaretPosition(panel.getStyledDocument().getLength());
                        HTMLDocument doc=(HTMLDocument) panel.getStyledDocument();
                        doc.insertAfterEnd(doc.getCharacterElement(doc.getLength()),"<br>");
                    } catch (BadLocationException ex) {
                        Logger.getLogger(Panel.class.getName()).log(Level.SEVERE, null, ex);
                    } catch (IOException ex) {
                        Logger.getLogger(Panel.class.getName()).log(Level.SEVERE, null, ex);
                    }
            }else if(temporal instanceof Spinner){
                JTextField b = (JTextField)((Spinner) temporal).spinner;
                panel.setCaretPosition(panel.getStyledDocument().getLength());
                 panel.insertComponent(b);
            }else if(temporal instanceof Texto){
                 JTextPane b = (JTextPane)((Texto) temporal).texto;
                 panel.setCaretPosition(panel.getStyledDocument().getLength());
                 panel.insertComponent(b);
            }else if(temporal instanceof Texto_a){
                JTextPane b = (JTextPane)((Texto_a) temporal).cajaTexto;
                 panel.setCaretPosition(panel.getStyledDocument().getLength());
                 panel.insertComponent(b);
            }else if(temporal instanceof caja_texto){
                JTextField b = (JTextField)((caja_texto) temporal).cajaTexto;
                panel.setCaretPosition(panel.getStyledDocument().getLength());
                 panel.insertComponent(b);
            }else if(temporal instanceof tabla){
                
            }    
        }
        return this.panel;
    }
      
     
      
      
    
    
    
    /*
    @Override
    public Etiqueta retornarHtml() {
        agregarElementos();
        
   
        List<Object> v = objetosPanel.ejecutarCuerpo();
        Etiqueta temporal;
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
        asignarElementos();
        panel.setAutoscrolls(true);

        panel.setBackground(Color.yellow);
        return panel;
    }

*/
     @Override
    public void asignarElementos(){
        
   
        panel.setSize(ancho, alto);
        if(this.elementosPanel.obtenerAlineado()!=null){
             propiedadAlineado n = elementosPanel.obtenerAlineado();
            if(n.alineado.equalsIgnoreCase("derecha")){              
                StyledDocument doc = panel.getStyledDocument();
                SimpleAttributeSet center = new SimpleAttributeSet();
                StyleConstants.setAlignment(center, StyleConstants.ALIGN_RIGHT);
                doc.setParagraphAttributes(0, doc.getLength(), center, false);     
            }else if(n.alineado.equalsIgnoreCase("izquierda")){
                StyledDocument doc = panel.getStyledDocument();
                SimpleAttributeSet center = new SimpleAttributeSet();
                StyleConstants.setAlignment(center, StyleConstants.ALIGN_LEFT);
                doc.setParagraphAttributes(0, doc.getLength(), center, false);    
            }else if(n.alineado.equalsIgnoreCase("centrado")){
                StyledDocument doc = panel.getStyledDocument();
                SimpleAttributeSet center = new SimpleAttributeSet();
                StyleConstants.setAlignment(center, StyleConstants.ALIGN_CENTER);
                doc.setParagraphAttributes(0, doc.getLength(), center, false); 
            }
        } else{
                StyledDocument doc = panel.getStyledDocument();
                SimpleAttributeSet center = new SimpleAttributeSet();
                StyleConstants.setAlignment(center, StyleConstants.ALIGN_LEFT);
                doc.setParagraphAttributes(0, doc.getLength(), center, false);  
        }
    }
    
    
    @Override
    public void agregarElementos(){
        propiedad temporal;
        for (int i = 0; i < this.elementosPanel.listadoElementos.size(); i++) {
            temporal = this.elementosPanel.listadoElementos.get(i);
            if(temporal instanceof  propiedadAlineado){
                propiedadAlineado p = (propiedadAlineado)temporal;
                if(!asignarAlineado(p.alineado)){
                    paginaActual.erroresPagina.insertarError("Semantico", "Elemento no valido para la alineacion del boton");
                }
            }else if(temporal instanceof propiedadId){
                 propiedadId p = (propiedadId)temporal;
                if(!asignarID(p.idElemento)){
                    paginaActual.erroresPagina.insertarError("Semantico", "Elemento no valido para la alineacion el ID de un boton");
                }
                
            }else if(temporal instanceof propiedadGrupo){
                propiedadGrupo p = (propiedadGrupo)temporal;
                if(!asignarGrupo(p.grupo)){
                    paginaActual.erroresPagina.insertarError("Semantico", "Elemento no valido para la alineacion el ID de un boton");
                }
                
            }else if(temporal instanceof propiedadAlto){
                propiedadAlto p = (propiedadAlto)temporal;
                if(!asignarAlto(p.alturaComponente)){
                  
                    paginaActual.erroresPagina.insertarError("Semantico", "Elemento no valido para la alineacion el ID de un boton");
                }
                
            }else if(temporal instanceof propiedadAncho){
                propiedadAncho p = (propiedadAncho)temporal;
                if(!asignarAncho(p.valorAncho)){
                    paginaActual.erroresPagina.insertarError("Semantico", "Elemento no valido para la alineacion el ID de un boton");
                }
                
            }
        }
    }







}
