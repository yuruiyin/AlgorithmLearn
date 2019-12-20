package problem201_300;

import java.util.List;

public class Problem281 {

    public class ZigzagIterator {

        private List<Integer> list1;
        private List<Integer> list2;
        private int index1;
        private int index2;
        private boolean isFirstTurn; // 是否轮到第一个

        public ZigzagIterator(List<Integer> v1, List<Integer> v2) {
            list1 = v1;
            list2 = v2;
            index1 = 0;
            index2 = 0;
            isFirstTurn = true;
        }

        public int next() {
            if (index1 == list1.size()) {
                return list2.get(index2++);
            }

            if (index2 == list2.size()) {
                return list1.get(index1++);
            }

            if (isFirstTurn) {
                isFirstTurn = false;
                return list1.get(index1++);
            } else {
                isFirstTurn = true;
                return list2.get(index2++);
            }
        }

        public boolean hasNext() {
            return index1 < list1.size() || index2 < list2.size();
        }
    }

}
