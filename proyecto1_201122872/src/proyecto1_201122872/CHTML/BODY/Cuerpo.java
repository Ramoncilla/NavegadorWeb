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
import javax.swing.text.BadLocationException;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyledDocument;
import javax.swing.text.html.HTMLDocument;
import proyecto1_201122872.CHTML.ElemetoPropiedad.propiedad;
import proyecto1_201122872.CHTML.ElemetoPropiedad.propiedadAlineado;
import proyecto1_201122872.CHTML.ElemetoPropiedad.propiedadAlto;
import proyecto1_201122872.CHTML.ElemetoPropiedad.propiedadAncho;
import proyecto1_201122872.CHTML.ElemetoPropiedad.propiedadColorFondo;
import proyecto1_201122872.CHTML.ElemetoPropiedad.propiedadGrupo;
import proyecto1_201122872.CHTML.ElemetoPropiedad.propiedadId;
import proyecto1_201122872.CHTML.Etiqueta;
import proyecto1_201122872.CHTML.listaElementos;
import static proyecto1_201122872.Proyecto1_201122872.paginaActual;
/**
 *
 * @author Ramonella
 */
public class Cuerpo extends Etiqueta  {
    

    public List<Etiqueta> sentenciasCuerpo;
    public JTextPane panel;
    public List<Etiqueta> etiquetas;
    public String cadenaColor;
    
    public Cuerpo(Object elementos, Object etiquet){
        this.panel= new JTextPane();
        this.elementosEtiqueta = new listaElementos((ArrayList<propiedad>)elementos);
        this.sentenciasCuerpo = (ArrayList<Etiqueta>)etiquet;
        this.etiquetas= new ArrayList<>();
        panel.setContentType("text/html"); 
        this.cadenaColor="";
    }
    
    public void imprimir(){
        System.out.println(sentenciasCuerpo.size());
    }
    
    
    
    public List<Etiqueta> obtenerEtiquetasConElementos(){
        
        Etiqueta temporal;
        for (int i = 0; i< this.sentenciasCuerpo.size(); i++) {
            temporal = this.sentenciasCuerpo.get(i);
            if(temporal instanceof Boton){
                etiquetas.add(temporal.retornarHtml());
            }else if(temporal instanceof Caja){
                etiquetas.add(temporal.retornarHtml());
            }else if(temporal instanceof Enlace){
                etiquetas.add(temporal.retornarHtml());
            }else if(temporal instanceof Imagen){
                etiquetas.add(temporal.retornarHtml());
            }else if(temporal instanceof Panel){
                etiquetas.add(temporal.retornarHtml());
            }else if(temporal instanceof Salto){
                etiquetas.add(temporal.retornarHtml());
            }else if(temporal instanceof Spinner){
                etiquetas.add(temporal.retornarHtml());
            }else if(temporal instanceof Texto){
                etiquetas.add(temporal.retornarHtml());
            }else if(temporal instanceof Texto_a){
                etiquetas.add(temporal.retornarHtml());
            }else if(temporal instanceof caja_texto){
                etiquetas.add(temporal.retornarHtml());
            }else if(temporal instanceof tabla){
                etiquetas.add(temporal.retornarHtml());
            }
     
        }
        return etiquetas;
    }
    
   
    
     public Color getColor(String color){
     Color c =Color.GRAY ;
        try{
            c = (Color) Color.class.getField(color).get(null);
        }catch (Exception excep){
            c= Color.decode(color);
        }
     return c;
}
 
    
    
     @Override
    public void asignarElementos(){
        Dimension dmnsn = new Dimension(ancho, alto);
        
        panel.setSize(dmnsn);
        panel.setSize(ancho, alto);
        panel.setMaximumSize(dmnsn);
        panel.setMaximumSize(dmnsn);
        panel.setPreferredSize(dmnsn);
        if(!(cadenaColor.equalsIgnoreCase(""))){
            Color c = getColor(cadenaColor);
            panel.setBackground(c);
        }
        if(this.elementosEtiqueta.obtenerAlineado()!=null){
             propiedadAlineado n = elementosEtiqueta.obtenerAlineado();
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
        for (int i = 0; i < this.elementosEtiqueta.listadoElementos.size(); i++) {
            temporal = this.elementosEtiqueta.listadoElementos.get(i);
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
                
            }else if(temporal instanceof propiedadColorFondo){
                propiedadColorFondo p = (propiedadColorFondo)temporal;
                this.cadenaColor = p.cadenaColor;
                
            }
        }
    
    
    
    }
    
    
    
    
    
    
    
   /* public List<Object> dibujar(){
        List<Object> etiquetas = new ArrayList<>();
        
        Etiqueta temporal;
        for (int i = 0; i < sentenciasCuerpo.size(); i++) {
            temporal = sentenciasCuerpo.get(i);
            if(temporal.retornarHtml() instanceof JButton){
                etiquetas.add(temporal.retornarHtml());
            } else  if(temporal.retornarHtml() instanceof JTextArea){
                etiquetas.add(temporal.retornarHtml());
            } else  if(temporal.retornarHtml() instanceof JTextField){
                etiquetas.add(temporal.retornarHtml());
            } else if(temporal.retornarHtml() instanceof Salto){
                etiquetas.add(temporal.retornarHtml());
            }else if(temporal.retornarHtml() instanceof JLabel){
                etiquetas.add(temporal.retornarHtml());
            }else if(temporal.retornarHtml() instanceof Texto){
                etiquetas.add(temporal.retornarHtml());
            }else if(temporal.retornarHtml() instanceof JComboBox){
                etiquetas.add(temporal.retornarHtml());
            }else if(temporal.retornarHtml() instanceof JTextPane){
                etiquetas.add(temporal.retornarHtml());
            }   
        }
      return etiquetas;
    }
    */
    
}
