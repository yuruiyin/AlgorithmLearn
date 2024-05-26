package doubleContest.round131;

import java.util.List;

public class A {

    public int duplicateNumbersXOR(int[] nums) {
        boolean[] visited = new boolean[51];
        int ans = 0;
        for (int num : nums) {
            if (visited[num]) {
                ans ^= num;
            } else {
                visited[num] = true;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println("hello world");
    }

}
