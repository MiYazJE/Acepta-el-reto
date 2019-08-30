import java.util.Scanner;

/**
 * @author Rubén Saiz
 */

public class p515 {

    static int getTurnos(int n, int turno) {
        if (n <= 0) return 0;
        if (turno == 1) return getTurnos(n - 1, 2) + 1;
        if (n % 2 == 0) return getTurnos(n - 2, 1) + 1;
        return getTurnos(n - 1, 1) + 1;
    }

    public static void main(String[] args) {

        Scanner s = new Scanner(System.in);

        int copas;

        while (true) {
            copas = s.nextInt();
            if (copas == 0) break;
            System.out.println( getTurnos(copas, 1) );
        }

    }

}

