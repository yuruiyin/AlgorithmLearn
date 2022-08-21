package contest.contest306;

public class B {

    public int edgeScore(int[] edges) {
        int n = edges.length;
        long[] inDegree = new long[n];
        for (int i = 0; i < n; i++) {
            inDegree[edges[i]] += i;
        }

        long maxDegree = 0;
        for (long d : inDegree) {
            maxDegree = Math.max(maxDegree, d);
        }

        for (int i = 0; i < n; i++) {
            if (inDegree[i] == maxDegree) {
                return i;
            }
        }
        return -1;
    }

}
