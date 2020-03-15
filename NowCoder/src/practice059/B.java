package practice059;

import java.io.*;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class B {

    static class Task {

        class Node {
            long x;
            long y;
            long z;
            Node(long x, long y) {
                this.x = x;
                this.y = y;
            }
        }

        public void solve(int testNumber, InputReader in, PrintWriter out) {
            // 最小生成树
            int n = in.nextInt();
            Node[] nodes = new Node[n];
            for (int i = 0; i < n; i++) {
                nodes[i] = new Node(in.nextInt(), in.nextInt());
                long x = nodes[i].x;
                long y = nodes[i].y;
                long z = (x - y) * (x - y) * y;
                nodes[i].z = z;
            }

            Arrays.sort(nodes, new Comparator<Node>() {
                @Override
                public int compare(Node o1, Node o2) {
                    return Long.compare(o1.z, o2.z);
                }
            });

            long cost = 0;
            for (int i = 1; i < n; i++) {
                cost += nodes[i].z - nodes[i-1].z;
            }

            out.println(cost);

        }
    }

    public static void main(String[] args) {
        InputStream inputStream = System.in;
        OutputStream outputStream = System.out;
        InputReader in = new InputReader(inputStream);
        PrintWriter out = new PrintWriter(outputStream);
        Task task = new Task();
        task.solve(1, in, out);
        out.close();
    }

    static class InputReader {

        public BufferedReader reader;
        public StringTokenizer tokenizer;

        public InputReader(InputStream stream) {
            reader = new BufferedReader(new InputStreamReader(stream), 32768);
            tokenizer = null;
        }

        public String next() {
            while (tokenizer == null || !tokenizer.hasMoreTokens()) {
                try {
                    tokenizer = new StringTokenizer(reader.readLine());
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
            return tokenizer.nextToken();
        }

        public int nextInt() {
            return Integer.parseInt(next());
        }

        public long nextLong() {
            return Long.parseLong(next());
        }

        public double nextDouble() {
            return Double.parseDouble(next());
        }

    }

}
