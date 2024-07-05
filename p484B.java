import java.math.BigInteger;
import java.util.Scanner;

public class p484B {

  public static String reverse(String str) {
    char[] num = str.toCharArray();
    for (int i = 0; i < num.length / 2; i++) {
      char temp = num[num.length - i - 1];
      num[num.length - i - 1] = num[i];
      num[i] = temp;
    }
    return new String(num);
  }

  public static void main(String[] args) {

    Scanner s = new Scanner(System.in);

    while (s.hasNext()) {
      String[] parts = s.nextLine().split("\\.");

      if (parts.length == 1) {
        System.out.println(new BigInteger(parts[0]).toString(10));
        continue;
      }

      String left = new BigInteger(parts[0]).toString(10);
      String right = reverse(new BigInteger(reverse(parts[1])).toString(10));

      if (left.equals("0") && right.equals("0"))
        System.out.println(0);
      else if (right.equals("0"))
        System.out.println(left);
      else
        System.out.println(left + "." + right);

    }

    s.close();
  }

}
