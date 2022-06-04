package problem401_500;

public class Problem464 {

    private Boolean[][] memo;
    private int target;

    private boolean rec(int idx, int nums, int sum) {
        if (sum >= target) {
            return false;
        }

        if (nums == 0) {
            return false;
        }

        if (memo[idx][nums] != null) {
            return memo[idx][nums];
        }

        boolean isOk = false;
        for (int i = 0; (1 << i) <= nums; i++) {
            int chooseValue = 1 << i;
            if ((nums & chooseValue) == 0) {
                continue;
            }
            if (!rec(idx ^ 1, nums ^ chooseValue, sum + i + 1)) {
                isOk = true;
                break;
            }
        }

        memo[idx][nums] = isOk;
        return isOk;
    }

    public boolean canIWin(int maxChoosableInteger, int desiredTotal) {
        if (desiredTotal == 0) {
            return true;
        }

        if ((maxChoosableInteger * (maxChoosableInteger + 1)) >>> 1 < desiredTotal) {
            return false;
        }

        memo = new Boolean[2][1 << maxChoosableInteger];
        this.target = desiredTotal;
        return rec(0, (1 << maxChoosableInteger) - 1, 0);
    }

    public static void main(String[] args) {
//        System.out.println(new Problem464().canIWin(10, 11));
        System.out.println(new Problem464().canIWin(5, 50));
    }

}
