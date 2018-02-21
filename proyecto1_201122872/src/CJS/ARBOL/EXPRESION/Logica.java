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
public class Logica extends objetoBase{
    
    objetoBase operando1;
    objetoBase operando2;
    String operador;
    
    
    public Logica(Object op1, Object op, Object op2){
        this.operador=op.toString();
        this.operando1= (objetoBase) op1;
        this.operando2= (objetoBase)op2;
    }
    
    
    
    
    
}
