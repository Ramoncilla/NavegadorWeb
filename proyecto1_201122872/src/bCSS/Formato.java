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
public class Formato extends propiedad{
    
    public List<String> listaFormatos;
    
    public Formato(Object lista){
        this.listaFormatos = (ArrayList<String>)lista;
    }
    
    
}
