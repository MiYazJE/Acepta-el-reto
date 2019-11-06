import java.util.Scanner;

public class p503 {

    static void fill(int[] arr) {
        for (int i = 0; i < arr.length; i++)
            arr[i] = 0;
    }
    
    public static void main(String[] args) {

        final Scanner s = new Scanner(System.in);

        int[] memo = new int[42];
        int casos = s.nextInt();
        int dado1, dado2, max, numMax;

        while (casos-- != 0) {

            dado1 = s.nextInt();
            dado2 = s.nextInt();

            for (int i = 1; i <= dado1; i++)
                for (int j = 1; j <= dado2; j++)
                    memo[i + j]++;

            max = numMax = 0;
            for (int i = 1; i <= dado1 + dado2; i++) {
                if (memo[i] > max) {
                    max = memo[i];
                    numMax = i;
                }
            }

            System.out.print( numMax );

            for (int i = 1; i <= dado1 + dado2; i++)
                if (memo[i] == max && i != numMax) System.out.print(" " + i);

            fill(memo);
            System.out.println();
        }

    }

}
