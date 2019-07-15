import java.util.Scanner;

public class p314 {

    public static void main(String[] args) {

        Scanner s = new Scanner(System.in);

        int casos = s.nextInt();
        int numTemps, picos, valles;
        int[] temps;

        for (int j = 0; j < casos; j++) {

            numTemps = s.nextInt();
            temps    = new int[numTemps];

            for (int i = 0; i < numTemps; i++) temps[i] = s.nextInt();

            valles = picos = 0;
            for (int i = 1; i < numTemps-1; i++) {
                if (temps[i-1] < temps[i] && temps[i+1] < temps[i]) picos++;
                if (temps[i-1] > temps[i] && temps[i+1] > temps[i]) valles++;
            }

            System.out.println( picos + " " + valles );
        }

    }

}
