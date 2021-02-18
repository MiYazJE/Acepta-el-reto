import java.util.Scanner;

public class p602 {

    static int[] memo = new int[50];
    static int[] memo2 = new int[50];

    static void fibo() {
        memo[0] = 1;
        memo[1] = 1;
        memo2[0] = 1;
        memo2[1] = 2;
        int acum = 2;
        for (int i = 2; i < memo.length; i++) {
            memo[i] = (2 * memo[i - 2]) + memo[i - 1];
            acum += memo[i];
            memo2[i] = acum;
        }
    }

    public static void main(String[] args) {

        Scanner s = new Scanner(System.in);

        int cases = s.nextInt();
        fibo();

        while (cases-- != 0) {
            int ans = 0;
            int num = s.nextInt();
            for (int i = 0; i < memo2.length; i++) {
                if (memo2[i] >= num) {
                    ans = i + 1;
                    break;
                }
            }
            System.out.println(ans);
        }

    }

}
