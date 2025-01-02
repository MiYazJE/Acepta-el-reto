import java.util.PriorityQueue;
import java.util.Scanner;

public class p701 {

  static class Block implements Comparable<Block> {
    int many, daysToExpire;

    Block(int many, int daysToExpire) {
      this.many = many;
      this.daysToExpire = daysToExpire;
    }

    @Override
    public int compareTo(Block o) {
      return o.daysToExpire - daysToExpire;
    }
  }

  public static void main(String[] args) {

    Scanner s = new Scanner(System.in);

    PriorityQueue<Block> blocks = new PriorityQueue<>();

    while (true) {
      int itemsToBuy = s.nextInt();
      if (itemsToBuy == 0)
        break;

      int N = s.nextInt();
      while (N-- != 0) {
        blocks.add(new Block(s.nextInt(), s.nextInt()));
      }

      int ans = 0;
      while (itemsToBuy > 0 && !blocks.isEmpty()) {
        Block block = blocks.poll();
        ans = block.daysToExpire;
        if (itemsToBuy >= block.many) {
          itemsToBuy -= block.many;
        } else
          break;
      }

      System.out.println(ans);
      blocks.clear();
    }

    s.close();

  }

}
