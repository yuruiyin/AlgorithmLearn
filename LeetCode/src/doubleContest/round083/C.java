package doubleContest.round083;

import java.util.*;

public class C {

    class NumberContainers {

        private TreeMap<Integer, Integer> map;
        private Map<Integer, TreeSet<Integer>> indexMap;

        public NumberContainers() {
            map = new TreeMap<>();
            indexMap = new HashMap<>();
        }

        public void change(int index, int number) {
            if (map.containsKey(index)) {
                int oldNum = map.get(index);
                indexMap.get(oldNum).remove(index);
                map.put(index, number);
                if (!indexMap.containsKey(number)) {
                    indexMap.put(number, new TreeSet<>());
                }
                indexMap.get(number).add(index);
            } else {
                map.put(index, number);
                if (!indexMap.containsKey(number)) {
                    indexMap.put(number, new TreeSet<>());
                }
                indexMap.get(number).add(index);
            }
        }

        public int find(int number) {
            TreeSet<Integer> indexSet = indexMap.get(number);
            if (indexSet == null || indexSet.isEmpty()) {
                return -1;
            }
            return indexSet.first();
        }
    }

}
