import java.util.LinkedList;
import java.util.Scanner;

public class p581 {

    public static void main(String[] args) {

        Scanner s = new Scanner(System.in);

        LinkedList<Integer> list = new LinkedList<>();
        int n = s.nextInt(), N, jumps;

        while (n-- != 0) {
            N = s.nextInt();
            jumps = s.nextInt();

            for (int i = 1; i <= N; i++) list.add(i);

            int pos = -1;
            while (list.size() != 1) {
                pos = (pos + jumps) % list.size();
                list.remove(pos);
                pos--;
            }

            System.out.println(list.pop());
        }

    }

}
