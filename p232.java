import java.util.Scanner;

class Fecha {
    int dia, mes, year;
    Fecha(int d, int m, int y) {
        dia = d; mes = m - 1; year = y;
    }

    @Override
    public String toString() {
        return "Fecha{" +
                "dia=" + dia +
                ", mes=" + mes +
                ", year=" + year +
                '}';
    }
}

public class p232 {

    static boolean salir(String[] input) {
        for (int i = 0; i < input.length; i++) {
            if (!input[i].equals("0")) return false;
        }
        return true;
    }

    public static void main(String[] args) {

        final Scanner s = new Scanner(System.in);

        final int[] meses = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        String[] input;
        int res;
        Fecha nacimiento, actual;

        while (true) {

            input = s.nextLine().split(" ");
            if (salir(input)) break;

            nacimiento = new Fecha(
                    Integer.parseInt(input[0]), Integer.parseInt(input[1]), Integer.parseInt(input[2])
            );
            actual = new Fecha(
                    Integer.parseInt(input[3]), Integer.parseInt(input[4]), Integer.parseInt(input[5])
            );

            res = 0;

            if (nacimiento.dia != actual.dia || nacimiento.mes != actual.mes) {

                if (nacimiento.year == actual.year && actual.mes == nacimiento.mes) {
                    res += actual.dia - nacimiento.dia;
                }
                else if (nacimiento.year == actual.year) {
                    res += meses[nacimiento.mes] - nacimiento.dia;
                    for (int i = nacimiento.mes + 1; i < actual.mes; i++) {
                        res += meses[i];
                    }
                    res += actual.dia;
                }
                else {
                    for (int i = nacimiento.year; i <= actual.year; i++) {
                        if (i > nacimiento.year && i < actual.year) {
                            res += 364;
                        }
                        else if (i == actual.year) {
                            for (int j = 0; j < actual.mes; j++) {
                                res += meses[j];
                            }
                            res += actual.dia;
                        }
                        else {
                            res += meses[nacimiento.mes] - nacimiento.dia;
                            for (int j = nacimiento.mes + 1; j < 12; j++) {
                                res += meses[j];
                            }
                        }
                    }
                    if (nacimiento.mes < actual.mes ||
                        (nacimiento.mes == actual.mes && nacimiento.dia < actual.dia))
                        res--;
                }
            }

            System.out.println(res);
        }

    }

}
