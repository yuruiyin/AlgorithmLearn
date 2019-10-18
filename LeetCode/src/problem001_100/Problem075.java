package problem001_100;

public class Problem075 {

    public void sortColors(int[] nums) {
        int[] countArr = new int[3];
        int size = nums.length;

        for (int i = 0; i < size; i++) {
            countArr[nums[i]]++;
        }

        int count = 0;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < countArr[i]; j++) {
                nums[count++] = i;
            }
        }
    }

    public static void main(String[] args) {
        int[] nums = {2,0,2,1,1,0};
        new Problem075().sortColors(nums);

        for (int i = 0; i < nums.length; i++) {
            System.out.print(nums[i] + " ");
        }
    }

}
