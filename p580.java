import java.util.*;

public class p580 {

    public static void main(String[] args) {

        Scanner s = new Scanner(System.in);

        HashMap<String, Integer> count = new HashMap<>();
        int n, ans, many;
        String name;

        while (true) {
            n = s.nextInt();
            if (n == 0) break;
            ans = many = 0;
            for (int i = 0; i < n; i++) {
                name = s.next();
                if (!count.containsKey(name)) count.put(name, 1);
                else count.put(name, count.get(name) + 1);
                if (count.size() >= 3 && count.containsKey("Mafalda")) {
                    ans++;
                    LinkedList<String> remove = new LinkedList<>();
                    LinkedList<String> decrease = new LinkedList<>();
                    for (Map.Entry<String, Integer> m : count.entrySet()) {
                        many++;
                        if (m.getValue() == 1) remove.push(m.getKey());
                        else decrease.push(m.getKey());
                    }
                    for (String x : remove) count.remove(x);
                    for (String x : decrease) count.put(x, count.get(x) - 1);
                }
            }
            System.out.println( ans + " " + (n - many) );
            count.clear();
        }

    }

}
