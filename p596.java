import java.util.Scanner;

public class p596 {

    public static void main(String[] args) {

        Scanner s = new Scanner(System.in);

        while (s.hasNext()) {
            String decode = "";
            char[] input = s.next().toCharArray();
            for (int i = 0; i < input.length - 2; i++) {
                if (input[i] == '.') continue;
                if (input[i + 1] == '.' && input[i + 2] == '.') decode += input[i];
            }
            System.out.println( decode );
        }

    }

}
