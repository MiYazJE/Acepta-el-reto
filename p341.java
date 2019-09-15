import java.util.*;

/**
 * @author Rubén Saiz
 */

class Estado {
    int val, index;
    Estado(int val, int index) {
        this.val = val;
        this.index = index;
    }
    public String toString() {
        return val + "-" + index;
    }
}

class sort implements Comparator<Estado> {
    public int compare(Estado o1, Estado o2) {
        if (o1.val == o2.val) return o1.index - o2.index;
        return o1.val - o2.val;
    }
}

public class p341 {

    public static void main(String[] args) {

        final Scanner s = new Scanner(System.in);
        Integer clientes, cajas;
        sort sort = new sort();

        while (s.hasNext()) {
            cajas = s.nextInt();
            clientes = s.nextInt();
            LinkedList<Estado> queue = new LinkedList<>();
            for (int i = 0; i < cajas; i++) queue.add(new Estado(0, i + 1));
            for (int i = 0; i < clientes; i++) {
                Collections.sort(queue, sort);
                int tiempo = s.nextInt();
                Estado aux = queue.removeFirst();
                aux.val += tiempo;
                queue.add(aux);
            }
            Collections.sort(queue, sort);
            System.out.println( queue.removeFirst().index );
        }

    }

}
