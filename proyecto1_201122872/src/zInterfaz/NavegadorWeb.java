/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package zInterfaz;

import java.util.ArrayList;
import java.util.List;
import javax.swing.JTabbedPane;

/**
 *
 * @author Ramonella
 */
public class NavegadorWeb {
    
    public List<Pagina> panelesPagina;
    public List<String> historialNavegador;
    public List<String> elementosFavoritos;
        
    
    
    public NavegadorWeb(){
        this.panelesPagina= new ArrayList<>();
        this.historialNavegador= new ArrayList<>();
        this.elementosFavoritos= new ArrayList<>();
       
    }
    
    public void agregarPagina(Pagina nueva){
        this.panelesPagina.add(nueva);
    }
    
    
    public void agregarFavorito(String pagina){
        
        this.elementosFavoritos.add(pagina);
        
    }
    
    
    
    public void mostrarFavoritos(){
        String cad ="<table border=1><tr><th>Favoritos</th></tr>";
        
        for (int i = 0; i <this.elementosFavoritos.size(); i++) {
            cad+="<tr><td>"+this.elementosFavoritos.get(i)+"</td></tr>";
        }
        
        cad+="</table>";
        
        Favoritos f= new Favoritos();
        f.mostrar(cad);
        f.show();
 
    }
    
   public void mostrarHistorial(){
        String cad ="<table border=1><tr><th>Historial</th></tr>";
        
        for (int i = 0; i <this.historialNavegador.size(); i++) {
            cad+="<tr><td>"+this.historialNavegador.get(i)+"</td></tr>";
        }
        
        cad+="</table>";
        
        HistorialNavegador f= new HistorialNavegador();
        f.mostrar(cad);
        f.show();
 
    }  
    
    
    
}
