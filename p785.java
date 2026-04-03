import java.util.Scanner;

public class p785 {

  public static void main(String[] args) {
    
    Scanner s = new Scanner(System.in);
    
    int C = s.nextInt();
    while (C-- != 0) {
      long a = s.nextLong();
      long b = s.nextLong();
      System.out.println(Long.bitCount(a ^ b));
    }

    s.close();

  }
  
}
