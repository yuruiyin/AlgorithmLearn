package dianfeng_contest.S108;

/**
 * A
 *
 * @author: yry
 * @date: 2020/8/1
 */
public class C {

    private int[] dp;

    private int getCount(int div, int target) {
        int count = target / div;
        target %= div;
        count += dp[target];
        return count;
    }

    /**
     * 把所有询问的答案按询问顺序放入vector里
     * @param arr int整型一维数组 要查询坐标的数组
     * @return int整型一维数组
     */
    public int[] MinimumTimes (int[] arr) {
        // write code here
        // 0,3,7,11
        dp = new int[11];
        dp[0] = 0;
        dp[1] = 3;
        dp[2] = 4;
        dp[3] = 1;
        dp[4] = 2;
        dp[5] = 3;
        dp[6] = 2;
        dp[7] = 1;
        dp[8] = 2;
        dp[9] = 3;
        dp[10] = 2;

        int len = arr.length;
        int[] ansArr = new int[len];
        for (int i = 0; i < len; i++) {
            int target = arr[i];
            int count11 = getCount(11, target);
            int count7 = getCount(7, target);
            int count3 = getCount(3, target);
            ansArr[i] = Math.min(Math.min(count7, count11), count3);
        }

        return ansArr;
    }

    public static void main(String[] args) {
        int[] arr = new int[100];
        for (int i = 23; i < 100; i++) {
            arr[i] = i + 1;
        }
        int[] ansArr = new C().MinimumTimes(arr);
        for (int num : ansArr) {
            System.out.print(num + " ");
        }
    }
}
