package round662_div2;

import java.io.*;
import java.util.*;

public class B {

    static class Task {

        private final int MAX = 100005;

        public void solve(int testNumber, InputReader in, PrintWriter out) {
            int n = in.nextInt();
            int[] arr = new int[n];
            int[] countArr = new int[MAX];
            TreeSet<Integer> more4Set = new TreeSet<>();
            TreeSet<Integer> more2Set = new TreeSet<>();
            for (int i = 0; i < n; i++) {
                arr[i] = in.nextInt();
                countArr[arr[i]]++;
                if (countArr[arr[i]] >= 4) {
                    more4Set.add(arr[i]);
                }

                if (countArr[arr[i]] >= 2) {
                    more2Set.add(arr[i]);
                }
            }

            int q = in.nextInt();
            int count = n;
            while ((q--) > 0) {
                char symbol = in.next().charAt(0);
                int x = Integer.parseInt(in.next());

                if (symbol == '+') {
                    countArr[x]++;
                    if (countArr[x] >= 4) {
                        more4Set.add(x);
                    }
                    if (countArr[x] >= 2) {
                        more2Set.add(x);
                    }
                    count++;
                } else {
                    countArr[x]--;
                    if (countArr[x] < 4) {
                        more4Set.remove(x);
                    }
                    if (countArr[x] < 2) {
                        more2Set.remove(x);
                    }
                    count--;
                }

                if (more4Set.isEmpty() || count < 8) {
                    out.println("NO");
                } else {
                    int size4 = more4Set.size();
                    if (size4 == 1) {
                        int num = more4Set.first();
                        if (countArr[num] >= 8) {
                            out.println("YES");
                        } else if (countArr[num] >= 6) {
                            int size2 = more2Set.size();
                            if (size2 > 1) {
                                out.println("YES");
                            } else {
                                out.println("NO");
                            }
                        } else {
                            int size2 = more2Set.size();
                            if (size2 > 2) {
                                out.println("YES");
                            } else {
                                out.println("NO");
                            }
                        }
                    } else {
                        out.println("YES");
                    }
                }
            }
        }
    }

    private static void sort(double[] arr) {
        Double[] objArr = Arrays.stream(arr).boxed().toArray(Double[]::new);
        Arrays.sort(objArr);
        for (int i = 0; i < arr.length; i++) {
            arr[i] = objArr[i];
        }
    }

    private static void sort(int[] arr) {
        Integer[] objArr = Arrays.stream(arr).boxed().toArray(Integer[]::new);
        Arrays.sort(objArr);
        for (int i = 0; i < arr.length; i++) {
            arr[i] = objArr[i];
        }
    }

    private static void sort(long[] arr) {
        Long[] objArr = Arrays.stream(arr).boxed().toArray(Long[]::new);
        Arrays.sort(objArr);
        for (int i = 0; i < arr.length; i++) {
            arr[i] = objArr[i];
        }
    }

    private static void solve() {
        InputStream inputStream = System.in;
        OutputStream outputStream = System.out;
        InputReader in = new InputReader(inputStream);
        PrintWriter out = new PrintWriter(outputStream);
        Task task = new Task();
        task.solve(1, in, out);
        out.close();
    }

    public static void main(String[] args) {
        new Thread(null, () -> solve(), "1", 1 << 26).start();
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
