/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CJS.ESTRUCURAS_CONTROL;

import CJS.TablaSimbolos.SimbEtiqueta;
import CJS.TablaSimbolos.tablaSimbolos;
import CJS.elementoRetorno;
import Funciones.Funcion;
import java.util.ArrayList;
import java.util.List;
import proyecto1_201122872.CHTML.Etiqueta;

/**
 *
 * @author Ramonella
 */
public class ListaObservadores {
    
    public List<Observador> observadoresDocumento;
   
    
    public ListaObservadores(){
        this.observadoresDocumento= new ArrayList<>();
    }
    
    public void insertar(Observador nuevo){
        this.observadoresDocumento.add(nuevo);
    }
    
    
    //busca los observadores unicamnte de obtner y id
    public void buscarObservadorPorElemento(int tipoEvento, int idElemento, int contexto, tablaSimbolos tabla ){
        Observador temporal;
        elementoRetorno etTemporal;
        Etiqueta retornoTemporal;
        for (int i = 0; i < this.observadoresDocumento.size(); i++) {
            temporal= this.observadoresDocumento.get(i);
            if(temporal.tipoObservador==2){ 
                if(temporal.tipoEvento==tipoEvento){
                    etTemporal= temporal.objetoObservar.Ejecutar(tabla, contexto);
                    if(etTemporal.ValorRetorno instanceof SimbEtiqueta){
                        retornoTemporal = ((SimbEtiqueta)etTemporal.ValorRetorno).etiquetaHTML;
                        if(retornoTemporal.numeroIdentificador==idElemento){
                            if(temporal.funcionEjecutar instanceof Llamada){
                                Llamada nueva = (Llamada)temporal.funcionEjecutar;
                                elementoRetorno r= nueva.Ejecutar(tabla, contexto);
                            }else if(temporal.funcionEjecutar instanceof Funcion){
                                //aqui viene si se va a crear una funio nueva
                                contexto++;
                                elementoRetorno ret = ((Funcion)temporal.funcionEjecutar).Ejecutar(tabla, contexto);
                                tabla.eliminarSimbolosLocales(contexto);
                                contexto--;  
                            }
                        }
                    }
                    
                }
                
            }
        }
    
    
    }
    
    
}
