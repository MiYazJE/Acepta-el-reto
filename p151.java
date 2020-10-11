import java.util.Scanner;

public class p151 {

    public static void main(String[] args) {

        Scanner s = new Scanner(System.in);
        int F, num;
        boolean valid;

        while (true) {

            F = s.nextInt();
            if (F == 0) break;

            valid = true;
            for (int i = 0; i < F; i++) {
                for (int j = 0; j < F; j++) {
                    num = s.nextInt();
                    if (Math.abs(i - j) == 0) {
                        valid = valid && num == 1;
                    }
                    else {
                        valid = valid && num == 0;
                    }
                }
            }

            System.out.println( valid ? "SI" : "NO" );
        }

    }

}
