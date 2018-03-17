/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CJS.EXPRESION;

import static proyecto1_201122872.Proyecto1_201122872.paginaActual;
/**
 *
 * @author Ramonella
 */
public class Division  extends expresionBase {
   
    
    public Division(){
        
    }
    
     @Override
    public Object Resolver(Object val1, Object val2){
      
     
        
        String tipo1 = obtenerTipoExpresion(val1);
        String tipo2 = obtenerTipoExpresion(val2);
 
        String cad1, cad2;
        double dou1, dou2;
        
        /* Validaciones con Booleanos */
        if (esBool(tipo1) && esNumero(tipo2)) {
            
            dou1 = getBoolNumero(val1);
            dou2 = Double.parseDouble(getNumero(val2).toString()); 
            if(dou2==0){
                paginaActual.erroresPagina.insertarError("Semantico", "No es valido realizar una division entre 0");
                return "nulo";
            }
            
           return dou1/dou2;
           
        }else  if (esNumero(tipo1) && esBool(tipo2)) {
            
            dou1 = Double.parseDouble(getNumero(val1).toString()); 
            dou2 = getBoolNumero(val2); 
            if(dou2==0){
                paginaActual.erroresPagina.insertarError("Semantico", "No es valido realizar una division entre 0");
                return "nulo";
            }
            
            return dou1/dou2;
        }
        else  if (esNumero(tipo1) && esNumero(tipo2)) {
            
            dou1 = Double.parseDouble(getNumero(val1).toString()); 
            dou2 = Double.parseDouble(getNumero(val2).toString());  
            if(dou2==0){
                paginaActual.erroresPagina.insertarError("Semantico", "No es valido realizar una division entre 0");
                return "nulo";
            }
            
            return dou2/dou1;
        }
        
        else {
            paginaActual.erroresPagina.insertarError("Semantico", "No es valido dividir un "+ tipo1+" con un "+ tipo2);
           return "nulo"; 
        }
    }
    
}
