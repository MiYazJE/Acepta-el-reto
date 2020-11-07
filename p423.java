import java.util.Scanner;

public class p423 {

    static Scanner s = new Scanner(System.in);
    static int n;

    static int getBecarios(int dept) {
        int N = s.nextInt(), current = 0;
        if (N == 0) return dept >= n ? 1 : 0;
        for (int i = 0; i < N; i++) {
            current += getBecarios(dept + 1);
        }
        return current;
    }

    public static void main(String[] args) {

        while (s.hasNext()) {
            n = s.nextInt();
            System.out.println(getBecarios(0));
        }

    }

}
