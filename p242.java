import java.util.Scanner;

public class p242 {

    public static void main(String[] args) {

        Scanner s = new Scanner(System.in);

        int nums;
        long total, cont;
        long[] arr;

        while (true) {

            nums = s.nextInt();
            if (nums == 0) break;

            arr = new long[nums];
            total = 0;

            for (int i = 0; i < nums; i++) {
                arr[i] = s.nextInt();
                total += arr[i];
            }

            cont = 0l;
            for (int i = 0; i < nums; i++) {
                total -= arr[i];
                cont  += total * arr[i];
                if (total == 0) break;
            }

            System.out.println( cont );
        }

    }

}
