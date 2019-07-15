import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

public class p198 {

    public static void main(String[] args) {

        Scanner s = new Scanner(System.in);

        char[] expresion;
        Stack<Integer> pila;
        Queue<Integer> cola;
        String resPila, resCola;
        boolean errorPila, errorCola;
        int n1, n2 = 0;

        while (s.hasNext()) {

            expresion = s.next().toCharArray();
            cola = new LinkedList<>();
            pila = new Stack<>();
            errorCola = errorPila = false;

            for (int i = 0; i < expresion.length; i++) {
                if (Character.isDigit(expresion[i])) {
                    int num = Integer.parseInt(""+expresion[i]);
                    cola.add(num); pila.push(num);
                }
                else {
                    switch (expresion[i]) {
                        case '+':
                            if (!errorPila)
                                n2 = pila.pop(); n1 = pila.pop(); pila.push(n1 + n2);
                            if (!errorCola)
                                n2 = cola.poll(); n1 = cola.poll(); cola.add(n1 + n2);
                            break;
                        case '-':
                            if (!errorPila)
                                n2 = pila.pop(); n1 = pila.pop(); pila.push(n1 - n2);
                            if (!errorCola)
                                n2 = cola.poll(); n1 = cola.poll(); cola.add(n1 - n2);
                            break;
                        case '/':
                            if (!errorPila)
                                try {
                                    n2 = pila.pop(); n1 = pila.pop(); pila.push(n1 / n2);
                                } catch(ArithmeticException e) {errorPila = true;}
                            if (!errorCola)
                                try {
                                    n2 = cola.poll(); n1 = cola.poll(); cola.add(n1 / n2);
                                } catch(ArithmeticException e) {errorCola = true;}
                            break;
                        case '*':
                            if (!errorPila)
                                n2 = pila.pop(); n1 = pila.pop(); pila.push(n1 * n2);
                            if (!errorCola)
                                n2 = cola.poll(); n1 = cola.poll(); cola.add(n1 * n2);
                    }
                }
            }

            resPila = (errorPila) ? "ERROR" : String.valueOf(pila.pop());
            resCola = (errorCola) ? "ERROR" : String.valueOf(cola.poll());

            if (resPila.equals(resCola)) System.out.println(resPila + " = " + resCola);
            else System.out.println(resPila + " != " + resCola);
        }

    }

}
