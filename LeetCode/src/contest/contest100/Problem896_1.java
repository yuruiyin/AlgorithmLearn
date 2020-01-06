package contest.contest100;

public class Problem896_1 {

    private boolean increasing(int[] arr)  {
        int len = arr.length;
        for (int i = 1; i < len; i++) {
            if (arr[i] < arr[i-1]) {
                return false;
            }
        }
        return true;
    }

    private boolean decreasing(int[] arr) {
        int len = arr.length;
        for (int i = 1; i < len; i++) {
            if (arr[i] > arr[i-1]) {
                return false;
            }
        }
        return true;
    }

    public boolean isMonotonic(int[] arr) {
        return increasing(arr) || decreasing(arr);
    }

}
