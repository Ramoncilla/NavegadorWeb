/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto1_201122872.CHTML.BODY;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import proyecto1_201122872.CHTML.ElemetoPropiedad.propiedad;
import proyecto1_201122872.CHTML.Etiqueta;
import proyecto1_201122872.CHTML.listaElementos;
/**
 *
 * @author Ramonella
 */
public class Cuerpo extends Etiqueta  {
    
    public listaElementos elementosCuerpo;
    public List<Etiqueta> sentenciasCuerpo;
    
    public Cuerpo(Object elementos, Object etiquetas){
    
        this.elementosCuerpo = new listaElementos((ArrayList<propiedad>)elementos);
        this.sentenciasCuerpo = (ArrayList<Etiqueta>)etiquetas;
    }
    
    public Cuerpo(Object elementos){
            
        this.elementosCuerpo = new listaElementos((ArrayList<propiedad>)elementos);
        this.sentenciasCuerpo = new ArrayList<>();
    }
    
    public void imprimir(){
        System.out.println(sentenciasCuerpo.size());
    }
    
    public List<Object>ejecutarCuerpo(){
        List<Object> etiquetas = new ArrayList<>();
        
        Etiqueta temporal;
        for (int i = 0; i < sentenciasCuerpo.size(); i++) {
            temporal = sentenciasCuerpo.get(i);
            if(temporal.MostrarHtml() instanceof JButton){
                etiquetas.add(temporal.MostrarHtml());
        }   
        }
      return etiquetas;
    }
    
}
