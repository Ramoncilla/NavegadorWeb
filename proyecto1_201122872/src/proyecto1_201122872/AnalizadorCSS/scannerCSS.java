/* The following code was generated by JFlex 1.4.3 on 3/8/18 2:44 PM */

/* ------------------------==: CODIGO DE USUARIO :==--------------------------*/

package proyecto1_201122872.AnalizadorCSS;
    

import java_cup.runtime.*;
import java.io.*;
import java.lang.*;
import java.util.ArrayList;
import java.util.LinkedList;


/**
 * This class is a scanner generated by 
 * <a href="http://www.jflex.de/">JFlex</a> 1.4.3
 * on 3/8/18 2:44 PM from the specification file
 * <tt>ScannerCSS.jflex</tt>
 */
public class scannerCSS implements java_cup.runtime.Scanner {

  /** This character denotes the end of file */
  public static final int YYEOF = -1;

  /** initial size of the lookahead buffer */
  private static final int ZZ_BUFFERSIZE = 16384;

  /** lexical states */
  public static final int YYINITIAL = 0;
  public static final int FUERA = 2;

  /**
   * ZZ_LEXSTATE[l] is the state in the DFA for the lexical state l
   * ZZ_LEXSTATE[l+1] is the state in the DFA for the lexical state l
   *                  at the beginning of a line
   * l is of the form l = 2*k, k a non negative integer
   */
  private static final int ZZ_LEXSTATE[] = { 
     0,  0,  1, 1
  };

  /** 
   * Translates characters to character classes
   */
  private static final String ZZ_CMAP_PACKED = 
    "\11\0\1\4\1\5\1\0\2\4\22\0\1\4\1\0\1\11\4\0"+
    "\1\10\1\24\1\25\1\7\1\26\1\30\1\27\1\2\1\6\12\1"+
    "\1\13\1\12\1\0\1\31\3\0\1\21\1\50\1\44\1\35\1\17"+
    "\1\20\1\36\1\45\1\34\1\52\1\3\1\22\1\43\1\41\1\40"+
    "\1\37\1\51\1\15\1\23\1\14\1\16\1\47\1\3\1\42\1\53"+
    "\1\46\1\32\1\0\1\33\1\0\1\3\1\0\1\21\1\50\1\44"+
    "\1\35\1\17\1\20\1\36\1\45\1\34\1\52\1\3\1\22\1\43"+
    "\1\41\1\40\1\37\1\51\1\15\1\23\1\14\1\16\1\47\1\3"+
    "\1\42\1\53\1\46\66\0\1\3\21\0\1\3\u1f54\0\1\3\udfe7\0";

  /** 
   * Translates characters to character classes
   */
  private static final char [] ZZ_CMAP = zzUnpackCMap(ZZ_CMAP_PACKED);

  /** 
   * Translates DFA states to action switch labels.
   */
  private static final int [] ZZ_ACTION = zzUnpackAction();

  private static final String ZZ_ACTION_PACKED_0 =
    "\2\0\1\1\1\2\1\3\1\4\1\5\1\6\1\7"+
    "\1\1\1\10\1\11\4\3\1\12\1\13\1\14\1\15"+
    "\1\16\1\17\1\20\1\21\13\3\4\0\1\22\10\3"+
    "\1\23\20\3\1\24\1\25\1\0\31\3\1\25\1\26"+
    "\30\3\1\27\1\3\1\30\4\3\1\31\2\3\1\32"+
    "\13\3\1\33\1\3\1\34\6\3\1\35\13\3\1\36"+
    "\4\3\1\37\3\3\1\40\5\3\1\41\3\3\1\42"+
    "\1\3\1\43\2\3\1\44\1\0\2\3\1\45\3\3"+
    "\1\46\1\47\1\50\1\51\1\52\4\3\1\53\3\3"+
    "\1\54\2\3\1\55\2\3\1\56";

  private static int [] zzUnpackAction() {
    int [] result = new int[214];
    int offset = 0;
    offset = zzUnpackAction(ZZ_ACTION_PACKED_0, offset, result);
    return result;
  }

  private static int zzUnpackAction(String packed, int offset, int [] result) {
    int i = 0;       /* index in packed string  */
    int j = offset;  /* index in unpacked array */
    int l = packed.length();
    while (i < l) {
      int count = packed.charAt(i++);
      int value = packed.charAt(i++);
      do result[j++] = value; while (--count > 0);
    }
    return j;
  }


  /** 
   * Translates a state to a row index in the transition table
   */
  private static final int [] ZZ_ROWMAP = zzUnpackRowMap();

