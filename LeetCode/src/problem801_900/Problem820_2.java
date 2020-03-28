package problem801_900;

import java.util.Arrays;
import java.util.Comparator;

/**
 * Problem820_2
 *
 * @author: yry
 * @date: 2020/3/28
 */
public class Problem820_2 {


    public int minimumLengthEncoding(String[] words) {
        // 判断每个元素是否能成为别人的后缀
        int ans = 0;
        int len = words.length;

        for (int i = 0; i < len; i++) {
            words[i] = new StringBuilder(words[i]).reverse().toString();
        }

        Arrays.sort(words);

        for (int i = 1; i < len; i++) {
            if (words[i].startsWith(words[i-1])) {
                continue;
            }

            ans += words[i-1].length() + 1;
        }

        ans += words[len - 1].length() + 1;
        return ans;
    }

}
