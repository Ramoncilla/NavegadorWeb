/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CJS.EXPRESION;

import static proyecto1_201122872.Proyecto1_201122872.paginaActual;

/**
 *
 * @author Ramonella
 */
public class expresionesLogicas extends expresionBase {

    public expresionesLogicas() {

    }

    public Object Resolver_Expresion(Object val1, Object val2, String simb) {
        switch (simb) {
            case "||": {
                return ResolverOR(val1, val2);
            }
            case "&&": {
                return ResolverAND(val1, val2);
            }
        }
        return "nulo";
    }

    public Object ResolverOR(Object val1, Object val2) {
        String tipo1 = obtenerTipoExpresion(val1);
        String tipo2 = obtenerTipoExpresion(val2);

        if (tipo1.equalsIgnoreCase("bool") && tipo2.equalsIgnoreCase("bool")) {

            String v1 = getBool(val1);
            String v2 = getBool(val2);
                if (v1.equalsIgnoreCase("verdadero") || v2.equalsIgnoreCase("verdadero")) {
                    return "verdadero";
                } else {
                    return "falso";
                }
        }
        paginaActual.erroresPagina.insertarError("Semantico", "Tipos no validos para realizar un opeacion OR " + tipo1 + " y " + tipo2);
        return "nulo";
    }

    public Object ResolverAND(Object val1, Object val2) {
        String tipo1 = obtenerTipoExpresion(val1);
        String tipo2 = obtenerTipoExpresion(val2);

      if (tipo1.equalsIgnoreCase("bool") && tipo2.equalsIgnoreCase("bool")) {

            String v1 = getBool(val1);
            String v2 = getBool(val2);
                if (v1.equalsIgnoreCase("verdadero") && v2.equalsIgnoreCase("verdadero")) {
                    return "verdadero";
                } else {
                    return "falso";
                }
        }
        paginaActual.erroresPagina.insertarError("Semantico", "Tipos no validos para realizar un opeacion AND " + tipo1 + " y " + tipo2);
        return "nulo";
    }

    public Object ResolverNOT(Object val1) {
        String tipo1 = obtenerTipoExpresion(val1);

        if (tipo1.equalsIgnoreCase("bool")) {

            String valor = getBool(val1);

                if (valor.equalsIgnoreCase("verdadero")) {
                    return "falso";
                } else {
                    return "verdadero";
                }
            
        }
        paginaActual.erroresPagina.insertarError("Semantico", "Tipos no validos para realizar un opeacion NOT " + tipo1);
        return "nulo";
    }

}
