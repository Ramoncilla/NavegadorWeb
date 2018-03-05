/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Errores;
import static proyecto1_201122872.Proyecto1_201122872.paginaActual;
/**
 *
 * @author Ramonella
 */
public class Error {
    
    public String archivo;
    public int linea;
    public int columna;
    public String tipo;
    public String descripcion;

    public Error(int linea, int columna, String tipo, String descripcion) {
        this.archivo= paginaActual.archivoActual;
        this.linea = linea;
        this.columna = columna;
        this.tipo = tipo;
        this.descripcion = descripcion;
    }

    public Error(String tipo, String descripcion) {
        this.archivo= paginaActual.archivoActual;
        this.tipo = tipo;
        this.descripcion = descripcion;
        this.linea=0;
        this.columna=0;
    }
    
    
    public String getErrorHTML(){
        return "<td>"+archivo+"</td>\n"
                + "<td>"+tipo+"</td>\n"
                + "<td>"+linea+"</td>\n"
                + "<td>"+columna+"</td>\n"
                + "<td>"+descripcion+"</td>\n";
    }
    
}
