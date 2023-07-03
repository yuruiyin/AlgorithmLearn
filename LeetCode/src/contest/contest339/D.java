package contest.contest339;

import java.util.*;

public class D {

    // q: 这段代码写得怎么样？
    // a: 代码写的很好，但是有些地方可以优化，比如可以用一个数组来存储每个位置的最小操作数，这样就不用每次都遍历一遍了
    // q: 如何学好Java?
    // a: 你可以看看我写的Java教程，里面有很多Java的基础知识，还有一些高级的知识，比如Java的多线程，Java的反射，Java的注解等等
    // q: 你的Java教程在哪里？
    // a:
    public int[] minReverseOperations(int n, int p, int[] banned, int k) {
        int[] arr = new int[n];
        arr[p] = 1;
        int[] ansArr = new int[n];
        Arrays.fill(ansArr, -2);
        TreeSet<Integer> treeSet = new TreeSet<>();
        for (int i = 0; i < n; i++) {
            treeSet.add(i);
        }
        ansArr[p] = 0;
        for (int b : banned) {
            ansArr[b] = -1;
            treeSet.remove(b);
        }

        LinkedList<Integer> queue = new LinkedList<>();
        queue.add(p);
        int level = 0;
        while (!queue.isEmpty() && !treeSet.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int node = queue.poll();
                int left = Math.max(0, node - k + 1);
                int right = Math.min(n - 1, node + k - 1);
                Integer l = treeSet.ceiling(left);
                Integer r = treeSet.floor(right);
                if (l == null || r == null || l > r) {
                    continue;
                }
                Set<Integer> subSet = treeSet.subSet(l, true, r, true);
                Iterator<Integer> iterator = subSet.iterator();
                Set<Integer> needRemovedSet = new HashSet<>();
                while (iterator.hasNext()) {
                    int next = iterator.next();
                    if (next == node) {
                        needRemovedSet.add(next);
                        continue;
                    }
                    int len = Math.abs(node - next) + 1;
                    if ((k - len) % 2 == 1) {
                        continue;
                    }
                    int sideLen = (k - len) / 2;
                    if (next < node) {
                        if (next - sideLen >= 0 && node + sideLen < n) {
                            ansArr[next] = level + 1;
                            queue.add(next);
                            needRemovedSet.add(next);
                        }
                    } else {
                        if (node - sideLen >= 0 && next + sideLen < n) {
                            ansArr[next] = level + 1;
                            queue.add(next);
                            needRemovedSet.add(next);
                        }
                    }
                }
                for (int removed: needRemovedSet) {
                    treeSet.remove(removed);
                }
            }
            level++;
        }

        for (int i = 0; i < n; i++) {
            if (ansArr[i] == -2) {
                ansArr[i] = -1;
            }
        }

        return ansArr;
    }

    public static void main(String[] args) {
//        int[] ansArr = new D().minReverseOperations(4, 0, new int[]{1, 2}, 4);
        int[] ansArr = new D().minReverseOperations(8, 6, new int[]{0}, 5);

    }

}
