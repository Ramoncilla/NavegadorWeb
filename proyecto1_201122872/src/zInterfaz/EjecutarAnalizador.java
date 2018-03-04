/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package zInterfaz;

import CJS.TablaSimbolos.tablaSimbolos;
import CJS.objetoBase;
import Funciones.Funcion;
import java.io.BufferedReader;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import proyecto1_201122872.AnalizadorCJS.ParserPrimera;
import proyecto1_201122872.AnalizadorCJS.scannerCJS;
import proyecto1_201122872.LectoArchivos;
import static proyecto1_201122872.Proyecto1_201122872.cadenaImpresion;
import static proyecto1_201122872.Proyecto1_201122872.erroresEjecucion;
import static proyecto1_201122872.Proyecto1_201122872.lFunciones;

/**
 *
 * @author Ramonella
 */
public class EjecutarAnalizador {
    
    
    
   public void ejecutarHTML(){
       
   } 
   
   
  private void ejecutarCJS(String rutaArchivo) throws Exception{
      
        if(rutaArchivo.isEmpty()){
            JOptionPane.showMessageDialog(null,"Error, ruta no valida para ejecutar CJS.", "USAC-WEB", JOptionPane.INFORMATION_MESSAGE);
            return;
        }else{
          LectoArchivos lector = new LectoArchivos(rutaArchivo);
        String cadena=lector.obtenerContenidoArchivo();
        if(cadena.isEmpty()){
            JOptionPane.showMessageDialog(null,"Error, no ess posible analizar una cadena vacia", "USAC-WEB", JOptionPane.INFORMATION_MESSAGE);
            return;
        }else{
            System.out.println("Inicio de Analisis JS");
            
            scannerCJS scannerjs = new scannerCJS(new BufferedReader(new StringReader(cadena)));
            proyecto1_201122872.AnalizadorCJS.Parser parserCJS = new proyecto1_201122872.AnalizadorCJS.Parser(scannerjs);
            parserCJS.parse();           
            List<objetoBase> h = (ArrayList<objetoBase>)parserCJS.listaSentencias;
            tablaSimbolos tabla = new tablaSimbolos();
            objetoBase temporal; 
            Object v ;
            List<objetoBase> sentencias= new ArrayList<>();
            for (int i = 0; i < h.size(); i++) {
                temporal = h.get(i);
                
                if(temporal instanceof Funcion){
                    lFunciones.insertarFuncion((Funcion) temporal);
                }else{
                    sentencias.add(temporal);
                }
                
                
            }
            
             for (int i = 0; i < sentencias.size(); i++) {
                temporal = sentencias.get(i);
                
               v= temporal.Ejecutar(tabla, 0);
                
                
            }
                        
           System.out.println("Fin de analisis JS");  
        }  
        }
        
        
    }
   
   
   public void ejecutarCSS(){
       
       
   }
   
    
    
}
