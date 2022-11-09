package problem301_400;

import java.util.*;

public class Problem336 {

    private boolean isPalindrome(char[] arr, int l, int r) {
        while (l < r) {
            if (arr[l] != arr[r]) {
                return false;
            }
            l++;
            r--;
        }
        return true;
    }

    private List<Integer> getList(int i, int j) {
        List<Integer> list = new ArrayList<>();
        list.add(i);
        list.add(j);
        return list;
    }

    public List<List<Integer>> palindromePairs(String[] words) {
        int len = words.length;
        Map<String, Integer> indexMap = new HashMap<>();
        for (int i = 0; i < len; i++) {
            indexMap.put(words[i], i);
        }

        boolean hasEmptyStr = indexMap.containsKey("");

        List<List<Integer>> ansList = new ArrayList<>();
        for (int i = 0; i < len; i++) {
            String word = words[i];
            int tmpLen = word.length();
            char[] arr = word.toCharArray();
            String reverseWord = new StringBuilder(word).reverse().toString();
            if (!reverseWord.equals(word) && indexMap.containsKey(reverseWord)) {
                ansList.add(getList(i, indexMap.get(reverseWord)));
            }

            // 不添加前缀后缀的情况下，看自身是否是回文传，且存在空字符串
            if (!word.equals("") && isPalindrome(arr, 0, tmpLen - 1) && hasEmptyStr) {
                ansList.add(getList(i, indexMap.get("")));
                ansList.add(getList(indexMap.get(""), i));
            }

            // 以当前word为前缀
            for (int j = 1; j < tmpLen; j++) {
                // 判断[j, tmpLen - 1]是否是回文
                if (!isPalindrome(arr, j, tmpLen - 1)) {
                    continue;
                }
                // 后面增加j个
                String addStr = new StringBuilder(word.substring(0, j)).reverse().toString();
                if (indexMap.containsKey(addStr)) {
                    ansList.add(getList(i, indexMap.get(addStr)));
                }
            }

            // 以当前word为后缀
            for (int j = 1; j < tmpLen; j++) {
                // 判断[0, j]是否是回文
                if (!isPalindrome(arr, 0, tmpLen - j - 1)) {
                    continue;
                }
                // 前面增加j个
                String addStr = new StringBuilder(word.substring(tmpLen - j)).reverse().toString();
                if (indexMap.containsKey(addStr)) {
                    ansList.add(getList(indexMap.get(addStr), i));
                }
            }
        }
        return ansList;
    }

}
