package problem801_900;

// TLE
public class Problem810 {

    private int[] nums;
    private int len;

    private boolean isWin(int preXor, boolean[] visited, boolean isMineTurn, int level) {
        if (level == len - 1) {
            return false;
        }

        for (int i = 0; i < len; i++) {
            if (visited[i]) {
                continue;
            }

            if ((preXor ^ nums[i]) == 0) {
                // 删除该数，当前玩家会输
                continue;
            }

            visited[i] = true;
            boolean tmpIsWin = isWin(preXor ^ nums[i], visited, !isMineTurn, level + 1);
            visited[i] = false;
            if (!tmpIsWin) {
                // 对方输了，那就是当前玩家赢了
                return true;
            }
        }

        return false;
    }

    public boolean xorGame(int[] nums) {
        this.nums = nums;
        this.len = nums.length;
        int xor = 0;
        for (int num : nums) {
            xor ^= num;
        }

        if (xor == 0) {
            return true;
        }

        return isWin(xor, new boolean[len], true, 0);
    }

}
