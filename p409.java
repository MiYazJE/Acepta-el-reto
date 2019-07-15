import java.util.Scanner;

/**
 * @author Rubén Saiz
 */

public class p409 {

    public static void shellSort(int[] data) {
        int inner, outer;
        int temp;
        int len = data.length;
        //find initial value of h
        int h = 1;
        while (h <= len / 3)
            h = h * 3 + 1; // (1, 4, 13, 40, 121, ...)

        while (h > 0) // decreasing h, until h=1
        {
            // h-sort the file
            for (outer = h; outer < len; outer++) {
                temp = data[outer];
                inner = outer;
                // one subpass (eg 0, 4, 8)
                while (inner > h - 1 && data[inner - h] > temp) {
                    data[inner] = data[inner - h];
                    inner -= h;
                }
                data[inner] = temp;
            }
            h = (h - 1) / 3; // decrease h
        }
    }

    public static void main(String[] args) {

        Scanner s = new Scanner(System.in);

        int casos = s.nextInt();
        int[] arr;
        int castellers, alturas, total;

        for (int i = 0; i < casos; i++) {

            castellers = s.nextInt();
            alturas    = s.nextInt();
            arr = new int[alturas];

            for (int j = 0; j < alturas; j++) arr[j] = s.nextInt();
            shellSort(arr);

            total = 0;
            castellers--;
            for (int j = castellers; j < alturas; j++) {
                if (arr[j] - arr[j-castellers] <= 15) {
                    j += castellers;
                    total++;
                }
            }

            System.out.println( total );
        }

    }

}
