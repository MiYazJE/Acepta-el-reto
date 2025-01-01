import java.util.Scanner;

public class p773 {

  public static void main(String[] args) {

    Scanner s = new Scanner(System.in);

    while (true) {
      int max = s.nextInt();
      int N = s.nextInt();
      if (max == 0 && N == 0)
        break;

      int[] arr = new int[N];
      for (int i = 0; i < N; i++) {
        arr[i] = s.nextInt();
      }

      boolean can = true;
      for (int i = 0; i < N; i++) {
        int num = s.nextInt();
        if (!can)
          continue;
        can = arr[i] - num >= 0;
        max -= num;
        can = can && max >= 0;
      }

      System.out.println(can ? "SI" : "NO");
    }

    s.close();

  }

}
