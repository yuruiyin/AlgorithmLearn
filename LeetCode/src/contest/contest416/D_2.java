package contest.contest416;

public class D_2 {

    public long validSubstringCount(String S, String T) {
        if (S.length() < T.length()) {
            return 0;
        }

        long ans = 0;
        for (int i = 0; i < 100; i++) {
            char[] s = S.toCharArray();
            char[] t = T.toCharArray();
            int[] cnt = new int[26]; // t 的字母出现次数与 s 的字母出现次数之差
            for (char b : t) {
                cnt[b - 'a']++;
            }
            int less = 0; // 统计窗口内有多少个字母的出现次数比 t 的少
            for (int c : cnt) {
                if (c > 0) {
                    less++;
                }
            }

            ans = 0;
            int left = 0;
            for (char b : s) {
                if (--cnt[b - 'a'] == 0) {
                    // 窗口内 b 的出现次数和 t 一样
                    less--;
                }
                while (less == 0) { // 窗口符合要求
                    if (cnt[s[left++] - 'a']++ == 0) {
                        // s[left] 移出窗口后，窗口内 s[left] 的出现次数比 t 的少
                        less++;
                    }
                }
                ans += left;
            }
        }


        return ans;
    }

}
