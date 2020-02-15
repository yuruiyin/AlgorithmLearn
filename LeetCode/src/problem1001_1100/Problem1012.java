package problem1001_1100;

public class Problem1012 {

//    private static List<Integer> ansList = new ArrayList<>();
    private static int[] ansArr = new int[10000000]; // 用数组比用list更快
    private static int index = 0;

    static {
        for (int bit = 1; bit <= 9; bit++) {
            permutation(0, bit, new boolean[10], 0, ansArr);
        }
    }

    private static void permutation(int from, int bitCount, boolean[] visited, int num, int[] ansArr) {
        if (from == bitCount) {
            ansArr[index++] = num;
            return;
        }

        int start = 0;
        if (from == 0) {
            start = 1;
        }

        for (int i = start; i <= 9; i++) {
            if (visited[i]) {
                continue;
            }

            visited[i] = true;
            num *= 10; // 用整数比用StringBuilder更快
            num += i;
            permutation(from + 1, bitCount, visited, num, ansArr);
            num /= 10;
            visited[i] = false;
        }
    }

    public int numDupDigitsAtMostN(int n) {
        int ans = 0;
        for (int i = 0; i < index; i++) {
            if (ansArr[i] <= n) {
                ans++;
            }
        }

        return n - ans;
    }
    
    public static void main(String[] args) {
        System.out.println(new Problem1012().numDupDigitsAtMostN(1));
        System.out.println(new Problem1012().numDupDigitsAtMostN(20));
        System.out.println(new Problem1012().numDupDigitsAtMostN(100));
        System.out.println(new Problem1012().numDupDigitsAtMostN(1000));

    }

}

//    给定正整数 N，返回小于等于 N 且具有至少 1 位重复数字的正整数。
//
//        示例 1：
//
//        输入：20
//        输出：1
//        解释：具有至少 1 位重复数字的正数（<= 20）只有 11 。
//        示例 2：
//
//        输入：100
//        输出：10
//        解释：具有至少 1 位重复数字的正数（<= 100）有 11，22，33，44，55，66，77，88，99 和 100 。
//        示例 3：
//
//        输入：1000
//        输出：262
//
//
//        提示：
//
//        1 <= N <= 10^9
