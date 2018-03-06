/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto1_201122872.CHTML.HEADER;
import proyecto1_201122872.CHTML.ElemetoPropiedad.propiedadRuta;
import proyecto1_201122872.CHTML.Etiqueta;
/**
 *
 * @author Ramonella
 */
public class CJS extends Etiqueta{
    
   public String rutaCJS;
    public propiedadRuta ruta;
    
    
    
    public CJS(Object val){
        this.ruta= (propiedadRuta)val;
        this.rutaCJS= ruta.ruta;
    }
    
}
