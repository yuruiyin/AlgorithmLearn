import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * LintCode016
 *
 * @author: yry
 * @date: 2020/3/19
 */
public class LintCode016 {

    private int[] arr;
    private int len;
    private List<List<Integer>> ansList;

    private void backTrack(List<Integer> tmpList, boolean[] visited) {
        if (tmpList.size() == len) {
            ansList.add(new ArrayList<>(tmpList));
            return;
        }

        for (int i = 0; i < len; i++) {
            if (visited[i] || i > 0 && !visited[i - 1] && arr[i] == arr[i-1]) {
                continue;
            }

            visited[i] = true;
            tmpList.add(arr[i]);
            backTrack(tmpList, visited);
            tmpList.remove(tmpList.size() - 1);
            visited[i] = false;
        }
    }

    public List<List<Integer>> permuteUnique(int[] nums) {
        // write your code here
        this.arr = nums;
        this.len = arr.length;
        ansList = new ArrayList<>();
        Arrays.sort(arr);
        backTrack(new ArrayList<>(), new boolean[len]);
        return ansList;
    }

}
