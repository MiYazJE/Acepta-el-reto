import java.util.*;

public class p787 {

  public static void swap(int[] arr) {
    int i = 0, j = arr.length - 1;
    while (i < j) {
      int temp = arr[i];
      arr[i] = arr[j];
      arr[j] = temp;
      i++;
      j--;
    }
  }

  public static int[] solve(int[] arr) {
    swap(arr);

    int n = arr.length;
    if (n < 4)
      return arr;

    int[] leftArr = Arrays.copyOfRange(arr, 0, n / 2);
    int[] rightArr = Arrays.copyOfRange(arr, n / 2, n);

    int[] swapLeft = solve(leftArr);
    int[] swapRight = solve(rightArr);

    int[] ans = new int[n];
    for (int i = 0, j = 0; i < swapLeft.length; i++) {
      ans[j++] = swapLeft[i];
      ans[j++] = swapRight[i];
    }

    return ans;
  }

  public static void main(String[] args) {
    Scanner s = new Scanner(System.in);

    while (true) {
      int n = s.nextInt();
      if (n == 0)
        break;

      int[] mazo = new int[n];
      for (int i = 0; i < n; i++) {
        mazo[i] = s.nextInt();
      }

      int[] ans = solve(mazo);

      for (int i = 0; i < ans.length; i++) {
        if (i > 0)
          System.out.print(" ");
        System.out.print(ans[i]);
      }
      System.out.println();
    }

    s.close();
  }
}
