package problem901_1000;

import java.util.*;

public class Problem967 {

    private int n;

    private List<String> backTrack(int idx, int cur, int k) {
        if (idx == n - 1) {
            return new ArrayList<>(Collections.singleton(cur + ""));
        }

        List<String> list = new ArrayList<>();
        List<String> addRes = null;
        if (cur + k <= 9) {
            addRes = backTrack(idx + 1, cur + k, k);
        }

        List<String> minusRes = null;
        if (cur - k >= 0) {
            minusRes = backTrack(idx + 1, cur - k, k);
        }

        int firstNum = (int) (Math.pow(10, n - idx - 1) * cur);
        if (addRes != null) {
            for (String num : addRes) {
                list.add(cur + "" + num);
            }
        }

        if (minusRes != null) {
            for (String num : minusRes) {
                list.add(cur + "" + num);
            }
        }

//        if ((addRes != null || minusRes != null) && list.isEmpty()) {
//            list.add(cur + "");
//        }

        return list;
    }

    public int[] numsSameConsecDiff(int n, int k) {
        if (n == 1) {
            int[] ansArr = new int[10];
            for (int i = 0; i <= 9; i++) {
                ansArr[i] = i;
            }
            return ansArr;
        }

        this.n = n;
        List<Integer> ansList = new ArrayList<>();
        for (int i = 1; i <= 9; i++) {
            List<String> list = backTrack(0 , i, k);
            for (String num : list) {
                ansList.add(Integer.parseInt(num));
            }
        }

        Set<Integer> set = new HashSet<>(ansList);

        int size = set.size();
        int[] ansArr = new int[size];
        int index = 0;
        for (Integer num : set) {
            ansArr[index++] = num;
        }

        return ansArr;
    }

}
