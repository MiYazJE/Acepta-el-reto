import java.util.LinkedList;
import java.util.Scanner;

public class p610 {

    public static void main(String[] args) {

        final Scanner s = new Scanner(System.in);

        LinkedList<Integer> gente = new LinkedList<>();
        int C = s.nextInt();
        int N, spiderman, stark, K, muertes, proximoMuerto;

        while (C-- != 0) {
            N = s.nextInt();
            for (int i = 1; i <= N; i++) gente.add(i);

            stark = s.nextInt();
            spiderman = s.nextInt();
            K = s.nextInt();

            muertes = N / 2;
            proximoMuerto = 0;
            if (N % 2 != 0) muertes++;
            while (muertes-- != 0) {
                proximoMuerto = (proximoMuerto + K) % gente.size();
                gente.remove(proximoMuerto);
            }

            if ((gente.contains(spiderman) && gente.contains(stark)) ||
                ((!gente.contains(spiderman) && !gente.contains(stark)))) {
                System.out.println("No hay abrazo");
            }
            else if (gente.contains(spiderman)) {
                System.out.println("No quiero irme, Peter!");
            }
            else {
                System.out.println("No quiero irme, Sr. Stark!");
            }

            gente.clear();
        }

    }

}
