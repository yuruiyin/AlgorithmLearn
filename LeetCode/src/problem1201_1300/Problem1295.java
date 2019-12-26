package problem1201_1300;

public class Problem1295 {

    public int findNumbers(int[] nums) {
        int ans = 0;
        for (int num : nums) {
            int count = 0;
            while (num  > 0) {
                num /= 10;
                count++;
            }
            ans += (count % 2 == 0) ? 1 : 0;
        }

        return ans;
    }
    
    public static void main(String[] args) {

    }
    
}
