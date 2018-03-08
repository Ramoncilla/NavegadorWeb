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
public class Grupo extends baseCss{
        public String grupo;
    public List<propiedad> propiedadesCss;
    
    
    public Grupo(Object id, Object prop){
        this.grupo= id.toString();
        this.propiedadesCss= (ArrayList<propiedad>)prop;
        
    }
    
}
