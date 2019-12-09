package problem201_300;

import java.util.LinkedList;

public class Problem251 {

    class Vector2D {

        private LinkedList<Integer> queue = new LinkedList<>();

        public Vector2D(int[][] v) {
            for (int[] row: v) {
                for (int col : row) {
                    queue.add(col);
                }
            }
        }

        public int next() {
            return queue.poll();
        }

        public boolean hasNext() {
            return !queue.isEmpty();
        }
    }

}
