import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

class Treasure implements Comparable<Treasure> {
    String name;
    int value, weight;

    Treasure(String str, int v, int w) {
        this.name = str;
        this.value = v;
        this.weight = w;
    }

    @Override
    public int compareTo(Treasure t) {
        if (this.value != t.value) {
            return t.value - this.value;
        }

        if (this.weight != t.weight) {
            return this.weight - t.weight;
        }

        return 0;
    }
}

public class p661 {

    public static void main(String[] args) {

        Scanner s = new Scanner(System.in);

        ArrayList<Treasure> treasures = new ArrayList<Treasure>();
        StringBuilder str = new StringBuilder();
        int N;

        while (true) {
            N = s.nextInt();
            if (N == 0) break;

            for (int i = 0; i < N; i++) {
                Treasure treasure = new Treasure(s.next(), s.nextInt(), s.nextInt());
                treasures.add(treasure);
                s.nextLine();
            }

            Collections.sort(treasures);

            for (int i = 0; i < N; i++) {
                str.append(treasures.get(i).name);
                if (i + 1 != N) str.append(" ");
            }

            System.out.println(str);

            str.delete(0, str.length());
            treasures.clear();
        }

    }

}
