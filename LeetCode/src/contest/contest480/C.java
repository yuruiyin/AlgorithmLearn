package contest.contest480;

public class C {

    public long minMoves(int[] arr) {
        long sum = 0;
        int negIdx = -1;
        int len = arr.length;
        for (int i = 0; i < len; i++) {
            sum += arr[i];
            if (arr[i] < 0) {
                negIdx = i;
            }
        }

        if (negIdx == -1) {
            return 0;
        }

        if (sum < 0) {
            return -1;
        }

        long ans = 0;

        for (int offset = 1; ; offset++) {
            int leftIdx = (negIdx - offset + len) % len;
            int rightIdx = (negIdx + offset) % len;
            arr[negIdx] += arr[leftIdx];
            if (arr[negIdx] >= 0) {
                ans += (arr[leftIdx] - arr[negIdx]) * (long)offset;
                break;
            }
            ans += arr[leftIdx] * (long)offset;
            if (leftIdx != rightIdx) {
                arr[negIdx] += arr[rightIdx];
                if (arr[negIdx] >= 0) {
                    ans += (arr[rightIdx] - arr[negIdx]) * (long)offset;
                    break;
                }
                ans += arr[rightIdx] * (long)offset;
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        System.out.println(new C().minMoves(new int[]{5,1,-4}));
    }

}
