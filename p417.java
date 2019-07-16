import java.util.Scanner;

public class p417 {

    public static void main(String[] args) {

        Scanner s = new Scanner(System.in);

        String palabra;
        boolean ciclica;
        int size, pos;

        while (s.hasNext()) {

            palabra = s.next().toLowerCase();
            size = 0;
            ciclica = true;

            for (int i = 0; i < palabra.length()/2; i++) {
                ciclica = true; pos = 0;
                for (int j = i+1; j < palabra.length(); j++) {
                    if (palabra.charAt(pos) != palabra.charAt(j)) { ciclica = false; break;}
                    pos++; pos %= i+1;
                }
                if (ciclica) { size = i+1; break; }
            }

            System.out.println( (ciclica && size>0 && palabra.length()%size==0) ? size : palabra.length() );
        }

    }

}
