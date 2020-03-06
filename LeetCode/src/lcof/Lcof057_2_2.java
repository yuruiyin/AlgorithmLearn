package lcof;

import java.util.ArrayList;
import java.util.List;

public class Lcof057_2_2 {

    private List<Integer> rec(int target, int from) {
        if (target == 0) {
            return new ArrayList<>();
        }

        if (target < from) {
            return null;
        }

        List<Integer> list = new ArrayList<>();
        list.add(from);
        List<Integer> nextList = rec(target - from, from + 1);
        if (nextList == null) {
            return null;
        }
        
        list.addAll(nextList);
        return list;
    }

    public int[][] findContinuousSequence(int target) {
        List<List<Integer>> ansList = new ArrayList<>();
        for (int i = 1; i <= target / 2; i++) {
            List<Integer> list = rec(target, i);
            if (list != null) {
                ansList.add(list);
            }
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
    
    public static void main(String[] args) {
        int[][] ansArr = new Lcof057_2_2().findContinuousSequence(15);
    }

}
