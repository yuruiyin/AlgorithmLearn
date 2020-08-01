package contest.contest193;

import java.util.*;

/**
 * A
 *
 * @author: yry
 * @date: 2020/6/14
 */
public class B {

    public int findLeastNumOfUniqueInts(int[] arr, int k) {
        Map<Integer, Integer> countMap = new HashMap<>();

        for (int num : arr) {
            countMap.put(num, countMap.getOrDefault(num, 0) + 1);
        }

        List<Integer> countList = new ArrayList<>();

        for (int num : countMap.keySet()) {
            countList.add(countMap.get(num));
        }

        Collections.sort(countList);

        int size = countList.size();
        int sum = 0;

        for (int i = 0; i < size; i++) {
            sum += countList.get(i);
            if (sum == k) {
                return size - i - 1;
            } else if (sum > k){
                return size - i;
            }
        }

        return 0;
    }

}
