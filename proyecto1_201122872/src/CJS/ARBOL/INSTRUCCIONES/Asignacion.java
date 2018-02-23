/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CJS.ARBOL.INSTRUCCIONES;

import CJS.TablaSimbolos.SimbVariable;
import CJS.TablaSimbolos.tablaSimbolos;
import CJS.elementoRetorno;
import CJS.objetoBase;

/**
 *
 * @author Ramonella
 */
public class Asignacion extends objetoBase{
    
    public String nombre;
    public objetoBase expresion;
    
    public Asignacion(Object nombre, Object exp){
        
        this.nombre= nombre.toString();
        this.expresion = (objetoBase) exp;
        
    }
    
       @Override
    public elementoRetorno Ejecutar(tablaSimbolos tabla, int contexto){
        
        elementoRetorno valor = (elementoRetorno) expresion.Ejecutar(tabla, contexto); 
        elementoRetorno ret = new elementoRetorno();
        tabla.asignarSimbolo(this.nombre ,valor.ValorRetorno,contexto);
           System.out.println("asignacion");
        tabla.imprimirTablaSimbolos();
           System.out.println("fin asigna");
        return ret;
        
    }
    
    
    
    
}
