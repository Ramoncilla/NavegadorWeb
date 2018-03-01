/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto1_201122872.CHTML.BODY;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JTextField;
import proyecto1_201122872.CHTML.ElemetoPropiedad.propiedad;
import proyecto1_201122872.CHTML.Etiqueta;
import proyecto1_201122872.CHTML.listaElementos;
/**
 *
 * @author Ramonella
 */
public class Texto extends Etiqueta{
    
    public listaElementos elementosTexto;
    public String cadenaTexto;
    private JTextField texto;
    
    public Texto(Object elementos , Object cadena){
        this.elementosTexto = new listaElementos((ArrayList<propiedad>)elementos);
        this.cadenaTexto= cadena.toString();
        this.texto= new JTextField();
        texto.setText(cadenaTexto);
    }
    
       @Override
    public Object retornarHtml(){
        return texto;
       
    }
    
}
