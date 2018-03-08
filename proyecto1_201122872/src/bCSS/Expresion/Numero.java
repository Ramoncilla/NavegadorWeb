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
public class Numero extends baseCss {
    
    public double numero;
    
    public Numero(Object n){
        this.numero = Double.parseDouble(n.toString());
    }
    
}
