import java.util.ArrayList;
import java.util.Scanner;

public class p367 {

    public static void main(String[] args) {

        Scanner s = new Scanner(System.in);

        int C = s.nextInt();
        int pos, N;
        ArrayList<Integer> portals = new ArrayList<>();

        while (C-- != 0) {

            pos = s.nextInt();
            N   = s.nextInt();

            for (int i = 0; i < N; i++) portals.add(s.nextInt());

            int cost, temp = pos, index = -1;
            while (!portals.isEmpty()) {
                cost = 1001;
                for (int i = 0; i < portals.size(); i++) {
                    int n = portals.get(i);
                    if (Math.abs(pos - n) < cost || (Math.abs(pos - n) == cost && n > temp)) {
                        temp = n;
                        cost = Math.abs(pos - n);
                        index = i;
                    }
                }
                pos = temp;
                portals.remove(index);
                System.out.print(temp);
                System.out.print(portals.isEmpty() ? "\n" : " ");
            }

        }

    }

}
