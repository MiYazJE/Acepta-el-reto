import java.util.Arrays;
import java.util.Scanner;

public class p696 {

  public static void main(String[] args) {

    Scanner s = new Scanner(System.in);
    int min, max;
    boolean[] arr = new boolean[500_000 + 1];

    while (s.hasNext()) {
      min = Integer.MAX_VALUE;
      max = Integer.MIN_VALUE;
      while (true) {
        int num = s.nextInt();
        if (num == 0)
          break;
        arr[num] = true;
        min = Math.min(min, num);
        max = Math.max(max, num);
      }

      int ans = 0;
      for (int i = min; i <= max; i++) {
        if (!arr[i]) {
          ans = i;
          break;
        }
      }

      System.out.println(ans);
      Arrays.fill(arr, min, max + 1, false);
    }

    s.close();

  }

}
