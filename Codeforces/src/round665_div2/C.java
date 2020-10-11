package round665_div2;

import java.io.*;
import java.util.*;

public class C {

    static class Task {

        class Data {
            int value;
            int index;
            Data(int value, int index) {
                this.value = value;
                this.index = index;
            }
        }

        public void solve(int testNumber, InputReader in, PrintWriter out) {
            int t = in.nextInt();
            while ((t--) > 0) {
                int n = in.nextInt();
                int[] arr = new int[n];
                int min = Integer.MAX_VALUE;
                for (int i = 0; i < n; i++) {
                    arr[i] = in.nextInt();
                    min = Math.min(min, arr[i]);
                }

                List<Data> notDivIndexList = new ArrayList<>();
                List<Data> divIndexList = new ArrayList<>();

                for (int i = 0; i < n; i++) {
                    if (arr[i] % min == 0) {
                        divIndexList.add(new Data(arr[i], i));
                    } else {
                        notDivIndexList.add(new Data(arr[i], i));
                    }
                }

                if (notDivIndexList.size() == 0) {
                    out.println("YES");
                    continue;
                }

                boolean isOk = true;
                for (int i = 1; i < notDivIndexList.size(); i++) {
                    Data curData = notDivIndexList.get(i);
                    if (curData.value < notDivIndexList.get(i - 1).value) {
                        isOk = false;
                        break;
                    }
                }

                if (!isOk) {
                    out.println("NO");
                    continue;
                }

                // 对divIndexList进行排序
                List<Integer> indexList = new ArrayList<>();
                for (Data data : divIndexList) {
                    indexList.add(data.index);
                }

                divIndexList.sort(Comparator.comparingInt(o -> o.value));

                for (int i = 0; i < divIndexList.size(); i++) {
                    divIndexList.get(i).index = indexList.get(i);
                }

                int notDivIndex = 0;
                int divIndex = 0;

                int preValue = -1;

                for (int i = 0; i < n; i++) {
                    Data notDivData = notDivIndexList.get(notDivIndex);
                    Data divData = divIndexList.get(divIndex);
                    if (notDivData.index == i) {
                        if (preValue == -1) {
                            preValue = notDivData.value;
                        } else {
                            if (notDivData.value < preValue) {
                                isOk = false;
                                break;
                            }

                            preValue = notDivData.value;
                        }

                        notDivIndex++;
                    } else {
                        if (preValue == -1) {
                            preValue = divData.value;
                        } else {
                            if (divData.value < preValue) {
                                isOk = false;
                                break;
                            }

                            preValue = divData.value;
                        }

                        divIndex++;
                    }

                    if (divIndex == divIndexList.size() || notDivIndex == notDivIndexList.size()) {
                        break;
                    }
                }

                if (divIndex != divIndexList.size()) {
                    if (divIndexList.get(divIndex).value < preValue) {
                        isOk = false;
                    }
                }

                if (notDivIndex != notDivIndexList.size()) {
                    if (notDivIndexList.get(notDivIndex).value < preValue) {
                        isOk = false;
                    }
                }

                out.println(isOk ? "YES" : "NO");

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
