import java.util.Arrays;
import java.util.Scanner;

class Range implements Comparable<Range> {
  int start, end;

  Range(int s, int e) {
    this.start = s;
    this.end = e;
  }

  public int compareTo(Range range) {
    return this.start - range.start;
  }

}

public class p776 {

  public static void main(String[] args) {

    Scanner s = new Scanner(System.in);
    Range[] ranges;

    while (true) {
      int N = s.nextInt();
      if (N == 0)
        break;

      ranges = new Range[N];
      for (int i = 0; i < N; i++) {
        ranges[i] = new Range(s.nextInt(), s.nextInt());
      }
      Arrays.sort(ranges);

      int ans = 0;
      int p = 0;
      Range range = ranges[p];
      while (true) {
        int num = s.nextInt();
        if (num == 0) {
          break;
        }

        if (num >= range.start && num <= range.end) {
          continue;
        }

        if (num < range.start) {
          ans++;
          continue;
        }

        while (p + 1 < N && num > ranges[p].end) {
          p++;
          range = ranges[p];
        }

        if (num < range.start || num > range.end) {
          ans++;
        }
      }

      System.out.println(ans);
    }

    s.close();

  }

}
