package contest.contest293;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class A {


    private boolean isSame(String word1, String word2) {
        char[] countArr1 = new char[26];
        for (char c : word1.toCharArray()) {
            countArr1[c - 'a']++;
        }
        char[] countArr2 = new char[26];
        for (char c : word2.toCharArray()) {
            countArr2[c - 'a']++;
        }
        return Arrays.equals(countArr1, countArr2);
    }

    public List<String> removeAnagrams(String[] words) {
        List<String> list = new ArrayList<>();
        for (String word : words) {
            list.add(word);
        }

        while (true) {
            int size = list.size();
            int removeIdx = -1;
            for (int i = 1; i < size; i++) {
                String curWord = list.get(i);
                String preWord = list.get(i - 1);
                if (isSame(curWord, preWord)) {
                    removeIdx = i;
                    break;
                }
            }
            if (removeIdx == -1) {
                break;
            }
            List<String> tmpList = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                if (i == removeIdx) {
                    continue;
                }
                tmpList.add(list.get(i));
            }
            list = tmpList;
        }
        return list;
    }

    public static void main(String[] args) {
        System.out.println("hello world");
    }

}
