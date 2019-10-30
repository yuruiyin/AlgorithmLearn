package contest.contest151;

import java.util.Arrays;

public class Problem1170 {

    private int getMinLetterCount(String word) {
        char[] arr = word.toCharArray();

        Arrays.sort(arr);

        int count = 1;
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] == arr[i-1]) {
                count++;
            } else {
                return count;
            }
        }

        return count;
    }

    public int[] numSmallerByFrequency(String[] queries, String[] words) {
        int[] ans = new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
            int curAns = 0;
            int qCount = getMinLetterCount(queries[i]);
            for (int j = 0; j < words.length; j++) {
                int count = getMinLetterCount(words[j]);
                if (count > qCount) {
                    curAns++;
                }
            }

            ans[i] = curAns;
        }

        return ans;
    }
    
    public static void main(String[] args) {
        
    }
    
}
//
//        示例 1：
//
//        输入：queries = ["cbd"], words = ["zaaaz"]
//        输出：[1]
//        解释：查询 f("cbd") = 1，而 f("zaaaz") = 3 所以 f("cbd") < f("zaaaz")。
//        示例 2：
//
//        输入：queries = ["bbb","cc"], words = ["a","aa","aaa","aaaa"]
//        输出：[1,2]
//        解释：第一个查询 f("bbb") < f("aaaa")，第二个查询 f("aaa") 和 f("aaaa") 都 > f("cc")。
//
//
//        提示：
//
//        1 <= queries.length <= 2000
//        1 <= words.length <= 2000
//        1 <= queries[i].length, words[i].length <= 10
//        queries[i][j], words[i][j] 都是小写英文字母


