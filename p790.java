import java.util.Scanner;

public class p790 {

  public static void main(String[] args) {
    
    Scanner s = new Scanner(System.in);

    while (true) {
      int totalPanaderias = s.nextInt();
      if (totalPanaderias == 0) break;

      int[] panaderias = new int[totalPanaderias];
      for (int i = 0; i < totalPanaderias; i++) 
        panaderias[i] = s.nextInt();

      int totalCharcuterias = s.nextInt();
      int[] charcuterias = new int[totalCharcuterias];
      for (int i = 0; i < totalCharcuterias; i++) 
        charcuterias[i] = s.nextInt();

      int indexP = 0;
      int indexC = 0;
      int ans = Integer.MAX_VALUE;

      while (true) {
        if (indexP == totalPanaderias || indexC == totalCharcuterias) break;

        ans = Math.min(ans, Math.abs(panaderias[indexP] - charcuterias[indexC]));
        if (panaderias[indexP] > charcuterias[indexC]) indexC++;
        else indexP++;
      }

      System.out.println(ans);
    }


    s.close();

  }
  
}
