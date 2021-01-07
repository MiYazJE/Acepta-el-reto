import java.util.Scanner;

public class p582 {

    public static void main(String[] args) {

        final Scanner s = new Scanner(System.in);

        int cases = s.nextInt();
        s.nextLine();
        boolean correcto, primero, marisaNaranjo;

        for (int i = 0; i < cases; i++) {
            primero = marisaNaranjo = false;
            correcto = true;
            String[] arr = s.nextLine().split(" ");
            for (int j = 0; j < arr.length && correcto; j++) {
                String str = arr[j];
                if (str.equals("")) marisaNaranjo = true;
                if (j == 0 && str.equals("doong")) primero = true;
                else if (str.equals("ding-dong")) correcto = false;
            }
            if (marisaNaranjo) System.out.println("MARISA NARANJO");
            else if (correcto && primero && arr.length >= 12) System.out.println("CORRECTO");
            else if (correcto && arr.length < 12) System.out.println("TARDE");
            else System.out.println("SALIDA NULA");
        }


    }

}
