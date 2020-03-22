package problem301_400;

/**
 * Problem389_1
 *
 * @author: yry
 * @date: 2020/3/20
 */
public class Problem389_1 {

    public char findTheDifference(String s, String t) {
        char ans = t.charAt(t.length() - 1);
        for (int i = 0; i < s.length(); i++) {
            ans += t.charAt(i) - s.charAt(i);
        }
        return ans;
    }

}
