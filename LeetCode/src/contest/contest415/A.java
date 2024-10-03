package contest.contest415;

import java.util.HashSet;
import java.util.Set;

public class A {

    public int[] getSneakyNumbers(int[] nums) {
        int[] ansArr = new int[2];
        Set<Integer> set = new HashSet<>();
        int i = 0;
        for (int num : nums) {
            if (set.contains(num)) {
                ansArr[i++] = num;
            }
            set.add(num);
        }
        return ansArr;
    }

    public static void main(String[] args) {
        System.out.println("hello world");
    }

}
