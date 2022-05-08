package contest.contest292;

import java.util.Set;
import java.util.TreeSet;

public class A {

    public String largestGoodInteger(String num) {
        char[] arr = num.toCharArray();
        int len = arr.length;
        TreeSet<String> set = new TreeSet<>();
        for (int i = 0; i < len - 2; i++) {
            if (arr[i] == arr[i + 1] && arr[i] == arr[i + 2]) {
                set.add(num.substring(i, i + 3));
            }
        }
        return set.isEmpty() ? "" : set.last();
    }

    public static void main(String[] args) {
        System.out.println("hello world");
    }

}
