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
public class AsignaPosArreglo extends objetoBase{
    
    public String nombreArreglo;
    public objetoBase posArreglo;
    public objetoBase valorCasilla;
    
    
    public AsignaPosArreglo(Object nombre, Object pos, Object valor){
        this.nombreArreglo = nombre.toString();
        this.posArreglo = (objetoBase)pos;
        this.valorCasilla = (objetoBase)valor;
    }

    @Override
    public elementoRetorno Ejecutar(tablaSimbolos tabla, int contexto) {
        
        elementoRetorno posVector = (elementoRetorno) posArreglo.Ejecutar(tabla, contexto); 
        elementoRetorno valorPosVector = (elementoRetorno) valorCasilla.Ejecutar(tabla, contexto); 
        elementoRetorno ret = new elementoRetorno();
        tabla.asignarPosicionArreglo(nombreArreglo, posVector.ValorRetorno,valorPosVector.ValorRetorno, contexto);
           System.out.println("asignacion pos arreglo");
        tabla.imprimirTablaSimbolos();
           System.out.println("fin asigna pos arreglo");
        return ret;
    }
    
    
    
    
    
    
}
