package problem501_600;

public class Problem526 {

    private int n;

    private int backTrack(int from, boolean[] visited) {
        if (from == n + 1) {
            return 1;
        }

        int ans = 0;
        for (int i = 1; i <= n; i++) {
            if (visited[i]) {
                continue;
            }

            if (from % i != 0 && i % from != 0) {
                continue;
            }

            visited[i] = true;
            ans += backTrack(from + 1, visited);
            visited[i] = false;
        }

        return ans;
    }

    public int countArrangement(int n) {
        this.n = n;
        return backTrack(1, new boolean[n+1]);
    }

}
