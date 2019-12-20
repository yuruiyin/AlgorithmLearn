package problem201_300;

public class Problem275_1 {

    public int hIndex(int[] citations) {
        if (citations == null || citations.length == 0) {
            return 0;
        }

        int len = citations.length;
        int ans = 0;
        // 二分
        int low = 0;
        int high = len - 1;
        while (low <= high) {
            int mid = (low + high) >>> 1;
            int midVal = citations[mid];

            if (len - mid == midVal) {
                return len - mid;
            } else if (len - mid > midVal) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        return len - low;
    }

}
