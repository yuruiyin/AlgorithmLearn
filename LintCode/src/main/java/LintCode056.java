import java.util.HashMap;
import java.util.Map;

/**
 * LintCode056
 *
 * @author: yry
 * @date: 2020/3/17
 */
public class LintCode056 {

    public int[] twoSum(int[] numbers, int target) {
        Map<Integer, Integer> indexMap = new HashMap<>();
        for (int i = 0; i < numbers.length; i++) {
            int diff = target - numbers[i];
            if (indexMap.containsKey(diff)) {
                return new int[]{indexMap.get(diff), i};
            }

            indexMap.put(numbers[i], i);
        }

        return new int[]{-1, -1};
    }

}
