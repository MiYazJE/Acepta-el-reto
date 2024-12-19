import java.util.Arrays;
import java.util.Scanner;

public class p767 {

  public static void main(String[] args) {

    Scanner s = new Scanner(System.in);

    while (true) {
      int N = s.nextInt();
      if (N == 0)
        break;

      int[] arr = new int[N];
      int max = 0;
      for (int i = 0; i < arr.length; i++) {
        arr[i] = s.nextInt();
        if (arr[i] + i > max) {
          max = arr[i] + i;
        }
      }

      int[] sums = new int[N];
      for (int i = 0; i < N; i++) {
        sums[i] = max - i - arr[i];
      }

      String ans = Arrays.toString(sums)
          .replace("[", "")
          .replace("]", "")
          .replace(",", "");
      System.out.println(ans);
    }

    s.close();

  }

}
