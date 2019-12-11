package problem701_800;

import java.util.HashSet;
import java.util.Set;

public class Problem771 {

    public int numJewelsInStones(String J, String S) {
        Set<Character> set = new HashSet<>();
        for (char c : J.toCharArray()) {
            set.add(c);
        }

        int ans = 0;
        for (char c : S.toCharArray()) {
            if (set.contains(c)) {
                ans++;
            }
        }

        return ans;
    }

}
