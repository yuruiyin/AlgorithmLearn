package problem601_700;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Problem679 {

    private int[] nums;
    private int len;
    private List<List<Double>> permutationList;

    private void getPermutationList(List<Double> tmpList, boolean[] visited) {
        if (tmpList.size() == len) {
            permutationList.add(new ArrayList<>(tmpList));
            return;
        }

        for (int i = 0; i < len; i++) {
            if (visited[i] || i > 0 && !visited[i-1] && nums[i] == nums[i-1]) {
                continue;
            }

            visited[i] = true;
            tmpList.add((double) nums[i]);
            getPermutationList(tmpList, visited);
            tmpList.remove(tmpList.size() - 1);
            visited[i] = false;
        }
    }

    private boolean rec(List<Double> numList) {
        int size = numList.size();
        if (size== 1) {
            return Math.abs(numList.get(0) - 24) <= 1e-6;
        }

        // 选择相邻的两两先结合（执行四则运算）
        for (int i = 0; i < size - 1; i++) {
            // +，-，*，/
            List<Double> newNumList = new ArrayList<>();
            newNumList.add(numList.get(i) + numList.get(i+1));
            newNumList.add(numList.get(i) - numList.get(i+1));
            newNumList.add(numList.get(i) * numList.get(i+1));
            if (numList.get(i+1) != 0) {
                newNumList.add(numList.get(i) / numList.get(i+1));
            }

            for (Double newNum: newNumList) {
                List<Double> nextList = new ArrayList<>(numList);
                nextList.set(i, newNum);
                nextList.remove(i + 1);
                if (rec(nextList)) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean judgePoint24(int[] nums) {
        this.nums = nums;
        this.len = nums.length;
        permutationList = new ArrayList<>();
        Arrays.sort(nums);
        getPermutationList(new ArrayList<>(), new boolean[len]);

        for (List<Double> numList : permutationList) {
            if (rec(numList)) {
                return true;
            }
        }

        return false;
    }
    
    public static void main(String[] args) {
//        System.out.println(new Problem679().judgePoint24(new int[]{4, 1, 8, 7}));
//        System.out.println(new Problem679().judgePoint24(new int[]{1, 2, 1, 2}));
//        System.out.println(new Problem679().judgePoint24(new int[]{7, 2, 6, 6}));
//        System.out.println(new Problem679().judgePoint24(new int[]{1, 3, 4, 6}));
//        System.out.println(new Problem679().judgePoint24(new int[]{3, 5, 1, 1}));
//        System.out.println(new Problem679().judgePoint24(new int[]{8, 1, 6, 6}));
        System.out.println(new Problem679().judgePoint24(new int[]{3, 3, 8, 8}));
    }

}
