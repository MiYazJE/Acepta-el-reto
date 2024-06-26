import java.util.Scanner;

public class p752 {

  public static void main(String[] args) {
    Scanner s = new Scanner(System.in);

    while (true) {
      int P = s.nextInt();
      int N = s.nextInt();

      if (P == 0 && N == 0) {
        break;
      }

      int[] arr = new int[N];
      for (int i = 0; i < N; i++)
        arr[i] = s.nextInt();

      int min = Integer.MAX_VALUE;
      int startIndex = -1;
      int currentSum = 0;
      int leftIndex = 0;

      for (int i = 0; i < N; i++) {
        currentSum += arr[i];

        while (currentSum >= P) {
          int currentMin = i - leftIndex + 1;
          if (currentMin < min) {
            min = currentMin;
            startIndex = leftIndex + 1;
          }
          currentSum -= arr[leftIndex];
          leftIndex++;
        }
      }

      System.out.println(startIndex == -1 ? "NO ENTRAN" : (min + " " + startIndex));
    }

    s.close();
  }
}
