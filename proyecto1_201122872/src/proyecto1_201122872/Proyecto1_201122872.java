/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto1_201122872;

import Errores.tablaErrores;
import Funciones.ListaFunciones;

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
    }
    
}
