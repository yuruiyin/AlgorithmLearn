package problem301_400;

/**
 * Problem370_1
 *
 * @author: yry
 * @date: 2020/4/4
 */
public class Problem370_1 {

    // 差分
    public int[] getModifiedArray(int length, int[][] updates) {
        int[] diff = new int[length];
        for (int[] update : updates) {
            int startIdx = update[0];
            int endIdx = update[1];
            int inc = update[2];
            diff[startIdx] += inc;
            if (endIdx < length - 1) {
                diff[endIdx + 1] -= inc;
            }
        }

        for (int i = 1; i < length; i++) {
            diff[i] += diff[i-1];
        }

        return diff;
    }

}
