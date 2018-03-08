/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bCSS;

import CJS.ARBOL.EXPRESION.DateTime;
import CJS.ARBOL.EXPRESION.Datee;
import CJS.TablaSimbolos.tablaSimbolos;
import CJS.elementoRetorno;
import CJS.objetoBase;
import proyecto1_201122872.CHTML.ElemetoPropiedad.propiedad;
import static proyecto1_201122872.Proyecto1_201122872.paginaActual;

/**
 *
 * @author Ramonella
 */
public class Autoredimension extends propiedad{
      public objetoBase expresionValor;
      public String area;
      String valorAutoredimension;
      
      
    public Autoredimension(Object cad, Object v){
        this.expresionValor= (objetoBase)cad;
        this.area= v.toString();
    }
    
    
    
    
    public Object obtenerValor(){
        elementoRetorno r= expresionValor.Ejecutar(new tablaSimbolos(), 0);
        if(esBool(obtenerTipoExpresion(r.ValorRetorno))){
            this.valorAutoredimension=getBool(r.ValorRetorno);
        }else{
            this.valorAutoredimension="falso";
            paginaActual.erroresPagina.insertarError("Semantico", "La propiedad Autoredimension debe traer un valor booleano");
        } 
        
        return this.valorAutoredimension;
    }
    
    
    public String getBool(Object val){
        if(val.toString().equalsIgnoreCase("verdadero"))
            return "verdadero";
        else
            return "falso";
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
     
    
     public boolean esBool(String tipo) {
        return tipo.equalsIgnoreCase("bool");
    }
    
}
