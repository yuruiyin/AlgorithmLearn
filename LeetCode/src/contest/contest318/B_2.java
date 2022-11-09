package contest.contest318;

public class B_2 {

    public long maximumSubarraySum(int[] nums, int k) {
        int len = nums.length;
        long ansMax = 0;
        long sum = 0;
        int[] countArr = new int[100001];
        int size = 0;
        for (int i = 0; i < k; i++) {
            int num = nums[i];
            if (countArr[num]++ == 0) {
                size++;
            }
            sum += num;
        }
        if (size == k) {
            ansMax = sum;
        }
        for (int r = k; r < len; r++) {
            int lNum = nums[r - k];
            int rNum = nums[r];
            if (countArr[rNum]++ == 0) {
                size++;
            }
            if (--countArr[lNum] == 0) {
                size--;
            }
            sum += rNum - lNum;
            if (size == k && sum > ansMax) {
                ansMax = sum;
            }
        }
        return ansMax;
    }

    public static void main(String[] args) {
        System.out.println(new B_2().maximumSubarraySum(new int[]{1,1,2}, 2));
    }

}
