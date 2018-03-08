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
public class Tamtex extends propiedad{
      public objetoBase expresionSize;
      double valorTamanho=10;
    
    public Tamtex(Object cad){
        this.expresionSize= (objetoBase)cad;
        obtenerValor();
    }
    
    
     public void obtenerValor(){
          expresionBase exp = new expresionBase();
        elementoRetorno r= expresionSize.Ejecutar(new tablaSimbolos(), 0);
        if(exp.esNumero(exp.obtenerTipoExpresion(r.ValorRetorno))){
            
            this.valorTamanho= Double.parseDouble(r.ValorRetorno.toString());
        }else{

            paginaActual.erroresPagina.insertarError("Semantico", "La propiedad Autoredimension debe traer un valor booleano");
        } 
        
      
    }

    public double getValorTamanho() {
        return valorTamanho;
    }

   
     
     
    
}
