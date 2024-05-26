package contest.contest389;

import java.util.ArrayList;
import java.util.List;

public class B {

    public long countSubstrings(String s, char c) {
        char[] arr = s.toCharArray();
        int len = arr.length;
        long ans = 0;
        List<Integer> indexList = new ArrayList<>();
        for (int i = 0; i < len; i++) {
            if (arr[i] == c) {
                indexList.add(i);
            }
        }
        long count = indexList.size();
        return count * (count + 1) / 2;
    }

}
