package pre_contest03_2020;

import java.io.*;
import java.util.*;

public class P1007 {

    static class Task {

        private int x;
        private int y;
        private int z;

        private int getCount(int value1, int value2, int x, int y) {
            int count = 0;
            while (value1 > 0 && value2 > 0) {
                value1 -= y;
                value2 -= x;
                count++;
            }
            return count;
        }

        private boolean isOk(List<Data> list) {
            int count = 0;
            for (Data data : list) {
                if (data.volume <= 0) {
                    count++;
                }
            }

            return count < 2;
        }

        class Data {
            int power;
            int volume;
            Data(int power, int volume) {
                this.power = power;
                this.volume = volume;
            }
        }

        private int getAns() {
            // 三种选择

            List<Data> list = new ArrayList<>();
            list.add(new Data(x, 1000));
            list.add(new Data(y, 1000));
            list.add(new Data(z, 1000));

            list.sort(Comparator.comparingInt(o -> o.power));
            int ans1 = 0;

            // 分两种情况
            // 1. 先用最大攻击力的把1干死
            // 2. 先用最大攻击力的把2干死
            List<Data> list1 = new ArrayList<>();
            for (int i = 0; i < 3; i++) {
                Data data = list.get(i);
                list1.add(new Data(data.power, data.volume));
            }
            while (isOk(list)) {
                Data maxPowerData = list.get(2);
                if (maxPowerData.volume <= 0) {
                    ans1 += getCount(list.get(0).volume, list.get(1).volume, list.get(0).power, list.get(1).power);
                } else {
                    Data minPowerData = list.get(0);
                    if (minPowerData.volume <= 0) {
                        // 最小攻击力的已经阵亡了
                        ans1 += getCount(list.get(1).volume, list.get(2).volume, list.get(1).power, list.get(2).power);
                        break;
                    }

                    int count = minPowerData.volume / maxPowerData.power + (minPowerData.volume % maxPowerData.power == 0 ? 0 : 1);
                    minPowerData.volume = 0;
                    maxPowerData.volume -= count * minPowerData.power;
                    ans1 += count;
                }
            }

            int ans2 = 0;
            list = list1;
            while (isOk(list)) {
                Data maxPowerData = list.get(2);
                if (maxPowerData.volume <= 0) {
                    ans2 += getCount(list.get(0).volume, list.get(1).volume, list.get(0).power, list.get(1).power);
                } else {
                    Data midPowerData = list.get(1);
                    if (midPowerData.volume <= 0) {
                        // 中间攻击力的已经阵亡了
                        ans2 += getCount(list.get(0).volume, list.get(2).volume, list.get(0).power, list.get(2).power);
                        break;
                    }

                    int count = midPowerData.volume / maxPowerData.power + (midPowerData.volume % maxPowerData.power == 0 ? 0 : 1);
                    midPowerData.volume = 0;
                    maxPowerData.volume -= count * midPowerData.power;
                    ans2 += count;
                }
            }
            return Math.min(ans1, ans2);
        }

        public void solve(int testNumber, InputReader in, PrintWriter out) {
            int t = in.nextInt();
            while ((t--) > 0) {
                x = in.nextInt();
                y = in.nextInt();
                z = in.nextInt();

                out.println(getAns());
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
