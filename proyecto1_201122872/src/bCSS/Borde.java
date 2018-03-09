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
public class Borde extends propiedad {
    
       public objetoBase expresionSize;
       public objetoBase expresionColor;
       public objetoBase expresionCurva;
       double Vsize=5;
       String Vcolor ="black";
       String Vcurva="false";
        
        
        
    
    public Borde(Object v0, Object v1, Object v2){
        this.expresionSize = (objetoBase)v0;
        this.expresionColor = (objetoBase)v1;
        this.expresionCurva = (objetoBase)v2;
        asignarValores();
    }
    
     public void asignarValores(){
         
         Object size = expresionSize.Ejecutar(new tablaSimbolos(), 0).ValorRetorno;
         Object color = expresionColor.Ejecutar(new tablaSimbolos(), 0).ValorRetorno;
         Object curva=expresionCurva.Ejecutar(new tablaSimbolos(), 0).ValorRetorno;
         
         expresionBase exp = new expresionBase();
         String tSize = exp.obtenerTipoExpresion(size);
         String tColor = exp.obtenerTipoExpresion(color);
         String tCurva= exp.obtenerTipoExpresion(curva);
         
         if(exp.esNumero(tSize) && exp.esCadena(tColor) && exp.esBool(tCurva)){
             this.Vsize=Double.parseDouble(size.toString());
             this.Vcolor= color.toString();
             this.Vcurva=curva.toString();
             
         }else{
            
            paginaActual.erroresPagina.insertarError("Semantico", "La propiedad borde no coinciden con los tipos"); 
         }
         
    }

    public double getVsize() {
        return Vsize;
    }

    public String getVcolor() {
        return Vcolor;
    }

    public String getVcurva() {
        return Vcurva;
    }
     
     
     
    
}
