import java.util.HashMap;
import java.util.Scanner;

public class p637 {

    private static int getCost(String str) {
        int dots = 0, dashes = 0;
        for (char c : str.toCharArray()) {
            if (c == '-') dashes++;
            else dots++;
        }
        return (dashes * 3) +
                dots +
                str.length() - 1;
    }

    private static void initializeMap(HashMap<Character, Integer> map) {
        map.put('A', getCost(".-"));
        map.put('B', getCost("-..."));
        map.put('C', getCost("-.-."));
        map.put('D', getCost("-.."));
        map.put('E', getCost("."));
        map.put('F', getCost("..-."));
        map.put('G', getCost("--."));
        map.put('H', getCost("...."));
        map.put('I', getCost(".."));
        map.put('J', getCost(".---"));
        map.put('K', getCost("-.-"));
        map.put('L', getCost(".-.."));
        map.put('M', getCost("--"));
        map.put('N', getCost("-."));
        map.put('O', getCost("---"));
        map.put('P', getCost(".--."));
        map.put('Q', getCost("--.-"));
        map.put('R', getCost(".-."));
        map.put('S', getCost("..."));
        map.put('T', getCost("-"));
        map.put('U', getCost("..-"));
        map.put('V', getCost("...-"));
        map.put('W', getCost(".--"));
        map.put('X', getCost("-..-"));
        map.put('Y', getCost("-.--"));
        map.put('Z', getCost("--.."));
        map.put('?', getCost("..--.."));
        map.put('!', getCost("-.-.--"));
    }

    public static void main(String[] args) {

        Scanner s = new Scanner(System.in);

        HashMap<Character, Integer> map = new HashMap<>();
        initializeMap(map);

        int cases = s.nextInt();
        s.nextLine();

        while (cases-- != 0) {
            String[] words = s.nextLine().split(" ");

            int total = 0;
            for (int i = 0; i < words.length; i++) {
                String word = words[i];
                if (i > 0) total += 5;

                for (int j = 0; j < word.length(); j++) {
                    if (j > 0) total += 3;
                    total += map.get(word.charAt(j));
                }
            }

            System.out.println(total);
        }

    }

}
