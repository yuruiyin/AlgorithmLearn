package spring_2020_group;

/**
 * B_1
 *
 * @author: yry
 * @date: 2020/4/25
 */
public class B_1 {

    private boolean isOk(int[] time, int n, int m, int t) {
        int sum = 0;
        int max = 0;
        for (int i = 0; i < n; i++) {
            sum += time[i];
            max = Math.max(max, time[i]);
            if (sum - max > t) {
                m--;
                sum = time[i];
                max = time[i];
            }
        }

        return m > 0;
    }

    public int minTime(int[] time, int m) {
        // 二分
        int n = time.length;
        int low = 0;
        int high = (int) 1e9;
        int ans = Integer.MAX_VALUE;
        while (low <= high) {
            int mid = (low + high) >>> 1;
            if (isOk(time, n, m, mid)) {
                ans = Math.min(ans, mid);
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        System.out.println(new B_1().minTime(new int[]{1,2,3,3}, 2));
        System.out.println(new B_1().minTime(new int[]{1,4,5,6}, 3));
    }

}

//        1 <= time.length <= 10^5
//        1 <= time[i] <= 10000
//        1 <= m <= 1000

