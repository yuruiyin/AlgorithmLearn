package lcp;

import java.util.*;

public class Problem05_1 {

    List<List<Integer>> graph = new ArrayList<>();
    int[] start;
    int[] end;
    int time;
    int mod = 1000000007;

    public int[] bonus(int n, int[][] leadership, int[][] operations) {
        for (int i = 0; i <= n; i++) graph.add(new ArrayList<>());
        start = new int[n+1];
        end = new int[n+1];
        for (int i = 0; i < leadership.length; i++) {
            int u = leadership[i][0];
            int v = leadership[i][1];
            graph.get(u).add(v);
        }
        time = 0;
        dfs(1);
        ST st = new ST(n);
        st.init(1, 1, n);

        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < operations.length; i++) {
            if (operations[i][0] == 1) {
                int u = operations[i][1];
                int val = operations[i][2];
                st.add(start[u], start[u], val, 1, 1, n);
            } else if (operations[i][0] == 2) {
                int u = operations[i][1];
                int val = operations[i][2];
                st.add(start[u], end[u], val, 1, 1, n);
            } else {
                int u = operations[i][1];
                res.add((int) (st.get(start[u], end[u], 1, 1, n) % mod));
            }
        }
        int[] ans = new int[res.size()];
        for (int i = 0; i < res.size(); i++) ans[i] = res.get(i);
        return ans;
    }

    void dfs(int u) {
        time++;
        start[u] = time;
        for (int v: graph.get(u)) {
            dfs(v);
        }
        end[u] = time;
    }

    class ST {
        long[] v;
        long[] sum;
        int[] sz;
        ST(int n) {
            v = new long[n * 4];
            sum = new long[n * 4];
            sz = new int[n * 4];
        }

        void init(int x, int nl, int nr) {
            if (nl == nr) {
                sz[x] = 1;
                return;
            }
            int mid = (nl + nr) / 2;
            init(x*2, nl, mid);
            init(x*2+1, mid+1, nr);
            sz[x] = sz[x*2] + sz[x*2+1];
        }

        void push(int x) {
            if (v[x] > 0) {
                v[x*2] += v[x];
                v[x*2+1] += v[x];
                v[x] = 0;
            }
        }

        void update(int x) {
            sum[x] = sum[x*2] + v[x*2] * sz[x*2] +
                    sum[x*2+1] + v[x*2+1] * sz[x*2+1];
        }

        void add(int l, int r, int val, int x, int nl, int nr) {
            if (l > r) return;
            if (l == nl && r == nr) {
                v[x] += val;
                return;
            }
            int mid = (nl + nr) / 2;
            push(x);
            add(l, Math.min(r, mid), val, x*2, nl, mid);
            add(Math.max(mid+1, l), r, val, x*2+1, mid+1, nr);
            update(x);
        }

        long get(int l, int r, int x, int nl, int nr) {
            if (l > r) return 0;
            if (l == nl && r == nr) {
                return sum[x] + sz[x] * v[x];
            }
            push(x);
            int mid = (nl + nr) / 2;
            long res = 0;
            res += get(l, Math.min(r, mid), x*2, nl, mid);
            res += get(Math.max(mid+1, l), r, x*2+1, mid+1, nr);
            update(x);
            return res;
        }
    }
}
