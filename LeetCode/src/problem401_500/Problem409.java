package problem401_500;

/**
 * Problem409
 *
 * @author: yry
 * @date: 2020/3/19
 */
public class Problem409 {

    public int longestPalindrome(String s) {
        int[] countArr = new int['z' - 'A' + 1];
        for (char c : s.toCharArray()) {
            countArr[c - 'A']++;
        }

        int ans = 0;
        boolean hasOddCount = false;
        for (int count : countArr) {
            if (count > 0) {
                ans += (count >>> 1) << 1;
                if ((count & 1) == 1) {
                    hasOddCount = true;
                }
            }
        }

        if (hasOddCount) {
            ans++;
        }

        return ans;
    }

}
