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

    static int lcsRecursion(int m, int n) {
        if (m == 0 || n == 0) return 0;
        int best= memo[m][n];
        if (memo[m][n]!= 0) return best;
        if (A.charAt(m-1) == B.charAt(n-1))  return best + 1 + lcsRecursion(m-1, n-1);
        return Math.max(lcsRecursion(m, n-1),lcsRecursion(m-1, n));
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
