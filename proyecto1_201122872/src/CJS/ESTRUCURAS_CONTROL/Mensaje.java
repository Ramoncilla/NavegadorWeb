/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CJS.ESTRUCURAS_CONTROL;

import CJS.ARBOL.EXPRESION.DateTime;
import CJS.ARBOL.EXPRESION.Datee;
import CJS.TablaSimbolos.tablaSimbolos;
import CJS.elementoRetorno;
import CJS.objetoBase;
import javax.swing.JOptionPane;


/**
 *
 * @author Ramonella
 */
public class Mensaje extends objetoBase{
    
    public objetoBase expresionMostrar;
    
    
    public Mensaje(Object exp){
        this.expresionMostrar = (objetoBase)exp;
    }

    @Override
    public elementoRetorno Ejecutar(tablaSimbolos tabla, int contexto) {
        
        elementoRetorno ret = expresionMostrar.Ejecutar(tabla, contexto);
        if(ret.ValorRetorno instanceof Datee){
            Datee fecha = (Datee) ret.ValorRetorno;
            JOptionPane.showMessageDialog(null, fecha.getDate(), "USAC-WEB", JOptionPane.INFORMATION_MESSAGE);
            
        }else if(ret.ValorRetorno instanceof DateTime){
            DateTime fecha = (DateTime)ret.ValorRetorno;
            JOptionPane.showMessageDialog(null, fecha.getDateTime(), "USAC-WEB", JOptionPane.INFORMATION_MESSAGE);
            
        }else{
            JOptionPane.showMessageDialog(null, ret.ValorRetorno.toString(), "USAC-WEB", JOptionPane.INFORMATION_MESSAGE);
        }
        
        
        
        return super.Ejecutar(tabla, contexto); //To change body of generated methods, choose Tools | Templates.
    }
    
    
    
    
    
}
