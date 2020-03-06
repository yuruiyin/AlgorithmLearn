package holiday_32;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class D {

    private static BufferedReader br;
    private static StringTokenizer tokenizer;

    static class Product {
        int count;
        int price;
        Product(int count, int price) {
            this.count = count;
            this.price = price;
        }
    }

    private static void solve() throws IOException {
        int n = nextInt();
        Product[] products = new Product[3];
        for (int i = 0; i < 3; i++) {
            int count = nextInt();
            int price = nextInt();
            products[i] = new Product(count, price);
        }

        int minCost = Integer.MAX_VALUE;
        for (int i = 0; i < 3; i++) {
            int count = products[i].count;
            int price = products[i].price;
            int cost = (n / count) * price;
            if (n % count != 0) {
                cost += price;
            }

            minCost = Math.min(minCost, cost);
        }

        System.out.println(minCost);
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
