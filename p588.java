import java.util.Scanner;

public class p588 {

    static boolean isPalindrome(String str) {
        int left = 0, right = str.length() - 1;
        while (left < right) {
            if (str.charAt(left++) != str.charAt(right--))
                return false;
        }
        return true;
    }

    public static void main(String[] args) {

        final Scanner s = new Scanner(System.in);

        char[] arr;
        long num;

        while (true) {
            num = s.nextLong();
            if (num == 0) break;
            arr = Long.toBinaryString(num).toCharArray();
            for (int i = 0; i < arr.length; i++) {
                if (arr[i] == '1') break;
                arr[i] = ' ';
            }
            for (int i = arr.length - 1; i >= 0; i--) {
                if (arr[i] == '1') break;
                arr[i] = ' ';
            }
            System.out.println(isPalindrome(new String(arr).trim()) ? "SI" : "NO");
        }

    }

}
