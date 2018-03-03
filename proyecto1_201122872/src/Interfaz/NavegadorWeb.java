/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interfaz;

import java.util.ArrayList;
import java.util.List;
import javax.swing.JTabbedPane;

/**
 *
 * @author Ramonella
 */
public class NavegadorWeb {
    
    List<Pagina> panelesPagina;
    JTabbedPane pestanhas;
    
    
    
    public NavegadorWeb(){
        this.panelesPagina= new ArrayList<>();
        this.pestanhas= new JTabbedPane();
    }
    
    
    
    
}
