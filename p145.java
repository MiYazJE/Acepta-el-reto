import java.util.*;

/**
 * @author Rubén Saiz
 * 18/07/2019
 */

public class p145 {

    public static void main(String[] args) {

        Scanner s = new Scanner(System.in);

        char[] tren;
        Stack<Character> parejas;
        int res;

        while (s.hasNext()) {

            tren = s.next().toCharArray();
            parejas = new Stack<>();

            res = 0;
            for (int i = 0; i < tren.length; i++) {
                switch (tren[i]) {
                    case '@': parejas.clear(); break;
                    case 'H': case 'h': parejas.push(tren[i]); break;
                    case 'M': if (!parejas.isEmpty() && parejas.pop() == 'H') res++; else parejas.push(tren[i]); break;
                    case 'm': if (!parejas.isEmpty() && parejas.pop() == 'h') res++; else parejas.push(tren[i]); break;
                }
            }

            System.out.println( res );
        }

    }

}
