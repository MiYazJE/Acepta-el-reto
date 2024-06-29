import java.util.Scanner;

public class p757 {

  public static void main(String[] args) {

    Scanner s = new Scanner(System.in);

    int C = s.nextInt();
    s.nextLine();

    while (C-- != 0) {
      String[] parts = s.nextLine().split("S");

      int max = 0;
      for (String str : parts) {
        max = Math.max(max, str.length());
      }

      System.out.println(max);
    }

    s.close();
  }

}
