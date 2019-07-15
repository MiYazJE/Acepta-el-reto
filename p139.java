import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

/**
 * @author Rubén Saiz
 */

public class p139 {

    public static int count(String num) {
        int sum = 0;
        for (int i = 0; i < num.length(); i++) {
            sum += Integer.parseInt(""+num.charAt(i));
            if (sum > 1) return sum;
        }
        return sum;
    }

    public static void main(String[] args) {

        Scanner s = new Scanner(System.in);

        int num, digito;
        String temp;
        int suma;
        int compare;
        Set<Integer> set;

        while (true) {

            num = s.nextInt();
            if (num == 0) break;

            set = new TreeSet<>();
            set.add(num);

            if (num == 1) System.out.println(num + " -> cubifinito.");
            else {

                System.out.print(num + " - ");
                while (true) {

                    suma = 0;
                    temp = String.valueOf(num);
                    for (int i = temp.length()-1; i >= 0; i--) {
                        digito = Integer.parseInt(""+temp.charAt(i));
                        suma += digito * digito * digito;
                    }

                    if (suma == 1)  {
                        System.out.println(suma + " -> cubifinito.");
                        break;
                    }
                    else if (set.contains(suma)) {
                        System.out.println(suma + " -> no cubifinito.");
                        break;
                    }
                    else {
                        set.add(suma);
                        num = suma;
                        System.out.print(suma + " - ");
                    }

                }

            }

        }

    }

}
