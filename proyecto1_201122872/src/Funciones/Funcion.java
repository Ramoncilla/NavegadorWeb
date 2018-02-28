/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Funciones;

import CJS.ESTRUCURAS_CONTROL.CuerpoEstructuras;
import CJS.TablaSimbolos.Simbolo;
import CJS.TablaSimbolos.tablaSimbolos;
import CJS.elementoRetorno;
import CJS.objetoBase;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Ramonella
 */
public class Funcion extends objetoBase {
    
    public String nombreFuncion;
    public List<String> parametros;
    public CuerpoEstructuras cuerpoFuncion;
    public int noParametros;
    
    
    public Funcion(Object nombre, Object parametros, Object cuerpo){
        
        this.nombreFuncion= nombre.toString();
        this.parametros= (ArrayList<String>)parametros;
        this.cuerpoFuncion= (CuerpoEstructuras)cuerpo;
        this.noParametros= this.parametros.size();
        
    }

    @Override
    public elementoRetorno Ejecutar(tablaSimbolos tabla, int contexto) {
        //1. asignamos parametros en la tabla de simbolos
        
        cuerpoFuncion.Ejecutar(tabla, contexto);
        
        
        return super.Ejecutar(tabla, contexto); //To change body of generated methods, choose Tools | Templates.
    }
    
    
    
    
}
