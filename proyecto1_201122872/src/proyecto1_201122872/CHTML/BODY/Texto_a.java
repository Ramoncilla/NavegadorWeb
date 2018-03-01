/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto1_201122872.CHTML.BODY;
import java.awt.Color;
import java.util.ArrayList;
import javax.swing.JTextArea;
import proyecto1_201122872.CHTML.ElemetoPropiedad.propiedad;
import proyecto1_201122872.CHTML.Etiqueta;
import proyecto1_201122872.CHTML.listaElementos;
/**
 *
 * @author Ramonella
 */
public class Texto_a extends Etiqueta{
    
        public listaElementos elementosTexto_a;
        public String cadenaTexto_a;
        private JTextArea cajaTexto;
        
    public Texto_a(Object elementos , Object cadena){
        this.elementosTexto_a = new listaElementos((ArrayList<propiedad>)elementos);
        this.cadenaTexto_a= cadena.toString();  
        cajaTexto= new JTextArea();
        cajaTexto.setText(cadenaTexto_a);
        
    }

    @Override
    public Object retornarHtml() { 
        cajaTexto.setBackground(Color.orange); 
        return this.cajaTexto;
    }
    
    
    
    
    
    
    
    
}
