package contest.contest135;

public class Problem1039 {

    private static final int N = 50;

    private int[] memo;

    private int dfs(int[] a, int left, int right) {
        if (left + 1 == right) {
            return 0;
        }

        int key = left * N + right;

        if (memo[key] != 0) {
            return memo[key];
        }

        int ans = Integer.MAX_VALUE;
        for (int i = left + 1; i < right; i++) {
            ans = Math.min(ans, dfs(a, left, i) + dfs(a, i, right) + a[left] * a[i] * a[right]);
        }

        memo[key] = ans;
        return ans;
    }

    public int minScoreTriangulation(int[] a) {
        int n = a.length;

        if (n == 3) {
            return a[0] * a[1] * a[2];
        }

        memo = new int[N * N];
        return dfs(a, 0, n - 1);
    }

    public static void main(String[] args) {
        System.out.println(new Problem1039().minScoreTriangulation(new int[]{1,2,3}));
        System.out.println(new Problem1039().minScoreTriangulation(new int[]{3,7,4,5}));
        System.out.println(new Problem1039().minScoreTriangulation(new int[]{1,3,1,4,1,5}));

        System.out.println(new Problem1039().minScoreTriangulation(new int[]{4,3,4,3,5}));

        System.out.println(new Problem1039().minScoreTriangulation(new int[]{2,2,2,2,1,2,2,2,2,1}));


    }

}
