package contest.contest353;

public class D {

    public boolean checkArray(int[] nums, int k) {
        if (k == 1) {
            return true;
        }

        int len = nums.length;
        int left = 0;
        int right = 0;
        int pre = 0;
        while (true) {
            while (left < len && nums[left] - pre == 0) {
                left++;
                right = left;
            }

            if (left == right) {
                pre = 0;
            }

            if (left >= len) {
                return true;
            }

            if (len - left < k) {
                System.out.println("left: " + left);
                return false;
            }

            for (int i = right + 1; i < left + k; i++) {
                if (i == right + 1) {
                    if (nums[i] < nums[i - 1] - pre) {
                        System.out.println("11left: " + left + "right: " + right + "i: " + i);
                        return false;
                    }
                } else {
                    if (nums[i] < nums[i - 1]) {
                        System.out.println("left: " + left + "i: " + i);
                        return false;
                    }
                }
            }

            int nextLeft = left;
            for (int i = left + 1; i < left + k; i++) {
                if (i == right + 1) {
                    if (nums[i] > nums[i - 1] - pre) {
                        nextLeft = i;
                        break;
                    }
                } else {
                    if (nums[i] > nums[i - 1]) {
                        nextLeft = i;
                        break;
                    }
                }
            }

            if (nextLeft == left) {
                pre = 0;
                left = left + k;
                right = left;
            } else {
                pre = nums[left];
                right = left + k - 1;
                left = nextLeft;
            }

        }

    }

    public static void main(String[] args) {
        System.out.println(new D().checkArray(new int[]{2,2,3,1,1,0}, 3));
    }

}
