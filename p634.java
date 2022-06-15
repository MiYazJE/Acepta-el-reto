import java.util.*;

public class p634 {
    public static void main(String[ ] args) {
        Scanner s = new Scanner(System.in);

        int cases = s.nextInt();
        s.nextLine();

        while (cases-- != 0) {
            String line = s.nextLine(); 
            int total = 0, current = 0; 
            for (char c : line.toCharArray()) {
                if (c == 'O') {
                    current += 10;
                    total += current;
                }
                else {
                    current = 0;
                }
            }
            System.out.println(total);
        }
    }
}
