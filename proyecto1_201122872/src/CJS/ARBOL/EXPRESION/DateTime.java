/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CJS.ARBOL.EXPRESION;

import CJS.objetoBase;

/**
 *
 * @author Ramonella
 */
public class DateTime extends objetoBase {
    
    public Datee fecha;
    public  int horas;
    public int minutos;
    public int segundos;
    
    
    
    public DateTime(Object fecha, Object horas, Object minutos, Object segundos){
        
        this.fecha= (Datee)fecha;
        this.horas= (int)horas;
        this.minutos = (int)minutos;
        this.segundos= (int)segundos; 
    }
    
    
    
}
