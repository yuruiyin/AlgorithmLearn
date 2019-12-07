package problem301_400;

import java.util.*;

public class Problem380 {

    class RandomizedSet {

        private Random random;
        private List<Integer> list;
        private Map<Integer, Integer> indexMap;

        /** Initialize your data structure here. */
        public RandomizedSet() {
            list = new ArrayList<>();
            indexMap = new HashMap<>();
            random = new Random();
        }

        /** Inserts a value to the set. Returns true if the set did not already contain the specified element. */
        public boolean insert(int val) {
            if (indexMap.containsKey(val)) {
                return false;
            }

            indexMap.put(val, list.size());
            return list.add(val);
        }

        /** Removes a value from the set. Returns true if the set contained the specified element. */
        public boolean remove(int val) {
            if (!indexMap.containsKey(val)) {
                return false;
            }

            int index = indexMap.get(val);
            list.set(index, list.get(list.size() - 1)); // 最后一个补到要被删掉的元素的位置上
            indexMap.put(list.get(index), index);
            indexMap.remove(val);
            list.remove(list.size() - 1);
            return true;
        }

        /** Get a random element from the set. */
        public int getRandom() {
            int index = random.nextInt(list.size());
            return list.get(index);
        }
    }

}
