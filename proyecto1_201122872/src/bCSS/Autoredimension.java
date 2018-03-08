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
public class Autoredimension extends propiedad{
      public baseCss expresionValor;
      public String area;
    
    public Autoredimension(Object cad, Object v){
        this.expresionValor= (baseCss)cad;
        this.area= v.toString();
    }
    
    
}
