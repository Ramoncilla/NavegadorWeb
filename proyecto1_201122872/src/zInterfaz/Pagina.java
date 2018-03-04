/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package zInterfaz;

import CJS.TablaSimbolos.tablaSimbolos;
import Errores.tablaErrores;
import java.util.List;
import javax.swing.JTextPane;

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
    
    public Pagina(int id){
        
        this.areaWeb= new JTextPane();
        this.areaWeb.setContentType("text/html");
        this.areaWeb.setEditable(false);
        this.tabla= new tablaSimbolos();
        this.erroresPagina= new tablaErrores();
        this.analizadores = new EjecutarAnalizador();
        this.idPagina= id;
        this.nombrePagina= "";
        this.rutaPagina = "";
    }

    public void setRutaPagina(String rutaPagina) {
        this.rutaPagina = rutaPagina;
    }

    public void setNombrePagina(String nombrePagina) {
        this.nombrePagina = nombrePagina;
    }
    
   
    
    
    
    
    
    
    
    
    
    
    
    
 
    
    
    
    
}
