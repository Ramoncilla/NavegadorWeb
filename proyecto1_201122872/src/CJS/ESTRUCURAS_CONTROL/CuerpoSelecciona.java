/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CJS.ESTRUCURAS_CONTROL;

import CJS.TablaSimbolos.tablaSimbolos;
import CJS.elementoRetorno;
import CJS.objetoBase;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Ramonella
 */
public class CuerpoSelecciona extends objetoBase {
    
   List<Caso> casosSelecciona;
   CuerpoEstructuras defecto; 
   
   public CuerpoSelecciona(){
       this.casosSelecciona= new ArrayList<>();
       this.defecto= new CuerpoEstructuras();
   }
   
   public void agregarCaso(Object caso){
       Caso nuevo = (Caso)caso;
       this.casosSelecciona.add(nuevo);
   }
   public void agregarDefecto(Object defecto)
   {
       this.defecto=(CuerpoEstructuras)defecto;
   }

    @Override
    public elementoRetorno Ejecutar(tablaSimbolos tabla, int contexto) {
        
        
        
        
        
        
        return super.Ejecutar(tabla, contexto); //To change body of generated methods, choose Tools | Templates.
    }
   
   
   
   
   
    
    
}
