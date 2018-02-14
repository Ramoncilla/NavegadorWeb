/* ------------------------==: CODIGO DE USUARIO :==--------------------------*/

package proyecto1_201122872.AnalizadorCHTML;
    

import java_cup.runtime.Symbol;
import java.io.*;
import java.lang.*;
import java.util.ArrayList;
import java.util.LinkedList;

%% 

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
entero              = [0-9]+
numero             = [0-9]+(("\."[0-9]+)?)
letras              = [a-zA-Z_]
cadena              = [\"] ~[\"]
caracter            = "'"([0-9]|[a-zA-Z])"'"
id                  = {letras}({letras}|{numero})*


cadena2   = (({id}|{numero}|\s ))(({id}|{numero}|\s )+)

comentario_multi    = "<//-"~"-//>"


%{
public static String cadena;
//cadena2   = (\n|{id}|{numero})+
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
%%

/* -----------------------------==: COMENTARIOS  :==--------------------------*/
{comentario_multi}   {System.out.println("Coment Multi");   /* se ignora*/}



"<"         {System.out.println("menor");              return new Symbol (simbolosCHTML.menor, yyline+1,yychar+1, new String (yytext()));}
">"         {System.out.println("mayor");              return new Symbol (simbolosCHTML.mayor, yyline+1,yychar+1, new String (yytext()));}


/*--------------------=: Palabras reservadas :=-------------------- */

"chtml"  {System.out.println("chtml");              return new Symbol (simbolosCHTML.chtml, yyline+1,yychar+1, new String (yytext()));}
"fin-chtml"  {System.out.println("fincHtml");               return new Symbol (simbolosCHTML.finChtml, yyline+1,yychar+1, new String (yytext()));}
"encabezado"  {System.out.println("encabezado");                 return new Symbol (simbolosCHTML.encabezado, yyline+1,yychar+1, new String (yytext()));}
"fin-encabezado"  {System.out.println("finEncabezado");               return new Symbol (simbolosCHTML.finEncabezado, yyline+1,yychar+1, new String (yytext()));}
"cjs"  {System.out.println("cjs");               return new Symbol (simbolosCHTML.cjs, yyline+1,yychar+1, new String (yytext()));}
"fin-cjs"  {System.out.println("finCjs");               return new Symbol (simbolosCHTML.finCjs, yyline+1,yychar+1, new String (yytext()));}
"ccss"  {System.out.println("ccss");               return new Symbol (simbolosCHTML.ccss, yyline+1,yychar+1, new String (yytext()));}
"fin-ccss"  {System.out.println("finCcss");               return new Symbol (simbolosCHTML.finCcss, yyline+1,yychar+1, new String (yytext()));}
"cuerpo"  {System.out.println("cierpo");               return new Symbol (simbolosCHTML.cuerpo, yyline+1,yychar+1, new String (yytext()));}
"fin-cuerpo"  {System.out.println("finCuerpo");               return new Symbol (simbolosCHTML.finCuerpo, yyline+1,yychar+1, new String (yytext()));}
"titulo"  {System.out.println("titulo");               return new Symbol (simbolosCHTML.titulo, yyline+1,yychar+1, new String (yytext()));}
"fin-titulo"  {System.out.println("finTitulo");               return new Symbol (simbolosCHTML.finTitulo, yyline+1,yychar+1, new String (yytext()));}
"panel"  {System.out.println("panel");               return new Symbol (simbolosCHTML.panel, yyline+1,yychar+1, new String (yytext()));}
"fin-panel"  {System.out.println("finPanel");               return new Symbol (simbolosCHTML.finPanel, yyline+1,yychar+1, new String (yytext()));}
"texto"  {System.out.println("textp");               return new Symbol (simbolosCHTML.texto, yyline+1,yychar+1, new String (yytext()));}
"fin-texto"  {System.out.println("finTexto");                  return new Symbol (simbolosCHTML.finTexto, yyline+1,yychar+1, new String (yytext()));}
"imagen"  {System.out.println("Imagen");               return new Symbol (simbolosCHTML.imagen, yyline+1,yychar+1, new String (yytext()));}
"fin-imagen"  {System.out.println("finImagen");               return new Symbol (simbolosCHTML.finImagen, yyline+1,yychar+1, new String (yytext()));}
"boton"  {System.out.println("Boton");               return new Symbol (simbolosCHTML.boton, yyline+1,yychar+1, new String (yytext()));}
"fin-boton"  {System.out.println("finBoton");               return new Symbol (simbolosCHTML.finBoton, yyline+1,yychar+1, new String (yytext()));}
"enlace"  {System.out.println("enlace");               return new Symbol (simbolosCHTML.enlace, yyline+1,yychar+1, new String (yytext()));}
"fin-enlace"  {System.out.println("finEnlace");               return new Symbol (simbolosCHTML.finEnlace, yyline+1,yychar+1, new String (yytext()));}
"tabla"  {System.out.println("tabla");               return new Symbol (simbolosCHTML.tabla, yyline+1,yychar+1, new String (yytext()));}
"fin-tabla"  {System.out.println("finTabla");               return new Symbol (simbolosCHTML.finTabla, yyline+1,yychar+1, new String (yytext()));}
"fil_t"  {System.out.println("filT");               return new Symbol (simbolosCHTML.fil_t, yyline+1,yychar+1, new String (yytext()));}
"fin-fil_t"  {System.out.println("finFilT");               return new Symbol (simbolosCHTML.finFil_t, yyline+1,yychar+1, new String (yytext()));}
"cb"  {System.out.println("cb");               return new Symbol (simbolosCHTML.cb, yyline+1,yychar+1, new String (yytext()));}
"fin-cb"  {System.out.println("finCb");               return new Symbol (simbolosCHTML.finCb, yyline+1,yychar+1, new String (yytext()));}
"ct"  {System.out.println("ct");               return new Symbol (simbolosCHTML.ct, yyline+1,yychar+1, new String (yytext()));}
"fin-ct"  {System.out.println("finCt");               return new Symbol (simbolosCHTML.finCt, yyline+1,yychar+1, new String (yytext()));}
"texto_a"  {System.out.println("textoa");               return new Symbol (simbolosCHTML.texto_a, yyline+1,yychar+1, new String (yytext()));}
"fin-texto_a"  {System.out.println("finTextoa");               return new Symbol (simbolosCHTML.finTexto_a, yyline+1,yychar+1, new String (yytext()));}
"caja_texto"  {System.out.println("cajaTexto");               return new Symbol (simbolosCHTML.caja_texto, yyline+1,yychar+1, new String (yytext()));}
"fin-caja_texto"  {System.out.println("finCajaTExto");               return new Symbol (simbolosCHTML.finCaja_texto, yyline+1,yychar+1, new String (yytext()));}
"caja"  {System.out.println("caja");               return new Symbol (simbolosCHTML.caja, yyline+1,yychar+1, new String (yytext()));}
"fin-caja"  {System.out.println("finCaja");               return new Symbol (simbolosCHTML.finCaja, yyline+1,yychar+1, new String (yytext()));}
"opcion"  {System.out.println("opcion");               return new Symbol (simbolosCHTML.opcion, yyline+1,yychar+1, new String (yytext()));}
"fin-opcion"  {System.out.println("finOpcion");               return new Symbol (simbolosCHTML.finOpcion, yyline+1,yychar+1, new String (yytext()));}
"spinner"  {System.out.println("spinner");               return new Symbol (simbolosCHTML.spinner, yyline+1,yychar+1, new String (yytext()));}
"fin-spinner"  {System.out.println("finSpinner");               return new Symbol (simbolosCHTML.finSpinner, yyline+1,yychar+1, new String (yytext()));}
"salto-fin"  {System.out.println("saltofin");               return new Symbol (simbolosCHTML.saltoFin, yyline+1,yychar+1, new String (yytext()));}


"id"  {System.out.println("identificador");               return new Symbol (simbolosCHTML.id, yyline+1,yychar+1, new String (yytext()));}
"grupo"  {System.out.println("grupo");               return new Symbol (simbolosCHTML.grupo, yyline+1,yychar+1, new String (yytext()));}
"alto"  {System.out.println("alto");               return new Symbol (simbolosCHTML.alto, yyline+1,yychar+1, new String (yytext()));}
"ancho"  {System.out.println("anchod");               return new Symbol (simbolosCHTML.ancho, yyline+1,yychar+1, new String (yytext()));}
"alineado"  {System.out.println("alineado");               return new Symbol (simbolosCHTML.alineado, yyline+1,yychar+1, new String (yytext()));}

"valor"  {System.out.println("valor");               return new Symbol (simbolosCHTML.valor, yyline+1,yychar+1, new String (yytext()));}
"click"  {System.out.println("click");               return new Symbol (simbolosCHTML.click, yyline+1,yychar+1, new String (yytext()));}
"ruta"  {System.out.println("ruta");               return new Symbol (simbolosCHTML.ruta, yyline+1,yychar+1, new String (yytext()));}
"fondo"  {System.out.println("fondo");               return new Symbol (simbolosCHTML.fondo, yyline+1,yychar+1, new String (yytext()));}
"izquierda"  {System.out.println("izquierdo");               return new Symbol (simbolosCHTML.izquierda, yyline+1,yychar+1, new String (yytext()));}
"derecho"  {System.out.println("derecho");               return new Symbol (simbolosCHTML.derecha, yyline+1,yychar+1, new String (yytext()));}
"centrado"  {System.out.println("centrado");               return new Symbol (simbolosCHTML.centrado, yyline+1,yychar+1, new String (yytext()));}

"="  {System.out.println("igual");               return new Symbol (simbolosCHTML.igualSimb, yyline+1,yychar+1, new String (yytext()));}
";"  {System.out.println("puntoComa");               return new Symbol (simbolosCHTML.puntoComaSimb, yyline+1,yychar+1, new String (yytext()));}



/* -------------------------==: EXPRESIONES REGULARES :==---------------------*/


{cadena2}    {System.out.println("cadena2");                return new Symbol (simbolosCHTML.cadena2, yyline+1,yychar+1, new String (yytext()));}
{cadena}    {System.out.println("cadeba");                return new Symbol (simbolosCHTML.cadena, yyline+1,yychar+1, new String (yytext()));}
{numero}    {System.out.println("nu mero");                return new Symbol (simbolosCHTML.numero, yyline+1,yychar+1, new String (yytext()));}
{id}        {System.out.println("id");                return new Symbol (simbolosCHTML.identificador, yyline+1,yychar+1, new String (yytext()));}



/* -------------------------------==: BLANCOS :==-----------------------------*/
[ \t\r\f\n]+        { /* Se ignoran */}

/* --------------------------------==: ERROR :==------------------------------*/
/* Cualquier Otro */
.                      { ErrorScan(yyline,yychar,yytext()); }