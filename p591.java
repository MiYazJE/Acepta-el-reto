import java.math.BigInteger;
import java.util.*;

public class p591 {

    public static void main(String[] args) {

        Scanner s = new Scanner(System.in);

        long num;
        int size, half, indexI, indexJ, finalIndex;
        TreeMap<Integer, BigInteger> anillos = new TreeMap<>();

        while (s.hasNext()) {
            size = s.nextInt();
            half = size / 2;
            int to = size % 2 != 0 ? size / 2 + 1 : size / 2;
            for (int i = 0; i < to; i++) anillos.put(i, new BigInteger("0"));
            for (int i = 0; i < size; i++) {
                indexI = i <= half ? i : size - i - 1;
                if (size % 2 == 0 && i == half) indexI--;
                for (int j = 0; j < size; j++) {
                    indexJ = j <= half ? j : size - j - 1;
                    if (size % 2 == 0 && j == half) indexJ--;
                    num = s.nextLong();
                    finalIndex = Math.min(indexJ, indexI);
                    anillos.put(finalIndex, anillos.get(finalIndex).add(BigInteger.valueOf(num)));
                }
            }
            System.out.print(anillos.get(to - 1));
            for (int i = to - 2; i >= 0; i--) System.out.print(" " + anillos.get(i));
            System.out.println();
            anillos.clear();
        }

    }

}
