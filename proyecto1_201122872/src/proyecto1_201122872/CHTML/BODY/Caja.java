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
import proyecto1_201122872.CHTML.Etiqueta;
import proyecto1_201122872.CHTML.Opcion;
import proyecto1_201122872.CHTML.listaElementos;
/**
 *
 * @author Ramonella
 */
public class Caja extends Etiqueta implements ActionListener {
   
    public listaElementos elementosEtiqueta;
    public List<Opcion> opcionesCaja;
    public JComboBox cajaOpciones;
    public Object valorSeleccionado;
    public String elementoSeleccionado;
    
    public Caja(Object elementos, Object opciones)
    {
        this.elementosEtiqueta=(listaElementos)elementos;
        this.opcionesCaja=(ArrayList<Opcion>)opciones;
        this.cajaOpciones= new JComboBox();
    }    

    @Override
    public Object retornarHtml() {
        Opcion temporal;
        cajaOpciones = new JComboBox();
        cajaOpciones.addActionListener(this);
        for (int i = 0; i < this.opcionesCaja.size(); i++) {
            temporal = this.opcionesCaja.get(i);
            cajaOpciones.addItem(temporal.contenidoOpcion);
        } 
        cajaOpciones.setSize(200, 120);
        return cajaOpciones;
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
    
    
    
    
    
    
    
}
