package contest.contest398;

public class C {

    public long sumDigitDifferences(int[] nums) {
        int[][] countArr = new int[10][10];
        for (int num : nums) {
            for (int i = 0; i < 10 && num > 0; i++) {
                int bit = num % 10;
                num /= 10;
                countArr[i][bit]++;
            }
        }

        long ans = 0;
        for (int i = 0; i < 9; i++) {
            int[] subCountArr = countArr[i];
            for (int j = 0; j <= 9; j++) {
                for (int k = j + 1; k <= 9; k++) {
                    ans += (long)subCountArr[j] * subCountArr[k];
                }
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        System.out.println((long)10000 * 5000001);
    }

}
