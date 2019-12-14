import java.util.*;

public class p102 {

    private static int getNumVocales(String str) {
        int cont = 0;
        str = str.toLowerCase();
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if (Character.isLetter(c)) {
                if (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u') {
                    cont++;
                }
            }
        }
        return cont;
    }

    private static String descodificar(String codificada, int desplazamiento) {

        String decodificada = "";
        int letterValue;
        char c, newLetter;

        for (int i = 1; i < codificada.length(); i++) {

            c = Character.toLowerCase(codificada.charAt(i));

            if (Character.isLetter(c)) {

                letterValue = c + desplazamiento;
                if (letterValue < 97) {
                    letterValue = 123 - (97 - letterValue);
                }
                else if (letterValue > 122) {
                    letterValue = 96 + (letterValue - 122);
                }

                newLetter = (char)letterValue;
                if (Character.isUpperCase(codificada.charAt(i))) {
                    newLetter = Character.toUpperCase(newLetter);
                }

                decodificada += newLetter;
            }
            else {
                decodificada += c;
            }

        }

        return decodificada;
    }

    private static int calcularDesplazamiento(char codigo) {

        codigo = Character.toLowerCase(codigo);

        int left  = (codigo < 'p')
                ? -((codigo - 'a') + (123 - 'p'))
                : -(codigo - 'p');
        int right = (codigo > 'p')
                ? (('z' - codigo) + ('p' - 96))
                : ('p' - codigo);

        return (Math.abs(left) <= right) ? left : right;
    }

    public static void main(String[] args) {

        Scanner s = new Scanner(System.in);

        boolean keep = true;
        String codificada, decodificada;
        int desplazamiento, vocales;

        while (keep) {

            codificada = s.nextLine();
            desplazamiento = calcularDesplazamiento(codificada.charAt(0));

            decodificada = descodificar(codificada, desplazamiento);

            if (decodificada.equals("FIN")) {
                keep = false;
            }
            else {
                vocales = getNumVocales( decodificada );
                System.out.println( vocales );
            }

        }

    }

}
