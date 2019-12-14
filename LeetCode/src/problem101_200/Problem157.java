package problem101_200;

public class Problem157 {

    class Reader4 {
        int read4(char[] buf) {
            return 0;
        }
    }

    public class Solution extends Reader4 {

        private int count;

        /**
         * @param buf Destination buffer
         * @param n   Number of characters to read
         * @return    The number of actual characters read
         */
        public int read(char[] buf, int n) {
            char[] tmpBuf = new char[4];

            while (true) {
                int tmpCount = read4(tmpBuf);
                for (int j = 0; j < tmpCount; j++) {
                    buf[count++] = tmpBuf[j];
                    if (count >= n) {
                        return n;
                    }
                }

                if (tmpCount < 4) {
                    return count;
                }
            }
        }

    }

}
