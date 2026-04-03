import java.util.*;

public class p105 {

    public static void main(String[] args) {

        Scanner s = new Scanner(System.in);

        String num, output;
        String[] semana = {"MARTES", "MIERCOLES", "JUEVES", "VIERNES", "SABADO", "DOMINGO"};
        double n, min, max, domingo = 0, suma;
        int posMin = 0, posMax = 0;

        while (true) {

            max = Integer.MIN_VALUE;
            min = Integer.MAX_VALUE;
            suma = 0;

            for (int i = 0; i < 6; i++) {
                
                num = s.next();
                if (num.equals("-1")) System.exit(0);

                n = Double.parseDouble(num);
                if (i == 5) domingo = n;
                suma += n;
                
                if (n > max) {
                    max = n;
                    posMax = i;
                }
                if (n < min) {
                    min = n;
                    posMin = i;
                }

            }

            suma /= 6;
            
            if (posMin == posMax) output = "EMPATE";
            else {
                output = semana[posMax] + " ";
                output += semana[posMin];
            }

            if (domingo >= suma) output += " SI";
            else output += " NO"; 

            System.out.println( output );

        }

    }

}
