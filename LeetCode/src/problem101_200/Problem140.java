package problem101_200;

import java.util.*;

public class Problem140 {

    private String s;
    private int len;
    private Set<String> wordSet;
    private Set<Integer> wordLenSet;
    private List<List<String>>[] memo;
    private int[] memoOfIsFound;

    private String listToStr(List<String> list) {
        StringBuilder ansSb = new StringBuilder();
        int len = list.size();
        for (int i = 0; i < len; i++) {
            ansSb.append(list.get(i));
            if (i < len - 1) {
                ansSb.append(" ");
            }
        }

        return ansSb.toString();
    }

    private List<List<String>> backTrack(int start) {
        if (start == len) {
            return new ArrayList<>();
        }

        if (memoOfIsFound[start] != 0) {
            return memo[start];
        }

        List<List<String>> ansList = new ArrayList<>();
        for (Integer wordLen: wordLenSet) {
            int end = start + wordLen;
            if (end > len) {
                break;
            }

            String subStr = s.substring(start, end);
            if (!wordSet.contains(subStr)) {
                continue;
            }

            List<List<String>> subList = backTrack(end);
            if (subList == null) {
                continue;
            }

            if (subList.isEmpty()) {
                ansList.add(Arrays.asList(subStr));
                continue;
            }

            for (List<String> tmpList: subList) {
                List<String> list = new ArrayList<>(Arrays.asList(subStr));
                list.addAll(tmpList);
                ansList.add(list);
            }
        }


        if (ansList.isEmpty()) {
            ansList = null;
        }

        memoOfIsFound[start] = 1;
        memo[start] = ansList;
        return ansList;
    }

    public List<String> wordBreak(String s, List<String> wordDict) {
        this.s = s;
        this.len = s.length();
        wordLenSet = new TreeSet<>();
        wordSet = new HashSet<>();

        for (String word: wordDict) {
            wordSet.add(word);
            wordLenSet.add(word.length());
        }

        memo = new ArrayList[len];
        memoOfIsFound = new int[len];
        List<List<String>> list = backTrack(0);
        List<String> ansList = new ArrayList<>();

        if (list != null) {
            for (List<String> tmpList : list) {
                ansList.add(listToStr(tmpList));
            }
        }

        return ansList;
    }
    
}
