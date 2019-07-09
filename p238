import java.util.ArrayList;
import java.util.Scanner;

/**
 * @author Rubén Saiz
 */

class Participante {

    String nums;
    int total;

    Participante() {
        nums = "";
        total = 0;
    }

    void agregar(String num) {
        nums += " " + num;
        total += Integer.valueOf( num );
    }

    @Override
    public String toString() {
        return String.format("%d:%s", total, nums);
    }
}

public class p238 {

    public static void main(String[] args) {

        Scanner s = new Scanner(System.in);

        int numBilletes, participantes, j, pos;
        ArrayList<Participante> listaParticipantes;

        while (true) {

            numBilletes = s.nextInt();
            participantes = s.nextInt();
            if (numBilletes == 0 && participantes == 0) break;

            listaParticipantes = new ArrayList<>();
            j = 0; pos = 0;
            while (j < numBilletes) {
                if (listaParticipantes.size() != participantes) {
                    listaParticipantes.add(new Participante());
                }
                if (pos == participantes) pos = 0;
                listaParticipantes.get(pos).agregar( s.next() );
                j++; pos++;
            }

            for (int i = 0; i < participantes; i++) {
                if (i > listaParticipantes.size()-1)
                    System.out.println("0:");
                else
                    System.out.println(listaParticipantes.get(i));
            }
            System.out.println("---");

        }

    }

}
