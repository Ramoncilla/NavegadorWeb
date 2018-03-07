/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto1_201122872.CHTML.BODY;
import java.awt.Color;

import java.awt.Font;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.font.TextAttribute;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.swing.SwingConstants;
import proyecto1_201122872.CHTML.ElemetoPropiedad.propiedad;
import proyecto1_201122872.CHTML.ElemetoPropiedad.propiedadAlineado;
import proyecto1_201122872.CHTML.ElemetoPropiedad.propiedadAlto;
import proyecto1_201122872.CHTML.ElemetoPropiedad.propiedadAncho;

import proyecto1_201122872.CHTML.ElemetoPropiedad.propiedadGrupo;
import proyecto1_201122872.CHTML.ElemetoPropiedad.propiedadId;
import proyecto1_201122872.CHTML.ElemetoPropiedad.propiedadRuta;
import proyecto1_201122872.CHTML.Etiqueta;
import proyecto1_201122872.CHTML.listaElementos;
import static proyecto1_201122872.Proyecto1_201122872.paginaActual;
/**
 *
 * @author Ramonella
 */
public class Enlace  extends Etiqueta implements MouseListener{
    
     public listaElementos elementosEnlace;
     public String cadenaEnlace;
    public labelComponente link;
     public String rutaEnlace;
     public List<String>funcionesClic;

     
    public Enlace(Object elementos , Object cadena){
        
        this.elementosEnlace = new listaElementos((ArrayList<propiedad>)elementos);
        this.cadenaEnlace= cadena.toString();  
        this.link = new labelComponente();
        this.alto=20;
        this.ancho=150;
        this.funcionesClic= new ArrayList<>();
         asignarRutaEnlace();
    }
   
    
    private void asignarRutaEnlace() {
            propiedadRuta elementoRuta = elementosEnlace.obtenerRuta();
            if (elementoRuta != null) {
                this.rutaEnlace = elementoRuta.ruta;
            }else{
                this.rutaEnlace="";
            }
        
    }

    @Override
    public Etiqueta retornarHtml() {
        agregarElementos();
       
        File f = new File(this.rutaEnlace);
        if (f.exists() && !f.isDirectory()) {
            link.setText(this.cadenaEnlace);
        
        } else {
             link.setText(this.cadenaEnlace);
            paginaActual.erroresPagina.insertarError("Semantico", "Ruta de Enlace no existe");

        }
        asignarElementos();
        link.setVisible(true);
        link.setSize(ancho, alto);
        link.setOpaque(true);
        link.setForeground(Color.BLUE);
        Font font = link.getFont();        
        Map attributes = font.getAttributes();
        attributes.put(TextAttribute.UNDERLINE, TextAttribute.UNDERLINE_ON);
        link.setFont(font.deriveFont(attributes));
        link.addMouseListener(this);
        return this;
    }

    
     @Override
    public void asignarElementos(){
         System.out.println("dfsdfdsfds");
           if(elementosEnlace.obtenerAlineado()!=null){
            propiedadAlineado n = elementosEnlace.obtenerAlineado();
            if(n.alineado.equalsIgnoreCase("derecha")){
                link.setHorizontalAlignment(SwingConstants.RIGHT);
            }else if(n.alineado.equalsIgnoreCase("izquierda")){
                link.setHorizontalAlignment(SwingConstants.LEFT);     
            }else if(n.alineado.equalsIgnoreCase("centrado")){
                link.setHorizontalAlignment(SwingConstants.CENTER);
            }
        }

        
        
    }
    
    
    @Override
    public void mouseClicked(MouseEvent e) {
         File f = new File(this.rutaEnlace);
        if (f.exists() && !f.isDirectory()) {
            

        }
        System.out.println("clic en enlace "+ this.cadenaEnlace);
    }

    @Override
    public void mousePressed(MouseEvent me) {
    }

    @Override
    public void mouseReleased(MouseEvent me) {
    }

    @Override
    public void mouseEntered(MouseEvent me) {
    }

    @Override
    public void mouseExited(MouseEvent me) {
    }
    
    
    
         @Override
    public void agregarElementos(){
        propiedad temporal;
        for (int i = 0; i < this.elementosEnlace.listadoElementos.size(); i++) {
            temporal = this.elementosEnlace.listadoElementos.get(i);
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
                
            }else if(temporal instanceof propiedadRuta){
                propiedadRuta p = (propiedadRuta)temporal;
                this.rutaEnlace= p.ruta.replace("\"", "");
                
            }
            
            
            
        }
    
    
}
}