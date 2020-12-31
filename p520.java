    import java.util.Scanner;

    public class p520 {

        public static void main(String[] args) {

            final Scanner s = new Scanner(System.in);

            int N, pos, n1, n2;

            while (true) {
                N = s.nextInt();
                pos = s.nextInt();
                if (N == 0 && pos == 0) break;
                while (true) {
                    n1 = s.nextInt();
                    n2 = s.nextInt();
                    if (n1 == 0 && n2 == 0) break;
                    if ((n1 == pos && n2 != pos)) {
                        pos = n2;
                    }
                    else if (n2 == pos && n1 != pos) {
                        pos = n1;
                    }
                }
                System.out.println( pos );
            }

        }

    }