  private static final String ZZ_ROWMAP_PACKED_0 =
    "\0\0\0\54\0\54\0\130\0\204\0\54\0\54\0\260"+
    "\0\54\0\334\0\54\0\54\0\u0108\0\u0134\0\u0160\0\u018c"+
    "\0\54\0\54\0\54\0\54\0\54\0\54\0\54\0\54"+
    "\0\u01b8\0\u01e4\0\u0210\0\u023c\0\u0268\0\u0294\0\u02c0\0\u02ec"+
    "\0\u0318\0\u0344\0\u0370\0\u039c\0\u03c8\0\u03f4\0\334\0\54"+
    "\0\u0420\0\u044c\0\u0478\0\u04a4\0\u04d0\0\u04fc\0\u0528\0\u0554"+
    "\0\204\0\u0580\0\u05ac\0\u05d8\0\u0604\0\u0630\0\u065c\0\u0688"+
    "\0\u06b4\0\u06e0\0\u070c\0\u0738\0\u0764\0\u0790\0\u07bc\0\u07e8"+
    "\0\u0814\0\u0840\0\u03c8\0\u086c\0\u0898\0\u08c4\0\u08f0\0\u091c"+
    "\0\u0948\0\u0974\0\u09a0\0\u09cc\0\u09f8\0\u0a24\0\u0a50\0\u0a7c"+
    "\0\u0aa8\0\u0ad4\0\u0b00\0\u0b2c\0\u0b58\0\u0b84\0\u0bb0\0\u0bdc"+
    "\0\u0c08\0\u0c34\0\u0c60\0\u0c8c\0\u0cb8\0\54\0\204\0\u0ce4"+
    "\0\u0d10\0\u0d3c\0\u0d68\0\u0d94\0\u0dc0\0\u0dec\0\u0e18\0\u0e44"+
    "\0\u0e70\0\u0e9c\0\u0ec8\0\u0ef4\0\u0f20\0\u0f4c\0\u0f78\0\u0fa4"+
    "\0\u0fd0\0\u0ffc\0\u1028\0\u1054\0\u1080\0\u10ac\0\u10d8\0\204"+
    "\0\u1104\0\204\0\u1130\0\u115c\0\u1188\0\u11b4\0\204\0\u11e0"+
    "\0\u120c\0\204\0\u1238\0\u1264\0\u1290\0\u12bc\0\u12e8\0\u1314"+
    "\0\u1340\0\u136c\0\u1398\0\u13c4\0\u13f0\0\204\0\u141c\0\204"+
    "\0\u1448\0\u1474\0\u14a0\0\u14cc\0\u14f8\0\u1524\0\204\0\u1550"+
    "\0\u157c\0\u15a8\0\u15d4\0\u1600\0\u162c\0\u1658\0\u1684\0\u16b0"+
    "\0\u16dc\0\u1708\0\204\0\u1734\0\u1760\0\u178c\0\u17b8\0\204"+
    "\0\u17e4\0\u1810\0\u183c\0\204\0\u1868\0\u1894\0\u18c0\0\u18ec"+
    "\0\u1918\0\204\0\u1944\0\u1970\0\u199c\0\204\0\u19c8\0\204"+
    "\0\u19f4\0\u1a20\0\204\0\u1a4c\0\u1a78\0\u1aa4\0\204\0\u1ad0"+
    "\0\u1afc\0\u1b28\0\204\0\204\0\204\0\54\0\204\0\u1b54"+
    "\0\u1b80\0\u1bac\0\u1bd8\0\204\0\u1c04\0\u1c30\0\u1c5c\0\204"+
    "\0\u1c88\0\u1cb4\0\204\0\u1ce0\0\u1d0c\0\204";

  private static int [] zzUnpackRowMap() {
    int [] result = new int[214];
    int offset = 0;
    offset = zzUnpackRowMap(ZZ_ROWMAP_PACKED_0, offset, result);
    return result;
  }

  private static int zzUnpackRowMap(String packed, int offset, int [] result) {
    int i = 0;  /* index in packed string  */
    int j = offset;  /* index in unpacked array */
    int l = packed.length();
    while (i < l) {
      int high = packed.charAt(i++) << 16;
      result[j++] = high | packed.charAt(i++);
    }
    return j;
  }

  /** 
   * The transition table of the DFA
   */
  private static final int [] ZZ_TRANS = zzUnpackTrans();

