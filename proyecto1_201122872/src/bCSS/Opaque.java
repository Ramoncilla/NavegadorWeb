/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bCSS;

import proyecto1_201122872.CHTML.ElemetoPropiedad.propiedad;

/**
 *
 * @author Ramonella
 */
public class Opaque extends propiedad{
       String valorOpaque;
    
    public Opaque(Object cad){
        this.valorOpaque= cad.toString();
    }

    public String getValorOpaque() {
        return valorOpaque;
    }
    
    
}
