package doubleContest.round088;

public class B {

    class LUPrefix {

        boolean[] visited;
        private int curLongest;
        private int n;

        public LUPrefix(int n) {
            this.n = n;
            visited = new boolean[n + 1];
            curLongest = 0;
        }

        public void upload(int video) {
            visited[video] = true;
            if (video == curLongest + 1) {
                for (int i = video; i <= n; i++) {
                    if (!visited[i]) {
                        break;
                    }
                    curLongest = i;
                }
            }
        }

        public int longest() {
            return curLongest;
        }
    }


}
