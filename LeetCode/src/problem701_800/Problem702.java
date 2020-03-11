package problem701_800;

public class Problem702 {

    interface ArrayReader {
        int get(int index);
    }

    public int search(ArrayReader reader, int target) {
        int low = 0;
        int high = Integer.MAX_VALUE;

        while (low <= high) {
            int mid = low + ((high - low) >>> 1);
            int midVal = reader.get(mid);
            if (midVal == Integer.MAX_VALUE) {
                high = mid - 1;
            } else if (midVal == target) {
                return mid;
            } else if (midVal > target) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        return -1;
    }

}
