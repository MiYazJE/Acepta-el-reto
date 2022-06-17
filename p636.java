import java.util.HashMap;
import java.util.Scanner;

public class p636 {

    public static void main(String[] args) {

        Scanner s = new Scanner(System.in);
        HashMap<Integer, Integer> map = new HashMap<>();

        while (s.hasNext()) {
            int left = s.nextInt(), right = s.nextInt();

            String nums = "";
            int index = 0;
            Integer start = null;
            left = (left % right) * 10;

            while (true) {
                int num = left / right;
                left = left % right;

                if (map.containsKey(left)) {
                    start = map.get(left);
                    if (num != Character.getNumericValue(nums.charAt(map.get(left)))) {
                        nums += num;
                        start++;
                    }
                    break;
                }

                nums += num;

                if (left == 0) {
                    break;
                }

                map.put(left, index);
                index++;
                left *= 10;
            }

            if (start == null) {
                System.out.println(0 + "." + nums);
            }
            else {
                String sanitized = "";
                for (int i = 0; i < nums.length(); i++) {
                    if (i == start) sanitized += "|";
                    sanitized += nums.charAt(i);
                }
                sanitized += "|";
                System.out.println(0 + "." + sanitized);
            }

            map.clear();
        }

    }

}
