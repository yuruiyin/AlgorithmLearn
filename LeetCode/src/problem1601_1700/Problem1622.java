package problem1601_1700;

import java.util.ArrayList;
import java.util.List;

public class Problem1622 {

    class Fancy {

        private static final int MOD = (int) (1e9 + 7);

        private List<Long> list;

        public Fancy() {
            list = new ArrayList<>();
        }

        public void append(int val) {
            list.add((long) val);
        }

        public void addAll(int inc) {
            int size = list.size();
            for (int i = 0; i < size; i++) {
                list.set(i, (list.get(i) + inc) % MOD);
            }
        }

        public void multAll(int m) {
            int size = list.size();
            for (int i = 0; i < size; i++) {
                list.set(i, (list.get(i) * m) % MOD);
            }
        }

        public int getIndex(int idx) {
            int size = list.size();
            if (idx >= size) {
                return -1;
            }
            return (int) (list.get(idx) % MOD);
        }
    }

}
