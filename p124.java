import java.util.Scanner;

public class p124 {

    public static void main(String[] args) {

        Scanner s = new Scanner(System.in);

        String str1, str2; 
        int[] n1, n2;

        while (true) {
            str1 = s.next();
            str2 = s.next();
            if (str1.equals("0") && str2.equals("0"))
                break;
            n1 = new int[Math.max(str1.length(), str2.length())];
            n2 = new int[Math.max(str1.length(), str2.length())];
            for (int i = 0; i < str1.length(); i++) n1[i] = Integer.parseInt(str1.charAt(str1.length() - 1 - i) + "");
            for (int i = 0; i < str2.length(); i++) n2[i] = Integer.parseInt(str2.charAt(str2.length() - 1 - i) + "");
            int ans = 0, carry = 0;
            for (int i = 0; i < n1.length; i++) {
                if ((n1[i] + n2[i] + carry) >= 10) {
                    ans++;
                    carry = (n1[i]+ n2[i] + carry) / 10;
                }
                else carry = 0;
            }
            System.out.println( ans );
        }

    }

}
