/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto1_201122872.CHTML.BODY;
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
import java.awt.Color;
import java.awt.Font;
import java.util.ArrayList;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyledDocument;
import proyecto1_201122872.CHTML.ElemetoPropiedad.propiedad;
import proyecto1_201122872.CHTML.ElemetoPropiedad.propiedadAlineado;
import proyecto1_201122872.CHTML.ElemetoPropiedad.propiedadAlto;
import proyecto1_201122872.CHTML.ElemetoPropiedad.propiedadAncho;
import proyecto1_201122872.CHTML.ElemetoPropiedad.propiedadClick;
import proyecto1_201122872.CHTML.ElemetoPropiedad.propiedadGrupo;
import proyecto1_201122872.CHTML.ElemetoPropiedad.propiedadId;
import proyecto1_201122872.CHTML.Etiqueta;
import proyecto1_201122872.CHTML.listaElementos;
import static proyecto1_201122872.Proyecto1_201122872.paginaActual;
/**
 *
 * @author Ramonella
 */
public class caja_texto extends Etiqueta {
    

     public String cadenaCaja_texto;
     public textFieldComponente cajaTexto;
    
    public caja_texto(Object elementos , Object cadena){
        this.elementosEtiqueta = new listaElementos((ArrayList<propiedad>)elementos);
        this.cadenaCaja_texto= cadena.toString();  
        this.cajaTexto= new textFieldComponente();
        this.alto=50;
        this.ancho=150;
    }

    @Override
    public Etiqueta retornarHtml() {
       agregarElementos();
       asignarElementos();
        this.cajaTexto.setText(cadenaCaja_texto.replace("\n", " "));
        
        return this;
    }
    
    
  
    
    
      @Override
    public void asignarElementos(){
   
        cajaTexto.setSize(ancho, alto);
        if(elementosEtiqueta.obtenerAlineado()!=null){
            propiedadAlineado n = elementosEtiqueta.obtenerAlineado();
            if(n.alineado.equalsIgnoreCase("derecha")){
                cajaTexto.setHorizontalAlignment(SwingConstants.RIGHT);
            }else if(n.alineado.equalsIgnoreCase("izquierda")){
                cajaTexto.setHorizontalAlignment(SwingConstants.LEFT);   
            }else if(n.alineado.equalsIgnoreCase("centrado")){
              cajaTexto.setHorizontalAlignment(SwingConstants.CENTER);
            }
        }else{
            cajaTexto.setHorizontalAlignment(SwingConstants.LEFT);
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
                
            }
        }
    }
    
     @Override
    public void agregarEstilo() {
        boolean bandera = false;
        propiedad propTemporal;
        for (int i = 0; i < this.elementosEtiqueta.listadoElementos.size(); i++) {
            propTemporal = this.elementosEtiqueta.listadoElementos.get(i);

            if (propTemporal instanceof Alineado) {
                Alineado n = (Alineado) propTemporal;

                if (n.alineacion.equalsIgnoreCase("derecha")) {
                    cajaTexto.setHorizontalAlignment(SwingConstants.RIGHT);
                    bandera =true;
                } else if (n.alineacion.equalsIgnoreCase("izquierda")) {
                    cajaTexto.setHorizontalAlignment(SwingConstants.LEFT);
                    bandera =true;
                } else if (n.alineacion.equalsIgnoreCase("centrado")) {
                    cajaTexto.setHorizontalAlignment(SwingConstants.CENTER);
                    bandera =true;
                }
            }
            
            if(propTemporal instanceof bCSS.Texto){
                bCSS.Texto t = (bCSS.Texto)propTemporal;
                this.cadenaCaja_texto=t.getTexto();
                this.cajaTexto.setText(this.cadenaCaja_texto); 
                bandera =true;
            }
            
            if(propTemporal instanceof Fondoelemento){
                Fondoelemento f = (Fondoelemento)propTemporal;
                Color c = getColor(f.getCadenaColor());
                this.cajaTexto.setBackground(c);
                bandera =true;
            }
            
            if(propTemporal instanceof Visible){
                Visible v = (Visible)propTemporal;
                switch(v.getVisible().toUpperCase()){
                    case "VERDADERO":{
                        this.cajaTexto.setVisible(true);
                        bandera =true;
                        break;                       
                    }
                    case "FALSO":{
                        this.cajaTexto.setVisible(false);
                        bandera =true;
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
                this.cajaTexto.setBorder(l);
                bandera =true;
            }
            
            if(propTemporal instanceof Opaque){
               Opaque v = (Opaque)propTemporal;
                switch(v.getValorOpaque().toUpperCase()){
                    case "VERDADERO":{
                        this.cajaTexto.setOpaque(true);
                        bandera =true;
                        break;                       
                    }
                    case "FALSO":{
                        this.cajaTexto.setOpaque(false);
                        bandera =true;
                        break;
                    }
                } 
                
            }
            
            if(propTemporal instanceof Colortext){
                Colortext c = (Colortext)propTemporal;
                Color j = getColor(c.getCadenaColor());
                this.cajaTexto.setForeground(j);
                bandera =true;
                
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
         if(siz!=null){
             tamLetra=(int)siz.getValorTamanho();bandera =true;}
         
         if(let!=null){
             fuente=let.getFuente();bandera =true;}
         
         if(noTipoLetra==1){
             String l = this.cajaTexto.getText();
             this.cajaTexto.setText(l.toUpperCase());
             bandera =true;
         }
         
          if(noTipoLetra==2){
             String l = this.cajaTexto.getText();
             this.cajaTexto.setText(l.toLowerCase());
             bandera =true;
         }
          
        if (noTipoLetra == 3) {
            String l = this.cajaTexto.getText();
            String a = l.toLowerCase();
            char[] caracteres = a.toCharArray();
            caracteres[0] = Character.toUpperCase(caracteres[0]);
            for (int i = 0; i < a.length() - 2; i++) {
                if (caracteres[i] == ' ' || Character.isSpaceChar(caracteres[i])) {
                    caracteres[i + 1] = Character.toUpperCase(caracteres[i + 1]);
                }
            }
            String h = new String(caracteres);
            this.cajaTexto.setText(h);
            bandera =true;
        }
         
         Font fNueva = new Font(fuente,letra,tamLetra);
         this.cajaTexto.setFont(fNueva);
         this.cajaTexto.setSize(ancho, alto);
      
        if(bandera){
            paginaActual.retCJS.observadores.buscarObservadorPorElemento(20, numeroIdentificador, 0, paginaActual.tabla);
        }
    }
    
}
