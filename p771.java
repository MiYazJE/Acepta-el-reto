import java.util.Scanner;

public class p771 {

  public static void main(String[] args) {

    Scanner s = new Scanner(System.in);

    int C = s.nextInt();
    while (C-- != 0) {
      System.out.println(s.nextInt() * 4);
    }

    s.close();

  }

}
