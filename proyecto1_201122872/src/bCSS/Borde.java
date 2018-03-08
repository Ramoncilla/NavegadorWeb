/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bCSS;

import CJS.objetoBase;
import proyecto1_201122872.CHTML.ElemetoPropiedad.propiedad;

/**
 *
 * @author Ramonella
 */
public class Borde extends propiedad {
    
      public objetoBase expresionSize;
       public objetoBase expresionColor;
        public objetoBase expresionCurva;
    
    public Borde(Object v0, Object v1, Object v2){
        this.expresionSize = (objetoBase)v0;
        this.expresionColor = (objetoBase)v1;
        this.expresionCurva = (objetoBase)v2;
    }
}
