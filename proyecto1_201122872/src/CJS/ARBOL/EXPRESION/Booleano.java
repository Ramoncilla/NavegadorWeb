/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CJS.ARBOL.EXPRESION;

import CJS.TablaSimbolos.tablaSimbolos;
import CJS.elementoRetorno;
import CJS.objetoBase;

/**
 *
 * @author Ramonella
 */
public class Booleano extends objetoBase{
    
    public String valor;
    
    
    public Booleano(Object val){
        this.valor = (val.toString());
        
    }
    
      @Override
    public elementoRetorno Ejecutar(tablaSimbolos tabla, int contexto){
        
        elementoRetorno ret = new elementoRetorno();
        ret.ValorRetorno= valor;
        super.retorno.ValorRetorno=valor;
        return ret;
    }
    
    
}
