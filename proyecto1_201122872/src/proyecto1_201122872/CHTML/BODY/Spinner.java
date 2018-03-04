/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto1_201122872.CHTML.BODY;

import java.awt.Dimension;
import java.util.ArrayList;
import javax.swing.JTextField;
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
public class Spinner extends Etiqueta {

    public listaElementos elementosSpinner;
    public int numeroSpinner;
    public textFieldComponente spinner;

    public Spinner(Object elementos, Object cadena) {
        this.alto=50;
        this.ancho=50;
        this.elementosSpinner = new listaElementos((ArrayList<propiedad>) elementos);
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
    public Object retornarHtml() {
        agregarElementos();
        asignarElementos();
        this.spinner.setText(String.valueOf(numeroSpinner));
       
        return spinner;
    }
    
    
      @Override
    public void asignarElementos(){
   
        spinner.setSize(ancho, alto);
        if(elementosSpinner.obtenerAlineado()!=null){
            propiedadAlineado n = elementosSpinner.obtenerAlineado();
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
        for (int i = 0; i < this.elementosSpinner.listadoElementos.size(); i++) {
            temporal = this.elementosSpinner.listadoElementos.get(i);
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
