import java.util.Arrays;
import java.util.Scanner;

public class p704 {

  public static void main(String[] args) {

    Scanner s = new Scanner(System.in);

    int C = s.nextInt();
    while (C-- != 0) {
      int A = s.nextInt() * 2;
      int B = s.nextInt() * 2;

      int K = s.nextInt();

      int[] arr = new int[K];
      for (int i = 0; i < K; i++) {
        arr[i] = s.nextInt();
      }

      Arrays.sort(arr);

      boolean hasA = false;
      boolean hasB = false;

      for (int i = 0; i < arr.length; i++) {
        if (!hasB && arr[i] >= B) {
          hasB = true;
          continue;
        }
        if (arr[i] >= A) {
          hasA = true;
        }
      }

      System.out.println(hasA && hasB ? "SI" : "NO");
    }

    s.close();
  }

}
