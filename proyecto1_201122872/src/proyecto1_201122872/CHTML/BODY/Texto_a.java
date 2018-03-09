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
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyledDocument;
import proyecto1_201122872.CHTML.ElemetoPropiedad.propiedad;
import proyecto1_201122872.CHTML.ElemetoPropiedad.propiedadAlineado;
import proyecto1_201122872.CHTML.ElemetoPropiedad.propiedadAlto;
import proyecto1_201122872.CHTML.ElemetoPropiedad.propiedadAncho;
import proyecto1_201122872.CHTML.ElemetoPropiedad.propiedadGrupo;
import proyecto1_201122872.CHTML.ElemetoPropiedad.propiedadId;
import proyecto1_201122872.CHTML.Etiqueta;
import proyecto1_201122872.CHTML.listaElementos;
import static proyecto1_201122872.Proyecto1_201122872.paginaActual;
/**
 *
 * @author Ramonella
 */
public class Texto_a extends Etiqueta{
    

        public String cadenaTexto;
        public jTextPane cajaTexto;
       
        
        
    public Texto_a(Object elementos , Object cadena){
        this.alto=300;
        this.ancho=300;
        this.elementosEtiqueta = new listaElementos((ArrayList<propiedad>)elementos);
        this.cadenaTexto= cadena.toString();  
        cajaTexto= new jTextPane();
    }

    @Override
    public Etiqueta retornarHtml() { 
        agregarElementos();
        asignarElementos();
        cajaTexto.setBackground(Color.orange);
           /*p = new JScrollPane(cajaTexto);
           p.setSize(cajaTexto.getPreferredSize());
           p.setVisible(true);*/
           
        return this;
    }
    
    

    
    
    @Override
    public void asignarElementos() {
        this.cajaTexto.setContentType("text/html");
        this.cajaTexto.setEditable(true);
        this.cajaTexto.setAutoscrolls(true);
        if(this.elementosEtiqueta.obtenerAlineado()!=null){
             propiedadAlineado n = elementosEtiqueta.obtenerAlineado();
            if(n.alineado.equalsIgnoreCase("derecha")){
                this.cajaTexto.setText(this.cadenaTexto);
                StyledDocument doc = cajaTexto.getStyledDocument();
                SimpleAttributeSet center = new SimpleAttributeSet();
                StyleConstants.setAlignment(center, StyleConstants.ALIGN_RIGHT);
                doc.setParagraphAttributes(0, doc.getLength(), center, false);     
            }else if(n.alineado.equalsIgnoreCase("izquierda")){
                this.cajaTexto.setText(this.cadenaTexto);
                StyledDocument doc = cajaTexto.getStyledDocument();
                SimpleAttributeSet center = new SimpleAttributeSet();
                StyleConstants.setAlignment(center, StyleConstants.ALIGN_LEFT);
                doc.setParagraphAttributes(0, doc.getLength(), center, false);    
            }else if(n.alineado.equalsIgnoreCase("centrado")){
                this.cajaTexto.setText(this.cadenaTexto);
                StyledDocument doc = cajaTexto.getStyledDocument();
                SimpleAttributeSet center = new SimpleAttributeSet();
                StyleConstants.setAlignment(center, StyleConstants.ALIGN_CENTER);
                doc.setParagraphAttributes(0, doc.getLength(), center, false); 
            }
        } else{
            this.cajaTexto.setText(this.cadenaTexto);
        }
         cajaTexto.setSize(ancho, alto);
    }

    @Override
    public void agregarElementos() {
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
        propiedad propTemporal;
        for (int i = 0; i < this.elementosEtiqueta.listadoElementos.size(); i++) {
            propTemporal = this.elementosEtiqueta.listadoElementos.get(i);

            if (propTemporal instanceof Alineado) {
                Alineado a = (Alineado) propTemporal;
                switch (a.alineacion.toUpperCase()) {
                    case "DERECHA": {
                        StyledDocument doc = cajaTexto.getStyledDocument();
                        SimpleAttributeSet center = new SimpleAttributeSet();
                        StyleConstants.setAlignment(center, StyleConstants.ALIGN_RIGHT);
                        doc.setParagraphAttributes(0, doc.getLength(), center, false);
                        break;
                    }
                    case "CENTRADO": {
                        StyledDocument doc = cajaTexto.getStyledDocument();
                        SimpleAttributeSet center = new SimpleAttributeSet();
                        StyleConstants.setAlignment(center, StyleConstants.ALIGN_CENTER);
                        doc.setParagraphAttributes(0, doc.getLength(), center, false);
                        break;
                    }

                    case "JUSTIFICADO": {
                        StyledDocument doc = cajaTexto.getStyledDocument();
                        SimpleAttributeSet center = new SimpleAttributeSet();
                        StyleConstants.setAlignment(center, StyleConstants.ALIGN_JUSTIFIED);
                        doc.setParagraphAttributes(0, doc.getLength(), center, false);
                        break;
                    }
                    default: {
                        StyledDocument doc = cajaTexto.getStyledDocument();
                        SimpleAttributeSet center = new SimpleAttributeSet();
                        StyleConstants.setAlignment(center, StyleConstants.ALIGN_LEFT);
                        doc.setParagraphAttributes(0, doc.getLength(), center, false);
                        break;
                    }
                }
            }
            if(propTemporal instanceof bCSS.Texto){
                bCSS.Texto t = (bCSS.Texto)propTemporal;
                this.cadenaTexto=t.getTexto();
                this.cajaTexto.setText(this.cadenaTexto);                
            }
            
            if(propTemporal instanceof Fondoelemento){
                Fondoelemento f = (Fondoelemento)propTemporal;
                Color c = getColor(f.getCadenaColor());
                this.cajaTexto.setBackground(c);
            }
            
            if(propTemporal instanceof Visible){
                Visible v = (Visible)propTemporal;
                switch(v.getVisible().toUpperCase()){
                    case "VERDADERO":{
                        this.cajaTexto.setVisible(true);
                        break;                       
                    }
                    case "FALSO":{
                        this.cajaTexto.setVisible(false);
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
            }
            
            if(propTemporal instanceof Opaque){
               Opaque v = (Opaque)propTemporal;
                switch(v.getValorOpaque().toUpperCase()){
                    case "VERDADERO":{
                        this.cajaTexto.setOpaque(true);
                        break;                       
                    }
                    case "FALSO":{
                        this.cajaTexto.setOpaque(false);
                        break;
                    }
                } 
                
            }
            
            if(propTemporal instanceof Colortext){
                Colortext c = (Colortext)propTemporal;
                Color j = getColor(c.getCadenaColor());
                this.cajaTexto.setForeground(j);
                
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
             String l = this.cajaTexto.getText();
             this.cajaTexto.setText(l.toUpperCase());
         }
         
          if(noTipoLetra==2){
             String l = this.cajaTexto.getText();
             this.cajaTexto.setText(l.toLowerCase());
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
        }
         
         Font fNueva = new Font(fuente,letra,tamLetra);
         this.cajaTexto.setFont(fNueva);
         this.cajaTexto.setSize(ancho, alto);
      
        
    }
    
    
    
    
    
}
