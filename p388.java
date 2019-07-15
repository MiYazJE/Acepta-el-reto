package ejercicio388;

import java.util.Scanner;

public class p388 {

    public static void main(String[] args) {

        Scanner s = new Scanner(System.in);

        int casos;
        int distancia, max;
        int[][] barcos;

        while (true) {

            casos = s.nextInt();
            if (casos == 0) break;

            max = Integer.MIN_VALUE;

            barcos = new int[casos][2];
            for (int i = 0; i < casos; i++) {
                barcos[i][0] = s.nextInt();
                barcos[i][1] = s.nextInt();
            }

            for (int i = 0; i < casos-1; i++) {
                for (int j = i; j < casos; j++) {
                    distancia = Math.abs(barcos[i][0] - barcos[j][0]) + Math.abs(barcos[i][1] - barcos[j][1]);
                    if (distancia > max) max = distancia;
                }
            }

            System.out.println( max );
        }

    }

}
