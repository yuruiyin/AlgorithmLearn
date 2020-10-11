package contest.contest202;

/**
 * A
 *
 * @author: yry
 * @date: 2020/8/16
 */
public class A {

    public boolean threeConsecutiveOdds(int[] arr) {
        int len = arr.length;
        if (len < 3) {
            return false;
        }

        for (int i = 0; i < len - 2; i++) {
            if (arr[i] % 2 == 1 && arr[i + 1] % 2 == 1 && arr[i + 2] % 2 == 1) {
                return true;
            }
        }

        return false;
    }

}