  private static final String ZZ_TRANS_PACKED_0 =
    "\1\3\1\4\1\3\1\5\1\6\1\7\1\10\1\11"+
    "\1\3\1\12\1\13\1\14\1\15\3\5\1\16\1\17"+
    "\1\20\1\5\1\21\1\22\1\23\1\24\1\25\1\26"+
    "\1\27\1\30\1\31\1\32\1\33\1\5\1\34\1\35"+
    "\1\5\1\36\1\37\1\40\1\5\1\41\1\42\1\5"+
    "\1\43\1\5\55\0\1\4\1\44\52\0\1\5\1\0"+
    "\1\5\10\0\10\5\10\0\20\5\6\0\1\45\1\46"+
    "\44\0\11\47\1\50\42\47\1\0\1\5\1\0\1\5"+
    "\10\0\1\5\1\51\1\5\1\52\1\5\1\53\2\5"+
    "\10\0\20\5\1\0\1\5\1\0\1\5\10\0\5\5"+
    "\1\54\2\5\10\0\4\5\1\55\13\5\1\0\1\5"+
    "\1\0\1\5\10\0\2\5\1\56\3\5\1\57\1\5"+
    "\10\0\20\5\1\0\1\5\1\0\1\5\10\0\3\5"+
    "\1\60\4\5\10\0\20\5\1\0\1\5\1\0\1\5"+
    "\10\0\10\5\10\0\1\5\1\61\10\5\1\62\5\5"+
    "\1\0\1\5\1\0\1\5\10\0\3\5\1\63\4\5"+
    "\10\0\20\5\1\0\1\5\1\0\1\5\10\0\1\5"+
    "\1\64\6\5\10\0\20\5\1\0\1\5\1\0\1\5"+
    "\10\0\10\5\10\0\3\5\1\65\14\5\1\0\1\5"+
    "\1\0\1\5\10\0\3\5\1\66\4\5\10\0\20\5"+
    "\1\0\1\5\1\0\1\5\10\0\5\5\1\67\2\5"+
    "\10\0\1\70\17\5\1\0\1\5\1\0\1\5\10\0"+
    "\2\5\1\71\1\72\1\5\1\73\2\5\10\0\4\5"+
    "\1\74\13\5\1\0\1\5\1\0\1\5\10\0\10\5"+
    "\10\0\4\5\1\75\13\5\1\0\1\5\1\0\1\5"+
    "\10\0\3\5\1\76\4\5\10\0\1\77\17\5\1\0"+
    "\1\5\1\0\1\5\10\0\10\5\10\0\4\5\1\100"+
    "\13\5\1\0\1\5\1\0\1\5\10\0\2\5\1\101"+
    "\5\5\10\0\20\5\1\0\1\102\52\0\5\103\1\0"+
    "\2\103\1\0\43\103\7\46\1\104\44\46\1\0\1\5"+
    "\1\0\1\5\10\0\2\5\1\105\5\5\10\0\20\5"+
    "\1\0\1\5\1\0\1\5\10\0\10\5\10\0\6\5"+
    "\1\106\11\5\1\0\1\5\1\0\1\5\10\0\10\5"+
    "\10\0\7\5\1\107\10\5\1\0\1\5\1\0\1\5"+
    "\10\0\6\5\1\110\1\5\10\0\20\5\1\0\1\5"+
    "\1\0\1\5\10\0\1\5\1\111\6\5\10\0\5\5"+
    "\1\112\12\5\1\0\1\5\1\0\1\5\10\0\1\113"+
    "\7\5\10\0\20\5\1\0\1\5\1\0\1\5\10\0"+
    "\10\5\10\0\1\114\17\5\1\0\1\5\1\0\1\5"+
    "\10\0\1\115\7\5\10\0\20\5\1\0\1\5\1\0"+
    "\1\5\10\0\10\5\10\0\15\5\1\116\2\5\1\0"+
    "\1\5\1\0\1\5\10\0\1\5\1\117\6\5\10\0"+
    "\20\5\1\0\1\5\1\0\1\5\10\0\2\5\1\120"+
    "\5\5\10\0\20\5\1\0\1\5\1\0\1\5\10\0"+
    "\5\5\1\121\2\5\10\0\20\5\1\0\1\5\1\0"+
    "\1\5\10\0\10\5\10\0\2\5\1\122\15\5\1\0"+
    "\1\5\1\0\1\5\10\0\10\5\10\0\17\5\1\123"+
    "\1\0\1\5\1\0\1\5\10\0\10\5\10\0\5\5"+
    "\1\124\12\5\1\0\1\5\1\0\1\5\10\0\1\5"+
    "\1\125\6\5\10\0\20\5\1\0\1\5\1\0\1\5"+
    "\10\0\10\5\10\0\5\5\1\126\12\5\1\0\1\5"+
    "\1\0\1\5\10\0\10\5\10\0\3\5\1\127\14\5"+
    "\1\0\1\5\1\0\1\5\10\0\6\5\1\130\1\5"+
    "\10\0\20\5\1\0\1\5\1\0\1\5\10\0\1\5"+
    "\1\131\6\5\10\0\20\5\1\0\1\5\1\0\1\5"+
    "\10\0\1\5\1\132\6\5\10\0\20\5\1\0\1\5"+
    "\1\0\1\5\10\0\7\5\1\133\10\0\20\5\1\0"+
    "\1\5\1\0\1\5\10\0\1\5\1\134\6\5\10\0"+
    "\20\5\1\0\1\5\1\0\1\5\10\0\7\5\1\135"+
    "\10\0\20\5\1\0\1\102\1\44\51\0\6\46\1\136"+
    "\1\104\44\46\1\0\1\5\1\0\1\5\10\0\3\5"+
    "\1\137\4\5\10\0\20\5\1\0\1\5\1\0\1\5"+
    "\10\0\1\140\7\5\10\0\20\5\1\0\1\5\1\0"+
    "\1\5\10\0\1\141\7\5\10\0\20\5\1\0\1\5"+
    "\1\0\1\5\10\0\7\5\1\142\10\0\20\5\1\0"+
    "\1\5\1\0\1\5\10\0\10\5\10\0\7\5\1\143"+
    "\10\5\1\0\1\5\1\0\1\5\10\0\10\5\10\0"+
    "\1\5\1\144\16\5\1\0\1\5\1\0\1\5\10\0"+
    "\10\5\10\0\4\5\1\145\13\5\1\0\1\5\1\0"+
    "\1\5\10\0\10\5\10\0\5\5\1\146\12\5\1\0"+
    "\1\5\1\0\1\5\10\0\1\5\1\147\6\5\10\0"+
    "\20\5\1\0\1\5\1\0\1\5\10\0\2\5\1\150"+
    "\5\5\10\0\20\5\1\0\1\5\1\0\1\5\10\0"+
    "\3\5\1\151\4\5\10\0\20\5\1\0\1\5\1\0"+
    "\1\5\10\0\10\5\10\0\3\5\1\152\14\5\1\0"+
    "\1\5\1\0\1\5\10\0\10\5\10\0\15\5\1\153"+
    "\2\5\1\0\1\5\1\0\1\5\10\0\1\5\1\154"+
    "\6\5\10\0\20\5\1\0\1\5\1\0\1\5\10\0"+
    "\2\5\1\155\5\5\10\0\20\5\1\0\1\5\1\0"+
    "\1\5\10\0\2\5\1\156\5\5\10\0\20\5\1\0"+
    "\1\5\1\0\1\5\10\0\7\5\1\157\10\0\20\5"+
    "\1\0\1\5\1\0\1\5\10\0\1\160\7\5\10\0"+
    "\20\5\1\0\1\5\1\0\1\5\10\0\10\5\10\0"+
    "\1\161\17\5\1\0\1\5\1\0\1\5\10\0\10\5"+
    "\10\0\4\5\1\162\13\5\1\0\1\5\1\0\1\5"+
    "\10\0\10\5\10\0\1\163\17\5\1\0\1\5\1\0"+
    "\1\5\10\0\1\164\7\5\10\0\20\5\1\0\1\5"+
    "\1\0\1\5\10\0\10\5\10\0\1\165\17\5\1\0"+
    "\1\5\1\0\1\5\10\0\10\5\10\0\1\5\1\166"+
    "\16\5\1\0\1\5\1\0\1\5\10\0\1\167\7\5"+
    "\10\0\20\5\1\0\1\5\1\0\1\5\10\0\10\5"+
    "\10\0\4\5\1\170\13\5\1\0\1\5\1\0\1\5"+
    "\10\0\3\5\1\171\4\5\10\0\20\5\1\0\1\5"+
    "\1\0\1\5\10\0\3\5\1\172\4\5\10\0\20\5"+
    "\1\0\1\5\1\0\1\5\10\0\5\5\1\173\2\5"+
    "\10\0\20\5\1\0\1\5\1\0\1\5\10\0\10\5"+
    "\10\0\4\5\1\174\13\5\1\0\1\5\1\0\1\5"+
    "\10\0\1\5\1\175\6\5\10\0\20\5\1\0\1\5"+
    "\1\0\1\5\10\0\3\5\1\176\4\5\10\0\20\5"+
    "\1\0\1\5\1\0\1\5\10\0\5\5\1\177\2\5"+
    "\10\0\20\5\1\0\1\5\1\0\1\5\10\0\10\5"+
    "\10\0\1\200\17\5\1\0\1\5\1\0\1\5\10\0"+
    "\10\5\10\0\10\5\1\201\7\5\1\0\1\5\1\0"+
    "\1\5\10\0\10\5\10\0\4\5\1\202\13\5\1\0"+
    "\1\5\1\0\1\5\10\0\2\5\1\203\5\5\10\0"+
    "\20\5\1\0\1\5\1\0\1\5\10\0\10\5\10\0"+
    "\1\204\17\5\1\0\1\5\1\0\1\5\10\0\7\5"+
    "\1\205\10\0\20\5\1\0\1\5\1\0\1\5\10\0"+
    "\7\5\1\206\10\0\20\5\1\0\1\5\1\0\1\5"+
    "\10\0\10\5\10\0\1\207\17\5\1\0\1\5\1\0"+
    "\1\5\10\0\1\5\1\210\6\5\10\0\20\5\1\0"+
    "\1\5\1\0\1\5\10\0\1\211\7\5\10\0\20\5"+
    "\1\0\1\5\1\0\1\5\10\0\1\5\1\212\6\5"+
    "\10\0\20\5\1\0\1\5\1\0\1\5\10\0\10\5"+
    "\10\0\12\5\1\213\5\5\1\0\1\5\1\0\1\5"+
    "\10\0\10\5\10\0\1\214\17\5\1\0\1\5\1\0"+
    "\1\5\10\0\10\5\10\0\14\5\1\215\3\5\1\0"+
    "\1\5\1\0\1\5\10\0\3\5\1\216\4\5\10\0"+
    "\20\5\1\0\1\5\1\0\1\5\10\0\10\5\10\0"+
    "\1\217\17\5\1\0\1\5\1\0\1\5\10\0\10\5"+
    "\10\0\6\5\1\220\11\5\1\0\1\5\1\0\1\5"+
    "\10\0\1\221\7\5\10\0\20\5\1\0\1\5\1\0"+
    "\1\5\10\0\3\5\1\222\4\5\10\0\20\5\1\0"+
    "\1\5\1\0\1\5\10\0\3\5\1\223\4\5\10\0"+
    "\20\5\1\0\1\5\1\0\1\5\10\0\5\5\1\224"+
    "\2\5\10\0\20\5\1\0\1\5\1\0\1\5\10\0"+
    "\3\5\1\225\4\5\10\0\20\5\1\0\1\5\1\0"+
    "\1\5\10\0\10\5\10\0\11\5\1\226\6\5\1\0"+
    "\1\5\1\0\1\5\10\0\3\5\1\227\4\5\10\0"+
    "\20\5\1\0\1\5\1\0\1\5\10\0\6\5\1\230"+
    "\1\5\10\0\20\5\1\0\1\5\1\0\1\5\10\0"+
    "\10\5\10\0\10\5\1\231\7\5\1\0\1\5\1\0"+
    "\1\5\10\0\10\5\10\0\10\5\1\232\7\5\1\0"+
    "\1\5\1\0\1\5\10\0\10\5\10\0\13\5\1\233"+
    "\4\5\1\0\1\5\1\0\1\5\10\0\5\5\1\234"+
    "\2\5\10\0\20\5\1\0\1\5\1\0\1\5\10\0"+
    "\5\5\1\235\2\5\10\0\20\5\1\0\1\5\1\0"+
    "\1\5\10\0\1\236\7\5\10\0\20\5\1\0\1\5"+
    "\1\0\1\5\10\0\10\5\10\0\4\5\1\237\13\5"+
    "\1\0\1\5\1\0\1\5\10\0\10\5\10\0\10\5"+
    "\1\240\7\5\1\0\1\5\1\0\1\5\10\0\6\5"+
    "\1\241\1\5\10\0\20\5\1\0\1\5\1\0\1\5"+
    "\10\0\4\5\1\242\3\5\10\0\20\5\1\0\1\5"+
    "\1\0\1\5\10\0\10\5\10\0\4\5\1\243\13\5"+
    "\1\0\1\5\1\0\1\5\10\0\6\5\1\244\1\5"+
    "\10\0\20\5\1\0\1\5\1\0\1\5\10\0\10\5"+
    "\10\0\1\5\1\245\16\5\1\0\1\5\1\0\1\5"+
    "\10\0\10\5\10\0\1\5\1\246\16\5\1\0\1\5"+
    "\1\0\1\5\10\0\1\5\1\247\6\5\10\0\20\5"+
    "\1\0\1\5\1\0\1\5\10\0\5\5\1\250\2\5"+
    "\10\0\20\5\1\0\1\5\1\0\1\5\10\0\6\5"+
    "\1\251\1\5\10\0\20\5\1\0\1\5\1\0\1\5"+
    "\10\0\2\5\1\252\5\5\10\0\20\5\1\0\1\5"+
    "\1\0\1\5\10\0\2\5\1\253\5\5\10\0\20\5"+
    "\1\0\1\5\1\0\1\5\10\0\5\5\1\254\2\5"+
    "\10\0\20\5\1\0\1\5\1\0\1\5\10\0\10\5"+
    "\10\0\1\5\1\255\16\5\1\0\1\5\1\0\1\5"+
    "\10\0\6\5\1\256\1\5\10\0\20\5\1\0\1\5"+
    "\1\0\1\5\10\0\3\5\1\257\4\5\10\0\20\5"+
    "\1\0\1\5\1\0\1\5\10\0\10\5\10\0\5\5"+
    "\1\260\12\5\1\0\1\5\1\0\1\5\10\0\5\5"+
    "\1\261\2\5\10\0\20\5\1\0\1\5\1\0\1\5"+
    "\10\0\3\5\1\262\4\5\10\0\20\5\1\0\1\5"+
    "\1\0\1\5\10\0\10\5\10\0\1\263\17\5\1\0"+
    "\1\5\1\0\1\5\10\0\3\5\1\264\4\5\10\0"+
    "\20\5\1\0\1\5\1\0\1\5\10\0\10\5\10\0"+
    "\1\265\17\5\1\0\1\5\1\0\1\5\10\0\10\5"+
    "\10\0\4\5\1\266\13\5\1\0\1\5\1\0\1\5"+
    "\10\0\10\5\10\0\1\5\1\267\16\5\1\0\1\5"+
    "\1\0\1\5\10\0\5\5\1\270\2\5\10\0\20\5"+
    "\1\0\1\5\1\0\1\5\10\0\6\5\1\271\1\5"+
    "\10\0\20\5\1\0\1\5\1\0\1\5\10\0\6\5"+
    "\1\272\1\5\10\0\20\5\1\0\1\5\1\0\1\5"+
    "\10\0\10\5\10\0\4\5\1\273\13\5\1\0\1\5"+
    "\1\0\1\5\10\0\10\5\3\0\1\274\4\0\20\5"+
    "\1\0\1\5\1\0\1\5\10\0\10\5\10\0\6\5"+
    "\1\275\11\5\1\0\1\5\1\0\1\5\10\0\1\276"+
    "\7\5\10\0\20\5\1\0\1\5\1\0\1\5\10\0"+
    "\6\5\1\277\1\5\10\0\20\5\1\0\1\5\1\0"+
    "\1\5\10\0\10\5\10\0\10\5\1\300\7\5\1\0"+
    "\1\5\1\0\1\5\10\0\10\5\10\0\7\5\1\301"+
    "\10\5\1\0\1\5\1\0\1\5\10\0\10\5\10\0"+
    "\7\5\1\302\10\5\1\0\1\5\1\0\1\5\10\0"+
    "\5\5\1\303\2\5\10\0\20\5\1\0\1\5\1\0"+
    "\1\5\10\0\5\5\1\304\2\5\10\0\20\5\1\0"+
    "\1\5\1\0\1\5\10\0\5\5\1\305\2\5\10\0"+
    "\20\5\14\0\1\306\40\0\1\5\1\0\1\5\10\0"+
    "\1\307\7\5\10\0\20\5\1\0\1\5\1\0\1\5"+
    "\10\0\5\5\1\310\2\5\10\0\20\5\1\0\1\5"+
    "\1\0\1\5\10\0\5\5\1\311\2\5\10\0\20\5"+
    "\1\0\1\5\1\0\1\5\10\0\3\5\1\312\4\5"+
    "\10\0\20\5\1\0\1\5\1\0\1\5\10\0\3\5"+
    "\1\313\4\5\10\0\20\5\1\0\1\5\1\0\1\5"+
    "\10\0\6\5\1\314\1\5\10\0\20\5\1\0\1\5"+
    "\1\0\1\5\10\0\10\5\10\0\1\5\1\315\16\5"+
    "\1\0\1\5\1\0\1\5\10\0\10\5\10\0\5\5"+
    "\1\316\12\5\1\0\1\5\1\0\1\5\10\0\10\5"+
    "\10\0\5\5\1\317\12\5\1\0\1\5\1\0\1\5"+
    "\10\0\10\5\10\0\4\5\1\320\13\5\1\0\1\5"+
    "\1\0\1\5\10\0\1\321\7\5\10\0\20\5\1\0"+
    "\1\5\1\0\1\5\10\0\7\5\1\322\10\0\20\5"+
    "\1\0\1\5\1\0\1\5\10\0\10\5\10\0\4\5"+
    "\1\323\13\5\1\0\1\5\1\0\1\5\10\0\10\5"+
    "\10\0\1\324\17\5\1\0\1\5\1\0\1\5\10\0"+
    "\10\5\10\0\4\5\1\325\13\5\1\0\1\5\1\0"+
    "\1\5\10\0\10\5\10\0\5\5\1\326\12\5";

