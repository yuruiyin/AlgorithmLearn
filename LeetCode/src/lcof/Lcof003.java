package lcof;

public class Lcof003 {

    public int findRepeatNumber(int[] nums) {
        int len = nums.length;
        boolean[] visited = new boolean[len];

        for (int num : nums) {
            if (visited[num]) {
                return num;
            }
            visited[num] = true;
        }

        return -1;
    }

}
