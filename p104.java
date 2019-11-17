import java.util.Scanner;

class Movil {
    int pi, di, pd, dd;
    Movil left, right;
    Movil(int pi, int di, int pd, int dd) {
        this.pi = pi; this.di = di; this.pd = pd; this.dd = dd;
    }
}

public class p104 {

    final static Scanner s = new Scanner(System.in);

    private static boolean isBalanced(Movil movil) {
        boolean left = true;
        if (movil.pi == 0) {
            movil.left = new Movil(s.nextInt(), s.nextInt(), s.nextInt(), s.nextInt());
            left = isBalanced(movil.left);
            movil.pi += movil.left.pi+ movil.left.pd;
        }
        boolean right = true;
        if (movil.pd == 0) {
            movil.right = new Movil(s.nextInt(), s.nextInt(), s.nextInt(), s.nextInt());
            right = isBalanced(movil.right);
            movil.pd += movil.right.pi + movil.right.pd;
        }
        return (left && right) && (movil.pi * movil.di == movil.pd * movil.dd);
    }

    public static void main(String[] args) {

        while (true) {
            Movil movil = new Movil(s.nextInt(), s.nextInt(), s.nextInt(), s.nextInt());
            if (movil.pi == 0 && movil.di == 0 && movil.pd == 0 && movil.dd == 0) System.exit(0);
            System.out.println( isBalanced(movil) ? "SI" : "NO" );
        }

    }

}
