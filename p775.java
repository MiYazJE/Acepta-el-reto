import java.util.Scanner;

public class p775 {
  public static void main(String[] args) {
    Scanner s = new Scanner(System.in);

    while (true) {

      long tiposDia = s.nextLong();
      if (tiposDia == 0)
        break;

      long tiposTotales = 0;
      long acc = 0;
      long accLastDay = 0;
      int i = 0;

      while (true) {
        if (i < 2) {
          tiposTotales += tiposDia;
        } else if (tiposDia > acc) {
          tiposTotales += (long) (tiposDia - acc);
          acc = 0;
        } else {
          acc -= tiposDia;
        }

        acc += accLastDay;
        accLastDay = tiposDia;

        tiposDia = s.nextLong();
        if (tiposDia == 0)
          break;
        i++;
      }

      System.out.println(tiposTotales);
    }
    s.close();
  }
}
