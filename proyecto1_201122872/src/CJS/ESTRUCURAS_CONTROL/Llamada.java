/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CJS.ESTRUCURAS_CONTROL;

import CJS.TablaSimbolos.tablaSimbolos;
import CJS.elementoRetorno;
import CJS.objetoBase;
import Funciones.Funcion;
import java.util.ArrayList;
import java.util.List;
import static proyecto1_201122872.Proyecto1_201122872.lFunciones;
import static proyecto1_201122872.Proyecto1_201122872.erroresEjecucion;
/**
 *
 * @author Ramonella
 */
public class Llamada extends objetoBase{
    
    public String nombreFuncion;
    public List<objetoBase> parametros;
    
        
    public Llamada(Object nombre, Object parametros){
        this.nombreFuncion= nombre.toString();
        this.parametros= (ArrayList<objetoBase>)parametros;
    }

    @Override
    public elementoRetorno Ejecutar(tablaSimbolos tabla, int contexto) {
        
        Funcion funcionBuscada= lFunciones.obtenerFuncion(nombreFuncion, parametros.size());
   
        
        if(funcionBuscada!=null){
            contexto++;
            funcionBuscada.Ejecutar(tabla, contexto);
            tabla.eliminarSimbolosLocales(contexto);
            contexto--; 
        }else{
            erroresEjecucion.insertarError("Semantico", "No existe la funcion "+nombreFuncion+" con "+ parametros.size());
        } 
        return super.Ejecutar(tabla, contexto); //To change body of generated methods, choose Tools | Templates.
    }
    
    

    
    
    
    
    
}
