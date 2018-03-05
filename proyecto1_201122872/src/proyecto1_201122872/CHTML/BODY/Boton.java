/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto1_201122872.CHTML.BODY;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.SwingConstants;
import proyecto1_201122872.CHTML.ElemetoPropiedad.propiedad;
import proyecto1_201122872.CHTML.Etiqueta;
import proyecto1_201122872.CHTML.listaElementos;
import proyecto1_201122872.CHTML.ElemetoPropiedad.*;
import static proyecto1_201122872.Proyecto1_201122872.paginaActual;

/**
 *
 * @author Ramonella
 */
public class Boton extends Etiqueta implements ActionListener {
    
    public listaElementos elementosBoton;
    public String captionBoton;
    public String nombreFuncionClick;
    public botonComponente botonObjeto;
    
    public Boton(Object elementos, Object cadena){
        this.alto = 50;
        this.ancho=150;
        this.elementosBoton = new listaElementos((ArrayList<propiedad>)elementos);
        this.captionBoton = cadena.toString();
        botonObjeto= new botonComponente();
        botonObjeto.addActionListener(this);
        this.nombreFuncionClick="";
    }
     
    @Override
    public Etiqueta retornarHtml(){ 
        agregarElementos();
        asignarElementos();
        return this;
    }
    
    
    @Override
    public void actionPerformed(ActionEvent ae) {
        
        System.out.println("Di clic en el boton "+ this.captionBoton);
        
        
    }
    
    
    
    @Override
    public void asignarElementos(){
        this.botonObjeto.setText(this.captionBoton);
        botonObjeto.setSize(ancho, alto);
        if(elementosBoton.obtenerAlineado()!=null){
            propiedadAlineado n = elementosBoton.obtenerAlineado();
            if(n.alineado.equalsIgnoreCase("derecha")){
                botonObjeto.setHorizontalAlignment(SwingConstants.RIGHT);
            }else if(n.alineado.equalsIgnoreCase("izquierda")){
                botonObjeto.setHorizontalAlignment(SwingConstants.LEFT);     
            }else if(n.alineado.equalsIgnoreCase("centrado")){
                botonObjeto.setHorizontalAlignment(SwingConstants.CENTER);
            }
        }
    }
    
    
    @Override
    public void agregarElementos(){
        propiedad temporal;
        for (int i = 0; i < this.elementosBoton.listadoElementos.size(); i++) {
            temporal = this.elementosBoton.listadoElementos.get(i);
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
                
            }else if(temporal instanceof propiedadClick){
                propiedadClick p = (propiedadClick)temporal;
                this.nombreFuncionClick= p.nombreFuncion;
                
            }
        }
    }
    
    
    
    
    
}
