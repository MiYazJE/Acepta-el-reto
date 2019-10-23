import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

class Kid {
    int bueno, peso;
    Kid(int b, int p) {
        bueno = b;
        peso  = p;
    }
    public String toString() {
        return bueno + " " + peso;
    }
}

class SortKids implements Comparator<Kid> {
    public int compare(Kid o1, Kid o2) {
        if (o1.bueno == o2.bueno) return o2.peso - o1.peso;
        return o1.bueno - o2.bueno;
    }
}

public class p366 {

    public static void main(String[] args) {

        final Scanner s = new Scanner(System.in);

        int ninyos;
        ArrayList<Kid> listaNinyos = new ArrayList<>();
        SortKids sort = new SortKids();

        while (true) {

            ninyos = s.nextInt();
            if (ninyos == 0) break;

            for (int i = 0; i < ninyos; i++) {
                int b = s.nextInt();
                int p = s.nextInt();
                listaNinyos.add(new Kid(b, p));
            }

            Collections.sort(listaNinyos, sort);

            for (int i = listaNinyos.size() - 1; i >= 0; i--)
                System.out.println(listaNinyos.get(i));

            listaNinyos.clear();
            System.out.println();
        }

    }

}
