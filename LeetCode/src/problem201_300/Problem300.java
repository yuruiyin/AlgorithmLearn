package problem201_300;

public class Problem300 {

    private int findFirstBiggerByBinarySearch(int[] tail, int n, int target) {
        int low = 0;
        int high = n - 1;
        // 从tail数组中找到第一个比nums[i]大的元素，然后更新tail数组，若找不到，则说明nums[i] 比tail数组所有元素都大，则totalMax可以加1
        while (low <= high) {
            int mid = (low + high) >> 1;
            if (target == tail[mid]) {
                return -1;
            } else if (target < tail[mid]) {
                if(mid == 0 || tail[mid - 1] < target) {
                    return mid;
                }
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        return low;
    }

    public int lengthOfLISBinarySearch(int[] nums) {
        int n = nums.length;
        if (n == 0) {
            return 0;
        }

        int totalMax = 1;
        int[] tail = new int[n + 1];
        tail[0] = nums[0];

        for (int i = 1; i < n; i++) {
           int index = findFirstBiggerByBinarySearch(tail, totalMax, nums[i]);

           if (index == -1) {
               // nums[i]与tail数组中某个值相等, 不理睬
               continue;
           }

           if (index == totalMax) {
               // 说明num[i]比tail数组所有都大
               totalMax++;
           }

           tail[index] = nums[i];
        }

        return totalMax;
    }

    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        if (n == 0) {
            return 0;
        }

        int totalMax = 1;
        int[] max = new int[n];
        max[0] = 1;

        for (int i = 1; i < n; i++) {
            int tmpMax = 0;
            for (int j = i - 1; j >= 0; j--) {
                if (nums[i] > nums[j] && max[j] > tmpMax) {
                    tmpMax = max[j];
                }
            }

            max[i] = tmpMax + 1;

            if (max[i] > totalMax) {
                totalMax = max[i];
            }
        }

        return totalMax;
    }

    public static void main(String[] args) {
        System.out.println(new Problem300().lengthOfLIS(new int[]{10,9,2,5,3,7,101,18}));
        System.out.println(new Problem300().lengthOfLISBinarySearch(new int[]{10,9,2,5,3,7,101,18}));
    }

}
