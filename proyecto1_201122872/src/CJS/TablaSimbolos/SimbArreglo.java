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
    public Object[] vector;
    
    
    public SimbArreglo(String nombre, double tamanhoArreglo){
        int val = (int)tamanhoArreglo;
        this.vector = new  Object [val];
        iniciarArreglo();
        this.nombre = nombre;
        this.disponible=false;
        this.tamanhoArreglo= tamanhoArreglo;
    }
    
    private void iniciarArreglo(){
        for (int i = 0; i < vector.length; i++) {
            vector[i]="nulo";
        }
    }
    
    
    @Override
    public String imprimirSimbolo(){
        String cad= "Nombre: "+ this.nombre+
                "\nAmbito: "+ this.ambito+
                "\n Tamanho: "+this.tamanhoArreglo;
      
            cad+="\nElementos: ";
            for (int i = 0; i < vector.length; i++) {
                if(vector[i]!= null)
                    cad+="\n["+i+"]-> "+vector[i];
                else
                    cad+="\n["+i+"]-> Nulo";
            }
        return cad;
    }
    
    
    
    
    
    
   
    
    
    
    
    
   
    
}
