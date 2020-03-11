package beginner.contest2020;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class D {

    private static BufferedReader br;
    private static StringTokenizer tokenizer;

    static class Store {
        int a;
        int b;
        Store(int a, int b) {
            this.a = a;
            this.b = b;
        }
    }

    private static void solve() throws IOException {
        int n = nextInt();
        int t = nextInt();
        List<Store> stores = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            stores.add(new Store(nextInt(), nextInt()));
        }

        long curT = 0;
        int ans = 0;
        while (ans < n && !stores.isEmpty()) {
            long minWaitTime = Long.MAX_VALUE;
            List<Store> nextStores = new ArrayList<>();
            Store minTimeStore = null;
            for (Store store : stores) {
                int a = store.a;
                int b = store.b;
                long waitTime = a * (curT + 1) + b;
                if (waitTime < minWaitTime) {
                    minWaitTime = waitTime;
                    minTimeStore = store;
                }

                if (curT + 1 + waitTime <= t) {
                    nextStores.add(store);
                }
            }

            curT = curT + 1 + minWaitTime;
            if (curT > t) {
                break;
            }

            if (minTimeStore != null) {
                nextStores.remove(minTimeStore);
            }

            ans++;
            stores = nextStores;
        }

        System.out.println(ans);
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
