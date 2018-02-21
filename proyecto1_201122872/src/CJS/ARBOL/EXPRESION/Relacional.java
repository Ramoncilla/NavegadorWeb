/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CJS.ARBOL.EXPRESION;

import CJS.EXPRESION.expresionesRelacionales;
import CJS.elementoRetorno;
import CJS.objetoBase;

/**
 *
 * @author Ramonella
 */
public class Relacional extends objetoBase{
    
   public objetoBase operando1;
   public objetoBase operando2;
   public  String operador;
   public expresionesRelacionales relacionales;
    
    
    public Relacional(Object operando1, Object operando2, Object op){
        this.operando1= (objetoBase) operando1;
        this.operando2=(objetoBase)operando2;
        this.operador= op.toString();
        
    }
    
    
   @Override
    public elementoRetorno Ejecutar(){
        
        
        
        return new elementoRetorno();
    }
    
}
