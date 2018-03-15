/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CJS.EXPRESION;
import CJS.ARBOL.EXPRESION.*;
import static proyecto1_201122872.Proyecto1_201122872.paginaActual;

/**
 *
 * @author Ramonella
 */
public class expresionesRelacionales extends expresionBase {
    
    public expresionesRelacionales(){
        
    }
    
    public Object Resolver_Expresion(Object val1, Object val2, String simb){
        switch (simb) {
            case "<": {
                return OperarMenor(val1, val2);
            }
            case ">": {
                return OperarMayor(val1, val2);
            }
            case "<=": {
                return OperarMenorIgual(val1, val2);
            }
            case ">=": {
                return OperarMayorIgual(val1, val2);
            }
            case "!=": {
                return OperarDistintoA(val1, val2);
            }
            case "==": {
                return OperarIgualIgual(val1, val2);
            }

        }
        return "nulo";
    }

    
    
    /*1. cadena con cadena
2. cadena con date/datetime
3. cadena (tamaño de la cadena) con numerico
4. numerico con numerico
5. date/datetime con date/datetime
6. booleano con booleano (toma el valor numerico 0 o 1)
7. booleano con numerico*/
    
    
    private String OperarMenor(Object val1, Object val2) {
         String tipo1= obtenerTipoExpresion(val1);
         String tipo2= obtenerTipoExpresion(val2);
         
          if ((tipo1.equalsIgnoreCase("numero")) && (tipo2.equalsIgnoreCase("numero"))) {
             double e1 = getNumero(val1);
             double e2 = getNumero(val2);
             if (e1 < e2) {
                 return "verdadero";
             } else {
                 return "falso";
             }
         }
          else if ((tipo1.equalsIgnoreCase("bool")) && (tipo2.equalsIgnoreCase("numero"))) {
             double e1 = getBoolNumero(val1);
             double e2 = getNumero(val2);
             if (e1 < e2) {
                 return "verdadero";
             } else {
                 return "falso";
             }
         }
          else if ((tipo1.equalsIgnoreCase("numero")) && (tipo2.equalsIgnoreCase("bool"))) {
             double e1 = getNumero(val1);
             double e2 = getBoolNumero(val2);
             if (e1 < e2) {
                 return "verdadero";
             } else {
                 return "falso";
             }
         }
          if ((tipo1.equalsIgnoreCase("bool")) && (tipo2.equalsIgnoreCase("bool"))) {
             double e1 = getBoolNumero(val1);
             double e2 = getBoolNumero(val2);
             if (e1 < e2) {
                 return "verdadero";
             } else {
                 return "falso";
             }
         }
          else if ((tipo1.equalsIgnoreCase("date")) && (tipo2.equalsIgnoreCase("datetime"))) {
              
             Datee fecha1=(Datee)val1;
             DateTime fecha2=(DateTime)val2;
             if(esMenorFecha(fecha1,fecha2.fecha)){
                 return "verdadero";
             }else{
                 return "falso";
             }
              
         }
          else if ((tipo1.equalsIgnoreCase("datetime")) && (tipo2.equalsIgnoreCase("date"))) {
            DateTime fecha1=(DateTime)val1;
             Datee fecha2=(Datee)val2;
             if(esMenorFecha(fecha1.fecha,fecha2)){
                 return "verdadero";
             }else{
                 return "falso";
             }
         }
          else if ((tipo1.equalsIgnoreCase("cadena")) && (tipo2.equalsIgnoreCase("numero"))) {
             double e1 = val1.toString().length();
             double e2 = getNumero(val2);
             if (e1 < e2) {
                 return "verdadero";
             } else {
                 return "falso";
             }
         }
          else if ((tipo1.equalsIgnoreCase("numero")) && (tipo2.equalsIgnoreCase("cadena"))) {
             double e1 = getNumero(val1);
             double e2 = val2.toString().length();
             if (e1 < e2) {
                 return "verdadero";
             } else {
                 return "falso";
             }
         }
          //////////////////////////
          else if ((tipo1.equalsIgnoreCase("cadena")) && (tipo2.equalsIgnoreCase("date"))) {
              Datee v1= (Datee)val2;
              int no= compararCadenas(val1.toString(),v1.getDate());
             if (no==-1) {
                 return "verdadero";
             } else {
                 return "falso";
             }
         }
          else if ((tipo1.equalsIgnoreCase("date")) && (tipo2.equalsIgnoreCase("cadena"))) {
             Datee v1= (Datee)val1;
              int no= compararCadenas(v1.getDate(),val2.toString());
             if (no==-1) {
                 return "verdadero";
             } else {
                 return "falso";
             }
         }
          else if ((tipo1.equalsIgnoreCase("datetime")) && (tipo2.equalsIgnoreCase("cadena"))) {
            DateTime v1= (DateTime)val1;
              int no= compararCadenas(v1.getDateTime(),val2.toString());
             if (no==-1) {
                 return "verdadero";
             } else {
                 return "falso";
             }
         }
          else if ((tipo1.equalsIgnoreCase("cadena")) && (tipo2.equalsIgnoreCase("datetime"))) {
           DateTime v1= (DateTime)val2;
              int no= compararCadenas(val2.toString(),v1.getDateTime());
             if (no==-1) {
                 return "verdadero";
             } else {
                 return "falso";
             }
         }
          
          
          //aquiii
          else  if ((tipo1.equalsIgnoreCase("cadena")) && (tipo2.equalsIgnoreCase("cadena"))) {
             int no= compararCadenas(val1.toString(),val2.toString());
             if (no==-1) {
                 return "verdadero";
             } else {
                 return "falso";
             }
         } else  if ((tipo1.equalsIgnoreCase("date")) && (tipo2.equalsIgnoreCase("date"))) {
             Datee fecha1=(Datee)val1;
             Datee fecha2=(Datee)val2;
             if(esMenorFecha(fecha1,fecha2)){
                 return "verdadero";
             }else{
                 return "falso";
             }
             
         }else  if ((tipo1.equalsIgnoreCase("datetime")) && (tipo2.equalsIgnoreCase("datetime"))) {
            DateTime fecha1=(DateTime)val1;
             DateTime fecha2=(DateTime)val2;
             if(esMenorFechaTime(fecha1,fecha2)){
                 return "verdadero";
             }else{
                 return "falso";
             }
         }else{
             paginaActual.erroresPagina.insertarError("Semantico", "No es valido hacer una operacion relacional (menor) con  "+ tipo1+" y un "+ tipo2);
             return "nulo";
         }
         
    }
    
    
    
    
    
    
    
