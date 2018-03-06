/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bCSS;

/**
 *
 * @author Ramonella
 */
public class Autoredimension extends baseCss{
      public baseCss expresionValor;
      public String area;
    
    public Autoredimension(Object cad, Object v){
        this.expresionValor= (baseCss)cad;
        this.area= v.toString();
    }
    
    
}
