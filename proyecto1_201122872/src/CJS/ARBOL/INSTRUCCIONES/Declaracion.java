/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CJS.ARBOL.INSTRUCCIONES;

import CJS.objetoBase;

/**
 *
 * @author Ramonella
 */
public class Declaracion extends objetoBase {
    
    public  String nombreElemento;
    
    
    public Declaracion(Object val){
        this.nombreElemento= val.toString();
    }
    
    
    
    
}