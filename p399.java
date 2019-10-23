import java.util.*;

public class p399 {

    static int[] toIntegers(String[] arr) {
        int[] res = new int[arr.length - 1];
        for (int i = 0; i < arr.length - 1; i++)
            res[i] = Integer.parseInt(arr[i]);
        return res;
    }

    static boolean canBe(int[] arr) {
        int[] vector = Arrays.copyOf(arr, arr.length);
        Arrays.sort(vector);
        for (int i = 0; i < vector.length; i++) {
            if (i % 2 == 1 && vector[i] != vector[i - 1])
                return false;
        }
        return true;
    }

    public static void main(String[] args) {

        final Scanner s = new Scanner(System.in);

        int[] arr;
        HashMap<Integer, Integer> veces = new HashMap<>();
        String[] input;
        ArrayList<Integer> list = new ArrayList<>();
        int max;

        while (true) {

            input = s.nextLine().split(" ");

            if (input.length == 1) break;
            arr = toIntegers(input);

            if (arr.length == 1) System.out.println(arr[0]);
            else if (arr.length % 2 == 0) System.out.println("NO");
            else {

                max = arr[0];
                veces.put(max, 1);

                for (int i = 1; i < arr.length; i++) {
                    max = Math.max(max, arr[i]);
                    if (veces.containsKey(arr[i])) {
                        veces.put(arr[i], veces.get(arr[i]) + 1);
                    }
                    else veces.put(arr[i], 1);
                }

                boolean valid = canBe(arr);

                if (!valid) {
                    System.out.println("NO");
                }
                else {

                    for (Map.Entry<Integer, Integer> entry : veces.entrySet())
                        for (int i = 0; i < entry.getValue() / 2; i++)
                            if (entry.getKey() != max)
                                list.add(entry.getKey());

                    Collections.sort(list);

                    // Left side
                    for (Integer n : list)
                        System.out.print(n + " ");

                    // Half
                    int m = veces.get(max);
                    for (int i = 0; i < m; i++)
                        System.out.print(max + " ");

                    // Right side
                    for (int i = list.size() - 1; i >= 0; i--) {
                        System.out.print(list.get(i));
                        if (i - 1 >= 0) System.out.print(" ");
                    }

                    list.clear();
                    System.out.println();
                }

                veces.clear();
            }

        }

    }

}
