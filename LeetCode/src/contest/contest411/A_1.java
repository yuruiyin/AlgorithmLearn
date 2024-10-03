package contest.contest411;

import java.util.LinkedList;

public class A_1 {

    public int countKConstraintSubstrings(String s, int k) {
        char[] arr = s.toCharArray();
        int len = arr.length;
        int ans = 0;
        int l = 0;
        int count0 = 0;
        int count1 = 0;
        for (int r = 0; r < len; r++) {
            if (arr[r] == '0') {
                count0++;
            } else {
                count1++;
            }

            while (count0 > k && count1 > k) {
                if (arr[l] == '0') {
                    count0--;
                } else {
                    count1--;
                }
                l++;
            }
            ans += (r - l + 1);
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println("hello world");
    }

}
