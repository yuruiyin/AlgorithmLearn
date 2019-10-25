package interview_google.round05;

import java.util.*;

public class Problem03 {

    public List<List<Integer>> threeSum(int[] nums) {
        int n = nums.length;
        if (n < 3 || n == 3 && nums[0] + nums[1] + nums[2] != 0) {
            return new ArrayList<>();
        }

        Map<Integer, Integer> indexMap = new HashMap<>();
        Arrays.sort(nums);

        for (int i = 0; i < n; i++) {
            indexMap.put(nums[i], i);
        }

        List<List<Integer>> ansList = new ArrayList<>();
        for (int i = 0; i < n; i ++) {
            if (i > 0 && nums[i] == nums[i-1]) {
                continue;
            }

            for (int j = i + 1; j < n; j++) {
                if (j > i + 1 && nums[j] == nums[j-1]) {
                    continue;
                }
                int sum = nums[i] + nums[j];
                if (indexMap.containsKey(-sum)) {
                    int index = indexMap.get(-sum);
                    if (index > i && index > j) {
                        ansList.add(new ArrayList<>(Arrays.asList(nums[i], nums[j], nums[index])));
                    }
                }
            }
        }

        return ansList;
    }
    
    public static void main(String[] args) {
        List<List<Integer>> ansList = new Problem03().threeSum(new int[]{-1, 0, 1, 2, -1, -4});
        
        for (List<Integer> list : ansList) {
            for (Integer num: list) {
                System.out.print(num + ",");
            }
            System.out.println();
        }
    }
    
}
