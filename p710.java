import java.util.Scanner;

public class p710 {

  public static void main(String[] args) {

    Scanner s = new Scanner(System.in);
    int C = s.nextInt();

    while (C-- != 0) {
      int n = s.nextInt();
      int sum = 0;

      for (int i = 0; i < 6; i++) {
        sum += s.nextInt();
      }

      System.out.println(n - sum);
    }

    s.close();

  }

}
