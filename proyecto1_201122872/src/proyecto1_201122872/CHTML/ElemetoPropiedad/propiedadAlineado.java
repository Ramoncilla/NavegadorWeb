/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto1_201122872.CHTML.ElemetoPropiedad;
import static proyecto1_201122872.Proyecto1_201122872.paginaActual;

/**
 *
 * @author Ramonella
 */
public class propiedadAlineado extends propiedad{
    
    public String alineado ;
    
    public propiedadAlineado(Object alineacion){
        
        String valor= alineacion.toString().replace("\"", "");
        if(valor.equalsIgnoreCase("izquierda")){
            this.alineado= "izquierda";
        }else if(valor.equalsIgnoreCase("derecha")){
            this.alineado="derecha";
        }else if(valor.equalsIgnoreCase("centrado")){
            this.alineado="centrado";
        }else{
            paginaActual.erroresPagina.insertarError("Semantico", "Una alineacion no puede ser de tipo "+ alineacion.toString());
            this.alineado= "izquierda";
        }
        
        
        
        
        
        
        
    }
    
    
    
    
}
