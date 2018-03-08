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
cadenaVector =({id}(".")("atexto"))
conteoVector =({id}(".")("conteo"))

idEtiqueta =({id}(".")("id"))
grupoEtiqueta =({id}(".")("grupo"))
altoEtiqueta =({id}(".")("alto"))
anchoEtiqueta =({id}(".")("ancho"))
alineadoEtiqueta =({id}(".")("alineado"))
bool_elemento=("true"|"false")
bool = (("'"{bool_elemento}"'")|("\""{bool_elemento}"\"")|({bool_elemento}))



comentario_multi  		= "'/" ~"/'"
comentario_simple 		 = "'"[^\n']+



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




/*------- Palabras reservadas -----------------*/

"'" {System.out.println("comillaSimple");   return new Symbol (simbolosCJS.comillaSimple, yyline+1,yychar+1, new String (yytext()));}
"dimv" {System.out.println("dimv");   return new Symbol (simbolosCJS.dimv, yyline+1,yychar+1, new String (yytext()));}
"{" {System.out.println("abreLlave");   return new Symbol (simbolosCJS.abreLlave, yyline+1,yychar+1, new String (yytext()));}
"}" {System.out.println("cierraLlave");   return new Symbol (simbolosCJS.cierraLlave, yyline+1,yychar+1, new String (yytext()));}
"(" {System.out.println("abrePar");   return new Symbol (simbolosCJS.abrePar, yyline+1,yychar+1, new String (yytext()));}
")" {System.out.println("cierraPar");   return new Symbol (simbolosCJS.cierraPar, yyline+1,yychar+1, new String (yytext()));}
":" {System.out.println("dosPuntos");   return new Symbol (simbolosCJS.dosPuntos, yyline+1,yychar+1, new String (yytext()));}
";" {System.out.println("puntoComa");   return new Symbol (simbolosCJS.puntoComa, yyline+1,yychar+1, new String (yytext()));}
"si" {System.out.println("si");   return new Symbol (simbolosCJS.si, yyline+1,yychar+1, new String (yytext()));}
"sino" {System.out.println("sino");   return new Symbol (simbolosCJS.sino, yyline+1,yychar+1, new String (yytext()));}
"caso" {System.out.println("caso");   return new Symbol (simbolosCJS.caso, yyline+1,yychar+1, new String (yytext()));}
"defecto" {System.out.println("defecto");   return new Symbol (simbolosCJS.defecto, yyline+1,yychar+1, new String (yytext()));}
"selecciona" {System.out.println("selecciona");   return new Symbol (simbolosCJS.selecciona, yyline+1,yychar+1, new String (yytext()));}
"para" {System.out.println("para");   return new Symbol (simbolosCJS.para, yyline+1,yychar+1, new String (yytext()));}
"mientras" {System.out.println("mientras");  return new Symbol (simbolosCJS.mientras, yyline+1,yychar+1, new String (yytext()));}
"detener" {System.out.println("detener");   return new Symbol (simbolosCJS.detener, yyline+1,yychar+1, new String (yytext()));}
"imprimir" {System.out.println("imprimir");   return new Symbol (simbolosCJS.imprimir, yyline+1,yychar+1, new String (yytext()));}
"retornar" {System.out.println("retornar");   return new Symbol (simbolosCJS.retornar, yyline+1,yychar+1, new String (yytext()));}
"funcion" {System.out.println("funcion");   return new Symbol (simbolosCJS.funcion, yyline+1,yychar+1, new String (yytext()));}
"," {System.out.println("coma");   return new Symbol (simbolosCJS.coma, yyline+1,yychar+1, new String (yytext()));}
"." {System.out.println("punto");   return new Symbol (simbolosCJS.punto, yyline+1,yychar+1, new String (yytext()));}
"mensaje" {System.out.println("mensaje");   return new Symbol (simbolosCJS.mensaje, yyline+1,yychar+1, new String (yytext()));}
"documento" {System.out.println("documento");   return new Symbol (simbolosCJS.documento, yyline+1,yychar+1, new String (yytext()));}
"obtener" {System.out.println("obtener");   return new Symbol (simbolosCJS.obtener, yyline+1,yychar+1, new String (yytext()));}
"setelemento" {System.out.println("setElemento");   return new Symbol (simbolosCJS.setelemento, yyline+1,yychar+1, new String (yytext()));}
"listo" {System.out.println("listo");   return new Symbol (simbolosCJS.listo, yyline+1,yychar+1, new String (yytext()));}
"modificado" {System.out.println("modificado");   return new Symbol (simbolosCJS.modificado, yyline+1,yychar+1, new String (yytext()));}
"cliqueado" {System.out.println("cliqueado");  return new Symbol (simbolosCJS.cliqueado, yyline+1,yychar+1, new String (yytext()));}
"observador" {System.out.println("observador");   return new Symbol (simbolosCJS.observador, yyline+1,yychar+1, new String (yytext()));}
"++" {System.out.println("masMas");   return new Symbol (simbolosCJS.masMas, yyline+1,yychar+1, new String (yytext()));}
"--" {System.out.println("menosMenos");   return new Symbol (simbolosCJS.menosMenos, yyline+1,yychar+1, new String (yytext()));}
"+" {System.out.println("mas");   return new Symbol (simbolosCJS.mas, yyline+1,yychar+1, new String (yytext()));}
"-" {System.out.println("menos");   return new Symbol (simbolosCJS.menos, yyline+1,yychar+1, new String (yytext()));}
"*" {System.out.println("multiplicacion");   return new Symbol (simbolosCJS.multiplicacion, yyline+1,yychar+1, new String (yytext()));}
"/" {System.out.println("division");   return new Symbol (simbolosCJS.division, yyline+1,yychar+1, new String (yytext()));}
"^" {System.out.println("potencia");   return new Symbol (simbolosCJS.potencia, yyline+1,yychar+1, new String (yytext()));}
"%" {System.out.println("residuo");   return new Symbol (simbolosCJS.residuo, yyline+1,yychar+1, new String (yytext()));}
"<"         {System.out.println("menor");  return new Symbol (simbolosCJS.menor, yyline+1,yychar+1, new String (yytext()));}
">"         {System.out.println("mayor");  return new Symbol (simbolosCJS.mayor, yyline+1,yychar+1, new String (yytext()));}
"<=" {System.out.println("menorIgual");   return new Symbol (simbolosCJS.menorIgual, yyline+1,yychar+1, new String (yytext()));}
">=" {System.out.println("mayorIgual");   return new Symbol (simbolosCJS.mayorIgual, yyline+1,yychar+1, new String (yytext()));}
"==" {System.out.println("igualIgual");   return new Symbol (simbolosCJS.igualIgual, yyline+1,yychar+1, new String (yytext()));}
"!=" {System.out.println("disitnoA");   return new Symbol (simbolosCJS.distintoA, yyline+1,yychar+1, new String (yytext()));}
"&&" {System.out.println("and");   return new Symbol (simbolosCJS.and, yyline+1,yychar+1, new String (yytext()));}
"||" {System.out.println("or");   return new Symbol (simbolosCJS.or, yyline+1,yychar+1, new String (yytext()));}
"!" {System.out.println("not");  return new Symbol (simbolosCJS.not, yyline+1,yychar+1, new String (yytext()));}
{bool}  {System.out.println("verdadero");               return new Symbol (simbolosCJS.valBool, yyline+1,yychar+1, new String (yytext()));}

"conteo" {System.out.println("conteo");   return new Symbol (simbolosCJS.conteo, yyline+1,yychar+1, new String (yytext()));}
"atexto" {System.out.println("atexto");  return new Symbol (simbolosCJS.atexto, yyline+1,yychar+1, new String (yytext()));}



/* -------------------------==: EXPRESIONES REGULARES :==---------------------*/

{cadenaVector}    {System.out.println("cadebaVEctor");                return new Symbol (simbolosCJS.cadenaVector, yyline+1,yychar+1, new String (yytext()));}
{conteoVector}    {System.out.println("conteroVEctor");                return new Symbol (simbolosCJS.conteoVector, yyline+1,yychar+1, new String (yytext()));}

{cadena}    {System.out.println(yytext());                return new Symbol (simbolosCJS.cadena, yyline+1,yychar+1, new String (yytext()));}
{numero}    {System.out.println(yytext());                return new Symbol (simbolosCJS.numero, yyline+1,yychar+1, new String (yytext()));}
{id}        {System.out.println(yytext());                return new Symbol (simbolosCJS.id, yyline+1,yychar+1, new String (yytext()));}


{comentario_multi}   {System.out.println("Coment Multi");   /* se ignora*/}
{comentario_simple}   {System.out.println("Coment simple");   /* se ignora*/}
/* -------------------------------==: BLANCOS :==-----------------------------*/
[ \t\r\f\n]+        { /* Se ignoran */}

/* --------------------------------==: ERROR :==------------------------------*/
/* Cualquier Otro */
.                      { ErrorScan(yyline,yychar,yytext()); }
