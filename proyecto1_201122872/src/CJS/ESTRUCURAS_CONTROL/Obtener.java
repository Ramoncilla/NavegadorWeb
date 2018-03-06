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
    
    public String idObjeto;
    
    
    public Obtener(Object valorId){
        this.idObjeto= valorId.toString().replace("\"", "");
    }

    @Override
    public elementoRetorno Ejecutar(tablaSimbolos tabla, int contexto) {
        elementoRetorno ret = new elementoRetorno();
        Etiqueta resultado = paginaActual.documento.obtenerElemento(idObjeto);
        if(resultado!=null){
            
            ret.ValorRetorno= new SimbEtiqueta(resultado);
        }else{
            ret.ValorRetorno="nulo";
        }
return ret;
    }
    
   
    
}
