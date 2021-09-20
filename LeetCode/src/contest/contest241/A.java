package contest.contest241;

import java.util.ArrayList;
import java.util.List;

/**
 * A
 *
 * @author: yry
 * @date: 2021/5/16
 */
public class A {

    private int[] arr;
    private int len;

    private int dfs(int cur, List<Integer> tmpList) {
        if (cur == len) {
            int ans = 0;
            for (int num : tmpList) {
                ans ^= num;
            }
            return ans;
        }

        int nonChoose = dfs(cur + 1, tmpList);
        tmpList.add(arr[cur]);
        int choose = dfs(cur + 1, tmpList);
        tmpList.remove(tmpList.size() - 1);
        return nonChoose + choose;
    }

    public int subsetXORSum(int[] nums) {
        arr = nums;
        this.len = arr.length;

        return dfs(0, new ArrayList<>());
    }

}
