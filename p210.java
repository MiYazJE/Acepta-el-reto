import java.util.*;

public class p210 {

    public static int[] precompute(int[] primos) {
        boolean primo;
        int aux;
        for (int i = 48; i < 6100; i++) {
            primo = true;
            aux   = (int)Math.sqrt(i) + 1;
            while (aux > 1) {
                if (i %aux == 0) {
                    primo = false;
                    break;
                }
                aux--;
            }
            if (primo) primos[i]++;
        }
        return primos;
    }

    static int getLower(int[] primos, int index) {
        for (int i = index-1; i >= 0; i--) {
            if (primos[i] != 0) return i;
        }
        return -1;
    }

    public static void main(String[] args) {

        final Scanner s = new Scanner(System.in);

        int[] primos = new int[6100];
        primos = precompute(primos);

        int casos = s.nextInt();
        s.nextLine();
        int suma, output;
        String nombre;

        for (int i = 0; i < casos; i++) {

            nombre = s.nextLine();

            suma = 0;
            for (int j = 0; j < nombre.length(); j++) {
                suma += nombre.charAt(j);
            }

            output = getLower(primos, suma);

            System.out.println(output);
        }

    }

}
