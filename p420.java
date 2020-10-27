import java.util.LinkedList;
import java.util.Scanner;

public class p420 {

    public static void main(String[] args) {

        final Scanner s = new Scanner(System.in);

        int C = s.nextInt();
        int target, sum, res;
        LinkedList<Integer> stack = new LinkedList<>();
        char[] input;

        while (C-- != 0) {
            target = s.nextInt();
            input = s.next().toCharArray();

            res = sum = 0;
            for (char c : input) {
                int n = Integer.parseInt(c + "");
                sum += n;
                stack.addLast(n);
                if (sum == target) res++;
                while (sum > target) {
                    sum -= stack.removeFirst();
                    if (sum == target) res++;
                }
            }

            System.out.println( res );
            stack.clear();
        }

    }

}
