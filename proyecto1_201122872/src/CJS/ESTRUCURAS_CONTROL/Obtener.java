/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CJS.ESTRUCURAS_CONTROL;

import CJS.TablaSimbolos.SimbEtiqueta;
import CJS.TablaSimbolos.tablaSimbolos;
import CJS.elementoRetorno;
import CJS.objetoBase;
import proyecto1_201122872.CHTML.Etiqueta;
import static proyecto1_201122872.Proyecto1_201122872.paginaActual;

/**
 *
 * @author Ramonella
 */
public class Obtener extends objetoBase {
    
    String idObjeto="";
    public objetoBase expObjeto;
    
    public Obtener(Object valorId){
        this.expObjeto= (objetoBase)valorId;
        //this.idObjeto= valorId.toString().replace("\"", "");
    }

    @Override
    public elementoRetorno Ejecutar(tablaSimbolos tabla, int contexto) {
        elementoRetorno ret = new elementoRetorno();
        elementoRetorno ret2= expObjeto.Ejecutar(tabla, contexto);
        if(ret2.ValorRetorno instanceof String)
            idObjeto =ret2.ValorRetorno.toString().replace("\"", "");
        
        Etiqueta resultado = paginaActual.documento.obtenerElemento(idObjeto);
        if(resultado!=null){
            
            ret.ValorRetorno= new SimbEtiqueta(resultado);
        }else{
            ret.ValorRetorno="nulo";
        }
return ret;
    }
    
   
    
}
