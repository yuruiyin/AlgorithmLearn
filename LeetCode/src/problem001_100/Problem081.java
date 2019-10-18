package problem001_100;

public class Problem081 {

    public boolean search(int[] nums, int target) {
        for (int num : nums) {
            if (num == target) {
                return true;
            }
        }

        return false;
    }
    
    public static void main(String[] args) {
        System.out.println(new Problem081().search(new int[]{2,5,6,0,0,1,2}, 0));
        System.out.println(new Problem081().search(new int[]{2,5,6,0,0,1,2}, 3));
    }
    
}
