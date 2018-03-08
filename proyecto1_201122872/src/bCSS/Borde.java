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
public class Borde extends propiedad {
    
      public baseCss expresionSize;
       public baseCss expresionColor;
        public baseCss expresionCurva;
    
    public Borde(Object v0, Object v1, Object v2){
        this.expresionSize = (baseCss)v0;
        this.expresionColor = (baseCss)v1;
        this.expresionCurva = (baseCss)v2;
    }
}
