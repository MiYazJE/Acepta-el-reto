import java.util.LinkedList;
import java.util.Scanner;

public class p141 {

    public static void main(String[] args) {

        final Scanner s = new Scanner(System.in);

        boolean balanced;
        LinkedList<Character> cola = new LinkedList<>();
        String str;
        char c;

        while (s.hasNext()) {

            str = s.nextLine();
            balanced = true;

            for (int i = 0; i < str.length() && balanced; i++) {
                c = str.charAt(i);
                if (c == '{' || c == '[' || c == '(') {
                    cola.addLast(c);
                }
                else if (c == ']' || c == '}' || c == ')') {
                    if (cola.isEmpty()) {
                        balanced = false;
                    }
                    else {
                        Character removed = cola.removeLast();
                        switch (c) {
                            case '}':
                                balanced = removed == '{';
                                break;
                            case ')':
                                balanced = removed == '(';
                                break;
                            case ']':
                                balanced = removed == '[';
                                break;
                            default:
                                balanced = false;
                        }
                    }
                }
            }

            balanced = balanced && cola.isEmpty();
            System.out.println( (balanced) ? "YES" : "NO" );
            cola.clear();
        }

    }

}
