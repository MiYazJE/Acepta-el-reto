import java.util.*;

public class p783 {

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        while (true) {
            int N = s.nextInt();
            int T = s.nextInt();

            if (N == 0 && T == 0)
                break;

            int[] arr = new int[N];
            for (int i = 0; i < N; i++)
                arr[i] = s.nextInt();

            Arrays.sort(arr);

            int tiempoTotal = 0;
            int penalizacion = 0;
            int resueltos = 0;

            for (int i = 0; i < N; i++) {
                if (tiempoTotal + arr[i] > T)
                    continue;

                tiempoTotal += arr[i];
                penalizacion += tiempoTotal;
                resueltos++;
            }

            System.out.println(resueltos + " " + penalizacion);
        }

        s.close();
    }
}
