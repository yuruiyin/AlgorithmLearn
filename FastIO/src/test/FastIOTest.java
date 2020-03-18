package test;

import utils.InputReader;

import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * ScannerTest
 *
 * @author: yry
 * @date: 2020/3/17
 */
public class FastIOTest {

    static class Reader
    {
        final private int BUFFER_SIZE = 1 << 16;
        private DataInputStream din;
        private byte[] buffer;
        private int bufferPointer, bytesRead;

        public Reader()
        {
            din = new DataInputStream(System.in);
            buffer = new byte[BUFFER_SIZE];
            bufferPointer = bytesRead = 0;
        }

        public Reader(String file_name) throws IOException
        {
            din = new DataInputStream(new FileInputStream(file_name));
            buffer = new byte[BUFFER_SIZE];
            bufferPointer = bytesRead = 0;
        }

        public String readLine() throws IOException
        {
            byte[] buf = new byte[64]; // line length
            int cnt = 0, c;
            while ((c = read()) != -1)
            {
                if (c == '\n')
                    break;
                buf[cnt++] = (byte) c;
            }
            return new String(buf, 0, cnt);
        }

        public int nextInt() throws IOException
        {
            int ret = 0;
            byte c = read();
            while (c <= ' ')
                c = read();
            boolean neg = (c == '-');
            if (neg)
                c = read();
            do
            {
                ret = ret * 10 + c - '0';
            }  while ((c = read()) >= '0' && c <= '9');

            if (neg)
                return -ret;
            return ret;
        }

        public long nextLong() throws IOException
        {
            long ret = 0;
            byte c = read();
            while (c <= ' ')
                c = read();
            boolean neg = (c == '-');
            if (neg)
                c = read();
            do {
                ret = ret * 10 + c - '0';
            }
            while ((c = read()) >= '0' && c <= '9');
            if (neg)
                return -ret;
            return ret;
        }

        public double nextDouble() throws IOException
        {
            double ret = 0, div = 1;
            byte c = read();
            while (c <= ' ')
                c = read();
            boolean neg = (c == '-');
            if (neg)
                c = read();

            do {
                ret = ret * 10 + c - '0';
            }
            while ((c = read()) >= '0' && c <= '9');

            if (c == '.')
            {
                while ((c = read()) >= '0' && c <= '9')
                {
                    ret += (c - '0') / (div *= 10);
                }
            }

            if (neg)
                return -ret;
            return ret;
        }

        private void fillBuffer() throws IOException
        {
            bytesRead = din.read(buffer, bufferPointer = 0, BUFFER_SIZE);
            if (bytesRead == -1)
                buffer[0] = -1;
        }

        private byte read() throws IOException
        {
            if (bufferPointer == bytesRead)
                fillBuffer();
            return buffer[bufferPointer++];
        }

        public void close() throws IOException
        {
            if (din == null)
                return;
            din.close();
        }
    }

    static class TaskReader {
        public void solve(Reader s) {
            try {
                long start = System.currentTimeMillis();
                int n = s.nextInt();
                int k = s.nextInt();
                int count=0;
                while (n-- > 0)
                {
                    int x = s.nextInt();
                    if (x%k == 0)
                        count++;
                }
                System.out.println(count);
                long end = System.currentTimeMillis();
                System.out.println("耗时： " + (end - start) + "ms");
            } catch (Exception e) {

            }
        }
    }

    static class Task {
        public void solve(int testNumber, InputReader in, PrintWriter out) {
            long start = System.currentTimeMillis();
            int n = in.nextInt();
            int k = in.nextInt();
            int count = 0;
            while (n-- > 0) {
                int x = in.nextInt();
                if (x % k == 0)
                    count++;
            }
            out.println(count);
            long end = System.currentTimeMillis();
            System.out.println("耗时： " + (end - start) + "ms");
        }
    }

    public static void main(String[] args) {

        // 以下耗时：2658ms
//        long start = System.currentTimeMillis();
//        Scanner s = new Scanner(System.in);
//        int n = s.nextInt();
//        int k = s.nextInt();
//        int count = 0;
//        while (n-- > 0)
//        {
//            int x = s.nextInt();
//            if (x%k == 0)
//                count++;
//        }
//        System.out.println(count);
//        long end = System.currentTimeMillis();
//        System.out.println("耗时： " + (end - start) + "ms");


        // 以下耗时：1s左右
//        InputStream inputStream = System.in;
//        OutputStream outputStream = System.out;
//        InputReader in = new InputReader(inputStream);
//        PrintWriter out = new PrintWriter(outputStream);
//        Task task = new Task();
//        task.solve(1, in, out);
//        out.close();


        Reader reader = new Reader();
        TaskReader taskReader = new TaskReader();
        taskReader.solve(reader);

    }

}

//        7 3
//        1
//        51
//        966369
//        7
//        9
//        999996
//        11