     private String OperarMayor(Object val1, Object val2) {
         String tipo1= obtenerTipoExpresion(val1);
         String tipo2= obtenerTipoExpresion(val2);
         
          if ((tipo1.equalsIgnoreCase("numero")) && (tipo2.equalsIgnoreCase("numero"))) {
             double e1 = getNumero(val1);
             double e2 = getNumero(val2);
             if (e1 > e2) {
                 return "verdadero";
             } else {
                 return "falso";
             }
         }
          else if ((tipo1.equalsIgnoreCase("bool")) && (tipo2.equalsIgnoreCase("numero"))) {
             double e1 = getBoolNumero(val1);
             double e2 = getNumero(val2);
             if (e1 > e2) {
                 return "verdadero";
             } else {
                 return "falso";
             }
         }
          else if ((tipo1.equalsIgnoreCase("numero")) && (tipo2.equalsIgnoreCase("bool"))) {
             double e1 = getNumero(val1);
             double e2 = getBoolNumero(val2);
             if (e1 > e2) {
                 return "verdadero";
             } else {
                 return "falso";
             }
         }
          if ((tipo1.equalsIgnoreCase("bool")) && (tipo2.equalsIgnoreCase("bool"))) {
             double e1 = getBoolNumero(val1);
             double e2 = getBoolNumero(val2);
             if (e1 > e2) {
                 return "verdadero";
             } else {
                 return "falso";
             }
         }
          else if ((tipo1.equalsIgnoreCase("date")) && (tipo2.equalsIgnoreCase("datetime"))) {
              
             Datee fecha1=(Datee)val1;
             DateTime fecha2=(DateTime)val2;
             if(esMayorFecha(fecha1,fecha2.fecha)){
                 return "verdadero";
             }else{
                 return "falso";
             }
              
         }
          else if ((tipo1.equalsIgnoreCase("datetime")) && (tipo2.equalsIgnoreCase("date"))) {
            DateTime fecha1=(DateTime)val1;
             Datee fecha2=(Datee)val2;
             if(esMayorFecha(fecha1.fecha,fecha2)){
                 return "verdadero";
             }else{
                 return "falso";
             }
         }
          else if ((tipo1.equalsIgnoreCase("cadena")) && (tipo2.equalsIgnoreCase("numero"))) {
             double e1 = val1.toString().length();
             double e2 = getNumero(val2);
             if (e1 > e2) {
                 return "verdadero";
             } else {
                 return "falso";
             }
         }
          else if ((tipo1.equalsIgnoreCase("numero")) && (tipo2.equalsIgnoreCase("cadena"))) {
             double e1 = getNumero(val1);
             double e2 = val2.toString().length();
             if (e1 > e2) {
                 return "verdadero";
             } else {
                 return "falso";
             }
         }
          //////////////////////////
          else if ((tipo1.equalsIgnoreCase("cadena")) && (tipo2.equalsIgnoreCase("date"))) {
              Datee v1= (Datee)val2;
              int no= compararCadenas(val1.toString(),v1.getDate());
             if (no==1) {
                 return "verdadero";
             } else {
                 return "falso";
             }
         }
          else if ((tipo1.equalsIgnoreCase("date")) && (tipo2.equalsIgnoreCase("cadena"))) {
             Datee v1= (Datee)val1;
              int no= compararCadenas(v1.getDate(),val2.toString());
             if (no==1) {
                 return "verdadero";
             } else {
                 return "falso";
             }
         }
          else if ((tipo1.equalsIgnoreCase("datetime")) && (tipo2.equalsIgnoreCase("cadena"))) {
            DateTime v1= (DateTime)val1;
              int no= compararCadenas(v1.getDateTime(),val2.toString());
             if (no==1) {
                 return "verdadero";
             } else {
                 return "falso";
             }
         }
          else if ((tipo1.equalsIgnoreCase("cadena")) && (tipo2.equalsIgnoreCase("datetime"))) {
           DateTime v1= (DateTime)val2;
              int no= compararCadenas(val2.toString(),v1.getDateTime());
             if (no==1) {
                 return "verdadero";
             } else {
                 return "falso";
             }
         }
          
          
          //aquiii
          else  if ((tipo1.equalsIgnoreCase("cadena")) && (tipo2.equalsIgnoreCase("cadena"))) {
             int no= compararCadenas(val1.toString(),val2.toString());
             if (no==1) {
                 return "verdadero";
             } else {
                 return "falso";
             }
         }
          else  if ((tipo1.equalsIgnoreCase("date")) && (tipo2.equalsIgnoreCase("date"))) {
             Datee fecha1=(Datee)val1;
             Datee fecha2=(Datee)val2;
             if(esMayorFecha(fecha1,fecha2)){
                 return "verdadero";
             }else{
                 return "falso";
             }
             
         }else  if ((tipo1.equalsIgnoreCase("datetime")) && (tipo2.equalsIgnoreCase("datetime"))) {
            DateTime fecha1=(DateTime)val1;
             DateTime fecha2=(DateTime)val2;
             if(esMayorFechaTime(fecha1,fecha2)){
                 return "verdadero";
             }else{
                 return "falso";
             }
         }else{
             paginaActual.erroresPagina.insertarError("Semantico", "No es valido hacer una operacion relacional (menor) con  "+ tipo1+" y un "+ tipo2);
             return "nulo";
         }
    }
     
     
     
     
     private String OperarMenorIgual(Object val1, Object val2) {
        String tipo1= obtenerTipoExpresion(val1);
         String tipo2= obtenerTipoExpresion(val2);
         
          if ((tipo1.equalsIgnoreCase("numero")) && (tipo2.equalsIgnoreCase("numero"))) {
             double e1 = getNumero(val1);
             double e2 = getNumero(val2);
             if (e1 <= e2) {
                 return "verdadero";
             } else {
                 return "falso";
             }
         }
          else if ((tipo1.equalsIgnoreCase("bool")) && (tipo2.equalsIgnoreCase("numero"))) {
             double e1 = getBoolNumero(val1);
             double e2 = getNumero(val2);
             if (e1 <= e2) {
                 return "verdadero";
             } else {
                 return "falso";
             }
         }
          else if ((tipo1.equalsIgnoreCase("numero")) && (tipo2.equalsIgnoreCase("bool"))) {
             double e1 = getNumero(val1);
             double e2 = getBoolNumero(val2);
             if (e1 <= e2) {
                 return "verdadero";
             } else {
                 return "falso";
             }
         }
          if ((tipo1.equalsIgnoreCase("bool")) && (tipo2.equalsIgnoreCase("bool"))) {
             double e1 = getBoolNumero(val1);
             double e2 = getBoolNumero(val2);
             if (e1 <= e2) {
                 return "verdadero";
             } else {
                 return "falso";
             }
         }
          else if ((tipo1.equalsIgnoreCase("date")) && (tipo2.equalsIgnoreCase("datetime"))) {
              
             Datee fecha1=(Datee)val1;
             DateTime fecha2=(DateTime)val2;
             if(esMenorFecha(fecha1,fecha2.fecha) || esIgualFecha(fecha1, fecha2.fecha)){
                 return "verdadero";
             }else{
                 return "falso";
             }
              
         }
          else if ((tipo1.equalsIgnoreCase("datetime")) && (tipo2.equalsIgnoreCase("date"))) {
            DateTime fecha1=(DateTime)val1;
             Datee fecha2=(Datee)val2;
             if(esMenorFecha(fecha1.fecha,fecha2) || esIgualFecha(fecha1.fecha, fecha2)){
                 return "verdadero";
             }else{
                 return "falso";
             }
         }
          else if ((tipo1.equalsIgnoreCase("cadena")) && (tipo2.equalsIgnoreCase("numero"))) {
             double e1 = val1.toString().length();
             double e2 = getNumero(val2);
             if (e1 <= e2) {
                 return "verdadero";
             } else {
                 return "falso";
             }
         }
          else if ((tipo1.equalsIgnoreCase("numero")) && (tipo2.equalsIgnoreCase("cadena"))) {
             double e1 = getNumero(val1);
             double e2 = val2.toString().length();
             if (e1 <= e2) {
                 return "verdadero";
             } else {
                 return "falso";
             }
         }
          //////////////////////////
          else if ((tipo1.equalsIgnoreCase("cadena")) && (tipo2.equalsIgnoreCase("date"))) {
              Datee v1= (Datee)val2;
              int no= compararCadenas(val1.toString(),v1.getDate());
             if (no==-1 || no==0) {
                 return "verdadero";
             } else {
                 return "falso";
             }
         }
          else if ((tipo1.equalsIgnoreCase("date")) && (tipo2.equalsIgnoreCase("cadena"))) {
             Datee v1= (Datee)val1;
              int no= compararCadenas(v1.getDate(),val2.toString());
             if (no==-1 || no==0) {
                 return "verdadero";
             } else {
                 return "falso";
             }
         }
          else if ((tipo1.equalsIgnoreCase("datetime")) && (tipo2.equalsIgnoreCase("cadena"))) {
            DateTime v1= (DateTime)val1;
              int no= compararCadenas(v1.getDateTime(),val2.toString());
          if (no==-1 || no==0) {
                 return "verdadero";
             } else {
                 return "falso";
             }
         }
          else if ((tipo1.equalsIgnoreCase("cadena")) && (tipo2.equalsIgnoreCase("datetime"))) {
           DateTime v1= (DateTime)val2;
              int no= compararCadenas(val2.toString(),v1.getDateTime());
             if (no==-1 || no==0) {
                 return "verdadero";
             } else {
                 return "falso";
             }
         }
          
          
          //aquiii
          else  if ((tipo1.equalsIgnoreCase("cadena")) && (tipo2.equalsIgnoreCase("cadena"))) {
             int no= compararCadenas(val1.toString(),val2.toString());
             if (no==-1 || no==0) {
                 return "verdadero";
             } else {
                 return "falso";
             }
         } else  if ((tipo1.equalsIgnoreCase("date")) && (tipo2.equalsIgnoreCase("date"))) {
             Datee fecha1=(Datee)val1;
             Datee fecha2=(Datee)val2;
             if(esMenorFecha(fecha1,fecha2) || esIgualFecha(fecha1,fecha2)){
                 return "verdadero";
             }else{
                 return "falso";
             }
             
         }else  if ((tipo1.equalsIgnoreCase("datetime")) && (tipo2.equalsIgnoreCase("datetime"))) {
            DateTime fecha1=(DateTime)val1;
             DateTime fecha2=(DateTime)val2;
             if(esMenorFechaTime(fecha1,fecha2) || esIgualFechaTime(fecha1,fecha2)){
                 return "verdadero";
             }else{
                 return "falso";
             }
         }else{
             paginaActual.erroresPagina.insertarError("Semantico", "No es valido hacer una operacion relacional (menor) con  "+ tipo1+" y un "+ tipo2);
             return "nulo";
         }
    }
      
     
     
