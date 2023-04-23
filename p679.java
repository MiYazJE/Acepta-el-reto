import java.util.LinkedList;
import java.util.Scanner;

public class p679 {

    public static void main(String[] args) {

        Scanner s = new Scanner(System.in);
        LinkedList<String> phrase = new LinkedList<>();
        LinkedList<String> temp = new LinkedList<>();
        int c = s.nextInt();

        while (c-- != 0) {

            String prevAction = null;
            while (true) {
                String str = s.next();
                if (str.equals(".")) break;

                if (!str.equals(">") && !str.equals("<")) {
                    phrase.addLast(str);
                    prevAction = str;
                    temp.clear();
                }

                if (str.equals("<") && !phrase.isEmpty()) {
                    String wordRemoved = phrase.removeLast();
                    temp.addLast(wordRemoved);
                }

                if (str.equals(">")) {
                    if (temp.isEmpty() && prevAction != null) {
                        phrase.addLast(prevAction);
                    }
                    else if (!temp.isEmpty()) {
                        String wordToAdd = temp.removeLast();
                        phrase.addLast(wordToAdd);
                    }

                }

            }

            String res = "";
            while (!phrase.isEmpty()) {
                res += phrase.removeFirst();
                if (!phrase.isEmpty()) res += " ";
            }

            System.out.println( res );
            temp.clear();
        }

    }

}
