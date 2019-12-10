package problem1001_1100;

import java.util.ArrayList;
import java.util.List;

public class Problem1062 {

    private char[] arr;
    private int len;

    private int backTrack(List<Integer> indexList) {
        List<Integer>[] nextIndexListArr = new ArrayList[26];

        for (Integer index: indexList) {
            if (index == len) {
                continue;
            }
            int cNum = arr[index] - 'a';
            if (nextIndexListArr[cNum] == null) {
                nextIndexListArr[cNum] = new ArrayList<>();
            }

            nextIndexListArr[cNum].add(index+1);
        }

        int max = 0;
        boolean hasDuplicated = false;
        for (int i = 0; i < 26; i++) {
            if (nextIndexListArr[i] != null && nextIndexListArr[i].size() > 1) {
                hasDuplicated = true;
                int nextMaxLen = backTrack(nextIndexListArr[i]);
                if (nextMaxLen > max) {
                    max = nextMaxLen;
                }
            }
        }

        if (!hasDuplicated) {
            return 0;
        }

        return max + 1;
    }

    public int longestRepeatingSubstring(String str) {
        arr = str.toCharArray();
        len = arr.length;
        List<Integer> indexList = new ArrayList<>();
        for (int i = 0; i < len; i++) {
            indexList.add(i);
        }
        return backTrack(indexList);
    }

}

//  给定字符串 S，找出最长重复子串的长度。如果不存在重复子串就返回 0。
//
//        示例 1：
//
//        输入："abcd"
//        输出：0
//        解释：没有重复子串。
//        示例 2：
//
//        输入："abbaba"
//        输出：2
//        解释：最长的重复子串为 "ab" 和 "ba"，每个出现 2 次。
//        示例 3：
//
//        输入："aabcaabdaab"
//        输出：3
//        解释：最长的重复子串为 "aab"，出现 3 次。
//        示例 4：
//
//        输入："aaaaa"
//        输出：4
//        解释：最长的重复子串为 "aaaa"，出现 2 次。
//         
//
//        提示：
//
//        字符串 S 仅包含从 'a' 到 'z' 的小写英文字母。
//        1 <= S.length <= 1500
