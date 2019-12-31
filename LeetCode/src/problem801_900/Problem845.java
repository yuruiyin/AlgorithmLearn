package problem801_900;

public class Problem845 {

    public int longestMountain(int[] arr) {
        int len = arr.length;
        int max = 0;
        for (int i = 1; i < len - 1; ) {
            int leftCount = 0;
            for (int left = i - 1; left >= 0; left--) {
                if (arr[left] < arr[left+1]) {
                    leftCount++;
                } else {
                    break;
                }
            }

            if (leftCount == 0) {
                i++;
                continue;
            }

            int rightCount = 0;
            for (int right = i + 1; right < len; right++) {
                if (arr[right] < arr[right-1]) {
                    rightCount++;
                } else {
                    break;
                }
            }

            if (rightCount == 0) {
                i++;
                continue;
            }

            int count = leftCount + rightCount + 1;
            max = Math.max(max, count);
            i += rightCount + 1;
        }

        return max;
    }

}
