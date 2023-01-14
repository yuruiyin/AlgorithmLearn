package contest.contest319;

import common.TreeNode;

import java.util.*;

public class C {

    private List<Integer>[] levelListArr;

    private void bfs(TreeNode root) {
        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        levelListArr[0].add(root.val);
        int level = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            level++;
            for (int i = 0; i < size; i++) {
                TreeNode cur = queue.poll();
                if (cur.left != null) {
                    levelListArr[level].add(cur.left.val);
                    queue.add(cur.left);
                }
                if (cur.right != null) {
                    levelListArr[level].add(cur.right.val);
                    queue.add(cur.right);
                }
            }
        }
    }

    private void swap(List<Integer> list, int i, int j) {
        int tmp = list.get(i);
        list.set(i, list.get(j));
        list.set(j, tmp);
    }

    public int minimumOperations(TreeNode root) {
        levelListArr = new ArrayList[100001];
        Arrays.setAll(levelListArr, value -> new ArrayList<>());
        bfs(root);
        int ans = 0;
        for (int i = 0; i < 100000; i++) {
            List<Integer> levelList = levelListArr[i];
            if (levelList.isEmpty()) {
                continue;
            }

            int size = levelList.size();
            Map<Integer, Integer> indexMap = new HashMap<>();
            for (int j = 0; j < size; j++) {
                indexMap.put(levelList.get(j), j);
            }

            // 双指针
            List<Integer> sortedList = new ArrayList<>(levelList);
            Collections.sort(sortedList);
            for (int j = 0; j < size; j++) {
                int sortedNum = sortedList.get(j);
                int originNum = levelList.get(j);
                if (sortedNum != originNum) {
                    int oldIdx = indexMap.get(sortedNum);
                    indexMap.put(originNum, oldIdx);
                    swap(levelList, j, oldIdx);
                    indexMap.put(sortedNum, j);
                    ans++;
                }
            }

        }
        return ans;
    }

}
