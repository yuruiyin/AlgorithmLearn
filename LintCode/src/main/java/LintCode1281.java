import java.util.*;

/**
 * LintCode1281
 *
 * @author: yry
 * @date: 2020/3/20
 */
public class LintCode1281 {

    class Data {
        int val;
        int count;
        Data(int val, int count) {
            this.val = val;
            this.count = count;
        }
    }

    public List<Integer> topKFrequent(int[] nums, int k) {
        if (nums == null || nums.length == 0) {
            return new ArrayList<>(Collections.singleton(0));
        }

        Map<Integer, Integer> countMap = new HashMap<>();
        for (int num : nums) {
            countMap.put(num, countMap.getOrDefault(num, 0) + 1);
        }

        PriorityQueue<Data> heap = new PriorityQueue<>(Comparator.comparingInt(o -> o.count));

        for (Integer num : countMap.keySet()) {
            heap.offer(new Data(num, countMap.get(num)));
            if (heap.size() > k) {
                heap.poll();
            }
        }

        List<Integer> ansList = new ArrayList<>();
        while (!heap.isEmpty()) {
            ansList.add(heap.poll().val);
        }

        return ansList;
    }

}
