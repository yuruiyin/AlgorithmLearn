package contest.contest101;

import java.util.LinkedList;

public class Problem900 {

    class RLEIterator {

        class Data {
            int value;
            int count;
            Data(int value, int count) {
                this.value = value;
                this.count = count;
            }
        }

        private LinkedList<Data> queue;

        public RLEIterator(int[] arr) {
            queue = new LinkedList<>();
            int len = arr.length;
            for (int i = 0; i < len; i+=2) {
                if (arr[i] == 0) {
                    continue;
                }

                queue.offer(new Data(arr[i+1], arr[i]));
            }
        }

        public int next(int n) {
            while (!queue.isEmpty()) {
                Data data = queue.peek();
                if (data.count > n) {
                    data.count -= n;
                    return data.value;
                } else if (data.count == n) {
                    queue.poll();
                    return data.value;
                } else {
                    n -= data.count;
                    queue.poll();
                }
            }

            return -1;
        }
    }

}
