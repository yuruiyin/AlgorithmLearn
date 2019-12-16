package problem201_300;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Problem228 {

    private String getInterval(int start, int end) {
        String interval;
        if (end == start) {
            interval = String.valueOf(start);
        } else {
            interval = start + "->" + end;
        }
        return interval;
    }

    public List<String> summaryRanges(int[] nums) {
        if (nums == null || nums.length == 0) {
            return new ArrayList<>();
        }

        int len = nums.length;
        int start = nums[0];
        int end = nums[0];
        List<String> ansList = new ArrayList<>();

        for (int i = 1; i < len; i++) {
            if (nums[i] == nums[i-1] + 1) {
                end = nums[i];
            } else {
                ansList.add(getInterval(start, end));
                start = nums[i];
                end = nums[i];
            }
        }

        ansList.add(getInterval(start, end));
        return ansList;
    }

}
