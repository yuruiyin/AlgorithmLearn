package problem901_1000;

public class Problem941 {

    public boolean validMountainArray(int[] arr) {
        int len = arr.length;
        if (len < 3) {
            return false;
        }

        boolean asc = true;
        boolean hasAsc = false;
        for (int i = 1; i < len; i++) {
            if (arr[i] < arr[i-1]) {
                asc = false;
            }

            if (asc) {
                hasAsc = true;
                if (arr[i] <= arr[i-1]) {
                    return false;
                }
            } else {
                if (arr[i] >= arr[i-1]) {
                    return false;
                }
            }
        }

        return hasAsc && !asc;
    }

}
