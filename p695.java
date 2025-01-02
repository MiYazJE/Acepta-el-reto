import java.util.Arrays;
import java.util.Scanner;

public class p695 {

  public static void main(String[] args) {

    Scanner s = new Scanner(System.in);

    while (true) {

      String str = s.nextLine();
      if (str.equals("0"))
        break;

      char[] strAsCharArr = str.toCharArray();
      Arrays.sort(strAsCharArr);
      String sortAsc = String.valueOf(strAsCharArr);

      String sortDsc = "";
      for (int i = strAsCharArr.length - 1; i >= 0; i--)
        sortDsc += strAsCharArr[i];

      int sortAscNum = Integer.parseInt(sortAsc);
      int sortDscNum = Integer.parseInt(sortDsc);
      int resta = sortDscNum - sortAscNum;

      System.out.printf("%d - %d = %d = %d x 9\n", sortDscNum, sortAscNum, resta, resta / 9);
    }

    s.close();

  }

}
