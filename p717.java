import java.util.Scanner;

public class p717 {

    static boolean compare(String str) {
        return str.substring(0, 3).equals(str.substring(3, 6));
    }

    public static void main(String[] args) {

        Scanner s = new Scanner(System.in);
        int C = s.nextInt();

        while (C-- != 0) {
            String d1 = s.next();
            String d2 = s.next();
            String d3 = s.next();

            boolean valid = compare(d1 + d2 + d3)
                    || compare(d2 + d1 + d3)
                    || compare(d3 + d2 + d1)
                    || compare(d3 + d1 + d2);

            System.out.println( valid ? "DIVERTIDOS" : "INSULSOS" );

        }
    }

}
