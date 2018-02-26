/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CJS.ESTRUCURAS_CONTROL;

import CJS.TablaSimbolos.tablaSimbolos;
import CJS.elementoRetorno;
import CJS.objetoBase;

/**
 *
 * @author Ramonella
 */
public class Mientras extends objetoBase{
    
    public objetoBase condicion;
    public CuerpoEstructuras sentenciasVerdaderas;
    
    
    public Mientras(Object cond, Object verd){
        this.condicion= (objetoBase)cond;
        this.sentenciasVerdaderas= (CuerpoEstructuras)verd;
    }

    @Override
    public elementoRetorno Ejecutar(tablaSimbolos tabla, int contexto) {
        
        
        return super.Ejecutar(tabla, contexto); //To change body of generated methods, choose Tools | Templates.
    }
    
    
    /* public void Ejecutar(Simbolos_Tabla Vars) {
        Simbolos_Tabla Vars_Temporales = Vars.clonar(Vars);
        condicion.Ejecutar(Vars);
        Object resultado = condicion.ValorRetorno;
        boolean res = esBool(resultado);

        nodo_base base;
       while (res && resultado.toString().equalsIgnoreCase("verdadero")) {
            if (sentVerdaderas != null) {
                
                
                for (int i = 0; i < sentVerdaderas.size(); i++) {
                    base = sentVerdaderas.get(i);
                    
                    if (i != (sentVerdaderas.size() - 1)) {
                        base.Ejecutar(Vars);

                    } else {
                        base.Ejecutar(Vars);
                        Vars = Vars.modificarTabla(Vars_Temporales, Vars);
                    }
                }

            }
            condicion.Ejecutar(Vars);
         resultado = condicion.ValorRetorno;
         res = esBool(resultado);
            
        } 

    }*/
    
    
    
    
    
}
