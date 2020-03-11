package problem001_100;

import java.io.*;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.StringTokenizer;

public class P093_1 {

    static class Task {

        private List<List<Integer>> ansList;
        private int n;
        private int m;

        private void notRec() {
            int max = (1 << n);
            for (int i = 0; i < max; i++) {
                if (Integer.bitCount(i) == m) {
                    int cur = i;
                    List<Integer> list = new ArrayList<>();
                    for (int j = 0; j < 32 && cur > 0; j++, cur >>>= 1) {
                        if ((cur & 1) == 1) {
                            list.add(j + 1);
                        }
                    }
                    ansList.add(list);
                }
            }
        }

        public void solve(int testNumber, InputReader in, PrintWriter out) {
            n = in.nextInt();
            m = in.nextInt();
            ansList = new ArrayList<>();
            notRec();

            ansList.sort(new Comparator<List<Integer>>() {
                @Override
                public int compare(List<Integer> o1, List<Integer> o2) {
                    for (int i = 0; i < o1.size(); i++) {
                        if (o1.get(i).equals(o2.get(i))) {
                            continue;
                        }

                        return o1.get(i).compareTo(o2.get(i));
                    }

                    return 0;
                }
            });

            for (List<Integer> list : ansList) {
                for (Integer num : list) {
                    out.print(num + " ");
                }
                out.println();
            }
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
