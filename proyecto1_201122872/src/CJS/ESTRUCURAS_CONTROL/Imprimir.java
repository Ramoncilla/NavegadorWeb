/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CJS.ESTRUCURAS_CONTROL;

import CJS.ARBOL.EXPRESION.DateTime;
import CJS.ARBOL.EXPRESION.Datee;
import CJS.TablaSimbolos.tablaSimbolos;
import CJS.elementoRetorno;
import CJS.objetoBase;
import static proyecto1_201122872.Proyecto1_201122872.paginaActual;

/**
 *
 * @author Ramonella
 */
public class Imprimir extends objetoBase {
     public objetoBase expresionMostrar;
    
    
    public Imprimir(Object exp){
        this.expresionMostrar = (objetoBase)exp;
    }

    @Override
    public elementoRetorno Ejecutar(tablaSimbolos tabla, int contexto) {
        
        elementoRetorno ret = expresionMostrar.Ejecutar(tabla, contexto);
        if(ret.ValorRetorno instanceof Datee){
            Datee fecha = (Datee) ret.ValorRetorno;
            paginaActual.cadenaSalida +="> "+ fecha.getDate()+"\n";
            
        }else if(ret.ValorRetorno instanceof DateTime){
            DateTime fecha = (DateTime)ret.ValorRetorno;
             paginaActual.cadenaSalida +="> "+ fecha.getDateTime()+"\n";
            
        }else{
            paginaActual.cadenaSalida +="> "+ ret.ValorRetorno.toString()+"\n";
        }
        
        return ret;
    }
    
    
}
