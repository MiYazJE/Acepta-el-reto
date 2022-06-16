import java.util.Scanner;

public class p635 {
    
    public static void main(String args[]) {
      Scanner s = new Scanner(System.in);
      int cases = s.nextInt();
      
      while (cases-- != 0) {
        int year = s.nextInt();
        System.out.println((year / 100) + (year % 100 != 0 ? 1 : 0));
      }
    }
    
}
