import java.util.ArrayList;
import java.util.Scanner;

public class p142 {

    public static void main(String[] args) {

        Scanner s = new Scanner(System.in);

        int jugadores, saltos, eliminar;
        ArrayList<Integer> juego;

        while (true) {

            jugadores = s.nextInt();
            saltos    = s.nextInt();

            if (jugadores == 0 && saltos == 0) break;
            juego = new ArrayList<>();

            for (int i = 1; i <= jugadores; i++) juego.add(i);

            eliminar = 0;
            while (juego.size() > 1) {
                eliminar += saltos;
                eliminar %= juego.size();
                juego.remove(eliminar);
            }

            System.out.println(juego.get(0));
        }

    }

}
