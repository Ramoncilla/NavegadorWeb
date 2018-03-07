/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CJS.TablaSimbolos;

import static proyecto1_201122872.Proyecto1_201122872.paginaActual;

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
    
    
    public SimbArreglo clonar(){
        SimbArreglo nuevo = new SimbArreglo(this.nombre, this.tamanhoArreglo, this.contexto);
        Object []valores = new Object[this.vector.length];
        for (int i = 0; i < this.vector.length; i++) {
            valores[i]=vector[i];
        }
        nuevo.vector=valores;
        return nuevo;
    }
    
    
    public double conteoArreglo(){
        return this.tamanhoArreglo;
    }
    
    
    public Object obtenerValorPoscion(int pos){
        
        if(!(pos<0)){
            if(pos<vector.length){
                for (int i = 0; i < vector.length; i++) {
                    if(pos==i){
                        return vector[i];
                    }
                }
            }else{
                paginaActual.erroresPagina.insertarError("Semantico", "El tamanho del arreglo "+ this.nombre+", es de "+ vector.length+", no se puede acceder a la posicion "+ pos);
                return "nulo";
            }
        }else{
           paginaActual.erroresPagina.insertarError("Semantico", "No se puede acceder a posciones negativas del arreglo "+this.nombre);
           return "nulo"; 
        }  
      
      return "nulo";
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
