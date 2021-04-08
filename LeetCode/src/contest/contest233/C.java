package contest.contest233;

/**
 * A
 *
 * @author: yry
 * @date: 2021/3/21
 */
public class C {

    public int maxValue(int n, int index, int maxSum) {
        long l = 1;
        long r = maxSum;
        long leftCount = index + 1;
        long rightCount = n - index;
        long ans = 1;
        while (l <= r) {
            long mid = (l + r) >>> 1;
            long leftSum = 0;
            if (mid >= leftCount) {
                leftSum = (mid + (mid - leftCount + 1)) * leftCount / 2;
            } else {
                leftSum = (mid + 1) * mid / 2 + (leftCount - mid);
            }

            long rightSum = 0;
            if (mid >= rightCount) {
                rightSum = (mid + (mid - rightCount + 1)) * rightCount / 2;
            } else {
                rightSum = (mid + 1) * mid / 2 + (rightCount - mid);
            }

            if (leftSum + rightSum - mid <= maxSum) {
                ans = mid;
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }

        return (int) ans;
    }
    
    public static void main(String[] args) {
        System.out.println(new C().maxValue(3, 0, 815094800));
    }

}
