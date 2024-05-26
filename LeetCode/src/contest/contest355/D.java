package contest.contest355;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class D {

    class Data {
        char edge;
        int nextNode;
        Data(int nextNode, char edge) {
            this.edge = edge;
            this.nextNode = nextNode;
        }
    }

    private int n;
    private List<Data>[] adj;

    private int[] memo;


    public long countPalindromePaths(List<Integer> parent, String s) {
        this.n = parent.size();
        if (n == 1) {
            return 0;
        }

        adj = new ArrayList[n];
        Arrays.setAll(adj, value -> new ArrayList<>());
        char[] edgeArr = s.toCharArray();
        for (int i = 1; i < n; i++) {
            int u = i;
            int v = parent.get(u);
            char edge = edgeArr[u];
            adj[u].add(new Data(v, edge));
            adj[v].add(new Data(u, edge));
        }

        return 0;
    }

}
