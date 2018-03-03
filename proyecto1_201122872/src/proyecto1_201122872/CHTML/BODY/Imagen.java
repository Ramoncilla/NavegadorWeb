/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto1_201122872.CHTML.BODY;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionAdapter;
import java.awt.event.MouseMotionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import proyecto1_201122872.CHTML.ElemetoPropiedad.propiedad;
import proyecto1_201122872.CHTML.ElemetoPropiedad.propiedadRuta;
import proyecto1_201122872.CHTML.Etiqueta;
import proyecto1_201122872.CHTML.listaElementos;

/**
 *
 * @author Ramonella
 */
public class Imagen extends Etiqueta implements MouseListener {

    public listaElementos elementosImagen;
    public String rutaImagen;
    private JLabel imagen;

    public Imagen(Object elementos, Object ruta) {
        this.elementosImagen = new listaElementos((ArrayList<propiedad>) elementos);
        this.rutaImagen = ruta.toString();
        this.imagen = new JLabel();
        asignarRutaImagen();

    }

    private void asignarRutaImagen() {
        if (rutaImagen.equalsIgnoreCase("SinImagen")) {
            propiedadRuta elementoRuta = elementosImagen.obtenerRuta();
            if (elementoRuta != null) {
                this.rutaImagen = elementoRuta.ruta;
            }
        }
    }

    @Override
    public Object retornarHtml() {

        File f = new File(this.rutaImagen);
        if (f.exists() && !f.isDirectory()) {
            ImageIcon imageIcon = new ImageIcon(this.rutaImagen);
            imagen = new JLabel(imageIcon);

        } else {
            imagen = new JLabel("No existe la imgen");

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

}
