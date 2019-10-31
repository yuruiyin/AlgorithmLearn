package problem1101_1200;

public class Problem1133 {

    public int largestUniqueNumber(int[] arr) {
        int[] countArr = new int[1001];

        for (int num: arr) {
            countArr[num]++;
        }

        for (int i = 1000; i >= 0; i--) {
            if (countArr[i] == 1) {
                return i;
            }
        }

        return -1;
    }
    
    public static void main(String[] args) {

    }
    
}
