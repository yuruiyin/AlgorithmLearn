package contest.contest237;

import java.util.HashSet;
import java.util.Set;

/**
 * A
 *
 * @author: yry
 * @date: 2021/4/18
 */
public class A {

    public boolean checkIfPangram(String sentence) {
        Set<Character> set = new HashSet<>();
        char[] arr = sentence.toCharArray();
        for (char c : arr) {
            set.add(c);
        }
        return set.size() == 26;
    }

    public static void main(String[] args) {

    }

}
