package contest.contest089;

public class Problem852_1 {

    public int peakIndexInMountainArray(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > arr[i+1]) {
                return i;
            }
        }
        return -1;
    }

}
