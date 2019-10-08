public class Problem162 {

    public int findPeakElement(int[] nums) {
        int low = 0;
        int high = nums.length - 1;
        while (low < high) {
            int mid = (low + high) >>> 1;

            if (nums[mid] > nums[mid + 1]) {
                high = mid;
            } else {
                low = mid + 1;
            }
        }

        return low;
    }
    
    public static void main(String[] args) {
        System.out.println(new Problem162().findPeakElement(new int[]{1,2,3,1}));
        System.out.println(new Problem162().findPeakElement(new int[]{1,2,1,3,5,6,4}));
    }
}
