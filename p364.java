import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @author Rubén Saiz
 */

public class p364 {

    static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {

        String line;
        StringBuilder result = new StringBuilder();;

        while (true) {

            line = br.readLine();
            if (line.equals("FIN")) break;

            for (int i = 0; i < line.length(); i++) {
                if (line.charAt(i) != ' ') {
                    if (line.charAt(i) == 90) result.append((char)65);
                    else result.append((char)(line.charAt(i) + 1));
                }
                else result.append(' ');
            }

            System.out.printf( "%s\n", result );
            result.setLength(0);
        }

    }

}
