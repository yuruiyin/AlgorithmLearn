package contest.contest198;

/**
 * A
 *
 * @author: yry
 * @date: 2020/7/19
 */
public class D {

    public int closestToTarget(int[] arr, int target) {
        int len = arr.length;
        int ansMin = Integer.MAX_VALUE;
        int size = 1;
        for (int i = 1; i < len; i++) {
            if (arr[i] == arr[i - 1]) {
                continue;
            }

            arr[size++] = arr[i];
        }

        for (int i = 0; i < size; i++) {
            int num = arr[i];
            if (num <= target) {
                ansMin = Math.min(ansMin, target - num);
            } else {
                int cur = 0xffffffff;
                for (int j = i; j < size; j++) {
                    cur &= arr[j];
                    if (cur <= target) {
                        ansMin = Math.min(ansMin, target - cur);
                        break;
                    }

                    ansMin = Math.min(ansMin, cur - target);

                    if (cur == 0) {
                        break;
                    }
                }
            }
        }

        return ansMin;
    }

}
