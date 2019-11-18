package problem1001_1100;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Problem1023 {

    private void calcCount(Map<Character, Integer> countMap, String str) {
        char[] patternArr = str.toCharArray();

        for (char c : patternArr) {
            if (countMap.containsKey(c)) {
                countMap.put(c, countMap.get(c) + 1);
            } else {
                countMap.put(c, 1);
            }
        }
    }

    private boolean isUpperCase(char c) {
        return c >= 'A' && c <= 'Z';
    }

    private boolean isUpperCaseMatch(Map<Character, Integer> tmpCountMap, Map<Character, Integer> countMap) {
        for (Character c : tmpCountMap.keySet()) {
            if (isUpperCase(c) && (!countMap.containsKey(c) || !tmpCountMap.get(c).equals(countMap.get(c)))) {
                return false;
            }
        }

        return true;
    }

    private int findFirstBiggerByBinarySearch(List<Integer> indexList, int target) {
        int low = 0;
        int high = indexList.size() - 1;
        while (low <= high) {
            int mid = (low + high) >>> 1;
            int midVal = indexList.get(mid);
            if (target <= midVal) {
                if (mid == 0 || indexList.get(mid-1) < target) {
                    return midVal;
                }
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        return -1;
    }

    private boolean isSubSequence(String query, String pattern) {
        Map<Character, List<Integer>> indexListMap = new HashMap<>();
        for (int i = 0; i < query.length(); i++) {
            char c = query.charAt(i);
            if (indexListMap.containsKey(c)) {
                indexListMap.get(c).add(i);
            } else {
                List<Integer> list = new ArrayList<>();
                list.add(i);
                indexListMap.put(c, list);
            }
        }

        int from = 0;
        for (int i = 0; i < pattern.length(); i++) {
            char c = pattern.charAt(i);
            List<Integer> indexList = indexListMap.get(c);
            if (indexList == null || indexList.isEmpty()) {
                return false;
            }

            int index = findFirstBiggerByBinarySearch(indexList, from);
            if (index == -1) {
                return false;
            }
            from = index + 1;
        }

        return true;
    }

    public List<Boolean> camelMatch(String[] queries, String pattern) {
        Map<Character, Integer> countMap = new HashMap<>();
        calcCount(countMap, pattern);

        List<Boolean> ansList = new ArrayList<>();
        for (String query : queries) {
            Map<Character, Integer> tmpCountMap = new HashMap<>();
            calcCount(tmpCountMap, query);

            ansList.add(isUpperCaseMatch(tmpCountMap, countMap) && isSubSequence(query, pattern));
        }

        return ansList;
    }
    
    public static void main(String[] args) {
        new Problem1023().camelMatch(new String[]{"FooBar","FooBarTest","FootBall","FrameBuffer","ForceFeedBack"}, "FB");
    }
    
}
