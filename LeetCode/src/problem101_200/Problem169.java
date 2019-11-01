package problem101_200;

import java.util.HashMap;
import java.util.Map;

public class Problem169 {

    public int majorityElement(int[] nums) {
        Map<Integer, Integer> countMap = new HashMap<>();

        for (int num: nums) {
            if (countMap.containsKey(num)) {
                countMap.put(num, countMap.get(num) + 1);
            } else {
                countMap.put(num, 1);
            }

            if (countMap.get(num) > nums.length / 2) {
                return num;
            }
        }

        return -1;
    }
    
    public static void main(String[] args) {

    }
    
}
