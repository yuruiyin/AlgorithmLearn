package problem801_900;

import java.util.ArrayList;
import java.util.List;

public class Problem855 {

    class ExamRoom {

        List<Integer> list;
        private int n;

        public ExamRoom(int N) {
            list = new ArrayList<>();
            n = N;
        }

        private int find(List<Integer> list, int target) {
            int size = list.size();
            int low = 0;
            int high = size - 1;
            while (low <= high) {
                int mid = (low + high) >>> 1;
                int midVal = list.get(mid);
                if (target > midVal) {
                    if (mid == size - 1 || list.get(mid + 1) > target) {
                        return mid + 1;
                    }

                    low = mid + 1;
                } else {
                    high = mid - 1;
                }
            }

            return 0;
        }

        public int seat() {
            int size = list.size();
            if (size == 0) {
                list.add(0);
                return 0;
            }

            int startLen = list.get(0);
            int endLen = n - list.get(size - 1) - 1;
            int maxIndex = -1;
            int max = 0;
            if (startLen >= endLen) {
                max = startLen;
                maxIndex = 0;
            } else {
                max = endLen;
                maxIndex = n-1;
            }

            for (int i = 0; i < size - 1; i++) {
                int diff = list.get(i + 1) - list.get(i);
                int len = diff / 2;
                if (len > max || len == max && list.get(i) + len < maxIndex) {
                    max = len;
                    maxIndex = list.get(i) + len;
                }
            }

            int insertIndex = find(list, maxIndex);
            if (insertIndex == size) {
                list.add(maxIndex);
            } else {
                list.add(insertIndex, maxIndex);
            }

            return maxIndex;
        }

        public void leave(int p) {
            list.remove(Integer.valueOf(p));
        }
    }

}
