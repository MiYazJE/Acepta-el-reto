import java.util.HashMap;
import java.util.Scanner;

public class p768 {

  public static void main(String[] args) {

    Scanner s = new Scanner(System.in);

    HashMap<Character, Integer> map = new HashMap<>();

    while (s.hasNext()) {

      String str = s.nextLine();
      int max = 0;
      for (char c : str.toCharArray()) {
        int count = map.containsKey(c) ? map.get(c) + 1 : 1;
        map.put(c, count);
        max = Math.max(max, count);
      }

      System.out.println(max > (int) Math.ceil((double) str.length() / 2) ? "NO" : "SI");

      map.clear();
    }

    s.close();

  }

}
