package contest.contest401;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

public class D_1 {

    public int maxTotalReward(int[] arr) {
        Arrays.sort(arr);
        int maxNum = 0;
        for (int num : arr) {
            maxNum = Math.max(maxNum, num);
        }
        // 答案的上界是 2 * maxNum - 1，
        // 去重之后，最大数是必选的。
        return 0;
    }

    private static int[] createArr() {
        int[] arr = new int[50000];
        Arrays.fill(arr, 1);
        return arr;
    }

    private static int[] createArr1() {
        int[] arr = new int[50000];
        for (int i = 0; i < 50000; i++) {
            arr[i] = i + 1;
        }
        return arr;
    }

    public static void main(String[] args) {
//        System.out.println(new D().maxTotalReward(new int[]{
//                1, 14, 13, 19
//        }));
        System.out.println(new D_1().maxTotalReward(createArr1()));
    }


}
