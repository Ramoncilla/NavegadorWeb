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
public class expresionesAritmeticas extends expresionBase {
    
    Suma sumas= new Suma();
    Resta restas = new Resta();
    Multiplicacion multiplicaciones = new Multiplicacion();
    Division divisiones = new Division();
    Potencia potencias = new Potencia();
    Residuo residuos = new Residuo();
    
    @Override
    public Object Resolver(Object operando1, Object operando2, String signo){
      Object resultado;
        switch (signo) {
            case "+": {
                resultado=sumas.Resolver(operando1, operando2); 
                System.out.println(operando1+" + "+operando2+" = " + resultado);
                return resultado;
            }
            case "*": {
                resultado=multiplicaciones.Resolver(operando1, operando2); 
                System.out.println(operando1+" * "+operando2+" = " + resultado);
                return resultado;
            }
            case "/": {
                resultado=divisiones.Resolver(operando1, operando2); 
                System.out.println(operando1+" / "+operando2+" = " + resultado);
                return resultado;
            }
            case "-": {
                resultado=restas.Resolver(operando1, operando2); 
                System.out.println(operando1+" - "+operando2+" = " + resultado);
                return resultado;
            }
            case "^": {
               resultado=potencias.Resolver(operando1, operando2); 
                System.out.println(operando1+" ^ "+operando2+" = " + resultado);
                return resultado;
            }
             case "%": {
               resultado=residuos.Resolver(operando1, operando2); 
                System.out.println(operando1+" % "+operando2+" = " + resultado);
                return resultado;
            }
        }
        return "nulo";  
    }
    
    
    
    
}
