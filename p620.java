import java.util.Scanner;

public class p620 {

    static boolean can(int pos, int[] nums, int size1, int size2, int many) {
        if (many == nums.length) return true;
        for (int i = pos; i < nums.length; i++) {
            if (size1 - nums[i] >= 0) {
                if (can(i + 1, nums, size1 - nums[i], size2, many + 1)) return true;
            }
            if (size2 - nums[i] >= 0) {
                if (can(i + 1, nums, size1, size2 - nums[i], many + 1)) return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {


        Scanner s = new Scanner(System.in);
        int n, size1, size2;
        int[] arr;

        while (s.hasNext()) {
            size1 = size2 = s.nextInt();
            if (size1 == 0) break;
            n = s.nextInt();
            arr = new int[n];
            for (int i = 0; i < n; i++) arr[i] = s.nextInt();
            System.out.println(can(0, arr, size1, size2,0) ? "SI" : "NO");
        }

    }

}
