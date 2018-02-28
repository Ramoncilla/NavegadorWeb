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
public class Unario extends objetoBase {

    public objetoBase expresionUnario;
    public String operador;

    public Unario(Object expresion, Object opereandor) {

        this.expresionUnario = (objetoBase) expresion;
        this.operador = opereandor.toString();
    }

    @Override
    public elementoRetorno Ejecutar(tablaSimbolos tabla, int contexto) {

        elementoRetorno ret = this.expresionUnario.Ejecutar(tabla, contexto);
        if (ret.ValorRetorno != null) {
            if (obtenerTipoExpresion(ret.ValorRetorno).equalsIgnoreCase("numero")) {

                double dou = Double.parseDouble(ret.ValorRetorno.toString());
                if (operador.equalsIgnoreCase("++")) {
                    dou++;
                } else {
                    dou--;
                }
                ret.ValorRetorno = dou;
                super.retorno.ValorRetorno = dou;

            } else if (obtenerTipoExpresion(ret.ValorRetorno).equalsIgnoreCase("bool")) {
                double dou = getBoolNumero(ret.ValorRetorno);
                if (operador.equalsIgnoreCase("++")) {
                    dou++;
                } else {
                    dou--;
                }
                ret.ValorRetorno = dou;
                super.retorno.ValorRetorno = dou;

            }

        }

        return ret;
    }

    private Double getBoolNumero(Object val) {
        if (val.toString().equalsIgnoreCase("verdadero")) {
            return 1.0;
        } else {
            return 0.0;
        }
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
