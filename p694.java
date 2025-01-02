import java.util.Scanner;

public class p694 {

  public static void main(String[] args) {

    Scanner s = new Scanner(System.in);

    int C = s.nextInt();
    s.nextLine();

    StringBuilder ans = new StringBuilder();

    while (C-- != 0) {

      for (String str : s.nextLine().split(" ")) {
        char c = str.charAt(0);
        if (Character.isUpperCase(c)) {
          ans.append(c);
        }
      }

      System.out.println(ans.toString());
      ans.delete(0, ans.length());
    }

    s.close();

  }

}
