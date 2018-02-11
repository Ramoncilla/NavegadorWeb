
//----------------------------------------------------
// The following code was generated by CUP v0.10k
// Sun Feb 11 14:21:16 CST 2018
//----------------------------------------------------

package proyecto1_201122872.AnalizadorCHTML;

import proyecto1_201122872.AnalizadorCHTML.simbolosCHTML;
import java_cup.runtime.*;
import java.io.*;
import java.lang.*;
import java.util.*;
import java.util.ArrayList;

/** CUP v0.10k generated parser.
  * @version Sun Feb 11 14:21:16 CST 2018
  */
public class Parser extends java_cup.runtime.lr_parser {

  /** Default constructor. */
  public Parser() {super();}

  /** Constructor which sets the default scanner. */
  public Parser(java_cup.runtime.Scanner s) {super(s);}

  /** Production table. */
  protected static final short _production_table[][] = 
    unpackFromStrings(new String[] {
    "\000\026\000\002\020\006\000\002\002\004\000\002\012" +
    "\006\000\002\013\006\000\002\014\006\000\002\015\006" +
    "\000\002\016\006\000\002\017\006\000\002\024\003\000" +
    "\002\024\003\000\002\024\003\000\002\024\003\000\002" +
    "\024\003\000\002\024\003\000\002\025\004\000\002\025" +
    "\003\000\002\026\005\000\002\026\006\000\002\027\005" +
    "\000\002\030\005\000\002\030\006\000\002\031\005" });

  /** Access to production table. */
  public short[][] production_table() {return _production_table;}

  /** Parse-action table. */
  protected static final short[][] _action_table = 
    unpackFromStrings(new String[] {
    "\000\007\000\004\066\005\001\002\000\004\002\011\001" +
    "\002\000\004\073\006\001\002\000\004\076\007\001\002" +
    "\000\004\074\010\001\002\000\004\002\001\001\002\000" +
    "\004\002\000\001\002" });

  /** Access to parse-action table. */
  public short[][] action_table() {return _action_table;}

  /** <code>reduce_goto</code> table. */
  protected static final short[][] _reduce_table = 
    unpackFromStrings(new String[] {
    "\000\007\000\004\020\003\001\001\000\002\001\001\000" +
    "\002\001\001\000\002\001\001\000\002\001\001\000\002" +
    "\001\001\000\002\001\001" });

  /** Access to <code>reduce_goto</code> table. */
  public short[][] reduce_table() {return _reduce_table;}

  /** Instance of action encapsulation class. */
  protected CUP$Parser$actions action_obj;

  /** Action encapsulation object initializer. */
  protected void init_actions()
    {
      action_obj = new CUP$Parser$actions(this);
    }

  /** Invoke a user supplied parse action. */
  public java_cup.runtime.Symbol do_action(
    int                        act_num,
    java_cup.runtime.lr_parser parser,
    java.util.Stack            stack,
    int                        top)
    throws java.lang.Exception
  {
    /* call code in generated class */
    return action_obj.CUP$Parser$do_action(act_num, parser, stack, top);
  }

  /** Indicates start state. */
  public int start_state() {return 0;}
  /** Indicates start production. */
  public int start_production() {return 1;}

  /** <code>EOF</code> Symbol index. */
  public int EOF_sym() {return 0;}

  /** <code>error</code> Symbol index. */
  public int error_sym() {return 1;}



 /* -------------------------==: DECLARAR EL ARBOL :==--------------------------*/
    //public Nodo Gramaticas;     
    public static String cadena;

/* -------------------------==: ERROR SINTACTICO :==--------------------------*/
public void syntax_error(Symbol s){
    System.out.println("Error Sintactico -> lexema: " +s.value+" Linea: " +s.right+ " Columna: "+s.left);
    cadena += "<tr>"
                + "<td><center><b>" + s.value + "</b></center></td>"
                + "<td><center><b>" + s.right + "</b></center></td>"
                + "<td><center><b>" + s.left+ "</b></center></td>"
                + "</tr>";
}

/* ------------------==: ERROR SINTACTICO NO RECUPERABLE :==------------------*/
public void unrecovered_syntax_error(Symbol s) throws java.lang.Exception{
    System.out.println("Error Sintactico No Recuperable-> Lexema: " +s.value+" Linea: "+s.right+ " Columna: "+s.left);
     cadena += "<tr>"
                + "<td><center><b>" + s.value + "</b></center></td>"
                + "<td><center><b>" + s.right + "</b></center></td>"
                + "<td><center><b>" + s.left+ "</b></center></td>"
                + "</tr>";
}


}

