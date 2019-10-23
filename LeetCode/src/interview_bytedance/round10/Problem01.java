package interview_bytedance.round10;

import java.util.HashMap;
import java.util.Map;

public class Problem01 {

    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        Map<Integer, Integer> indexMap = new HashMap<>();

        for (int i = 0; i < nums2.length; i++) {
            indexMap.put(nums2[i], i);
        }

        int[] ans = new int[nums1.length];
        int count = 0;
        for (int i = 0; i < nums1.length; i++) {
            int index = indexMap.get(nums1[i]);
            boolean isFound = false;
            int j;
            for (j = index; j < nums2.length; j++) {
                if (nums2[j] > nums1[i]) {
                    isFound = true;
                    break;
                }
            }

            if (isFound) {
                ans[count++] = nums2[j];
            } else {
                ans[count++] = -1;
            }
        }

        return ans;
    }
    
    public static void main(String[] args) {

    }
    
}
