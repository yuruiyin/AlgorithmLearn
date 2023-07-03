package contest.contest352;

import utils.TreeMultiSet;

import java.util.TreeSet;

public class D {

    public int sumImbalanceNumbers(int[] nums) {
        int len = nums.length;
        int ans = 0;
        for (int s = 0; s < len - 1; s++) {
            TreeSet<Integer> treeSet = new TreeSet<>();
            treeSet.add(nums[s]);
            int pre = 0;
            for (int e = s + 1; e < len; e++) {
                int num = nums[e];
                if (!treeSet.contains(num)) {
                    Integer firstBiggerNum = treeSet.higher(num);
                    if (firstBiggerNum != null && firstBiggerNum > num + 1) {
                        pre++;
                    }
                    Integer lastSmallerNum = treeSet.lower(num);
                    if (lastSmallerNum != null && lastSmallerNum + 1 < num) {
                        pre++;
                    }

                    if (firstBiggerNum != null && lastSmallerNum != null) {
                        pre--;
                    }
                }

                ans += pre;
                treeSet.add(num);
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(new D().sumImbalanceNumbers(new int[]{3, 1, 2}));
    }

}
