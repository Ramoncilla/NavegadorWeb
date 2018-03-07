/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto1_201122872.CHTML.BODY;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import proyecto1_201122872.CHTML.ElemetoPropiedad.propiedad;
import proyecto1_201122872.CHTML.ElemetoPropiedad.propiedadAlineado;
import proyecto1_201122872.CHTML.ElemetoPropiedad.propiedadAlto;
import proyecto1_201122872.CHTML.ElemetoPropiedad.propiedadAncho;
import proyecto1_201122872.CHTML.ElemetoPropiedad.propiedadClick;
import proyecto1_201122872.CHTML.ElemetoPropiedad.propiedadGrupo;
import proyecto1_201122872.CHTML.ElemetoPropiedad.propiedadId;
import proyecto1_201122872.CHTML.Etiqueta;
import proyecto1_201122872.CHTML.Opcion;
import proyecto1_201122872.CHTML.listaElementos;
import static proyecto1_201122872.Proyecto1_201122872.paginaActual;
/**
 *
 * @author Ramonella
 */
public class Caja extends Etiqueta implements ActionListener {
   
   
    public List<Opcion> opcionesCaja;
    public ComboComponente cajaOpciones;
    public Object valorSeleccionado;
    public String elementoSeleccionado;
    public List<String> funcionesClic;
    
    public Caja(Object elementos, Object opciones)
    {
        this.funcionesClic= new ArrayList<>();
        this.alto=50;
        this.ancho=100;
        this.elementosEtiqueta=(listaElementos)elementos;
        this.opcionesCaja=(ArrayList<Opcion>)opciones;
        this.cajaOpciones= new ComboComponente();
    }    

    @Override
    public Etiqueta retornarHtml() {
        Opcion temporal;
        cajaOpciones = new ComboComponente();
        cajaOpciones.addActionListener(this);
        agregarElementos();
        asignarElementos();
        for (int i = 0; i < this.opcionesCaja.size(); i++) {
            temporal = this.opcionesCaja.get(i);
            cajaOpciones.addItem(temporal.contenidoOpcion);
            
        } 
        return this;
    }

 
    
    
    @Override
    public void actionPerformed(ActionEvent ae) {
        this.elementoSeleccionado= cajaOpciones.getSelectedItem().toString();
        this.valorSeleccionado= obtenerValor(this.elementoSeleccionado);     
        System.out.println("imprimir "+ this.elementoSeleccionado+" valor: "+ this.valorSeleccionado);
    }
    
    
    private Object obtenerValor(String contenido){
        for (int i = 0; i < this.opcionesCaja.size(); i++) {
            if(this.opcionesCaja.get(i).contenidoOpcion.equalsIgnoreCase(contenido)){
                return this.opcionesCaja.get(i).valorOpcion;
                
            }   
        }
        
        return "nulo";
    }
    
   
       
    @Override
    public void asignarElementos(){
   
        cajaOpciones.setSize(ancho, alto);
        if(elementosEtiqueta.obtenerAlineado()!=null){
            propiedadAlineado n = elementosEtiqueta.obtenerAlineado();
            if(n.alineado.equalsIgnoreCase("derecha")){
                ((JLabel)cajaOpciones.getRenderer()).setHorizontalAlignment(SwingConstants.RIGHT);
            }else if(n.alineado.equalsIgnoreCase("izquierda")){
                ((JLabel)cajaOpciones.getRenderer()).setHorizontalAlignment(SwingConstants.LEFT);     
            }else if(n.alineado.equalsIgnoreCase("centrado")){
              ((JLabel)cajaOpciones.getRenderer()).setHorizontalAlignment(SwingConstants.CENTER);
            }
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
                
            }else if(temporal instanceof propiedadClick){
                propiedadClick p = (propiedadClick)temporal;
                this.funcionesClic.add(p.nombreFuncion);
                
            }
        }
    }
    
    
    
    
    
    
    
    
}
