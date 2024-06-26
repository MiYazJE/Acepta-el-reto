import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Scanner;

public class p729 {

  public static void main(String[] args) {

    Scanner s = new Scanner(System.in);

    HashMap<String, Integer> map = new HashMap<>();
    HashMap<Integer, ArrayList<String>> whoHas = new HashMap<>();

    while (s.hasNext()) {
      int N = s.nextInt();

      for (int i = 0; i < N; i++) {
        String name = s.next();

        int total = 0;
        while (true) {
          int n = s.nextInt();
          if (n == 0)
            break;
          total++;
          if (!whoHas.containsKey(n))
            whoHas.put(n, new ArrayList<String>());
          whoHas.get(n).add(name);
        }
        map.put(name, total);
      }

      ArrayList<String> winners = new ArrayList<String>();
      int K = s.nextInt();

      while (K-- != 0) {
        int num = s.nextInt();
        boolean exit = false;
        ArrayList<String> names = whoHas.containsKey(num) ? whoHas.get(num) : null;
        if (names == null)
          continue;
        for (String name : names) {
          int remaining = map.get(name) - 1;
          if (remaining == 0) {
            winners.add(name);
            exit = true;
          }
          map.put(name, remaining);
        }
        if (exit) {
          s.nextLine();
          break;
        }
      }

      Collections.sort(winners);
      System.out.println(
          winners
              .toString()
              .replace("[", "")
              .replace("]", "")
              .replace(",", ""));
      map.clear();
      whoHas.clear();
    }

    s.close();
  }

}
