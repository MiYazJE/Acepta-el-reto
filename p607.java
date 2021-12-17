import java.util.Scanner;

public class p607 {

    static int[] preCompute() {
        int[] arr = new int[32];
        for (int i = 0; i < 32; i++) {
            arr[i] = Double.valueOf(Math.pow(2, i)).intValue();
        }
        return arr;
    }

    public static void main(String[] args) {

        final Scanner s = new Scanner(System.in);

        int[] powerOf2 = preCompute();
        int C = s.nextInt();
        Integer N;

        while (C-- != 0) {
            N = s.nextInt();
            int ans = 0;
            for (int i = 0; i < powerOf2.length; i++) {
                if (powerOf2[i] >= N) {
                    ans = i;
                    break;
                }
            }
            System.out.println(ans);
        }

    }

}
