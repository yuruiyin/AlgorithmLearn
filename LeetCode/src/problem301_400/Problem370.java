package problem301_400;

/**
 * Problem370
 *
 * @author: yry
 * @date: 2020/4/4
 */
public class Problem370 {

    public int[] getModifiedArray(int length, int[][] updates) {
        int[] arr = new int[length];
        for (int[] update : updates) {
            int startIdx = update[0];
            int endIdx = update[1];
            int inc = update[2];
            for (int i = startIdx; i <= endIdx; i++) {
                arr[i] += inc;
            }
        }

        return arr;
    }

}
