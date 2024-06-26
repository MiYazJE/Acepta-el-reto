import java.util.Scanner;

public class p745 {

  static String encodeExcel(long num, String encoded) {
    if (num == 0)
      return encoded;

    num--;
    int index = (int) (65 + (num % 26));
    return encodeExcel((long) (num / 26), ((char) index) + encoded);
  }

  public static void main(String[] args) {

    Scanner s = new Scanner(System.in);

    while (true) {
      long num = s.nextLong();
      if (num == 0)
        break;

      String encoded = "";
      while (num != 0) {
        encoded += encodeExcel(num, "") + " ";
        num = s.nextLong();
      }

      System.out.println(encoded.trim());
    }

    s.close();
  }

}
