/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CJS.TablaSimbolos;

import CJS.ARBOL.EXPRESION.DateTime;
import CJS.ARBOL.EXPRESION.Datee;
import java.util.ArrayList;
import java.util.List;
import proyecto1_201122872.CHTML.Etiqueta;
import static proyecto1_201122872.Proyecto1_201122872.erroresEjecucion;

/**
 *
 * @author Ramonella
 */
public class tablaSimbolos {
    
    public List<Simbolo>listaSimbolos;
    
    public tablaSimbolos(){
        this.listaSimbolos = new ArrayList<>();
    }
    
    
    /*-------------------------------------- Asignaciones -------------------------*/
    
    public boolean asignarPosicionArreglo(String nombre, Object pos, Object valor, int contexto){
        
        Simbolo temporal;
        String ctx= obtenerContexto(contexto);
        boolean g= esNumero(obtenerTipoExpresion(pos));
        
        if(g){
            double pi = Double.parseDouble(pos.toString());
           int posicion = (int)pi;
        for (int i = 0; i < this.listaSimbolos.size(); i++) {
           temporal= this.listaSimbolos.get(i);
            if(temporal.nombre.equalsIgnoreCase(nombre) && ctx.equalsIgnoreCase(temporal.ambito)){
                if(temporal instanceof SimbArreglo){
                    SimbArreglo array = (SimbArreglo)temporal;
                    if(posicion<=array.tamanhoArreglo && posicion >=0){
                        int p = (int) posicion;
                        array.vector[p]= valor;
                        this.listaSimbolos.set(i, array);
                        return true;    
                    }else{
                        erroresEjecucion.insertarError("Semantico", "En el indice que desea insertar un elemenot esta fuera de rango");
                        return false;
                    }
                }else{
                    erroresEjecucion.insertarError("semantico", "El elemento "+ nombre+", no es un arreglo");
                    return false;
                }
            }
                      
        }}else{
            erroresEjecucion.insertarError("Semantico", "El indice debe ser un numero");
            return false;
        }
        
        erroresEjecucion.insertarError("sementico", "El elemento "+ nombre+", no existe");
        return false;
    }
    
    
    

