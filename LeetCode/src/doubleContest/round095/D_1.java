package doubleContest.round095;

public class D_1 {

    private boolean isOk(long[] arr, int r, int k, long min, int[][] queue) {
        int len = arr.length;
        long pre = 0;
//        LinkedList<int[]> queue = new LinkedList<>();
//        List<int[]> queue = new ArrayList<>();
        int queueSize = 0;
        int fromIdx = 0;
        for (int i = 0; i < len; i++) {
            int j;
            for (j = fromIdx; j < queueSize; j++) {
                int[] top = queue[j];
                if (top[0] < i) {
                    pre -= top[1];
                } else {
                    break;
                }
            }
            fromIdx = j;
            long diff = min - (arr[i] + pre);
            if (diff <= 0) {
                continue;
            }
            if (k < diff) {
                return false;
            }
            pre += diff;
            k -= diff;
            queue[queueSize++] = new int[]{Math.min(len - 1, i + (r << 1)), (int) diff};
        }
        return true;
    }

    public long maxPower(int[] stations, int r, int k) {
        // 二分
        long low = 0;
        long high = (long) (1e11);

        int len = stations.length;

        long[] preSumArr = new long[len];
        preSumArr[0] = stations[0];
        for (int i = 1; i < len; i++) {
            preSumArr[i] = preSumArr[i - 1] + stations[i];
        }

        long[] arr = new long[len];
        for (int i = 0; i < len; i++) {
            int left = Math.max(0, i - r);
            int right = Math.min(len - 1, i + r);
            arr[i] = preSumArr[right] - (left == 0 ? 0 : preSumArr[left - 1]);
        }

        long ans = -1;
        int[][] queue = new int[len][2];
        while (low <= high) {
            long mid = (low + high) >>> 1L;
            if (isOk(arr, r, k, mid, queue)) {
                ans = mid;
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(new D_1().maxPower(new int[]{4, 4, 4, 4}, 0, 3));
    }

}
