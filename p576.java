import java.util.Scanner;

public class p576 {

    public static void main(String[] args) {

        final Scanner s = new Scanner(System.in);

        int palabra, total;

        while (true) {
            palabra = s.nextInt();
            if (palabra == 0) break;
            total = 0;
            while (true) {
                int num = s.nextInt();
                if (num == 0) break;
                total += num * palabra;
            }
            int horas = total / 3600;
            total %= 3600;
            int min = total / 60;
            total %= 60;
            System.out.printf("%02d:%02d:%02d\n", horas, min, total);
        }

    }

}
