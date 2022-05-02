package contest.contest291;

import java.util.Arrays;

public class B {

    public int minimumCardPickup(int[] cards) {
        int[] preIdxArr = new int[1000001];
        Arrays.fill(preIdxArr, -1);
        int len = cards.length;
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < len; i++) {
            int num = cards[i];
            if (preIdxArr[num] != -1) {
                min = Math.min(min, i - preIdxArr[num] + 1);
            }
            preIdxArr[num] = i;
        }
        if (min == Integer.MAX_VALUE) {
            return -1;
        }
        return min;
    }

    public static void main(String[] args) {
        System.out.println("hello world");
    }

}