  private static int [] zzUnpackTrans() {
    int [] result = new int[7480];
    int offset = 0;
    offset = zzUnpackTrans(ZZ_TRANS_PACKED_0, offset, result);
    return result;
  }

  private static int zzUnpackTrans(String packed, int offset, int [] result) {
    int i = 0;       /* index in packed string  */
    int j = offset;  /* index in unpacked array */
    int l = packed.length();
    while (i < l) {
      int count = packed.charAt(i++);
      int value = packed.charAt(i++);
      value--;
      do result[j++] = value; while (--count > 0);
    }
    return j;
  }


  /* error codes */
  private static final int ZZ_UNKNOWN_ERROR = 0;
  private static final int ZZ_NO_MATCH = 1;
  private static final int ZZ_PUSHBACK_2BIG = 2;

  /* error messages for the codes above */
  private static final String ZZ_ERROR_MSG[] = {
    "Unkown internal scanner error",
    "Error: could not match input",
    "Error: pushback value was too large"
  };

  /**
   * ZZ_ATTRIBUTE[aState] contains the attributes of state <code>aState</code>
   */
  private static final int [] ZZ_ATTRIBUTE = zzUnpackAttribute();

  private static final String ZZ_ATTRIBUTE_PACKED_0 =
    "\1\0\1\10\1\11\2\1\2\11\1\1\1\11\1\1"+
    "\2\11\4\1\10\11\13\1\4\0\1\11\33\1\1\0"+
    "\31\1\1\11\135\1\1\0\11\1\1\11\20\1";

