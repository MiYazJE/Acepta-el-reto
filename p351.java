import java.util.*;

/**
 * @author Rubén Saiz
 */

class User implements Comparable<User> {
    int id, time;
    User(int id, int time) {
        this.id = id; this.time = time;
    }
    @Override
    public int compareTo(User o) {
        if (this.time == o.time) return this.id - o.id;
        return this.time - o.time;
    }
}

public class p351 {

    public static void main(String[] args) {

        final Scanner s = new Scanner(System.in);

        int id, time, casos, K;
        Queue<User> userList = new PriorityQueue<>();
        Map<Integer, Integer> times = new HashMap<>();

        while (true) {

            casos = s.nextInt();
            if (casos == 0) break;

            for (int i = 0; i < casos; i++) {
                id = s.nextInt();
                time = s.nextInt();
                userList.add(new User(id, time));
                times.put(id, time);
            }

            K = s.nextInt();
            for (int i = 0; i < K; i++) {
                User user = userList.poll();
                System.out.println( user.id );
                userList.add(new User(user.id, user.time + times.get(user.id)));
            }

            times.clear();
            userList.clear();
            System.out.println("----");
        }

    }

}
