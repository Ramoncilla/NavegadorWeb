/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto1_201122872.CHTML.BODY;
import java.util.ArrayList;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import proyecto1_201122872.CHTML.ElemetoPropiedad.propiedad;
import proyecto1_201122872.CHTML.ElemetoPropiedad.propiedadAlineado;
import proyecto1_201122872.CHTML.ElemetoPropiedad.propiedadAlto;
import proyecto1_201122872.CHTML.ElemetoPropiedad.propiedadAncho;
import proyecto1_201122872.CHTML.ElemetoPropiedad.propiedadClick;
import proyecto1_201122872.CHTML.ElemetoPropiedad.propiedadGrupo;
import proyecto1_201122872.CHTML.ElemetoPropiedad.propiedadId;
import proyecto1_201122872.CHTML.Etiqueta;
import proyecto1_201122872.CHTML.listaElementos;
import static proyecto1_201122872.Proyecto1_201122872.erroresEjecucion;
/**
 *
 * @author Ramonella
 */
public class caja_texto extends Etiqueta {
    
     public listaElementos elementosCaja_texto;
     public String cadenaCaja_texto;
     public textFieldComponente cajaTexto;
    
    public caja_texto(Object elementos , Object cadena){
        this.elementosCaja_texto = new listaElementos((ArrayList<propiedad>)elementos);
        this.cadenaCaja_texto= cadena.toString();  
        this.cajaTexto= new textFieldComponente();
        this.alto=50;
        this.ancho=150;
    }

    @Override
    public Object retornarHtml() {
       agregarElementos();
       asignarElementos();
        this.cajaTexto.setText(cadenaCaja_texto.replace("\n", " "));
        
        return cajaTexto;
    }
    
      @Override
    public void asignarElementos(){
   
        cajaTexto.setSize(ancho, alto);
        if(elementosCaja_texto.obtenerAlineado()!=null){
            propiedadAlineado n = elementosCaja_texto.obtenerAlineado();
            if(n.alineado.equalsIgnoreCase("derecha")){
                cajaTexto.setHorizontalAlignment(SwingConstants.RIGHT);
            }else if(n.alineado.equalsIgnoreCase("izquierda")){
                cajaTexto.setHorizontalAlignment(SwingConstants.LEFT);   
            }else if(n.alineado.equalsIgnoreCase("centrado")){
              cajaTexto.setHorizontalAlignment(SwingConstants.CENTER);
            }
        }else{
            cajaTexto.setHorizontalAlignment(SwingConstants.LEFT);
        }
    }
    
    
    @Override
    public void agregarElementos(){
        propiedad temporal;
        for (int i = 0; i < this.elementosCaja_texto.listadoElementos.size(); i++) {
            temporal = this.elementosCaja_texto.listadoElementos.get(i);
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
