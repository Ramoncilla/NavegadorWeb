/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bCSS.Expresion;

import bCSS.baseCss;

/**
 *
 * @author Ramonella
 */
public class Cadena extends baseCss{
        public String cadena;
    
    public Cadena(Object c){
        this.cadena = c.toString().replace("\"", "");
    }
    
}
