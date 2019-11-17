package interview_google.round08;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Problem02 {

    public boolean canFinish(int n, int[][] prerequisites) {
        ArrayList<Integer>[] adj = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            adj[i] = new ArrayList<>();
        }

        for (int[] prerequisite : prerequisites) {
            int prev = prerequisite[1];
            int cur = prerequisite[0];
            adj[prev].add(cur);
        }

        int[] inDegreeArr = new int[n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < adj[i].size(); j++) {
                int cur = adj[i].get(j);
                inDegreeArr[cur]++;
            }
        }

        LinkedList<Integer> queue = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            if (inDegreeArr[i] == 0) {
                queue.add(i);
            }
        }

        int zeroInDegreeCount = 0;

        while (!queue.isEmpty()) {
            List<Integer> nodeList = new ArrayList<>();
            while (!queue.isEmpty()) {
                nodeList.add(queue.removeFirst());
                zeroInDegreeCount++;
            }

            for (Integer node : nodeList) {
                for (int i = 0; i < adj[node].size(); i++) {
                    int cur = adj[node].get(i);
                    inDegreeArr[cur]--;
                    if (inDegreeArr[cur] == 0) {
                        queue.add(cur);
                    }
                }
            }
        }

        return zeroInDegreeCount == n;
    }
    
    public static void main(String[] args) {
        
    }
    
}
