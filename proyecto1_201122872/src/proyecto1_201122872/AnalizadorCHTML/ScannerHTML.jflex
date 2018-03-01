/* ------------------------==: CODIGO DE USUARIO :==--------------------------*/

package proyecto1_201122872.AnalizadorCHTML;
    

import java_cup.runtime.*;
import java.io.*;
import java.lang.*;
import java.util.ArrayList;
import java.util.LinkedList;

%%

%{
public static String cadena;
/* ------------------------==: METODO DE ERROR LEXICO :==---------------------*/
    private void ErrorScan(int linea, int columna, String valor) {
        System.out.println("Error Lexico Iden: " + valor + ", " + linea + ", " + columna);
        cadena += "<tr>"
                + "<td><center><b>" + valor + "</b></center></td>"
                + "<td><center><b>" + linea + "</b></center></td>"
                + "<td><center><b>" + columna + "</b></center></td>"
                + "</tr>";
    }

%} 

/* ----------------------==: OPCIONES Y DECLARACIONES :==---------------------*/
%cupsym simbolosCHTML
%class scannerCHTML
%cup
%public
%unicode
%public
%line
%char
%ignorecase
%caseless

/* -------------------------==: EXPRESIONES REGULARES :==---------------------*/

numero             = [0-9]+(("\."[0-9]+)?)
letras              = [a-zA-Z_]
cadena              = [\"] ~[\"]
caracter            = "'"([0-9]|[a-zA-Z])"'"
id                  = {letras}({letras}|{numero})*
cadena2 			= [0-9_!-;?-Ñ=áéíóúÁÉÍÓÚ] [[[0-9_!-;?-Ñ=áéíóúÁÉÍÓÚ] | [\ \r\t\f\n]]+ [0-9_!-;?-Ñ=áéíóúÁÉÍÓÚ]]*
espacios   		= [\ \r\t\f\t]
saltos   		= [\ \n]

comentario_multi    = "<//-"~"-//>"


%xstate SIN_ETIQUETA


%%option

/* -----------------------------==: COMENTARIOS  :==--------------------------*/








<YYINITIAL> ">"         {System.out.println("mayor");  yybegin(SIN_ETIQUETA);            return new Symbol (simbolosCHTML.mayor, yyline+1,yychar+1, new String (yytext()));}

"<"         {System.out.println("menor");  yybegin(YYINITIAL);            return new Symbol (simbolosCHTML.menor, yyline+1,yychar+1, new String (yytext()));}
/*--------------------=: Palabras reservadas :=-------------------- */

<YYINITIAL>  "chtml"  {System.out.println("chtml");              return new Symbol (simbolosCHTML.chtml, yyline+1,yychar+1, new String (yytext()));}
<YYINITIAL> "fin-chtml"  {System.out.println("fincHtml");               return new Symbol (simbolosCHTML.finChtml, yyline+1,yychar+1, new String (yytext()));}
<YYINITIAL> "encabezado"  {System.out.println("encabezado");                 return new Symbol (simbolosCHTML.encabezado, yyline+1,yychar+1, new String (yytext()));}
<YYINITIAL>	"fin-encabezado"  {System.out.println("finEncabezado");               return new Symbol (simbolosCHTML.finEncabezado, yyline+1,yychar+1, new String (yytext()));}
<YYINITIAL> "cjs"  {System.out.println("cjs");               return new Symbol (simbolosCHTML.cjs, yyline+1,yychar+1, new String (yytext()));}
<YYINITIAL> "fin-cjs"  {System.out.println("finCjs");               return new Symbol (simbolosCHTML.finCjs, yyline+1,yychar+1, new String (yytext()));}
<YYINITIAL> "ccss"  {System.out.println("ccss");               return new Symbol (simbolosCHTML.ccss, yyline+1,yychar+1, new String (yytext()));}
<YYINITIAL> "fin-ccss"  {System.out.println("finCcss");               return new Symbol (simbolosCHTML.finCcss, yyline+1,yychar+1, new String (yytext()));}
<YYINITIAL> "cuerpo"  {System.out.println("cierpo");               return new Symbol (simbolosCHTML.cuerpo, yyline+1,yychar+1, new String (yytext()));}
<YYINITIAL> "fin-cuerpo"  {System.out.println("finCuerpo");               return new Symbol (simbolosCHTML.finCuerpo, yyline+1,yychar+1, new String (yytext()));}
<YYINITIAL> "titulo"  {System.out.println("titulo");               return new Symbol (simbolosCHTML.titulo, yyline+1,yychar+1, new String (yytext()));}
<YYINITIAL> "fin-titulo"  {System.out.println("finTitulo");               return new Symbol (simbolosCHTML.finTitulo, yyline+1,yychar+1, new String (yytext()));}
<YYINITIAL> "panel"  {System.out.println("panel");               return new Symbol (simbolosCHTML.panel, yyline+1,yychar+1, new String (yytext()));}
<YYINITIAL> "fin-panel"  {System.out.println("finPanel");               return new Symbol (simbolosCHTML.finPanel, yyline+1,yychar+1, new String (yytext()));}
<YYINITIAL> "texto"  {System.out.println("textp");               return new Symbol (simbolosCHTML.texto, yyline+1,yychar+1, new String (yytext()));}
<YYINITIAL> "fin-texto"  {System.out.println("finTexto");                  return new Symbol (simbolosCHTML.finTexto, yyline+1,yychar+1, new String (yytext()));}
<YYINITIAL> "imagen"  {System.out.println("Imagen");               return new Symbol (simbolosCHTML.imagen, yyline+1,yychar+1, new String (yytext()));}
<YYINITIAL> "fin-imagen"  {System.out.println("finImagen");               return new Symbol (simbolosCHTML.finImagen, yyline+1,yychar+1, new String (yytext()));}
<YYINITIAL> "boton"  {System.out.println("Boton");               return new Symbol (simbolosCHTML.boton, yyline+1,yychar+1, new String (yytext()));}
<YYINITIAL> "fin-boton"  {System.out.println("finBoton");               return new Symbol (simbolosCHTML.finBoton, yyline+1,yychar+1, new String (yytext()));}
<YYINITIAL> "enlace"  {System.out.println("enlace");               return new Symbol (simbolosCHTML.enlace, yyline+1,yychar+1, new String (yytext()));}
<YYINITIAL> "fin-enlace"  {System.out.println("finEnlace");               return new Symbol (simbolosCHTML.finEnlace, yyline+1,yychar+1, new String (yytext()));}
<YYINITIAL> "tabla"  {System.out.println("tabla");               return new Symbol (simbolosCHTML.tabla, yyline+1,yychar+1, new String (yytext()));}
<YYINITIAL> "fin-tabla"  {System.out.println("finTabla");               return new Symbol (simbolosCHTML.finTabla, yyline+1,yychar+1, new String (yytext()));}
<YYINITIAL> "fil_t"  {System.out.println("filT");               return new Symbol (simbolosCHTML.fil_t, yyline+1,yychar+1, new String (yytext()));}
<YYINITIAL> "fin-fil_t"  {System.out.println("finFilT");               return new Symbol (simbolosCHTML.finFil_t, yyline+1,yychar+1, new String (yytext()));}
<YYINITIAL> "cb"  {System.out.println("cb");               return new Symbol (simbolosCHTML.cb, yyline+1,yychar+1, new String (yytext()));}
<YYINITIAL> "fin-cb"  {System.out.println("finCb");               return new Symbol (simbolosCHTML.finCb, yyline+1,yychar+1, new String (yytext()));}
<YYINITIAL> "ct"  {System.out.println("ct");               return new Symbol (simbolosCHTML.ct, yyline+1,yychar+1, new String (yytext()));}
<YYINITIAL> "fin-ct"  {System.out.println("finCt");               return new Symbol (simbolosCHTML.finCt, yyline+1,yychar+1, new String (yytext()));}
<YYINITIAL> "texto_a"  {System.out.println("textoa");               return new Symbol (simbolosCHTML.texto_a, yyline+1,yychar+1, new String (yytext()));}
<YYINITIAL> "fin-texto_a"  {System.out.println("finTextoa");               return new Symbol (simbolosCHTML.finTexto_a, yyline+1,yychar+1, new String (yytext()));}
<YYINITIAL> "caja_texto"  {System.out.println("cajaTexto");               return new Symbol (simbolosCHTML.caja_texto, yyline+1,yychar+1, new String (yytext()));}
<YYINITIAL> "fin-caja_texto"  {System.out.println("finCajaTExto");               return new Symbol (simbolosCHTML.finCaja_texto, yyline+1,yychar+1, new String (yytext()));}
<YYINITIAL> "caja"  {System.out.println("caja");               return new Symbol (simbolosCHTML.caja, yyline+1,yychar+1, new String (yytext()));}
<YYINITIAL> "fin-caja"  {System.out.println("finCaja");               return new Symbol (simbolosCHTML.finCaja, yyline+1,yychar+1, new String (yytext()));}
<YYINITIAL> "opcion"  {System.out.println("opcion");               return new Symbol (simbolosCHTML.opcion, yyline+1,yychar+1, new String (yytext()));}
<YYINITIAL> "fin-opcion"  {System.out.println("finOpcion");               return new Symbol (simbolosCHTML.finOpcion, yyline+1,yychar+1, new String (yytext()));}
<YYINITIAL> "spinner"  {System.out.println("spinner");               return new Symbol (simbolosCHTML.spinner, yyline+1,yychar+1, new String (yytext()));}
<YYINITIAL> "fin-spinner"  {System.out.println("finSpinner");               return new Symbol (simbolosCHTML.finSpinner, yyline+1,yychar+1, new String (yytext()));}
<YYINITIAL> "salto-fin"  {System.out.println("saltofin");               return new Symbol (simbolosCHTML.saltoFin, yyline+1,yychar+1, new String (yytext()));}


<YYINITIAL> "id"  {System.out.println("identificador");               return new Symbol (simbolosCHTML.id, yyline+1,yychar+1, new String (yytext()));}
<YYINITIAL> "grupo"  {System.out.println("grupo");               return new Symbol (simbolosCHTML.grupo, yyline+1,yychar+1, new String (yytext()));}
<YYINITIAL> "alto"  {System.out.println("alto");               return new Symbol (simbolosCHTML.alto, yyline+1,yychar+1, new String (yytext()));}
<YYINITIAL> "ancho"  {System.out.println("anchod");               return new Symbol (simbolosCHTML.ancho, yyline+1,yychar+1, new String (yytext()));}
<YYINITIAL> "alineado"  {System.out.println("alineado");               return new Symbol (simbolosCHTML.alineado, yyline+1,yychar+1, new String (yytext()));}

<YYINITIAL> "valor"  {System.out.println("valor");               return new Symbol (simbolosCHTML.valor, yyline+1,yychar+1, new String (yytext()));}
<YYINITIAL> "click"  {System.out.println("click");               return new Symbol (simbolosCHTML.click, yyline+1,yychar+1, new String (yytext()));}
<YYINITIAL> "ruta"  {System.out.println("ruta");               return new Symbol (simbolosCHTML.ruta, yyline+1,yychar+1, new String (yytext()));}
<YYINITIAL> "fondo"  {System.out.println("fondo");               return new Symbol (simbolosCHTML.fondo, yyline+1,yychar+1, new String (yytext()));}
<YYINITIAL> "izquierda"  {System.out.println("izquierdo");               return new Symbol (simbolosCHTML.izquierda, yyline+1,yychar+1, new String (yytext()));}
<YYINITIAL> "derecho"  {System.out.println("derecho");               return new Symbol (simbolosCHTML.derecha, yyline+1,yychar+1, new String (yytext()));}
<YYINITIAL> "centrado"  {System.out.println("centrado");               return new Symbol (simbolosCHTML.centrado, yyline+1,yychar+1, new String (yytext()));}

<YYINITIAL> "="  {System.out.println("igual");               return new Symbol (simbolosCHTML.igualSimb, yyline+1,yychar+1, new String (yytext()));}
<YYINITIAL> ";"  {System.out.println("puntoComa");               return new Symbol (simbolosCHTML.puntoComaSimb, yyline+1,yychar+1, new String (yytext()));}



/* -------------------------==: EXPRESIONES REGULARES :==---------------------*/



<YYINITIAL> {cadena}    {System.out.println("cadeba");                return new Symbol (simbolosCHTML.cadena, yyline+1,yychar+1, new String (yytext()));}
<YYINITIAL> {numero}    {System.out.println("nu mero");                return new Symbol (simbolosCHTML.numero, yyline+1,yychar+1, new String (yytext()));}
<YYINITIAL> {id}        {System.out.println("id");                return new Symbol (simbolosCHTML.identificador, yyline+1,yychar+1, new String (yytext()));}



/* -------------------------------==: BLANCOS :==-----------------------------*/
<YYINITIAL> [ \t\r\f\n]+        { /* Se ignoran */}
<YYINITIAL>{espacios}     		{ /*Espacios en blanco, ignorados*/ }
<YYINITIAL>{saltos}     		{ /*Saltos de linea, ignorados*/}
<YYINITIAL>{comentario_multi}      	{ /*Comentario Multi Línea Ignorado*/ }


 <SIN_ETIQUETA> {
 
 "<"         {System.out.println("menor");  yybegin(YYINITIAL);            return new Symbol (simbolosCHTML.menor, yyline+1,yychar+1, new String (yytext()));}
	 {comentario_multi}      	{ /*Comentario Multi Línea Ignorado*/ }
	 
	 {espacios}     		{ /*Saltos de linea, ignorados*/}
	 {saltos}     		{ /*espacios, ignorados*/}
	
	 {cadena2}    {System.out.println("cadena2 "+yytext() );  return new Symbol (simbolosCHTML.cadena2, yyline+1,yychar+1, new String (yytext()));}
	 . 					{ String errLex = "Error léxico, caracter irreconocible: '"+yytext()+"' en la línea: "+(yyline+1)+" y columna: "+yycolumn;
						  System.out.println(errLex); 
						}
 }






/* --------------------------------==: ERROR :==------------------------------*/
/* Cualquier Otro */
.                      { ErrorScan(yyline,yychar,yytext()); }