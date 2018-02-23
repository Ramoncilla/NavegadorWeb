/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CJS.ARBOL.EXPRESION;

import CJS.TablaSimbolos.tablaSimbolos;
import CJS.elementoRetorno;
import CJS.objetoBase;

/**
 *
 * @author Ramonella
 */
public class DateTime extends objetoBase {
    
    public Datee fecha;
    public  int horas;
    public int minutos;
    public int segundos;
    
    
    
    public DateTime(Object fec0ha, Object horas, Object minutos, Object segundos){
        
        this.fecha= (Datee)fec0ha;
        this.horas= Integer.parseInt(horas.toString());
        this.minutos = Integer.parseInt(minutos.toString());
        this.segundos= Integer.parseInt(segundos.toString());
    }
    
     public String getDateTime(){
        
        return fecha.getDate()+" "+horas+":"+minutos+":"+segundos;
        
    }
     
        @Override
    public elementoRetorno Ejecutar(tablaSimbolos tabla, int contexto){
        
        Datee fechaF = new Datee(this.fecha.dia, this.fecha.mes, this.fecha.anio);
        DateTime n = new DateTime(fechaF,this.horas, this.minutos, this.segundos);
        elementoRetorno ret = new elementoRetorno();
        ret.ValorRetorno= n;
        super.retorno.ValorRetorno=n;
        return ret;
    }
    
    
}
