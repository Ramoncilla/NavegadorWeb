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
import proyecto1_201122872.CHTML.ElemetoPropiedad.propiedad;
import proyecto1_201122872.CHTML.Etiqueta;

/**
 *
 * @author Ramonella
 */
public class DOM {

    public List<Etiqueta> etiquetasHTML;

    public DOM() {
        this.etiquetasHTML = new ArrayList<>();
    }

    public void agregarListaEtiquetas(ArrayList<Etiqueta> valores) {
        Etiqueta temporal;
        int control = 0;
        for (int i = 0; i < valores.size(); i++) {
            temporal = valores.get(i);
            temporal.numeroIdentificador = control;
            if (temporal instanceof Panel) {
                Panel p = (Panel) temporal;
                Object vec2[] = agregarListaPanel((ArrayList<Etiqueta>) p.objetosPanel.sentenciasCuerpo, (control + 1));;///////////////////////////////
                ArrayList<Etiqueta> etiquetasPanel = (ArrayList<Etiqueta>) vec2[1];
                ((Panel) temporal).objetosPanel.sentenciasCuerpo = etiquetasPanel;
                control = Integer.parseInt(vec2[0].toString());
            } else if (temporal instanceof Caja) {
                Caja c = (Caja) temporal;
                Object vec2[] = agregarListaPanel((ArrayList<Etiqueta>) c.opcionesCaja, (control + 1));
                ArrayList<Etiqueta> opcionesCaja = (ArrayList<Etiqueta>) vec2[1];
                ((Caja) temporal).opcionesCaja = opcionesCaja;
                control = Integer.parseInt(vec2[0].toString());
            }
            this.etiquetasHTML.add(temporal);
            control++;

        }
    }

    private Object[] agregarListaPanel(ArrayList<Etiqueta> valores, int v) {
        Object vec[] = new Object[2];
        List<Etiqueta> eti = new ArrayList<>();
        int control = v;
        Etiqueta temporal;
        for (int i = v; i < (v + valores.size()); i++) {
            temporal = valores.get(i - v);
            temporal.numeroIdentificador = control;
            if (temporal instanceof Panel) {
                Panel p = (Panel) temporal;
                Object vec2[] = agregarListaPanel((ArrayList<Etiqueta>) p.objetosPanel.sentenciasCuerpo, (control + 1));//gdfgfdgfgfgfhg
                ArrayList<Etiqueta> etiquetasPanel = (ArrayList<Etiqueta>) vec2[1];
                ((Panel) temporal).objetosPanel.sentenciasCuerpo = etiquetasPanel;
            } else if (temporal instanceof Caja) {
                Caja c = (Caja) temporal;
                Object vec2[] = agregarListaPanel((ArrayList<Etiqueta>) c.opcionesCaja, (control + 1));
                ArrayList<Etiqueta> etiquetasOpciones = (ArrayList<Etiqueta>) vec2[1];
                ((Caja) temporal).opcionesCaja = etiquetasOpciones;
            }
            eti.add(temporal);
            control++;
        }
        vec[0] = control;
        vec[1] = eti;
        return vec;
    }

    public void actualizarEtiquetaDOM(Etiqueta et) {
        Etiqueta temporal;
        for (int i = 0; i < this.etiquetasHTML.size(); i++) {
            temporal = this.etiquetasHTML.get(i);
            if (et.numeroIdentificador == temporal.numeroIdentificador) {
                //Etiqueta n = et.retornarHtml();
                et.agregarElementos();
                et.asignarElementos();               
                this.etiquetasHTML.set(i, et);
                break;
            } else if (temporal instanceof Panel) {
                Panel e = actualizarPanel((Panel) temporal, et);
                this.etiquetasHTML.set(i, e);
            }
        }
    }

    public Panel actualizarPanel(Panel et, Etiqueta b) {
        Etiqueta temporal;
        for (int i = 0; i < et.objetosPanel.sentenciasCuerpo.size(); i++) {
            temporal = et.objetosPanel.sentenciasCuerpo.get(i);
            if (temporal.numeroIdentificador == b.numeroIdentificador) {
                //Etiqueta g = b.retornarHtml();
                b.agregarElementos();
                b.asignarElementos();
                et.objetosPanel.sentenciasCuerpo.set(i, b);
                return et;
            } else if (temporal instanceof Panel) {
                Panel c = (Panel) temporal;
                Panel v = actualizarPanel(c, b);
                et.objetosPanel.sentenciasCuerpo.set(i, v);

            }

        }

        return et;
    }

