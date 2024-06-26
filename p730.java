import java.util.Scanner;

public class p730 {

  public static void main(String[] args) {
    Scanner s = new Scanner(System.in);

    int C = s.nextInt();
    while (C-- != 0) {
      int n = s.nextInt();
      int ans = 0;
      for (char c : Integer.toString(n, 2).toCharArray()) {
        if (c == '1')
          ans++;
      }
      System.out.println(ans);
    }
  }

}
