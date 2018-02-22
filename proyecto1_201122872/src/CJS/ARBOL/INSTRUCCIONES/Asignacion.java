/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CJS.ARBOL.INSTRUCCIONES;

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
        this.expresion = (objetoBase) expresion;
        
    }
    
    
    
    
    
    
}
