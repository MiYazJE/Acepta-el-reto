    import java.io.*;

    /**
     * @author Rubén Saiz
     */

    class Arbol {
        int val;
        Arbol left, right;
        Arbol(int x) { val = x; }
        public String toString() {
            return String.valueOf( val );
        }
    }

    public class p298 {

        static FastReader r = new FastReader(System.in);

        static void insertNodes(Arbol node) {

            int value = r.readInt();
            if (value != -1) {
                node.left = new Arbol( value );
                insertNodes(node.left);
            }

            value = r.readInt();
            if (value != -1) {
                node.right = new Arbol( value );
                insertNodes( node.right);
            }

        }

        static boolean isBST(Arbol node, Integer min, Integer max) {
            if (node == null) return true;
            if (min != null && node.val <= min ||
                max != null && node.val >= max)
                return false;
            return  isBST(node.left, min, node.val) &&
                    isBST(node.right, node.val, max);
        }

        public static void main(String[] args) {

            int rootValue;

            for (int i = r.readInt(); i > 0; i--) {

                rootValue = r.readInt();
                if (rootValue == -1) System.out.println("SI");
                else {
                    Arbol root = new Arbol( rootValue );
                    insertNodes( root );
                    System.out.println( isBST(root, null, null) ? "SI" : "NO" );
                }

            }

        }

    }

    class FastReader {
        private InputStream stream;
        private byte[] buf = new byte[1024];

        private int curChar;

        private int numChars;

        public FastReader(InputStream stream) {
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
                stringBuilder.append(c);
                c = read();
            } while (!isSpaceChar((char) c));
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
