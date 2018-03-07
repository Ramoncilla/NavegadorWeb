/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CJS.ESTRUCURAS_CONTROL;

import CJS.ARBOL.EXPRESION.Id;
import CJS.TablaSimbolos.SimbEtiqueta;
import CJS.TablaSimbolos.Simbolo;
import CJS.TablaSimbolos.tablaSimbolos;
import CJS.elementoRetorno;
import CJS.objetoBase;
import proyecto1_201122872.CHTML.BODY.Boton;
import proyecto1_201122872.CHTML.BODY.Caja;
import proyecto1_201122872.CHTML.BODY.Cuerpo;
import proyecto1_201122872.CHTML.BODY.Enlace;
import proyecto1_201122872.CHTML.BODY.Imagen;
import static proyecto1_201122872.Proyecto1_201122872.paginaActual;

/**
 *
 * @author Ramonella
 */
public class setElemento extends objetoBase{
    
    public objetoBase nombreObjetoHTML;
    public String nombreElementoModificar;
    public String valorElemento;
    
    
    
    public setElemento(Object nombre, Object elemento, Object valor){
        this.nombreObjetoHTML=(objetoBase)nombre;
        this.nombreElementoModificar= elemento.toString().replace("\"", "");
        this.valorElemento= valor.toString().replace("\"", "");
    }

