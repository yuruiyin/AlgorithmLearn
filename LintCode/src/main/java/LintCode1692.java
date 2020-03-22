import java.util.Arrays;

/**
 * LintCode1692
 *
 * @author: yry
 * @date: 2020/3/20
 */
public class LintCode1692 {

    private int findFirstBigger(int[] atk1, int from, int target) {
        int low = from;
        int high = atk1.length - 1;
        while (low <= high) {
            int mid = (low + high) >>> 1;
            int midVal = atk1[mid];
            if (midVal > target) {
                if (mid == from || atk1[mid - 1] <= target) {
                    return mid;
                }

                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        return -1;
    }

    public int getAns(int[] atk1, int[] atk2) {
        Arrays.sort(atk2); // 怪物战斗力从小到大排序
        Arrays.sort(atk1);

        int from = 0;
        int ans = 0;
        for (int i = 0; i < atk2.length; i++) {
            int firstBigger = findFirstBigger(atk1, from, atk2[i]);
            if (firstBigger == -1) {
                break;
            }

            ans++;
            from = firstBigger + 1;
        }

        return ans;
    }

}
