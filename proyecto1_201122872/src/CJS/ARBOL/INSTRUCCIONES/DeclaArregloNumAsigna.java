/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CJS.ARBOL.INSTRUCCIONES;

import CJS.TablaSimbolos.tablaSimbolos;
import CJS.elementoRetorno;
import CJS.objetoBase;
import static proyecto1_201122872.Proyecto1_201122872.paginaActual;

/**
 *
 * @author Ramonella
 */
public class DeclaArregloNumAsigna extends objetoBase{
    
    public DeclaArreglo arregloDeclaracion;
    public asignaArreglo arregloAsigna;
    
    
    
    public DeclaArregloNumAsigna(Object decla, Object asigna){
        this.arregloDeclaracion = (DeclaArreglo)decla;
        this.arregloAsigna= (asignaArreglo)asigna;
    }

    @Override
    public elementoRetorno Ejecutar(tablaSimbolos tabla, int contexto) {
        Object valor = arregloDeclaracion.tamanhoArreglo.Ejecutar(tabla, contexto).ValorRetorno;
        int numeroAsigna = arregloAsigna.elementosArreglo.size();
        if(valor instanceof Integer || valor instanceof Double){
            double d = (Double)valor;
            int numeroDecla = (int)d;
            if(numeroDecla == numeroAsigna){
                arregloDeclaracion.Ejecutar(tabla, contexto);
                arregloAsigna.Ejecutar(tabla, contexto);
            }else{
                paginaActual.erroresPagina.insertarError("Semantica", "No coincide el numero de elementos con el valor asignado al arreglo");
            } 
        }else{
           paginaActual.erroresPagina.insertarError("Semantica", "Expresion no valida para tamanho de una arreglo"); 
        }
        return new elementoRetorno();
    }
    
    
    
    
    
}
