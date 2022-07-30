package contest.contest301;

import java.util.TreeSet;

public class B {

    class SmallestInfiniteSet {

        private TreeSet<Integer> treeSet;

        public SmallestInfiniteSet() {
            treeSet = new TreeSet<>();
            for (int i = 1; i <= 1001; i++) {
                treeSet.add(i);
            }
        }

        public int popSmallest() {
            return treeSet.pollFirst();
        }

        public void addBack(int num) {
            treeSet.add(num);
        }
    }

}
