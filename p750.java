import java.util.Scanner;

public class p750 {

  static int zerosCount = 0;

  static int countZeros(String str) {
    int count = 0;
    for (char c : str.toCharArray()) {
      if (c == '0')
        count++;
    }
    return count;
  }

  static int checksum(String num) {
    if (num.length() == 1)
      return Integer.parseInt(num);

    zerosCount += countZeros(num);

    int sum = 0;
    for (char c : num.toCharArray()) {
      if (c == '0')
        continue;

      if (sum == 0) {
        sum = Integer.parseInt("" + c);
      } else {
        sum *= Integer.parseInt("" + c);
      }
    }

    zerosCount += countZeros("" + sum);
    sum = Integer.parseInt(
        (sum + "").replaceAll("0", ""));
    return checksum("" + sum);
  }

  public static void main(String[] args) {

    Scanner s = new Scanner(System.in);

    while (true) {
      String num = s.nextLine();
      if (num.equals("0"))
        break;

      zerosCount = 0;
      int sum = checksum(num);

      System.out.println(sum + "" + zerosCount);
    }

    s.close();
  }

}
