/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto1_201122872;

import Errores.tablaErrores;
import Funciones.ListaFunciones;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 *
 * @author Ramonella
 */
public class Proyecto1_201122872 {

    public static String archivoActual="archivin";
    public static tablaErrores erroresEjecucion;
    public static String cadenaImpresion;
    public static ListaFunciones lFunciones;
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        erroresEjecucion= new tablaErrores();
        cadenaImpresion="";
        lFunciones= new ListaFunciones();
        Navegador n= new Navegador();
        n.show();
        
        List<String> lista = new ArrayList<>();
        lista.add("alina");
        lista.add("pedrito bello");
        lista.add("popo");
        lista.add("compi2");
        lista.add("pipi");
        
        String temporal ;
        for (Iterator<String> iter = lista.iterator(); iter.hasNext();) {
            temporal = iter.next();
            if(temporal.equalsIgnoreCase("popo")|| temporal.equalsIgnoreCase("pipi")){
                iter.remove();
            }
            
        }
        
        for (int i = 0; i < lista.size(); i++) {
            System.out.println(lista.get(i));
        }
        
        
        
        /*  public Simbolos_Tabla modificarTabla(Simbolos_Tabla reales, Simbolos_Tabla modificados){
          nodo_tabla temporal;
          for(Iterator<nodo_tabla> iter = modificados.elementos_tabla.iterator(); iter.hasNext();){
                                     nodo_tabla t = iter.next();
                    temporal= getVarModificada(t,reales.elementos_tabla);
                    
                    if(temporal==null){
               iter.remove();
              }
          } 
          return modificados;
      }
      */
        
        
        
    }
    
}
