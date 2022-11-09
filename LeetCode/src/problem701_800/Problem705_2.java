package problem701_800;

import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Set;

public class Problem705_2 {

    class MyHashSet {

        private final Set<Integer> set;

        public MyHashSet() {
            set = new HashSet<>();
        }

        public void add(int key) {
            set.add(key);
        }

        public void remove(int key) {
            set.remove(key);
        }

        public boolean contains(int key) {
            return set.contains(key);
        }
    }

}
