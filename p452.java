import java.util.*;

/**
 * @author Rubén Saiz
 */

public class p452 {

    public static void main(String[] args) {

        Scanner s = new Scanner(System.in);

        int numeros;
        int[] bingo;
        TreeSet<Integer> lista;
        
        while (true) {

            numeros = s.nextInt();
            if (numeros == 0) break;

            lista = new TreeSet<>();
            bingo = new int[numeros];

            for (int i = 0; i < numeros; i++) bingo[i] = s.nextInt();

            for (int i = 0; i < numeros-1; i++)
                for (int j = i+1; j < numeros; j++)
                    lista.add( Math.abs(bingo[i] - bingo[j]) );

            Iterator<Integer> i = lista.iterator();
            while (i.hasNext()) {
                System.out.print(i.next());
                if (i.hasNext()) System.out.print(" ");
                else System.out.println();
            }
            
        }

    }

}
