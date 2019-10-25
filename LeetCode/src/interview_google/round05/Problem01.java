package interview_google.round05;

import java.util.HashMap;
import java.util.Map;

public class Problem01 {

    public boolean containsNearbyDuplicate(int[] nums, int k) {
        int n = nums.length;
        Map<Integer, Integer> indexMap = new HashMap<>();

        for (int i = 0; i < n; i++) {
            if (indexMap.containsKey(nums[i])) {
                if (i - indexMap.get(nums[i]) <= k) {
                    return true;
                }
            }

            indexMap.put(nums[i], i);
        }

        return false;
    }
    
    public static void main(String[] args) {
        System.out.println(new Problem01().containsNearbyDuplicate(new int[]{1,2,3,1}, 3));
        System.out.println(new Problem01().containsNearbyDuplicate(new int[]{1,0,1,1}, 1));
        System.out.println(new Problem01().containsNearbyDuplicate(new int[]{1,2,3,1,2,3}, 2));

    }
    
}
