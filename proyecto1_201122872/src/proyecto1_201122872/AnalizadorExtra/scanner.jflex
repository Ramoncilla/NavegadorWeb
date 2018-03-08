
package proyecto1_201122872.AnalizadorExtra;
import java_cup.runtime.*;


%%

%{
    //Código de usuario
    

%}

%unicode
%caseless
%ignorecase
%cup
%public
%line
%column
%class scanner


entero              = [0-9]+
decimal             = [0-9]+("\."[0-9]+)+
letras              = [a-zA-ZÑñ_]

id                  = {letras}({letras}|{numero} | "_")*

SPACE   		= [\ \r\t\f\t]
ENTER   		= [\ \n]
comentML   		= "/*" ~"*/"
comentL 		 = "//"[^\n']+
numero 			= [0-9]+
cadena 		= [\"] ~[\"]
ptcoma			= ";"
dospts			= ":"
true_		= "true"
false_		= "false"



%xstate FUERA

%%option
"("        	{return new Symbol (sym.parabre, yyline+1,yychar+1, new String (yytext()));}
 ")"       	{return new Symbol (sym.parcierra, yyline+1,yychar+1, new String (yytext()));}
"*"        	{return new Symbol (sym.por, yyline+1,yychar+1, new String (yytext()));}

"+"        	{return new Symbol (sym.mas, yyline+1,yychar+1, new String (yytext()));}
"-"        	{return new Symbol (sym.men, yyline+1,yychar+1, new String (yytext()));}
"/"        	{return new Symbol (sym.div, yyline+1,yychar+1, new String (yytext()));}

","         {return new Symbol (sym.coma, yyline+1,yychar+1, new String (yytext()));}

"="        {return new Symbol (sym.igual, yyline+1,yychar+1, new String (yytext()));}
"["         {return new Symbol (sym.corcheteabre, yyline+1,yychar+1, new String (yytext()));}
"]"         {return new Symbol (sym.corchetecierra, yyline+1,yychar+1, new String (yytext()));}


"id"    		{return new Symbol (sym.terminalID, yyline+1,yychar+1, new String (yytext()));}
"grupo"    		{return new Symbol (sym.grupo, yyline+1,yychar+1, new String (yytext()));}
"alineado"    	{return new Symbol (sym.alineado, yyline+1,yychar+1, new String (yytext()));}
"texto"  		{return new Symbol (sym.texto, yyline+1,yychar+1, new String (yytext()));}
"formato"      	{return new Symbol (sym.formato, yyline+1,yychar+1, new String (yytext()));}
"letra"      	{return new Symbol (sym.letra, yyline+1,yychar+1, new String (yytext()));}
"tamtex"      	{return new Symbol (sym.tamtext, yyline+1,yychar+1, new String (yytext()));}
"colortext"     {return new Symbol (sym.colortext, yyline+1,yychar+1, new String (yytext()));}
"fondoelemento"	{return new Symbol (sym.fondoelemento, yyline+1,yychar+1, new String (yytext()));}
"autoredimension"	{return new Symbol (sym.autoredimension, yyline+1,yychar+1, new String (yytext()));}
"horizontal"	{return new Symbol (sym.horizontal, yyline+1,yychar+1, new String (yytext()));}
"vertical" 		{return new Symbol (sym.vertical, yyline+1,yychar+1, new String (yytext()));}
"visible"		{return new Symbol (sym.visible, yyline+1,yychar+1, new String (yytext()));}
"borde" 		{return new Symbol (sym.borde, yyline+1,yychar+1, new String (yytext()));}
"opaque" 		{return new Symbol (sym.opaque, yyline+1,yychar+1, new String (yytext()));}
"izquierda" 	{return new Symbol (sym.izquierda, yyline+1,yychar+1, new String (yytext()));}
"derecha" 		{return new Symbol (sym.derecha, yyline+1,yychar+1, new String (yytext()));}
"centrado" 		{return new Symbol (sym.centrado, yyline+1,yychar+1, new String (yytext()));}
"justificado"	{return new Symbol (sym.justificado, yyline+1,yychar+1, new String (yytext()));}
"negrilla" 		{return new Symbol (sym.negrilla, yyline+1,yychar+1, new String (yytext()));}
"cursiva" 		{return new Symbol (sym.cursiva, yyline+1,yychar+1, new String (yytext()));}
"mayuscula" 	{return new Symbol (sym.mayuscula, yyline+1,yychar+1, new String (yytext()));}
"minuscula" 	{return new Symbol (sym.minuscula, yyline+1,yychar+1, new String (yytext()));}
"capital-t" 	{return new Symbol (sym.capitalt, yyline+1,yychar+1, new String (yytext()));}

<YYINITIAL> {true_}            	{ return new Symbol(sym.booleano, yyline, yycolumn, yytext()); }
<YYINITIAL> {false_}            { return new Symbol(sym.booleano, yyline, yycolumn, yytext()); }

<YYINITIAL> {entero}         	{ return new Symbol(sym.numero, yyline, yycolumn, yytext()); }
<YYINITIAL> {decimal}         	{ return new Symbol(sym.numero, yyline, yycolumn, yytext()); }


<YYINITIAL> {ptcoma}           	{ return new Symbol(sym.ptcoma, yyline, yycolumn, yytext()); }
<YYINITIAL> {dospts}           	{ return new Symbol(sym.dospts, yyline, yycolumn, yytext()); }
<YYINITIAL> {id}            	{ return new Symbol(sym.id, yyline, yycolumn, yytext()); }
<YYINITIAL> {cadena}           { return new Symbol(sym.cadena, yyline, yycolumn, yytext()); }

 
<YYINITIAL>{SPACE}     		{ /*Espacios en blanco, ignorados*/ }
<YYINITIAL>{ENTER}     		{ /*Saltos de linea, ignorados*/}
<YYINITIAL>{comentML}      	{ /*Comentario Multi Línea Ignorado*/ }
<YYINITIAL>{comentL}      	{ /*Comentario Multi Línea Ignorado*/ }




. /*error lexico*/ 

								{
									String errLex = "Error léxico, caracter irreconocible: '"+yytext()+"' en la línea: "+(yyline+1)+" y columna: "+yycolumn;
									//System.err.println(errLex);
									System.out.println(errLex);
									
								}

