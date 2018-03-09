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
import java.awt.Dimension;
import java.awt.Font;
import java.util.ArrayList;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;
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
public class Spinner extends Etiqueta {


    public int numeroSpinner;
    public textFieldComponente spinner;

    public Spinner(Object elementos, Object cadena) {
        this.alto=50;
        this.ancho=50;
        this.elementosEtiqueta= new listaElementos((ArrayList<propiedad>) elementos);
        if(esNumero(cadena.toString())){
            this.numeroSpinner= Integer.parseInt(cadena.toString());
        }    else{
            this.numeroSpinner=0;
        }
        this.spinner= new textFieldComponente();
    }
    
    private boolean esNumero(String s) {
        return s != null && s.matches("[-+]?\\d*\\.?\\d+");
    }

    @Override
    public Etiqueta retornarHtml() {
        agregarElementos();
        asignarElementos();
        this.spinner.setText(String.valueOf(numeroSpinner));
       
        return this;
    }
    
 
    
    
      @Override
    public void asignarElementos(){
   
        spinner.setSize(ancho, alto);
        if(elementosEtiqueta.obtenerAlineado()!=null){
            propiedadAlineado n = elementosEtiqueta.obtenerAlineado();
            if(n.alineado.equalsIgnoreCase("derecha")){
                spinner.setHorizontalAlignment(SwingConstants.RIGHT);
            }else if(n.alineado.equalsIgnoreCase("izquierda")){
                spinner.setHorizontalAlignment(SwingConstants.LEFT);   
            }else if(n.alineado.equalsIgnoreCase("centrado")){
              spinner.setHorizontalAlignment(SwingConstants.CENTER);
            }
        }else{
            spinner.setHorizontalAlignment(SwingConstants.LEFT);
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
                
            }
        }
    }
     
 @Override
    public void agregarEstilo() {
        propiedad propTemporal;
        for (int i = 0; i < this.elementosEtiqueta.listadoElementos.size(); i++) {
            propTemporal = this.elementosEtiqueta.listadoElementos.get(i);

            if (propTemporal instanceof Alineado) {
                Alineado n = (Alineado) propTemporal;

                if (n.alineacion.equalsIgnoreCase("derecha")) {
                    spinner.setHorizontalAlignment(SwingConstants.RIGHT);
                } else if (n.alineacion.equalsIgnoreCase("izquierda")) {
                    spinner.setHorizontalAlignment(SwingConstants.LEFT);
                } else if (n.alineacion.equalsIgnoreCase("centrado")) {
                    spinner.setHorizontalAlignment(SwingConstants.CENTER);
                }
            }
                       
            if(propTemporal instanceof Visible){
                Visible v = (Visible)propTemporal;
                switch(v.getVisible().toUpperCase()){
                    case "VERDADERO":{
                        this.spinner.setVisible(true);
                        break;                       
                    }
                    case "FALSO":{
                        this.spinner.setVisible(false);
                        break;
                    }
                }
                
            }
           
            
            if(propTemporal instanceof Opaque){
               Opaque v = (Opaque)propTemporal;
                switch(v.getValorOpaque().toUpperCase()){
                    case "VERDADERO":{
                        this.spinner.setOpaque(true);
                        break;                       
                    }
                    case "FALSO":{
                        this.spinner.setOpaque(false);
                        break;
                    }
                } 
                
            }
            
          
            
            if(propTemporal instanceof Autoredimension){
                
            }
               
        }
        
        
       
       
      
         this.spinner.setSize(ancho, alto);
      
        
    }

}
