/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CJS.ARBOL.EXPRESION;

import CJS.TablaSimbolos.SimbArreglo;
import CJS.TablaSimbolos.tablaSimbolos;
import CJS.elementoRetorno;
import CJS.objetoBase;
import static proyecto1_201122872.Proyecto1_201122872.erroresEjecucion;

/**
 *
 * @author Ramonella
 */
public class posVector extends objetoBase{
    
    public String nombreArreglo;
    public objetoBase posicionArreglo;
    
    
    
    public posVector(Object nom, Object pos){
        this.nombreArreglo= nom.toString();
        this.posicionArreglo= (objetoBase)pos;
    }

    @Override
    public elementoRetorno Ejecutar(tablaSimbolos tabla, int contexto) {
      String ambito="";
        elementoRetorno ret = new elementoRetorno();
        if(contexto>0)
            ambito="local";
        else
            ambito="global";
        SimbArreglo simb= tabla.obtenerArreglo(nombreArreglo, ambito, contexto);
        elementoRetorno r= posicionArreglo.Ejecutar(tabla, contexto);
        String tipoExpresion= obtenerTipoExpresion(r.ValorRetorno);
        
        if(simb!=null && tipoExpresion.equalsIgnoreCase("numero")){
            double d = Double.parseDouble(r.ValorRetorno.toString());
            int posicion = (int)d;
            
            ret.ValorRetorno= simb.obtenerValorPoscion(posicion);
            super.retorno.ValorRetorno= simb.obtenerValorPoscion(posicion);
           
        }else{
            super.retorno.ValorRetorno= "nulo";
            erroresEjecucion.insertarError("semantico", "No existe el arreglo "+ nombreArreglo);
        }
        
        return retorno;
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
    
    
}
