/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CJS.ESTRUCURAS_CONTROL;

import CJS.TablaSimbolos.tablaSimbolos;
import CJS.elementoRetorno;
import CJS.objetoBase;

/**
 *
 * @author Ramonella
 */
public class Retornar extends objetoBase{
    
    objetoBase expresionRetorno;
    
    public Retornar(Object expresion){
        
        expresionRetorno= (objetoBase)expresion;
    }

    @Override
    public elementoRetorno Ejecutar(tablaSimbolos tabla, int contexto) {
        
        elementoRetorno ret =expresionRetorno.Ejecutar(tabla, contexto);
        ret.banderaRetorno=true;
        return ret; //To change body of generated methods, choose Tools | Templates.
    }
    
    
    
}
