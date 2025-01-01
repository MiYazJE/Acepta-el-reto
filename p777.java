import java.util.Scanner;

public class p777 {

  static long mcm(long a, long b) {
    return (long) ((long) (a * b) / mcd(a, b));
  }

  static long mcd(long a, long b) {
    while (b != 0) {
      long temp = b;
      b = (long) a % b;
      a = temp;
    }
    return a;
  }

  public static void main(String[] args) {
    Scanner s = new Scanner(System.in);

    int C = s.nextInt();
    while (C-- != 0) {
      long A = s.nextLong();
      long B = s.nextLong();
      long mcm = mcm(A, B);
      long ans = (long) (mcm / A) + (long) (mcm / B) - 1;
      System.out.println(ans);
    }

    s.close();
  }

}
