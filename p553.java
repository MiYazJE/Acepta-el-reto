import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.Scanner;

class Traduction {
    int left, right;
    public Traduction(int left, int right) {
        this.left = left;
        this.right = right;
    }
}

class Sort implements Comparator<Traduction> {
    @Override
    public int compare(Traduction o1, Traduction o2) {
        if (o1.left == o2.left) return o2.right - o1.right;
        return o1.left - o2.left;
    }
}

public class p553 {

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        LinkedList<Traduction> traductions = new LinkedList<>();
        int n, res;
        Traduction prevTraduction;
        Sort sort = new Sort();

        while (true) {
            n = s.nextInt();
            if (n == 0) break;

            for (int i = 0; i < n; i++)
                traductions.add(new Traduction(s.nextInt(), s.nextInt()));

            Collections.sort(traductions, sort);

            prevTraduction = traductions.get(0);
            res = (prevTraduction.right - prevTraduction.left) + 1;

            for (int i = 1; i < traductions.size(); i++) {
                Traduction current = traductions.get(i);
                if (prevTraduction.right >= current.left) {
                    int diff = (current.left - prevTraduction.right) + (current.right - current.left);
                    if (diff > 0) {
                        res += diff;
                        prevTraduction = current;
                    }
                }
                else {
                    prevTraduction = current;
                    res += (current.right - current.left) + 1;
                }
            }

            System.out.println( res );
            traductions.clear();
        }
    }

}