    public Etiqueta obtenerElemento2(String id) {

        Etiqueta temporal, ret;
        for (int i = 0; i < this.etiquetasHTML.size(); i++) {
            temporal = this.etiquetasHTML.get(i);
            if (!temporal.id.equalsIgnoreCase("nulo")) {
                if (temporal.id.equalsIgnoreCase(id)) {
                    return temporal;
                } else if (temporal instanceof Panel) {
                    Panel p = (Panel) temporal;
                    ret = obtenerEtiquetaPanel((ArrayList<Etiqueta>) p.objetosPanel.sentenciasCuerpo, id);////////////////////////////////
                    if (ret != null) {
                        return ret;
                    }
                }
            } else {
                if (temporal instanceof Panel) {
                    Panel p = (Panel) temporal;
                    ret = obtenerEtiquetaPanel((ArrayList<Etiqueta>) p.objetosPanel.sentenciasCuerpo, id);/////////////////////////////////
                    if (ret != null) {
                        return ret;
                    }

                }
            }

        }

        return null;
    }

    private Etiqueta obtenerEtiquetaPanel2(ArrayList<Etiqueta> etiquetas, String nombre) {
        Etiqueta temporal;
        for (int i = 0; i < etiquetas.size(); i++) {
            temporal = etiquetas.get(i);
            if (temporal.id.equalsIgnoreCase(nombre)) {
                return temporal;
            } else if (temporal instanceof Panel) {
                Panel p = (Panel) temporal;
                return obtenerEtiquetaPanel((ArrayList<Etiqueta>) p.objetosPanel.sentenciasCuerpo, nombre);/////////////////////////////
            }
        }
        return null;
    }

    
    
    public Etiqueta obtenerElemento(String id){
        Etiqueta temporal;
        String nTemporal;
        for (int i = 0; i < this.etiquetasHTML.size(); i++) {
            temporal = this.etiquetasHTML.get(i);
            
            if(temporal.id.equalsIgnoreCase(id)){
                return temporal;
            }else if(temporal instanceof Panel){
                nTemporal = this.etiquetasHTML.get(i).id;
                Panel p = (Panel)temporal;
                Etiqueta temporalPanel = obtenerEtiquetaPanel(p.objetosPanel.sentenciasCuerpo,id);
                if(temporalPanel!=null)
                    return temporalPanel;
            }    
        }
        
        return null;
    }
    
    
    private Etiqueta obtenerEtiquetaPanel(List<Etiqueta> sentenciasPanel, String id){
        Etiqueta temporal;
        String nTemporal;
        for (int i = 0; i < sentenciasPanel.size(); i++) {
            temporal = sentenciasPanel.get(i);
            
            if(sentenciasPanel.get(i).id.equalsIgnoreCase(id)){
                return temporal;
            }else if(temporal instanceof Panel){
                nTemporal= sentenciasPanel.get(i).id;
                Panel p = (Panel)temporal;
                Etiqueta t = obtenerEtiquetaPanel(p.objetosPanel.sentenciasCuerpo,id);
                if(t!=null)
                    return t;
            }
        }
        return null;
    }
    
    
    
    
    /*  aplicar estilos CSS*/
    public void aplicarCssID(ID bloque) {

        List<Etiqueta> elementosID = obtenerEtiquetasID(bloque.id);
        propiedad propTemporal;
        Etiqueta elementoTemporal;
        for (int i = 0; i < elementosID.size(); i++) {
            elementoTemporal = elementosID.get(i);
            for (int j = 0; j < bloque.propiedadesCss.size(); j++) {
                propTemporal = bloque.propiedadesCss.get(j);
                elementoTemporal.elementosEtiqueta.listadoElementos.add(propTemporal);
            }
            actualizarEtiquetaDOM(elementoTemporal);
        }
    }