       private String  OperarMayorIgual(Object val1, Object val2) {
   String tipo1= obtenerTipoExpresion(val1);
         String tipo2= obtenerTipoExpresion(val2);
         
          if ((tipo1.equalsIgnoreCase("numero")) && (tipo2.equalsIgnoreCase("numero"))) {
             double e1 = getNumero(val1);
             double e2 = getNumero(val2);
             if (e1 >= e2) {
                 return "verdadero";
             } else {
                 return "falso";
             }
         }
          else if ((tipo1.equalsIgnoreCase("bool")) && (tipo2.equalsIgnoreCase("numero"))) {
             double e1 = getBoolNumero(val1);
             double e2 = getNumero(val2);
             if (e1 >= e2) {
                 return "verdadero";
             } else {
                 return "falso";
             }
         }
          else if ((tipo1.equalsIgnoreCase("numero")) && (tipo2.equalsIgnoreCase("bool"))) {
             double e1 = getNumero(val1);
             double e2 = getBoolNumero(val2);
             if (e1 >= e2) {
                 return "verdadero";
             } else {
                 return "falso";
             }
         }
          if ((tipo1.equalsIgnoreCase("bool")) && (tipo2.equalsIgnoreCase("bool"))) {
             double e1 = getBoolNumero(val1);
             double e2 = getBoolNumero(val2);
             if (e1 >= e2) {
                 return "verdadero";
             } else {
                 return "falso";
             }
         }
          else if ((tipo1.equalsIgnoreCase("date")) && (tipo2.equalsIgnoreCase("datetime"))) {
              
             Datee fecha1=(Datee)val1;
             DateTime fecha2=(DateTime)val2;
             if(esMayorFecha(fecha1,fecha2.fecha) || esIgualFecha(fecha1, fecha2.fecha)){
                 return "verdadero";
             }else{
                 return "falso";
             }
              
         }
          else if ((tipo1.equalsIgnoreCase("datetime")) && (tipo2.equalsIgnoreCase("date"))) {
            DateTime fecha1=(DateTime)val1;
             Datee fecha2=(Datee)val2;
             if(esMayorFecha(fecha1.fecha,fecha2) || esIgualFecha(fecha1.fecha, fecha2)){
                 return "verdadero";
             }else{
                 return "falso";
             }
         }
          else if ((tipo1.equalsIgnoreCase("cadena")) && (tipo2.equalsIgnoreCase("numero"))) {
             double e1 = val1.toString().length();
             double e2 = getNumero(val2);
             if (e1 >= e2) {
                 return "verdadero";
             } else {
                 return "falso";
             }
         }
          else if ((tipo1.equalsIgnoreCase("numero")) && (tipo2.equalsIgnoreCase("cadena"))) {
             double e1 = getNumero(val1);
             double e2 = val2.toString().length();
             if (e1 >= e2) {
                 return "verdadero";
             } else {
                 return "falso";
             }
         }
         //////////////////////////
          else if ((tipo1.equalsIgnoreCase("cadena")) && (tipo2.equalsIgnoreCase("date"))) {
              Datee v1= (Datee)val2;
              int no= compararCadenas(val1.toString(),v1.getDate());
             if (no==1 || no==0) {
                 return "verdadero";
             } else {
                 return "falso";
             }
         }
          else if ((tipo1.equalsIgnoreCase("date")) && (tipo2.equalsIgnoreCase("cadena"))) {
             Datee v1= (Datee)val1;
              int no= compararCadenas(v1.getDate(),val2.toString());
           if (no==1 || no==0) {
                 return "verdadero";
             } else {
                 return "falso";
             }
         }
          else if ((tipo1.equalsIgnoreCase("datetime")) && (tipo2.equalsIgnoreCase("cadena"))) {
            DateTime v1= (DateTime)val1;
              int no= compararCadenas(v1.getDateTime(),val2.toString());
            if (no==1 || no==0) {
                 return "verdadero";
             } else {
                 return "falso";
             }
         }
          else if ((tipo1.equalsIgnoreCase("cadena")) && (tipo2.equalsIgnoreCase("datetime"))) {
           DateTime v1= (DateTime)val2;
              int no= compararCadenas(val2.toString(),v1.getDateTime());
             if (no==1 || no==0) {
                 return "verdadero";
             } else {
                 return "falso";
             }
         }
          
          
          //aquiii
          else  if ((tipo1.equalsIgnoreCase("cadena")) && (tipo2.equalsIgnoreCase("cadena"))) {
             int no= compararCadenas(val1.toString(),val2.toString());
             if (no==1 || no==0) {
                 return "verdadero";
             } else {
                 return "falso";
             }
         } else  if ((tipo1.equalsIgnoreCase("date")) && (tipo2.equalsIgnoreCase("date"))) {
             Datee fecha1=(Datee)val1;
             Datee fecha2=(Datee)val2;
             if(esMayorFecha(fecha1,fecha2) || esIgualFecha(fecha1,fecha2)){
                 return "verdadero";
             }else{
                 return "falso";
             }
             
         }else  if ((tipo1.equalsIgnoreCase("datetime")) && (tipo2.equalsIgnoreCase("datetime"))) {
            DateTime fecha1=(DateTime)val1;
             DateTime fecha2=(DateTime)val2;
             if(esMayorFechaTime(fecha1,fecha2) || esIgualFechaTime(fecha1,fecha2)){
                 return "verdadero";
             }else{
                 return "falso";
             }
         }else{
             paginaActual.erroresPagina.insertarError("Semantico", "No es valido hacer una operacion relacional (menor) con  "+ tipo1+" y un "+ tipo2);
             return "nulo";
         }
    }
       
