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
public class Numero extends objetoBase{
    
    public Object numero;
    
    public Numero(Object valor){
        
        if(valor.toString().contains(".")){
             this.numero = Double.parseDouble(valor.toString());
        }else{
             this.numero = Integer.parseInt(valor.toString());
        }
        
        
       
       
    }
    
    @Override
    public elementoRetorno Ejecutar(tablaSimbolos tabla, int contexto){
        
        elementoRetorno ret = new elementoRetorno();
        ret.ValorRetorno= this.numero;
        super.retorno.ValorRetorno=numero;
        return ret;
    }
    
}
