import java.util.Scanner;

public class p523 {

    public static void main(String[] args) {

        Scanner s = new Scanner(System.in);

        int casos = s.nextInt();

        String matriculaMia, matriculaTest;
        String numero1, numero2, letras1, letras2;
        int viejos, nuevos;

        for (int i = 0; i < casos; i++) {

            matriculaMia = s.next();
            numero1 = matriculaMia.substring(0, 4);
            letras1 = matriculaMia.substring(4, 7);

            //System.out.println(numero1 + " " + letras1);
            nuevos = viejos = 0;
            while (true) {

                matriculaTest = s.next();
                if (matriculaTest.equals("0")) break;

                numero2 = matriculaTest.substring(0, 4);
                letras2 = matriculaTest.substring(4, 7);

               // System.out.println(numero2 + " " + letras2);

                if (letras1.equals(letras2)) {
                    if (numero2.compareTo(numero1) < 0) viejos++;
                    else nuevos++;
                }
                else {
                    if (letras1.compareTo(letras2) < 0) nuevos++;
                    else viejos++;
                }

            }

            System.out.println( viejos + " " + nuevos );
        }

    }

}
