/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CJS.EXPRESION;

/**
 *
 * @author Ramonella
 */
public class expresionesLogicas extends expresionBase {
    
    public expresionesLogicas(){
        
    }
    
    
     public Object Resolver_Expresion(Object val1, Object val2, String simb){
        switch (simb) {
            case "||": {
                return ResolverOR(val1, val2);
            }
            case "&&": {
                return ResolverAND(val1, val2);
            }
            case "&|": {
                return ResolverXOR(val1, val2);
            }

        }
        return "nulo";
    }
    
      
    
      
       public Object ResolverOR(Object val1, Object val2){
          String tipo1 = obtenerTipoExpresion(val1);
          String tipo2= obtenerTipoExpresion(val2);
          
          if(tipo1.equalsIgnoreCase("bool") && tipo2.equalsIgnoreCase("bool")){
              if(getBool(val1)==1 || getBool(val2)==1){
                  return "verdadero";
              }else{
                  return "falso";
              }
              
          }else{
              ErrorE nuevo = new ErrorE("Tipos no validos para una expresion logica","","","Semantico","Graphik");
              l_errores.insertar(nuevo);
          }
          
          return "nulo";
      }
       
       public Object ResolverAND(Object val1, Object val2){
          String tipo1 = obtenerTipoExpresion(val1);
          String tipo2= obtenerTipoExpresion(val2);
          
          if(tipo1.equalsIgnoreCase("bool") && tipo2.equalsIgnoreCase("bool")){
              if(getBool(val1)==1 && getBool(val2)==1){
                  return "verdadero";
              }else{
                  return "falso";
              }
              
          }else{
              ErrorE nuevo = new ErrorE("Tipos no validos para una expresion logica","","","Semantico","Graphik");
                l_errores.insertar(nuevo);
          }
          
          return "nulo";
      } 
      
      public Object ResolverXOR(Object val1, Object val2){
          String tipo1 = obtenerTipoExpresion(val1);
          String tipo2= obtenerTipoExpresion(val2);
          
          if(tipo1.equalsIgnoreCase("bool") && tipo2.equalsIgnoreCase("bool")){
              if(getBool(val1) != getBool(val2)){
                  return "verdadero";
              }else{
                  return "falso";
              }
              
          }else{
              ErrorE nuevo = new ErrorE("Tipos no validos para una expresion logica","","","Semantico","Graphik");
                l_errores.insertar(nuevo);
          }
          
          return "nulo";
      }
     
       public Object ResolverNOT(Object val1){
          String tipo1 = obtenerTipoExpresion(val1);
         
          
          if(tipo1.equalsIgnoreCase("bool")){
              if(getBool(val1)==0){
                  return "verdadero";
              }else{
                  return "falso";
              }
              
          }else{
              ErrorE nuevo = new ErrorE("Tipos no validos para una expresion logica","","","Semantico","Graphik");
                l_errores.insertar(nuevo);
          }
          
          return "nulo";
      }
    
    
    
    
}
