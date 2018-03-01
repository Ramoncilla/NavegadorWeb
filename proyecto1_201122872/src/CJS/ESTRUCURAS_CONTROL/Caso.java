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
public class Caso extends objetoBase {
    
    public objetoBase expresionCaso;
    public CuerpoEstructuras sentenciasCaso;
    
    
    public Caso(Object exp, Object cuerpo){
        this.expresionCaso= (objetoBase)exp;
        this.sentenciasCaso=(CuerpoEstructuras)cuerpo;
    }

    @Override
    public elementoRetorno Ejecutar(tablaSimbolos tabla, int contexto) {
        
        return sentenciasCaso.Ejecutar(tabla, contexto);
        
    }
    
    
    public elementoRetorno ejecutarExpresion(tablaSimbolos tabla, int contexto){
        return expresionCaso.Ejecutar(tabla, contexto);
    } 
    
}
