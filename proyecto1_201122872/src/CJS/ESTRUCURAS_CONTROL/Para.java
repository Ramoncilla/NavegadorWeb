/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CJS.ESTRUCURAS_CONTROL;

import CJS.ARBOL.EXPRESION.DateTime;
import CJS.ARBOL.EXPRESION.Datee;
import CJS.ARBOL.INSTRUCCIONES.AsignaUnario;
import CJS.ARBOL.INSTRUCCIONES.DeclaAsig;
import CJS.TablaSimbolos.tablaSimbolos;
import CJS.elementoRetorno;
import CJS.objetoBase;
import static proyecto1_201122872.Proyecto1_201122872.paginaActual;

/**
 *
 * @author Ramonella
 */
public class Para extends objetoBase{
    
    //PARA::= para abrePar id dosPuntos EXPRESION puntoComa EXPRESION puntoComa OPERADOR_PARA cierraPar CUERPO;
    
    public DeclaAsig variableControl;
    public objetoBase expresionControl;
    public String operador;
    public CuerpoEstructuras cuerpoPara;
    public AsignaUnario unarioVariableControl;



   public Para(Object decla, Object expresion, Object operador, Object cuerpo, Object unario){
       this.variableControl = (DeclaAsig)decla;
       this.expresionControl = (objetoBase)expresion;
       this.operador= operador.toString();
       this.cuerpoPara=(CuerpoEstructuras)cuerpo;
       this.unarioVariableControl=(AsignaUnario)unario;
       
   }    
   
   
    @Override
    public elementoRetorno Ejecutar(tablaSimbolos tabla, int contexto) {
         System.out.println("inicio pargggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggga");
        tabla.imprimirTablaSimbolos();
        System.out.println("fin inicio para");
        contexto++;
        variableControl.Ejecutar(tabla, contexto);
        
        elementoRetorno resCondicion= expresionControl.Ejecutar(tabla, contexto);
        elementoRetorno resultado= new elementoRetorno();
        String tipoExpresion = obtenerTipoExpresion(resCondicion.ValorRetorno);

        if(esBool(tipoExpresion)){
            
            while(resCondicion.ValorRetorno.toString().equalsIgnoreCase("verdadero")){
            //if(resCondicion.ValorRetorno.toString().equalsIgnoreCase("verdadero")){
                if(!resultado.detener){
                   resultado = cuerpoPara.Ejecutar(tabla, contexto);
                   unarioVariableControl.Ejecutar(tabla, contexto);
                   resCondicion= expresionControl.Ejecutar(tabla, contexto); 
                }else{
                    break;
                }
                 
            }
            resultado.detener=false;
        }else{
           paginaActual.erroresPagina.insertarError("Semantico", "Tipo de expresion no valido para una expresion de una sentencia Para");
        }
        contexto--;
        System.out.println("fin para");
        tabla.imprimirTablaSimbolos();
        System.out.println("fin fin para ");
        return resultado;
    }
    
    
     private boolean esBool(String tipo) {
        return tipo.equalsIgnoreCase("bool");
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
