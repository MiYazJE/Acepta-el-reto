import java.util.Scanner;

public class p273 {

    static int[][] memo = new int[1001][1001];
    static String A, B;

    static void fill(int y, int x) {
        for (int i = 0; i < y; i++) {
            for (int j = 0; j < x; j++) {
                memo[i+1][j+1] = 0;
            }
        }
    }

    static int lcs() {
        for (int i = 0; i < A.length(); i++) {
            for (int j = 0; j < B.length(); j++) {
                if (A.charAt(i) == B.charAt(j)) {
                    memo[i+1][j+1] = memo[i][j] + 1;
                }
                else {
                    memo[i+1][j+1] = Math.max(memo[i][j+1], memo[i+1][j]);
                }
            }
        }
        return memo[A.length()][B.length()];
    }

    public static void main(String[] args) {

        final Scanner s = new Scanner(System.in);

        while (s.hasNext()) {

            A = s.next();
            B = s.next();

            System.out.println( lcs() );
            fill(A.length(), B.length());
        }

    }

}
