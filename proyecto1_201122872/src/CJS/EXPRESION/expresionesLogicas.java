/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CJS.EXPRESION;

import static proyecto1_201122872.Proyecto1_201122872.erroresEjecucion;

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

        if (tipo1.equalsIgnoreCase("numero") && tipo2.equalsIgnoreCase("numero")) {

            double dou1 = getNumero(val1);
            double dou2 = getNumero(val2);

            if ((dou1 == 1 || dou1 == 0)
                    && (dou2 == 1 || dou2 == 0)) {

                if (dou1 == 1 || dou2 == 1) {
                    return 1;
                } else {
                    return 0;
                }
            }
        }
        erroresEjecucion.insertarError("Semantico", "Tipos no validos para realizar un opeacion OR " + tipo1 + " y " + tipo2);
        return "nulo";
    }

    public Object ResolverAND(Object val1, Object val2) {
        String tipo1 = obtenerTipoExpresion(val1);
        String tipo2 = obtenerTipoExpresion(val2);

        if (tipo1.equalsIgnoreCase("numero") && tipo2.equalsIgnoreCase("numero")) {

            double dou1 = getNumero(val1);
            double dou2 = getNumero(val2);

            if ((dou1 == 1 || dou1 == 0)
                    && (dou2 == 1 || dou2 == 0)) {

                if (dou1 == 1 && dou2 == 1) {
                    return 1;
                } else {
                    return 0;
                }
            }
        }
        erroresEjecucion.insertarError("Semantico", "Tipos no validos para realizar un opeacion AND " + tipo1 + " y " + tipo2);
        return "nulo";
    }

    public Object ResolverNOT(Object val1) {
        String tipo1 = obtenerTipoExpresion(val1);

        if (tipo1.equalsIgnoreCase("numero")) {

            double dou1 = getNumero(val1);

            if ((dou1 == 1 || dou1 == 0)) {

                if (dou1 == 1) {
                    return 0;
                } else {
                    return 1;
                }
            }
        }
        erroresEjecucion.insertarError("Semantico", "Tipos no validos para realizar un opeacion NOT " + tipo1);
        return "nulo";
    }

}
