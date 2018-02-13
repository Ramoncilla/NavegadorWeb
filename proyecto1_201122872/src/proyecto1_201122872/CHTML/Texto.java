/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto1_201122872.CHTML;

import java.util.ArrayList;
import java.util.List;
import proyecto1_201122872.CHTML.ElemetoPropiedad.propiedad;

/**
 *
 * @author Ramonella
 */
public class Texto extends Etiqueta {
    
    public List<propiedad>elementos= new ArrayList<>();
    public String cadena;
    
    public Texto(Object propiedades, Object cadenaTexto){
        
        this.elementos = (List<propiedad>)propiedades;
        cadena =cadenaTexto.toString();
        
    }
    
    
    
    
    
}
