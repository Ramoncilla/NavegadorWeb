/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CJS.ESTRUCURAS_CONTROL;

import CJS.TablaSimbolos.tablaSimbolos;
import CJS.elementoRetorno;
import CJS.objetoBase;

/**
 *
 * @author Ramonella
 */
public class Observador extends objetoBase{
  
    
    
    public objetoBase objetoObservar;
    public String nombreEvento;
    public objetoBase funcionEjecutar;
    public int tipoObservador;
    public int tipoEvento;
    
    //1 tipo documento 2 cualquiero elemento 
    public Observador(Object oObservar, Object tipoEvento, Object funcion, Object tipo){
        this.objetoObservar= (objetoBase)oObservar;
        this.nombreEvento= tipoEvento.toString();
        this.funcionEjecutar= (objetoBase)funcion;
        this.tipoObservador = Integer.parseInt(tipo.toString()); 
        this.tipoEvento= asignarEvento(nombreEvento);
    }
    
    
    private int asignarEvento(String cad){
        
        switch (cad.toUpperCase()){
            case "LISTO":{
             return 10;  
            }
            case "MODIFICADO":{
             return 20; 
            }
            case "CLIQUEADO":{
             return 30;   
            }
        }
        return 0;
        
    }
    
    
    /*OBSERVADOR::= ELEMENTO punto observador abrePar TIPOS_EVENTOS coma FUNCION cierraPar puntoComa
		| documento punto observador abrePar TIPOS_EVENTOS coma FUNCION cierraPar puntoComa
		|ELEMENTO punto observador abrePar TIPOS_EVENTOS coma LLAMADA cierraPar puntoComa
		| documento punto observador abrePar TIPOS_EVENTOS coma LLAMADA cierraPar puntoComa;*/

    @Override
    public elementoRetorno Ejecutar(tablaSimbolos tabla, int contexto) {
        
        if(tipoObservador ==1){
            
            
        }else{
            
            
            
        }
        return super.Ejecutar(tabla, contexto); //To change body of generated methods, choose Tools | Templates.
    }
    
    
    
}
