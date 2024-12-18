import java.util.Scanner;

public class p763 {

  public static void main(String[] args) {

    Scanner s = new Scanner(System.in);

    int C = s.nextInt();
    s.nextLine();

    while (C-- != 0) {
      String str = s.nextLine();
      System.out.println(str.toLowerCase().equals("colgadas") ? "Bien" : "Mal");

    }

    s.close();
  }

}
