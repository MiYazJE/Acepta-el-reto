import java.util.HashMap;
import java.util.Scanner;

public class p748 {

  public static void main(String[] args) {

    Scanner s = new Scanner(System.in);
    HashMap<String, Integer> map = new HashMap<>();

    while (true) {
      int N = s.nextInt();
      if (N == 0)
        break;
      s.nextLine();

      for (int i = 0; i < N; i++) {
        String line = s.nextLine();
        if (line.charAt(0) == '?') {
          String[] parts = line.split(" ");
          int many = Integer.parseInt(parts[1]);
          int sum = 0;
          for (int j = 0; j < many; j++) {
            String name = parts[2 + j];
            sum += map.containsKey(name) ? map.get(name) : 0;
            map.remove(name);
          }
          System.out.println(sum);
        } else {
          String[] parts = line.split(" ");
          String name = parts[0];
          int count = Integer.parseInt(parts[1]);
          int existingCount = map.containsKey(name) ? map.get(name) : 0;
          map.put(name, existingCount + count);
        }
      }

      System.out.println("---");
      map.clear();
    }

    s.close();
  }

}
