/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CJS.TablaSimbolos;

import CJS.objetoBase;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Ramonella
 */
public class SimbArreglo extends Simbolo{
    
  
    public double tamanhoArreglo=0;
    public List<Object> vector;
    
    
    public SimbArreglo(String nombre, double tamanhoArreglo){
        this.vector = new ArrayList<>();
        this.nombre = nombre;
        this.disponible=false;
        this.tamanhoArreglo= tamanhoArreglo;
    }
    
    
    
    @Override
    public String imprimirSimbolo(){
        String cad= "Nombre: "+ this.nombre+
                "\nAmbito: "+ this.ambito+
                "\n Tamanho: "+this.tamanhoArreglo;
        if(vector.isEmpty()){
            cad+="\nElementos: vacio";
        }else{
            /*cad+="\nElementos: ";
            for (int i = 0; i < vector.size(); i++) {
                cad+="\n"+vector.get(i)
            }*/
        }
        
        
        return cad;
    }
    
    
    
    
    
    
   
    
    
    
    
    
   
    
}
