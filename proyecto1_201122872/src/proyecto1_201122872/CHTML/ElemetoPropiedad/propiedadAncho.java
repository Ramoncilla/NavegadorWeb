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
public class propiedadAncho extends propiedad{
    
    public Object valorAncho;
    
    
    public propiedadAncho(Object ancho){
        this.valorAncho= ancho.toString().replace("\"", "");
    }
    
    
}
