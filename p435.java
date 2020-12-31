import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Scanner;

public class p435 {

    public static void main(String[] args) {

        final Scanner s = new Scanner(System.in);

        HashMap<Character, Integer> map = new HashMap<>();
        boolean subnormal, first;
        int many = -1, sum;

        while (s.hasNext()) {
            sum = 0;
            for (char c : s.next().toCharArray()) {
                if (!map.containsKey(c)) {
                    sum += Integer.parseInt("" + c);
                    map.put(c, 1);
                }
                else map.put(c, map.get(c) + 1);
            }
            subnormal = first = true;
            for (Map.Entry<Character, Integer> entry : map.entrySet()) {
                if (first) {
                    first = false;
                    many = entry.getValue();
                }
                else if (many != entry.getValue()) {
                    subnormal = false;
                    break;
                }
            }
            System.out.println( map.containsKey('0') && sum == 45 && subnormal ? "subnormal" : "no subnormal" );
            map.clear();
        }

    }

}
