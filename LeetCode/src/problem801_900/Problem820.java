package problem801_900;

/**
 * Problem820
 *
 * @author: yry
 * @date: 2020/3/28
 */
public class Problem820 {

    public int minimumLengthEncoding(String[] words) {
        // 判断每个元素是否能成为别人的后缀
        int ans = 0;
        int len = words.length;
        boolean[] visited = new boolean[len];

        for (int i = 0; i < len; i++) {
            if (visited[i]) {
                continue;
            }

            boolean isOtherSuffix = false;
            for (int j = i + 1; j < len; j++) {
                if (visited[j]) {
                    continue;
                }

                if (words[i].endsWith(words[j])) {
                    visited[j] = true;
                }

                if (!words[i].endsWith(words[j]) && words[j].endsWith(words[i])) {
                    isOtherSuffix = true;
                }
            }

            if (!isOtherSuffix) {
                // 当前words[i]不是别人的后缀
                ans += words[i].length() + 1;
            }
        }

        return ans;
    }

}
