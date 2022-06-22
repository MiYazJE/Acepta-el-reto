import java.util.Scanner;

public class p639 {

    static int getMinDiffOfThreeNums(int a, int b, int c) {
        return Math.max(a, Math.max(b, c)) - Math.min(a, Math.min(b, c));
    }

    public static void main(String[] args) {

        Scanner s = new Scanner(System.in);

        while (s.hasNext()) {
            int n = s.nextInt();
            int[] arr = new int[n];

            int sum = 0;
            for (int i = 0; i < n; i++) {
                arr[i] = s.nextInt();
                sum += arr[i];
            }

            int a = arr[0];
            int c = arr[n - 1];
            int b = sum - (a + c);
            int currentMinDiff = getMinDiffOfThreeNums(a, b, c);

            int left = 1, right = n - 2;
            while (left < right) {
                int newA = a + arr[left];
                int newC = c + arr[right];

                if (newA < newC) {
                    currentMinDiff = Math.min(currentMinDiff, getMinDiffOfThreeNums(newA, b - arr[left], c));
                    currentMinDiff = Math.min(currentMinDiff, getMinDiffOfThreeNums(a, b - arr[right], newC));
                    a = newA;
                    b -= arr[left++];
                }
                else {
                    currentMinDiff = Math.min(currentMinDiff, getMinDiffOfThreeNums(a, b - arr[right], newC));
                    currentMinDiff = Math.min(currentMinDiff, getMinDiffOfThreeNums(newA, b - arr[left], c));
                    c = newC;
                    b -= arr[right--];
                }
            }

            System.out.println(currentMinDiff);
        }

    }

}
