import java.util.ArrayList;
import java.util.Scanner;
import java.util.TreeMap;

class Posit {

  int startF = Integer.MAX_VALUE;
  int startC = Integer.MAX_VALUE;
  int endF = Integer.MIN_VALUE;
  int endC = Integer.MIN_VALUE;
  char id;

  Posit(char id) {
    this.id = id;
  }

  void updateCords(int f, int c) {
    this.startF = Math.min(this.startF, f);
    this.endF = Math.max(this.endF, f);
    
    this.startC = Math.min(this.startC, c);
    this.endC = Math.max(this.endC, c);
  }

  boolean canRemove(char[][] m) {
    for (int i = startF; i <= endF; i++) {
      for (int j = startC; j <= endC; j++) {
        if (m[i][j] != id && m[i][j] != '.') return false;
      }
    }
    
    return true;
  }

  void destroy(char[][] m) {
    for (int i = startF; i <= endF; i++) {
      for (int j = startC; j <= endC; j++) {
        m[i][j] = '.';
      }
    }
  }
}

public class p654 {

  static TreeMap<Character, Posit> posits = new TreeMap<>();
  static char[][] m;
  static boolean[][] visited;

  public static void main(String[] args) {
    
    Scanner s = new Scanner(System.in);

    int cases = s.nextInt();

    while (cases-- != 0) {
      int C = s.nextInt();
      int F = s.nextInt();
      s.nextLine();

      m = new char[F][C];

      for (int i = 0; i < F; i++) {
        char[] str = s.nextLine().toCharArray();
        for (int j = 0; j < C; j++) {
          m[i][j] = str[j];
        }
      }

      visited = new boolean[F][C];
      for (int i = 0; i < F; i++) {
        for (int j = 0; j < C; j++) {
          char id = m[i][j];
          if (id == '.' || visited[i][j]) continue;

          Posit posit = posits.containsKey(id) ? posits.get(id) : new Posit(id);
          posit.updateCords(i, j);
          posits.put(id, posit);
        }
      }

      if (posits.isEmpty()) {
        System.out.println("----");
        continue;
      }

      boolean valid = true;
      ArrayList<String> ans = new ArrayList<>();

      while (!posits.isEmpty()) {
        String idsDeleted = "";
        ArrayList<Posit> positsToDestroy = new ArrayList<>();
        ArrayList<Posit> positList = new ArrayList<>(posits.values());

        for (Posit posit : positList) {
          if (posit.canRemove(m)) {
            positsToDestroy.add(posit);
            idsDeleted += " " + posit.id;
          }
        }

        if (positsToDestroy.isEmpty()) {
          valid = false;
          break;
        }

        for (Posit posit : positsToDestroy) {
          posits.remove(posit.id);
          posit.destroy(m);
        }

        ans.add(idsDeleted);
      }

      if (!valid) {
        System.out.println("IMPOSIBLE");
      } else {
        for (String str : ans) {
          System.out.println(str.trim());
        }
      }
      
      System.out.println("----");

      posits.clear();
    }

    s.close();
  }
  
}
