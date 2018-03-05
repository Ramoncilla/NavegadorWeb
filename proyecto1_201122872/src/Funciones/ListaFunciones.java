/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Funciones;

import java.util.ArrayList;
import java.util.List;
import static proyecto1_201122872.Proyecto1_201122872.paginaActual;

/**
 *
 * @author Ramonella
 */
public class ListaFunciones {
    
    public List<Funcion> funciones;
    
    
    public ListaFunciones(){
        this.funciones = new ArrayList<>();
    }
    
    
    private boolean existeFuncion(Funcion nueva)
    {
        Funcion temporal;
        for (int i = 0; i < this.funciones.size(); i++) {
            temporal = this.funciones.get(i);
            if(temporal.nombreFuncion.equalsIgnoreCase(nueva.nombreFuncion) &&
                    temporal.noParametros== nueva.noParametros){
                return true;
            }
            
        } 
        return false;
    }
    
    
    public boolean insertarFuncion(Funcion fun){
        
        if(!existeFuncion(fun)){
            this.funciones.add(fun);
            return true;
        }else{
            paginaActual.erroresPagina.insertarError("Semantico", "Ya existe la funcion llamada "+ fun.nombreFuncion+", que cuenta con "+fun.noParametros+" parametros");
            return false;
        }
        
    }
    
    
    public Funcion obtenerFuncion(String nombre, int noParmetros){
        
        Funcion temporal;
        for (int i = 0; i < this.funciones.size(); i++) {
            temporal = this.funciones.get(i);
            if(temporal.nombreFuncion.equalsIgnoreCase(nombre) &&
                    temporal.noParametros== noParmetros){
                return temporal;
            }
            
        } 
        return null;
    }
    
    
}
