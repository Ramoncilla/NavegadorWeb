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
public class Declaracion extends objetoBase {
    
    public  String nombreElemento;
    
    
    public Declaracion(Object val){
        this.nombreElemento= val.toString();
    }
    
    
    @Override
    public elementoRetorno Ejecutar(tablaSimbolos tabla, int contexto){
        
        SimbVariable nuevaVariable = new SimbVariable(nombreElemento);
        if(contexto>0)
            nuevaVariable.ambito="local";
        else
            nuevaVariable.ambito="global";
        nuevaVariable.tipoVariable="";
        tabla.agregarSimbolo(nuevaVariable, contexto);
        System.out.println("DEclaracion");
        tabla.imprimirTablaSimbolos();
        System.out.println("fin declaracion");
        return new elementoRetorno();
    }
    
}
