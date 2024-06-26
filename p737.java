import java.util.Scanner;

public class p737 {

  public static void main(String[] args) {
    Scanner s = new Scanner(System.in);
    long[] arr;

    int C = s.nextInt();
    while (C-- != 0) {
      int n = s.nextInt();
      arr = new long[n];
      long max = 0L;
      for (int i = 0; i < arr.length; i++) {
        int num = s.nextInt();
        max = Math.max(max, num);
        arr[i] = (long) num;
      }
      for (int i = 0; i < arr.length; i++) {
        if (i == 0) {
          arr[i] = (long) (max - arr[i]);
        } else {
          arr[i] = (long) ((max - arr[i]) + arr[i - 1]);
        }
      }
      int Q = s.nextInt();
      while (Q-- != 0) {
        int left = s.nextInt() - 1;
        int right = s.nextInt() - 1;
        long ans = (long) (arr[right] - arr[left]);
        long left_left = left - 1 < 0 ? 0L : arr[left - 1];
        ans += arr[left] - left_left;
        System.out.println(ans);
      }
      System.out.println("---");
    }
  }

}
