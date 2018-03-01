/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto1_201122872.CHTML.BODY;
import java.awt.Color;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import proyecto1_201122872.CHTML.ElemetoPropiedad.propiedad;
import proyecto1_201122872.CHTML.Etiqueta;
import proyecto1_201122872.CHTML.listaElementos;
/**
 *
 * @author Ramonella
 */
public class Texto extends Etiqueta{
    
    //texto normal en html
    
    public listaElementos elementosTexto;
    public String cadenaTexto;
    private JTextArea texto;
    public String cadenaHTML;
    
    public Texto(Object elementos , Object cadena){
        this.elementosTexto = new listaElementos((ArrayList<propiedad>)elementos);
        this.cadenaTexto= cadena.toString();
        this.texto= new JTextArea();
        
    }
    
       @Override
    public Object retornarHtml(){
         cadenaHTML="<p>"+this.cadenaTexto+"</p>";
        
        /*texto.setText(cadenaTexto);
        texto.setForeground(Color.yellow);
        texto.setOpaque(true);*/
        //texto.enable(false);
        return this;
       
    }
    
}
