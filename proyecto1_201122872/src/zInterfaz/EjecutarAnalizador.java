/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package zInterfaz;

import CJS.ESTRUCURAS_CONTROL.Observador;
import CJS.TablaSimbolos.tablaSimbolos;
import CJS.objetoBase;
import Funciones.Funcion;
import java.io.BufferedReader;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.text.html.HTMLDocument;
import proyecto1_201122872.AnalizadorCHTML.Parser;
import proyecto1_201122872.AnalizadorCHTML.scannerCHTML;
import proyecto1_201122872.AnalizadorCJS.scannerCJS;
import proyecto1_201122872.CHTML.BODY.Cuerpo;
import proyecto1_201122872.CHTML.BODY.Salto;
import proyecto1_201122872.CHTML.Chtml;
import proyecto1_201122872.CHTML.ElemetoPropiedad.propiedad;
import proyecto1_201122872.CHTML.Etiqueta;
import proyecto1_201122872.CHTML.HEADER.Encabezado;
import proyecto1_201122872.CHTML.listaElementos;
import proyecto1_201122872.LectoArchivos;


/**
 *
 * @author Ramonella
 */
public class EjecutarAnalizador {
    
    
    
    public Chtml ejecutarHTML(String ruta) throws Exception{
 
      
        Chtml  retorno=null;
        
        if(ruta.isEmpty()){
            JOptionPane.showMessageDialog(null, "Error, ruta no valida para ejecutar CHTML.", "USAC-WEB", JOptionPane.INFORMATION_MESSAGE);
        }else{
          LectoArchivos lector = new LectoArchivos(ruta);
        String cadena=lector.obtenerContenidoArchivo();
        if(cadena.isEmpty()){
           JOptionPane.showMessageDialog(null, "Error, no es posible analizar una cadena vacia para CHTML.", "USAC-WEB", JOptionPane.INFORMATION_MESSAGE);
        }else{
            System.out.println("Inicio de Analisis CHTML");
            scannerCHTML scannerHtml = new scannerCHTML(new BufferedReader(new StringReader(cadena)));
            Parser parserHtml = new Parser(scannerHtml);
            parserHtml.parse();
            
           retorno= parserHtml.codigoHTML;
                System.out.println("Fin de analisis CHTML");  
           return retorno;
            /*
            jTextPane1.setContentType("text/html");
            List<Object> v = (ArrayList<Object>)etiquet.body.ejecutarCuerpo();
            for (int i = 0; i < v.size(); i++) {
                if(v.get(i) instanceof JButton){
                    JButton j = (JButton) v.get(i);    
                   jTextPane1.setCaretPosition(jTextPane1.getStyledDocument().getLength());
                    jTextPane1.insertComponent(j);
                }else if(v.get(i) instanceof JTextField){
                    JTextField j = (JTextField)v.get(i);
                    jTextPane1.setCaretPosition(jTextPane1.getStyledDocument().getLength());
                    jTextPane1.insertComponent(j);
                }else if(v.get(i) instanceof JTextArea){
                    JTextArea j = (JTextArea)v.get(i);
                    jTextPane1.setCaretPosition(jTextPane1.getStyledDocument().getLength());
                    jTextPane1.insertComponent(j);
                }else if(v.get(i) instanceof Salto){
                    jTextPane1.setCaretPosition(jTextPane1.getStyledDocument().getLength());
                    HTMLDocument doc=(HTMLDocument) jTextPane1.getStyledDocument();
                    doc.insertAfterEnd(doc.getCharacterElement(doc.getLength()),"<br>");
                }else if(v.get(i) instanceof JLabel){
                    JLabel j = (JLabel)v.get(i);
                    jTextPane1.setCaretPosition(jTextPane1.getStyledDocument().getLength());
                    jTextPane1.insertComponent(j);
                  
                }else if(v.get(i) instanceof JComboBox){
                    JComboBox j = (JComboBox)v.get(i);
                    jTextPane1.setCaretPosition(jTextPane1.getStyledDocument().getLength());
                    jTextPane1.insertComponent(j);
                }else if(v.get(i) instanceof JTextPane){
                    JTextPane j = (JTextPane)v.get(i);
                    jTextPane1.setCaretPosition(jTextPane1.getStyledDocument().getLength());
                    jTextPane1.insertComponent(j);
                 }else if(v.get(i) instanceof JScrollPane){
                    JScrollPane j = (JScrollPane)v.get(i);
                    jTextPane1.setCaretPosition(jTextPane1.getStyledDocument().getLength());
                    jTextPane1.insertComponent(j);
                }
            }*/
  
            
            
      
        }  
        }
        
       return retorno; 
    }
   
   
    public retornoCJS ejecutarCJS(String rutaArchivo) throws Exception {
        retornoCJS retorno = new retornoCJS();

        if (rutaArchivo.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Error, ruta no valida para ejecutar CJS.", "USAC-WEB", JOptionPane.INFORMATION_MESSAGE);
        } else {
            LectoArchivos lector = new LectoArchivos(rutaArchivo);
            String cadena = lector.obtenerContenidoArchivo();
            if (cadena.isEmpty()) {
                JOptionPane.showMessageDialog(null, "Error, no ess posible analizar una cadena vacia", "USAC-WEB", JOptionPane.INFORMATION_MESSAGE);
            } else {
                System.out.println("Inicio de Analisis JS");
                scannerCJS scannerjs = new scannerCJS(new BufferedReader(new StringReader(cadena)));
                proyecto1_201122872.AnalizadorCJS.Parser parserCJS = new proyecto1_201122872.AnalizadorCJS.Parser(scannerjs);
                parserCJS.parse();
                List<objetoBase> h = (ArrayList<objetoBase>) parserCJS.listaSentencias;
                objetoBase temporal;
                for (int i = 0; i < h.size(); i++) {
                    temporal = h.get(i);

                    if (temporal instanceof Funcion) {
                        retorno.insertarFuncion((Funcion) temporal);
                    } else if (temporal instanceof Observador) {
                        retorno.insertarObservador((Observador) temporal);
                    } else {
                        retorno.insertarSentencia(temporal);
                    }
                }

                /*
             for (int i = 0; i < sentencias.size(); i++) {
                temporal = sentencias.get(i);
                
               v= temporal.Ejecutar(tabla, 0);              
            }*/
                System.out.println("Fin de analisis JS");
            }
        }

        return retorno;
    }

   
   public void ejecutarCSS(){
       
       
   }
   
    
    
}
