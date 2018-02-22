/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CJS.ARBOL.EXPRESION;

import CJS.objetoBase;

/**
 *
 * @author Ramonella
 */
public class Negativo extends objetoBase {
    
    public objetoBase expresion;
    
    
    public Negativo(Object el ){
        
        this.expresion = (objetoBase) el;
    }
    
    
}
