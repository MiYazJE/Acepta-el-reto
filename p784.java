import java.util.Scanner;

public class p784 {

  public static void main(String[] args) {
    
    Scanner s = new Scanner(System.in);
    
    int C = s.nextInt();
    s.nextLine();

    while (C-- != 0) {
      String[] parts = s.nextLine().split(" ");
      String ans = "";
      
      for (int i = 0; i < parts.length; i++) {
        ans += parts[i].charAt(0) + parts[i];
        if (i + 1 != parts.length) ans += " ";
      }

      System.out.println(ans);
    }

    s.close();

  }
  
}
