import java.util.Arrays;
import java.util.Scanner;

public class p746 {

  public static void main(String[] args) {

    Scanner s = new Scanner(System.in);
    int[] arr;

    while (true) {
      int N = s.nextInt();
      int K = s.nextInt();
      if (N == 0 && K == 0)
        break;

      arr = new int[N];

      for (int i = 0; i < N; i++) {
        arr[i] = s.nextInt();
      }

      Arrays.sort(arr);

      int left = 0;
      int right = N - 1;
      int ans = 0;

      while (left < right) {
        int sum = arr[left] + arr[right];

        if (sum == K) {
          ans++;
          right--;
          left++;
          continue;
        }

        if (sum < K) {
          left++;
        } else {
          right--;
        }
      }

      System.out.println(ans);
    }

    s.close();
  }

}
