import java.util.Scanner;

public class p764 {

  public static void main(String[] args) {

    Scanner s = new Scanner(System.in);

    while (true) {
      int N = s.nextInt();
      if (N == 0)
        break;

      int ans = 0;
      while (N-- != 0) {
        int A = s.nextInt();
        int B = s.nextInt();
        ans += Math.abs(A - B);
      }

      System.out.println(ans);
    }

    s.close();

  }

}
