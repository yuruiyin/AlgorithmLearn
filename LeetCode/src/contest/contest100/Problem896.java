package contest.contest100;

public class Problem896 {

    public boolean isMonotonic(int[] arr) {
        int len = arr.length;
        if (len <= 2) {
            return true;
        }

        int isBigger = -1;

        for (int i = 1; i < len; i++) {
            if (arr[i] > arr[i-1]) {
                if (isBigger == 0) {
                    return false;
                }
                isBigger = 1;
            } else if (arr[i] < arr[i-1]) {
                if (isBigger == 1) {
                    return false;
                }
                isBigger = 0;
            }
        }

        return true;
    }

}
