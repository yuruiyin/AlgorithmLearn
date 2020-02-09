package contest.contest122;

import common.TreeNode;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Problem987 {

    class Data {
        int x;
        int y;
        int val;
        Data(int x, int y, int val) {
            this.x = x;
            this.y = y;
            this.val = val;
        }
    }

    private List<Data> list;

    private void dfs(TreeNode root, int x, int y) {
        if (root == null) {
            return;
        }

        list.add(new Data(x, y, root.val));
        dfs(root.left, x - 1, y - 1);
        dfs(root.right, x + 1, y - 1);
    }

    public List<List<Integer>> verticalTraversal(TreeNode root) {
        list = new ArrayList<>();
        dfs(root, 0, 0);
        list.sort(new Comparator<Data>() {
            @Override
            public int compare(Data o1, Data o2) {
                if (o1.x != o2.x) {
                    return o1.x - o2.x;
                }

                if (o1.y != o2.y) {
                    return o2.y - o1.y;
                }

                return o1.val - o2.val;
            }
        });

        int size = list.size();
        List<List<Integer>> ansList = new ArrayList<>();
        List<Integer> preList = new ArrayList<>();
        preList.add(list.get(0).val);
        ansList.add(preList);
        for (int i = 1; i < size; i++) {
            Data data = list.get(i);
            Data preData = list.get(i-1);
            if (data.x == preData.x) {
                preList.add(data.val);
            } else {
                List<Integer> curList = new ArrayList<>();
                curList.add(data.val);
                ansList.add(curList);
                preList = curList;
            }
        }

        return ansList;

    }

}
