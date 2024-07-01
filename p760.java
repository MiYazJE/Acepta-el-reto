import java.util.Scanner;

public class p760 {
  private static final int MOD = 1_000_000_007;

  private static long calculatePermutations(int n, int from, int to) {

    long current = 1;
    for (int i = 0; i < from; i++) {
      current = (current * (n - i)) % MOD;
    }
    long result = current;

    for (int i = from; i < to; i++) {
      current = (current * (n - i)) % MOD;
      result = (result + current) % MOD;
    }

    return result;
  }

  public static void main(String[] args) {
    Scanner s = new Scanner(System.in);

    int C = s.nextInt();
    while (C-- != 0) {
      int T = s.nextInt();
      int A = s.nextInt();
      int B = s.nextInt();

      long totalPatterns = calculatePermutations(T * T, A, B) % MOD;

      System.out.println(totalPatterns);
    }

    s.close();
  }

}
