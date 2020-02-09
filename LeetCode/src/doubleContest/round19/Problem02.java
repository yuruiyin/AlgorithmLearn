package doubleContest.round19;

public class Problem02 {

    public int numOfSubarrays(int[] arr, int k, int threshold) {
        int len = arr.length;
        int[] preSumArr = new int[len];
        preSumArr[0] = arr[0];

        for (int i = 1; i < len; i++) {
            preSumArr[i] = preSumArr[i-1] + arr[i];
        }

        int ans = 0;
        for (int i = 0; i + k <= len; i++) {
            int left = i;
            int right = i + k - 1;
            int sum = 0;
            if (left == 0) {
                sum = preSumArr[right];
            } else {
                sum = preSumArr[right] - preSumArr[left - 1];
            }

            int aver = sum / k;

            if (aver >= threshold) {
                ans++;
            }
        }

        return ans;
    }
    
    public static void main(String[] args) {
        System.out.println(new Problem02().numOfSubarrays(new int[]{2,2,2,2,5,5,5,8}, 3, 4));
    }

}
