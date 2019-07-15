import java.util.Scanner;

public class p424 {

    public static void main(String[] args) {

        Scanner s = new Scanner(System.in);

        int max, num, casos, beneficios;

        while (true) {

            casos = s.nextInt();
            if (casos == 0) break;

            max = beneficios = 0;
            for (int i = 0; i < casos; i++) {
                num = s.nextInt();
                beneficios += num;
                if (beneficios > max) max = beneficios;
            }

            System.out.println(beneficios + " " + max);
        }

    }

}
