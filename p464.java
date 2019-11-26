import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.LinkedList;

class Tiempo implements Comparable<Tiempo> {

    int pos, tiempo;
    Tiempo(int j, int x) {pos = j; tiempo = x;}

    @Override
    public int compareTo(Tiempo o) {
        return this.tiempo - o.tiempo;
    }

    @Override
    public String toString() {
        return "Tiempo{" +
                "tiempo=" + tiempo +
                '}';
    }
}

public class p464 {

    public static void main(String[] args) throws IOException {

        final BufferedReader r = new BufferedReader(new InputStreamReader(System.in));

        Integer casos;
        int pos, auxPos;
        String[] tiempo;
        LinkedList<Tiempo> tiempos = new LinkedList<>();
        LinkedList<Tiempo> res = new LinkedList<>();
        Tiempo prev, actual;
        StringBuilder output = new StringBuilder();

        while (true) {

            String n = r.readLine();
            if (n == null) break;
            casos = Integer.parseInt(n);

            for (int i = 0; i < casos; i++) {
                tiempo = r.readLine().split(":");
                int secs = (Integer.parseInt(tiempo[0]) * 3600) + (Integer.parseInt(tiempo[1]) * 60) + Integer.parseInt(tiempo[2]);
                tiempos.add(new Tiempo(i, secs));
            }

            Collections.sort(tiempos);

            auxPos = pos = 1;
            prev = tiempos.get(0);
            res.add(new Tiempo(pos, prev.pos));
            for (int i = 1; i < tiempos.size(); i++) {
                actual = tiempos.get(i);
                ++auxPos;
                if (Math.abs(prev.tiempo - actual.tiempo) > 1) {
                    pos = auxPos;
                }
                prev = actual;
                res.add(new Tiempo(pos, actual.pos));
            }

            Collections.sort(res);

            for (int i = 0; i < casos; i++) {
                output.append(res.get(i).pos);
                if (i < casos - 1) output.append("\n");
            }

            System.out.println(output.toString());

            tiempos.clear();
            res.clear();
            output.delete(0, output.length());

            System.out.println("---");
        }

    }

}
