import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

class Led {
  int start, end;

  Led(int s) {
    this.start = s;
    this.end = 0;
  }

  int calculate() {
    if (this.end == 0)
      return 0;
    return this.end - this.start;
  }

}

public class p774 {

  public static void main(String[] args) {

    Scanner s = new Scanner(System.in);

    HashMap<Integer, Led> leds = new HashMap<>();

    while (true) {
      int N = s.nextInt();
      if (N == 0)
        break;

      for (int i = 0; i < N; i++) {
        int ledId = s.nextInt();
        if (!leds.containsKey(ledId)) {
          leds.put(ledId, new Led(i));
        } else {
          Led currentLed = leds.get(ledId);
          currentLed.end = i;
          leds.put(ledId, currentLed);
        }
      }

      long ans = 0;
      for (Map.Entry<Integer, Led> entry : leds.entrySet()) {
        Led led = entry.getValue();
        ans += led.calculate();
      }

      System.out.println(ans);
      leds.clear();
    }

    s.close();

  }

}
