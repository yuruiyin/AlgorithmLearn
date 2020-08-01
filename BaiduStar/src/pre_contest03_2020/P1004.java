package pre_contest03_2020;

import java.io.*;
import java.util.*;

public class P1004 {

    static class Task {

        public void solve(int testNumber, InputReader in, PrintWriter out) {
            int t = in.nextInt();
            while ((t--) > 0) {
                int n = in.nextInt();
                LinkedList<Integer>[] listArr = new LinkedList[2];
                listArr[0] = new LinkedList<>();
                listArr[1] = new LinkedList<>();
                for (int i = 0; i < n; i++) {
                    int x = in.nextInt();
                    int y = in.nextInt();
                    listArr[x - 1].add(y);
                }

                // 0是右车道
                Collections.sort(listArr[0]);
                Collections.sort(listArr[1]);

                // 左车道的车一定不能去占用右车道的车
                int time;
                int offset = 0;
                for (time = 1; !listArr[0].isEmpty() && !listArr[1].isEmpty() ;time++) {
                    int minRight = listArr[0].getFirst();
                    int minLeft = listArr[1].getFirst();

                    if (minRight - (time - 1) == 0) {
                        listArr[0].poll();
                    }

                    if (minLeft - (time - 1) > 0) {
                        continue;
                    }

                    List<Integer> leftList = new ArrayList<>();
                    while (!listArr[1].isEmpty()) {
                        if (listArr[1].getFirst() - (time - 1) > 0) {
                            break;
                        }

                        leftList.add(listArr[1].poll());
                    }

                    int size = leftList.size();
                    if (leftList.get(size - 1) - (time - 1) == 0) {
                        // 左车道车到达转弯处
                        if (minRight - (time - 1) == 0) {
                            // 右车道车也到达转弯处
                            if (listArr[0].isEmpty()) {
                                listArr[0].add(time);
                            } else {
                                int nextRight = listArr[0].getFirst();
                                if (nextRight - minRight > 1) {
                                    listArr[0].offerFirst(time);
                                } else {
                                    // 不能给左车道走
                                    listArr[1].addFirst(leftList.get(size - 1));
                                }
                            }
                        } else {
                            // 右车道车还没到达转弯处
                            if (minRight - (time - 1) > 1) {
                                listArr[0].offerFirst(time);
                            } else {
                                // 不能给左车道走
                                listArr[1].addFirst(leftList.get(size - 1));
                            }
                        }
                    } else if (leftList.get(size - 1) - (time - 1) == -1) {
                        if (minRight - (time - 1) == 0 && listArr[0].isEmpty() && listArr[1].isEmpty()) {
                            offset++;
                        } else {

                        }
                    }

                }

                time--;
                int ans = time + offset;

                if (!listArr[0].isEmpty()) {
                    ans += listArr[0].getLast() - time + 1;
                }

                if (!listArr[1].isEmpty()) {
                    ans += listArr[1].getLast() - time + 2;
                }

                out.println(ans);

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
