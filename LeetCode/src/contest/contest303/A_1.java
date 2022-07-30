package contest.contest303;

import java.util.HashSet;
import java.util.Set;

public class A_1 {

    public char repeatedCharacter(String s) {
        char[] arr = s.toCharArray();
        Set<Character> set = new HashSet<>();
        for (char c : arr) {
            if (set.contains(c)) {
                return c;
            }
            set.add(c);
        }
        return ' ';
    }

    public static void main(String[] args) {
        System.out.println("hell");
    }

}
