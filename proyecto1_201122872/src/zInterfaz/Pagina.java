/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package zInterfaz;

import CJS.ESTRUCURAS_CONTROL.Observador;
import CJS.TablaSimbolos.tablaSimbolos;
import CJS.objetoBase;
import Errores.tablaErrores;
import Funciones.ListaFunciones;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.text.BadLocationException;
import javax.swing.text.html.HTMLDocument;
import proyecto1_201122872.CHTML.BODY.Boton;
import proyecto1_201122872.CHTML.BODY.Caja;
import proyecto1_201122872.CHTML.BODY.Cuerpo;
import proyecto1_201122872.CHTML.BODY.Enlace;
import proyecto1_201122872.CHTML.BODY.Imagen;
import proyecto1_201122872.CHTML.BODY.Panel;
import proyecto1_201122872.CHTML.BODY.Salto;
import proyecto1_201122872.CHTML.BODY.Spinner;
import proyecto1_201122872.CHTML.BODY.Texto;
import proyecto1_201122872.CHTML.BODY.Texto_a;
import proyecto1_201122872.CHTML.BODY.caja_texto;
import proyecto1_201122872.CHTML.BODY.tabla;
import proyecto1_201122872.CHTML.Chtml;
import proyecto1_201122872.CHTML.Etiqueta;
import proyecto1_201122872.CHTML.HEADER.Encabezado;
import proyecto1_201122872.LectoArchivos;
import static proyecto1_201122872.Proyecto1_201122872.paginaActual;

/**
 *
 * @author Ramonella
 */
public class Pagina {
    
    public tablaSimbolos tabla;
    public tablaErrores erroresPagina;
    public EjecutarAnalizador analizadores;
    public String rutaPagina;
    public JTextPane areaWeb;
    public String nombrePagina;
    public int idPagina;
    public List<String> historialPagina;
    public List<String> rutasArchivosCSS;
    public List<String> rutasArchivosJS;
    private LectoArchivos lector;
    public String cadenaSalida;
    public String archivoActual="";
    public retornoCJS retCJS;
    public String tituloPagina;
    public DOM documento;
    
    public Pagina(int id){
        retCJS= new retornoCJS();
        this.lector= new LectoArchivos("");
        this.rutasArchivosCSS= new ArrayList<>();
        this.rutasArchivosJS= new ArrayList<>();
        this.areaWeb= new JTextPane();
        this.areaWeb.setContentType("text/html");
        this.areaWeb.setEditable(false);
        this.tabla= new tablaSimbolos();
        this.erroresPagina= new tablaErrores();
        this.analizadores = new EjecutarAnalizador();
        this.idPagina= id;
        this.nombrePagina= "";
        this.rutaPagina = "";
        this.cadenaSalida="";
        this.historialPagina= new ArrayList<>();
        this.rutasArchivosCSS= new ArrayList<>();
        this.rutasArchivosJS= new ArrayList<>();
        this.documento= new DOM();
        
    }

    
    
     public void reiniciar(){
        retCJS= new retornoCJS();
        this.areaWeb.setText("");
        this.areaWeb.setContentType("text/html");
        this.areaWeb.setEditable(false);
        this.tabla= new tablaSimbolos();
        this.erroresPagina= new tablaErrores();
        this.analizadores = new EjecutarAnalizador();
        this.cadenaSalida="";
        this.archivoActual="";
        this.tituloPagina="";
        this.rutasArchivosCSS= new ArrayList<>();
        this.rutasArchivosJS= new ArrayList<>();
        this.documento= new DOM();
        
    }
    
    public void setRutaPagina(String rutaPagina) {
        this.rutaPagina = rutaPagina;
    }

    public void setNombrePagina(String nombrePagina) {
        this.nombrePagina = nombrePagina;
    }
    
    public void agregarCadenaSalida(String cad){
        this.cadenaSalida+=cad;
    }
    
    
    public String dibujarPagina() throws Exception{
        reiniciar();
        paginaActual =this;
        Chtml raizHTML = this.analizadores.ejecutarHTML(rutaPagina);
        if(raizHTML!=null){
        Cuerpo cuerpoHTML= raizHTML.body;
        Encabezado encabezadoHTML = raizHTML.header;
        this.tituloPagina= encabezadoHTML.obtenerTitulos();
        this.rutasArchivosCSS= encabezadoHTML.obtenerCSS();
        this.rutasArchivosJS= encabezadoHTML.obtenerCJS();
        CrearElementosCJS();
        List<Etiqueta> componentesHTML = cuerpoHTML.obtenerEtiquetasConElementos();
        //aqui se le aplica el css
        this.documento.agregarListaEtiquetas((ArrayList<Etiqueta>)componentesHTML);
        this.retCJS.ejecutarLibres(tabla, 0);
        
        Dibujar(componentesHTML);
        
        
        this.historialPagina.add(rutaPagina);
        }
        
      return this.tituloPagina;  
    }
    
    
    
    
    
    
    
    
    
    
    private void CrearElementosCJS() throws Exception{
        String rutaArchivo;
        retornoCJS temporal;
        for (int i = 0; i < this.rutasArchivosJS.size(); i++) {
            rutaArchivo = this.rutasArchivosJS.get(i);
            temporal = this.analizadores.ejecutarCJS(rutaArchivo);
            agregarFunciones (temporal.lFunciones);
            agregarSentencias(temporal.sentenciasLibres);
            agregarObservadores(temporal.observadores);
        }  
    }
    
