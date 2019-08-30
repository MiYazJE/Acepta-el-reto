import java.util.Scanner;

/**
 * @author Rubén Saiz
 */

public class p262 {

    static int pow(int n, int pot) {
        if (pot == 0) return 1;
        return pow(n, pot - 1) * n % MOD;
    }

    final static int MOD = 46_337;

    public static void main(String[] args) {

        Scanner s = new Scanner(System.in);

        int veces, potencia;
        int result;

        while (true) {

            veces = s.nextInt();
            potencia = s.nextInt();

            if (veces == 0 && potencia == 0) break;

            result = 0;
            for (int i = 1; i <= veces; i++) {
                result += pow(i, potencia);
                result %= MOD;
            }

            System.out.println( result );
        }

    }

}
