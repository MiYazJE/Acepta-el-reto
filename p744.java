import java.util.Scanner;

public class p744 {

  public static void main(String[] args) {

    Scanner s = new Scanner(System.in);

    while (s.hasNext()) {
      int K = s.nextInt();

      int ans = 0;
      int prevTime = -1;

      while (true) {
        int currentTime = s.nextInt();
        if (currentTime == 0) {
          break;
        }

        if (prevTime == -1 || currentTime > prevTime + K) {
          ans++;
          prevTime = currentTime;
        }

      }

      System.out.println(ans);
    }

    s.close();
  }

}
