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
public class Booleano extends objetoBase{
    
    public boolean valor;
    
    
    public Booleano(Object val){
        this.valor = (val.toString().equalsIgnoreCase("verdadero"));
        
    }
    
    
}
