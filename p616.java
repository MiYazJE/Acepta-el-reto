import java.util.Scanner;

public class p616 {

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        while (true) {
            int c = s.nextInt();
            if (c == 0) break;
            boolean left = false;
            int scoreLeft = 0, scoreRight = 0;
            for (int i = 0; i < c; i++) {
                String round = s.next();
                if (round.equals("PIC")) {
                    left = !left;
                }
                if (round.equals("PONG!")) {
                    if (left) scoreRight++;
                    else scoreLeft++;
                }
            }
            System.out.println(scoreLeft + " " + scoreRight);
        }
    }
}
