package problem301_400;

/**
 * Problem392
 *
 * @author: yry
 * @date: 2020/3/20
 */
public class Problem392 {

    public boolean isSubsequence(String s, String t) {
        char[] sArr = s.toCharArray();
        char[] tArr = t.toCharArray();

        int curIndex = 0;
        for (char c : tArr) {
            if (curIndex == sArr.length) {
                return true;
            }

            if (c == sArr[curIndex]) {
                curIndex++;
            }
        }

        return curIndex == sArr.length;
    }

}
