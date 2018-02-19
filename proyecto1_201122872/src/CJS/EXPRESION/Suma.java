/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CJS.EXPRESION;

/**
 *
 * @author Ramonella
 */
public class Suma  extends expresionBase{
    
    public Suma(){
        
    }
    
    @Override
    public Object Resolver(Object val1, Object val2){
      
        double v1= Double.parseDouble(val1.toString());
        double v2 =Double.parseDouble(val2.toString());
        
        String tipo1 = obtenerTipoExpresion(val1);
        String tipo2 = obtenerTipoExpresion(val2);

        String cad1, cad2;
        double dou1, dou2;
        
        /* Validaciones con Booleanos */
        if (esBool(tipo1) && esBool(tipo2)) {
            
            dou1 = getBool(val1);
            dou2 = getBool(val2);           
            
            if(dou1==1 || dou2==1)
                return 1;
            else
                return 0;
        }else  if (esBool(tipo1) && esNumero(tipo2)) {
            
            dou1 = getBool(val1);
            dou2 = getNumero(val2);           
            
            return dou1+dou2;
        }
        else  if (esBool(tipo1) && esCadena(tipo2)) {
            
            dou1 = getBool(val1);
            cad2 = getCadena(val2);           
            
            return dou1+cad2;
        }
        
        else  if (esNumero(tipo1) && esNumero(tipo2)) {
            
            dou1 = getNumero(val1);
            dou2 = getNumero(val2);           
            
            return dou1+dou2;
        }
        
        else  if (esNumero(tipo1) && esBool(tipo2)) {
            
            dou1 = getNumero(val1);
            dou2 = getBool(val2);           
            
            return dou1+dou2;
        }
        
        
        
        
        return v1+v2;
    }
    
}
