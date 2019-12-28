import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class P5582 {

    private static BufferedReader br;
    private static StringTokenizer tokenizer;

    private static void runCase() throws IOException {
        int n = nextInt();
        int k = nextInt();
        int[] arr = new int[k];
        boolean[] disallowArr = new boolean[n+1];
        for (int i = 0; i < k; i++) {
            arr[i] = nextInt();
            disallowArr[arr[i]] = true;
        }

        if (k == n) {
            System.out.println(-1);
            return;
        }

        List<Integer> list = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            if (!disallowArr[i]) {
                list.add(i);
            }
        }

        for (Integer num : list) {
            if (num == 1) {
                System.out.println(n);
                return;
            }

            if (n % num == 0) {
                continue;
            }

            //如果是奇数， 2 到 n-1 都可以
            if (n % 2 == 1) {
                System.out.println(n);
                return;
            }

            if (num % 2 == 1) {
                System.out.println(n);
            }
        }

        System.out.println(-1);
    }
    
    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        int t = nextInt();
        while ((t--) > 0) {
            runCase();
        }
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
