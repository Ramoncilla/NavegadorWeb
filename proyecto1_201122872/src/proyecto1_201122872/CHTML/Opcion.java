/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto1_201122872.CHTML;

/**
 *
 * @author Ramonella
 */
public class Opcion {
    
    public String contenidoOpcion;
    public Object valorOpcion;
    
    
    public Opcion(Object valor){
        this.contenidoOpcion="";
        this.valorOpcion= valor;
    }
       
    public void setContenido(Object cont){
        this.contenidoOpcion= cont.toString();
        if(valorOpcion instanceof String){
            if(valorOpcion.toString().equalsIgnoreCase("nulo")){
                this.valorOpcion=contenidoOpcion;
            }
        }
    }
    
    
    
    
}
