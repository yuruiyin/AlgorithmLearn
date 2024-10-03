package contest.contest416;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class A {

    public boolean reportSpam(String[] message, String[] bannedWords) {
        Set<String> set = new HashSet<>(Arrays.asList(bannedWords));
        int count = 0;
        for (String str : message) {
            if (set.contains(str)) {
                count++;
            }
        }

        return count >= 2;
    }

    public static void main(String[] args) {
        System.out.println("hello world");
    }

}
