/* ------------------------==: CODIGO DE USUARIO :==--------------------------*/

package proyecto1_201122872.AnalizadorCSS;
    

import java_cup.runtime.Symbol;
import java.io.*;
import java.lang.*;
import java.util.ArrayList;
import java.util.LinkedList;

%% 

/* ----------------------==: OPCIONES Y DECLARACIONES :==---------------------*/
%cupsym simbolosCSS
%class scannerCSS
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
letras              = [a-zA-ZÑñ_]
cadena              = [\"] ~[\"]
caracter            = "'"([0-9]|[a-zA-Z])"'"
id                  = {letras}({letras}|{numero} | "_")*

comentario_multi  		= "/*" ~"*/"
comentario_simple 		 = "//"[^\n]*



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
%%

/* -----------------------------==: COMENTARIOS  :==--------------------------*/
{comentario_multi}   {System.out.println("Coment Multi");   /* se ignora*/}
{comentario_simple}   {System.out.println("Coment simple");   /* se ignora*/}



/*------- Palabras reservadas -----------------*/


"id" {System.out.println("id");   return new Symbol (simbolosCSS.idTerminal, yyline+1,yychar+1, new String (yytext()));}
"grupo" {System.out.println("grupo");   return new Symbol (simbolosCSS.grupo, yyline+1,yychar+1, new String (yytext()));}
"alineado" {System.out.println("alineado");   return new Symbol (simbolosCSS.alineado, yyline+1,yychar+1, new String (yytext()));}
"texto" {System.out.println("texto");   return new Symbol (simbolosCSS.texto, yyline+1,yychar+1, new String (yytext()));}
"formato" {System.out.println("formato");   return new Symbol (simbolosCSS.formato, yyline+1,yychar+1, new String (yytext()));}
"letra" {System.out.println("letra");   return new Symbol (simbolosCSS.letra, yyline+1,yychar+1, new String (yytext()));}
"tamtex" {System.out.println("tamtex");   return new Symbol (simbolosCSS.tamtex, yyline+1,yychar+1, new String (yytext()));}
"colortext" {System.out.println("colortext");   return new Symbol (simbolosCSS.colortext, yyline+1,yychar+1, new String (yytext()));}
"fondoelemento" {System.out.println("fondoelemento");   return new Symbol (simbolosCSS.fondoelemento, yyline+1,yychar+1, new String (yytext()));}
"autoredimension" {System.out.println("autoredimension");   return new Symbol (simbolosCSS.autoredimension, yyline+1,yychar+1, new String (yytext()));}
"horizontal" {System.out.println("horizontal");   return new Symbol (simbolosCSS.horizontal, yyline+1,yychar+1, new String (yytext()));}
"vertical" {System.out.println("vertical");   return new Symbol (simbolosCSS.vertical, yyline+1,yychar+1, new String (yytext()));}
"visible" {System.out.println("visible");   return new Symbol (simbolosCSS.visible, yyline+1,yychar+1, new String (yytext()));}
"borde" {System.out.println("borde");   return new Symbol (simbolosCSS.borde, yyline+1,yychar+1, new String (yytext()));}
"opaque" {System.out.println("opaque");   return new Symbol (simbolosCSS.opaque, yyline+1,yychar+1, new String (yytext()));}
"izquierda" {System.out.println("izquierda");   return new Symbol (simbolosCSS.izquierda, yyline+1,yychar+1, new String (yytext()));}
"derecha" {System.out.println("derecha");   return new Symbol (simbolosCSS.derecha, yyline+1,yychar+1, new String (yytext()));}
"centrado" {System.out.println("centrado");   return new Symbol (simbolosCSS.centrado, yyline+1,yychar+1, new String (yytext()));}
"justificado" {System.out.println("justificado");   return new Symbol (simbolosCSS.justificado, yyline+1,yychar+1, new String (yytext()));}
"negrilla" {System.out.println("negrilla");   return new Symbol (simbolosCSS.negrilla, yyline+1,yychar+1, new String (yytext()));}
"cursiva" {System.out.println("cursiva");   return new Symbol (simbolosCSS.cursiva, yyline+1,yychar+1, new String (yytext()));}
"mayuscula" {System.out.println("mayuscula");   return new Symbol (simbolosCSS.mayuscula, yyline+1,yychar+1, new String (yytext()));}
"minuscula" {System.out.println("minuscula");   return new Symbol (simbolosCSS.minuscula, yyline+1,yychar+1, new String (yytext()));}
"capital-t" {System.out.println("capitalT");   return new Symbol (simbolosCSS.capitalT, yyline+1,yychar+1, new String (yytext()));}

"[" {System.out.println("abreCor");   return new Symbol (simbolosCSS.corAbre, yyline+1,yychar+1, new String (yytext()));}

"]" {System.out.println("cierraCor");   return new Symbol (simbolosCSS.corCierra, yyline+1,yychar+1, new String (yytext()));}

"=" {System.out.println("igual");   return new Symbol (simbolosCSS.igual, yyline+1,yychar+1, new String (yytext()));}


"(" {System.out.println("abrePAr");   return new Symbol (simbolosCSS.abrePar, yyline+1,yychar+1, new String (yytext()));}
")" {System.out.println("cierraPar");   return new Symbol (simbolosCSS.cierraPar, yyline+1,yychar+1, new String (yytext()));}
":" {System.out.println("dosPuntos");   return new Symbol (simbolosCSS.dosPuntos, yyline+1,yychar+1, new String (yytext()));}
";" {System.out.println("puntoComa");   return new Symbol (simbolosCSS.puntoComa, yyline+1,yychar+1, new String (yytext()));}

"," {System.out.println("coma");   return new Symbol (simbolosCSS.coma, yyline+1,yychar+1, new String (yytext()));}

"+" {System.out.println("mas");   return new Symbol (simbolosCSS.mas, yyline+1,yychar+1, new String (yytext()));}
"-" {System.out.println("menos");   return new Symbol (simbolosCSS.menos, yyline+1,yychar+1, new String (yytext()));}
"*" {System.out.println("multiplicacion");   return new Symbol (simbolosCSS.multiplicacion, yyline+1,yychar+1, new String (yytext()));}
"/" {System.out.println("division");   return new Symbol (simbolosCSS.division, yyline+1,yychar+1, new String (yytext()));}

"false"  {System.out.println("verdadero");               return new Symbol (simbolosCSS.booleano, yyline+1,yychar+1, new String (yytext()));}
"true"  {System.out.println("falso");               return new Symbol (simbolosCSS.booleano, yyline+1,yychar+1, new String (yytext()));}



/* -------------------------==: EXPRESIONES REGULARES :==---------------------*/



{cadena}    {System.out.println(yytext());                return new Symbol (simbolosCSS.cadena, yyline+1,yychar+1, new String (yytext()));}
{numero}    {System.out.println(yytext());                return new Symbol (simbolosCSS.numero, yyline+1,yychar+1, new String (yytext()));}
{id}        {System.out.println(yytext());                return new Symbol (simbolosCSS.id, yyline+1,yychar+1, new String (yytext()));}



/* -------------------------------==: BLANCOS :==-----------------------------*/


[ \t\r\f\n]+         { /* Se ignoran */}



/* --------------------------------==: ERROR :==------------------------------*/
/* Cualquier Otro */
.                      { ErrorScan(yyline,yychar,yytext()); }
