/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CJS.ARBOL.EXPRESION;

import CJS.TablaSimbolos.SimbArreglo;
import CJS.TablaSimbolos.SimbEtiqueta;
import CJS.TablaSimbolos.SimbVariable;
import CJS.TablaSimbolos.Simbolo;
import CJS.TablaSimbolos.tablaSimbolos;
import CJS.elementoRetorno;
import CJS.objetoBase;
import static proyecto1_201122872.Proyecto1_201122872.paginaActual;

/**
 *
 * @author Ramonella
 */
public class Id extends objetoBase{
    
    public String id;
    
    
    public Id(Object val){
        this.id= val.toString();
    }

    @Override
    public elementoRetorno Ejecutar(tablaSimbolos tabla, int contexto) {
        elementoRetorno ret = new elementoRetorno();
        String amb="";
        if(contexto>0){
            amb="local";
        }else{
            amb="global";
        }
       Simbolo simb = tabla.obtenerSimbolo(id,amb, contexto);
       if(simb!=null){
           if(simb instanceof SimbVariable){
               SimbVariable c = (SimbVariable)simb;
               ret.ValorRetorno= c.valorVariable;
               super.retorno.ValorRetorno=c.valorVariable;
               
           }else if(simb instanceof SimbArreglo){
               SimbArreglo arr = (SimbArreglo)simb;
               SimbArreglo nuevo = arr.clonar();
               super.retorno.ValorRetorno= nuevo;
           }else if(simb instanceof SimbEtiqueta){
                SimbEtiqueta et = (SimbEtiqueta)simb;
               SimbEtiqueta et2 = et.clonar();
               super.retorno.ValorRetorno= et2;
               
           }
       }else if(amb.equalsIgnoreCase("local")){
           simb = tabla.obtenerSimbolo(id,"global", contexto);
            if(simb instanceof SimbVariable){
               SimbVariable c = (SimbVariable)simb;
               ret.ValorRetorno= c.valorVariable;
               super.retorno.ValorRetorno=c.valorVariable;
               
           }else if(simb instanceof SimbArreglo){
               SimbArreglo arr = (SimbArreglo)simb;
               SimbArreglo nuevo = arr.clonar();
               super.retorno.ValorRetorno= nuevo;
               
           }else if(simb instanceof SimbEtiqueta){
               SimbEtiqueta et = (SimbEtiqueta)simb;
               SimbEtiqueta et2 = et.clonar();
               super.retorno.ValorRetorno= et2;
           }
           
           
           
       }else{
           paginaActual.erroresPagina.insertarError("Semantico", "El elemento "+id+", no existe");
       }
       
        
        return ret;
    }
    
    
    
    
}
