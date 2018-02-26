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
public class Si extends objetoBase{
    
    public objetoBase condicion;
    public CuerpoEstructuras cuerpoVerdadero;
    public CuerpoEstructuras cuerpoFalso;
    
    
    public Si(Object cond, Object verdaderas, Object falsas){
        this.condicion=(objetoBase)cond;
        this.cuerpoVerdadero= (CuerpoEstructuras)verdaderas;
        this.cuerpoFalso= (CuerpoEstructuras)falsas;
        
    }
    
    

    @Override
    public elementoRetorno Ejecutar(tablaSimbolos tabla, int contexto) {
        
        elementoRetorno resCondicion= condicion.Ejecutar(tabla, contexto);
        elementoRetorno resultado= new elementoRetorno();
        String tipoExpresion = obtenerTipoExpresion(resCondicion.ValorRetorno);
        if(esBool(tipoExpresion)){
            if(resCondicion.ValorRetorno.toString().equalsIgnoreCase("verdadero")){
                resultado = cuerpoVerdadero.Ejecutar(tabla, contexto);
            }else{
                resultado= cuerpoFalso.Ejecutar(tabla, contexto);
            }
            
        }else{
           erroresEjecucion.insertarError("Semantico", "Tipo de expresion no valido para una expresion de una sentencia SI");
        }
        
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
    
    
    
    
}
