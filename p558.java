import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

class CamelCasi {

    String camelCase;
    int camelLetters;

    public CamelCasi(String word) {
        this.camelLetters = -1;
        this.getCamelLetters(word);
    }

    public void getCamelLetters(String word) {
        int count = 0;
        for (char c : word.toCharArray()) {
            if (Character.isUpperCase(c)) {
                count++;
            }
        }
        if (count > this.camelLetters) {
            this.camelLetters = count;
            this.camelCase = word;
        }
    }

}

public class p558 {

    public static void main(String[] args) {

        final Scanner s = new Scanner(System.in);
        HashMap<String, CamelCasi> words = new HashMap<>();
        int n;
        String str;
        ArrayList<String> list = new ArrayList<>();

        while (s.hasNext()) {
            n = s.nextInt();
            for (int i = 0; i < n; i++) {
                str = s.next();
                if (!words.containsKey(str.toLowerCase())) {
                    words.put(str.toLowerCase(), new CamelCasi(str));
                }
                else {
                    CamelCasi camelCase = words.get(str.toLowerCase());
                    camelCase.getCamelLetters(str);
                }
                list.add(str);
            }

            for (String word : list) {
                System.out.println( words.get(word.toLowerCase()).camelCase );
            }

            System.out.println("---");
            words.clear();
            list.clear();
        }

    }

}
