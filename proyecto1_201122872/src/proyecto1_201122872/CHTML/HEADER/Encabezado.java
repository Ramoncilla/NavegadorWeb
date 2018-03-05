/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto1_201122872.CHTML.HEADER;
import java.util.ArrayList;
import java.util.List;
import proyecto1_201122872.CHTML.Etiqueta;
/**
 *
 * @author Ramonella
 */
public class Encabezado extends Etiqueta{
    
    List<Etiqueta> etiquetasEncabezado;
    
    
    public Encabezado(Object lista){
        this.etiquetasEncabezado= (ArrayList<Etiqueta>)lista;
    }
    
    
    public List<String>obtenerCJS(){
      List<String> rutas = new ArrayList<>();
      Etiqueta temporal;
        for (int i = 0; i < this.etiquetasEncabezado.size(); i++) {
           temporal = this.etiquetasEncabezado.get(i);
           if(temporal instanceof CJS){
               rutas.add(((CJS)temporal).rutaCJS);
           }
        }
      
      return rutas;
    }
    
    public List<String>obtenerCSS(){
         List<String> rutas = new ArrayList<>();
         Etiqueta temporal;
        for (int i = 0; i < this.etiquetasEncabezado.size(); i++) {
           temporal = this.etiquetasEncabezado.get(i);
           if(temporal instanceof CCSS){
               rutas.add(((CCSS)temporal).rutaCSS);
           }
        }
      
      return rutas;
        
    }
    
    
    public String obtenerTitulos(){
      Etiqueta temporal;
        for (int i = 0; i < this.etiquetasEncabezado.size(); i++) {
           temporal = this.etiquetasEncabezado.get(i);
           if(temporal instanceof Titulo){
               return ((Titulo)temporal).tituloPagina;
           }
        }
      
      return "";  
    }
    
    
    
    
    
    
}
