/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto1_201122872.CHTML.BODY;

import java.util.ArrayList;
import proyecto1_201122872.CHTML.ElemetoPropiedad.propiedad;
import proyecto1_201122872.CHTML.Etiqueta;
import proyecto1_201122872.CHTML.listaElementos;

/**
 *
 * @author Ramonella
 */
public class Spinner extends Etiqueta {

    public listaElementos elementosSpinner;
    public String cadenaSpinner;

    public Spinner(Object elementos, Object cadena) {
        this.elementosSpinner = new listaElementos((ArrayList<propiedad>) elementos);
        this.cadenaSpinner = cadena.toString();
    }

}
