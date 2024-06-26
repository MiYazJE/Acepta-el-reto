import java.util.Scanner;

public class p736 {

  public static void main(String[] args) {
    Scanner s = new Scanner(System.in);

    int C = s.nextInt();
    while (C-- != 0) {
      int E = s.nextInt();
      int n = s.nextInt();
      System.out.println((E / n) + (E % n == 0 ? 0 : 1));
    }

    s.close();
  }

}
