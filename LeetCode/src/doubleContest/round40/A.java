package doubleContest.round40;

/**
 * A
 *
 * @author: yry
 * @date: 2020/11/28
 */
public class A {

    public int maxRepeating(String sequence, String word) {
        if (!sequence.contains(word)) {
            return 0;
        }

        int len1 = sequence.length();
        int wordLen = word.length();

        int ans = 0;
        for (int k = 1; wordLen * k <= len1 ;k++) {
            String str = word.repeat(k);
            if (!sequence.contains(str)) {
                return k - 1;
            }
            ans = k;
        }

        return ans;
    }

}
