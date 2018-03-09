/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package zInterfaz;

/**
 *
 * @author Ramonella
 */

    
    
    import java.util.StringTokenizer;
 
public class Prueba{
 
    static void eliminaEspacio(String sTexto, String sCadenaSinBlancos){
 
        for (int x=0; x < sTexto.length(); x++) {
            if (sTexto.charAt(x) != ' ')
            sCadenaSinBlancos += sTexto.charAt(x);
        }
 
        sCadenaSinBlancos = "";
 
        StringTokenizer stTexto = new StringTokenizer(sTexto);
 
        while (stTexto.hasMoreElements())
            sCadenaSinBlancos += stTexto.nextElement();
 
        System.out.println(sCadenaSinBlancos);
    }
 
    public static void main(String[] args){
 
        String sTexto = "1 2 3 4 5 6 7 8 9 10";
        System.out.println(sTexto);
        String sCadenaSinBlancos = "";
 
        eliminaEspacio(sTexto,sCadenaSinBlancos);
    }
 
}
    

