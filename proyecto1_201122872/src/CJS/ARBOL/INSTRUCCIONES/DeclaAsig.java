/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CJS.ARBOL.INSTRUCCIONES;

import CJS.TablaSimbolos.SimbVariable;
import CJS.TablaSimbolos.tablaSimbolos;
import CJS.elementoRetorno;
import CJS.objetoBase;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Ramonella
 */
public class DeclaAsig extends objetoBase{
    
    List<objetoBase> lista ;
    
    public DeclaAsig(Object listado){
        this.lista = (ArrayList<objetoBase>)listado;    
    }
    
     @Override
    public elementoRetorno Ejecutar(tablaSimbolos tabla, int contexto){
        
        objetoBase temporal;
        Object v;
        for (int i = 0; i < lista.size(); i++) {
                temporal = lista.get(i);
                v= temporal.Ejecutar(tabla, contexto);
                
            }
        System.out.println("DEclaracion- Asignacion");
        tabla.imprimirTablaSimbolos();
        System.out.println("fin declaracion - asignanicon");
        return new elementoRetorno();
    }
    
    
}
