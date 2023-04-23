import java.util.Scanner;

public class p683 {

    static int getMinDistance(int[] arr, int from, int to) {
        int minDistance = Integer.MAX_VALUE;
        int temp = 0;
        boolean searching = false;

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == from) {
                temp = 0;
                searching = true;
            }
            if (arr[i] == to && searching) {
                minDistance = Math.min(minDistance, temp);
                searching = false;
            }
            if (searching) temp++;
        }

        return minDistance;
    }

    public static void main(String[] args) {

        Scanner s = new Scanner(System.in);
        int n;
        int[] arr;

        while (true) {
            n = s.nextInt();
            if (n == 0) return;

            int min = Integer.MAX_VALUE;
            int max = Integer.MIN_VALUE;
            arr = new int[n];
            for (int i = 0; i < n; i++) {
                int num = s.nextInt();
                arr[i] = num;
                min = Math.min(min, num);
                max = Math.max(max, num);
            }

            System.out.println(
                    min + " " +
                    max + " " +
                    Math.min(getMinDistance(arr, min, max), getMinDistance(arr, max, min))
            );
        }

    }

}
