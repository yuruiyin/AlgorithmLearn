public class Problem158 {

    private int size = 0;
    private int i = 0;
    private char[] tmpBuf = new char[4];

    private int read4(char[] buf) {
        System.arraycopy(new char[]{'a', 'b', 'c'}, 0, buf, 0, 3);
        return 3;
    }

    /**
     * @param buf Destination buffer
     * @param n   Number of characters to read
     * @return    The number of actual characters read
     */
    public int read(char[] buf, int n) {
        int index = 0;

        while (index < n) {
            if (size == 0) {
                size = read4(tmpBuf);
                if (size == 0) {
                    break;
                }
            }

            while (index < n && i < size) {
                buf[index++] = tmpBuf[i++];
            }

            if (i == size) {
                i = 0;
                size = 0;
            }
        }

        return index;
    }

    public static void main(String[] args) {
        char[] buf = new char[4];
        int n = new Problem158().read(buf, 1);
        System.out.println(buf[0] + "," + n);
        n = new Problem158().read(buf, 2);
        System.out.println(buf[1] + "" + buf[2] + "," + n);
    }

}
