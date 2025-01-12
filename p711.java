import java.util.Scanner;

public class p711 {

  public static void main(String[] args) {

    Scanner s = new Scanner(System.in);
    int C = s.nextInt();
    s.nextLine();

    int[] minimums, maximums;

    while (C-- != 0) {
      char[] num = s.nextLine().toCharArray();

      minimums = new int[num.length];
      int min = Integer.MAX_VALUE;
      for (int i = num.length - 1; i >= 0; i--) {
        if (i == num.length - 1) {
          minimums[i] = 0;
        } else {
          minimums[i] = min;
        }
        min = Math.min(min, num[i] - '0');
      }

      maximums = new int[num.length];
      int max = Integer.MIN_VALUE;
      for (int i = 0; i < num.length; i++) {
        if (i == 0) {
          maximums[i] = 0;
        } else {
          maximums[i] = max;
        }
        max = Math.max(max, num[i] - '0');
      }

      long ans = 0;
      for (int i = 0; i < num.length; i++) {
        int n = num[i] - '0';
        if ((i + 1) % 2 != 0) {
          ans += (n * 3) + minimums[i];
        } else {
          ans += (n * 2) + maximums[i];
        }
      }

      System.out.println(ans);
    }

    s.close();

  }

}
