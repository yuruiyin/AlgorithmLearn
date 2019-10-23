package interview_bytedance.round09;

public class Problem02 {

    private void swap(int[] a, int i, int j) {
        int tmp = a[i];
        a[i] = a[j];
        a[j] = tmp;
    }

    public void sortColors(int[] nums) {
        if (nums.length <= 1) {
            return;
        }

        if (nums.length == 2) {
            if (nums[0] > nums[1]) {
                swap(nums, 0, 1);
            }

            return;
        }

        int left = 0;
        int right = nums.length - 1;

        for (int i = 1; i <= right; ) {
            if (nums[left] > nums[right]) {
                swap(nums, left, right);
            }

            if (nums[i] < nums[left]) {
                swap(nums, i, left);
            }

            if (nums[i] > nums[right]) {
                swap(nums, i, right);
            }

            boolean isLeftRightMove = false;
            if (nums[left] == 0) {
                left++;
                if (i < left) {
                    i++;
                }
                isLeftRightMove = true;
            }

            if (nums[right] == 2) {
                right--;
                isLeftRightMove = true;
            }

            if (!isLeftRightMove) {
                i++;
            }
        }

    }
    
    public static void main(String[] args) {
        int[] nums = new int[]{2,0,2,1,1,0};
        new Problem02().sortColors(nums);

        for (int num : nums) {
            System.out.print(num + ",");
        }
        System.out.println();

        int[] nums1 = new int[]{1,2,0};
        new Problem02().sortColors(nums1);

        for (int num : nums1) {
            System.out.print(num + ",");
        }
        System.out.println();

        int[] nums2 = new int[]{2,1,0};
        new Problem02().sortColors(nums2);

        for (int num : nums2) {
            System.out.print(num + ",");
        }
        System.out.println();

        int[] nums3 = new int[]{2,1,2};
        new Problem02().sortColors(nums3);

        for (int num : nums3) {
            System.out.print(num + ",");
        }
        System.out.println();

//        [1,2,2,2,2,0,0,0,1,1]
        int[] nums4 = new int[]{1,2,2,2,2,0,0,0,1,1};
        new Problem02().sortColors(nums4);

        for (int num : nums4) {
            System.out.print(num + ",");
        }
        System.out.println();
    }
    
}
