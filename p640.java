import java.util.Scanner;

public class p640 {
    
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        
        long a, b;
        
        while (true) {
            a = s.nextLong();
            b = s.nextLong();
            if (a == 0 && b == 0) break;
            char[] arr = Long.toString(a, 9).toCharArray();
            String res = "";
            for (int i = arr.length - 1; i >= 0; i--) {
                if (Character.getNumericValue(arr[i]) >= b) {
                    res = (Character.getNumericValue(arr[i]) + 1) + "" + res;
                }
                else res = (arr[i] + "") + res;
            }
            System.out.println(res);
        }
    }
    
