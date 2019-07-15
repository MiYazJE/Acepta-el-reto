import java.util.Scanner;

/**
 * @author Rubén Saiz
 */

public class p522 {

    public static void main(String[] args) {

        Scanner s = new Scanner(System.in);

        String palabra1, palabra2;
        int p1, p2;
        double valor1, valor2;
        boolean primera;

        while (s.hasNext()) {

            palabra1 = s.next();
            palabra2 = s.next();

            palabra1 = palabra1.toLowerCase();
            palabra2 = palabra2.toLowerCase();

            primera = false;
            p1 = p2 = 0;
            while (true) {

                if (p1 > palabra1.length()-1){
                    primera = true;
                    break;
                }
                if (p2 > palabra2.length()-1) break;

                if (p1 < palabra1.length()-1) {
                    if (palabra1.charAt(p1) == 'c' && palabra1.charAt(p1+1) == 'h') {
                        valor1 = ((double)'c')+0.5;
                        p1++;
                    }
                    else if (palabra1.charAt(p1) == 'l' && palabra1.charAt(p1+1) == 'l') {
                        valor1 = ((double)'l')+0.5;
                        p1++;
                    }
                    else {
                        valor1 = palabra1.charAt(p1);
                    }
                }
                else {
                    valor1 = palabra1.charAt(p1);
                }

                if (p2 < palabra2.length()-1) {
                    if (palabra2.charAt(p2) == 'c' && palabra2.charAt(p2+1) == 'h') {
                        valor2 = ((double)'c')+0.5;
                        p2++;
                    }
                    else if (palabra2.charAt(p2) == 'l' && palabra2.charAt(p2+1) == 'l') {
                        valor2 = ((double)'l')+0.5;
                        p2++;
                    }
                    else {
                        valor2 = palabra2.charAt(p2);
                    }
                }
                else {
                    valor2 = palabra2.charAt(p2);
                }

                if (valor1 < valor2) {
                    primera = true;
                    break;
                }
                if (valor2 < valor1) break;

                p1++;
                p2++;
            }

            System.out.println( (primera) ? palabra1 : palabra2);
        }

    }

}
