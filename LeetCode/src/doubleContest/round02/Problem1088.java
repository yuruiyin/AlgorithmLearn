package doubleContest.round02;

public class Problem1088 {

    private int tmpCount = 0;

    private boolean isMatch(int num) {
        char[] arr = String.valueOf(num).toCharArray();
        int len = arr.length;

        if (len == 1) {
            if (arr[0] == '6' || arr[0] == '9') {
                return true;
            }
            return false;
        }

        for (int i = 0; i < len / 2; i++) {
            int leftChar = arr[i];
            int rightChar = arr[len-i-1];
            if (leftChar != rightChar && !(leftChar == '6' && rightChar == '9' || leftChar == '9' && rightChar == '6')) {
                return true;
            }

            // 6和6，9和9
            if (leftChar == rightChar && (leftChar == '6' || leftChar == '9')) {
                return true;
            }
        }

        if (len % 2 == 1) {
            // 奇数个，若两边两边对称，中间是6或者9也是ok的。
            int mid = len / 2;
            if (arr[mid] == '6' || arr[mid] == '9') {
                return true;
            }
            return false;
        }

        return false;
    }

    private void backTrack(int[] nums, int curBitCount, int curNum, int bitCount) {
        if (curBitCount == bitCount) {
            if (isMatch(curNum)) {
                tmpCount++;
            }
            return;
        }

        for (int num: nums) {
            if (num == 0 && curBitCount == 0) {
                continue;
            }

            backTrack(nums, curBitCount + 1, curNum * 10 + num, bitCount);
        }
    }

    private void backTrack(int[] nums, int curBitCount, int curNum, int bitCount, int maxNum, int highBitNum) {
        if (curBitCount == bitCount) {
            if (curNum <= maxNum && isMatch(curNum)) {
                tmpCount++;
            }
            return;
        }

        for (int num: nums) {
            if (num == 0 && curBitCount == 0) {
                continue;
            }

            if (curBitCount == 0 && num > highBitNum) {
                continue;
            }

            backTrack(nums, curBitCount + 1, curNum * 10 + num, bitCount, maxNum, highBitNum);
        }
    }


    public int confusingNumberII(int n) {
        int[] nums = new int[]{0, 1, 6, 8, 9};
        int bitCount = 0;
        int tmpN = n;
        while (tmpN > 0) {
            bitCount++;
            tmpN /= 10;
        }

        int ans = 0;

        for (int i = 1; i <= bitCount - 1; i++) {
            tmpCount = 0;
            backTrack(nums, 0, 0, i);
            ans += tmpCount;
        }

        tmpCount = 0;
        tmpN = n;
        while (tmpN >= 10) {
            tmpN /= 10;
        }
        int highBitNum = tmpN;
        backTrack(nums, 0, 0, bitCount, n, highBitNum);
        ans += tmpCount;

        return ans;
    }

    public static void main(String[] args) {
        System.out.println(new Problem1088().confusingNumberII(100));
    }
    
}
