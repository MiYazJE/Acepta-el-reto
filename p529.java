package ejercicio529;

import java.util.Scanner;

public class p529 {

    public static void main(String[] args) {

        Scanner s = new Scanner(System.in);

        int casos = s.nextInt();
        String linea;
        char[] logs;
        int login, max;

        for (int i = 0; i < casos; i++) {

            linea = s.next();
            logs = linea.toCharArray();

            login = max = 0;
            for (int j = 0; j < logs.length; j++) {
                if (logs[j] == 'I') login++;
                if (logs[j] == 'O') {
                    if (login > 0) login--;
                    else max++;
                }
                max = Math.max(max, login);
            }

            System.out.println( max );
        }

    }

}
