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
public class Conteo extends objetoBase {

    public String nombreArreglo;

    public Conteo(Object sent) {
        System.out.println(sent);
        String cad= sent.toString().replace(".", "&&");
        String[] elementos = cad.split("&&");
        if (elementos.length == 2) {
            this.nombreArreglo = elementos[0];
        }
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
        
        if(simb!=null){
            ret.ValorRetorno= simb.conteoArreglo();
            super.retorno.ValorRetorno= simb.conteoArreglo();
           
        }else{
            super.retorno.ValorRetorno= "nulo";
            erroresEjecucion.insertarError("semantico", "No existe el arreglo "+ nombreArreglo);
        }
        
        return retorno;

    }
}
