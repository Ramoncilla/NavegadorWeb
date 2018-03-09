/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto1_201122872.CHTML.BODY;

import CJS.elementoRetorno;
import Funciones.Funcion;
import bCSS.Alineado;
import bCSS.Autoredimension;
import bCSS.Borde;
import bCSS.Colortext;
import bCSS.Fondoelemento;
import bCSS.Formato;
import bCSS.Letra;
import bCSS.Opaque;
import bCSS.Tamtex;
import bCSS.Visible;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import bCSS.Texto;
import java.awt.Color;

import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;
import proyecto1_201122872.CHTML.ElemetoPropiedad.propiedad;
import proyecto1_201122872.CHTML.Etiqueta;
import proyecto1_201122872.CHTML.listaElementos;
import proyecto1_201122872.CHTML.ElemetoPropiedad.*;
import static proyecto1_201122872.Proyecto1_201122872.g;
import static proyecto1_201122872.Proyecto1_201122872.paginaActual;

/**
 *
 * @author Ramonella
 */
public class Boton extends Etiqueta implements ActionListener {
    
   // public listaElementos elementosBoton;
    public String captionBoton;
    public List<String> funcionesClic;
    public botonComponente botonObjeto;
    public String rutaBoton;
    
    public Boton(Object elementos, Object cadena){
        this.alto = 50;
        this.ancho=150;
        this.elementosEtiqueta = new listaElementos((ArrayList<propiedad>)elementos);
        this.captionBoton = cadena.toString();
        botonObjeto= new botonComponente();
        botonObjeto.addActionListener(this);
        this.funcionesClic=new ArrayList<>();
        this.rutaBoton="";
    }
     
