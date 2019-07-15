package ejercicio239;

import java.util.Scanner;

public class p239 {

    public static void main(String[] args) {

        Scanner s = new Scanner(System.in);

        int totalDias, gts;
        int dias, horas, minutos, totalSegundos;

        while (true) {

            totalDias = s.nextInt();
            gts  = s.nextInt();
            if (totalDias == 0 && gts == 0)
                break;

            totalSegundos = (totalDias * gts) * (144);

            dias = totalSegundos / 86400;
            totalSegundos %= 86400;

            horas = totalSegundos / 3600;
            totalSegundos %= 3600;

            minutos = totalSegundos / 60;
            totalSegundos %= 60;

            System.out.printf("%01d:%02d:%02d:%02d\n", dias, horas, minutos, totalSegundos);

        }

    }

}
