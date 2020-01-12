package doubleContest.round17;

import java.util.ArrayList;
import java.util.List;

public class Problem01 {

    public int[] decompressRLElist(int[] nums) {
        int len = nums.length;
        List<Integer> ansList = new ArrayList<>();

        for (int i = 0; i < len; i+=2) {
            int a = nums[i];
            int b = nums[i+1];
            for (int j = 0; j < a; j++) {
                ansList.add(b);
            }
        }

        int size = ansList.size();
        int[] arr = new int[size];
        for (int i = 0; i < size; i++) {
            arr[i] = ansList.get(i);
        }

        return arr;
    }

}
