import java.util.Scanner;

public class p703 {

  static class Salida {
    int time, velocityInKm;

    Salida(String line) {
      String[] parts = line.split(" ");

      this.velocityInKm = Integer.parseInt(parts[2]);

      String[] timeParts = parts[0].split(":");
      this.time = Integer.parseInt(timeParts[0]) * 60 + Integer.parseInt(timeParts[1]);

    }

    int calculate() {
      return (this.time * this.velocityInKm) / 60;
    }
  }

  public static void main(String[] args) {

    Scanner s = new Scanner(System.in);

    while (s.hasNext()) {
      int N = s.nextInt();
      s.nextLine();

      while (N-- != 0) {
        System.out.println(new Salida(s.nextLine()).calculate());
      }
    }

    s.close();

  }

}
