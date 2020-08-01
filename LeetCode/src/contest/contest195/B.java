package contest.contest195;

import java.util.HashMap;
import java.util.Map;

/**
 * A
 *
 * @author: yry
 * @date: 2020/6/30
 */
public class B {


    public boolean canArrange(int[] arr, int k) {
        Map<Integer, Integer> modCountMap = new HashMap<>();

        for (int num : arr) {
            int mod = (num % k + k) % k;
            int diffMod = (k - mod) % k;
            int diffModCount = modCountMap.getOrDefault(diffMod, 0);
            if (diffModCount > 0) {
                modCountMap.put(diffMod, diffModCount - 1);
            } else {
                modCountMap.put(mod, modCountMap.getOrDefault(mod, 0) + 1);
            }
        }

        for (int mod : modCountMap.keySet()) {
            if (modCountMap.get(mod) != 0) {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        System.out.println(new B().canArrange(new int[]{
                -1,1,-2,2,-3,3,-4,4
        }, 3));
    }

}