    public void aplicarCSSGrupo(Grupo bloque) {
        List<Etiqueta> elementosGrupo = obtenerEtiquetasGrupo(bloque.grupo);
        propiedad propTemporal;
        Etiqueta elementoTemporal;
        for (int i = 0; i < elementosGrupo.size(); i++) {
            elementoTemporal = elementosGrupo.get(i);
            for (int j = 0; j < bloque.propiedadesCss.size(); j++) {
                propTemporal = bloque.propiedadesCss.get(j);
                elementoTemporal.elementosEtiqueta.listadoElementos.add(propTemporal);
            }
            actualizarEtiquetaDOM(elementoTemporal);
        }

    }

    
    /*Obtener Valores por grupo*/
    public List<Etiqueta> obtenerEtiquetasGrupo(String id) {
        List<Etiqueta> lista = new ArrayList<>();

        Etiqueta temporal, ret;
        for (int i = 0; i < this.etiquetasHTML.size(); i++) {
            temporal = this.etiquetasHTML.get(i);
            if (!temporal.grupo.equalsIgnoreCase("nulo")) {
                if (temporal.grupo.equalsIgnoreCase(id)) {
                    lista.add(temporal);
                } else if (temporal instanceof Panel) {
                    Panel p = (Panel) temporal;
                    lista = obtenerEtiquetaPanelGrupo((ArrayList<Etiqueta>) p.objetosPanel.sentenciasCuerpo, id, (ArrayList<Etiqueta>) lista);///////////////////

                }
            } else {
                if (temporal instanceof Panel) {
                    Panel p = (Panel) temporal;
                    lista = obtenerEtiquetaPanelGrupo((ArrayList<Etiqueta>) p.objetosPanel.sentenciasCuerpo, id, (ArrayList<Etiqueta>) lista);//////////////////////////

                }
            }

        }

        return lista;
    }

    private List<Etiqueta> obtenerEtiquetaPanelGrupo(ArrayList<Etiqueta> etiquetas, String nombre, ArrayList<Etiqueta> lista) {

        Etiqueta temporal;
        for (int i = 0; i < etiquetas.size(); i++) {
            temporal = etiquetas.get(i);
            if (temporal.grupo.equalsIgnoreCase(nombre)) {
                lista.add(temporal);
            } else if (temporal instanceof Panel) {
                Panel p = (Panel) temporal;
                lista = (ArrayList<Etiqueta>) obtenerEtiquetaPanelGrupo((ArrayList<Etiqueta>) p.objetosPanel.sentenciasCuerpo, nombre, lista);///////////////
            }
        }
        return lista;
    }

    /*obtener valores por id*/
    public List<Etiqueta> obtenerEtiquetasID(String id) {
        List<Etiqueta> lista = new ArrayList<>();

        Etiqueta temporal, ret;
        for (int i = 0; i < this.etiquetasHTML.size(); i++) {
            temporal = this.etiquetasHTML.get(i);
            if (!temporal.id.equalsIgnoreCase("nulo")) {
                if (temporal.id.equalsIgnoreCase(id)) {
                    lista.add(temporal);
                } else if (temporal instanceof Panel) {
                    Panel p = (Panel) temporal;
                    lista = obtenerEtiquetaPanelID((ArrayList<Etiqueta>) p.objetosPanel.sentenciasCuerpo, id, (ArrayList<Etiqueta>) lista);///////////////////

                }
            } else {
                if (temporal instanceof Panel) {
                    Panel p = (Panel) temporal;
                    lista = obtenerEtiquetaPanelID((ArrayList<Etiqueta>) p.objetosPanel.sentenciasCuerpo, id, (ArrayList<Etiqueta>) lista);//////////////////////
                }
            }

        }

        return lista;
    }

    private List<Etiqueta> obtenerEtiquetaPanelID(ArrayList<Etiqueta> etiquetas, String nombre, ArrayList<Etiqueta> lista) {

        Etiqueta temporal;
        for (int i = 0; i < etiquetas.size(); i++) {
            temporal = etiquetas.get(i);
            if (temporal.id.equalsIgnoreCase(nombre)) {
                lista.add(temporal);
            } else if (temporal instanceof Panel) {
                Panel p = (Panel) temporal;
                lista = (ArrayList<Etiqueta>) obtenerEtiquetaPanelID((ArrayList<Etiqueta>) p.objetosPanel.sentenciasCuerpo, nombre, lista);//////////////////////
            }
        }
        return lista;
    }

}
