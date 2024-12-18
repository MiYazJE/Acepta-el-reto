import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class p765 {

  static String getWinner(HashMap<String, Integer> map) {
    boolean isDraw = false;
    String winner = null;
    int count = 0;

    for (Map.Entry<String, Integer> entry : map.entrySet()) {
      if (entry.getValue() > count) {
        count = entry.getValue();
        winner = entry.getKey();
        isDraw = false;
      } else if (entry.getValue() == count) {
        isDraw = true;
      }
    }

    String drawStr = Character.isUpperCase(winner.charAt(0)) ? "EMPATE" : "empate";
    return isDraw ? drawStr : winner;
  }

  public static void main(String[] args) {

    Scanner s = new Scanner(System.in);

    HashMap<String, Integer> ninots = new HashMap<>();
    HashMap<String, Integer> ninotsInfantils = new HashMap<>();

    while (true) {
      int N = s.nextInt();
      if (N == 0)
        break;

      s.nextLine();

      while (true) {
        String[] parts = s.nextLine().split(" ");
        for (int i = 0; i < parts.length; i++) {
          String str = parts[i];
          if (Character.isUpperCase(str.charAt(0))) {
            int currentCount = ninots.containsKey(str) ? ninots.get(str) : 0;
            ninots.put(str, currentCount + 1);
          } else {
            int currentCount = ninotsInfantils.containsKey(str) ? ninotsInfantils.get(str) : 0;
            ninotsInfantils.put(str, currentCount + 1);
          }

          N--;
          if (N == 0)
            break;
        }
        if (N == 0)
          break;
      }

      String ans = getWinner(ninotsInfantils) + " " + getWinner(ninots);
      System.out.println(ans);

      ninots.clear();
      ninotsInfantils.clear();
    }

    s.close();

  }

}
