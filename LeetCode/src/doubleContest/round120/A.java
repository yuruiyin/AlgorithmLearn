package doubleContest.round120;

public class A {

    public int incremovableSubarrayCount(int[] nums) {
        int len = nums.length;
        int ans = 0;
        for (int i = 0; i < len; i++) {
            for (int j = i; j < len; j++) {
                int[] tmpArr = new int[len - (j - i + 1)];
                int idx = 0;
                for (int k = 0; k < i; k++) {
                    tmpArr[idx++] = nums[k];
                }
                for (int k = j + 1; k < len; k++)  {
                    tmpArr[idx++] = nums[k];
                }

                boolean isOk = true;
                for (int k = 1; k < tmpArr.length; k++) {
                    if (tmpArr[k] <= tmpArr[k - 1]) {
                        isOk = false;
                        break;
                    }
                }
                if (isOk) {
                    ans++;
                }
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println("hello world");
    }

}
