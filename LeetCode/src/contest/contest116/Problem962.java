package contest.contest116;

public class Problem962 {

    public int maxWidthRamp(int[] arr) {
        int len = arr.length;
        int left = -1;
        int right = len - 1;
        for (int i = 0; i < len; i++) {
            if (arr[i] <= arr[len-1]) {
                left = i;
                break;
            }
        }

        int max = right - left;

        for (int i = len - 2; i >= 0; i--) {
            if (arr[i] <= arr[right]) {
                continue;
            }

            for (int j = 0; j <= i; j++) {
                if (i - j < max) {
                    break;
                }
                if (arr[j] <= arr[i]) {
                    if (i - j >= max) {
                        max = i - j;
                        left = j;
                        right = i;
                    }
                    break;
                }
            }
        }

        return max;
    }
    
    public static void main(String[] args) {
        System.out.println(new Problem962().maxWidthRamp(new int[]{6,0,8,2,1,5}));
    }

}
