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
public class Numero extends objetoBase{
    
    public double numero;
    
    public Numero(Object valor){
        this.numero = Double.parseDouble(valor.toString());
    }
    
    
    
}
