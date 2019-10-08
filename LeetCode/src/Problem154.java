public class Problem154 {

    public int findMin(int[] nums) {
        int min = Integer.MAX_VALUE;
        for (int num : nums) {
            if (num < min) {
                min = num;
            }
        }

        return min;
    }
    
    public static void main(String[] args) {
        System.out.println(new Problem154().findMin(new int[]{1,3,5}));
        System.out.println(new Problem154().findMin(new int[]{2,2,2,0,1}));
    }
}
