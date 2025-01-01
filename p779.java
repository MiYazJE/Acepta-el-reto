import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class p779 {

  static class Range implements Comparable<Range> {
    int start, end;

    Range(int s, int e) {
      this.start = s;
      this.end = e;
    }

    public int compareTo(Range range) {
      return this.start - range.start;
    }

  }

  public static void main(String[] args) {

    Scanner s = new Scanner(System.in);

    ArrayList<Range> ranges = new ArrayList<>();

    while (true) {
      int total = s.nextInt();
      int N = s.nextInt();

      if (total == 0 && N == 0)
        break;

      for (int i = 0; i < N; i++) {
        int many = s.nextInt();
        for (int j = 0; j < many; j++) {
          String[] parts = s.next().split(",");
          ranges.add(new Range(Integer.parseInt(parts[0]), Integer.parseInt(parts[1])));
        }
      }

      Collections.sort(ranges);

      boolean can = true;
      int lastEnd = 0;
      for (Range range : ranges) {
        if (range.start > lastEnd + 1) {
          can = false;
          break;
        }
        lastEnd = Math.max(lastEnd, range.end);
      }

      if (lastEnd != total || ranges.get(0).start != 1) {
        can = false;
      }

      System.out.println(can ? "SI" : "NO");
      ranges.clear();
    }

    s.close();

  }

}
