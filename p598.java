import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

public class p598 {

  public static void main(String[] args) {

    Scanner s = new Scanner(System.in);
    HashMap<Integer, Integer> map = new HashMap<>();

    while (s.hasNext()) {
      int N = s.nextInt();
      int M = s.nextInt();

      int[] arr = new int[N];
      for (int i = 0; i < N; i++) {
        arr[i] = s.nextInt();
      }

      Arrays.sort(arr);

      for (int i = 0; i < M; i++) {
        int num = s.nextInt();
        if (!map.containsKey(num))
          map.put(num, 1);
        else
          map.put(num, map.get(num) + 1);
      }

      int ans = 0;
      for (int i = 0; i < N; i++) {
        int talla = arr[i];

        int count = map.containsKey(talla) ? map.get(talla) : 0;
        int count2 = map.containsKey(talla + 1) ? map.get(talla + 1) : 0;
        if (count > 0) {
          map.put(talla, count - 1);
          ans++;
        } else if (count2 > 0) {
          map.put(talla + 1, count2 - 1);
          ans++;
        }
      }

      System.out.println(N - ans);
      map.clear();
    }

    s.close();

  }

}
