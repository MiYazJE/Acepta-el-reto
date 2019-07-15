import java.util.ArrayList;
import java.util.Scanner;

/**
 * @author Rubén Saiz
 */

public class p349 {

    public static boolean salir(ArrayList<String> nums) {
        boolean salir = true;
        for (int i = 0; i < nums.size(); i++) {
            if (isNaN(nums.get(i))) {salir = false; break;}
        }
        return salir;
    }

    public static boolean isNaN(String test) {
        String[] ops = {"*", "-", "+", "/"};
        for (int i = 0; i < 4; i++)
            if (test.equals(ops[i])) return true;
        return false;
    }

    public static void main(String[] args) {

        Scanner s = new Scanner(System.in);

        int casos = s.nextInt();
        s.nextLine();
        int res=0, n1, n2;
        char[] temp;
        ArrayList<String> operaciones;

        for (int i = 0; i < casos; i++) {

            temp = s.nextLine().toCharArray();
            operaciones = new ArrayList<>();

            for (int j = 0; j < temp.length; j++) {
                if (temp[j] == ' ') continue;
                operaciones.add(""+temp[j]);
            }

            while (true) {

                for (int j = operaciones.size()-1; j >= 0; j--) {

                    String op = operaciones.get(j);

                    if (isNaN(op)) {

                        if (isNaN(operaciones.get(j+1))) continue;
                        n1 = Integer.parseInt(operaciones.get(j+1));
                        n2 = Integer.parseInt(operaciones.get(j+2));

                        switch (op) {
                            case "*": res = n1 * n2; break;
                            case "+": res = n1 + n2; break;
                            case "/": res = n1 / n2; break;
                            case "-": res = n1 - n2;
                        }

                        operaciones.remove(j); operaciones.remove(j); operaciones.remove(j);
                        if (j == 0) operaciones.add(0, String.valueOf(res));
                        else operaciones.add(j, String.valueOf(res));
                        j = operaciones.size()-1;
                    }

                }

                if (salir(operaciones)) break;
            }

            System.out.println( operaciones.get(0) );
        }
    }

}
