import java.util.Scanner;

public class p282 {

    public static void main(String[] args) {

        Scanner s = new Scanner(System.in);

        int casos, size, parches, ant, next;

        while (s.hasNext()) {

            casos = s.nextInt();
            size  = s.nextInt();

            parches = 1;
            ant = s.nextInt();
            for (int i = 0; i < casos - 1; i++) {
                next = s.nextInt();
                if (ant + size < next) {
                    parches++;
                    ant = next;
                }
            }
            
            System.out.println( parches );
        }

    }

}
