package problem001_100;

import utils.PrintUtil;

import java.util.ArrayList;
import java.util.List;

public class Problem077 {

    private List<List<Integer>> ansList;

    private void backTrack(int n, int from, int k, List<Integer> tmpList) {
        if (tmpList.size() == k) {
            ansList.add(new ArrayList<>(tmpList));
            return;
        }

        int needCount = k - tmpList.size(); // 还需要的个数
        if (n - from + 1 < needCount) {
            return;
        }
        for (int i = from; i <= n; i++) {
            tmpList.add(i);
            backTrack(n, i+1, k, tmpList);
            tmpList.remove(tmpList.size() - 1);
        }
    }

    public List<List<Integer>> combine(int n, int k) {
        ansList = new ArrayList<>();
        backTrack(n, 1, k, new ArrayList<>());
        return ansList;
    }
    
    public static void main(String[] args) {
        List<List<Integer>> ansList = new Problem077().combine(4, 2);
        PrintUtil.printIntListList(ansList);
    }
    
}
