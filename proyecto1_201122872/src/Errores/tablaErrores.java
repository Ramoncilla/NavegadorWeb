/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Errores;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Ramonella
 */
public class tablaErrores {
    
    List<Error> listadoErrores;
    
    
    public tablaErrores(){
        this.listadoErrores= new ArrayList<>();
    }
    
    public void insertarError(Error e){
        this.listadoErrores.add(e);
    }
    
    public void reiniciarErrores(){
        this.listadoErrores.clear();
    }
    
    
    public void insertarError(String tipo, String descripcion){
        // public Error(String tipo, String descripcion)
        Error er= new Error(tipo, descripcion);
        this.listadoErrores.add(er);
        
        
    }
    
}