  private static int [] zzUnpackAttribute() {
    int [] result = new int[214];
    int offset = 0;
    offset = zzUnpackAttribute(ZZ_ATTRIBUTE_PACKED_0, offset, result);
    return result;
  }

  private static int zzUnpackAttribute(String packed, int offset, int [] result) {
    int i = 0;       /* index in packed string  */
    int j = offset;  /* index in unpacked array */
    int l = packed.length();
    while (i < l) {
      int count = packed.charAt(i++);
      int value = packed.charAt(i++);
      do result[j++] = value; while (--count > 0);
    }
    return j;
  }

  /** the input device */
  private java.io.Reader zzReader;

  /** the current state of the DFA */
  private int zzState;

  /** the current lexical state */
  private int zzLexicalState = YYINITIAL;

  /** this buffer contains the current text to be matched and is
      the source of the yytext() string */
  private char zzBuffer[] = new char[ZZ_BUFFERSIZE];

  /** the textposition at the last accepting state */
  private int zzMarkedPos;

  /** the current text position in the buffer */
  private int zzCurrentPos;

  /** startRead marks the beginning of the yytext() string in the buffer */
  private int zzStartRead;

  /** endRead marks the last character in the buffer, that has been read
      from input */
  private int zzEndRead;

  /** number of newlines encountered up to the start of the matched text */
  private int yyline;

  /** the number of characters up to the start of the matched text */
  private int yychar;

