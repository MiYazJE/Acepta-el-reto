import java.util.LinkedList;
import java.util.Scanner;

public class p630 {

    public static void main(String[] args) {

        Scanner s = new Scanner(System.in);
        int n, round, ans;
        LinkedList<Byte> queue = new LinkedList<Byte>();

        while (true) {
            n = s.nextInt();
            round = s.nextInt();
            if (n == 0 && round == 0) break;

            s.nextLine();
            String str = s.nextLine();

            if (round <= 0) {
                System.out.println(0);
                continue;
            }

            ans = 0;
            round--;
            for (int i = 0; i < str.length(); i += 2) {
                byte n1 = Byte.parseByte(str.charAt(i) + "");
                byte n2 = Byte.parseByte(str.charAt(i + 1) + "");
                if (n1 == 1 && n2 == 1) ans++;
                if (n1 == 0 && n2 == 0) queue.add((byte)0);
                else queue.addLast((byte)1);
            }

            while (round-- != 0) {
                int matches = queue.size() / 2;
                for (int i = 0; i < matches; i++) {
                    byte n1 = queue.poll();
                    byte n2 = queue.poll();
                    if (n1 == 1 && n2 == 1) ans++;
                    if (n1 == 0 && n2 == 0) queue.add((byte)0);
                    else queue.addLast((byte)1);
                }
            }

            System.out.println(ans);
            queue.clear();
        }

    }

}
