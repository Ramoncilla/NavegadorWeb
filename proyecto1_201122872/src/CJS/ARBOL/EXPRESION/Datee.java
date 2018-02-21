/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CJS.ARBOL.EXPRESION;

import CJS.elementoRetorno;
import CJS.objetoBase;

/**
 *
 * @author Ramonella
 */
public class Datee extends objetoBase {
    
    public int dia;
    public int mes;
    public int anio;
    
    public Datee(Object dia, Object mes, Object anio){
         this.dia= Integer.parseInt(dia.toString());
         this.mes= Integer.parseInt(mes.toString());
         this.anio= Integer.parseInt(anio.toString());
    }
    
    public String getDate(){
        
        return dia+"/"+mes+"/"+anio;
        
    }
    
    
         @Override
    public elementoRetorno Ejecutar(){
        
        Datee fechaF = new Datee(this.dia, this.mes, this.anio);
        elementoRetorno ret = new elementoRetorno();
        ret.ValorRetorno= fechaF;
        super.retorno.ValorRetorno=fechaF;
        return ret;
    }
    
    
}
