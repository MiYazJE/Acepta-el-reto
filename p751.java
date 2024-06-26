import java.util.Scanner;

public class p751 {

  public static void main(String[] args) {

    Scanner s = new Scanner(System.in);

    int C = s.nextInt();
    s.nextLine();

    while (C-- != 0) {
      String[] parts = s.nextLine().split(" ");
      int y1Start = Integer.parseInt(parts[0]);
      int y1End = Integer.parseInt(parts[1]);
      int y2Start = Integer.parseInt(parts[2]);
      int y2End = Integer.parseInt(parts[3]);

      int maxStart = Math.max(y1Start, y2Start);
      int minEnd = Math.min(y1End, y2End);
      int ans = Math.max(minEnd - maxStart + 1, 0);
      System.out.println(ans);
    }

    s.close();
  }

}
