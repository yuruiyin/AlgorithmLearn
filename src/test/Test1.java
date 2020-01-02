package test;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

// 并查集
public class Test1 {

    public List<List<Character>> solve(char[][] grid) {
        List<Character>[] treeArr = new ArrayList[26];
        for (char[] row : grid) {
            char c1 = row[0];
            char c2 = row[1];
            List<Character> tree1 = treeArr[c1 - 'A'];
            List<Character> tree2 = treeArr[c2 - 'A'];
            if (tree1 != null && tree2 != null) {
                if (tree1 == tree2) {
                    continue;
                }

                tree1.addAll(tree2);
                for (Character c : tree2) {
                    treeArr[c - 'A'] = tree1;
                }
            } else if (tree1 != null) {
                tree1.add(c2);
                treeArr[c2 - 'A'] = tree1;
            } else if (tree2 != null) {
                tree2.add(c1);
                treeArr[c1 - 'A'] = tree2;
            } else {
                List<Character> tree = new ArrayList<>();
                tree.add(c1);
                tree.add(c2);
                treeArr[c1 - 'A'] = tree;
                treeArr[c2 - 'A'] = tree;
            }
        }

        Set<List<Character>> set = new HashSet<>();
        for (int i = 0; i < 26; i++) {
            set.add(treeArr[i]);
        }

        return new ArrayList<>(set);
    }

    public static void main(String[] args) {

    }

}