/** Cup generated class to encapsulate user supplied action code.*/
class CUP$Parser$actions {


//Operaciones_Listas operaciones = new Operaciones_Listas();


  private final Parser parser;

  /** Constructor */
  CUP$Parser$actions(Parser parser) {
    this.parser = parser;
  }

  /** Method with the actual generated action code. */
  public final java_cup.runtime.Symbol CUP$Parser$do_action(
    int                        CUP$Parser$act_num,
    java_cup.runtime.lr_parser CUP$Parser$parser,
    java.util.Stack            CUP$Parser$stack,
    int                        CUP$Parser$top)
    throws java.lang.Exception
    {
      /* Symbol object for return from actions */
      java_cup.runtime.Symbol CUP$Parser$result;

      /* select the action based on the action number */
      switch (CUP$Parser$act_num)
        {
          /*. . . . . . . . . . . . . . . . . . . .*/
          case 21: // tagFinChtml ::= menor finChtml mayor 
            {
              Object RESULT = null;

              CUP$Parser$result = new java_cup.runtime.Symbol(23/*tagFinChtml*/, ((java_cup.runtime.Symbol)CUP$Parser$stack.elementAt(CUP$Parser$top-2)).left, ((java_cup.runtime.Symbol)CUP$Parser$stack.elementAt(CUP$Parser$top-0)).right, RESULT);
            }
          return CUP$Parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 20: // tagChtml ::= menor chtml listaPropiedadesGenerales mayor 
            {
              Object RESULT = null;

              CUP$Parser$result = new java_cup.runtime.Symbol(22/*tagChtml*/, ((java_cup.runtime.Symbol)CUP$Parser$stack.elementAt(CUP$Parser$top-3)).left, ((java_cup.runtime.Symbol)CUP$Parser$stack.elementAt(CUP$Parser$top-0)).right, RESULT);
            }
          return CUP$Parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 19: // tagChtml ::= menor chtml mayor 
            {
              Object RESULT = null;

              CUP$Parser$result = new java_cup.runtime.Symbol(22/*tagChtml*/, ((java_cup.runtime.Symbol)CUP$Parser$stack.elementAt(CUP$Parser$top-2)).left, ((java_cup.runtime.Symbol)CUP$Parser$stack.elementAt(CUP$Parser$top-0)).right, RESULT);
            }
          return CUP$Parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 18: // tagFinEncabezado ::= menor finEncabezado mayor 
            {
              Object RESULT = null;

              CUP$Parser$result = new java_cup.runtime.Symbol(21/*tagFinEncabezado*/, ((java_cup.runtime.Symbol)CUP$Parser$stack.elementAt(CUP$Parser$top-2)).left, ((java_cup.runtime.Symbol)CUP$Parser$stack.elementAt(CUP$Parser$top-0)).right, RESULT);
            }
          return CUP$Parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 17: // tagEncabezado ::= menor encabezado listaPropiedadesGenerales mayor 
            {
              Object RESULT = null;

              CUP$Parser$result = new java_cup.runtime.Symbol(20/*tagEncabezado*/, ((java_cup.runtime.Symbol)CUP$Parser$stack.elementAt(CUP$Parser$top-3)).left, ((java_cup.runtime.Symbol)CUP$Parser$stack.elementAt(CUP$Parser$top-0)).right, RESULT);
            }
          return CUP$Parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 16: // tagEncabezado ::= menor encabezado mayor 
            {
              Object RESULT = null;

              CUP$Parser$result = new java_cup.runtime.Symbol(20/*tagEncabezado*/, ((java_cup.runtime.Symbol)CUP$Parser$stack.elementAt(CUP$Parser$top-2)).left, ((java_cup.runtime.Symbol)CUP$Parser$stack.elementAt(CUP$Parser$top-0)).right, RESULT);
            }
          return CUP$Parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 15: // listaPropiedadesGenerales ::= propiedadGeneral 
            {
              Object RESULT = null;

              CUP$Parser$result = new java_cup.runtime.Symbol(19/*listaPropiedadesGenerales*/, ((java_cup.runtime.Symbol)CUP$Parser$stack.elementAt(CUP$Parser$top-0)).left, ((java_cup.runtime.Symbol)CUP$Parser$stack.elementAt(CUP$Parser$top-0)).right, RESULT);
            }
          return CUP$Parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 14: // listaPropiedadesGenerales ::= listaPropiedadesGenerales propiedadGeneral 
            {
              Object RESULT = null;

              CUP$Parser$result = new java_cup.runtime.Symbol(19/*listaPropiedadesGenerales*/, ((java_cup.runtime.Symbol)CUP$Parser$stack.elementAt(CUP$Parser$top-1)).left, ((java_cup.runtime.Symbol)CUP$Parser$stack.elementAt(CUP$Parser$top-0)).right, RESULT);
            }
          return CUP$Parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 13: // propiedadGeneral ::= ccssPropiedad 
            {
              Object RESULT = null;

              CUP$Parser$result = new java_cup.runtime.Symbol(18/*propiedadGeneral*/, ((java_cup.runtime.Symbol)CUP$Parser$stack.elementAt(CUP$Parser$top-0)).left, ((java_cup.runtime.Symbol)CUP$Parser$stack.elementAt(CUP$Parser$top-0)).right, RESULT);
            }
          return CUP$Parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 12: // propiedadGeneral ::= alineadoPropiedad 
            {
              Object RESULT = null;

              CUP$Parser$result = new java_cup.runtime.Symbol(18/*propiedadGeneral*/, ((java_cup.runtime.Symbol)CUP$Parser$stack.elementAt(CUP$Parser$top-0)).left, ((java_cup.runtime.Symbol)CUP$Parser$stack.elementAt(CUP$Parser$top-0)).right, RESULT);
            }
          return CUP$Parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 11: // propiedadGeneral ::= anchoPropiedad 
            {
              Object RESULT = null;

              CUP$Parser$result = new java_cup.runtime.Symbol(18/*propiedadGeneral*/, ((java_cup.runtime.Symbol)CUP$Parser$stack.elementAt(CUP$Parser$top-0)).left, ((java_cup.runtime.Symbol)CUP$Parser$stack.elementAt(CUP$Parser$top-0)).right, RESULT);
            }
          return CUP$Parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 10: // propiedadGeneral ::= altoPropiedad 
            {
              Object RESULT = null;

              CUP$Parser$result = new java_cup.runtime.Symbol(18/*propiedadGeneral*/, ((java_cup.runtime.Symbol)CUP$Parser$stack.elementAt(CUP$Parser$top-0)).left, ((java_cup.runtime.Symbol)CUP$Parser$stack.elementAt(CUP$Parser$top-0)).right, RESULT);
            }
          return CUP$Parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 9: // propiedadGeneral ::= grupoPropiedad 
            {
              Object RESULT = null;

              CUP$Parser$result = new java_cup.runtime.Symbol(18/*propiedadGeneral*/, ((java_cup.runtime.Symbol)CUP$Parser$stack.elementAt(CUP$Parser$top-0)).left, ((java_cup.runtime.Symbol)CUP$Parser$stack.elementAt(CUP$Parser$top-0)).right, RESULT);
            }
          return CUP$Parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 8: // propiedadGeneral ::= idPropiedad 
            {
              Object RESULT = null;

              CUP$Parser$result = new java_cup.runtime.Symbol(18/*propiedadGeneral*/, ((java_cup.runtime.Symbol)CUP$Parser$stack.elementAt(CUP$Parser$top-0)).left, ((java_cup.runtime.Symbol)CUP$Parser$stack.elementAt(CUP$Parser$top-0)).right, RESULT);
            }
          return CUP$Parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 7: // ccssPropiedad ::= ccss igualSimb expresion puntoComaSimb 
            {
              Object RESULT = null;

              CUP$Parser$result = new java_cup.runtime.Symbol(13/*ccssPropiedad*/, ((java_cup.runtime.Symbol)CUP$Parser$stack.elementAt(CUP$Parser$top-3)).left, ((java_cup.runtime.Symbol)CUP$Parser$stack.elementAt(CUP$Parser$top-0)).right, RESULT);
            }
          return CUP$Parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 6: // alineadoPropiedad ::= alineado igualSimb expresion puntoComaSimb 
            {
              Object RESULT = null;

              CUP$Parser$result = new java_cup.runtime.Symbol(12/*alineadoPropiedad*/, ((java_cup.runtime.Symbol)CUP$Parser$stack.elementAt(CUP$Parser$top-3)).left, ((java_cup.runtime.Symbol)CUP$Parser$stack.elementAt(CUP$Parser$top-0)).right, RESULT);
            }
          return CUP$Parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 5: // anchoPropiedad ::= ancho igualSimb expresion puntoComaSimb 
            {
              Object RESULT = null;

              CUP$Parser$result = new java_cup.runtime.Symbol(11/*anchoPropiedad*/, ((java_cup.runtime.Symbol)CUP$Parser$stack.elementAt(CUP$Parser$top-3)).left, ((java_cup.runtime.Symbol)CUP$Parser$stack.elementAt(CUP$Parser$top-0)).right, RESULT);
            }
          return CUP$Parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 4: // altoPropiedad ::= alto igualSimb expresion puntoComaSimb 
            {
              Object RESULT = null;

              CUP$Parser$result = new java_cup.runtime.Symbol(10/*altoPropiedad*/, ((java_cup.runtime.Symbol)CUP$Parser$stack.elementAt(CUP$Parser$top-3)).left, ((java_cup.runtime.Symbol)CUP$Parser$stack.elementAt(CUP$Parser$top-0)).right, RESULT);
            }
          return CUP$Parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 3: // grupoPropiedad ::= grupo igualSimb expresion puntoComaSimb 
            {
              Object RESULT = null;

              CUP$Parser$result = new java_cup.runtime.Symbol(9/*grupoPropiedad*/, ((java_cup.runtime.Symbol)CUP$Parser$stack.elementAt(CUP$Parser$top-3)).left, ((java_cup.runtime.Symbol)CUP$Parser$stack.elementAt(CUP$Parser$top-0)).right, RESULT);
            }
          return CUP$Parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 2: // idPropiedad ::= id igualSimb expresion puntoComaSimb 
            {
              Object RESULT = null;

              CUP$Parser$result = new java_cup.runtime.Symbol(8/*idPropiedad*/, ((java_cup.runtime.Symbol)CUP$Parser$stack.elementAt(CUP$Parser$top-3)).left, ((java_cup.runtime.Symbol)CUP$Parser$stack.elementAt(CUP$Parser$top-0)).right, RESULT);
            }
          return CUP$Parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 1: // $START ::= rutaPropiedad EOF 
            {
              Object RESULT = null;
		int start_valleft = ((java_cup.runtime.Symbol)CUP$Parser$stack.elementAt(CUP$Parser$top-1)).left;
		int start_valright = ((java_cup.runtime.Symbol)CUP$Parser$stack.elementAt(CUP$Parser$top-1)).right;
		Object start_val = (Object)((java_cup.runtime.Symbol) CUP$Parser$stack.elementAt(CUP$Parser$top-1)).value;
		RESULT = start_val;
              CUP$Parser$result = new java_cup.runtime.Symbol(0/*$START*/, ((java_cup.runtime.Symbol)CUP$Parser$stack.elementAt(CUP$Parser$top-1)).left, ((java_cup.runtime.Symbol)CUP$Parser$stack.elementAt(CUP$Parser$top-0)).right, RESULT);
            }
          /* ACCEPT */
          CUP$Parser$parser.done_parsing();
          return CUP$Parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 0: // rutaPropiedad ::= ruta igualSimb cadena puntoComaSimb 
            {
              Object RESULT = null;

              CUP$Parser$result = new java_cup.runtime.Symbol(14/*rutaPropiedad*/, ((java_cup.runtime.Symbol)CUP$Parser$stack.elementAt(CUP$Parser$top-3)).left, ((java_cup.runtime.Symbol)CUP$Parser$stack.elementAt(CUP$Parser$top-0)).right, RESULT);
            }
          return CUP$Parser$result;

          /* . . . . . .*/
          default:
            throw new Exception(
               "Invalid action number found in internal parse table");

        }
    }
}

