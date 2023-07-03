package spring_2023_group;

public class B {

    private boolean isOk(int[][] rampart, int target) {
        int len = rampart.length;
        int left = rampart[0][1];
        for (int i = 1; i < len - 1; i++) {
            int l = rampart[i][0] - left;
            int r = rampart[i + 1][0] - rampart[i][1];
            if (l + r < target) {
                return false;
            }
            left = Math.max(rampart[i][1], rampart[i + 1][0] - (l + r - target));
        }
        return true;
    }

    public int rampartDefensiveLine(int[][] rampart) {
        int len = rampart.length;
        int[] first = rampart[0];
        int[] last = rampart[len - 1];
        // 二分
        int l = 0;
        int r = (int) 1e8;
        int ans = 0;
        while (l <= r) {
            int mid = (l + r) >>> 1;
            if (isOk(rampart, mid)) {
                ans = mid;
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        return ans;
    }

}
