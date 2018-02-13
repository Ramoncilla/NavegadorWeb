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
public class propiedad {
    
    
    public int obtenerTipoPropiedad(propiedad elemento){
        /*
        1 := id
        2 := alto
        3 := ancho
        4:= alineado
        */
        if(elemento instanceof propiedadId){
            return 1;
        }else if(elemento instanceof propiedadAncho){
            return 3;
        }else if(elemento instanceof propiedadAlto){
            return 2;
        }else{
            return 4;
        }
    }
    
}
