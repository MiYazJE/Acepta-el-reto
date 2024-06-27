import java.util.Scanner;

public class p755 {

  public static int gcd(int a, int b) {
    while (b != 0) {
      int temp = b;
      b = a % b;
      a = temp;
    }
    return a;
  }

  public static void main(String[] args) {

    Scanner s = new Scanner(System.in);

    int C = s.nextInt();
    while (C-- != 0) {
      int W = s.nextInt();
      int H = s.nextInt();
      int l = gcd(W, H);
      long res1 = (W / l);
      long res2 = (H / l);
      long ans = res1 * res2;
      System.out.println(ans);
    }

    s.close();

  }

}
