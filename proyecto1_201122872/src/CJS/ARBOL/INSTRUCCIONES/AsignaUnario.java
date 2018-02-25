/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CJS.ARBOL.INSTRUCCIONES;

import CJS.TablaSimbolos.tablaSimbolos;
import CJS.elementoRetorno;
import CJS.objetoBase;

/**
 *
 * @author Ramonella
 */
public class AsignaUnario extends objetoBase{
    
    public objetoBase valorUnario;
    public String operador;
    
    
    
    public AsignaUnario(Object unario, Object operador){
        this.valorUnario= (objetoBase)unario;
        this.operador= operador.toString();
        
    }

    @Override
    public elementoRetorno Ejecutar(tablaSimbolos tabla, int contexto) {
        
       
        elementoRetorno ret = new elementoRetorno();
        tabla.asignarUnario(valorUnario, operador, contexto);
           System.out.println("asignacion- unario");
        tabla.imprimirTablaSimbolos();
           System.out.println("fin asigna - unario");
        return ret;
    }
    
    
    
    
    
    
    
}
