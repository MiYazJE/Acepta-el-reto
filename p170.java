import java.util.Scanner;

public class p170 {

    public static void main(String[] args) {

        Scanner s = new Scanner(System.in);

        int piramide;
        int suma;

        while (true) {

            piramide = s.nextInt();
            if (piramide == 0) break;

            int i, aux = 1; suma = 0;
            for (i = 0; i < piramide; i++) {
                suma += aux; aux++;
                if (suma == piramide) {
                    System.out.println(--aux + " " + 0);
                    break;
                }
                else if (suma + (aux) > piramide) {
                    System.out.println(--aux + " " + (piramide - suma));
                    break;
                }
            }

        }

    }

}
