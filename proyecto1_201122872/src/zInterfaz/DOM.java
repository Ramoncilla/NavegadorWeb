/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package zInterfaz;

import java.util.ArrayList;
import java.util.List;
import proyecto1_201122872.CHTML.BODY.Panel;
import proyecto1_201122872.CHTML.Etiqueta;

/**
 *
 * @author Ramonella
 */
public class DOM {
    
    public List<Etiqueta>etiquetasHTML;
    
    public DOM(){
        this.etiquetasHTML= new ArrayList<>();
    }
    
    
    public void agregarListaEtiquetas (ArrayList<Etiqueta> valores){
        for (int i = 0; i < valores.size(); i++) {
            this.etiquetasHTML.add(valores.get(i));
        }
    }
    
    
    public Etiqueta obtenerElemento(String id) {

        Etiqueta temporal, ret;
        for (int i = 0; i < this.etiquetasHTML.size(); i++) {
            temporal = this.etiquetasHTML.get(i);
            if (!temporal.id.equalsIgnoreCase("nulo")) {
                if (temporal.id.equalsIgnoreCase(id)) {
                    return temporal;                   
                } else if (temporal instanceof Panel) {
                    Panel p = (Panel) temporal;
                    ret = obtenerEtiquetaPanel((ArrayList<Etiqueta>) p.objetosPanel.etiquetas, id);
                    if(ret!=null)
                        return ret;
                }
            } else {
                if (temporal instanceof Panel) {
                     Panel p = (Panel) temporal;
                    ret = obtenerEtiquetaPanel((ArrayList<Etiqueta>) p.objetosPanel.etiquetas, id);
                    if(ret!=null)
                        return ret;

                }
            }

        }

        return null;
    }

    
    
    private Etiqueta obtenerEtiquetaPanel(ArrayList<Etiqueta> etiquetas, String nombre){
        Etiqueta temporal, temporal2;
        for (int i = 0; i < etiquetas.size(); i++) {
           temporal = etiquetas.get(i);
           if(temporal.id.equalsIgnoreCase(nombre)){
               return temporal;
           }else if(temporal instanceof Panel){
               Panel p = (Panel)temporal;
               return obtenerEtiquetaPanel((ArrayList<Etiqueta>)p.objetosPanel.etiquetas,nombre);
           }
        }
        return null;
    }
}
