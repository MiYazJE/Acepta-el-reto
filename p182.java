import java.util.Scanner;

public class p182 {

    public static void main(String[] args) {

        Scanner s = new Scanner(System.in);

        int num, iteraciones;
        String aux;
        int casos = s.nextInt();

        for (int k = 0; k < casos; k++) {

            num = s.nextInt();
            aux = String.valueOf(num);
            iteraciones = 0;

            if (aux.length() == 1) System.out.println(0);
            else {
                while (aux.length() != 1) {
                    iteraciones++;
                    num = Integer.parseInt(""+aux.charAt(0));
                    for (int i = 1; i < aux.length(); i++) {
                        num *= Integer.parseInt(""+aux.charAt(i));
                    }
                    aux = String.valueOf(num);
                }
                System.out.println( iteraciones );
            }

        }

    }

}
