/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CJS.ARBOL.INSTRUCCIONES;

import CJS.TablaSimbolos.tablaSimbolos;
import CJS.elementoRetorno;
import CJS.objetoBase;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Ramonella
 */
public class asignaArreglo extends objetoBase{
    
  public String nombreArreglo;
  public List<objetoBase> elementosArreglo;
  
  public asignaArreglo(Object nombre, Object elementos){
      this.nombreArreglo= nombre.toString();
      this.elementosArreglo= (ArrayList<objetoBase>)elementos;
  }

  
  private Object[] ejecutarElementos(tablaSimbolos tabla, int contexto, List<objetoBase> elementos){
      Object[] valorElementos= new Object[elementos.size()];
      elementoRetorno ret;
      for (int i = 0; i < elementos.size(); i++) {
          ret= elementos.get(i).Ejecutar(tabla, contexto);
          valorElementos[i]= ret.ValorRetorno;
      }
      return valorElementos;
  }

    @Override
    public elementoRetorno Ejecutar(tablaSimbolos tabla, int contexto) {
        Object [] valores = ejecutarElementos(tabla,contexto,this.elementosArreglo);
        tabla.asignarSimbolo(this.nombreArreglo ,valores,contexto);
        System.out.println("asignacion - arreglo");
        tabla.imprimirTablaSimbolos();
           System.out.println("fin asigna - arreglo");
        
        return new elementoRetorno(); //To change body of generated methods, choose Tools | Templates.
    }
  
  
  
  
  
    
}