  /**
   * the number of characters from the last newline up to the start of the 
   * matched text
   */
  private int yycolumn;

  /** 
   * zzAtBOL == true <=> the scanner is currently at the beginning of a line
   */
  private boolean zzAtBOL = true;

  /** zzAtEOF == true <=> the scanner is at the EOF */
  private boolean zzAtEOF;

  /** denotes if the user-EOF-code has already been executed */
  private boolean zzEOFDone;

  /* user code: */
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



  /**
   * Creates a new scanner
   * There is also a java.io.InputStream version of this constructor.
   *
   * @param   in  the java.io.Reader to read input from.
   */
  public scannerCSS(java.io.Reader in) {
    this.zzReader = in;
  }

  /**
   * Creates a new scanner.
   * There is also java.io.Reader version of this constructor.
   *
   * @param   in  the java.io.Inputstream to read input from.
   */
  public scannerCSS(java.io.InputStream in) {
    this(new java.io.InputStreamReader(in));
  }

  /** 
   * Unpacks the compressed character translation table.
   *
   * @param packed   the packed character translation table
   * @return         the unpacked character translation table
   */
  private static char [] zzUnpackCMap(String packed) {
    char [] map = new char[0x10000];
    int i = 0;  /* index in packed string  */
    int j = 0;  /* index in unpacked array */
    while (i < 180) {
      int  count = packed.charAt(i++);
      char value = packed.charAt(i++);
      do map[j++] = value; while (--count > 0);
    }
    return map;
  }


  /**
   * Refills the input buffer.
   *
   * @return      <code>false</code>, iff there was new input.
   * 
   * @exception   java.io.IOException  if any I/O-Error occurs
   */
  private boolean zzRefill() throws java.io.IOException {

    /* first: make room (if you can) */
    if (zzStartRead > 0) {
      System.arraycopy(zzBuffer, zzStartRead,
                       zzBuffer, 0,
                       zzEndRead-zzStartRead);

      /* translate stored positions */
      zzEndRead-= zzStartRead;
      zzCurrentPos-= zzStartRead;
      zzMarkedPos-= zzStartRead;
      zzStartRead = 0;
    }

    /* is the buffer big enough? */
    if (zzCurrentPos >= zzBuffer.length) {
      /* if not: blow it up */
      char newBuffer[] = new char[zzCurrentPos*2];
      System.arraycopy(zzBuffer, 0, newBuffer, 0, zzBuffer.length);
      zzBuffer = newBuffer;
    }

    /* finally: fill the buffer with new input */
    int numRead = zzReader.read(zzBuffer, zzEndRead,
                                            zzBuffer.length-zzEndRead);

    if (numRead > 0) {
      zzEndRead+= numRead;
      return false;
    }
    // unlikely but not impossible: read 0 characters, but not at end of stream    
    if (numRead == 0) {
      int c = zzReader.read();
      if (c == -1) {
        return true;
      } else {
        zzBuffer[zzEndRead++] = (char) c;
        return false;
      }     
    }

	// numRead < 0
    return true;
  }

    
  /**
   * Closes the input stream.
   */
  public final void yyclose() throws java.io.IOException {
    zzAtEOF = true;            /* indicate end of file */
    zzEndRead = zzStartRead;  /* invalidate buffer    */

    if (zzReader != null)
      zzReader.close();
  }


  /**
   * Resets the scanner to read from a new input stream.
   * Does not close the old reader.
   *
   * All internal variables are reset, the old input stream 
   * <b>cannot</b> be reused (internal buffer is discarded and lost).
   * Lexical state is set to <tt>ZZ_INITIAL</tt>.
   *
   * @param reader   the new input stream 
   */
  public final void yyreset(java.io.Reader reader) {
    zzReader = reader;
    zzAtBOL  = true;
    zzAtEOF  = false;
    zzEOFDone = false;
    zzEndRead = zzStartRead = 0;
    zzCurrentPos = zzMarkedPos = 0;
    yyline = yychar = yycolumn = 0;
    zzLexicalState = YYINITIAL;
  }


  /**
   * Returns the current lexical state.
   */
  public final int yystate() {
    return zzLexicalState;
  }


  /**
   * Enters a new lexical state
   *
   * @param newState the new lexical state
   */
  public final void yybegin(int newState) {
    zzLexicalState = newState;
  }


  /**
   * Returns the text matched by the current regular expression.
   */
  public final String yytext() {
    return new String( zzBuffer, zzStartRead, zzMarkedPos-zzStartRead );
  }


  /**
   * Returns the character at position <tt>pos</tt> from the 
   * matched text. 
   * 
   * It is equivalent to yytext().charAt(pos), but faster
   *
   * @param pos the position of the character to fetch. 
   *            A value from 0 to yylength()-1.
   *
   * @return the character at position pos
   */
  public final char yycharat(int pos) {
    return zzBuffer[zzStartRead+pos];
  }


  /**
   * Returns the length of the matched text region.
   */
  public final int yylength() {
    return zzMarkedPos-zzStartRead;
  }


  /**
   * Reports an error that occured while scanning.
   *
   * In a wellformed scanner (no or only correct usage of 
   * yypushback(int) and a match-all fallback rule) this method 
   * will only be called with things that "Can't Possibly Happen".
   * If this method is called, something is seriously wrong
   * (e.g. a JFlex bug producing a faulty scanner etc.).
   *
   * Usual syntax/scanner level error handling should be done
   * in error fallback rules.
   *
   * @param   errorCode  the code of the errormessage to display
   */
  private void zzScanError(int errorCode) {
    String message;
    try {
      message = ZZ_ERROR_MSG[errorCode];
    }
    catch (ArrayIndexOutOfBoundsException e) {
      message = ZZ_ERROR_MSG[ZZ_UNKNOWN_ERROR];
    }

    throw new Error(message);
  } 


  /**
   * Pushes the specified amount of characters back into the input stream.
   *
   * They will be read again by then next call of the scanning method
   *
   * @param number  the number of characters to be read again.
   *                This number must not be greater than yylength()!
   */
  public void yypushback(int number)  {
    if ( number > yylength() )
      zzScanError(ZZ_PUSHBACK_2BIG);

    zzMarkedPos -= number;
  }


