import java.util.*;

/** 
 * @author retos_killer
 * Problema 106 ACR Codigo de barras
 */

public class p106 {

    public static String identificarPais(String codigo) {
        if      (codigo.equals("380")) return "Bulgaria";
        else if (codigo.equals("539")) return "Irlanda";
        else if (codigo.equals("560")) return "Portugal";
        else if (codigo.equals("759")) return "Venezuela";
        else if (codigo.equals("850")) return "Cuba";
        else if (codigo.equals("890")) return "India";
        else {
            codigo = codigo.substring(0, 2);
            if      (codigo.equals("70")) return "Noruega";
            else if (codigo.equals("50")) return "Inglaterra";
            else if (codigo.charAt(0) == '0') return "EEUU";
        }
        return "Desconocido";
    }

    public static void main(String[] args) {

        Scanner s = new Scanner(System.in);

        String codigo, pais;
        int calculo, codigoCntrol, flag, len, n;
        boolean ean13;
        
        while (true) {

            codigo = s.nextLine();
            if (codigo.equals("0")) break;
            
            len   = codigo.length();
            ean13 = (len > 8 && len < 14);
            
            if (len < 14) {
                
                flag    = 0;
                calculo = 0;
                
                for (int i = len-2; i >= 0; i--) {
                    n = Integer.parseInt(""+codigo.charAt(i));
                    if (flag == 0) {
                        calculo += n * 3;
                        flag = 1;
                    }
                    else {
                        calculo += n;
                        flag = 0;
                    }
                }
                
                codigoCntrol = Integer.parseInt(""+codigo.charAt(len-1));
                
                if ((codigoCntrol + calculo) %10 == 0) {
                    if (ean13) {
                        pais = "";
                        if (len < 13) pais = "EEUU";
                        else pais = identificarPais(codigo.substring(0, 3));
                        System.out.println("SI " + pais);
                    }
                    else {
                        System.out.println("SI");
                    }
                }
                else {
                    System.out.println("NO");
                }

            }
            else {
                System.out.println("NO");
            }

        }

    }

}