package problem1101_1200;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Problem1177 {

    public List<Boolean> canMakePaliQueries(String s, int[][] queries) {
        List<Boolean> ansList = new ArrayList<>();

        Map<Long, Integer> memo = new HashMap<>();
        int len = s.length();

        int[][] gCount = new int[len][26];
        gCount[0][s.charAt(0) - 'a']++;

        for (int i = 1; i < s.length(); i++) {
            for (int j = 0; j < 26; j++) {
                gCount[i][j] = gCount[i-1][j];
            }

            gCount[i][s.charAt(i) - 'a']++;
        }

        for (int i = 0; i < queries.length; i++) {
            int left = queries[i][0];
            int right = queries[i][1];
            int k = queries[i][2];

            if (k >= (right - left + 1) / 2 || k >= 26) {
                ansList.add(true);
                continue;
            }

            long key = left * 100000L + right;

            if (memo.containsKey(key)) {
                if (k >= memo.get(key)) {
                    ansList.add(true);
                } else {
                    ansList.add(false);
                }
                continue;
            }

            // 可重新排序
            int ans = 0;
            int[] count = new int[26];
            if (left == 0) {
                count = gCount[right];
            } else {
                for (int j = 0; j < 26; j++) {
                    count[j] = gCount[right][j] - gCount[left - 1][j];
                }
            }

            int oddCount = 0; //  奇数个字符个数
            for (int j = 0; j < 26; j++) {
                if (count[j] % 2 == 1) {
                    oddCount++;
                }
            }

            ans += (oddCount / 2);
            boolean res = k >= ans;
            memo.put(key, ans);
            ansList.add(res);
        }

        return ansList;
    }
    
    public static void main(String[] args) {
//        List<Boolean> ansList = new Problem03().canMakePaliQueries("abcda", new int[][]{
//                {3,3,0},{1,2,0},{0,3,1},{0,3,2},{0,4,1}
//        });
//
//        for (Boolean value : ansList) {
//            System.out.print(value + ",");
//        }

        List<Boolean> ansList = new Problem1177().canMakePaliQueries("hunu", new int[][]{
                {1,1,1},{2,3,0},{3,3,1},{0,3,2},{1,3,3},{2,3,1},{3,3,1},{0,3,0},{1,1,1},{2,3,0},{3,3,1},{0,3,1},{1,1,1}
        });

        for (Boolean value : ansList) {
            System.out.print(value + ",");
        }
    }
    
}

//"hunu"
//        [[1,1,1],[2,3,0],[3,3,1],[0,3,2],[1,3,3],[2,3,1],[3,3,1],[0,3,0],[1,1,1],[2,3,0],[3,3,1],[0,3,1],[1,1,1]]
//
//        [true,false,true,true,true,true,true,false,true,false,true,true,true]

//示例：
//
//        输入：s = "abcda", queries = [[3,3,0],[1,2,0],[0,3,1],[0,3,2],[0,4,1]]
//        输出：[true,false,false,true,true]
//        解释：
//        queries[0] : 子串 = "d"，回文。
//        queries[1] : 子串 = "bc"，不是回文。
//        queries[2] : 子串 = "abcd"，只替换 1 个字符是变不成回文串的。
//        queries[3] : 子串 = "abcd"，可以变成回文的 "abba"。 也可以变成 "baab"，先重新排序变成 "bacd"，然后把 "cd" 替换为 "ab"。
//        queries[4] : 子串 = "abcda"，可以变成回文的 "abcba"。
//
//
//        提示：
//
//        1 <= s.length, queries.length <= 10^5
//        0 <= queries[i][0] <= queries[i][1] < s.length
//        0 <= queries[i][2] <= s.length
//        s 中只有小写英文字母
