
/* ------------------------==: CODIGO DE USUARIO :==--------------------------*/

package proyecto1_201122872.AnalizadorCJS;
    

import java_cup.runtime.Symbol;
import java.io.*;
import java.lang.*;
import java.util.ArrayList;
import java.util.LinkedList;

%% 

/* ----------------------==: OPCIONES Y DECLARACIONES :==---------------------*/
%cupsym simbolosCJS
%class scannerCJS
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
//cadena2   = (({id}|{numero}|\s ))(({id}|{numero}|\s )+)
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



"<"         {System.out.println("menor");              return new Symbol (simbolosCJS.menor, yyline+1,yychar+1, new String (yytext()));}
">"         {System.out.println("mayor");              return new Symbol (simbolosCJS.mayor, yyline+1,yychar+1, new String (yytext()));}



"="  {System.out.println("igual");               return new Symbol (simbolosCJS.igualSimb, yyline+1,yychar+1, new String (yytext()));}
";"  {System.out.println("puntoComa");               return new Symbol (simbolosCJS.puntoComaSimb, yyline+1,yychar+1, new String (yytext()));}



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