        private String OperarIgualIgual(Object val1, Object val2) {
           String tipo1= obtenerTipoExpresion(val1);
         String tipo2= obtenerTipoExpresion(val2);
         
          if ((tipo1.equalsIgnoreCase("numero")) && (tipo2.equalsIgnoreCase("numero"))) {
             double e1 = getNumero(val1);
             double e2 = getNumero(val2);
             if (e1 == e2) {
                 return "verdadero";
             } else {
                 return "falso";
             }
         }
          else if ((tipo1.equalsIgnoreCase("bool")) && (tipo2.equalsIgnoreCase("numero"))) {
             double e1 = getBoolNumero(val1);
             double e2 = getNumero(val2);
             if (e1 == e2) {
                 return "verdadero";
             } else {
                 return "falso";
             }
         }
          else if ((tipo1.equalsIgnoreCase("numero")) && (tipo2.equalsIgnoreCase("bool"))) {
             double e1 = getNumero(val1);
             double e2 = getBoolNumero(val2);
             if (e1 == e2) {
                 return "verdadero";
             } else {
                 return "falso";
             }
         }
          if ((tipo1.equalsIgnoreCase("bool")) && (tipo2.equalsIgnoreCase("bool"))) {
             double e1 = getBoolNumero(val1);
             double e2 = getBoolNumero(val2);
             if (e1 == e2) {
                 return "verdadero";
             } else {
                 return "falso";
             }
         }
          else if ((tipo1.equalsIgnoreCase("date")) && (tipo2.equalsIgnoreCase("datetime"))) {
              
             Datee fecha1=(Datee)val1;
             DateTime fecha2=(DateTime)val2;
             return "falso";
              
         }
          else if ((tipo1.equalsIgnoreCase("datetime")) && (tipo2.equalsIgnoreCase("date"))) {
            DateTime fecha1=(DateTime)val1;
             Datee fecha2=(Datee)val2;
            
                 return "falso";
             
         }
          else if ((tipo1.equalsIgnoreCase("cadena")) && (tipo2.equalsIgnoreCase("numero"))) {
             double e1 = val1.toString().length();
             double e2 = getNumero(val2);
             if (e1 == e2) {
                 return "verdadero";
             } else {
                 return "falso";
             }
         }
          else if ((tipo1.equalsIgnoreCase("numero")) && (tipo2.equalsIgnoreCase("cadena"))) {
             double e1 = getNumero(val1);
             double e2 = val2.toString().length();
             if (e1 == e2) {
                 return "verdadero";
             } else {
                 return "falso";
             }
         }
         //////////////////////////
          else if ((tipo1.equalsIgnoreCase("cadena")) && (tipo2.equalsIgnoreCase("date"))) {
              Datee v1= (Datee)val2;
              int no= compararCadenas(val1.toString(),v1.getDate());
             if (no==0) {
                 return "verdadero";
             } else {
                 return "falso";
             }
         }
          else if ((tipo1.equalsIgnoreCase("date")) && (tipo2.equalsIgnoreCase("cadena"))) {
             Datee v1= (Datee)val1;
              int no= compararCadenas(v1.getDate(),val2.toString());
             if (no==0) {
                 return "verdadero";
             } else {
                 return "falso";
             }
         }
          else if ((tipo1.equalsIgnoreCase("datetime")) && (tipo2.equalsIgnoreCase("cadena"))) {
            DateTime v1= (DateTime)val1;
              int no= compararCadenas(v1.getDateTime(),val2.toString());
              if (no==0) {
                 return "verdadero";
             } else {
                 return "falso";
             }
         }
          else if ((tipo1.equalsIgnoreCase("cadena")) && (tipo2.equalsIgnoreCase("datetime"))) {
           DateTime v1= (DateTime)val2;
              int no= compararCadenas(val2.toString(),v1.getDateTime());
              if (no==0) {
                 return "verdadero";
             } else {
                 return "falso";
             }
         }
          
          
          //aquiii
          else  if ((tipo1.equalsIgnoreCase("cadena")) && (tipo2.equalsIgnoreCase("cadena"))) {
             int no= compararCadenas(val1.toString(),val2.toString());
              if (no==0) {
                 return "verdadero";
             } else {
                 return "falso";
             }
         } else  if ((tipo1.equalsIgnoreCase("date")) && (tipo2.equalsIgnoreCase("date"))) {
             Datee fecha1=(Datee)val1;
             Datee fecha2=(Datee)val2;
             if(esIgualFecha(fecha1,fecha2)){
                 return "verdadero";
             }else{
                 return "falso";
             }
             
         }else  if ((tipo1.equalsIgnoreCase("datetime")) && (tipo2.equalsIgnoreCase("datetime"))) {
            DateTime fecha1=(DateTime)val1;
             DateTime fecha2=(DateTime)val2;
             if(esIgualFechaTime(fecha1,fecha2)){
                 return "verdadero";
             }else{
                 return "falso";
             }
         }else{
             paginaActual.erroresPagina.insertarError("Semantico", "No es valido hacer una operacion relacional (menor) con  "+ tipo1+" y un "+ tipo2);
             return "nulo";
         }
    }
    
        
        
        
         private String OperarDistintoA(Object val1, Object val2) {
            String tipo1= obtenerTipoExpresion(val1);
         String tipo2= obtenerTipoExpresion(val2);
         
          if ((tipo1.equalsIgnoreCase("numero")) && (tipo2.equalsIgnoreCase("numero"))) {
             double e1 = getNumero(val1);
             double e2 = getNumero(val2);
             if (e1 != e2) {
                 return "verdadero";
             } else {
                 return "falso";
             }
         }
          else if ((tipo1.equalsIgnoreCase("bool")) && (tipo2.equalsIgnoreCase("numero"))) {
             double e1 = getBoolNumero(val1);
             double e2 = getNumero(val2);
             if (e1 != e2) {
                 return "verdadero";
             } else {
                 return "falso";
             }
         }
          else if ((tipo1.equalsIgnoreCase("numero")) && (tipo2.equalsIgnoreCase("bool"))) {
             double e1 = getNumero(val1);
             double e2 = getBoolNumero(val2);
             if (e1 != e2) {
                 return "verdadero";
             } else {
                 return "falso";
             }
         }
          if ((tipo1.equalsIgnoreCase("bool")) && (tipo2.equalsIgnoreCase("bool"))) {
             double e1 = getBoolNumero(val1);
             double e2 = getBoolNumero(val2);
             if (e1 != e2) {
                 return "verdadero";
             } else {
                 return "falso";
             }
         }
          else if ((tipo1.equalsIgnoreCase("date")) && (tipo2.equalsIgnoreCase("datetime"))) {
              
             Datee fecha1=(Datee)val1;
             DateTime fecha2=(DateTime)val2;
             return "verdadero";
              
         }
          else if ((tipo1.equalsIgnoreCase("datetime")) && (tipo2.equalsIgnoreCase("date"))) {
            DateTime fecha1=(DateTime)val1;
             Datee fecha2=(Datee)val2;
            
                 return "verdadero";
             
         }
          else if ((tipo1.equalsIgnoreCase("cadena")) && (tipo2.equalsIgnoreCase("numero"))) {
             double e1 = val1.toString().length();
             double e2 = getNumero(val2);
             if (e1 != e2) {
                 return "verdadero";
             } else {
                 return "falso";
             }
         }
          else if ((tipo1.equalsIgnoreCase("numero")) && (tipo2.equalsIgnoreCase("cadena"))) {
             double e1 = getNumero(val1);
             double e2 = val2.toString().length();
             if (e1!= e2) {
                 return "verdadero";
             } else {
                 return "falso";
             }
         }
         //////////////////////////
          else if ((tipo1.equalsIgnoreCase("cadena")) && (tipo2.equalsIgnoreCase("date"))) {
              Datee v1= (Datee)val2;
              int no= compararCadenas(val1.toString(),v1.getDate());
             if (no==-1) {
                 return "verdadero";
             } else {
                 return "falso";
             }
         }
          else if ((tipo1.equalsIgnoreCase("date")) && (tipo2.equalsIgnoreCase("cadena"))) {
             Datee v1= (Datee)val1;
              int no= compararCadenas(v1.getDate(),val2.toString());
              if (!(no==0)) {
                 return "verdadero";
             } else {
                 return "falso";
             }
         }
          else if ((tipo1.equalsIgnoreCase("datetime")) && (tipo2.equalsIgnoreCase("cadena"))) {
            DateTime v1= (DateTime)val1;
              int no= compararCadenas(v1.getDateTime(),val2.toString());
             if (!(no==0)) {
                 return "verdadero";
             } else {
                 return "falso";
             }
         }
          else if ((tipo1.equalsIgnoreCase("cadena")) && (tipo2.equalsIgnoreCase("datetime"))) {
           DateTime v1= (DateTime)val2;
              int no= compararCadenas(val2.toString(),v1.getDateTime());
            if (!(no==0)) {
                 return "verdadero";
             } else {
                 return "falso";
             }
         }
          
          
          //aquiii
          else  if ((tipo1.equalsIgnoreCase("cadena")) && (tipo2.equalsIgnoreCase("cadena"))) {
             int no= compararCadenas(val1.toString(),val2.toString());
            if (!(no==0)) {
                 return "verdadero";
             } else {
                 return "falso";
             }
         } else  if ((tipo1.equalsIgnoreCase("date")) && (tipo2.equalsIgnoreCase("date"))) {
             Datee fecha1=(Datee)val1;
             Datee fecha2=(Datee)val2;
             if(!(esIgualFecha(fecha1,fecha2))){
                 return "verdadero";
             }else{
                 return "falso";
             }
             
         }else  if ((tipo1.equalsIgnoreCase("datetime")) && (tipo2.equalsIgnoreCase("datetime"))) {
            DateTime fecha1=(DateTime)val1;
             DateTime fecha2=(DateTime)val2;
             if(!(esIgualFechaTime(fecha1,fecha2))){
                 return "verdadero";
             }else{
                 return "falso";
             }
         }else{
             paginaActual.erroresPagina.insertarError("Semantico", "No es valido hacer una operacion relacional (menor) con  "+ tipo1+" y un "+ tipo2);
             return "nulo";
         }
    }
         
         
         
