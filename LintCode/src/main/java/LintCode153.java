import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * LintCode153
 *
 * @author: yry
 * @date: 2020/3/19
 */
public class LintCode153 {

    private int[] arr;
    private int len;
    private List<List<Integer>> ansList;

    private void backTrack(int from, int target, int sum, List<Integer> tmpList, boolean[] visited) {
        if (sum == target) {
            ansList.add(new ArrayList<>(tmpList));
            return;
        }

        if (sum > target) {
            return;
        }

        for (int i = from; i < len; i++) {
            if (visited[i] || i > 0 && !visited[i - 1] && arr[i] == arr[i-1]) {
                continue;
            }

            visited[i] = true;
            tmpList.add(arr[i]);
            backTrack(i + 1, target, sum + arr[i], tmpList, visited);
            tmpList.remove(tmpList.size() - 1);
            visited[i] = false;
        }
    }

    public List<List<Integer>> combinationSum2(int[] num, int target) {
        // write your code here
        this.arr = num;
        this.len = arr.length;
        Arrays.sort(arr);
        ansList = new ArrayList<>();
        backTrack(0, target, 0, new ArrayList<>(), new boolean[len]);
        return ansList;
    }
}
