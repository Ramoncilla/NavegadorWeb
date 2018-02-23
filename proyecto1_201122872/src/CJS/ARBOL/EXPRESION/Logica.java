/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CJS.ARBOL.EXPRESION;

import CJS.EXPRESION.expresionesLogicas;
import CJS.TablaSimbolos.tablaSimbolos;
import CJS.elementoRetorno;
import CJS.objetoBase;

/**
 *
 * @author Ramonella
 */
public class Logica extends objetoBase{
    
    objetoBase operando1;
    objetoBase operando2;
    String operador;
    expresionesLogicas logicas;
    
    
    public Logica(Object op1, Object op, Object op2){
        this.logicas= new expresionesLogicas();
        this.operador=op.toString();
        this.operando1= (objetoBase) op1;
        this.operando2= (objetoBase)op2;
    }
    
    @Override
    public elementoRetorno Ejecutar(tablaSimbolos tabla, int contexto) {
        elementoRetorno val1 = (elementoRetorno) operando1.Ejecutar(tabla, contexto);
        elementoRetorno val2 = (elementoRetorno) operando2.Ejecutar(tabla, contexto);
        elementoRetorno ret = new elementoRetorno();
        Object resultado = logicas.Resolver_Expresion(val1.ValorRetorno, val2.ValorRetorno, operador);
        ret.ValorRetorno = resultado;
        super.retorno.ValorRetorno = resultado;
        return ret;
    }
    
    
    
}
