package doubleContest.round115;

import java.util.ArrayList;
import java.util.List;

public class B {

    public List<String> getWordsInLongestSubsequence(int n, String[] words, int[] groups) {
        List<String> ansList = new ArrayList<>();
        int pre = groups[0];
        ansList.add(words[0]);
        for (int i = 1; i < n; i++) {
            if (groups[i] != pre) {
                ansList.add(words[i]);
                pre = groups[i];
            }
        }
        return ansList;
    }

}
