/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Errores;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Ramonella
 */
public class tablaErrores {
    
    List<ErrorS> listadoErrores;
    
    
    public tablaErrores(){
        this.listadoErrores= new ArrayList<>();
    }
    
    public void insertarError(ErrorS e){
        this.listadoErrores.add(e);
    }
    
    public void reiniciarErrores(){
        this.listadoErrores.clear();
    }
    
    
    public void insertarError(String tipo, String descripcion){
        // public Error(String tipo, String descripcion)
        ErrorS er= new ErrorS(tipo, descripcion);
        this.listadoErrores.add(er);
        
        
    }
    
    public String getErroresHTML(){
        String tabla="<table border=1>\n"
                + "<tr>\n"
                + "<th> Archivo </th>\n"
                + "<th> Tipo </th>\n"
                + "<th> Linea</th>\n"
                + "<th>Columna</th>\n"
                + "<th>Descripcion</th>\n"
                + "</tr>\n";
        
        for (int i = 0; i < listadoErrores.size(); i++) {
            tabla+="<tr>\n"+listadoErrores.get(i).getErrorHTML()+"</tr>\n";
            
        }
        tabla+="</table>";
        return tabla;
    }
    
    
    public boolean hayErrores(){
        return (this.listadoErrores.size()>=1);
    }
    
    
    
}
