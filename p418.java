import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class p418 {

    public static void main(String[] args) {

        Scanner s = new Scanner(System.in);
        int c, n, currentSum;
        String str;
        ArrayList<String> instructions = new ArrayList<String>();
        HashMap<Integer, Integer> relations = new HashMap<Integer, Integer>();
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        ArrayList<Integer> nums = new ArrayList<Integer>();

        c = s.nextInt();
        while (c-- != 0) {

            currentSum = 10;
            while (true) {
                n = s.nextInt();
                if (n == 0) break;
                map.put(n, currentSum);
                nums.add(n);
                currentSum += 10;
                str = s.next();
                if (!str.equals("RETURN")) {
                    relations.put(n, s.nextInt());
                }
                instructions.add(str);
            }

            for (int i = 0; i < nums.size(); i++) {
                int currentNum = nums.get(i);
                String currentInstruction = instructions.get(i);
                System.out.print(map.get(currentNum) + " " + currentInstruction);
                if (currentInstruction.equals("RETURN")) System.out.print("\n");
                else System.out.println(" " + map.get(relations.get(currentNum)));
            }
            System.out.println("---");

            map.clear();
            relations.clear();
            nums.clear();
            instructions.clear();
        }

    }

}
