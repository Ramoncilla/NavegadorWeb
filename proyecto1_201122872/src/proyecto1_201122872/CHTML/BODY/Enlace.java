/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto1_201122872.CHTML.BODY;
import bCSS.Alineado;
import bCSS.Autoredimension;
import bCSS.Borde;
import bCSS.Colortext;
import bCSS.Fondoelemento;
import bCSS.Formato;
import bCSS.Letra;
import bCSS.Opaque;
import bCSS.Tamtex;
import bCSS.Visible;
import java.awt.Color;

import java.awt.Font;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.font.TextAttribute;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;
import proyecto1_201122872.CHTML.ElemetoPropiedad.propiedad;
import proyecto1_201122872.CHTML.ElemetoPropiedad.propiedadAlineado;
import proyecto1_201122872.CHTML.ElemetoPropiedad.propiedadAlto;
import proyecto1_201122872.CHTML.ElemetoPropiedad.propiedadAncho;
import proyecto1_201122872.CHTML.ElemetoPropiedad.propiedadClick;

import proyecto1_201122872.CHTML.ElemetoPropiedad.propiedadGrupo;
import proyecto1_201122872.CHTML.ElemetoPropiedad.propiedadId;
import proyecto1_201122872.CHTML.ElemetoPropiedad.propiedadRuta;
import proyecto1_201122872.CHTML.Etiqueta;
import proyecto1_201122872.CHTML.listaElementos;
import static proyecto1_201122872.Proyecto1_201122872.paginaActual;
import static proyecto1_201122872.Proyecto1_201122872.g;
/**
 *
 * @author Ramonella
 */
public class Enlace  extends Etiqueta implements MouseListener{
    

