/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bCSS;

import CJS.EXPRESION.expresionBase;
import CJS.TablaSimbolos.tablaSimbolos;
import CJS.elementoRetorno;
import CJS.objetoBase;
import proyecto1_201122872.CHTML.ElemetoPropiedad.propiedad;
import static proyecto1_201122872.Proyecto1_201122872.paginaActual;

/**
 *
 * @author Ramonella
 */
public class Visible extends propiedad{
      public objetoBase expresion;
      String valVisible="true";
    
    public Visible(Object cad){
        this.expresion= (objetoBase)cad;
        obtenerValor();
    }
    
       public void obtenerValor(){
          expresionBase exp = new expresionBase();
        elementoRetorno r= expresion.Ejecutar(new tablaSimbolos(), 0);
        if(exp.esBool(exp.obtenerTipoExpresion(r.ValorRetorno))){
            
            this.valVisible= r.ValorRetorno.toString();
        }else{

            paginaActual.erroresPagina.insertarError("Semantico", "La propiedad Visible debe traer un valor booleano");
        } 
        
      
    }

    public String getVisible() {
        return valVisible;
    }
      
}
