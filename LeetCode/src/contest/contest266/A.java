package contest.contest266;

import java.util.HashSet;
import java.util.Set;

/**
 * A
 *
 * @author: yry
 * @date: 2021/11/7
 */
public class A {

    private boolean isOk(char c) {
        if (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u') {
            return true;
        }
        return false;
    }

    public int countVowelSubstrings(String word) {
        int ans = 0;
        char[] arr = word.toCharArray();
        int len = arr.length;
        for (int i = 0; i < len; i++) {
            if (!isOk(arr[i])) {
                continue;
            }
            Set<Character> set = new HashSet<>();
            set.add(arr[i]);
            for (int j = i + 1; j < len; j++) {
                if (!isOk(arr[j])) {
                    break;
                }
                set.add(arr[j]);
                if (set.size() == 5) {
                    ans++;
                }
            }
        }
        return ans;
    }


}
