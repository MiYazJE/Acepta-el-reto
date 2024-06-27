import java.util.Scanner;

public class p756 {

  public static void main(String[] args) {

    Scanner s = new Scanner(System.in);

    while (s.hasNext()) {
      int[] arr = new int[16];
      for (int i = 0; i < 16; i++)
        arr[i] = s.nextInt();
      int count = 0;
      for (int i = 1; i < 16; i++) {
        for (int j = i - 1; j >= 0; j--) {
          if (arr[i] < arr[j])
            count++;
        }
      }
      System.out.println(count % 2 == 0 ? "SI" : "NO");
    }

    s.close();
  }

}
