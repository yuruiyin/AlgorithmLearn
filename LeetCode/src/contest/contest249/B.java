package contest.contest249;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * A
 *
 * @author: yry
 * @date: 2021/7/11
 */
public class B {

    public int countPalindromicSubsequence(String s) {
        char[] arr = s.toCharArray();
        int len = arr.length;
        Set<String> list = new HashSet<>();
        for (int i = 0; i < 26; i++) {
            for (int j = 0; j < 26; j++) {
                char[] tmp = new char[3];
                tmp[0] = (char) (i + 'a');
                tmp[1] = (char) (j + 'a');
                tmp[2] = (char) (i + 'a');
                list.add(new String(tmp));
            }
        }

        int ans = 0;
        for (String str : list) {
            char[] tmpArr = str.toCharArray();
            int curIdx = 0;
            for (int i = 0; i < len && curIdx < 3; i++) {
                if (arr[i] == tmpArr[curIdx]) {
                    curIdx++;
                }
            }
            if (curIdx == 3) {
                ans++;
            }
        }

        return ans;
    }

}
