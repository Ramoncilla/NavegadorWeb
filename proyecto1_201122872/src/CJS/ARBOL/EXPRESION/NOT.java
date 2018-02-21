/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CJS.ARBOL.EXPRESION;

import CJS.EXPRESION.expresionesLogicas;
import CJS.elementoRetorno;
import CJS.objetoBase;

/**
 *
 * @author Ramonella
 */
public class NOT extends objetoBase {
    
    objetoBase operando1;
    expresionesLogicas logicas;
    
    
    public NOT(Object op1){
        this.logicas= new expresionesLogicas();
        this.operando1= (objetoBase) op1;
    }
    
    @Override
    public elementoRetorno Ejecutar() {
        elementoRetorno val1 = (elementoRetorno) operando1.Ejecutar();
        elementoRetorno ret = new elementoRetorno();
        Object resultado = logicas.ResolverNOT(val1.ValorRetorno);
        ret.ValorRetorno = resultado;
        super.retorno.ValorRetorno = resultado;
        return ret;
    }
    
    
    
    
}
