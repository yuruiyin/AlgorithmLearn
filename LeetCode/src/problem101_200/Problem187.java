package problem101_200;

import utils.PrintUtil;

import java.util.*;

public class Problem187 {

    public List<String> findRepeatedDnaSequences(String s) {
        int len = s.length();
        Map<String, Integer> countMap = new HashMap<>();
        List<String> ansList = new ArrayList<>();

        for (int i = 0; i < len - 9; i++) {
            String subStr = s.substring(i, i + 10);
            countMap.put(subStr, countMap.getOrDefault(subStr, 0) + 1);
            if (countMap.get(subStr) == 2) {
                ansList.add(subStr);
            }
        }

        return ansList;
    }

    public static void main(String[] args) {
        List<String> ansList = new Problem187().findRepeatedDnaSequences("AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT");

        PrintUtil.printStringList(ansList);
    }
}
