package doubleContest.round51;

import java.util.TreeSet;

/**
 * A
 *
 * @author: yry
 * @date: 2021/5/12
 */
public class B {

    class SeatManager {

        private TreeSet<Integer> treeSet;

        public SeatManager(int n) {
            treeSet = new TreeSet<>();
            for (int i = 1; i <= n; i++) {
                treeSet.add(i);
            }
        }

        public int reserve() {
            return treeSet.pollFirst();
        }

        public void unreserve(int seatNumber) {
            treeSet.add(seatNumber);
        }
    }

}
