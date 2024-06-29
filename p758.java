import java.util.Scanner;

public class p758 {

  public static void main(String[] args) {

    Scanner s = new Scanner(System.in);
    int C = s.nextInt();

    while (C-- != 0) {
      int N = s.nextInt();
      int left = (N * 2) + ((N - 2) * 2);
      left += (N * 2) - 5;
      int right = (N * N) - left;
      System.out.println(left + " " + right);
    }

    s.close();
  }

}
