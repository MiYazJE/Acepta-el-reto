import java.util.Scanner;

public class p617 {

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int c = s.nextInt();
        while (c-- != 0) {
            int n = s.nextInt();
            s.nextLine();
            Character[][] m = new Character[n][3];
            for (int i = 0; i < n; i++) {
                String input = s.nextLine();
                for (int j = 0; j < 3; j++) {
                    m[i][j] = input.charAt(j);
                }
            }
            String msg = "";
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < n; j++) {
                    msg += m[j][i];
                }
            }
            System.out.println(msg);
        }

    }

}
