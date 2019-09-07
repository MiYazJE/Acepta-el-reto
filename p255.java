import java.util.*;

public class p255 {

    static int longestPalindrome(char[] s, int start, int end) {
        int left = start, right = end;
        while (left <= right) {
            if (s[left] != s[right])
                return 0;
            left++; right--;
        }
        return (end - start) + 1;
    }

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        char[] c = new char[2001];
        String str;
        while (s.hasNext()) {
            str = s.next();
            c = str.toCharArray();
            int max = 1, p = str.length() - 1;
            for(int i = 0; i < str.length() && max <= (p - i); i++) {
                while((p - i) >= max) {
                    if (c[i] == c[p]) max = Math.max(max, longestPalindrome(c, i, p));
                    p--;
                }
                p = str.length() - 1;
            }

            System.out.println( max );
        }
    }

}
