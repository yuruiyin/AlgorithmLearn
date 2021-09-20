package contest.contest224;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * A
 *
 * @author: yry
 * @date: 2021/5/15
 */
public class B {

    public int tupleSameProduct(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }

        Map<Integer, Integer> countMap = new HashMap<>();
        int size = 0;
        for (int num : set) {
            nums[size++] = num;
        }

        for (int i = 0; i < size; i++) {
            for (int j = i + 1; j < size; j++) {
                int key = nums[i] * nums[j];
                countMap.put(key, countMap.getOrDefault(key, 0) + 1);
            }
        }

        int ans = 0;
        for (int key : countMap.keySet()) {
            int count = countMap.get(key);
            if (count <= 1) {
                continue;
            }

            ans += 4 * count * (count - 1);
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(new B().tupleSameProduct(new int[]{1,2,4,8,16,32,64,128,256,512,1024,2048,4096,8192}));
    }

}
