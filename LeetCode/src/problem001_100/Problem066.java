package problem001_100;

import utils.PrintUtil;

import java.util.ArrayList;
import java.util.List;

public class Problem066 {

    public int[] plusOne(int[] digits) {
        int n = digits.length;

        if (digits[n-1] < 9) {
            digits[n-1]++;
            return digits;
        }

        List<Integer> list = new ArrayList<>();
        int carry = 0;
        for (int i = n - 1; i >= 0; i--) {
            if (i == n - 1) {
                int value = digits[i] + 1;
                carry = value / 10;
                list.add(value % 10);
            } else {
                int value = digits[i] + carry;
                carry = value / 10;
                list.add(value % 10);
            }
        }

        if (carry == 1) {
            list.add(1);
        }

        int[] ansArr = new int[list.size()];

        for (int i = list.size() - 1; i >= 0; i--) {
            ansArr[list.size() - i - 1] = list.get(i);
        }

        return ansArr;
    }

    public static void main(String[] args) {
        int[] ans = new Problem066().plusOne(new int[]{1,2,3});
        PrintUtil.printIntArray(ans);

        int[] ans1 = new Problem066().plusOne(new int[]{4,3,2,1});
        PrintUtil.printIntArray(ans1);

        int[] ans2 = new Problem066().plusOne(new int[]{4,3,2,9});
        PrintUtil.printIntArray(ans2);

        int[] ans3 = new Problem066().plusOne(new int[]{9,9,9});
        PrintUtil.printIntArray(ans3);

        int[] ans4 = new Problem066().plusOne(new int[]{0});
        PrintUtil.printIntArray(ans4);
    }
    
}
