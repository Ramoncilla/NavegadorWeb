/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CJS.TablaSimbolos;

import proyecto1_201122872.CHTML.Etiqueta;

/**
 *
 * @author Ramonella
 */
public class SimbEtiqueta extends Simbolo{
    
    public Etiqueta etiquetaHTML;
    
    
    public SimbEtiqueta(Etiqueta et){
        this.etiquetaHTML=et;
    }

    @Override
    public String imprimirSimbolo() {
        String cad = "Tipo: Etiqueta\n"
                + "id: "+ this.etiquetaHTML.id+"\n"
                + "Grupo: "+ this.etiquetaHTML.grupo +"\n"
                + "Alineado: "+ this.etiquetaHTML.alineado+"\n"
                + "Alto: "+ this.etiquetaHTML.alto+"\n"
                + "Ancho: "+ this.etiquetaHTML.ancho+"\n";
        
        
        return cad;
    }
    
  
    
    
    
}
