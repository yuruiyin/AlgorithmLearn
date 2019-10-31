package doubleContest.round06;

public class Problem1150 {

    public boolean isMajorityElement(int[] nums, int target) {
        int count = 0;
        for (int num : nums) {
            if (num == target) {
                count++;
            }
        }

        return count > nums.length / 2;
    }
    
    public static void main(String[] args) {

    }
    
}
