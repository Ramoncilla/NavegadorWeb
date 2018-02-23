/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CJS.TablaSimbolos;

import CJS.objetoBase;

/**
 *
 * @author Ramonella
 */
public class Simbolo {
    
    public boolean disponible;
    public String nombre;
    public String ambito;
  
    
    
    public Simbolo(){


    }
    
    
    public String obtenerTipoSimbolo(Simbolo s){
        if(s instanceof SimbArreglo)
            return "arreglo";
        else if (s instanceof SimbEtiqueta)
            return "etiqueta";
        else if(s instanceof SimbVariable)
            return "variable";
        else
            return "vacio"; 
    }
    
    
    
    public String imprimirSimbolo(){
        
        return "";
    }
    
    
}
