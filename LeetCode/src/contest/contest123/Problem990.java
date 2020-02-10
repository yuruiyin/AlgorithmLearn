package contest.contest123;

import java.util.ArrayList;
import java.util.List;

public class Problem990 {

    public boolean equationsPossible(String[] equations) {
        List<Integer>[] treeArr = new ArrayList[26];

        for (String equation : equations) {
            int a = equation.charAt(0) - 'a';
            int b = equation.charAt(3) - 'a';
            String operator = equation.substring(1, 3);

            if (!operator.equals("==")) {
                continue;
            }

            List<Integer> aTree = treeArr[a];
            List<Integer> bTree = treeArr[b];

            if (aTree != null && bTree != null) {
                if (aTree == bTree) {
                    continue;
                }

                aTree.addAll(bTree);
                for (Integer num : bTree) {
                    treeArr[num] = aTree;
                }
            } else if (aTree != null) {
                aTree.add(b);
                treeArr[b] = aTree;
            } else if (bTree != null) {
                bTree.add(a);
                treeArr[a] = bTree;
            } else {
                List<Integer> tree = new ArrayList<>();
                tree.add(a);
                tree.add(b);
                treeArr[a] = tree;
                treeArr[b] = tree;
            }
        }

        for (String equation : equations) {
            int a = equation.charAt(0) - 'a';
            int b = equation.charAt(3) - 'a';
            String operator = equation.substring(1, 3);

            if (operator.equals("==")) {
                continue;
            }

            if (a == b) {
                return false;
            }

            if (treeArr[a] != null && treeArr[a] == treeArr[b]) {
                return false;
            }
        }

        return true;
    }

}
