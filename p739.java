import java.util.Scanner;

public class p739 {

  public static void main(String[] args) {
    Scanner s = new Scanner(System.in);

    int C = s.nextInt();
    while (C-- != 0) {
      float anchoPared = s.nextFloat();
      float altoPared = s.nextFloat();
      float anchoAzulejo = s.nextFloat();
      float altoAzulejo = s.nextFloat();

      Double H = Math.ceil(anchoPared / anchoAzulejo) * Math.ceil(altoPared / altoAzulejo);
      Double V = Math.ceil(anchoPared / altoAzulejo) * Math.ceil(altoPared / anchoAzulejo);
      System.out.println((int) Math.min(H, V));
    }

    s.close();
  }

}
