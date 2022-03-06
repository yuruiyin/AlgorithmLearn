package contest.contest269;

/**
* a
*
* @author: yry
* @date: 2021/11/28
*/
public class C {

    public int minimumDeletions(int[] nums) {
        int minValueIdx = -1;
        int maxValueIdx = -1;
        int max = -100001;
        int min = 100001;
        int len = nums.length;
        for (int i = 0; i < len; i++) {
            if (nums[i] > max) {
                max = Math.max(max, nums[i]);
                maxValueIdx = i;
            }

            if (nums[i] < min) {
                min = Math.min(min, nums[i]);
                minValueIdx = i;
            }
        }

        int minIdx = Math.min(minValueIdx, maxValueIdx);
        int maxIdx = Math.max(minValueIdx, maxValueIdx);

        return Math.min(Math.min(maxIdx + 1, len - minIdx), minIdx + 1 + len - maxIdx);
    }

}
