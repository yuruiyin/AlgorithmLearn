package doubleContest.round03;

public class Problem1099 {

    public int twoSumLessThanK(int[] arr, int k) {
        int ansMax = Integer.MIN_VALUE;
        int len = arr.length;

        for (int i = 0; i < len; i++) {
            for (int j = i + 1; j < len; j++) {
                int sum = arr[i] + arr[j];
                if (sum < k && sum > ansMax) {
                    ansMax = sum;
                }
            }
        }

        return ansMax == Integer.MIN_VALUE ? -1 : ansMax;
    }
    
    public static void main(String[] args) {

    }
    
}
