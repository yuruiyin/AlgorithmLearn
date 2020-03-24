package lcci;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * Lcci1715
 *
 * @author: yry
 * @date: 2020/3/23
 */
public class Lcci1715 {

    private Set<String> set;
    private Boolean[] memo;

    private boolean dp(int from, String word) {
        int len = word.length();
        if (from == len) {
            return true;
        }

        if (memo[from] != null) {
            return memo[from];
        }

        for (int i = from; i < len; i++) {
            if (set.contains(word.substring(from, i + 1)) && dp(i + 1, word)) {
                memo[from] = true;
                return true;
            }
        }

        memo[from] = false;
        return false;
    }

    public String longestWord(String[] words) {
        Arrays.sort(words, (o1, o2) -> o1.length() == o2.length() ? o1.compareTo(o2) : o2.length() - o1.length());
        set = new HashSet<>();
        set.addAll(Arrays.asList(words));

        for (String word : words) {
            memo = new Boolean[word.length()];
            set.remove(word);
            if (dp(0, word)) {
                return word;
            }
            set.add(word);
        }

        return "";
    }

    public static void main(String[] args) {
        System.out.println(new Lcci1715().longestWord(new String[]{
                "qlmql","qlmqlmqqlqmqqlq","mqqlqmqqlqmqqlq","mqqlq","mqqlqlmlsmqq","qmlmmmmsm","lmlsmqq","slmsqq","mslqssl","mqqlqmqqlq"
        }));
    }

}
