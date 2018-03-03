/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto1_201122872.CHTML.BODY;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JButton;
import proyecto1_201122872.CHTML.ElemetoPropiedad.propiedad;
import proyecto1_201122872.CHTML.Etiqueta;
import proyecto1_201122872.CHTML.listaElementos;
import proyecto1_201122872.CHTML.ElemetoPropiedad.*;
import static proyecto1_201122872.Proyecto1_201122872.erroresEjecucion;

/**
 *
 * @author Ramonella
 */
public class Boton extends Etiqueta implements ActionListener {
    
    public listaElementos elementosBoton;
    public String captionBoton;
    public JButton botonObjeto;
    public String nombreFuncionClick;
    public static int alto1=0;
    public static int ancho1=0;
    botonComponente h;
    
    public Boton(Object elementos, Object cadena){
        this.elementosBoton = new listaElementos((ArrayList<propiedad>)elementos);
        this.captionBoton = cadena.toString();
        
         botonObjeto = new JButton(this.captionBoton);
         this.botonObjeto.addActionListener(this);
        this.nombreFuncionClick="";
    }
     
    @Override
    public Object retornarHtml(){ 
       
        this.alto=40;
        this.ancho=50;
        agregarElementos();
        botonObjeto.setOpaque(false);
        botonObjeto.setSize(this.ancho, this.alto);
        return botonObjeto;
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        
        System.out.println("Di clic en el boton "+ this.captionBoton);
        
        
    }
    
    
    private void agregarElementos(){
        propiedad temporal;
        for (int i = 0; i < this.elementosBoton.listadoElementos.size(); i++) {
            temporal = this.elementosBoton.listadoElementos.get(i);
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
                
            }else if(temporal instanceof propiedadClick){
                propiedadClick p = (propiedadClick)temporal;
                this.nombreFuncionClick= p.nombreFuncion;
                
                //verificar que exista la funcion y si si guardo el nombre sino marco error
//                if(!asignarID(p.idElemento)){
//                    erroresEjecucion.insertarError("Semantico", "Elemento no valido para la alineacion el ID de un boton");
//                }
                
            }
        }
    }
    
    
}
