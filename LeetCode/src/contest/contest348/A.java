package contest.contest348;

import java.util.HashSet;
import java.util.Set;

public class A {

    public int minimizedStringLength(String s) {
        char[] arr = s.toCharArray();
        int len = arr.length;
        Set<Character> set = new HashSet<>();
        for (char c : arr) {
            set.add(c);
        }
        return set.size();
    }

    public static void main(String[] args) {
        System.out.println("hello world");
    }

}
