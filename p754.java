import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class p754 {

  static String repeat(char c, int count) {
    String repeat = "";
    for (int i = 0; i < count; i++)
      repeat += c;
    return repeat;
  }

  public static void main(String[] args) {

    Scanner s = new Scanner(System.in);
    HashMap<Character, Integer> map = new HashMap<>();

    while (s.hasNext()) {
      String str = s.nextLine();

      for (char c : str.toCharArray()) {
        if (!map.containsKey(c))
          map.put(c, 1);
        else
          map.put(c, map.get(c) + 1);
      }

      int odd = 0;
      String middle = "";
      for (Map.Entry<Character, Integer> entry : map.entrySet()) {
        if (entry.getValue() % 2 != 0) {
          odd++;
          if (odd == 2)
            break;
          middle = "" + entry.getKey();
        }
      }

      if (odd == 2) {
        System.out.println("NO HAY");
        map.clear();
        continue;
      }

      StringBuilder left = new StringBuilder();
      ArrayList<Character> list = new ArrayList<>(map.keySet());
      Collections.sort(list);

      for (Character c : list) {
        int count = map.get(c);
        left.append(repeat(c, count / 2));
      }

      String right = left.reverse().toString();
      String ans = left.reverse().toString() + middle + right;

      System.out.println(ans);
      map.clear();
    }

    s.close();
  }

}
