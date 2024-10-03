package contest.contest412;

public class B {

    private void swap(char[] arr, int i, int j) {
        char tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

    private boolean isOk(int num1, int num2) {
        if (num1 == num2) {
            return true;
        }
        char[] arr1 = String.valueOf(num1).toCharArray();
        char[] arr2 = String.valueOf(num2).toCharArray();
        for (int i = 0; i < arr1.length; i++) {
            for (int j = i + 1; j < arr1.length; j++) {
                swap(arr1, i, j);
                int newNum1 = Integer.parseInt(new String(arr1));
                if (newNum1 == num2) {
                    return true;
                }
                swap(arr1, i, j);
            }
        }

        for (int i = 0; i < arr2.length; i++) {
            for (int j = i + 1; j < arr2.length; j++) {
                swap(arr2, i, j);
                int newNum2 = Integer.parseInt(new String(arr2));
                if (newNum2 == num1) {
                    return true;
                }
                swap(arr2, i, j);
            }
        }

        return false;
    }

    public int countPairs(int[] nums) {
        int len = nums.length;
        int ans = 0;
        for (int i = 0; i < len; i++) {
            for (int j = i + 1; j < len; j++) {
                if (isOk(nums[i], nums[j])) {
                    ans++;
                }
            }
        }
        return ans;
    }

}
