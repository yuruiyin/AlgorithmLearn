package doubleContest.round09;

import java.util.Arrays;

public class Problem01 {

    public int maxNumberOfApples(int[] arr) {
        Arrays.sort(arr);
        int ans = 0;
        int sum = 0;
        for (int num : arr) {
            if (sum + num <= 5000) {
                sum += num;
                ans++;
            } else {
                break;
            }
        }

        return ans;
    }
    
    public static void main(String[] args) {

    }
    
}
