package doubleContest.round097;

import java.util.ArrayList;
import java.util.List;

public class A {

    public int[] separateDigits(int[] nums) {
        List<Integer> list = new ArrayList<>();
        for (int num : nums) {
            char[] arr = String.valueOf(num).toCharArray();
            for (char c: arr) {
                list.add(c - '0');
            }
        }

        int[] ansArr = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            ansArr[i] = list.get(i);
        }
        return ansArr;
    }

    public static void main(String[] args) {
        System.out.println("hello world");
    }

}
