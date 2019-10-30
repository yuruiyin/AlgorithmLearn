package problem1101_1200;

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

    /**
     * 寻找第一个比它大的索引
     * @return
     */
    private int binarySearch(int[] countArr, int targetCount) {
        int low = 0;
        int high = countArr.length - 1;

        while (low <= high) {
            int mid = (low + high) >> 1;
            int midCount = countArr[mid];
            if (targetCount < midCount) {
                if (mid == 0 || targetCount >= countArr[mid-1]) {
                    return mid;
                }

                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        return low;
    }

    public int[] numSmallerByFrequency(String[] queries, String[] words) {
        int[] ans = new int[queries.length];

        // 先统计words中所有单词的最小字母出现次数
        int[] wordCountArr = new int[words.length];
        for (int j = 0; j < words.length; j++) {
            wordCountArr[j] = getMinLetterCount(words[j]);
        }
        Arrays.sort(wordCountArr);

        int[] tmpCountArr = new int[11];
        for (int i = 1; i <= 10; i++) {
            tmpCountArr[i] = wordCountArr.length - binarySearch(wordCountArr, i);
        }

        for (int i = 0; i < queries.length; i++) {
            int qCount = getMinLetterCount(queries[i]);
            ans[i] = tmpCountArr[qCount];
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