    @Override
    public Etiqueta retornarHtml(){ 
        agregarElementos();
        asignarElementos();
        return this;
    }
    
    
    @Override
    public void actionPerformed(ActionEvent ae) {
        System.out.println("Di clic en el boton "+ this.captionBoton);
        String temporal;
        Funcion funBuscada;
        for (int i = 0; i < this.funcionesClic.size(); i++) {
            temporal = funcionesClic.get(i).replace("\"", "").replace("(", "").replace(")", "");
            funBuscada= paginaActual.retCJS.lFunciones.obtenerFuncion(temporal, 0);
            int contexto=0;
            if(funBuscada!=null)
            {
                contexto++;
                elementoRetorno ret = funBuscada.Ejecutar(paginaActual.tabla, contexto);
                paginaActual.tabla.eliminarSimbolosLocales(contexto);
                contexto--; 
                
            }else{
               paginaActual.erroresPagina.insertarError("Semantico", "No se puede ejecutar la funcion "+ temporal+", en el boton "+this.captionBoton+", debido a que no existe.");
            }
        }
        
        
        if(this.elementosEtiqueta.obtenerRuta()!=null){
            propiedadRuta u = this.elementosEtiqueta.obtenerRuta();
            File f = new File(u.ruta);
        if (f.exists() && !f.isDirectory()) {
           g.nuevaPagina();
         try {
             g.CargarPagina(u.ruta);
         } catch (Exception ex) {
             Logger.getLogger(Enlace.class.getName()).log(Level.SEVERE, null, ex);
         }
        }else{
            JOptionPane.showMessageDialog(null, "No se puede abrir la pagina, ruta no valida "+u.ruta, "USAC-WEB", JOptionPane.ERROR_MESSAGE);
        }
            
        }
        paginaActual.retCJS.observadores.buscarObservadorPorElemento(30, numeroIdentificador, 0, paginaActual.tabla);
        
        
    }

   
    @Override
    public void agregarEstilo(){
        propiedad propTemporal;
        for (int i = 0; i < this.elementosEtiqueta.listadoElementos.size(); i++) {
            propTemporal = this.elementosEtiqueta.listadoElementos.get(i);
            
            if(propTemporal instanceof Alineado){
                Alineado a = (Alineado)propTemporal;
                switch(a.alineacion.toUpperCase()){
                    case "DERECHA":{
                        this.botonObjeto.setHorizontalAlignment(SwingConstants.RIGHT);
                        break;
                    }
                    case "CENTRADO":{
                        this.botonObjeto.setHorizontalAlignment(SwingConstants.CENTER);
                        break;
                    }
                    default:{
                        this.botonObjeto.setHorizontalAlignment(SwingConstants.LEFT);
                        break;
                    }
                }
            }
            if(propTemporal instanceof Texto){
                Texto t = (Texto)propTemporal;
                this.botonObjeto.setText(t.getTexto());
                
            }
            
            if(propTemporal instanceof Fondoelemento){
                Fondoelemento f = (Fondoelemento)propTemporal;
                Color c = getColor(f.getCadenaColor());
                this.botonObjeto.setBackground(c);
            }
            
            if(propTemporal instanceof Visible){
                Visible v = (Visible)propTemporal;
                switch(v.getVisible().toUpperCase()){
                    case "VERDADERO":{
                        this.botonObjeto.setVisible(true);
                        break;                       
                    }
                    case "FALSO":{
                        this.botonObjeto.setVisible(false);
                        break;
                    }
                }
                
            }
            if(propTemporal instanceof Borde){
                Borde b = (Borde)propTemporal;
                Color c = getColor(b.getVcolor());
                double tam = b.getVsize();
                boolean curva= b.getVcurva().equalsIgnoreCase("verdadero");
                int j = (int)tam;
                LineBorder l = new LineBorder(c,j,curva);
                this.botonObjeto.setBorder(l);
            }
            
            if(propTemporal instanceof Opaque){
               Opaque v = (Opaque)propTemporal;
                switch(v.getValorOpaque().toUpperCase()){
                    case "VERDADERO":{
                        this.botonObjeto.setOpaque(true);
                        break;                       
                    }
                    case "FALSO":{
                        this.botonObjeto.setOpaque(false);
                        break;
                    }
                } 
                
            }
            
            if(propTemporal instanceof Colortext){
                Colortext c = (Colortext)propTemporal;
                Color j = getColor(c.getCadenaColor());
                this.botonObjeto.setForeground(j);
                
            }
            
            if(propTemporal instanceof Autoredimension){
                
            }
               
        }
        
        
        Formato form = this.elementosEtiqueta.obtenerFormato();
        Tamtex siz= this.elementosEtiqueta.obtenerTamtex();
        Letra let= this.elementosEtiqueta.obtenerLetra();
        String fuente="";
        int letra = Font.PLAIN;
        int noTipoLetra =0;
        int tamLetra =12;
        if(form!=null){
            String g;
            for (int i = 0; i < form.listaFormatos.size(); i++) {
                g=form.listaFormatos.get(i);
                if(g.equalsIgnoreCase("negrita"))
                    letra+=Font.BOLD;
                if(g.equalsIgnoreCase("cursiva"))
                    letra+=Font.ITALIC;
                if(g.equalsIgnoreCase("mayuscula"))
                    noTipoLetra=1;
                if(g.equalsIgnoreCase("minuscula"))
                    noTipoLetra=2;
                if(g.equalsIgnoreCase("capital-t"))
                    noTipoLetra=3;
                
            }
        }
         if(siz!=null)
             tamLetra=(int)siz.getValorTamanho();
         
         if(let!=null)
             fuente=let.getFuente();
         
         if(noTipoLetra==1){
             String l = this.botonObjeto.getText();
             this.botonObjeto.setText(l.toUpperCase());
         }
         
          if(noTipoLetra==2){
             String l = this.botonObjeto.getText();
             this.botonObjeto.setText(l.toLowerCase());
         }
          
        if (noTipoLetra == 3) {
            String l = this.botonObjeto.getText();
            String a = l.toLowerCase();
            char[] caracteres = a.toCharArray();
            caracteres[0] = Character.toUpperCase(caracteres[0]);
            for (int i = 0; i < a.length() - 2; i++) {
                if (caracteres[i] == ' ' || Character.isSpaceChar(caracteres[i])) {
                    caracteres[i + 1] = Character.toUpperCase(caracteres[i + 1]);
                }
            }
            String h = new String(caracteres);
            this.botonObjeto.setText(h);
        }
         
         Font fNueva = new Font(fuente,letra,tamLetra);
         this.botonObjeto.setFont(fNueva);
         this.botonObjeto.setSize(ancho, alto);
      
        
    }
    
    
    
    
    @Override
    public void asignarElementos(){
        this.botonObjeto.setText(this.captionBoton);
        botonObjeto.setSize(ancho, alto);
        if(elementosEtiqueta.obtenerAlineado()!=null){
            propiedadAlineado n = elementosEtiqueta.obtenerAlineado();
            if(n.alineado.equalsIgnoreCase("derecha")){
                botonObjeto.setHorizontalAlignment(SwingConstants.RIGHT);
            }else if(n.alineado.equalsIgnoreCase("izquierda")){
                botonObjeto.setHorizontalAlignment(SwingConstants.LEFT);     
            }else if(n.alineado.equalsIgnoreCase("centrado")){
                botonObjeto.setHorizontalAlignment(SwingConstants.CENTER);
            }
        }
    }
    
    
    @Override
    public void agregarElementos(){
        propiedad temporal;
        for (int i = 0; i < this.elementosEtiqueta.listadoElementos.size(); i++) {
            temporal = this.elementosEtiqueta.listadoElementos.get(i);
            if(temporal instanceof  propiedadAlineado){
                propiedadAlineado p = (propiedadAlineado)temporal;
                if(!asignarAlineado(p.alineado)){
                    paginaActual.erroresPagina.insertarError("Semantico", "Elemento no valido para la alineacion del boton");
                }
            }else if(temporal instanceof propiedadId){
                 propiedadId p = (propiedadId)temporal;
                if(!asignarID(p.idElemento)){
                    paginaActual.erroresPagina.insertarError("Semantico", "Elemento no valido para la alineacion el ID de un boton");
                }
                
            }else if(temporal instanceof propiedadGrupo){
                propiedadGrupo p = (propiedadGrupo)temporal;
                if(!asignarGrupo(p.grupo)){
                    paginaActual.erroresPagina.insertarError("Semantico", "Elemento no valido para la alineacion el ID de un boton");
                }
                
            }else if(temporal instanceof propiedadAlto){
                propiedadAlto p = (propiedadAlto)temporal;
                if(!asignarAlto(p.alturaComponente)){
                  
                    paginaActual.erroresPagina.insertarError("Semantico", "Elemento no valido para la alineacion el ID de un boton");
                }
                
            }else if(temporal instanceof propiedadAncho){
                propiedadAncho p = (propiedadAncho)temporal;
                if(!asignarAncho(p.valorAncho)){
                    paginaActual.erroresPagina.insertarError("Semantico", "Elemento no valido para la alineacion el ID de un boton");
                }
                
            }else if(temporal instanceof propiedadClick){
                propiedadClick p = (propiedadClick)temporal;
                String nombre=p.nombreFuncion.replace("(", "").replace(")", "").replace("\"", "");
                if(!existeFunClick(nombre))
                this.funcionesClic.add(nombre);
                
            }else if(temporal instanceof propiedadRuta){
                propiedadRuta p = (propiedadRuta)temporal;
                this.rutaBoton= p.ruta.replace("\"", "");
                
            }
        }
    }
    
    private boolean existeFunClick(String nombreFun){
        for (int i = 0; i < this.funcionesClic.size(); i++) {
            if(this.funcionesClic.get(i).equalsIgnoreCase(nombreFun)){
                return true;
            }
        }
        return false;
    }
    
    public void insertarClick(String nombre){
        
        if(!existeFunClick(nombre)){
            this.funcionesClic.add(nombre);
        }
    }
    
}
