import java.util.Scanner;

public class p788 {

  public static void main(String[] args) {
    
    Scanner s = new Scanner(System.in);

    int C = s.nextInt();
    while (C-- != 0) {
      int N = s.nextInt();
      int T = s.nextInt();

      System.out.println((T / N) + (T % N));
    }

    s.close();

  }
  
}
