package contest.contest423;

import java.util.*;


public class B {

    public int maxIncreasingSubarrays(List<Integer> nums) {
        int len = nums.size();
        List<Integer> countList = new ArrayList<>();
        int count = 1;
        for (int i = 1; i < len; i++) {
            if (nums.get(i) > nums.get(i - 1)) {
                count++;
            } else {
                countList.add(count);
                count = 1;
            }
        }

        countList.add(count);
        if (countList.size() == 1) {
            return countList.get(0) / 2;
        }

        int ansMax = countList.get(0) / 2;
        for (int i = 1; i < countList.size(); i++) {
            ansMax = Math.max(ansMax, Math.min(countList.get(i), countList.get(i - 1)));
            ansMax = Math.max(ansMax, countList.get(i) / 2);
        }
        return ansMax;
    }

    public static void main(String[] args) {
        System.out.println("hello world");
    }

}
