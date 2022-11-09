package doubleContest.round089;

import java.util.*;

public class D {

    private List<Integer>[] adj;

    private int len;

    private int[] nums;

    private List<Integer> getAllFactors(int num) {
        List<Integer> list = new ArrayList<>();
        int end = (int) Math.sqrt(num);
        for (int i = 1; i <= end; i++) {
            if (num % i == 0) {
                list.add(i);
                if (num / i != i) {
                    list.add(num / i);
                }
            }
        }
        return list;
    }

    private boolean bfs(int eachSum) {
        if (len == 1) {
            // 只有一个节点
            return eachSum == nums[0];
        }

        LinkedList<Integer> queue = new LinkedList<>();
        int[] arr = Arrays.copyOf(nums, nums.length);

        Set<Integer>[] adjSet = new HashSet[len];
        for (int i = 0; i < len; i++) {
            adjSet[i] = new HashSet<>(adj[i]);
            if (adjSet[i].size() == 1) {
                queue.add(i);
            }
        }

        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int node = queue.poll();
                Set<Integer> nextSet = adjSet[node];
                if (arr[node] > eachSum) {
                    return false;
                }
                for (int next : nextSet) {
                    adjSet[next].remove(node);
                    if (arr[node] < eachSum) {
                        arr[next] += arr[node];
                        if (arr[next] > eachSum) {
                            return false;
                        }
                    }
                    if (adjSet[next].size() == 1) {
                        queue.add(next);
                    }
                }
            }
        }

        return true;
    }

    public int componentValue(int[] nums, int[][] edges) {
        this.len = nums.length;
        this.nums = nums;
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }

        adj = new ArrayList[len];
        Arrays.setAll(adj, value -> new ArrayList<>());
        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];
            adj[u].add(v);
            adj[v].add(u);
        }

        List<Integer> factors = getAllFactors(sum);
        Collections.sort(factors);
        int size = factors.size();
        for (int i = size - 1; i >= 0; i--) {
            int factor = factors.get(i);
            // 从大到小
            if (factor == 1) {
                return 0;
            }

            if (bfs(sum / factor)) {
                return factor - 1;
            }
        }

        return 0;
    }

    public static void main(String[] args) {
//        System.out.println(getAllFactors(1000000).size());
        System.out.println(new D().componentValue(new int[]{2}, new int[][]{}));
    }

}
