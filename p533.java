import java.util.Scanner;

public class p533 {

    public static void main(String[] args) {

        Scanner s = new Scanner(System.in);

        int limite, num, pos, temp, res;
        int casos = s.nextInt();

        while (casos-- != 0) {

            limite = s.nextInt();
            limite *= 8;

            res = -1;
            pos = temp = 0;
            while (true) {
                num = s.nextInt();
                if (num == 0) break;
                pos++;
                temp += num;
                if (temp >= limite) {
                    res = pos;
                    s.nextLine();
                    break;
                }
            }

            System.out.println( (res != -1) ? pos : "SIGAMOS RECICLANDO" );
        }

    }

}