  /**
   * Contains user EOF-code, which will be executed exactly once,
   * when the end of file is reached
   */
  private void zzDoEOF() throws java.io.IOException {
    if (!zzEOFDone) {
      zzEOFDone = true;
      yyclose();
    }
  }


  /**
   * Resumes scanning until the next regular expression is matched,
   * the end of input is encountered or an I/O-Error occurs.
   *
   * @return      the next token
   * @exception   java.io.IOException  if any I/O-Error occurs
   */
  public java_cup.runtime.Symbol next_token() throws java.io.IOException {
    int zzInput;
    int zzAction;

    // cached fields:
    int zzCurrentPosL;
    int zzMarkedPosL;
    int zzEndReadL = zzEndRead;
    char [] zzBufferL = zzBuffer;
    char [] zzCMapL = ZZ_CMAP;

    int [] zzTransL = ZZ_TRANS;
    int [] zzRowMapL = ZZ_ROWMAP;
    int [] zzAttrL = ZZ_ATTRIBUTE;

    while (true) {
      zzMarkedPosL = zzMarkedPos;

      yychar+= zzMarkedPosL-zzStartRead;

      boolean zzR = false;
      for (zzCurrentPosL = zzStartRead; zzCurrentPosL < zzMarkedPosL;
                                                             zzCurrentPosL++) {
        switch (zzBufferL[zzCurrentPosL]) {
        case '\u000B':
        case '\u000C':
        case '\u0085':
        case '\u2028':
        case '\u2029':
          yyline++;
          zzR = false;
          break;
        case '\r':
          yyline++;
          zzR = true;
          break;
        case '\n':
          if (zzR)
            zzR = false;
          else {
            yyline++;
          }
          break;
        default:
          zzR = false;
        }
      }

      if (zzR) {
        // peek one character ahead if it is \n (if we have counted one line too much)
        boolean zzPeek;
        if (zzMarkedPosL < zzEndReadL)
          zzPeek = zzBufferL[zzMarkedPosL] == '\n';
        else if (zzAtEOF)
          zzPeek = false;
        else {
          boolean eof = zzRefill();
          zzEndReadL = zzEndRead;
          zzMarkedPosL = zzMarkedPos;
          zzBufferL = zzBuffer;
          if (eof) 
            zzPeek = false;
          else 
            zzPeek = zzBufferL[zzMarkedPosL] == '\n';
        }
        if (zzPeek) yyline--;
      }
      zzAction = -1;

      zzCurrentPosL = zzCurrentPos = zzStartRead = zzMarkedPosL;
  
      zzState = ZZ_LEXSTATE[zzLexicalState];


      zzForAction: {
        while (true) {
    
          if (zzCurrentPosL < zzEndReadL)
            zzInput = zzBufferL[zzCurrentPosL++];
          else if (zzAtEOF) {
            zzInput = YYEOF;
            break zzForAction;
          }
          else {
            // store back cached positions
            zzCurrentPos  = zzCurrentPosL;
            zzMarkedPos   = zzMarkedPosL;
            boolean eof = zzRefill();
            // get translated positions and possibly new buffer
            zzCurrentPosL  = zzCurrentPos;
            zzMarkedPosL   = zzMarkedPos;
            zzBufferL      = zzBuffer;
            zzEndReadL     = zzEndRead;
            if (eof) {
              zzInput = YYEOF;
              break zzForAction;
            }
            else {
              zzInput = zzBufferL[zzCurrentPosL++];
            }
          }
          int zzNext = zzTransL[ zzRowMapL[zzState] + zzCMapL[zzInput] ];
          if (zzNext == -1) break zzForAction;
          zzState = zzNext;

          int zzAttributes = zzAttrL[zzState];
          if ( (zzAttributes & 1) == 1 ) {
            zzAction = zzState;
            zzMarkedPosL = zzCurrentPosL;
            if ( (zzAttributes & 8) == 8 ) break zzForAction;
          }

        }
      }

      // store back cached position
      zzMarkedPos = zzMarkedPosL;

      switch (zzAction < 0 ? zzAction : ZZ_ACTION[zzAction]) {
        case 19: 
          { System.out.println("idTerminal");  return new Symbol (simbolosCSS.idTerminal, yyline+1,yychar+1, new String (yytext()));
          }
        case 47: break;
        case 40: 
          { System.out.println("minuscula");  return new Symbol (simbolosCSS.minuscula, yyline+1,yychar+1, new String (yytext()));
          }
        case 48: break;
        case 34: 
          { System.out.println("alienado");  return new Symbol (simbolosCSS.alineado, yyline+1,yychar+1, new String (yytext()));
          }
        case 49: break;
        case 28: 
          { System.out.println("tamtex");  return new Symbol (simbolosCSS.tamtex, yyline+1,yychar+1, new String (yytext()));
          }
        case 50: break;
        case 6: 
          { System.out.println("/");  return new Symbol (simbolosCSS.division, yyline+1,yychar+1, new String (yytext()));
          }
        case 51: break;
        case 24: 
          { System.out.println("false");  return new Symbol(simbolosCSS.booleano, yyline, yycolumn, yytext());
          }
        case 52: break;
        case 46: 
          { System.out.println("autoredimension");  return new Symbol (simbolosCSS.autoredimension, yyline+1,yychar+1, new String (yytext()));
          }
        case 53: break;
        case 11: 
          { System.out.println(")");  return new Symbol (simbolosCSS.cierraPar, yyline+1,yychar+1, new String (yytext()));
          }
        case 54: break;
        case 35: 
          { System.out.println("negrilla");  return new Symbol (simbolosCSS.negrilla, yyline+1,yychar+1, new String (yytext()));
          }
        case 55: break;
        case 12: 
          { System.out.println("+");  return new Symbol (simbolosCSS.mas, yyline+1,yychar+1, new String (yytext()));
          }
        case 56: break;
        case 4: 
          { /*Espacios en blanco, ignorados*/
          }
        case 57: break;
        case 17: 
          { System.out.println("]");  return new Symbol (simbolosCSS.corCierra, yyline+1,yychar+1, new String (yytext()));
          }
        case 58: break;
        case 14: 
          { System.out.println(",");  return new Symbol (simbolosCSS.coma, yyline+1,yychar+1, new String (yytext()));
          }
        case 59: break;
        case 3: 
          { System.out.println("id");  return new Symbol(simbolosCSS.id, yyline, yycolumn, yytext());
          }
        case 60: break;
        case 37: 
          { System.out.println("vertical");  return new Symbol (simbolosCSS.vertical, yyline+1,yychar+1, new String (yytext()));
          }
        case 61: break;
        case 45: 
          { System.out.println("fondoElemento");  return new Symbol (simbolosCSS.fondoelemento, yyline+1,yychar+1, new String (yytext()));
          }
        case 62: break;
        case 39: 
          { System.out.println("mayuscula");  return new Symbol (simbolosCSS.mayuscula, yyline+1,yychar+1, new String (yytext()));
          }
        case 63: break;
        case 18: 
          { System.out.println("cadena");  return new Symbol(simbolosCSS.cadena, yyline, yycolumn, yytext());
          }
        case 64: break;
        case 23: 
          { System.out.println("texto");  return new Symbol (simbolosCSS.texto, yyline+1,yychar+1, new String (yytext()));
          }
        case 65: break;
        case 32: 
          { System.out.println("cursiva");  return new Symbol (simbolosCSS.cursiva, yyline+1,yychar+1, new String (yytext()));
          }
        case 66: break;
        case 22: 
          { System.out.println("true");  return new Symbol(simbolosCSS.booleano, yyline, yycolumn, yytext());
          }
        case 67: break;
        case 15: 
          { System.out.println("=");  return new Symbol (simbolosCSS.igual, yyline+1,yychar+1, new String (yytext()));
          }
        case 68: break;
        case 43: 
          { System.out.println("horizontal");  return new Symbol (simbolosCSS.horizontal, yyline+1,yychar+1, new String (yytext()));
          }
        case 69: break;
        case 8: 
          { System.out.println("puntoComa");  return new Symbol(simbolosCSS.puntoComa, yyline, yycolumn, yytext());
          }
        case 70: break;
        case 33: 
          { System.out.println("visible");  return new Symbol (simbolosCSS.visible, yyline+1,yychar+1, new String (yytext()));
          }
        case 71: break;
        case 13: 
          { System.out.println("-");  return new Symbol (simbolosCSS.menos, yyline+1,yychar+1, new String (yytext()));
          }
        case 72: break;
        case 5: 
          { /*Saltos de linea, ignorados*/
          }
        case 73: break;
        case 42: 
          { System.out.println("colortext");  return new Symbol (simbolosCSS.colortext, yyline+1,yychar+1, new String (yytext()));
          }
        case 74: break;
        case 2: 
          { System.out.println("etero");  return new Symbol(simbolosCSS.numero, yyline, yycolumn, yytext());
          }
        case 75: break;
        case 26: 
          { System.out.println("grupo");  return new Symbol (simbolosCSS.grupo, yyline+1,yychar+1, new String (yytext()));
          }
        case 76: break;
        case 21: 
          { /*Comentario Multi Línea Ignorado*/
          }
        case 77: break;
        case 41: 
          { System.out.println("capitalT");  return new Symbol (simbolosCSS.capitalT, yyline+1,yychar+1, new String (yytext()));
          }
        case 78: break;
        case 38: 
          { System.out.println("izq");  return new Symbol (simbolosCSS.izquierda, yyline+1,yychar+1, new String (yytext()));
          }
        case 79: break;
        case 9: 
          { System.out.println("dospuntos");  return new Symbol(simbolosCSS.dosPuntos, yyline, yycolumn, yytext());
          }
        case 80: break;
        case 16: 
          { System.out.println("[");  return new Symbol (simbolosCSS.corAbre, yyline+1,yychar+1, new String (yytext()));
          }
        case 81: break;
        case 25: 
          { System.out.println("letra");  return new Symbol (simbolosCSS.letra, yyline+1,yychar+1, new String (yytext()));
          }
        case 82: break;
        case 29: 
          { System.out.println("opaque");  return new Symbol (simbolosCSS.opaque, yyline+1,yychar+1, new String (yytext()));
          }
        case 83: break;
        case 20: 
          { System.out.println("cdecimal");  return new Symbol(simbolosCSS.numero, yyline, yycolumn, yytext());
          }
        case 84: break;
        case 27: 
          { System.out.println("borde");  return new Symbol (simbolosCSS.borde, yyline+1,yychar+1, new String (yytext()));
          }
        case 85: break;
        case 10: 
          { System.out.println("abrePar"); return new Symbol (simbolosCSS.abrePar, yyline+1,yychar+1, new String (yytext()));
          }
        case 86: break;
        case 7: 
          { System.out.println("*");  return new Symbol (simbolosCSS.multiplicacion, yyline+1,yychar+1, new String (yytext()));
          }
        case 87: break;
        case 36: 
          { System.out.println("centrado");  return new Symbol (simbolosCSS.centrado, yyline+1,yychar+1, new String (yytext()));
          }
        case 88: break;
        case 44: 
          { System.out.println("justi");  return new Symbol (simbolosCSS.justificado, yyline+1,yychar+1, new String (yytext()));
          }
        case 89: break;
        case 30: 
          { System.out.println("formato");  return new Symbol (simbolosCSS.formato, yyline+1,yychar+1, new String (yytext()));
          }
        case 90: break;
        case 1: 
          { String errLex = "Error léxico, caracter irreconocible: '"+yytext()+"' en la línea: "+(yyline+1)+" y columna: "+yycolumn;
									//System.err.println(errLex);
									System.out.println(errLex);
									 ErrorScan(yyline,yychar,yytext());
          }
        case 91: break;
        case 31: 
          { System.out.println("derecha");  return new Symbol (simbolosCSS.derecha, yyline+1,yychar+1, new String (yytext()));
          }
        case 92: break;
        default: 
          if (zzInput == YYEOF && zzStartRead == zzCurrentPos) {
            zzAtEOF = true;
            zzDoEOF();
              { return new java_cup.runtime.Symbol(simbolosCSS.EOF); }
          } 
          else {
            zzScanError(ZZ_NO_MATCH);
          }
      }
    }
  }


}
