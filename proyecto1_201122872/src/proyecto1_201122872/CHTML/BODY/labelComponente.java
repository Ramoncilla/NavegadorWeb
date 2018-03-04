/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto1_201122872.CHTML.BODY;

import java.awt.Dimension;
import javax.swing.JLabel;

/**
 *
 * @author Ramonella
 */
public class labelComponente extends JLabel {
   @Override
    public void setSize(int i, int i1) {
        super.setSize(i, i1); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Dimension getPreferredSize() {
        Dimension f = new Dimension(getWidth(),getHeight());
        return f; //To change body of generated methods, choose Tools | Templates.
    }

    
    @Override
    public int getHeight() {
        return super.getHeight(); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int getWidth() {
        return super.getWidth(); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void setMaximumSize(Dimension dmnsn) {
        Dimension dim = getPreferredSize();
        super.setMaximumSize(dim); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void setMinimumSize(Dimension dmnsn) {
        Dimension dim = getPreferredSize();
        super.setMaximumSize(dim); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void setPreferredSize(Dimension dmnsn) {
        Dimension dim = getPreferredSize();
        super.setMaximumSize(dim); //To change body of generated methods, choose Tools | Templates.
    }
    
    @Override
    public Dimension getMinimumSize() {
        Dimension f = new Dimension(getWidth(),getHeight());
        return f;//To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Dimension getMaximumSize() {
      Dimension f = new Dimension(getWidth(),getHeight());
        return f; //To change body of generated methods, choose Tools | Templates.
    }
    
 
      
    
}
