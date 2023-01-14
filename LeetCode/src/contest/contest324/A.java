package contest.contest324;

import java.util.HashSet;
import java.util.Set;

public class A {

    public int similarPairs(String[] words) {
        int len = words.length;
        int ans = 0;
        for (int i = 0; i < len; i++) {
            Set<Character> set1 = new HashSet<>();
            for (char c : words[i].toCharArray()) {
                set1.add(c);
            }
            for (int j = i + 1; j < len; j++) {
                Set<Character> set2 = new HashSet<>();
                for (char c : words[j].toCharArray()) {
                    set2.add(c);
                }
                if (set1.size() == set2.size()) {
                    boolean isOk = true;
                    for (Character c1 : set1) {
                        if (!set2.contains(c1)) {
                            isOk = false;
                            break;
                        }
                    }
                    if (isOk) {
                        ans++;
                    }
                }
            }
        }
        return ans;

    }

    public static void main(String[] args) {
        System.out.println("hello world");
    }

}
