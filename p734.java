import java.util.Scanner;

class Time {

  private int hours;
  private int minuts;
  int totalMinuts;

  Time(String str) {
    String[] parts = str.split(":");
    this.hours = Integer.parseInt(parts[0]);
    this.minuts = Integer.parseInt(parts[1]);
    this.totalMinuts = this.minuts + (this.hours * 60);
  }
}

public class p734 {

  final static int TOTAL_MINUTS_PER_DAY = 1440;

  public static void main(String[] args) {
    Scanner s = new Scanner(System.in);

    int C = s.nextInt();
    while (C-- != 0) {
      Time t1 = new Time(s.next());
      Time t2 = new Time(s.next());

      int time1 = TOTAL_MINUTS_PER_DAY - t1.totalMinuts;
      int totalTime = time1 + t2.totalMinuts;

      System.out.println((totalTime * 48) / 12);
    }

    s.close();
  }

}
