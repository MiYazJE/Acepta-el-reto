import java.util.Scanner;

public class p698 {

  public static void main(String[] args) {

    Scanner s = new Scanner(System.in);

    int c = s.nextInt(), N;
    long[] arr;
    long sum;

    while (c-- != 0) {
      N = s.nextInt();

      arr = new long[N * N];
      sum = 0L;

      for (int i = 0; i < N; i++) {
        for (int j = 0; j < N; j++) {
          int num = s.nextInt();
          arr[(i * N) + j] = num;
          sum += num;
        }
      }

      boolean isValid = solve(arr, sum);
      System.out.println(isValid ? "SI" : "NO");
    }

    s.close();

  }

  static boolean solve(long arr[], long target) {
    for (int i = 0; i < arr.length; i++) {
      if (target - arr[i] == arr[i])
        return true;
    }

    return false;
  }

}
