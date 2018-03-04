/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto1_201122872.CHTML.BODY;
import java.util.ArrayList;
import javax.swing.SwingConstants;

import proyecto1_201122872.CHTML.ElemetoPropiedad.propiedad;
import proyecto1_201122872.CHTML.ElemetoPropiedad.propiedadAlineado;
import proyecto1_201122872.CHTML.ElemetoPropiedad.propiedadAlto;
import proyecto1_201122872.CHTML.ElemetoPropiedad.propiedadAncho;
import proyecto1_201122872.CHTML.ElemetoPropiedad.propiedadGrupo;
import proyecto1_201122872.CHTML.ElemetoPropiedad.propiedadId;
import proyecto1_201122872.CHTML.Etiqueta;
import proyecto1_201122872.CHTML.listaElementos;
import static proyecto1_201122872.Proyecto1_201122872.erroresEjecucion;
/**
 *
 * @author Ramonella
 */
public class Texto extends Etiqueta{
    
    //texto normal en html
    
    public listaElementos elementosTexto;
    public String cadenaTexto;
    public jTextPane texto;

    
    public Texto(Object elementos , Object cadena){
        this.alto=150;
        this.ancho=150;
        this.texto= new jTextPane();
        this.elementosTexto = new listaElementos((ArrayList<propiedad>)elementos);
        this.cadenaTexto= cadena.toString();
        
    }
    
       @Override
    public Object retornarHtml(){
        agregarElementos();
        asignarElementos();
        return texto;
       
    }
    
    @Override
    public void asignarElementos() {
        this.texto.setContentType("text/html");
        this.texto.setEditable(false);
        this.texto.setAutoscrolls(true);
        if(this.elementosTexto.obtenerAlineado()!=null){
             propiedadAlineado n = elementosTexto.obtenerAlineado();
            if(n.alineado.equalsIgnoreCase("derecha")){
                this.texto.setText("<html><body><right>"+this.cadenaTexto+"</right></body></html>");
                
            }else if(n.alineado.equalsIgnoreCase("izquierda")){
                this.texto.setText("<html><body><left>"+this.cadenaTexto+"</left></body></html>");   
            }else if(n.alineado.equalsIgnoreCase("centrado")){
                this.texto.setText("<html><body><center>"+this.cadenaTexto+"</center></body></html>");
            }
        } else{
            this.texto.setText(this.cadenaTexto);
        }
         texto.setSize(ancho, alto);
    }

    @Override
    public void agregarElementos() {
     propiedad temporal;
        for (int i = 0; i < this.elementosTexto.listadoElementos.size(); i++) {
            temporal = this.elementosTexto.listadoElementos.get(i);
            if(temporal instanceof  propiedadAlineado){
                propiedadAlineado p = (propiedadAlineado)temporal;
                if(!asignarAlineado(p.alineado)){
                    erroresEjecucion.insertarError("Semantico", "Elemento no valido para la alineacion del boton");
                }
            }else if(temporal instanceof propiedadId){
                 propiedadId p = (propiedadId)temporal;
                if(!asignarID(p.idElemento)){
                    erroresEjecucion.insertarError("Semantico", "Elemento no valido para la alineacion el ID de un boton");
                }
                
            }else if(temporal instanceof propiedadGrupo){
                propiedadGrupo p = (propiedadGrupo)temporal;
                if(!asignarGrupo(p.grupo)){
                    erroresEjecucion.insertarError("Semantico", "Elemento no valido para la alineacion el ID de un boton");
                }
                
            }else if(temporal instanceof propiedadAlto){
                propiedadAlto p = (propiedadAlto)temporal;
                if(!asignarAlto(p.alturaComponente)){
                  
                    erroresEjecucion.insertarError("Semantico", "Elemento no valido para la alineacion el ID de un boton");
                }
                
            }else if(temporal instanceof propiedadAncho){
                propiedadAncho p = (propiedadAncho)temporal;
                if(!asignarAncho(p.valorAncho)){
                    erroresEjecucion.insertarError("Semantico", "Elemento no valido para la alineacion el ID de un boton");
                }
                
            }
        }
    
    }
        
        
        
        
    
    
    
    
    
    
    
    
}
