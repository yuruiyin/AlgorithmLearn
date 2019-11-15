package contest.contest134;

import java.util.Arrays;

public class Problem1033 {

    public int[] numMovesStones(int a, int b, int c) {
        int[] arr = new int[]{a, b, c};

        Arrays.sort(arr);

        int diff1 = arr[1] - arr[0];
        int diff2 = arr[2] - arr[1];

        if (diff1 == 1 && diff2 == 1) {
            return new int[]{0, 0};
        }

        if (diff1 <= 2 || diff2 <= 2) {
            return new int[]{1, diff1 - 1 + diff2 - 1};
        }

        return new int[]{2, diff1 - 1 + diff2 - 1};

    }
    
    public static void main(String[] args) {

    }
    
}
