/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CJS.ESTRUCURAS_CONTROL;

import CJS.ARBOL.EXPRESION.DateTime;
import CJS.ARBOL.EXPRESION.Datee;
import CJS.TablaSimbolos.tablaSimbolos;
import CJS.elementoRetorno;
import CJS.objetoBase;
import static proyecto1_201122872.Proyecto1_201122872.erroresEjecucion;

/**
 *
 * @author Ramonella
 */
public class Para extends objetoBase{
    /*
     public objetoBase condicion;
    public CuerpoEstructuras sentenciasVerdaderas;
    
    
    public Mientras(Object cond, Object verd){
        this.condicion= (objetoBase)cond;
        this.sentenciasVerdaderas= (CuerpoEstructuras)verd;
    }

    @Override
    public elementoRetorno Ejecutar(tablaSimbolos tabla, int contexto) {
         System.out.println("inicio mientrs");
        tabla.imprimirTablaSimbolos();
        System.out.println("fin inicio mientras");
        
        elementoRetorno resCondicion= condicion.Ejecutar(tabla, contexto);
        elementoRetorno resultado= new elementoRetorno();
        String tipoExpresion = obtenerTipoExpresion(resCondicion.ValorRetorno);
        contexto++;
        if(esBool(tipoExpresion)){
            
            while(resCondicion.ValorRetorno.toString().equalsIgnoreCase("verdadero")){
            //if(resCondicion.ValorRetorno.toString().equalsIgnoreCase("verdadero")){
                if(!resultado.detener){
                   resultado = sentenciasVerdaderas.Ejecutar(tabla, contexto);
                   resCondicion= condicion.Ejecutar(tabla, contexto); 
                }else{
                    break;
                }
                 
            }
            resultado.detener=false;
        }else{
           erroresEjecucion.insertarError("Semantico", "Tipo de expresion no valido para una expresion de una sentencia SI");
        }
        contexto--;
        System.out.println("fin while");
        tabla.imprimirTablaSimbolos();
        System.out.println("fin fin while ");
        return resultado;
    }
    
    
     private boolean esBool(String tipo) {
        return tipo.equalsIgnoreCase("bool");
    }
    
      private String obtenerTipoExpresion(Object val) {
        
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
    */
}
