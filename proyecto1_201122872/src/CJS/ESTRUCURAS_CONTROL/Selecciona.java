/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CJS.ESTRUCURAS_CONTROL;

import CJS.TablaSimbolos.tablaSimbolos;
import CJS.elementoRetorno;
import CJS.objetoBase;

/**
 *
 * @author Ramonella
 */
public class Selecciona extends objetoBase {

    objetoBase expresion;
    CuerpoSelecciona cuerpo;

    public Selecciona(Object exp, Object cuerpo) {
        this.expresion = (objetoBase) exp;
        this.cuerpo = (CuerpoSelecciona) cuerpo;
    }

    @Override
    public elementoRetorno Ejecutar(tablaSimbolos tabla, int contexto) {
        elementoRetorno valorExpresion = this.expresion.Ejecutar(tabla, contexto);
        Caso temporal;
        elementoRetorno expCaso;
        elementoRetorno retCaso = new elementoRetorno();
        boolean banderaPasar = false;
        boolean banderaDefecto = true;
        for (int i = 0; i < this.cuerpo.casosSelecciona.size(); i++) {
            if (!retCaso.detener) {
                temporal = this.cuerpo.casosSelecciona.get(i);
                expCaso = temporal.ejecutarExpresion(tabla, contexto);
                if (expCaso.ValorRetorno.equals(valorExpresion.ValorRetorno) || banderaPasar) {
                    banderaDefecto = false;
                    banderaPasar = true;
                    contexto++;
                    retCaso = temporal.Ejecutar(tabla, contexto);
                    tabla.eliminarSimbolosLocales(contexto);
                    contexto--;
                }
            } else {
                break;
            }

        }

        if (banderaDefecto) {
            contexto++;
            retCaso = cuerpo.defecto.Ejecutar(tabla, contexto);
            tabla.eliminarSimbolosLocales(contexto);
            contexto--;
        }

        return retCaso;
    }

}
