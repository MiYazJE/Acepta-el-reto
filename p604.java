import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class p604 {

    static int getCardValue(char c) {
        if (c == 'A') return 4;
        if (c == 'K') return 3;
        if (c == 'Q') return 2;
        if (c == 'J') return 1;
        return 0;
    }

    public static void main(String[] args) {

        Scanner s = new Scanner(System.in);

        int c = s.nextInt();
        int result;
        char carta, palo;
        HashMap<Character, Integer> baraja = new HashMap<>();

        while (c-- != 0) {
            baraja.put('C', 0);
            baraja.put('D', 0);
            baraja.put('P', 0);
            baraja.put('T', 0);
            result = 0;

            for (int i = 0; i < 13; i++) {
                carta = s.next().charAt(0);
                palo = s.next().charAt(0);
                int value = getCardValue(carta);
                result += value;
                baraja.put(palo, baraja.get(palo) + 1);
            }

            for (Map.Entry<Character, Integer> entry : baraja.entrySet()) {
                int value = entry.getValue();
                if (value == 0) result += 3;
                if (value == 1) result += 2;
                if (value == 2) result += 1;
            }

            System.out.println(result);
            baraja.clear();
        }

    }

}
