/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto1_201122872.CHTML.BODY;
import java.util.List;
import javax.swing.JTextPane;
import proyecto1_201122872.CHTML.Etiqueta;
import proyecto1_201122872.CHTML.listaElementos;
/**
 *
 * @author Ramonella
 */
public class Panel extends Etiqueta  {
    
    public listaElementos elementosPanel;
    public Cuerpo objetosPanel;
    private JTextPane panel;
    
    
    public Panel(Object elementos, Object cuerpo){
        this.elementosPanel= (listaElementos)elementos;
        this.objetosPanel= (Cuerpo)objetosPanel;
        panel= new JTextPane();
        panel.setContentType("text/html");
    }

    @Override
    public Object retornarHtml() {
        
        List<Object> componentesPanel = objetosPanel.ejecutarCuerpo();
        Object temporal;
        for (int i = 0; i < componentesPanel.size(); i++) {
            temporal = componentesPanel.get(i);
            
        }
        
        
        
        return super.retornarHtml(); //To change body of generated methods, choose Tools | Templates.
    }
    
    
    
    
    
    
    
    
    
    
}
