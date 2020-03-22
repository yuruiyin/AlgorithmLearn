package contest.round03;

import java.util.Arrays;

/**
 * A
 *
 * @author: yry
 * @date: 2020/3/21
 */
public class C {

    public int MinimumAmplitude(int[] arr) {
        int len = arr.length;
        if (len <= 4) {
            return 0;
        }

        Arrays.sort(arr);
        int minDiff = Integer.MAX_VALUE;
        for (int left = 0; left <= 3; left++) {
            int right = 3 - left;
            int min = arr[left];
            int max = arr[len - right - 1];
            minDiff = Math.min(minDiff, max - min);
        }

        return minDiff;

    }
    
    public static void main(String[] args) {
        System.out.println(new C().MinimumAmplitude(new int[]{-4,20,-16,-48,-47,50,-18,-27,-14,-45,-33,-32,-19,-40,1,40,43,-29,16,-43,19,-49,36,-37,-14,-2,46,-19,45,-14,-26,8,-34,42,2,43,-18,-41,36,-7,38,37,43,-43,21,23,14,-19,12,10,5,-31,-20,-10,-18,44,45,0,9,-4,39,39,40,-39,48,-47,-20,-26,50,7,31,36,-18,29,24,30,-8,16,-39,-33,-41,-9,18,-9,30,19,-14,-16,3,-35,-10,31,-2,17,39,14,-17,42,-27,13}));
    }

}
