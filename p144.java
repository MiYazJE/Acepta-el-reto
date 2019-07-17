import java.util.ArrayList;
import java.util.Scanner;

/**
 * @author Rubén Saiz
 */

public class p144 {

    public static void main(String[] args) {

        Scanner s = new Scanner(System.in);

        ArrayList<Character> letras;
        String presionadas;
        int pos;

        while (s.hasNext()) {

            presionadas = s.nextLine();

            pos = 0; letras = new ArrayList<>();
            for (int i = 0; i < presionadas.length(); i++) {
                switch (presionadas.charAt(i)) {
                    case '-': pos = 0; break;
                    case '*': pos++; break;
                    case '3':
                        if (!letras.isEmpty() && pos <= letras.size() - 1)
                            letras.remove(pos); break;
                    case '+':
                        if (letras.isEmpty()) pos = 0;
                        else pos = letras.size();
                        break;
                    default:
                        if (pos > letras.size())
                            if (!letras.isEmpty()) pos = letras.size();
                            else pos = 0;
                        letras.add(pos++, presionadas.charAt(i));
                }
            }

            for (Character c : letras) System.out.print(c + "");
            System.out.println();
        }

    }

}
