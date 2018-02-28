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
    
    
    public SimbArreglo(String nombre, double tamanhoArreglo, int ctx){
        int val = (int)tamanhoArreglo;
        this.vector = new  Object [val];
        iniciarArreglo();
        this.nombre = nombre;
       // this.disponible=false;
        this.tamanhoArreglo= tamanhoArreglo;
        this.contexto=ctx;
    }
    
    private void iniciarArreglo(){
        for (int i = 0; i < vector.length; i++) {
            vector[i]="nulo";
        }
    }
    
    
    
    public double conteoArreglo(){
        return this.tamanhoArreglo;
    }
    
    public String aTextoArreglo() {

        String retorno = "{";
        for (int i = 0; i < vector.length; i++) {
            if (i == (vector.length - 1)) {
                retorno += vector[i];
            } else {
                retorno += vector[i] + ",";
            }

        }
        retorno += "}";

        return retorno;

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
    
    
    
        @Override
    public String imprimirHTML(){
        
        String cad = "<td>"+ this.nombre+"</td>\n"
                + 
                "<td>"+ this.ambito+"</td>\n"+
                
                "<td>"+ this.tamanhoArreglo+"</td>\n";
        return cad;
    }
    
    
   
    
    
    
    
    
   
    
}
