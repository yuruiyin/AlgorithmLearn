package contest.contest301;

import java.util.Arrays;

public class A {

    public int fillCups(int[] arr) {
        int len = arr.length;
        int ans = 0;
        while (true) {
            boolean isEmpty = true;
            for (int i = 0; i < 3; i++) {
                if (arr[i] > 0) {
                    isEmpty = false;
                    break;
                }
            }
            if (isEmpty) {
                return ans;
            }

            Arrays.sort(arr);

            if (arr[1] >= 1 && arr[2] >= 1) {
                arr[1]--;
                arr[2]--;
                ans++;
            } else if (arr[2] >= 1) {
                arr[2]--;
                ans++;
            }
        }
    }

    public static void main(String[] args) {
        System.out.println(new A().fillCups(new int[]{2,0,2}));
        System.out.println("hello");
    }

}
