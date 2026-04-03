import java.util.Arrays;
import java.util.Scanner;

public class p650 {

  public static void main(String[] args) {

    Scanner s = new Scanner(System.in);

    while (s.hasNext()) {
      int N = s.nextInt();
      int[] arr = new int[N];

      for (int i = 0; i < N; i++)
        arr[i] = s.nextInt();

      if (N < 3) {
        System.out.println(0);
        continue;
      }

      Arrays.sort(arr);
      int ans = 0;
      for (int i = N - 3; i >= 0; i -= 3)
        ans += arr[i];

      System.out.println(ans);
    }

    s.close();
  }

}
