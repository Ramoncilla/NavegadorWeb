/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto1_201122872.CHTML;

import java.util.ArrayList;
import proyecto1_201122872.CHTML.BODY.Cuerpo;
import proyecto1_201122872.CHTML.ElemetoPropiedad.propiedad;
import proyecto1_201122872.CHTML.HEADER.Encabezado;

/**
 *
 * @author Ramonella
 */
public class Chtml extends Etiqueta{
    
    
    public listaElementos elementosChtml;
    public Encabezado header;
    public Cuerpo body;
    
    
    public Chtml(Object elementos, Object header, Object body){
        
        elementosChtml= new listaElementos((ArrayList<propiedad> )elementos);
        this.header = (Encabezado)header;
        this.body= (Cuerpo)body;
        
    }
    
    
}
