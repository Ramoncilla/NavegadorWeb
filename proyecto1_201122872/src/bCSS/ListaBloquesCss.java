/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bCSS;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Ramonella
 */
public class ListaBloquesCss {
    
    public List<baseCss> listaBloques;
    
    public ListaBloquesCss(){
        this.listaBloques= new ArrayList<>();
    }
    
    public void insertarLista(Object v){
        List<baseCss> lista = (ArrayList<baseCss>)v;
        baseCss temporal;
        for (int i = 0; i < lista.size(); i++) {
            temporal = lista.get(i);
            this.listaBloques.add(temporal);
        }
    }
    
    
}
