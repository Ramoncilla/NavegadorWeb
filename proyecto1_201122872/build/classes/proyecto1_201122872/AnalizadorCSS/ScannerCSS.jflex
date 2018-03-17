/* ------------------------==: CODIGO DE USUARIO :==--------------------------*/

package proyecto1_201122872.AnalizadorCSS;
    

import java_cup.runtime.*;
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

entero              = [0-9]+
decimal             = [0-9]+("\."[0-9]+)+
letras              = [a-zA-ZÑñ_]

id                  = {letras}({letras}|{numero} | "_")*

SPACE   		= [\ \r\t\f\t]
ENTER   		= [\ \n]
comentMulti   		= "/*" ~"*/"
comentSimple 		 = "//"[^\n']+
numero 			= [0-9]+
cadena 		= [\"] ~[\"]
ptcoma			= ";"
dospts			= ":"
trueVal		= "true"
falseVal		= "false"


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




%xstate FUERA

%%option
"("        	{System.out.println("abrePar"); return new Symbol (simbolosCSS.abrePar, yyline+1,yychar+1, new String (yytext()));}
 ")"       	{System.out.println(")");  return new Symbol (simbolosCSS.cierraPar, yyline+1,yychar+1, new String (yytext()));}
"*"        	{System.out.println("*");  return new Symbol (simbolosCSS.multiplicacion, yyline+1,yychar+1, new String (yytext()));}

"+"        	{System.out.println("+");  return new Symbol (simbolosCSS.mas, yyline+1,yychar+1, new String (yytext()));}
"-"        	{System.out.println("-");  return new Symbol (simbolosCSS.menos, yyline+1,yychar+1, new String (yytext()));}
"/"        	{System.out.println("/");  return new Symbol (simbolosCSS.division, yyline+1,yychar+1, new String (yytext()));}

","         {System.out.println(",");  return new Symbol (simbolosCSS.coma, yyline+1,yychar+1, new String (yytext()));}

"="        {System.out.println("=");  return new Symbol (simbolosCSS.igual, yyline+1,yychar+1, new String (yytext()));}
"["         {System.out.println("[");  return new Symbol (simbolosCSS.corAbre, yyline+1,yychar+1, new String (yytext()));}
"]"         {System.out.println("]");  return new Symbol (simbolosCSS.corCierra, yyline+1,yychar+1, new String (yytext()));}


"id"    		{System.out.println("idTerminal");  return new Symbol (simbolosCSS.idTerminal, yyline+1,yychar+1, new String (yytext()));}
"grupo"    		{System.out.println("grupo");  return new Symbol (simbolosCSS.grupo, yyline+1,yychar+1, new String (yytext()));}
"alineado"    	{System.out.println("alienado");  return new Symbol (simbolosCSS.alineado, yyline+1,yychar+1, new String (yytext()));}
"texto"  		{System.out.println("texto");  return new Symbol (simbolosCSS.texto, yyline+1,yychar+1, new String (yytext()));}
"formato"      	{System.out.println("formato");  return new Symbol (simbolosCSS.formato, yyline+1,yychar+1, new String (yytext()));}
"letra"      	{System.out.println("letra");  return new Symbol (simbolosCSS.letra, yyline+1,yychar+1, new String (yytext()));}
"tamtex"      	{System.out.println("tamtex");  return new Symbol (simbolosCSS.tamtex, yyline+1,yychar+1, new String (yytext()));}
"colortext"     {System.out.println("colortext");  return new Symbol (simbolosCSS.colortext, yyline+1,yychar+1, new String (yytext()));}
"fondoelemento"	{System.out.println("fondoElemento");  return new Symbol (simbolosCSS.fondoelemento, yyline+1,yychar+1, new String (yytext()));}
"autoredimension"	{System.out.println("autoredimension");  return new Symbol (simbolosCSS.autoredimension, yyline+1,yychar+1, new String (yytext()));}
"horizontal"	{System.out.println("horizontal");  return new Symbol (simbolosCSS.horizontal, yyline+1,yychar+1, new String (yytext()));}
"vertical" 		{System.out.println("vertical");  return new Symbol (simbolosCSS.vertical, yyline+1,yychar+1, new String (yytext()));}
"visible"		{System.out.println("visible");  return new Symbol (simbolosCSS.visible, yyline+1,yychar+1, new String (yytext()));}
"borde" 		{System.out.println("borde");  return new Symbol (simbolosCSS.borde, yyline+1,yychar+1, new String (yytext()));}
"opaque" 		{System.out.println("opaque");  return new Symbol (simbolosCSS.opaque, yyline+1,yychar+1, new String (yytext()));}
"izquierda" 	{System.out.println("izq");  return new Symbol (simbolosCSS.izquierda, yyline+1,yychar+1, new String (yytext()));}
"derecha" 		{System.out.println("derecha");  return new Symbol (simbolosCSS.derecha, yyline+1,yychar+1, new String (yytext()));}
"centrado" 		{System.out.println("centrado");  return new Symbol (simbolosCSS.centrado, yyline+1,yychar+1, new String (yytext()));}
"justificado"	{System.out.println("justi");  return new Symbol (simbolosCSS.justificado, yyline+1,yychar+1, new String (yytext()));}
"negrilla" 		{System.out.println("negrilla");  return new Symbol (simbolosCSS.negrilla, yyline+1,yychar+1, new String (yytext()));}
"cursiva" 		{System.out.println("cursiva");  return new Symbol (simbolosCSS.cursiva, yyline+1,yychar+1, new String (yytext()));}
"mayuscula" 	{System.out.println("mayuscula");  return new Symbol (simbolosCSS.mayuscula, yyline+1,yychar+1, new String (yytext()));}
"minuscula" 	{System.out.println("minuscula");  return new Symbol (simbolosCSS.minuscula, yyline+1,yychar+1, new String (yytext()));}
"capital-t" 	{System.out.println("capitalT");  return new Symbol (simbolosCSS.capitalT, yyline+1,yychar+1, new String (yytext()));}

<YYINITIAL> {trueVal}            	{System.out.println("true");  return new Symbol(simbolosCSS.booleano, yyline, yycolumn, yytext()); }
<YYINITIAL> {falseVal}            {System.out.println("false");  return new Symbol(simbolosCSS.booleano, yyline, yycolumn, yytext()); }

<YYINITIAL> {entero}         	{System.out.println("etero");  return new Symbol(simbolosCSS.numero, yyline, yycolumn, yytext()); }
<YYINITIAL> {decimal}         	{System.out.println("cdecimal");  return new Symbol(simbolosCSS.numero, yyline, yycolumn, yytext()); }


<YYINITIAL> {ptcoma}           	{System.out.println("puntoComa");  return new Symbol(simbolosCSS.puntoComa, yyline, yycolumn, yytext()); }
<YYINITIAL> {dospts}           	{System.out.println("dospuntos");  return new Symbol(simbolosCSS.dosPuntos, yyline, yycolumn, yytext()); }
<YYINITIAL> {id}            	{System.out.println("id");  return new Symbol(simbolosCSS.id, yyline, yycolumn, yytext()); }
<YYINITIAL> {cadena}           {System.out.println("cadena");  return new Symbol(simbolosCSS.cadena, yyline, yycolumn, yytext()); }

 
<YYINITIAL>{SPACE}     		{ /*Espacios en blanco, ignorados*/ }
<YYINITIAL>{ENTER}     		{ /*Saltos de linea, ignorados*/}
<YYINITIAL>{comentMulti}      	{ /*Comentario Multi Línea Ignorado*/ }
<YYINITIAL>{comentSimple}      	{ /*Comentario Multi Línea Ignorado*/ }




. /*error lexico*/ 

								{
									String errLex = "Error léxico, caracter irreconocible: '"+yytext()+"' en la línea: "+(yyline+1)+" y columna: "+yycolumn;
									//System.err.println(errLex);
									System.out.println(errLex);
									 ErrorScan(yyline,yychar,yytext());
									
								}


