package holiday_33;

import java.io.*;
import java.util.StringTokenizer;

public class E {
    
    public static void main(String[] args) {
        InputStream inputStream = System.in;
        OutputStream outputStream = System.out;
        InputReader in = new InputReader(inputStream);
        PrintWriter out = new PrintWriter(outputStream);
        Task task = new Task();
        task.solve(1, in, out);
        out.close();
    }

    static class Task {

        class Person {
            int dir;
            String name;
            Person(int dir, String name) {
                this.dir = dir;
                this.name = name;
            }
        }

        public void solve(int testNumber, InputReader in, PrintWriter out) {
            // 朝内的 左数，倒着来
            int n = in.nextInt();
            int m = in.nextInt();
            Person[] persons = new Person[n];
            for (int i = 0; i < n; i++) {
                persons[i] = new Person(in.nextInt(), in.next());
            }

            int cur = 0;
            for (int i = 0; i < m; i++) {
                int dir = in.nextInt();
                int count = in.nextInt();
                if (persons[cur].dir == 0) {
                    if (dir == 0) {
                        // 左数
                        cur = (cur + n - count) % n;
                    } else {
                        cur = (cur + count) % n;
                    }
                } else {
                    if (dir == 0) {
                        // 左数
                        cur = (cur + count) % n;
                    } else {
                        cur = (cur + n - count) % n;
                    }
                }
            }

            out.println(persons[cur].name);
        }
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
