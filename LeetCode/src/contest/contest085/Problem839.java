package contest.contest085;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Problem839 {

    private boolean isMatch(String str1, String str2) {
        int len = str1.length();
        int diffCount = 0;
        for (int i = 0; i < len; i++) {
            if (str1.charAt(i) != str2.charAt(i)) {
                diffCount++;
                if (diffCount > 2) {
                    return false;
                }
            }
        }
        return true;
    }

    public int numSimilarGroups(String[] arr) {
        int len = arr.length;
        List<Integer>[] treeArr = new ArrayList[len];
        for (int i = 0; i < len; i++) {
            for (int j = i+1; j < len; j++) {
                boolean isMatch = isMatch(arr[i], arr[j]);
                List<Integer> tree1 = treeArr[i];
                List<Integer> tree2 = treeArr[j];
                if (tree1 != null && tree2 != null) {
                    if (!isMatch) {
                       continue;
                    }

                    if (tree1 == tree2) {
                        continue;
                    }

                    // merge
                    tree1.addAll(tree2);
                    for (Integer num : tree2) {
                        treeArr[num] = tree1;
                    }
                } else if (tree1 != null) {
                    if (!isMatch) {
                        List<Integer> list = new ArrayList<>();
                        list.add(j);
                        treeArr[j] = list;
                    } else {
                        tree1.add(j);
                        treeArr[j] = tree1;
                    }
                } else if (tree2 != null) {
                    if (!isMatch) {
                        List<Integer> list = new ArrayList<>();
                        list.add(i);
                        treeArr[i] = list;
                    } else {
                        tree2.add(i);
                        treeArr[i] = tree2;
                    }
                } else {
                    if (!isMatch) {
                        List<Integer> list1 = new ArrayList<>();
                        list1.add(i);
                        treeArr[i] = list1;
                        List<Integer> list2 = new ArrayList<>();
                        list2.add(j);
                        treeArr[j] = list2;
                    } else {
                        List<Integer> list = new ArrayList<>();
                        list.add(i);
                        list.add(j);
                        treeArr[i] = list;
                        treeArr[j] = list;
                    }
                }
            }
        }

        Set<List<Integer>> set = new HashSet<>();
        for (int i = 0; i < len; i++) {
            set.add(treeArr[i]);
        }

        return set.size();
    }

}
