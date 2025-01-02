import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class p700 {

  static class Serie implements Comparable<Serie> {
    String title;
    int time;

    Serie(String title, int time) {
      this.title = title;
      this.time = time;
    }

    @Override
    public int compareTo(Serie serie) {
      if (this.time == serie.time) {
        return this.title.compareTo(serie.title);
      }
      return serie.time - this.time;
    }
  }

  public static void main(String[] args) {

    Scanner s = new Scanner(System.in);
    HashMap<String, Serie> series = new HashMap<>();

    while (true) {
      int N = s.nextInt();
      if (N == 0)
        break;

      for (int i = 0; i < N; i++) {
        int time = s.nextInt();
        String title = s.nextLine();
        if (title.charAt(0) == ' ')
          title = title.substring(1);
        int currentTime = series.containsKey(title) ? series.get(title).time : 0;
        series.put(title, new Serie(title, time + currentTime));
      }

      ArrayList<Serie> seriesList = new ArrayList<>();
      for (Map.Entry<String, Serie> entry : series.entrySet()) {
        if (entry.getValue().time >= 30)
          seriesList.add(entry.getValue());
      }

      Collections.sort(seriesList);
      for (int i = 0; i < Math.min(3, seriesList.size()); i++) {
        System.out.println(seriesList.get(i).title);
      }

      System.out.println("---");
      series.clear();
    }

    s.close();

  }

}
