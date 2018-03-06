/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package zInterfaz;

import CJS.ESTRUCURAS_CONTROL.Observador;
import CJS.TablaSimbolos.tablaSimbolos;
import CJS.elementoRetorno;
import CJS.objetoBase;
import Funciones.Funcion;
import Funciones.ListaFunciones;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Ramonella
 */
public class retornoCJS {
    
    public ListaFunciones lFunciones;
    public List<objetoBase> sentenciasLibres;
    public List<Observador> observadores;
    
    
    public retornoCJS(){
        this.lFunciones= new ListaFunciones();
        this.sentenciasLibres= new ArrayList<>();
        this.observadores= new ArrayList<>();
    }
    
    public void insertarFuncion(Funcion nueva){
        this.lFunciones.insertarFuncion(nueva);
    }
    
    public void insertarSentencia(objetoBase nueva){
        this.sentenciasLibres.add(nueva);
    }
    
    public void insertarObservador(Observador nuevo){
        this.observadores.add(nuevo);
    }
    
    
   public elementoRetorno ejecutarLibres(tablaSimbolos tabla, int contexto){
         elementoRetorno v = new elementoRetorno();
         objetoBase temporal;
             for (int i = 0; i < sentenciasLibres.size(); i++) {
                temporal = sentenciasLibres.get(i);
               v= temporal.Ejecutar(tabla, contexto);              
            }
           return v;
   }
    
   
    
}
