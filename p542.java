import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

/**
 * @author Rubén Saiz
 */

public class p542 {

    public static void main(String[] args) {

        Scanner s = new Scanner(System.in);

        int casos = s.nextInt();
        boolean sirve;
        ArrayList<Integer> list1 = new ArrayList<>();
        ArrayList<Integer> list2 = new ArrayList<>();

        while (casos-- != 0) {
            for (int i = 0; i < 3; i++) list1.add(s.nextInt());
            for (int i = 0; i < 3; i++) list2.add(s.nextInt());
            Collections.sort(list1);
            Collections.sort(list2);
            if (list1.get(2) < list2.get(2)) {
                if (list1.get(1) < list2.get(1)) {
                    if (list1.get(0) < list2.get(0)) {
                        sirve = true;
                    }
                    else sirve = false;
                }
                else sirve = false;
            }
            else sirve = false;
            System.out.println( sirve ? "SIRVE" : "NO SIRVE" );
            list1.clear();
            list2.clear();
        }

    }


}
