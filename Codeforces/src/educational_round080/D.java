package educational_round080;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.LineNumberReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class D {

    private static BufferedReader br;
    private static StringTokenizer tokenizer;

    static class Data {
        int max;
        int[] nums;
        int index;
        Data(int[] nums, int max, int index) {
            this.nums = nums;
            this.max = max;
            this.index = index;
        }
    }

    private static void solve() throws IOException {
        int n = nextInt();
        int m = nextInt();
        int[][] arr = new int[n][m];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                arr[i][j] = nextInt();
            }
        }

        int[] maxArr = new int[n];
        for (int i = 0; i < n; i++) {
            int max = 0;
            for (int j = 0; j < m; j++) {
                max = Math.max(max, arr[i][j]);
            }
            maxArr[i] = max;
        }

        Data[] datas = new Data[n];
        for (int i = 0; i < n; i++) {
            datas[i] = new Data(arr[i], maxArr[i], i + 1);
        }

        Arrays.sort(datas, new Comparator<Data>() {
            @Override
            public int compare(Data o1, Data o2) {
                return o2.max - o1.max;
            }
        });

        int maxMin = 0;
        int ansI = -1;
        int ansJ = -1;

        for (int i = 0; i < n; i++) {
            Data data1 = datas[i];
            if (data1.max < maxMin) {
                break;
            }
            for (int j = i; j < n; j++) {
                Data data2 = datas[j];
                if (data2.max < maxMin) {
                    break;
                }
                int[] tmpMaxArr = new int[m];
                int min = Integer.MAX_VALUE;
                for (int k = 0; k < m; k++) {
                    tmpMaxArr[k] = Math.max(data1.nums[k], data2.nums[k]);
                    min = Math.min(min, tmpMaxArr[k]);
                }

                if (min > maxMin) {
                    maxMin = min;
                    ansI = data1.index;
                    ansJ = data2.index;
                }
            }
        }
        
        System.out.println(ansI + " " + ansJ);

    }




    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        solve();
    }

    public static String next() throws IOException {
        while (tokenizer == null || !tokenizer.hasMoreTokens()) {
            String line = br.readLine();
            if (line == null)
                throw new IOException();
            tokenizer = new StringTokenizer(line);
        }
        return tokenizer.nextToken();
    }

    public static int nextInt() throws IOException {
        return Integer.parseInt(next());
    }

    public static long nextLong() throws IOException {
        return Long.parseLong(next());
    }

    public static double nextDouble() throws IOException {
        return Double.parseDouble(next());
    }

}
