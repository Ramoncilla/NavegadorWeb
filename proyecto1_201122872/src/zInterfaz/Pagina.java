/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package zInterfaz;

import CJS.TablaSimbolos.tablaSimbolos;
import Errores.tablaErrores;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JTextPane;
import proyecto1_201122872.LectoArchivos;

/**
 *
 * @author Ramonella
 */
public class Pagina {
    
    public tablaSimbolos tabla;
    public tablaErrores erroresPagina;
    public EjecutarAnalizador analizadores;
    public String rutaPagina;
    public JTextPane areaWeb;
    public String nombrePagina;
    public int idPagina;
    public List<String> historialPagina;
    public List<String> rutasArchivosCSS;
    public List<String> rutasArchivosJS;
    private LectoArchivos lector;
    public String cadenaSalida;
    
    public Pagina(int id){
        this.lector= new LectoArchivos("");
        this.rutasArchivosCSS= new ArrayList<>();
        this.rutasArchivosJS= new ArrayList<>();
        this.areaWeb= new JTextPane();
        this.areaWeb.setContentType("text/html");
        this.areaWeb.setEditable(false);
        this.tabla= new tablaSimbolos();
        this.erroresPagina= new tablaErrores();
        this.analizadores = new EjecutarAnalizador();
        this.idPagina= id;
        this.nombrePagina= "";
        this.rutaPagina = "";
        this.cadenaSalida="salidaaaa";
    }

    public void setRutaPagina(String rutaPagina) {
        this.rutaPagina = rutaPagina;
    }

    public void setNombrePagina(String nombrePagina) {
        this.nombrePagina = nombrePagina;
    }
    
    public void agregarCadenaSalida(String cad){
        this.cadenaSalida+=cad;
    }
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    /*Mostrar Opciones*/
    
    public String obtenerCadenaSalida(){
        return this.cadenaSalida;
    }
    
    public String[] obtenerCodigoHTML(){
        String [] retorno = new String[2];
        retorno[0]=this.nombrePagina;
        retorno[1] = this.lector.obtenerContenidoArchivo(this.rutaPagina); 
        return retorno;
    }
    
    public List<String[]> obtenerCodigoJS(){
        List<String[]>retorno = new ArrayList<>();
        File temporal;
        String [] val= new String[2];
        for (int i = 0; i < this.rutasArchivosJS.size(); i++) {
          temporal= new File(rutasArchivosJS.get(i));
          val[0]=temporal.getName();
          val[1]=lector.obtenerContenidoArchivo(rutasArchivosJS.get(i));
          retorno.add(val);
        }
        return retorno;
    }
    
    
    public List<String[]> obtenerCodigoCSS(){
      List<String[]>retorno = new ArrayList<>();
        File temporal;
        String [] val= new String[2];
        for (int i = 0; i < this.rutasArchivosCSS.size(); i++) {
          temporal= new File(rutasArchivosCSS.get(i));
          val[0]=temporal.getName();
          val[1]=lector.obtenerContenidoArchivo(rutasArchivosCSS.get(i));
          retorno.add(val);
        }
        return retorno;
    }
    
    
    public String obtenerErrores(){
        return this.erroresPagina.getErroresHTML();
    }
    
    
    
    
    
    
    
    
    
    
    
 
    
    
    
    
}
