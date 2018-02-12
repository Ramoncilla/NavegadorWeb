/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto1_201122872;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;


/**
 *
 * @author Ramonella
 */
public class LectoArchivos {
    
    private String rutaArchivo="";
    
    public LectoArchivos(String path){    
        this.rutaArchivo=path;
    }
    
    public String obtenerContenidoArchivo(){
        String cadena="";
        File archivo = null;
        FileReader fr = null;
        BufferedReader br = null;

        try {
            archivo = new File(this.rutaArchivo);
            fr = new FileReader(archivo);
            br = new BufferedReader(fr);

            String linea;
            while ((linea = br.readLine()) != null) {
                cadena+=linea;
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {

            try {
                if (null != fr) {
                    fr.close();
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
        return cadena;
    }
    
    
    
    
    
}
