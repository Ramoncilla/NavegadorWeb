/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto1_201122872.CHTML.BODY;
import java.awt.Color;
import java.util.ArrayList;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyledDocument;
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
public class Texto_a extends Etiqueta{
    

        public String cadenaTexto;
        public jTextPane cajaTexto;
       
        
        
    public Texto_a(Object elementos , Object cadena){
        this.alto=300;
        this.ancho=300;
        this.elementosEtiqueta = new listaElementos((ArrayList<propiedad>)elementos);
        this.cadenaTexto= cadena.toString();  
        cajaTexto= new jTextPane();
    }

    @Override
    public Etiqueta retornarHtml() { 
        agregarElementos();
        asignarElementos();
        cajaTexto.setBackground(Color.orange);
           /*p = new JScrollPane(cajaTexto);
           p.setSize(cajaTexto.getPreferredSize());
           p.setVisible(true);*/
           
        return this;
    }
    
    

    
    
    @Override
    public void asignarElementos() {
        this.cajaTexto.setContentType("text/html");
        this.cajaTexto.setEditable(true);
        this.cajaTexto.setAutoscrolls(true);
        if(this.elementosEtiqueta.obtenerAlineado()!=null){
             propiedadAlineado n = elementosEtiqueta.obtenerAlineado();
            if(n.alineado.equalsIgnoreCase("derecha")){
                this.cajaTexto.setText(this.cadenaTexto);
                StyledDocument doc = cajaTexto.getStyledDocument();
                SimpleAttributeSet center = new SimpleAttributeSet();
                StyleConstants.setAlignment(center, StyleConstants.ALIGN_RIGHT);
                doc.setParagraphAttributes(0, doc.getLength(), center, false);     
            }else if(n.alineado.equalsIgnoreCase("izquierda")){
                this.cajaTexto.setText(this.cadenaTexto);
                StyledDocument doc = cajaTexto.getStyledDocument();
                SimpleAttributeSet center = new SimpleAttributeSet();
                StyleConstants.setAlignment(center, StyleConstants.ALIGN_LEFT);
                doc.setParagraphAttributes(0, doc.getLength(), center, false);    
            }else if(n.alineado.equalsIgnoreCase("centrado")){
                this.cajaTexto.setText(this.cadenaTexto);
                StyledDocument doc = cajaTexto.getStyledDocument();
                SimpleAttributeSet center = new SimpleAttributeSet();
                StyleConstants.setAlignment(center, StyleConstants.ALIGN_CENTER);
                doc.setParagraphAttributes(0, doc.getLength(), center, false); 
            }
        } else{
            this.cajaTexto.setText(this.cadenaTexto);
        }
         cajaTexto.setSize(ancho, alto);
    }

    @Override
    public void agregarElementos() {
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
                
            }
        }
    
    
    
    
    
    } 
    
}
