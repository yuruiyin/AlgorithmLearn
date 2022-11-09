package problem701_800;

public class Problem705 {

    class MyHashSet {

        private static final int MAX = 1000_001;

        private final boolean[] visited;

        public MyHashSet() {
            visited = new boolean[MAX];
        }

        public void add(int key) {
            visited[key] = true;
        }

        public void remove(int key) {
            visited[key] = false;
        }

        public boolean contains(int key) {
            return visited[key];
        }
    }

}
