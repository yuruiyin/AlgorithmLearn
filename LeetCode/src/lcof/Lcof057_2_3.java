package lcof;

import java.util.ArrayList;
import java.util.List;

public class Lcof057_2_3 {

    private List<List<Integer>> ansList;

    private void rec(int target, int from, List<Integer> tmpList) {
        if (target == 0) {
            ansList.add(tmpList);
            return;
        }

        if (target < from) {
            return;
        }

        tmpList.add(from);
        rec(target - from, from + 1, tmpList);
    }

    public int[][] findContinuousSequence(int target) {
        ansList = new ArrayList<>();
        for (int i = 1; i <= target / 2; i++) {
            rec(target, i, new ArrayList<>());
        }

        int size = ansList.size();
        int[][] ansArr = new int[size][];
        for (int i = 0; i < size; i++) {
            List<Integer> list = ansList.get(i);
            int[] arr = new int[list.size()];
            for (int j = 0; j < list.size(); j++) {
                arr[j] = list.get(j);
            }
            ansArr[i] = arr;
        }

        return ansArr;
    }

}
