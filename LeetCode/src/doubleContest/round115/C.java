package doubleContest.round115;

import java.util.*;

public class C {

    public List<String> getWordsInLongestSubsequence(int n, String[] words, int[] groups) {
        Set<Integer>[] indexListArr = new HashSet[n];
        Arrays.setAll(indexListArr, value -> new HashSet<>());
        for (int i = 0; i < n; i++) {
            String word1 = words[i];
            for (int j = i + 1; j < n; j++) {
                String word2 = words[j];
                if (word1.length() != word2.length()) {
                    continue;
                }
                int len = word2.length();
                int diffCount = 0;
                for (int k = 0; k < len; k++) {
                    if (word1.charAt(k) != word2.charAt(k)) {
                        diffCount++;
                        if (diffCount > 1) {
                            break;
                        }
                    }
                }
                if (diffCount == 1) {
                    indexListArr[i].add(j);
                }
            }
        }

        int[] dp = new int[n];
        Arrays.fill(dp, 1);
        for (int i = 1; i < n; i++) {
            for (int j = i - 1; j >= 0; j--) {
                if (groups[i] != groups[j] && indexListArr[j].contains(i)) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
        }

//        for (int i = 0; i < n; i++) {
//            System.out.print(dp[i] + " ");
//        }
//        System.out.println();

        int maxCount = 0;
        int maxIdx = -1;

        for (int i = 0; i < n; i++) {
            if (dp[i] > maxCount) {
                maxCount = dp[i];
                maxIdx = i;
            }
        }

        List<String> ansList = new ArrayList<>();
        ansList.add(words[maxIdx]);
        int next = maxIdx;
        int needCount = maxCount - 1;
        for (int i = maxIdx - 1; i >= 0; i--) {
            if (groups[i] != groups[next] && indexListArr[i].contains(next) && dp[i] == needCount) {
                needCount--;
                next = i;
                ansList.add(words[i]);
            }
        }

        Collections.reverse(ansList);
        return ansList;
    }

}
