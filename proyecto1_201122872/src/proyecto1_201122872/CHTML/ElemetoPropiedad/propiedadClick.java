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
public class propiedadClick extends propiedad{
    
    public String nombreFuncion;
    
    public propiedadClick(Object valor){
    
        nombreFuncion= valor.toString().replace("(", "").replace(")", "");
    }
    
}
