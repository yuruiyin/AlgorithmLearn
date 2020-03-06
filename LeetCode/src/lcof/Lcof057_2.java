package lcof;

import java.util.ArrayList;
import java.util.List;

public class Lcof057_2 {

    public int[][] findContinuousSequence(int target) {
        List<List<Integer>> ansList = new ArrayList<>();

        for (int i = 1; i <= target / 2; i++) {
            int sum = i;
            List<Integer> list = new ArrayList<>();
            list.add(i);
            for (int j = i + 1; ;j++) {
                sum += j;
                list.add(j);
                if (sum > target) {
                    break;
                }

                if (sum == target) {
                    ansList.add(list);
                    break;
                }
            }
        }

        int len = ansList.size();
        int[][] ansArr = new int[len][];

        for (int i = 0; i < len; i++) {
            ansArr[i] = new int[ansList.get(i).size()];
            for (int j = 0; j < ansList.get(i).size(); j++) {
                ansArr[i][j] = ansList.get(i).get(j);
            }
        }

        return ansArr;
    }

}
