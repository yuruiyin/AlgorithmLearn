package problem1001_1100;

import java.util.ArrayList;
import java.util.List;

public class Problem1061 {

    public String smallestEquivalentString(String str1, String str2, String s) {
        List<Integer>[] treeList = new ArrayList[26];
        char[] arr1 = str1.toCharArray();
        char[] arr2 = str2.toCharArray();
        int len = arr1.length;

        for (int i = 0; i < len; i++) {
            char c1 = arr1[i];
            char c2 = arr2[i];
            int index1 = c1 - 'a';
            int index2 = c2 - 'a';
            List<Integer> tree1 = treeList[index1];
            List<Integer> tree2 = treeList[index2];
            if (tree1 != null && tree2 != null) {
                if (tree1 == tree2) {
                    continue;
                }

                // 合并
                int size1 = tree1.size();
                int size2 = tree2.size();

                if (size1 > size2) {
                    tree1.addAll(tree2);
                    for (Integer num : tree2) {
                        treeList[num] = tree1;
                    }
                } else {
                    tree2.addAll(tree1);
                    for (Integer num : tree1) {
                        treeList[num] = tree2;
                    }
                }
            } else if (tree1 != null) {
                tree1.add(index2);
                treeList[index2] = tree1;
            } else if (tree2 != null) {
                tree2.add(index1);
                treeList[index1] = tree2;
            } else {
                List<Integer> tree = new ArrayList<>();
                if (index1 == index2) {
                    tree.add(index1);
                } else {
                    tree.add(index1);
                    tree.add(index2);
                }
                treeList[index1] = tree;
                treeList[index2] = tree;
            }
        }

        StringBuilder ansSb = new StringBuilder();
        for (char c : s.toCharArray()) {
            List<Integer> tree = treeList[c - 'a'];
            if (tree == null) {
                ansSb.append(c);
            } else {
                int min = Integer.MAX_VALUE;
                for (Integer num : tree) {
                    if (num < min) {
                        min = num;
                    }
                }
                ansSb.append((char)(min + 'a'));
            }
        }

        return ansSb.toString();
    }

}

//  给出长度相同的两个字符串：A 和 B，其中 A[i] 和 B[i] 是一组等价字符。举个例子，如果 A = "abc" 且 B = "cde"，那么就有 'a' == 'c', 'b' == 'd', 'c' == 'e'。
//
//        等价字符遵循任何等价关系的一般规则：
//
//        自反性：'a' == 'a'
//        对称性：'a' == 'b' 则必定有 'b' == 'a'
//        传递性：'a' == 'b' 且 'b' == 'c' 就表明 'a' == 'c'
//        例如，A 和 B 的等价信息和之前的例子一样，那么 S = "eed", "acd" 或 "aab"，这三个字符串都是等价的，而 "aab" 是 S 的按字典序最小的等价字符串
//
//        利用 A 和 B 的等价信息，找出并返回 S 的按字典序排列最小的等价字符串。
//
//         
//
//        示例 1：
//
//        输入：A = "parker", B = "morris", S = "parser"
//        输出："makkek"
//        解释：根据 A 和 B 中的等价信息，我们可以将这些字符分为 [m,p], [a,o], [k,r,s], [e,i] 共 4 组。每组中的字符都是等价的，
//        并按字典序排列。所以答案是 "makkek"。
//        示例 2：
//
//        输入：A = "hello", B = "world", S = "hold"
//        输出："hdld"
//        解释：根据 A 和 B 中的等价信息，我们可以将这些字符分为 [h,w], [d,e,o], [l,r] 共 3 组。所以只有 S 中的第二个字符 'o' 变成 'd'，
//        最后答案为 "hdld"。
//        示例 3：
//
//        输入：A = "leetcode", B = "programs", S = "sourcecode"
//        输出："aauaaaaada"
//        解释：我们可以把 A 和 B 中的等价字符分为 [a,o,e,r,s,c], [l,p], [g,t] 和 [d,m] 共 4 组，
//        因此 S 中除了 'u' 和 'd' 之外的所有字母都转化成了 'a'，最后答案为 "aauaaaaada"。
//         
//
//        提示：
//
//        字符串 A，B 和 S 仅有从 'a' 到 'z' 的小写英文字母组成。
//        字符串 A，B 和 S 的长度在 1 到 1000 之间。
//        字符串 A 和 B 长度相同。
