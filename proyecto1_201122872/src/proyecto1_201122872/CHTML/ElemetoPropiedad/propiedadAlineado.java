/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto1_201122872.CHTML.ElemetoPropiedad;

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
            //reportar error
            this.alineado= "izquierda";
        }
        
        
        
        
        
        
    }
    
    
    
    
}
