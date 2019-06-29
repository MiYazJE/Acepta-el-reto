import java.util.Scanner;

public class p278 {

    public static void main(String[] args) {

        Scanner s = new Scanner(System.in);

        int casos = s.nextInt();
        Long tiempoMax, tiempoTareas;
        String linea;
        String[] separador;
        boolean puede;

        for (int i = 0; i < casos; i++) {

            linea = s.next();
            separador = linea.split(":");

            tiempoMax =  Long.parseLong(separador[0]) * 86400;
            tiempoMax += Long.parseLong(separador[1]) * 3600;
            tiempoMax += Long.parseLong(separador[2]) * 60;
            tiempoMax += Long.parseLong(separador[3]);

            tiempoTareas = 0L;
            while (true) {

                linea = s.next();
                separador = linea.split(":");

                tiempoTareas += Long.parseLong(separador[0]) * 3600;
                tiempoTareas += Long.parseLong(separador[1]) * 60;
                tiempoTareas += Long.parseLong(separador[2]);

                puede = (tiempoTareas < tiempoMax);

                if (separador[0].equals("00") &&
                    separador[1].equals("00") &&
                    separador[2].equals("00"))
                    break;
            }

            System.out.println( (puede) ? "SI" : "NO");
        }

    }

}
