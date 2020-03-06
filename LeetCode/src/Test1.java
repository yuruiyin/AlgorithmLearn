public class Test1 {

    private static final int MAX = 100000;
    private static Integer[] memo;

    private static boolean isPowerOf2(int n) {
        return (n & (n - 1)) == 0;
    }

    private static int dp(int cur) {
        if (cur == 1) {
            return 0;
        }

        if (memo[cur] != null) {
            return memo[cur];
        }

        int divide3Count = 0;
        while (cur % 3 == 0) {
            divide3Count++;
            cur /= 3;
        }

        int divide2Count = 0;
        while (cur % 2 == 0) {
            divide2Count++;
            cur >>= 1;
        }

        if (cur == 1) {
            return divide2Count + divide3Count;
        }

        return 1 + divide2Count + divide3Count + dp(cur - 1);
//        memo[cur] = res + 1;
//        return memo[cur];
    }

    private static int dfs(int cur) {
        if (cur == 1) {
            return 0;
        }

        if (memo[cur] != null) {
            return memo[cur];
        }

        int a = Integer.MAX_VALUE;
        int b = Integer.MAX_VALUE;
        if (cur % 3 == 0) {
            a = dfs(cur / 3);
        }

        if (cur % 2 == 0) {
            b = dfs(cur / 2);
        }

        int c = dfs(cur - 1);
        memo[cur] = Math.min(Math.min(a, b), c)+ 1;
        return memo[cur];
    }

    private static int getAns(int n) {
        int ansMin = Integer.MAX_VALUE;
        for (int i = 0; ; i++) {
            int pow2 = (int) Math.pow(2, i);
            if (pow2 > n) {
                break;
            }

            int value = 0;
            int j;
            for (j = 0; ;j++) {
                int pow3 = (int) Math.pow(3, j);
                if (pow2 * pow3 > n) {
                    break;
                }

                value = pow2 * pow3;
            }

            int diff = n - value;
            int count = i + j - 1 + diff;
            ansMin = Math.min(ansMin, count);
        }

        return ansMin;
    }
    
    public static void main(String[] args) {
//        memo = new Integer[MAX + 1];
//        System.out.println(dp(MAX));
        memo = new Integer[MAX + 1];
        System.out.println(dfs(MAX));

        System.out.println(getAns(MAX));

    }
    
}
