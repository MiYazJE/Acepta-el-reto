import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class p731 {

  public static void main(String[] args) {
    Scanner s = new Scanner(System.in);
    Set<Integer> set = new HashSet<>();

    while (s.hasNext()) {
      int N = s.nextInt();
      if (N == 0)
        break;

      int ans = 0;
      for (int i = 0; i < N; i++) {
        int num = s.nextInt();
        if (set.contains(num))
          continue;
        if (num % 2 != 0) {
          set.add(num + 1);
        } else {
          set.add(num - 1);
        }
        set.add(num);
        ans++;
      }
      System.out.println(ans);

      set.clear();
    }
  }

}
