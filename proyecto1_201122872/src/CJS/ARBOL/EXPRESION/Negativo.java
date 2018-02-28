/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CJS.ARBOL.EXPRESION;

import CJS.TablaSimbolos.tablaSimbolos;
import CJS.elementoRetorno;
import CJS.objetoBase;

/**
 *
 * @author Ramonella
 */
public class Negativo extends objetoBase {
    
    public objetoBase expresion;
    
    
    public Negativo(Object el ){
        
        this.expresion = (objetoBase) el;
    }
   
    @Override
    public elementoRetorno Ejecutar(tablaSimbolos tabla, int contexto) {

        elementoRetorno ret = this.expresion.Ejecutar(tabla, contexto);
        if (ret.ValorRetorno != null) {
            if (obtenerTipoExpresion(ret.ValorRetorno).equalsIgnoreCase("numero")) {

                double dou = Double.parseDouble(ret.ValorRetorno.toString());
                ret.ValorRetorno = dou*-1;
                super.retorno.ValorRetorno = dou*-1;

            } 

        }

        return ret;
    }



    private String obtenerTipoExpresion(Object val) {

        if ((val instanceof Double) || (val instanceof Integer)) {
            return "numero";
        }

        if (val instanceof String) {

            if (((String) val).equalsIgnoreCase("verdadero")
                    || ((String) val).equalsIgnoreCase("falso")) {
                return "bool";
            } else if (((String) val).equalsIgnoreCase("nulo")) {
                return "nulo";
            } else {
                return "cadena";
            }
        }

        if (val instanceof Datee) {
            return "Date";
        }
        if (val instanceof DateTime) {
            return "DateTime";
        }

        return "nulo";
    }
    
    
    
}
