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
public class CuerpoEstructuras extends objetoBase{
    
    List<objetoBase> listaSentencias;
    
    
    public CuerpoEstructuras(Object sentencias){
        this.listaSentencias= (ArrayList<objetoBase>)sentencias;
    }

    public CuerpoEstructuras(){
        this.listaSentencias= new ArrayList<>();
    }
    
    @Override
    public elementoRetorno Ejecutar(tablaSimbolos tabla, int contexto) {
        
        elementoRetorno ret = new elementoRetorno();
        for (int i = 0; i < this.listaSentencias.size(); i++) {
           if((!ret.detener) && (!ret.banderaRetorno)){
             ret= this.listaSentencias.get(i).Ejecutar(tabla, contexto);  
           }else{
               break;
           }
            
        }
       return ret;
    }
    
    
    
    
    
    
    
    
}
