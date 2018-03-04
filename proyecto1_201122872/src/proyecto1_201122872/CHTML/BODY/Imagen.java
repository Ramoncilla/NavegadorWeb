/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto1_201122872.CHTML.BODY;

import java.awt.Dimension;
import java.awt.Image;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;
import java.util.ArrayList;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import proyecto1_201122872.CHTML.ElemetoPropiedad.propiedad;
import proyecto1_201122872.CHTML.ElemetoPropiedad.propiedadAlineado;
import proyecto1_201122872.CHTML.ElemetoPropiedad.propiedadAlto;
import proyecto1_201122872.CHTML.ElemetoPropiedad.propiedadAncho;
import proyecto1_201122872.CHTML.ElemetoPropiedad.propiedadClick;
import proyecto1_201122872.CHTML.ElemetoPropiedad.propiedadGrupo;
import proyecto1_201122872.CHTML.ElemetoPropiedad.propiedadId;
import proyecto1_201122872.CHTML.ElemetoPropiedad.propiedadRuta;
import proyecto1_201122872.CHTML.Etiqueta;
import proyecto1_201122872.CHTML.listaElementos;
import static proyecto1_201122872.Proyecto1_201122872.erroresEjecucion;

/**
 *
 * @author Ramonella
 */
public class Imagen extends Etiqueta implements MouseListener {

    public listaElementos elementosImagen;
    public String rutaImagen;
    private JLabel imagen;
    public String nombreFuncionClick;

    public Imagen(Object elementos, Object ruta) {
        this.elementosImagen = new listaElementos((ArrayList<propiedad>) elementos);
        this.rutaImagen = ruta.toString();
        this.imagen = new JLabel();
        this.nombreFuncionClick="";
        asignarRutaImagen();
        this.ancho=100;
        this.alto=100;

    }

    private void asignarRutaImagen() {
        if (rutaImagen.equalsIgnoreCase("SinImagen")) {
            propiedadRuta elementoRuta = elementosImagen.obtenerRuta();
            if (elementoRuta != null) {
                this.rutaImagen= elementoRuta.ruta.replace("\"", "");
            }
        }
    }

    @Override
    public Object retornarHtml() {
        
        agregarElementos();
        imagen = new JLabel();
        imagen.setSize(ancho, alto);
        File f = new File(this.rutaImagen);
        if (f.exists() && !f.isDirectory()) {
           
            Image img= new ImageIcon(this.rutaImagen).getImage();
            ImageIcon img2=new ImageIcon(img.getScaledInstance(ancho, alto, Image.SCALE_SMOOTH));
            imagen = new JLabel(img2);
            imagen.setSize(ancho, alto);
            imagen.repaint();
           /* ImageIcon imageIcon = new ImageIcon(this.rutaImagen);  
            imagen = new JLabel(imageIcon);*/
            
        } else {
             ImageIcon imageIcon = new ImageIcon("C:\\Users\\Ramonella\\Documents\\Repositorios\\Proyecto1\\NavegadorWeb\\proyecto1_201122872\\ArchivosEntrada\\noEncontrada.gif");
            Icon icono = new ImageIcon(imageIcon.getImage().getScaledInstance(imagen.getWidth(), imagen.getHeight(), Image.SCALE_SMOOTH));
            imagen.setIcon(icono);
            imagen.repaint();

        }
        imagen.addMouseListener(this);
        imagen.setVisible(true);
        return imagen;
    }

    
   
    
    
    
    
    
    
    
    
    
    
    
    @Override
    public void mouseClicked(MouseEvent e) {
        System.out.println("presione la imgen " + rutaImagen);
    }

    @Override
    public void mousePressed(MouseEvent me) {
    }

    @Override
    public void mouseReleased(MouseEvent me) {
    }

    @Override
    public void mouseEntered(MouseEvent me) {
    }

    @Override
    public void mouseExited(MouseEvent me) {
    }

    
    
    
      @Override
    public void agregarElementos(){
        propiedad temporal;
        for (int i = 0; i < this.elementosImagen.listadoElementos.size(); i++) {
            temporal = this.elementosImagen.listadoElementos.get(i);
            if(temporal instanceof  propiedadAlineado){
                propiedadAlineado p = (propiedadAlineado)temporal;
                if(!asignarAlineado(p.alineado)){
                    erroresEjecucion.insertarError("Semantico", "Elemento no valido para la alineacion del boton");
                }
            }else if(temporal instanceof propiedadId){
                 propiedadId p = (propiedadId)temporal;
                if(!asignarID(p.idElemento)){
                    erroresEjecucion.insertarError("Semantico", "Elemento no valido para la alineacion el ID de un boton");
                }
                
            }else if(temporal instanceof propiedadGrupo){
                propiedadGrupo p = (propiedadGrupo)temporal;
                if(!asignarGrupo(p.grupo)){
                    erroresEjecucion.insertarError("Semantico", "Elemento no valido para la alineacion el ID de un boton");
                }
                
            }else if(temporal instanceof propiedadAlto){
                propiedadAlto p = (propiedadAlto)temporal;
                if(!asignarAlto(p.alturaComponente)){
                  
                    erroresEjecucion.insertarError("Semantico", "Elemento no valido para la alineacion el ID de un boton");
                }
                
            }else if(temporal instanceof propiedadAncho){
                propiedadAncho p = (propiedadAncho)temporal;
                if(!asignarAncho(p.valorAncho)){
                    erroresEjecucion.insertarError("Semantico", "Elemento no valido para la alineacion el ID de un boton");
                }
                
            }else if(temporal instanceof propiedadClick){
                propiedadClick p = (propiedadClick)temporal;
                this.nombreFuncionClick= p.nombreFuncion;
                
            }else if(temporal instanceof propiedadRuta){
                propiedadRuta p = (propiedadRuta)temporal;
                this.rutaImagen= p.ruta.replace("\"", "");
                
            }
            
            
            
        }
    }
    
    
    
}
