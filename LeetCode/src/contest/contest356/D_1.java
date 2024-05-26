package contest.contest356;

public class D_1 {

    private static final int MOD = (int) (1e9 + 7);

    private static final Integer[][] memo = new Integer[10][101];
    private Integer[][][] memo1;

    private int dfs(int pre, int leftCount) {
        if (leftCount == 0) {
            return 1;
        }

        if (memo[pre][leftCount] != null) {
            return memo[pre][leftCount];
        }

        int l = pre - 1;
        int r = pre + 1;
        long res = 0;
        if (l >= 0) {
            res += dfs(l, leftCount - 1);
        }

        if (r <= 9) {
            res += dfs(r, leftCount - 1);
        }

        return memo[pre][leftCount] = (int) (res % MOD);
    }

    private int dfs1(int isPreEqual, int pre, int leftCount, int[] arr) {
        if (leftCount == 0) {
            return 1;
        }

        if (memo1[isPreEqual][pre][leftCount] != null) {
            return memo1[isPreEqual][pre][leftCount];
        }

        int l = pre - 1;
        int r = pre + 1;
        long res = 0;
        int idx = arr.length - leftCount;
        if (l >= 0) {
            if (isPreEqual == 1) {
                if (l == arr[idx]) {
                    res += dfs1(1, l, leftCount - 1, arr);
                } else if (l < arr[idx]) {
                    res += dfs1(0, l, leftCount - 1, arr);
                }
            } else {
                res += dfs1(0, l, leftCount - 1, arr);
            }
        }

        if (r <= 9) {
            if (isPreEqual == 1) {
                if (r == arr[idx]) {
                    res += dfs1(1, r, leftCount - 1, arr);
                } else if (r < arr[idx]) {
                    res += dfs1(0, r, leftCount - 1, arr);
                }
            } else {
                res += dfs1(0, r, leftCount - 1, arr);
            }
        }

        return memo1[isPreEqual][pre][leftCount] = (int) (res % MOD);
    }

    private long getAns(int[] arr) {
        int len = arr.length;
        long res = 0;
        for (int i = 1; i < len; i++) {
            for (int first = 1; first <= 9; first++) {
                res += dfs(first, i - 1);
            }
        }

        memo1 = new Integer[2][10][101];
        for (int first = 1; first <= arr[0]; first++) {
            int isPreEqual = first == arr[0] ? 1 : 0;
            res += dfs1(isPreEqual, first, len - 1, arr);
        }
        return res;
    }

    private int[] convert(String str) {
        char[] arr = str.toCharArray();
        int[] ansArr = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            ansArr[i] = arr[i] - '0';
        }
        return ansArr;
    }

    public int countSteppingNumbers(String low, String high) {
        int[] lowArr = convert(low);
        int[] highArr = convert(high);
        long highRes = getAns(highArr);
        if (lowArr.length == 1 && lowArr[0] == '1') {
            return (int) (highRes % MOD);
        }

        long lowRes = getAns(lowArr);
        int flag = 1;
        for (int i = 0; i < lowArr.length - 1; i++) {
            if (Math.abs(lowArr[i] - lowArr[i + 1]) != 1) {
                flag = 0;
                break;
            }
        }

        return (int) ((highRes + MOD - lowRes + flag) % MOD);
    }

    public static void main(String[] args) {
        System.out.println(new D_1().countSteppingNumbers("90", "101"));
        System.out.println(new D_1().countSteppingNumbers("2", "40"));
        System.out.println(new D_1().countSteppingNumbers("106", "121"));
    }

}
