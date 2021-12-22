import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

class Coordinate {
    int f, c;
    public Coordinate(int f, int c) {
        this.f = f;
        this.c = c;
    }
}

public class p479 {

    static int getClosest(Coordinate search, ArrayList<Coordinate> points, String direction) {
        int closest = Integer.MAX_VALUE;

        for (Coordinate current : points) {
            if (direction.equals("DERECHA")) {
                if (search.f == current.f && search.c <= current.c) closest = Math.min(closest, current.c - search.c);
            }
            else if (direction.equals("IZQUIERDA")) {
                if (search.f == current.f &&  search.c >= current.c) closest = Math.min(closest, search.c - current.c);
            }
            else if (direction.equals("ABAJO")) {
                if (search.c == current.c && search.f <= current.f) closest = Math.min(closest, current.f - search.f);
            }
            else if (direction.equals("ARRIBA")) {
                if (search.c == current.c && search.f >= current.f) closest = Math.min(closest, search.f - current.f);
            }
        }

        return closest == Integer.MAX_VALUE ? -1 : closest;
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        ArrayList<Coordinate> points = new ArrayList<Coordinate>();
        int f, c, q;
        String[] in;

        while (true) {
            in = br.readLine().split(" ");
            f = Integer.parseInt(in[0]);
            c = Integer.parseInt(in[1]);
            if (f == 0 && c == 0) break;

            for (int i = 0; i < f; i++) {
                char[] line = br.readLine().toCharArray();
                for (int j = 0; j < c; j++) {
                    if (line[j] == 'X') points.add(new Coordinate(i + 1, j + 1));
                }
            }

            q = Integer.parseInt(br.readLine());
            while (q-- != 0) {
                in = br.readLine().split(" ");
                Coordinate search = new Coordinate(Integer.parseInt(in[0]), Integer.parseInt(in[1]));
                String direction = in[2];
                int closest = getClosest(search, points, direction);
                System.out.println(closest == -1 ? "NINGUNO" : closest);
            }

            System.out.println("---");
            points.clear();
        }

    }

}