    @Override
    public elementoRetorno Ejecutar(tablaSimbolos tabla, int contexto) {
        elementoRetorno retor = new elementoRetorno();
        String ambito="global";
        if(contexto>0)
            ambito="local";
        if(nombreElementoModificar.equalsIgnoreCase("fondo") ||
             nombreElementoModificar.equalsIgnoreCase("ruta") ||
                nombreElementoModificar.equalsIgnoreCase("click") ||
                nombreElementoModificar.equalsIgnoreCase("id") ||
                nombreElementoModificar.equalsIgnoreCase("grupo") ||
                nombreElementoModificar.equalsIgnoreCase("alto") ||
                nombreElementoModificar.equalsIgnoreCase("ancho") ||
                nombreElementoModificar.equalsIgnoreCase("alineado") ){
            
            int val =1;//id
            Object variable;
            if(nombreObjetoHTML instanceof Obtener){
                val=2;
                elementoRetorno  nuevo = this.nombreObjetoHTML.Ejecutar(tabla, contexto);
                variable = nuevo.ValorRetorno;
            }else{
                 val=1; 
                 Id idElemento = (Id)nombreObjetoHTML;
                variable = tabla.obtenerSimbolo(idElemento.id, ambito, contexto);
                }
            
            
            // if(nombreObjetoHTML instanceof Id){
               // Id idElemento = (Id)nombreObjetoHTML;
               // Simbolo variable = tabla.obtenerSimbolo(idElemento.id, ambito, contexto);
                if(variable instanceof SimbEtiqueta){
                  
                    SimbEtiqueta et= (SimbEtiqueta)variable;
                    String nomm = et.nombre;
                    if(nombreElementoModificar.equalsIgnoreCase("id")){
                        et.etiquetaHTML.id=valorElemento;
                    }else if(nombreElementoModificar.equalsIgnoreCase("grupo")){
                        et.etiquetaHTML.grupo=valorElemento;
                    }else if(nombreElementoModificar.equalsIgnoreCase("alto")){
                        try{
                            int v = Integer.parseInt(valorElemento);
                            et.etiquetaHTML.alto=v;
                        }catch(NumberFormatException e){
                            
                        }
                    }else if(nombreElementoModificar.equalsIgnoreCase("ancho")){
                        
                        try{
                            int v = Integer.parseInt(valorElemento);
                            et.etiquetaHTML.ancho=v;
                        }catch(NumberFormatException e){
                            
                        }
                    }else if(nombreElementoModificar.equalsIgnoreCase("alineado")){
                        if(valorElemento.equalsIgnoreCase("derecha") ||
                                valorElemento.equalsIgnoreCase("izquierda")||
                                valorElemento.equalsIgnoreCase("centrado")){
                            
                            et.etiquetaHTML.alineado=valorElemento;
                        }else{
                            et.etiquetaHTML.alineado="izquierda";
                        }
                    }else if(nombreElementoModificar.equalsIgnoreCase("click")){
                        
                        if(et.etiquetaHTML instanceof Boton){
                            Boton bt = (Boton) et.etiquetaHTML;
                            bt.funcionesClic.add(valorElemento);
                            et.etiquetaHTML=bt;
                        }else if(et.etiquetaHTML instanceof Caja){
                             Caja bt = (Caja) et.etiquetaHTML;
                            bt.funcionesClic.add(valorElemento);
                            et.etiquetaHTML=bt;
                        }else if(et.etiquetaHTML instanceof Imagen){
                             Imagen bt = (Imagen) et.etiquetaHTML;
                            bt.funcionesClic.add(valorElemento);
                            et.etiquetaHTML=bt;
                        }else if(et.etiquetaHTML instanceof Enlace){
                             Enlace bt = (Enlace) et.etiquetaHTML;
                            bt.funcionesClic.add(valorElemento);
                            et.etiquetaHTML=bt;
                        }
                        
                    } else if(nombreElementoModificar.equalsIgnoreCase("ruta")){
                       //imagen boton, enlace 
                       if(et.etiquetaHTML instanceof Imagen){
                         Imagen im= (Imagen)et.etiquetaHTML;
                         im.rutaImagen=valorElemento;
                         et.etiquetaHTML=im;
                           
                       }else if(et.etiquetaHTML instanceof Boton){
                           Boton im= (Boton)et.etiquetaHTML;
                           im.rutaBoton=valorElemento;
                           et.etiquetaHTML=im;
                           
                       }else if(et.etiquetaHTML instanceof Enlace){
                          Enlace im= (Enlace)et.etiquetaHTML;
                          im.rutaEnlace=valorElemento;
                          et.etiquetaHTML=im;
                           
                       }
                    } else if (et.etiquetaHTML instanceof Cuerpo){
                        Cuerpo c = (Cuerpo)et.etiquetaHTML;
                        c.cadenaColor=valorElemento;
                        et.etiquetaHTML=c;
                    }
                    
                    if(val==1){
                      tabla.asignarSimbolo(nomm, et, contexto);
                    retor.ValorRetorno=et;  
                    }else if(val==2){
                        paginaActual.documento.actualizarEtiquetaDOM(et.etiquetaHTML);
                        //aqui buscamos el observador
                    }
                    
                    
                    
                }else{
                    paginaActual.erroresPagina.insertarError("Semantico", "Al elemento, no es valido asignar un valor ya que no es una etiqueta html");
                }
            
                /* }else if(nombreObjetoHTML instanceof Obtener){
                     
                     elementoRetorno  nuevo = this.nombreObjetoHTML.Ejecutar(tabla, contexto);
                     if(nuevo.ValorRetorno instanceof SimbEtiqueta){
                       
                         
                         
                     }}*/
                     
            
                
                 
                 
                 
            
            
            
            
        }else{
            
            paginaActual.erroresPagina.insertarError("Semantico", "El elemento "+ this.nombreElementoModificar+", no es valido para realizar una modificacion");
        }
           
        return retor;
    }
    
    
    /*
    
    private retPropiedad validarElemento(String elemento, Object valor) {

        retPropiedad retorno = new retPropiedad();
        switch (elemento.toUpperCase()) {

            case "FONDO": {
                if(valor instanceof String){
                    retorno.bandera=true;
                    retorno.propiedad=1;
                }
                return retorno;
            }
            case "RUTA": {
                
                if()
                

                break;
            }
            case "CLICK": {

                break;
            }
            case "VALOR": {

                break;
            }
            case "ID": {

                break;
            }
            case "GRUPO": {

                break;
            }
            case "ALTO": {

                break;
            }
            case "ANCHO": {

                break;
            }
            case "ALINEADO": {

                break;
            }

        }

        return null;
    }
    
   
    */
    
    
}
