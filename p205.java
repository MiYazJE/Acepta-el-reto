import java.util.Scanner;

public class p205 {

    private static boolean esCapicua(String num) {
        int left = 0, right = num.length() - 1;
        while (left < right) {
            if (num.charAt(left) != num.charAt(right))
                return false;
            left++; right--;
        }
        return true;
    }

    private static String getReverse(String num) {
        String res = "";
        for (int i = 0; i < num.length(); i++) {
            res = num.charAt(i) + res;
        }
        return res;
    }

    public static void main(String[] args) {

        final Scanner s = new Scanner(System.in);

        boolean capicua, salir;
        int iteraciones, n1, n2;
        String numero;

        for (int i = s.nextInt(); i > 0; i--) {

            numero = s.next();

            capicua = salir = false;
            iteraciones = 0;

            while (!salir) {
                iteraciones++;
                n1 = Integer.parseInt(numero);
                n2 = Integer.parseInt(getReverse(numero));
                numero = String.valueOf(n1 + n2);
                salir = Integer.parseInt(numero) > 1_000_000_000;
                if (!salir) {
                    capicua = esCapicua(numero);
                    salir = capicua;
                }
            }

            System.out.println( (capicua) ? iteraciones + " " + numero
                                          : "Lychrel?");
        }

    }

}
