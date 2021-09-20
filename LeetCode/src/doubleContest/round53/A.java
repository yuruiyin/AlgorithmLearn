package doubleContest.round53;

import java.util.HashSet;
import java.util.Set;

/**
 * A
 *
 * @author: yry
 * @date: 2021/5/29
 */
public class A {

    private boolean isOk(char[] arr, int from) {
        Set<Character> set = new HashSet<>();
        set.add(arr[from]);
        set.add(arr[from + 1]);
        set.add(arr[from + 2]);
        return set.size() == 3;
    }

    public int countGoodSubstrings(String s) {
        char[] arr = s.toCharArray();
        int len = arr.length;
        int ans = 0;
        for (int i = 0; i < len - 2; i++) {
            if (isOk(arr, i)) {
                ans++;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println("hello world");
    }

}
