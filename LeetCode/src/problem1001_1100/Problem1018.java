package problem1001_1100;

import java.util.ArrayList;
import java.util.List;

public class Problem1018 {

    public List<Boolean> prefixesDivBy5(int[] arr) {
        // 二进制除法
        int prev = 0;
        List<Boolean> ansList = new ArrayList<>();
        for (int num : arr) {
            int value = (prev << 1) + num;
            ansList.add(value % 5 == 0);
            if (value >= 5) {
                prev = value - 5;
            } else {
                prev = value;
            }
        }

        return ansList;
    }

    public static void main(String[] args) {
        List<Boolean> ansList = new Problem1018().prefixesDivBy5(new int[]{1,1,1,0,1});
    }

}
