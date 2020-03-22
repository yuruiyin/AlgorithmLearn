package problem301_400;

/**
 * Problem389
 *
 * @author: yry
 * @date: 2020/3/20
 */
public class Problem389 {

    public char findTheDifference(String s, String t) {
        int[] sCountArr = new int[26];
        for (char c : s.toCharArray()) {
            sCountArr[c - 'a']++;
        }

        int[] tCountArr = new int[26];
        for (char c : t.toCharArray()) {
            tCountArr[c - 'a']++;
        }

        for (int i = 0; i < 26; i++) {
            if (tCountArr[i] > sCountArr[i]) {
                return (char) (i + 'a');
            }
        }

        return 'a';
    }

}
