import java.util.*;

/**
 * @author Rubén Saiz
 */

class Paciente implements Comparable<Paciente> {

    String nombre;
    int urgencia;
    int espera;

    public Paciente(String nombre, int urgencia, int espera) {
        this.nombre = nombre;
        this.urgencia = urgencia;
        this.espera = espera;
    }

    @Override
    public int compareTo(Paciente o) {
        if (o.urgencia == this.urgencia) return this.espera - o.espera;
        return o.urgencia - this.urgencia;
    }

    @Override
    public String toString() {
        return "Paciente{" +
                "nombre='" + nombre + '\'' +
                ", urgencia=" + urgencia +
                '}';
    }
}

public class p311 {

    public static void main(String[] args) {

        final Scanner s = new Scanner(System.in);

        String estado, nombre;
        int n, urgencia;

        PriorityQueue<Paciente> listaPacientes = new PriorityQueue<>();

        while (true) {

            n = s.nextInt();
            if (n == 0) break;

            for (int i = 0; i < n; i++) {
                estado = s.next();
                if (estado.equals("I")) {
                    nombre   = s.next();
                    urgencia = s.nextInt();
                    listaPacientes.add(new Paciente(nombre, urgencia, i));
                }
                else {
                    System.out.println(listaPacientes.poll().nombre);
                }
            }

            System.out.println("----");
            listaPacientes.clear();
        }

    }

}