    private Object obtenerSimboloAsignado(Simbolo simb, Object valor){
       
        String tipoValor = tipoExpresion(valor); // numero, cadena, date, etiqueta, listaObjectos
        int tipoValorEntero = tipoExpresionEntero(valor);
        SimbVariable variable;
        SimbEtiqueta etiquetal;
        SimbArreglo arreglo;
        if(tipoValorEntero ==1){
            variable = new SimbVariable(simb.nombre);
            variable.ambito= simb.ambito;
          //  variable.disponible=false;
            variable.tipoVariable= tipoValor;
            variable.valorVariable= valor;
            return variable;
        }
        if(tipoValorEntero ==3){
           Object[]valores = (Object[])valor;
           int noPos= valores.length;
           arreglo = new SimbArreglo(simb.nombre, noPos);
           arreglo.ambito= simb.ambito;
          // arreglo.disponible=false;
           arreglo.tamanhoArreglo=noPos;
           arreglo.vector=valores;
           return arreglo;
        }
  
        return "nulo";
    }
    
 
    public boolean asignarSimbolo(String nombre, Object valor, int contexto) {
        Simbolo simbTemporal;
        String ambito = obtenerContexto(contexto);
        String tipoValor = tipoExpresion(valor); //cadena numero date etiquera
        int tipoValorEntero = tipoExpresionEntero(valor);
        Object res;
        if (existeSimbolo(nombre, contexto)) {
            //if (esDisponible(nombre, contexto)) {
                for (int i = 0; i < this.listaSimbolos.size(); i++) {
                    simbTemporal = this.listaSimbolos.get(i);
                    if (simbTemporal.nombre.equalsIgnoreCase(nombre)
                            && simbTemporal.ambito.equalsIgnoreCase(ambito)) {
                        res = obtenerSimboloAsignado(simbTemporal, valor);
                        if (res instanceof Simbolo) {
                            switch (tipoValorEntero) {
                                case 1: // es una variable
                                    if (res instanceof SimbVariable) {
                                        SimbVariable var = (SimbVariable) res;
                                        this.listaSimbolos.set(i, var);
                                    }
                                    return true;
                                case 2: // es una etiqueta
                                    return true;
                                case 3: // es un arreglo
                                    if(res instanceof SimbArreglo){
                                        SimbArreglo arr = (SimbArreglo)res;
                                        this.listaSimbolos.set(i, arr);
                                    }
                                    return true;
                            }
                        } else {
                            erroresEjecucion.insertarError("semantico", "No existe la variable " + nombre + ", no se puede realizar asignacinon");
                            return false;
                        }
                    }
                }
           /* } else {  //debemos asegurar de guardar un elemento del mismo tipo porque no se encuentra disponible
                for (int i = 0; i < this.listaSimbolos.size(); i++) {
                    simbTemporal = this.listaSimbolos.get(i);
                    if (simbTemporal.nombre.equalsIgnoreCase(nombre)
                            && simbTemporal.ambito.equalsIgnoreCase(ambito)) {
                        
                        if(tipoValorEntero == 1 && (simbTemporal instanceof SimbVariable)){
                            SimbVariable var = (SimbVariable) simbTemporal;
                            if(tipoValor.equalsIgnoreCase(var.tipoVariable)){
                                var.valorVariable= valor;
                                this.listaSimbolos.set(i, var);
                                return true;
                                        
                                
                            }else{
                                erroresEjecucion.insertarError("Semantico", "El tipo de la variable "+var.nombre+" es, "+ var.tipoVariable+", imposible asignar un "+ tipoValor);
                             return false;
                            }
                            
                        }else if(tipoValorEntero == 2 && (simbTemporal instanceof SimbEtiqueta)){
                            return true;
                            
                        }else if(tipoValorEntero ==3 && (simbTemporal instanceof SimbArreglo)){
                            return true;
                            
                        }else{
                            erroresEjecucion.insertarError("Semantico", "Tipos no validos para la asignacion de una variable, "+ simbTemporal.nombre+", con "+ valor);
                             return false;
                            
                        }
                        
  
                    }
                    
                    
                }
              
                
                
                
            }*/

        }

        erroresEjecucion.insertarError("Semantico", "No se puede realizar la asignacion a " + nombre + ", dicho elemento no existe");
        return false;
    }
    
     
    /*--------------------------------- Declaraciones --------------------------------------------*/
    
    public boolean agregarArregloSinAsignacion(String nombre, Object size, int contexto){
        
        if(!(existeSimbolo(nombre,contexto))){
            String tipoSize = tipoExpresion(size);
            if(tipoSize.equalsIgnoreCase("numero")){
                double tamanhoArreglo = Double.parseDouble(size.toString());
                SimbArreglo nuevoArreglo = new SimbArreglo(nombre, tamanhoArreglo);
                nuevoArreglo.ambito= obtenerContexto(contexto);
                //nuevoArreglo.disponible=true;
                this.listaSimbolos.add(nuevoArreglo);
                return true;
            }
        }
        erroresEjecucion.insertarError("Semantico", "La arreglo "+ nombre+", ya existe en un ambito actual");
        return false;
    }
    
    public boolean agregarSimbolo(Simbolo simb, int contexto){
        boolean existe;
        if(contexto>0){
            //estoy en un ambito local
            existe= existeSimbolo(simb.nombre, contexto);
            if(!existe){
                this.listaSimbolos.add(simb);
                return true;
            }else{
                erroresEjecucion.insertarError("Semantico", "La variable "+ simb.nombre+", ya existe en un ambito local");
                return false;
            }
        }else{
            //estoy en un ambito global
            existe= existeSimbolo(simb.nombre, contexto);
            if(!existe){
               this.listaSimbolos.add(simb);
                return true; 
            }else{
                erroresEjecucion.insertarError("Semantico", "La variable "+ simb.nombre+", ya existe en un ambito global");
                return false;
            }
            
        }
    }
    
    
    
