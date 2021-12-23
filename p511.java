import java.util.*;

class Group {
  long n, repeat;
  Group(int repeat, int n) {
    this.n = n;
    this.repeat = repeat;
  }
}

public class p511 {
  
  public static void main(String[] args) {

    Scanner s = new Scanner(System.in);

    int a, b, p1, p2;
    long sum;
    Group[] groupsA, groupsB;

    while (s.hasNext()) {

      a = s.nextInt();
      b = s.nextInt();

      groupsA = new Group[a];
      groupsB = new Group[b];

      for (int i = 0; i < a; i++) groupsA[i] = new Group(s.nextInt(), s.nextInt());
      for (int i = 0; i < b; i++) groupsB[i] = new Group(s.nextInt(), s.nextInt());

      sum = p1 = p2 = 0;
      while (p1 < a) {
        Group groupA = groupsA[p1];
        Group groupB = groupsB[p2];
        if (groupA.repeat > groupB.repeat) {
          sum += groupB.repeat * groupA.n * groupB.n;
          groupA.repeat -= groupB.repeat;
          p2++;
        }
        else if (groupB.repeat > groupA.repeat) {
          sum += groupA.repeat * groupB.n * groupA.n;
          groupB.repeat -= groupA.repeat;
          p1++;
        } 
        else {
          sum += groupA.repeat * groupA.n * groupB.n;
          p1++; p2++;
        }
      }

      System.out.println(sum);
    }

  }

}
