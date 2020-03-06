package lcci;

public class Lcci1704 {

    public int missingNumber(int[] nums) {
        int n = nums.length;
        boolean[] visited = new boolean[n + 1];
        for (int num : nums) {
            visited[num] = true;
        }

        for (int i = 0; i <= n; i++) {
            if (!visited[i]) {
                return i;
            }
        }

        return -1;
    }

}
