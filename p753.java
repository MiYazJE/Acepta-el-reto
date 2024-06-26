import java.util.Scanner;

public class p753 {

  static boolean can(int[] arr, int currentIndex, int currentSum, int target) {
    if (currentSum == target)
      return true;
    if (currentSum > target || currentIndex == arr.length)
      return false;

    int tempSum = currentSum;
    for (int i = currentIndex; i < arr.length; i++) {
      tempSum += arr[i];
      if (tempSum > currentSum)
        break;
      if (tempSum == currentSum)
        return true;
    }

    return can(arr, currentIndex + 1, currentSum + arr[currentIndex], target)
        || can(arr, currentIndex + 1, currentSum, target);
  }

  public static void main(String[] args) {

    Scanner s = new Scanner(System.in);

    while (true) {
      int N = s.nextInt();
      if (N == 0)
        break;

      int[] arr = new int[N];
      int sum = 0;
      for (int i = 0; i < N; i++) {
        arr[i] = s.nextInt();
        sum += arr[i];
      }

      System.out.println(
          can(arr, 0, 0, sum / 2)
              ? "SI"
              : "NO");

    }

    s.close();
  }

}
