/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto1_201122872.CHTML.BODY;

import java.util.ArrayList;
import javax.swing.JTextField;
import proyecto1_201122872.CHTML.ElemetoPropiedad.propiedad;
import proyecto1_201122872.CHTML.Etiqueta;
import proyecto1_201122872.CHTML.listaElementos;

/**
 *
 * @author Ramonella
 */
public class Spinner extends Etiqueta {

    public listaElementos elementosSpinner;
    public int numeroSpinner;
    public JTextField spinner;

    public Spinner(Object elementos, Object cadena) {
        this.elementosSpinner = new listaElementos((ArrayList<propiedad>) elementos);
        if(esNumero(cadena.toString())){
            this.numeroSpinner= Integer.parseInt(cadena.toString());
        }    else{
            this.numeroSpinner=0;
        }
        this.spinner= new JTextField();
    }
    
    private boolean esNumero(String s) {
        return s != null && s.matches("[-+]?\\d*\\.?\\d+");
    }

    @Override
    public Object retornarHtml() {
        this.spinner.setText(numeroSpinner+"");
        return spinner;
    }
    
    
    


}