    private void agregarFunciones(ListaFunciones funciones){
        for (int i = 0; i < funciones.funciones.size(); i++) {
            this.retCJS.insertarFuncion(funciones.funciones.get(i));
        }
    }
    
    private void agregarSentencias( List<objetoBase> sentenciasLibres){
        for (int i = 0; i < sentenciasLibres.size(); i++) {
            this.retCJS.insertarSentencia(sentenciasLibres.get(i));
        }
    }
    
    private void agregarObservadores(List<Observador> observadores){
        for (int i = 0; i < observadores.size(); i++) {
            this.retCJS.insertarObservador(observadores.get(i));
        }
    }
    
       public void Dibujar(List<Etiqueta> lTemporal){
           
        Etiqueta temporal;
           for (int i = 0; i < lTemporal.size(); i++) {
            temporal = lTemporal.get(i);
            if(temporal instanceof Boton){
                JButton b= (JButton)((Boton) temporal).botonObjeto;
                 areaWeb.setCaretPosition(areaWeb.getStyledDocument().getLength());
                 areaWeb.insertComponent(b);
            }else if(temporal instanceof Caja){
                JComboBox b= (JComboBox)((Caja) temporal).cajaOpciones;
                 areaWeb.setCaretPosition(areaWeb.getStyledDocument().getLength());
                 areaWeb.insertComponent(b);
            }else if(temporal instanceof Enlace){
                JLabel b = (JLabel)((Enlace) temporal).link;
                 areaWeb.setCaretPosition(areaWeb.getStyledDocument().getLength());
                 areaWeb.insertComponent(b);
            }else if(temporal instanceof Imagen){
                 JLabel b = (JLabel)((Imagen) temporal).imagen;
                 areaWeb.setCaretPosition(areaWeb.getStyledDocument().getLength());
                 areaWeb.insertComponent(b);
            }else if(temporal instanceof Panel){
                 JTextPane b = (JTextPane)((Panel) temporal).Dibujar();
                 areaWeb.setCaretPosition(areaWeb.getStyledDocument().getLength());
                 areaWeb.insertComponent(b);
            }else if(temporal instanceof Salto){
                try {
                        areaWeb.setCaretPosition(areaWeb.getStyledDocument().getLength());
                        HTMLDocument doc=(HTMLDocument) areaWeb.getStyledDocument();
                        doc.insertAfterEnd(doc.getCharacterElement(doc.getLength()),"<br>");
                    } catch (BadLocationException ex) {
                        Logger.getLogger(Panel.class.getName()).log(Level.SEVERE, null, ex);
                    } catch (IOException ex) {
                        Logger.getLogger(Panel.class.getName()).log(Level.SEVERE, null, ex);
                    }
            }else if(temporal instanceof Spinner){
                JTextField b = (JTextField)((Spinner) temporal).spinner;
                areaWeb.setCaretPosition(areaWeb.getStyledDocument().getLength());
                 areaWeb.insertComponent(b);
            }else if(temporal instanceof Texto){
                 JTextPane b = (JTextPane)((Texto) temporal).texto;
                 areaWeb.setCaretPosition(areaWeb.getStyledDocument().getLength());
                 areaWeb.insertComponent(b);
            }else if(temporal instanceof Texto_a){
                JTextPane b = (JTextPane)((Texto_a) temporal).cajaTexto;
                 areaWeb.setCaretPosition(areaWeb.getStyledDocument().getLength());
                 areaWeb.insertComponent(b);
            }else if(temporal instanceof caja_texto){
                JTextField b = (JTextField)((caja_texto) temporal).cajaTexto;
                areaWeb.setCaretPosition(areaWeb.getStyledDocument().getLength());
                 areaWeb.insertComponent(b);
            }else if(temporal instanceof tabla){
                
            }    
        }
             
    }
    
    
    
    
    public void cargarCSS(){
        
    }
    

    
    
    
    
    
    
    
    /*Mostrar Opciones*/
    
    public String obtenerCadenaSalida(){
        return this.cadenaSalida;
    }
    
    public String[] obtenerCodigoHTML(){
        String [] retorno = new String[2];
        retorno[0]=this.nombrePagina;
        retorno[1] = this.lector.obtenerContenidoArchivo(this.rutaPagina); 
        return retorno;
    }
    
    public List<String[]> obtenerCodigoJS(){
        List<String[]>retorno = new ArrayList<>();
        File temporal;
        String [] val= new String[2];
        for (int i = 0; i < this.rutasArchivosJS.size(); i++) {
          temporal= new File(rutasArchivosJS.get(i));
          val[0]=temporal.getName();
          val[1]=lector.obtenerContenidoArchivo(rutasArchivosJS.get(i));
          retorno.add(val);
        }
        return retorno;
    }
    
    
    public List<String[]> obtenerCodigoCSS(){
      List<String[]>retorno = new ArrayList<>();
        File temporal;
        String [] val= new String[2];
        for (int i = 0; i < this.rutasArchivosCSS.size(); i++) {
          temporal= new File(rutasArchivosCSS.get(i));
          val[0]=temporal.getName();
          val[1]=lector.obtenerContenidoArchivo(rutasArchivosCSS.get(i));
          retorno.add(val);
        }
        return retorno;
    }
    
    
    public String obtenerErrores(){
        return this.erroresPagina.getErroresHTML();
    }
    
    
    
    
    
    
    
    
    
    
    
 
    
    
    
    
}
