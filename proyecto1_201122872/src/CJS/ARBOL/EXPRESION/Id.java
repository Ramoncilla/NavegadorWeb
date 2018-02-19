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
public class Id extends objetoBase{
    
    public String id;
    
    
    public Id(Object val){
        this.id= val.toString();
    }
    
    
}
