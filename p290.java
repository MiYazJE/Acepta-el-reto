import java.io.IOException;
import java.io.InputStream;

/**
 * @author Rubén Saiz
 */

public class p290 {

    final static FR s = new FR(System.in);

    static int max, index;
    static void getAltura(String input, int temp) {
        if (index == input.length() - 1) return;
        char c = input.charAt(index++);
        if (c != '.') getAltura(input, temp+1);
        else max = Math.max(temp, max);

        if (index == input.length()) return;
        c = input.charAt(index++);
        if (c != '.') getAltura(input, temp+1);
        else max = Math.max(temp, max);
    }

    public static void main(String[] args) {

        for (int i = s.readInt(); i > 0; i--) {
            String line = s.readString();
            max = index = 0;
            getAltura(line, 0);
            System.out.println( max );
        }
        
    }

}

class FR {

    private InputStream stream;
    private byte[] buf = new byte[1024];

    private int curChar;

    private int numChars;

    public FR(InputStream stream) {
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

    public int readInt() {
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
