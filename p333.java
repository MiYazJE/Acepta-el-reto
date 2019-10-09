import java.util.Scanner;

public class p333 {

    static boolean isPalindrome(int left, int right) {
        if (num.charAt(left) == '0' && left != right) return false;
        while (left <= right) {
            if (num.charAt(left) != num.charAt(right)) return false;
            left++; right--;
        }
        return true;
    }

    static String num;

    public static void main(String[] args) {

        final Scanner s = new Scanner(System.in);
        boolean dblCap;

        while (true) {
            num = s.next();
            if (num.equals("0")) break;
            dblCap = false;
            for (int i = 0; i < num.length()-1 && !dblCap; i++)
                dblCap = isPalindrome(0, i) && isPalindrome(i + 1, num.length() - 1);
            System.out.println( (dblCap) ? "SI" : "NO" );
        }

    }

}
