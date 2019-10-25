package problem001_100;

public class Problem041 {

    private void swap(int[] a, int i, int j) {
        int tmp = a[i];
        a[i] = a[j];
        a[j] = tmp;
    }

    public int firstMissingPositive(int[] nums) {
        int n = nums.length;
        boolean hasOne = false;

        for (int num : nums) {
            if (num == 1) {
                hasOne = true;
                break;
            }
        }

        if (!hasOne) {
            return 1;
        }

        for (int i = 0; i < n; i++) {
            if (nums[i] <= 0 || nums[i] > n) {
                continue;
            }

            // nums[i] != nums[nums[i] - 1] 很关键，也就是不相等才交换，否则会死循环
            while (nums[i] > 0 && nums[i] < n && nums[i] != nums[nums[i] - 1]) {
                swap(nums, i, nums[i] - 1);
            }
        }

        for (int i = 1; i < n; i++) {
            if (nums[i] != i + 1) {
                return i + 1;
            }
        }

        return n + 1;
    }

    public static void main(String[] args) {
        System.out.println(new Problem041().firstMissingPositive(new int[]{1,2,0}));
        System.out.println(new Problem041().firstMissingPositive(new int[]{3,4,-1,1}));
        System.out.println(new Problem041().firstMissingPositive(new int[]{7,8,9,11,12}));
        System.out.println(new Problem041().firstMissingPositive(new int[]{
                10,4,16,54,17,-7,21,15,25,31,61,1,6,12,21,46,16,56,54,12,23,20,38,63,2,27,35,11,13,47,13,11,61,39,0,14,42,8,16,54,50,12,-10,43,11,-1,24,38,-10,13,60,0,44,11,50,33,48,20,31,-4,2,54,-6,51,6
        }));

    }
    
}
