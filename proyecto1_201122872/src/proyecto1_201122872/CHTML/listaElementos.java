/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto1_201122872.CHTML;

import java.util.ArrayList;
import java.util.List;
import proyecto1_201122872.CHTML.ElemetoPropiedad.propiedad;
import proyecto1_201122872.CHTML.ElemetoPropiedad.propiedadAlineado;
import proyecto1_201122872.CHTML.ElemetoPropiedad.propiedadRuta;

/**
 *
 * @author Ramonella
 */
public class listaElementos {
    
   public List<propiedad> listadoElementos;

 public listaElementos(ArrayList<propiedad> listado){
    
    listadoElementos = listado;
 }  

 public propiedadRuta obtenerRuta(){
     
     propiedad temporal;
     for (int i = 0; i <this.listadoElementos.size(); i++) {
         temporal = listadoElementos.get(i);
         if(temporal instanceof propiedadRuta){
             return (propiedadRuta)temporal;
         }
     }
     return null;
 }

public propiedadAlineado obtenerAlineado(){
     
     propiedad temporal;
     for (int i = 0; i <this.listadoElementos.size(); i++) {
         temporal = listadoElementos.get(i);
         if(temporal instanceof propiedadAlineado){
             return (propiedadAlineado)temporal;
         }
     }
     return null;
 }

 


}
