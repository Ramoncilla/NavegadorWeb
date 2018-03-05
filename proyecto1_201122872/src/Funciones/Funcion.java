/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Funciones;

import CJS.ARBOL.EXPRESION.DateTime;
import CJS.ARBOL.EXPRESION.Datee;
import CJS.ARBOL.INSTRUCCIONES.Asignacion;
import CJS.ARBOL.INSTRUCCIONES.DeclaAsig;
import CJS.ARBOL.INSTRUCCIONES.Declaracion;
import CJS.ESTRUCURAS_CONTROL.CuerpoEstructuras;
import CJS.TablaSimbolos.Simbolo;
import CJS.TablaSimbolos.tablaSimbolos;
import CJS.elementoRetorno;
import CJS.objetoBase;
import java.util.ArrayList;
import java.util.List;
import static proyecto1_201122872.Proyecto1_201122872.paginaActual;

/**
 *
 * @author Ramonella
 */
public class Funcion extends objetoBase {
    
    public String nombreFuncion;
    public List<String> parametros;
    public CuerpoEstructuras cuerpoFuncion;
    public int noParametros;
    
    
    public Funcion(Object nombre, Object parametros, Object cuerpo){
        
        this.nombreFuncion= nombre.toString();
        this.parametros= (ArrayList<String>)parametros;
        this.cuerpoFuncion= (CuerpoEstructuras)cuerpo;
        this.noParametros= this.parametros.size();
        
    }

    @Override
    public elementoRetorno Ejecutar(tablaSimbolos tabla, int contexto) {
        //1. asignamos parametros en la tabla de simbolos
        
       elementoRetorno ret = cuerpoFuncion.Ejecutar(tabla, contexto);
       ret.banderaRetorno=false;
       ret.detener=false;
        
        
        return ret; //To change body of generated methods, choose Tools | Templates.
    }
    
    
    public boolean asignarParametros(List<objetoBase> valoresParametros, int contexto, tablaSimbolos tabla){
        
        List<Object> val = ejecutarParametros(valoresParametros,  contexto,  tabla);
        
        if(validarParametros(val)){
            
            if(valoresParametros.size()== this.parametros.size()){
                
                for (int i = 0; i < this.parametros.size(); i++) {
                    Declaracion decla = new Declaracion(parametros.get(i));
                    Asignacion asigna= new Asignacion(parametros.get(i),valoresParametros.get(i));
                    List<objetoBase>listado = new ArrayList<>();
                    listado.add(decla);
                    listado.add(asigna);
                    DeclaAsig h = new DeclaAsig(listado);
                    h.Ejecutar(tabla, contexto);
   
                }
                return true;
            }else{
                paginaActual.erroresPagina.insertarError("Semantico", "Numero de parmetros no coincide con la funcion "+ this.nombreFuncion);
            return false;
            }
            
        }else{
            paginaActual.erroresPagina.insertarError("Semantico", "Parametros no validos para asignar, viene un nulo");
            return false;
        }
    }
    
    
    private boolean validarParametros(List<Object> valores){
        boolean res=true;
        
        for (int i = 0; i < valores.size(); i++) {
            res= res && (!(obtenerTipoExpresion(valores.get(i)).equalsIgnoreCase("nulo")));
        }
        return res;
    }
    
     private List<Object> ejecutarParametros(List<objetoBase> expresionesParametros, int contexto, tablaSimbolos tabla){
      List<Object> lista = new ArrayList<>();
       elementoRetorno ret;
        for (int i = 0; i < expresionesParametros.size(); i++) {
            ret= expresionesParametros.get(i).Ejecutar(tabla, contexto);
            lista.add(ret.ValorRetorno);
        }
      return lista;
    }
    
    
     private String obtenerTipoExpresion(Object val) {
        
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
