package problem1101_1200;

public class Problem1109 {

    public int[] corpFlightBookings(int[][] bookings, int n) {
        int[] ans = new int[n];

        for (int[] booking: bookings) {
            for (int i = booking[0]; i <= booking[1]; i++) {
                ans[i-1] += booking[2];
            }
        }

        return ans;
    }
    
    public static void main(String[] args) {
        
    }
    
}
