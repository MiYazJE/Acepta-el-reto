import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.Scanner;

class Tarea {
    int prioridad, duracion;
    Tarea(int p, int d) {
        this.prioridad = p;
        this.duracion = d;
    }
}

class SortTareas implements Comparator<Tarea> {
    @Override
    public int compare(Tarea tarea1, Tarea tarea2) {
        if (tarea1.prioridad == tarea2.prioridad) return tarea1.duracion - tarea2.duracion;
        return tarea2.prioridad - tarea1.prioridad;
    }
}

public class p579 {

    public static void main(String[] args) {

        final Scanner s = new Scanner(System.in);

        LinkedList<Tarea> tareas = new LinkedList<>();
        SortTareas sortTareas = new SortTareas();

        while (true) {
            int n = s.nextInt();
            if (n == 0) break;
            for (int i = 0; i < n; i++) {
                tareas.add(new Tarea(s.nextInt(), s.nextInt()));
            }
            Collections.sort(tareas, sortTareas);
            for (Tarea tarea : tareas) {
                System.out.println(tarea.prioridad + " " + tarea.duracion);
            }
            System.out.println("---");
            tareas.clear();
        }

    }

}
