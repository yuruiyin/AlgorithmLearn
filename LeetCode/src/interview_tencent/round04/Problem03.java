package interview_tencent.round04;

public class Problem03 {

    private int findNotBiggerCount(int m, int n, int target) {
        int maxRow = Math.min(target, m);
        int count = 0;
        for (int i = maxRow; i >= 1; i--) {
            int maxCol = Math.min(target / i, n);
            count += maxCol;
        }

        return count;
    }

    public int findKthNumber(int m, int n, int k) {
        if (m == 1 || n == 1) {
            return k;
        }

        int low = 1;
        int high = m * n;

        while (low < high) {
            int mid = (low + high) >> 1;
            int count = findNotBiggerCount(m, n, mid);

            if (count >= k) {
                high = mid;
            } else {
                low = mid + 1;
            }
        }

        return high;

    }
    
    public static void main(String[] args) {
        System.out.println(new Problem03().findKthNumber(3, 3, 5));
        System.out.println(new Problem03().findKthNumber(2, 3, 6));
    }
    
}
