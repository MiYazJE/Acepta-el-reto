import java.util.*;

/**
 * @author Rubén Saiz
 */

class User implements Comparable<User> {
    int id, time, sum;
    User(int id, int time) {
        this.id = id;
        this.time = time;
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

        while (true) {

            casos = s.nextInt();
            if (casos == 0) break;

            for (int i = 0; i < casos; i++) {
                id = s.nextInt();
                time = s.nextInt();
                User user = new User(id, time);
                user.sum = time;
                userList.add( user );
            }

            K = s.nextInt();
            for (int i = 0; i < K; i++) {
                User user = userList.poll();
                System.out.println( user.id );
                User newUser = new User(user.id, user.time + user.sum);
                newUser.sum = user.sum;
                userList.add( newUser );
            }

            userList.clear();
            System.out.println("----");
        }

    }

}
