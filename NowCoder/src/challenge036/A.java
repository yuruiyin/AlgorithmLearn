package challenge036;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class A {

    private static BufferedReader br;
    private static StringTokenizer tokenizer;

    static class Data {
        int a;
        int b;
        int c;
        Data(int a, int b, int c) {
            this.a = a;
            this.b = b;
            this.c = c;
        }
    }

    private static void solve() throws IOException {
        int n = nextInt();
        Data[] datas = new Data[n];
        for (int i = 0; i < n; i++) {
            int a = nextInt();
            int b = nextInt();
            int c = nextInt();
            datas[i] = new Data(Math.min(a, b), Math.max(a, b), c);
        }

        Map<Long, Integer> map = new HashMap<>();
        List<Integer>[] adj = new ArrayList[n+1];
        for (int i = 0; i < n; i++) {
            Data data = datas[i];
            int a = data.a;
            int b = data.b;
            int c = data.c;
            map.put(b * 100000L + a, c);
            map.put(a * 100000L + b, c);
            if (adj[a] == null) {
                adj[a] = new ArrayList<>();
            }
            adj[a].add(b);
            if (adj[b] == null) {
                adj[b] = new ArrayList<>();
            }
            adj[b].add(a);
        }

        int high = Integer.MAX_VALUE;  // 第一个点的最大值
        for (int i = 0; i < n; i++) {
            if (datas[i].a == 1) {
                high = Math.min(high, datas[i].c);
            }
        }
        high--;

        // 二分
        int low = 1;
        int[] ansArr = new int[n+100];
        while (low <= high) {
            int mid = (low + high) >>> 1;
            ansArr[0] = mid;
            int cur = 1;
            boolean needBigger = false;
            boolean isFound = false;
            boolean[] visited = new boolean[n+1];
            int level = 0;
            do {
                level++;
                visited[cur] = true;
                int next = -1;
                int next1 = adj[cur].get(0);
                int next2 = adj[cur].get(1);
                if (!visited[next1]) {
                    next = next1;
                } else if (!visited[next2]) {
                    next = next2;
                } else {
                    next = 1;
                }
                int c = map.get(cur * 100000L + next);
                if (ansArr[cur - 1] >= c) {
                    if ((level - 1) % 2 == 1) {
                        needBigger = true;
                    } else {
                        needBigger = false;
                    }
                    break;
                }

                if (next == 1) {
                    if (ansArr[cur - 1] + mid == c) {
                        isFound = true;
                    } else if (ansArr[cur - 1] + mid < c) {
                        if ((level - 1) % 2 == 1) {
                            needBigger = false;
                        } else {
                            needBigger = true;
                        }
                    } else {
                        if ((level - 1) % 2 == 1) {
                            needBigger = true;
                        } else {
                            needBigger = false;
                        }
                    }
                }

                ansArr[next - 1] = c - ansArr[cur - 1];
                cur = next;
            } while (cur != 1);

            if (isFound) {
                break;
            }

            if (needBigger) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        for (int i = 0; i < n; i++) {
            System.out.println(ansArr[i]);
        }
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
