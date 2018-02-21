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
    
    
    public Relacional(Object operando1, Object op, Object operando2){
        relacionales = new expresionesRelacionales();
        this.operando1= (objetoBase) operando1;
        this.operando2=(objetoBase)operando2;
        this.operador= op.toString();
        
    }
    
    
 @Override
    public elementoRetorno Ejecutar() {
        elementoRetorno val1 = (elementoRetorno) operando1.Ejecutar();
        elementoRetorno val2 = (elementoRetorno) operando2.Ejecutar();
        elementoRetorno ret = new elementoRetorno();
        Object resultado = relacionales.Resolver_Expresion(val1.ValorRetorno, val2.ValorRetorno, operador);
        ret.ValorRetorno = resultado;
        super.retorno.ValorRetorno = resultado;
        return ret;
    }
}
