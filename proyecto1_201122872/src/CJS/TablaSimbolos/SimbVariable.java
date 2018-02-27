/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CJS.TablaSimbolos;

import CJS.objetoBase;

/**
 *
 * @author Ramonella
 */
public class SimbVariable extends Simbolo{
    
   public objetoBase expresionVariable;
   public Object valorVariable;
   public String tipoVariable;
     
   
   public SimbVariable(String nombre){
       this.nombre= nombre;
      // this.disponible=true; 
   }
    
   
   @Override
    public String imprimirSimbolo(){
        
        String cad = "Nombre: "+ this.nombre+
                "\nTipo: "+ this.tipoVariable+
                "\nValor: "+ this.valorVariable+
                "\nAMbito: "+ this.ambito+"\n";
        return cad;
    }
    
    
    @Override
    public String imprimirHTML(){
        
        String cad = "<td>"+ this.nombre+"</td>\n"
                + 
                "<td>"+ this.tipoVariable+"</td>\n"+
                
                "<td>"+ this.valorVariable+"</td>\n"+
                
                "<td>"+ this.ambito+"</td>\n";
        return cad;
    }
    
}
