import java.util.Scanner;

public class p685 {

    public static void main(String[] args) {

        Scanner s = new Scanner(System.in);

        while (true) {
            int tX = s.nextInt();
            int tY = s.nextInt();
            int pX = s.nextInt();
            int pY = s.nextInt();

            if (tX == 0 && tY == 0 && pX == 0 && pY == 0) break;

            boolean seen = (tX == pX || tY == pY) ||
                    Math.abs(tX - pX) == Math.abs(tY - pY);
            System.out.println( seen ? "SI" : "NO" );
        }

    }

}
