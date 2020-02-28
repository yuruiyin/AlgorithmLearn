package problem301_400;

// 树状数组版本
public class Problem307_1 {

    static class NumArray {

        // 树状数组
        class BIT {

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

        private BIT binaryIndexTree;

        public NumArray(int[] nums) {
            binaryIndexTree = new BIT(nums);
        }

        public void update(int i, int val) {
            binaryIndexTree.update(i, val);
        }

        public int sumRange(int i, int j) {
            return binaryIndexTree.sumRange(i, j);
        }
    }

    public static void main(String[] args) {
        NumArray numArray = new NumArray(new int[]{-1});
        System.out.println(numArray.sumRange(0, 0));
        numArray.update(0, 1);
        System.out.println(numArray.sumRange(0, 0));
    }

}
