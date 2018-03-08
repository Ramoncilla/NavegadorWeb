/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto1_201122872.CHTML;

import java.util.ArrayList;
import java.util.List;
import proyecto1_201122872.CHTML.ElemetoPropiedad.propiedad;
import proyecto1_201122872.CHTML.ElemetoPropiedad.propiedadAlineado;
import proyecto1_201122872.CHTML.ElemetoPropiedad.propiedadAlto;
import proyecto1_201122872.CHTML.ElemetoPropiedad.propiedadAncho;
import proyecto1_201122872.CHTML.ElemetoPropiedad.propiedadGrupo;
import proyecto1_201122872.CHTML.ElemetoPropiedad.propiedadId;
import proyecto1_201122872.CHTML.ElemetoPropiedad.propiedadRuta;
import proyecto1_201122872.CHTML.ElemetoPropiedad.propiedadValor;

/**
 *
 * @author Ramonella
 */
public class listaElementos {

    public List<propiedad> listadoElementos;

    public listaElementos(ArrayList<propiedad> listado) {

        listadoElementos = listado;
    }
    
    public listaElementos(){
        this.listadoElementos= new ArrayList<>();
    }

    public propiedadRuta obtenerRuta() {

        propiedad temporal;
        for (int i = 0; i < this.listadoElementos.size(); i++) {
            temporal = listadoElementos.get(i);
            if (temporal instanceof propiedadRuta) {
                return (propiedadRuta) temporal;
            }
        }
        return null;
    }

    public propiedadAlineado obtenerAlineado() {

        propiedad temporal;
        for (int i = 0; i < this.listadoElementos.size(); i++) {
            temporal = listadoElementos.get(i);
            if (temporal instanceof propiedadAlineado) {
                return (propiedadAlineado) temporal;
            }
        }
        return null;
    }

    public propiedadAlto obtenerAlto() {

        propiedad temporal;
        for (int i = 0; i < this.listadoElementos.size(); i++) {
            temporal = listadoElementos.get(i);
            if (temporal instanceof propiedadAlto) {
                return (propiedadAlto) temporal;
            }
        }
        return null;
    }

    public propiedadAncho obtenerAncho() {

        propiedad temporal;
        for (int i = 0; i < this.listadoElementos.size(); i++) {
            temporal = listadoElementos.get(i);
            if (temporal instanceof propiedadAncho) {
                return (propiedadAncho) temporal;
            }
        }
        return null;
    }

    public void asignarID(Object id) {

        propiedad temporal;
        for (int i = 0; i < this.listadoElementos.size(); i++) {
            temporal = listadoElementos.get(i);
            if (temporal instanceof propiedadId) {
                propiedadId v = (propiedadId) temporal;
                if (!id.toString().equalsIgnoreCase("")) {
                    v.idElemento = id.toString();
                    this.listadoElementos.set(i, v);
                    break;

                }
            }
        }
    }

    public void asignarGrupo(Object grupo) {

        propiedad temporal;
        for (int i = 0; i < this.listadoElementos.size(); i++) {
            temporal = listadoElementos.get(i);
            if (temporal instanceof propiedadGrupo) {
                propiedadGrupo v = (propiedadGrupo) temporal;
                if (!grupo.toString().equalsIgnoreCase("")) {
                    v.grupo = grupo.toString();
                    this.listadoElementos.set(i, v);
                    break;

                }
            }
        }

    }

    public void asignarAlto(Object op) {
        Object valor = op.toString().replace("\"", "");

        propiedad temporal;
        for (int i = 0; i < this.listadoElementos.size(); i++) {
            temporal = listadoElementos.get(i);
            if (temporal instanceof propiedadAlto) {
                propiedadAlto v = (propiedadAlto) temporal;
                try {
                    v.alturaComponente = Integer.parseInt(valor.toString());
                    this.listadoElementos.set(i, v);
                } catch (Exception e) {

                }

            }
        }

    }

    public void asignarAncho(Object op) {
        Object valor = op.toString().replace("\"", "");

        propiedad temporal;
        for (int i = 0; i < this.listadoElementos.size(); i++) {
            temporal = listadoElementos.get(i);
            if (temporal instanceof propiedadAncho) {
                propiedadAncho v = (propiedadAncho) temporal;
                try {
                    v.valorAncho = Integer.parseInt(valor.toString());
                    this.listadoElementos.set(i, v);
                } catch (Exception e) {

                }

            }
        }

    }

    public void asignarAlineado(Object alineacion) {

        propiedad temporal;
        for (int i = 0; i < this.listadoElementos.size(); i++) {
            temporal = listadoElementos.get(i);
            if (temporal instanceof propiedadAlineado) {
                propiedadAlineado v = (propiedadAlineado) temporal;
                if (alineacion instanceof String) {
                    switch (alineacion.toString().toUpperCase()) {
                        case "DERECHA":
                            v.alineado = alineacion.toString();
                            this.listadoElementos.set(i, v);
                            break;
                        case "IZQUIERDA":
                            v.alineado = alineacion.toString();
                            this.listadoElementos.set(i, v);
                            break;
                        case "CENTRADO":
                            v.alineado = alineacion.toString();
                            this.listadoElementos.set(i, v);
                            break;
                        default:
                            v.alineado = "izquierda";
                            this.listadoElementos.set(i, v);
                            break;
                    }

                }
            }
        }

    }
    
    
    public propiedadValor obtenerValor(){
        for (int i = 0; i < this.listadoElementos.size(); i++) {
            if(this.listadoElementos.get(i) instanceof propiedadValor){
                return (propiedadValor) this.listadoElementos.get(i);
            }
        }
        return null;
    }

}
