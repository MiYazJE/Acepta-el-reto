import java.util.Scanner;

public class regional_B {

    public static boolean tieneMinuscula(String pass) {

        boolean minuscula = false;

        for (int i = 0; i < pass.length(); i++) {
            if (pass.charAt(i) >= 97 && pass.charAt(i) <= 122) {
                minuscula = true;
                break;
            }
        }

        return minuscula;
    }

    public static boolean tieneMayuscula(String pass) {

        boolean mayuscula = false;

        for (int i = 0; i < pass.length(); i++) {
            if (pass.charAt(i) >= 65 && pass.charAt(i) <= 90) {
                mayuscula = true;
                break;
            }
        }

        return mayuscula;
    }

    public static boolean tieneDigito(String pass) {

        boolean digito = false;

        for (int i = 0; i < pass.length(); i++) {
            if (pass.charAt(i) >= 48 && pass.charAt(i) <= 57) {
                digito = true;
                break;
            }
        }

        return digito;
    }

    public static boolean tieneSimbolo(String pass) {

        boolean simbolo = false;
        boolean salir = false;
        String simbolos = "+_)(*&^%$#@!./,;{}";

        for (int i = 0; i < pass.length(); i++) {
            for (int j = 0; j < simbolos.length(); j++) {
                if (pass.charAt(i) == simbolos.charAt(j)) {
                    simbolo = true;
                    salir   = true;
                    break;
                }
                if (salir) break;
            }
        }

        return simbolo;
    }


    public static void main(String[] args) {

        Scanner s = new Scanner(System.in); 

        int casos = s.nextInt();
        String pass;
        boolean valida;
        
        for (int i = 0; i < casos; i++) {
        
            pass = s.next();
            valida = true;


            if (pass.length() < 12) {
                valida = false;
            }

            if (valida && !tieneMinuscula(pass)) {
                valida = false;
            }

            if (valida && !tieneMinuscula(pass)) {
                valida = false;
            }

            if (valida && !tieneDigito(pass)) {
                valida = false;
            }

            if (valida && !tieneSimbolo(pass)) {
                valida = false;
            }

            System.out.println((valida) ? "OK" : "ERROR");
        }

    }

}

