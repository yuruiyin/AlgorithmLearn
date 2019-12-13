package problem701_800;

public class Problem769_1 {

    public int maxChunksToSorted(int[] arr) {
        int max = 0;
        int ansCount = 0;
        int len = arr.length;
        for (int i = 0; i < len; i++) {
            if (arr[i] > max) {
                max = arr[i];
            }

            if (max <= i) {
                ansCount++;
            }
        }

        return ansCount;
    }

}