         /*------------------------- Operaciones extras ----------------------------------*/
         
        private int obtenerValorCadena(String cadena){
            int valorCadena=0;
            
            for (int i = 0; i < cadena.length(); i++) {
                
                valorCadena+=cadena.codePointAt(i);                
            }
            return valorCadena;   
        }
       
        
        private boolean esMenorFecha(Datee fecha1, Datee fecha2){
          
            if(fecha1.anio<fecha2.anio){
                return true;
            }else if(fecha1.anio== fecha2.anio){
                if(fecha1.mes<fecha2.mes){
                    return true;
                }else if(fecha1.mes== fecha2.mes){
                    if(fecha1.dia<fecha2.dia){
                        return true;
                    }
                }
            }
            return false;
        }
        
        
        private boolean esIgualFecha(Datee fecha1, Datee fecha2){
            return (fecha1.anio == fecha2.anio && fecha1.mes== fecha2.mes && fecha1.dia == fecha2.dia);
        }
        
        
        private boolean esIgualFechaTime(DateTime fecha1, DateTime fecha2){
            return (fecha1.fecha.anio == fecha2.fecha.anio && fecha1.fecha.mes== fecha2.fecha.mes && fecha1.fecha.dia == fecha2.fecha.dia &&
                    fecha1.horas== fecha2.horas && fecha1.minutos== fecha2.minutos && fecha1.segundos== fecha2.segundos);
        }
        
        
       private boolean esMayorFecha(Datee fecha1, Datee fecha2){
          
            if(fecha1.anio>fecha2.anio){
                return true;
            }else if(fecha1.anio== fecha2.anio){
                if(fecha1.mes>fecha2.mes){
                    return true;
                }else if(fecha1.mes== fecha2.mes){
                    if(fecha1.dia>fecha2.dia){
                        return true;
                    }
                }
            }
            return false;
        }
        
         
       
       
       
