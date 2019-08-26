import java.io.IOException;
import java.io.InputStream;

public class p525 {

    final static Reader s = new Reader(System.in);

    public static void main(String[] args) {

        int n1_1, n1_2, n2_1, n2_2;

        for (int i = s.nextInt(); i > 0; i--) {

            n1_1 = s.nextInt();
            n1_2 = s.nextInt();
            n2_1 = s.nextInt();
            n2_2 = s.nextInt();

            if (n1_1 > n1_2) {
                int temp = n1_2;
                n1_2 = n1_1;
                n1_1 = temp;
            }
            if (n2_1 > n2_2) {
                int temp = n2_2;
                n2_2 = n2_1;
                n2_1 = temp;
            }
            if ((n1_1 <= n2_1 && n1_2 <= n2_1) || n1_1 >= n2_2) System.out.println("SEPARADOS");
            else System.out.println("SOLAPADOS");

        }

    }

}

class Reader {
    private InputStream stream;
    private byte[] buf = new byte[1024];

    private int curChar;

    private int numChars;

    public Reader(InputStream stream) {
        this.stream = stream;
    }

    public int read() {
        if (numChars == -1)
            throw new RuntimeException();
        if (curChar >= numChars) {
            curChar = 0;
            try {
                numChars = stream.read(buf);
            } catch (IOException e) {
                throw new RuntimeException();
            }
            if (numChars <= 0)
                return -1;
        }
        return buf[curChar++];
    }

    public String readString() {
        final StringBuilder stringBuilder = new StringBuilder();
        int c = read();
        while (isSpaceChar(c))
            c = read();
        do {
            stringBuilder.append((char)c);
            c = read();
        } while (!isSpaceChar(c));
        return stringBuilder.toString();
    }

    public int nextInt() {
        int c = read();
        while (isSpaceChar(c))
            c = read();
        int sgn = 1;
        if (c == '-') {
            sgn = -1;
            c = read();
        }
        int res = 0;
        do {
            res *= 10;
            res += c - '0';
            c = read();
        } while (!isSpaceChar(c));
        return res * sgn;
    }

    public long readLong() {
        int c = read();
        while (isSpaceChar(c))
            c = read();
        int sgn = 1;
        if (c == '-') {
            sgn = -1;
            c = read();
        }
        long res = 0;
        do {
            res *= 10;
            res += c - '0';
            c = read();
        } while (!isSpaceChar(c));
        return res * sgn;
    }

    public boolean isSpaceChar(int c) {
        return c == ' ' || c == '\n' || c == '\r' || c == '\t' || c == -1;
    }
}
