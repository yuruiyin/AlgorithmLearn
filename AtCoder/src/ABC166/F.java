package ABC166;

import java.io.*;
import java.util.*;

public class F {

    static class Task {

        private int getTheThirdIdx(int idx1, int idx2) {
            if (idx1 == 0 && idx2 == 1) {
                return 2;
            } else if (idx1 == 0 && idx2 == 2) {
                return 1;
            }
            return 0;
        }

        public void solve(int testNumber, InputReader in, PrintWriter out) {
            int n = in.nextInt();
            int[] charArr = new int[3];
            for (int i = 0; i < 3; i++) {
                charArr[i] = in.nextInt();
            }

            // 大的减1，小的加1
            String[] arr = new String[n];
            for (int i = 0; i < n; i++) {
                String event = in.next();
                arr[i] = event;
            }

            List<Character> addOneList = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                String event = arr[i];
                int idx1 = event.charAt(0) - 'A';
                int idx2 = event.charAt(1) - 'A';
                if (charArr[idx1] == 0 && charArr[idx2] == 0) {
                    out.println("No");
                    return;
                }

                if (i == n - 1) {
                    if (charArr[idx1] <= charArr[idx2]) {
                        addOneList.add((char) ('A' + idx1));
                        charArr[idx1]++;
                        charArr[idx2]--;
                    } else {
                        addOneList.add((char) ('A' + idx2));
                        charArr[idx2]++;
                        charArr[idx1]--;
                    }
                    break;
                }

                if (charArr[idx1] == 0) {
                    addOneList.add((char) ('A' + idx1));
                    charArr[idx1]++;
                    charArr[idx2]--;
                } else if (charArr[idx2] == 0) {
                    addOneList.add((char) ('A' + idx2));
                    charArr[idx2]++;
                    charArr[idx1]--;
                } else if (charArr[idx1] < charArr[idx2]) {
                    addOneList.add((char) ('A' + idx1));
                    charArr[idx1]++;
                    charArr[idx2]--;
                } else if (charArr[idx1] > charArr[idx2]) {
                    addOneList.add((char) ('A' + idx2));
                    charArr[idx2]++;
                    charArr[idx1]--;
                } else {
                    int idx3 = getTheThirdIdx(idx1, idx2);
                    if (charArr[idx1] > 1 || charArr[idx3] != 0) {
                        addOneList.add((char) ('A' + idx1));
                        charArr[idx1]++;
                        charArr[idx2]--;
                        continue;
                    }

                    // 当前两个数为1，而且第三个数是0

                    String nextEvent = arr[i + 1];
                    int nextIdx1 = nextEvent.charAt(0) - 'A';
                    int nextIdx2 = nextEvent.charAt(1) - 'A';
                    if (nextIdx1 == idx3) {
                        if (idx1 == nextIdx2) {
                            addOneList.add((char) ('A' + idx1));
                            charArr[idx1]++;
                            charArr[idx2]--;
                        } else if (idx2 == nextIdx2) {
                            addOneList.add((char) ('A' + idx2));
                            charArr[idx2]++;
                            charArr[idx1]--;
                        }
                    } else if (nextIdx2 == idx3) {
                        if (idx1 == nextIdx1) {
                            addOneList.add((char) ('A' + idx1));
                            charArr[idx1]++;
                            charArr[idx2]--;
                        } else if (idx2 == nextIdx1) {
                            addOneList.add((char) ('A' + idx2));
                            charArr[idx2]++;
                            charArr[idx1]--;
                        }
                    } else {
                        addOneList.add((char) ('A' + idx1));
                        charArr[idx1]++;
                        charArr[idx2]--;
                    }
                }
            }

            out.println("Yes");
            for (Character cur : addOneList) {
                out.println(cur);
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
