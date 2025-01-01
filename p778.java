import java.util.Scanner;

public class p778 {

  public static void main(String[] args) {

    Scanner s = new Scanner(System.in);

    while (true) {
      long N = s.nextLong();
      if (N == 0)
        break;

      long max = Long.MIN_VALUE;
      long ans = 0;

      for (long i = 0; i < N; i++) {
        long current = s.nextLong();
        if (current >= max) {
          ans++;
          max = current;
        } else {
          ans = 0;
        }
      }

      System.out.println(ans);
    }

    s.close();

  }

}
