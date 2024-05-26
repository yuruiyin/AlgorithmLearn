package doubleContest.round113;

import java.util.*;

public class B {

    public int minLengthAfterRemovals(List<Integer> nums) {
        int size = nums.size();
        Map<Integer, Integer> countMap = new HashMap<>();
        for (int num : nums) {
            countMap.put(num, countMap.getOrDefault(num, 0) + 1);
        }

        PriorityQueue<Integer> heap = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return countMap.getOrDefault(o2, 0) - countMap.getOrDefault(o1, 0);
            }
        });

        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            if (set.contains(num)) {
                continue;
            }
            set.add(num);
            heap.add(num);
        }

//        Set<Integer> visited = new HashSet<>();
        for (int i = 0; i < size; i++) {
            int num = nums.get(i);
            if (!countMap.containsKey(num) || countMap.getOrDefault(num, 0) == 0) {
                continue;
            }
//            visited.add(num);
            while (!heap.isEmpty() && (heap.peek() == num || countMap.getOrDefault(heap.peek(), 0) == 0)) {
                heap.poll();
            }
            if (heap.isEmpty()) {
                int ans = 0;
                Set<Integer> set1 = new HashSet<>();
                for (int tmp: nums) {
                    if (set1.contains(tmp)) {
                        continue;
                    }
                    set1.add(tmp);
                    ans += countMap.getOrDefault(tmp, 0);
                }
                return ans;
            }
            int top = heap.poll();
            if (countMap.get(top) > 1) {
                countMap.put(top, countMap.get(top) - 1);
                heap.add(top);
            } else {
                countMap.remove(top);
            }
            if (countMap.get(num) == 1) {
                countMap.remove(num);
            } else {
                countMap.put(num, countMap.get(num) - 1);
            }
        }

        return 0;
    }

    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
//        list.add(1);
//        list.add(3);
//        list.add(3);
//        list.add(3);
//        list.add(4);

        list.add(1);
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(3);

        System.out.println(new B().minLengthAfterRemovals(list));
    }

}