       private boolean esMenorFechaTime(DateTime fecha1, DateTime fecha2){
           if(esMenorFecha(fecha1.fecha, fecha2.fecha)){
               return true;
           }else{
               if(esIgualFecha(fecha1.fecha, fecha2.fecha)){
                   if(fecha1.horas<fecha2.horas){
                       return true;
                   }else if(fecha1.horas== fecha2.horas){
                       if(fecha1.minutos<fecha2.minutos){
                           return true;
                       }else if(fecha1.minutos== fecha2.minutos){
                           if(fecha1.segundos<fecha2.segundos){
                               return true;
                           }
                       }
                   }
               }
           }
           
           return false;
       }
       
       
       
       private boolean esMayorFechaTime(DateTime fecha1, DateTime fecha2){
           if(esMayorFecha(fecha1.fecha, fecha2.fecha)){
               return true;
           }else{
               if(esIgualFecha(fecha1.fecha, fecha2.fecha)){
                   if(fecha1.horas>fecha2.horas){
                       return true;
                   }else if(fecha1.horas== fecha2.horas){
                       if(fecha1.minutos>fecha2.minutos){
                           return true;
                       }else if(fecha1.minutos== fecha2.minutos){
                           if(fecha1.segundos>fecha2.segundos){
                               return true;
                           }
                       }
                   }
               }
           }
           
           return false;
       }
       
       
        public int compararCadenas(String cadena1, String cadena2)
        {
            int contador = 0;
            if(cadena1.length() == 0 && cadena2.length()==0)
                return 0;
           
            while(contador<cadena1.length() && contador < cadena2.length()){
                //iniciamos el ciclo
                int c1 = (int)cadena1.charAt(contador);//[contador];
                int c2 = (int)cadena2.charAt(contador);//[contador];

                if (c1 < c2) { System.out.println("menor"); return -1; }
                if (c1 > c2) { System.out.println("mayor"); return 1; }
                contador++;
                if (cadena1.length() == cadena2.length())
                { System.out.println("iguales"); return 0; }

                if (cadena1.length() > cadena2.length())
                { System.out.println("mayor"); return 1; }


                if (cadena1.length() < cadena2.length())
                { System.out.println("menor"); return -1; }

            }

            return 3;
        }
}
