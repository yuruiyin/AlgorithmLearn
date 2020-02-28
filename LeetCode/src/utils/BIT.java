package utils;

// 树状数组
public class BIT {

    private int[] nums;
    private int[] treeArr; // 树状数组
    private int len;

    public BIT(int[] nums) {
        this.nums = nums;
        this.len = nums.length;
        treeArr = new int[len + 1];

        for (int i = 0; i < len; i++) {
            change(i + 1, nums[i]);
        }
    }

    private int lowbit(int x) {
        return x & -x;
    }

    public void change(int i, int val) {
        while (i <= len) {
            treeArr[i] += val;
            i += lowbit(i);
        }
    }

    public void update(int i, int val) {
        change(i + 1, val - nums[i]);
        nums[i] = val;
    }

    private int getPreSum(int i) {
        int sum = 0;
        while (i > 0) {
            sum += treeArr[i];
            i -= lowbit(i);
        }
        return sum;
    }

    public int sumRange(int i, int j) {
        return getPreSum(j + 1) - getPreSum(i);
    }

}
