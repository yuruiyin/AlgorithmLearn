/**
 * LintCode633
 *
 * @author: yry
 * @date: 2020/3/20
 */
public class LintCode633 {

    public int findDuplicate(int[] nums) {
        // write your code here
        int len = nums.length;
        boolean[] visited = new boolean[len + 1];
        for (int num : nums) {
            if (visited[num]) {
                return num;
            }

            visited[num] = true;
        }

        return -1;
    }

}
