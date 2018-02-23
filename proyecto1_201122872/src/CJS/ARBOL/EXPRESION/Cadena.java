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
public class Cadena extends objetoBase {
    
    public String cadena;
    
    public Cadena(Object val){
        this.cadena = val.toString().replace("\"", "");
    }
    
     @Override
    public elementoRetorno Ejecutar(tablaSimbolos tabla, int contexto){
        
        elementoRetorno ret = new elementoRetorno();
        ret.ValorRetorno= this.cadena;
        super.retorno.ValorRetorno=cadena;
        return ret;
    }
    
    
}
