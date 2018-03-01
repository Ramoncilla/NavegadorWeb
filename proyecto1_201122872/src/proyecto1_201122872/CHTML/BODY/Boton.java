/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto1_201122872.CHTML.BODY;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JButton;
import proyecto1_201122872.CHTML.ElemetoPropiedad.propiedad;
import proyecto1_201122872.CHTML.Etiqueta;
import proyecto1_201122872.CHTML.listaElementos;
/**
 *
 * @author Ramonella
 */
public class Boton extends Etiqueta implements ActionListener {
    
    public listaElementos elementosBoton;
    public String captionBoton;
    public JButton botonObjeto;
    
    public Boton(Object elementos, Object cadena){
        this.elementosBoton = new listaElementos((ArrayList<propiedad>)elementos);
        this.captionBoton = cadena.toString();
        botonObjeto = new JButton(this.captionBoton); 
        this.botonObjeto.addActionListener(this);
    }
     
    @Override
    public Object retornarHtml(){    
        return botonObjeto;
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        
        System.out.println("Di clic en el boton "+ this.captionBoton);
        
        
    }
    
}
