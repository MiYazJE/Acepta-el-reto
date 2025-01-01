import java.util.Scanner;

public class p772 {

  public static void main(String[] args) {

    Scanner s = new Scanner(System.in);

    while (true) {
      int year = s.nextInt();
      int N = s.nextInt();
      if (year == 0 && N == 0)
        break;

      int count = N * 74;
      System.out.println("[" + (year + count) + " .. " + (year + count + (N * 5)) + "]");
    }

    s.close();

  }

}
