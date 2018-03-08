/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bCSS;

import java.util.ArrayList;
import java.util.List;
import proyecto1_201122872.CHTML.ElemetoPropiedad.propiedad;

/**
 *
 * @author Ramonella
 */
public class ID extends baseCss {
    public String id;
    public List<propiedad> propiedadesCss;
    
    
    public ID(Object id, Object prop){
        this.id= id.toString();
        this.propiedadesCss= (ArrayList<propiedad>)prop;
        
    }
    
}
