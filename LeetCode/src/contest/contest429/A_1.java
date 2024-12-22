package contest.contest429;

import java.util.HashSet;
import java.util.Set;

public class A_1 {

    public int minimumOperations(int[] nums) {
        int len = nums.length;
        boolean[] visited = new boolean[101];
        for (int i = len - 1; i >= 0; i--) {
            int num = nums[i];
            if (visited[num]) {
                return (i + 1) / 3 + ((i + 1) % 3 == 0 ? 0 : 1);
            }
            visited[num] = true;
        }
        return 0;
    }

    public static void main(String[] args) {
        System.out.println("hello world");
    }

}
