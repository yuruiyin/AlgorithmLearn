package contest.contest481;

public class B {

    public long minCost(String s, int[] cost) {
        char[] arr = s.toCharArray();
        int len = arr.length;

        long ansMin = Long.MAX_VALUE;

        for (char c = 'a'; c <= 'z'; c++) {
            long res = 0;
            for (int i = 0; i < len; i++) {
                if (arr[i] == c) {
                    continue;
                }
                res += cost[i];
            }
            ansMin = Math.min(ansMin, res);
        }

        return ansMin;
    }

    public static void main(String[] args) {
        System.out.println("hello world");
    }

}
