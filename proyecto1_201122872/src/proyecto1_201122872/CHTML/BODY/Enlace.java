/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto1_201122872.CHTML.BODY;
import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import proyecto1_201122872.CHTML.ElemetoPropiedad.propiedad;
import proyecto1_201122872.CHTML.ElemetoPropiedad.propiedadRuta;
import proyecto1_201122872.CHTML.Etiqueta;
import proyecto1_201122872.CHTML.listaElementos;
import static proyecto1_201122872.Proyecto1_201122872.erroresEjecucion;
/**
 *
 * @author Ramonella
 */
public class Enlace  extends Etiqueta implements MouseListener{
    
     public listaElementos elementosEnlace;
     public String cadenaEnlace;
     private JLabel link;
     public String rutaEnlace;
     
    public Enlace(Object elementos , Object cadena){
        
        this.elementosEnlace = new listaElementos((ArrayList<propiedad>)elementos);
        this.cadenaEnlace= cadena.toString();  
        this.link = new JLabel();
         asignarRutaEnlace();
    }
   
    
    private void asignarRutaEnlace() {
            propiedadRuta elementoRuta = elementosEnlace.obtenerRuta();
            if (elementoRuta != null) {
                this.rutaEnlace = elementoRuta.ruta;
            }else{
                this.rutaEnlace="";
            }
        
    }

    @Override
    public Object retornarHtml() {

        File f = new File(this.rutaEnlace);
        if (f.exists() && !f.isDirectory()) {
            link = new JLabel(this.cadenaEnlace);

        } else {
            link = new JLabel(this.cadenaEnlace);
            erroresEjecucion.insertarError("Semantico", "Ruta de Enlace no existe");

        }
        link.setForeground(Color.BLUE);
        link.setOpaque(false);
        link.addMouseListener(this);
        return link;
    }

    @Override
    public void mouseClicked(MouseEvent e) {
         File f = new File(this.rutaEnlace);
        if (f.exists() && !f.isDirectory()) {
            

        }
        System.out.println("clic en enlace "+ this.cadenaEnlace);
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
    
    
}
