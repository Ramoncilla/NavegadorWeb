/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CJS.ARBOL.INSTRUCCIONES;

import CJS.TablaSimbolos.SimbArreglo;
import CJS.TablaSimbolos.SimbVariable;
import CJS.TablaSimbolos.tablaSimbolos;
import CJS.elementoRetorno;
import CJS.objetoBase;

/**
 *
 * @author Ramonella
 */
public class DeclaArreglo extends objetoBase {
    
    public String nombreArreglo;
    public objetoBase tamanhoArreglo;
    
    
    public DeclaArreglo(Object nombre, Object tamanho){
        this.nombreArreglo = nombre.toString();
        this.tamanhoArreglo = (objetoBase) tamanho;
    }
    
    
    
        @Override
    public elementoRetorno Ejecutar(tablaSimbolos tabla, int contexto){
        
        elementoRetorno valor = (elementoRetorno) tamanhoArreglo.Ejecutar(tabla, contexto);   
        tabla.agregarArregloSinAsignacion(nombreArreglo, valor.ValorRetorno, contexto);
        System.out.println("DEclaracion-Arreglo");
        tabla.imprimirTablaSimbolos();
        System.out.println("fin declaracion - Arreglo");
        return new elementoRetorno();
        

    }
    
    
    
    
}
