import java.util.Scanner;

class Version {
    int mayor;
    int minor;
    int patch;

    Version(int mayor, int minor, int patch) {
        this.mayor = mayor;
        this.minor = minor;
        this.patch = patch;
    }
}

public class p665 {

    public static void main(String[] args) {

        Scanner s = new Scanner(System.in);

        Version v1, v2;
        boolean valid;
        int n = s.nextInt();

        while (n-- != 0) {
            String[] a = s.next().split("\\.");
            String[] b = s.next().split("\\.");

            v1 = new Version(Integer.parseInt(a[0]), Integer.parseInt(a[1]), Integer.parseInt(a[2]));
            v2 = new Version(Integer.parseInt(b[0]), Integer.parseInt(b[1]), Integer.parseInt(b[2]));

            boolean mayorUpdated = v2.mayor - v1.mayor == 1;
            valid = !mayorUpdated || (v2.minor == 0 && v2.patch == 0);

            boolean minorUpdated = v2.minor - v1.minor == 1;
            valid = valid && (!minorUpdated || (v1.mayor == v2.mayor && v2.patch == 0));

            boolean patchUpdated = v2.patch - v1.patch == 1;
            valid = valid && (!patchUpdated || (v1.mayor == v2.mayor && v1.minor == v2.minor));

            valid = valid && (mayorUpdated || minorUpdated || patchUpdated);

            System.out.println(valid ? "SI" : "NO");
        }

    }

}
