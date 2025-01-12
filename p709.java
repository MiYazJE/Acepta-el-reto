import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class p709 {

  static String getWinner(HashMap<String, Integer> countries) {
    String winner = "";
    boolean draw = false;
    int max = Integer.MIN_VALUE;

    for (Map.Entry<String, Integer> entry : countries.entrySet()) {
      if (entry.getValue() == max) {
        draw = true;
        continue;
      }

      if (entry.getValue() > max) {
        max = entry.getValue();
        winner = entry.getKey();
        draw = false;
      }
    }

    return draw ? "EMPATE" : winner;
  }

  public static void main(String[] args) {

    Scanner s = new Scanner(System.in);

    HashMap<String, Integer> countries = new HashMap<>();

    while (true) {
      int N = s.nextInt();
      if (N == 0)
        break;

      s.nextLine();

      while (true) {
        String[] parts = s.nextLine().split(" ");
        N -= parts.length;
        for (String country : parts) {
          int count = countries.containsKey(country) ? countries.get(country) : 0;
          countries.put(country, count + 1);
        }
        if (N == 0)
          break;
      }

      System.out.println(getWinner(countries));
      countries.clear();
    }

    s.close();

  }

}
