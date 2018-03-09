/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package zInterfaz;

import bCSS.Grupo;
import bCSS.ID;
import java.util.ArrayList;
import java.util.List;
import proyecto1_201122872.CHTML.BODY.Caja;
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
        Etiqueta temporal;
        int control=0;
        for (int i = 0; i < valores.size(); i++) {
            temporal = valores.get(i);
            temporal.numeroIdentificador=control;
            if(temporal instanceof Panel){
                Panel p = (Panel)temporal;
                Object vec2[]=  agregarListaPanel ((ArrayList<Etiqueta>) p.objetosPanel.etiquetas,(control+1));;
                ArrayList<Etiqueta> etiquetasPanel = (ArrayList<Etiqueta>) vec2[1];
                ((Panel) temporal).objetosPanel.sentenciasCuerpo=etiquetasPanel;
                control = Integer.parseInt(vec2[0].toString());
            }else if(temporal instanceof Caja){
                Caja c = (Caja)temporal;
                 Object vec2[]=agregarListaPanel((ArrayList<Etiqueta>) c.opcionesCaja,(control+1));
                 ArrayList<Etiqueta> opcionesCaja= (ArrayList<Etiqueta>)vec2[1];
                 ((Caja)temporal).opcionesCaja=opcionesCaja;
                 control = Integer.parseInt(vec2[0].toString());                
            }
            this.etiquetasHTML.add(temporal);
            control++;
            
        }
    }
    
    private Object[] agregarListaPanel (ArrayList<Etiqueta> valores, int v){
        Object vec[]= new Object[2];
        List<Etiqueta> eti = new ArrayList<>();
        int control =v;
        Etiqueta temporal;
        for (int i = v; i < (v+valores.size()); i++) {
            temporal = valores.get(i-v);
            temporal.numeroIdentificador=control;
            if(temporal instanceof Panel){
                Panel p = (Panel)temporal;
                Object vec2[]=  agregarListaPanel ((ArrayList<Etiqueta>) p.objetosPanel.etiquetas,(control+1));;
                ArrayList<Etiqueta> etiquetasPanel = (ArrayList<Etiqueta>) vec2[1];
                ((Panel) temporal).objetosPanel.sentenciasCuerpo=etiquetasPanel;
            }else if(temporal instanceof Caja){
                Caja c = (Caja)temporal;
                Object vec2[]=agregarListaPanel((ArrayList<Etiqueta>) c.opcionesCaja,(control+1));
                ArrayList<Etiqueta>etiquetasOpciones = (ArrayList<Etiqueta>) vec2[1];
                ((Caja)temporal).opcionesCaja=etiquetasOpciones;
            }
            eti.add(temporal);
            control++;
        }
        vec[0]=control;
        vec[1]=eti;
        return vec;
    }
    
    
    public void actualizarEtiquetaDOM(Etiqueta et){
        Etiqueta temporal; 
        for (int i = 0; i < this.etiquetasHTML.size(); i++) {
            temporal = this.etiquetasHTML.get(i);
            if(et.numeroIdentificador== temporal.numeroIdentificador){
                Etiqueta n = et.retornarHtml();
                this.etiquetasHTML.set(i, n);
                break;
            }else if(temporal instanceof Panel){
                 Panel e =actualizarPanel((Panel)temporal,et);
                 this.etiquetasHTML.set(i, e);
            }
        }
    }
    
    
    public Panel actualizarPanel(Panel et, Etiqueta b){
        Etiqueta temporal;
        for (int i = 0; i < et.objetosPanel.sentenciasCuerpo.size(); i++) {
            temporal = et.objetosPanel.sentenciasCuerpo.get(i);
            if(temporal.numeroIdentificador==b.numeroIdentificador){
                Etiqueta g = b.retornarHtml();
                et.objetosPanel.sentenciasCuerpo.set(i, g);
               return et;
            }else if(temporal instanceof Panel){
                Panel c=(Panel)temporal;
                Panel v = actualizarPanel(c,b);
                et.objetosPanel.sentenciasCuerpo.set(i, v); 
  
            }
            
        }

        return et;
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
        Etiqueta temporal;
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
    
  
    
    
    /*  aplicar estilos CSS*/
    
    public void aplicarCssID(ID bloque){
        
        List<Etiqueta> elementosID= obtenerEtiquetasID(bloque.id);
        for (int i = 0; i < elementosID.size(); i++) {
            System.out.println(i);
        }
        
    }
    
    public void aplicarCSSGrupo(Grupo bloque){
        List<Etiqueta> elementosGrupo= obtenerEtiquetasGrupo(bloque.grupo);
        for (int i = 0; i < elementosGrupo.size(); i++) {
            System.out.println(i);
        } 
        
    }
    
    
    
    /*Obtener Valores por grupo*/
    
    
      public List<Etiqueta> obtenerEtiquetasGrupo(String id){
        List<Etiqueta> lista = new ArrayList<>();
        
        
         Etiqueta temporal, ret;
        for (int i = 0; i < this.etiquetasHTML.size(); i++) {
            temporal = this.etiquetasHTML.get(i);
            if (!temporal.grupo.equalsIgnoreCase("nulo")) {
                if (temporal.grupo.equalsIgnoreCase(id)) {
                    lista.add(temporal);
                } else if (temporal instanceof Panel) {
                    Panel p = (Panel) temporal;
                   lista = obtenerEtiquetaPanelGrupo((ArrayList<Etiqueta>) p.objetosPanel.etiquetas, id, (ArrayList<Etiqueta>) lista);
                    
                        
                }
            } else {
                if (temporal instanceof Panel) {
                     Panel p = (Panel) temporal;
                    lista = obtenerEtiquetaPanelGrupo((ArrayList<Etiqueta>) p.objetosPanel.etiquetas, id, (ArrayList<Etiqueta>) lista);
                    
                        

                }
            }

        }
        
        return lista;
    }
  
      private List<Etiqueta> obtenerEtiquetaPanelGrupo (ArrayList<Etiqueta> etiquetas, String nombre, ArrayList<Etiqueta>lista){
    
          Etiqueta temporal;
        for (int i = 0; i < etiquetas.size(); i++) {
           temporal = etiquetas.get(i);
           if(temporal.grupo.equalsIgnoreCase(nombre)){
               lista.add(temporal);
           }else if(temporal instanceof Panel){
               Panel p = (Panel)temporal;
               lista = (ArrayList<Etiqueta>) obtenerEtiquetaPanelGrupo((ArrayList<Etiqueta>)p.objetosPanel.etiquetas,nombre,lista);
           }
        }
        return lista;
    }
    
    
    
    
    
    
    
    
    
    /*obtener valores por id*/
    
    
    public List<Etiqueta> obtenerEtiquetasID(String id){
        List<Etiqueta> lista = new ArrayList<>();
        
        
         Etiqueta temporal, ret;
        for (int i = 0; i < this.etiquetasHTML.size(); i++) {
            temporal = this.etiquetasHTML.get(i);
            if (!temporal.id.equalsIgnoreCase("nulo")) {
                if (temporal.id.equalsIgnoreCase(id)) {
                    lista.add(temporal);
                } else if (temporal instanceof Panel) {
                    Panel p = (Panel) temporal;
                   lista = obtenerEtiquetaPanelID((ArrayList<Etiqueta>) p.objetosPanel.etiquetas, id, (ArrayList<Etiqueta>) lista);
                    
                        
                }
            } else {
                if (temporal instanceof Panel) {
                     Panel p = (Panel) temporal;
                    lista = obtenerEtiquetaPanelID((ArrayList<Etiqueta>) p.objetosPanel.etiquetas, id, (ArrayList<Etiqueta>) lista);
                    
                        

                }
            }

        }
        
        return lista;
    }
  
      private List<Etiqueta> obtenerEtiquetaPanelID (ArrayList<Etiqueta> etiquetas, String nombre, ArrayList<Etiqueta>lista){
    
          Etiqueta temporal;
        for (int i = 0; i < etiquetas.size(); i++) {
           temporal = etiquetas.get(i);
           if(temporal.id.equalsIgnoreCase(nombre)){
               lista.add(temporal);
           }else if(temporal instanceof Panel){
               Panel p = (Panel)temporal;
               lista = (ArrayList<Etiqueta>) obtenerEtiquetaPanelID((ArrayList<Etiqueta>)p.objetosPanel.etiquetas,nombre,lista);
           }
        }
        return lista;
    }
    
    
    
    
    
}