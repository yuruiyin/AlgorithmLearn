package contest.contest204;

/**
 * A
 *
 * @author: yry
 * @date: 2020/8/30
 */
public class A {

    public boolean containsPattern(int[] arr, int m, int k) {
        int len = arr.length;

        if (k == 1) {
            return true;
        }

        for (int i = 0; i <= len - m; i++) {
            int count = 1;
            for (int j = i + m; j <= len - m; j += m) {
                boolean isOk = true;
                for (int l = 0; l < m; l++) {
                    if (arr[i + l] != arr[j + l]) {
                        isOk = false;
                        break;
                    }
                }

                if (isOk) {
                    count++;
                    if (count >= k) {
                        return true;
                    }
                } else {
                    break;
                }
            }

            if (count >= k) {
                return true;
            }
        }

        return false;
    }

}
