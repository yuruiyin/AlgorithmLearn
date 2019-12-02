package problem101_200;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class Problem139 {

    private String s;
    private int len;
    private Set<Integer> wordLenSet;  // 字典里头单词的长度集合
    private Set<String> wordSet;      // 字典里头的单词集合
    private int[] memo;               // 记忆化数组，-1代表false，1代表true

    private boolean backTrack(int start) {
        if (start == len) {
            return true;
        }

        if (memo[start] != 0) {
            return memo[start] == 1;
        }

        for (Integer wordLen: wordLenSet) {
            int end = start + wordLen;
            if (end > len) {
                // 由于单词单独集合是一个TreeSet，从小到大排序，因此一发现长度越界了，后面就无需遍历了
                return false;
            }

            if (!wordSet.contains(s.substring(start, end))) {
                continue;
            }

            if (backTrack(end)) {
                memo[start] = 1;
                return true;
            }
        }

        memo[start] = -1;
        return false;
    }

    public boolean wordBreak(String s, List<String> wordDict) {
        this.s = s;
        this.len = s.length();
        wordLenSet = new TreeSet<>();
        wordSet = new HashSet<>();

        for (String word: wordDict) {
            wordLenSet.add(word.length());
            wordSet.add(word);
        }

        memo = new int[len];
        return backTrack(0);
    }
    
    public static void main(String[] args) {

    }
    
}