     public String cadenaEnlace;
    public labelComponente link;
     public String rutaEnlace;

     
    public Enlace(Object elementos , Object cadena){
        
        this.elementosEtiqueta = new listaElementos((ArrayList<propiedad>)elementos);
        this.cadenaEnlace= cadena.toString();  
        this.link = new labelComponente();
        this.alto=20;
        this.ancho=150;
         asignarRutaEnlace();
    }
   
    
    private void asignarRutaEnlace() {
            propiedadRuta elementoRuta = elementosEtiqueta.obtenerRuta();
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
           if(elementosEtiqueta.obtenerAlineado()!=null){
            propiedadAlineado n = elementosEtiqueta.obtenerAlineado();
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
           g.nuevaPagina();
         try {
             g.CargarPagina(this.rutaEnlace);
         } catch (Exception ex) {
             Logger.getLogger(Enlace.class.getName()).log(Level.SEVERE, null, ex);
         }
        }else{
            JOptionPane.showMessageDialog(null, "No se puede abrir la pagina, ruta no valida "+this.rutaEnlace, "USAC-WEB", JOptionPane.ERROR_MESSAGE);
        }
        //paginaActual.retCJS.observadores.buscarObservadorPorElemento(30, numeroIdentificador, 0, paginaActual.tabla);
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
                
            }else if(temporal instanceof propiedadRuta){
                propiedadRuta p = (propiedadRuta)temporal;
                this.rutaEnlace= p.ruta.replace("\"", "");
                
            }
            
            
            
        }
    
    
}
    
    
   
     @Override
    public void agregarEstilo(){
        boolean bandera = false;
        propiedad propTemporal;
        for (int i = 0; i < this.elementosEtiqueta.listadoElementos.size(); i++) {
            propTemporal = this.elementosEtiqueta.listadoElementos.get(i);
            
            if(propTemporal instanceof Alineado){
                Alineado a = (Alineado)propTemporal;
                switch(a.alineacion.toUpperCase()){
                    case "DERECHA":{
                        bandera=true;
                        this.link.setHorizontalAlignment(SwingConstants.RIGHT);
                        break;
                    }
                    case "CENTRADO":{
                        bandera=true;
                        this.link.setHorizontalAlignment(SwingConstants.CENTER);
                        break;
                    }
                    default:{
                        bandera=true;
                        this.link.setHorizontalAlignment(SwingConstants.LEFT);
                        break;
                    }
                }
            }
            if(propTemporal instanceof bCSS.Texto){
                bandera=true;
                bCSS.Texto t = (bCSS.Texto)propTemporal;
                this.cadenaEnlace=t.getTexto();
                this.link.setText(t.getTexto());
                
            }
            
            if(propTemporal instanceof Fondoelemento){
                bandera=true;
                Fondoelemento f = (Fondoelemento)propTemporal;
                Color c = getColor(f.getCadenaColor());
                this.link.setBackground(c);
            }
            
            if(propTemporal instanceof Visible){
                
                Visible v = (Visible)propTemporal;
                switch(v.getVisible().toUpperCase()){
                    case "VERDADERO":{
                        bandera=true;
                        this.link.setVisible(true);
                        break;                       
                    }
                    case "FALSO":{
                        bandera=true;
                        this.link.setVisible(false);
                        break;
                    }
                }
                
            }
            if(propTemporal instanceof Borde){
                bandera=true;
                Borde b = (Borde)propTemporal;
                Color c = getColor(b.getVcolor());
                double tam = b.getVsize();
                boolean curva= b.getVcurva().equalsIgnoreCase("verdadero");
                int j = (int)tam;
                LineBorder l = new LineBorder(c,j,curva);
                this.link.setBorder(l);
            }
            
            if(propTemporal instanceof Opaque){
                bandera=true;
               Opaque v = (Opaque)propTemporal;
                switch(v.getValorOpaque().toUpperCase()){
                    case "VERDADERO":{
                        this.link.setOpaque(true);
                        break;                       
                    }
                    case "FALSO":{
                        this.link.setOpaque(false);
                        break;
                    }
                } 
                
            }
            
            if(propTemporal instanceof Colortext){
                bandera=true;
                Colortext c = (Colortext)propTemporal;
                Color j = getColor(c.getCadenaColor());
                this.link.setForeground(j);
                
            }
            
            if(propTemporal instanceof Autoredimension){
                
            }
               
        }
        
        
        Formato form = this.elementosEtiqueta.obtenerFormato();
        Tamtex siz= this.elementosEtiqueta.obtenerTamtex();
        Letra let= this.elementosEtiqueta.obtenerLetra();
        String fuente="";
        int letra = Font.PLAIN;
        int noTipoLetra =0;
        int tamLetra =12;
        if(form!=null){
            String g;
            for (int i = 0; i < form.listaFormatos.size(); i++) {
                g=form.listaFormatos.get(i);
                if(g.equalsIgnoreCase("negrita"))
                    letra+=Font.BOLD;
                if(g.equalsIgnoreCase("cursiva"))
                    letra+=Font.ITALIC;
                if(g.equalsIgnoreCase("mayuscula"))
                    noTipoLetra=1;
                if(g.equalsIgnoreCase("minuscula"))
                    noTipoLetra=2;
                if(g.equalsIgnoreCase("capital-t"))
                    noTipoLetra=3;
                
            }
        }
         if(siz!=null){
             tamLetra=(int)siz.getValorTamanho();
             bandera=true;}
         
         if(let!=null){
             fuente=let.getFuente();
             bandera=true;}
         
         if(noTipoLetra==1){
             bandera=true;
             String l = this.link.getText();
             this.link.setText(l.toUpperCase());
         }
         
          if(noTipoLetra==2){
              bandera=true;
             String l = this.link.getText();
             this.link.setText(l.toLowerCase());
         }
          
        if (noTipoLetra == 3) {
            bandera=true;
            String l = this.link.getText();
            String a = l.toLowerCase();
            char[] caracteres = a.toCharArray();
            caracteres[0] = Character.toUpperCase(caracteres[0]);
            for (int i = 0; i < a.length() - 2; i++) {
                if (caracteres[i] == ' ' || Character.isSpaceChar(caracteres[i])) {
                    caracteres[i + 1] = Character.toUpperCase(caracteres[i + 1]);
                }
            }
            String h = new String(caracteres);
            this.link.setText(h);
        }
         
         Font fNueva = new Font(fuente,letra,tamLetra);
         this.link.setFont(fNueva);
         this.link.setSize(ancho, alto);
         if(bandera)
         {
             paginaActual.retCJS.observadores.buscarObservadorPorElemento(20, numeroIdentificador, 0, paginaActual.tabla);
         }        
    }
    
    
    
    
}