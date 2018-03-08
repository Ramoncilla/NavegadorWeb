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
public class Fondoelemento extends propiedad {
      public objetoBase expresionFondo;
      String cadenaColor="";
    
    public Fondoelemento(Object cad){
        this.expresionFondo= (objetoBase)cad;
        obtenerValor();
    }
    
    
      public void obtenerValor(){
          expresionBase exp = new expresionBase();
        elementoRetorno r= expresionFondo.Ejecutar(new tablaSimbolos(), 0);
        if(exp.esCadena(exp.obtenerTipoExpresion(r.ValorRetorno))){
            
            this.cadenaColor= r.ValorRetorno.toString();
        }else{

            paginaActual.erroresPagina.insertarError("Semantico", "La propiedad Autoredimension debe traer un valor booleano");
        } 
        
      
    }

    public String getCadenaColor() {
        return cadenaColor;
    }
}
