import java.util.Scanner;

public class p587 {

    public static void main(String[] args) {

        Scanner s = new Scanner(System.in);

        int cases = s.nextInt();
        int ans;

        while (cases-- != 0) {
            char[] arr = s.next().toCharArray();
            ans = arr.length;
            for (int i = 0; i < arr.length - 1; i += 2) {
                if (arr[i] != arr[i + 1]) {
                    ans--;
                }
            }
            System.out.println( ans );
        }

    }

}
