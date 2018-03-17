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
public class Resta  extends expresionBase {
      
    
    public Resta(){
        
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
            Object c = getNumero(val2);
            if(c instanceof Integer){
                int g = Integer.parseInt(c.toString());
                return dou1-g;
            }else{
               dou2= Double.parseDouble(c.toString());
                return dou1-dou2;
            }
            
            
            
          
           
        }else  if (esNumero(tipo1) && esBool(tipo2)) {
            
            dou2 = getBoolNumero(val2); 
            
             Object c = getNumero(val1);
            if(c instanceof Integer){
                int g = Integer.parseInt(c.toString());
                return g-dou2;
            }else{
               dou1= Double.parseDouble(c.toString());
                return dou1-dou2;
            }
            

        }
        else  if (esNumero(tipo1) && esNumero(tipo2)) {
            
           Object o1= getNumero(val1);
            Object o2= getNumero(val2);
            if(o1 instanceof Integer && o2 instanceof Integer){
                int i1= Integer.parseInt(o1.toString());
                int i2 = Integer.parseInt(o2.toString());
                return i1-i2;
            }else{
                double d = Double.parseDouble(o1.toString());
                double d2 = Double.parseDouble(o2.toString());
                return d-d2;
            }
        }
        
        else {
            paginaActual.erroresPagina.insertarError("Semantico", "No es valido restar un "+ tipo1+" con un "+ tipo2);
           return "nulo"; 
        }
    }
    
}