     /*------- Extras ---------------*/
    
   private boolean existeSimbolo(String nombre, int contexto){
      String ambito="";
        if(contexto>0)
            ambito="local";
        else
           ambito="global"; 
       
       Simbolo simbTemporal;
       for (int i = 0; i < listaSimbolos.size(); i++) {
           simbTemporal = listaSimbolos.get(i);
           if(simbTemporal.nombre.equalsIgnoreCase(nombre) &&
                   simbTemporal.ambito.equalsIgnoreCase(ambito)){
               return true;
           }
       }
       return false;
   }
   
   
    /* private boolean esDisponible(String nombre, int contexto){
        String ambito="";
        if(contexto>0)
            ambito="local";
        else
           ambito="global";
        Simbolo temporal;
        for (int i = 0; i < this.listaSimbolos.size(); i++) {
            temporal = this.listaSimbolos.get(i);
            if(temporal.ambito.equalsIgnoreCase(ambito)&&
                    temporal.nombre.equalsIgnoreCase(nombre)){
                return true;
            }
        }
        return false;
    }*/
    
    
    private String obtenerContexto(int contexto){
        if(contexto>0)
            return "local";
        else
            return "global";
        
    }
   
   
    private String tipoExpresion(Object val){
        
        if(val instanceof Object[]){
            return "arreglo";
        }
         if ((val instanceof Double)|| (val instanceof Integer)) {
            return "numero";
        }
       
        if (val instanceof String) {
            
            if(((String)val).equalsIgnoreCase("verdadero")||
                    ((String) val).equalsIgnoreCase("falso")){
                return "bool";
            }else if(((String)val).equalsIgnoreCase("nulo")){
               return "nulo"; 
            } else{
                return "cadena"; 
            }
        }
        
        if(val instanceof Datee){
            return "Date";
        }
        if(val instanceof DateTime ){
            return "DateTime";
        }
         if(val instanceof Etiqueta){
             return "etiqueta";
         }
        return "nulo";
        
    }
    
    
    
    private int tipoExpresionEntero(Object val){
        //0 nulo 1 variables 2 etiquestas 3 arreglos
        if(val!= null){
            
             if(val instanceof Object[]){
            return 3;
        }
             
             if ((val instanceof Double)|| (val instanceof Integer)) {
            return 1;
        }
       
        if (val instanceof String) {
            
            if(((String)val).equalsIgnoreCase("verdadero")||
                    ((String) val).equalsIgnoreCase("falso")){
                return 1;
            }else if(((String)val).equalsIgnoreCase("nulo")){
               return 0; 
            } else{
                return 1; 
            }
        }
        
        if(val instanceof Datee){
            return 1;
        }
        if(val instanceof DateTime ){
            return 1;
        }
         if(val instanceof Etiqueta){
             return 2;
         }
        }
        return 0;
        
    }
    
   
    
    public void imprimirTablaSimbolos(){
        
      System.out.println("------------INICIO TABLA-------------------------"); 
        for (int i = 0; i < this.listaSimbolos.size(); i++) {
            System.out.println(i+"  "+ listaSimbolos.get(i).imprimirSimbolo());
            
        }
       System.out.println("---------------FIN TABLA----------------------"); 
    }
    
    
      public boolean esNumero(String tipo) {
        return tipo.equalsIgnoreCase("numero");
    }
      
      
        public  String obtenerTipoExpresion(Object val) {
        
        if ((val instanceof Double)|| (val instanceof Integer)) {
            return "numero";
        }
       
        if (val instanceof String) {
            
            if(((String)val).equalsIgnoreCase("verdadero")||
                    ((String) val).equalsIgnoreCase("falso")){
                return "bool";
            }else if(((String)val).equalsIgnoreCase("nulo")){
               return "nulo"; 
            } else{
                return "cadena"; 
            }
        }
        
        if(val instanceof Datee){
            return "Date";
        }
        if(val instanceof DateTime ){
            return "DateTime";
        }
        
        return "nulo";
    }
     
      
}
