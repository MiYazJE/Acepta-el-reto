import java.util.Scanner;

public class p743 {

  public static void main(String[] args) {

    Scanner s = new Scanner(System.in);

    while (true) {
      int N = s.nextInt();
      if (N == 0)
        break;

      int ans = 0;
      for (int i = 0; i < N; i++) {
        ans += (s.nextInt() / 2);
      }

      System.out.println(ans);
    }

    s.close();
  }

}
