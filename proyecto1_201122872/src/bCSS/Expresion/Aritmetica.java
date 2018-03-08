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
public class Aritmetica extends baseCss {
    
    
    public baseCss operando1;
    public baseCss operando2;
    public String operador;
    
    
    
    public Aritmetica(Object op1, Object Simb, Object op2){
        this.operador= Simb.toString();
        this.operando1= (baseCss)op1;
        this.operando2= (baseCss)op2;
    }
    
    
    
    
}
