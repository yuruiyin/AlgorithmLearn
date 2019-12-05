package problem101_200;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Problem163 {

    private String getRangeStr(int start, int end) {
        String str;
        if (end == start) {
            str = start + "";
        } else {
            str = start + "->" + end;
        }
        return str;
    }

    public List<String> findMissingRanges(int[] nums, int lower, int upper) {
        int len = nums.length;
        if (len == 0) {
            String str = getRangeStr(lower, upper);
            return new ArrayList<>(Collections.singletonList(str));
        }

        List<String> ansList = new ArrayList<>();
        if (lower < nums[0]) {
            int end = Math.min(upper, nums[0] - 1);
            ansList.add(getRangeStr(lower, end));
        }

        for (int i = 0; i < len && nums[i] < upper; i++) {
            if (i == len - 1) {
                ansList.add(getRangeStr(nums[i] + 1, upper));
                break;
            }

            if (nums[i] == nums[i+1] - 1 || nums[i] == nums[i+1]) {
                continue;
            }

            int start = nums[i] + 1;
            int end = Math.min(upper, nums[i+1] - 1);
            ansList.add(getRangeStr(start, end));
        }

        return ansList;
    }

}
