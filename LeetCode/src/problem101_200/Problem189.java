package problem101_200;

public class Problem189 {

    public void rotate(int[] nums, int k) {
        if (k == 0 || nums == null || nums.length == 0) {
            return;
        }

        int len = nums.length;

        int count = 0;
        for (int start = 0; count < len; start++) {
            int curIndex = start;
            int curValue = nums[start];

            do {
                int nextIndex = (curIndex + k) % len;
                int nextValue = nums[nextIndex];
                nums[nextIndex] = curValue;
                curValue = nextValue;
                curIndex = nextIndex;
                count++;
            } while (start != curIndex);

        }
    }

    public static void main(String[] args) {
        new Problem189().rotate(new int[]{1,2,3,4,5,6}, 2);
    }

}
