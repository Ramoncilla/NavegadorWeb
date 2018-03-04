/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto1_201122872.CHTML;

/**
 *
 * @author Ramonella
 */
public class Etiqueta {
    
    public String id="nulo";
    public String grupo="nulo";
    public int alto;
    public int ancho;
    public String alineado="IZQUIERDA";
    
    
    
    public Object retornarHtml(){
        return "";
        
    }
    
    
    public Object Ejecutar(){
        
        return "";
    }
    
    
    public boolean asignarID(Object id){
        
        if(!id.toString().equalsIgnoreCase("")){
           this.id= id.toString();
      return true; 
        }
        return false;
    }
    
    public boolean asignarGrupo(Object grupo){
        if(!grupo.toString().equalsIgnoreCase("")){
           this.grupo= grupo.toString();
      return true; 
        }
        return false;
    }
    
    public boolean asignarAlto(Object op){
       Object valor = op.toString().replace("\"", "");
        
         try{
             this.alto= Integer.parseInt(valor.toString());
             return true;
         }catch(Exception e){
             return false;
         }
    }
    
     public boolean asignarAncho(Object op){
         Object valor = op.toString().replace("\"", "");
        
         try{
             this.ancho= Integer.parseInt(valor.toString());
             return true;
         }catch(Exception e){
             return false;
         }
         
    }
    
    public boolean asignarAlineado(Object alineacion) {
        if (alineacion instanceof String) {
            switch (alineacion.toString().toUpperCase()) {
                case "DERECHA":
                    this.alineado = alineacion.toString();
                    return true;
                case "IZQUIERDA":
                    this.alineado = alineacion.toString();
                    return true;
                case "CENTRADO":
                    this.alineado = alineacion.toString();
                    return true;
            }
        }
        return false;
    }
    
     public void agregarElementos(){
         
     }
     
     
     public void asignarElementos(){
         
     }
     

}
