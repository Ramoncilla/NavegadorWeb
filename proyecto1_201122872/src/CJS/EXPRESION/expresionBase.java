/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CJS.EXPRESION;

import CJS.ARBOL.EXPRESION.DateTime;
import CJS.ARBOL.EXPRESION.Datee;

/**
 *
 * @author Ramonella
 */
public class expresionBase {
    
     public Object Resolver(Object valor1, Object valor2){
        
        
        
        return "nulo";
    }
    
     public Object Resolver(Object valor1, Object valor2, String tipo){
        
        
        
        return "nulo";
    }
    
      public  String obtenerTipoExpresion(Object val) {
        
        if ((val instanceof Double)|| (val instanceof Integer)) {
            return "numero";
        }
       
        if (val instanceof String) {
            
            if(((String)val).equalsIgnoreCase("verdadero")||
                    ((String) val).equalsIgnoreCase("falso")){
                return "bool";
            }else if(((String)val).equalsIgnoreCase("nulo")){
               return "nulo"; 
            } else{
                return "cadena"; 
            }
        }
        
        if(val instanceof Datee){
            return "Date";
        }
        if(val instanceof DateTime ){
            return "DateTime";
        }
        
        return "nulo";
    }
     
      
      
      /*----------------- Get elementos ----------------------------*/
      public double getBool(Object val){
        if(val.toString().equalsIgnoreCase("verdadero"))
            return 1;
        else
            return 0;
    }
    public double getNumero(Object val){
        return Double.parseDouble(val+"");
    }
    
   
    
    public String getCadena(Object val){
        return val.toString();
    }
    
    
    public String getDate(Object val){
        return ((Datee) val).getDate();
    }
    
    public String getDateTime(Object val){
        return ((DateTime) val).getDateTime();
    }
    /*------------------------------- Preguntar por elementos ------------------------*/
    
    
    public boolean esCero(double valor){
        return(valor==0);
    }
    
    public boolean esNumero(String tipo) {
        return tipo.equalsIgnoreCase("numero");
    }

    public boolean esBool(String tipo) {
        return tipo.equalsIgnoreCase("bool");
    }
    
   
    
    public boolean esCadena(String tipo) {
        return tipo.equalsIgnoreCase("cadena");
    } 
     
     
     public boolean esDate(String tipo){
       return tipo.equalsIgnoreCase("date");  
     }
     
     public boolean esDateTime(String tipo){
       return tipo.equalsIgnoreCase("dateTime");  
     }
     
     
     
    
    
}
