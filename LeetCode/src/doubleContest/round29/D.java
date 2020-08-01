package doubleContest.round29;

import java.util.*;

/**
 * A
 *
 * @author: yry
 * @date: 2020/6/27
 */
public class D {

    private List<Integer>[] preListArr;
    private List<Integer>[] nextListArr;

    class Data {
        int root;
        int depth;
        Data(int root, int depth) {
            this.root = root;
            this.depth = depth;
        }
    }

    private int getDepth(int root) {
        LinkedList<Integer> queue = new LinkedList<>();
        queue.add(root);
        int depth = 0;

        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int node = queue.poll();
                List<Integer> preList = preListArr[node];
                if (preList == null) {
                    continue;
                }

                for (int pre : preList) {
                    queue.offer(pre);
                }
            }

            depth++;
        }

        return depth;
    }

    private List<Integer> getLeafs(int root) {
        LinkedList<Integer> queue = new LinkedList<>();
        queue.add(root);
        List<Integer> leafList = new ArrayList<>();

        while (!queue.isEmpty()) {
            int size = queue.size();
            List<Integer> tmpList = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                int node = queue.poll();
                tmpList.add(node);
                List<Integer> preList = preListArr[node];
                if (preList == null) {
                    continue;
                }
                for (int pre : preList) {
                    queue.offer(pre);
                }
            }
            leafList = tmpList;
        }

        return leafList;
    }

    private void removeLeafs(List<Integer> leafs) {
        for (int leaf : leafs) {
            List<Integer> nextList = nextListArr[leaf];
            if (nextList == null) {
                continue;
            }

            for (int next : nextList) {
                preListArr[next].remove((Integer) leaf);
            }
        }
    }

    public int minNumberOfSemesters(int n, int[][] edges, int k) {
        // 先计算有多少颗树
        preListArr = new ArrayList[n + 1];
        nextListArr = new ArrayList[n + 1];

        int[] nextArr = new int[n + 1];
        for (int[] edge: edges) {
            int from = edge[0];
            int to = edge[1];
            if (preListArr[to] == null) {
                preListArr[to] = new ArrayList<>();
            }

            preListArr[to].add(from);

            if (nextListArr[from] == null) {
                nextListArr[from] = new ArrayList<>();
            }

            nextListArr[from].add(to);
            nextArr[from] = to;
        }

        List<Integer> roots = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            if (nextArr[i] == 0) {
                roots.add(i);
            }
        }

        int maxDepth = 0;
        for (int root : roots) {
            // 寻找最长的树的高度
            maxDepth = Math.max(maxDepth, getDepth(root));
        }

        int ans = 0;
        while (maxDepth > 0) {
            List<Data> dataList = new ArrayList<>();
            List<Integer> maxDepthList = new ArrayList<>();
            for (int root : roots) {
                int depth = getDepth(root);
                if (depth == maxDepth) {
                    // 求叶子节点个数，并删除
                    maxDepthList.add(root);
                } else {
                    dataList.add(new Data(root, depth));
                }
            }

            Set<Integer> removeLeafs = new HashSet<>();
            for (Integer root : maxDepthList) {
                List<Integer> leafs = getLeafs(root);
                removeLeafs.addAll(leafs);
            }

            removeLeafs(new ArrayList<>(removeLeafs));

            int leafCount = removeLeafs.size();

            ans += leafCount / k + (leafCount % k != 0 ? 1 : 0);
            int mod = leafCount % k;
            // 可以修mod个其他的入度为0的课
            dataList.sort((o1, o2) -> o2.depth - o1.depth);
            for (Data data : dataList) {
                if (mod == 0) {
                    break;
                }
                int root = data.root;
                List<Integer> leafs = getLeafs(root);
                if (leafs.size() <= mod) {
                    removeLeafs(leafs);
                    mod -= leafs.size();
                } else {
                    for (int leaf : leafs) {
                        List<Integer> nextList = nextListArr[leaf];
                        for (int next : nextList) {
                            preListArr[next].remove((Integer) leaf);
                        }
                        mod--;
                        if (mod == 0) {
                            break;
                        }
                    }
                }
            }

            maxDepth--;
        }

        return ans;
    }

    public static void main(String[] args) {
        System.out.println(new D().minNumberOfSemesters(4, new int[][]{
                {2, 1}, {2, 4}
        }, 2));

//        System.out.println(new D().minNumberOfSemesters(11, new int[][]{
//
//        }, 2));
//
//        System.out.println(new D().minNumberOfSemesters(11, new int[][]{
//                {1, 2}
//        }, 2));
    }

}
