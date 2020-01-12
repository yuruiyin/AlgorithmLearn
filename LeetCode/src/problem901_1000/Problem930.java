package problem901_1000;

public class Problem930 {

    public int numSubarraysWithSum(int[] arr, int sum) {
        int len = arr.length;
        if (len == 0) {
            return 0;
        }

        int[] preSumArr = new int[len];
        int[] countArr = new int[len+1];
        preSumArr[0] = arr[0];
        countArr[preSumArr[0]]++;
        int ans = preSumArr[0] == sum ? 1 : 0;
        for (int i = 1; i < len; i++) {
            preSumArr[i] = preSumArr[i-1] + arr[i];
            int diff = preSumArr[i] - sum;
            if (preSumArr[i] == sum) {
                ans++;
            }
            if (diff < 0) {
                countArr[preSumArr[i]]++;
                continue;
            }

            ans += countArr[diff];
            countArr[preSumArr[i]]++;
        }

        return ans;
    }
    
    public static void main(String[] args) {
        System.out.println(new Problem930().numSubarraysWithSum(new int[]{1,0,1,0,1}, 2));
    }

}
