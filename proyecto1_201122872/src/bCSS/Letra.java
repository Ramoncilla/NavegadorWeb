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
public class Letra extends propiedad{
    
    public objetoBase expresionLetra;
    String fuente="";
    
    public Letra(Object cad){
        this.expresionLetra= (objetoBase)cad;
        obtenerValor();
    }
    
    
       public void obtenerValor(){
          expresionBase exp = new expresionBase();
        elementoRetorno r= expresionLetra.Ejecutar(new tablaSimbolos(), 0);
        if(exp.esCadena(exp.obtenerTipoExpresion(r.ValorRetorno))){
            
            this.fuente= r.ValorRetorno.toString();
        }else{

            paginaActual.erroresPagina.insertarError("Semantico", "La propiedad Autoredimension debe traer un valor booleano");
        } 
        
      
    }

    public String getFuente() {
        return fuente;
    }
      
    
    
}
