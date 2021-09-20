package contest.contest254;

/**
 * A
 *
 * @author: yry
 * @date: 2021/8/15
 */
public class A {

    public int numOfStrings(String[] patterns, String word) {
        int ans = 0;
        for (String str : patterns) {
            if (word.contains(str)) {
                ans++;
            }
        }
        return ans;
    }

}
