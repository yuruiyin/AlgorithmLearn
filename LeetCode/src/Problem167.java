public class Problem167 {

    /**
     * 通过二分查找值，找到则返回那个值的下标，否则返回最后一个比他小的
     */
    private int binarySearchLastSmaller(int[] numbers, int target, int low ,int high) {
        int len = numbers.length;
        while (low <= high) {
            int mid = (low + high) >>> 1;

            if (target == numbers[mid]) {
                return mid;
            } else if (target < numbers[mid]) {
                high = mid - 1;
            } else {
                if (mid == len - 1 || numbers[mid + 1] > target) {
                    return mid;
                }
                low = mid + 1;
            }
        }

        return -1;
    }

    /**
     * 通过二分查找值，找到则返回那个值的下标，否则返回第一个比他大的
     */
    private int binarySearchFirstBigger(int[] numbers, int target, int low ,int high) {
        while (low <= high) {
            int mid = (low + high) >>> 1;

            if (target == numbers[mid]) {
                return mid;
            } else if (target < numbers[mid]) {
                if (mid == 0 || numbers[mid - 1] < target) {
                    return mid;
                }
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        return -1;
    }

    /**
     * 解法1：双指针 + 二分
     */
    public int[] twoSum(int[] numbers, int target) {
        int left = 0;
        int right = numbers.length - 1;

        while (left < right) {
            int sum = numbers[left] + numbers[right];
            if (sum == target) {
                return new int[]{left + 1, right + 1};
            } else if (sum < target) {
                int diff = target - numbers[right];
                int ansIndex = binarySearchFirstBigger(numbers, diff, left + 1, right - 1);
                if (ansIndex == -1) {
                    return new int[]{-1, -1};
                }
                if (numbers[ansIndex] == diff) {
                    return new int[]{ansIndex + 1, right + 1};
                }
                left = ansIndex;
            } else {
                int diff = target - numbers[left];
                int ansIndex = binarySearchLastSmaller(numbers, diff, left + 1, right - 1);
                if (ansIndex == -1) {
                    return new int[]{-1, -1};
                }
                if (numbers[ansIndex] == diff) {
                    return new int[]{left + 1, ansIndex + 1};
                }
                right = ansIndex;
            }
        }

        return new int[]{-1, -1};
    }

    public static void main(String[] args) {
        int[] arr = new Problem167().twoSum(new int[]{2, 7, 11, 15}, 9);
        System.out.println(arr[0] + "," + arr[1]);
    }
}
