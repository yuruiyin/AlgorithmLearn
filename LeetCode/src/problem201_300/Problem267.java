package problem201_300;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Problem267 {

    private int[] countArr;
    private char oddCountChar = ' ';
    private int len;
    private List<String> ansList;

    private String getCompletePalindrome(String rightHalfStr) {
        StringBuilder sb = new StringBuilder(rightHalfStr);
        if (oddCountChar == ' ') {
            return sb.reverse().append(rightHalfStr).toString();
        }

        return sb.reverse().append(oddCountChar).append(rightHalfStr).toString();
    }

    private void backTrack(Set<Character> charSet, StringBuilder tmpSb) {
        if (tmpSb.length() == len / 2) {
            // 因为我们就生成回文串右半边，因此就是一半的长度
            ansList.add(getCompletePalindrome(tmpSb.toString()));
            return;
        }

        for (Character c : charSet) {
            if (countArr[c] == 0) {
                continue;
            }

            tmpSb.append(c);
            countArr[c] -= 2;
            backTrack(charSet, tmpSb);
            countArr[c] += 2;
            tmpSb.deleteCharAt(tmpSb.length() - 1);
        }
    }

    public List<String> generatePalindromes(String s) {
        countArr = new int[128];
        char[] arr = s.toCharArray();
        len = arr.length;
        ansList = new ArrayList<>();

        for (char c : arr) {
            countArr[c]++;
        }

        int oddCount = 0;
        for (int i = 0; i < 128; i++) {
            if ((countArr[i] & 1) == 1) {
                oddCount++;
                oddCountChar = (char) i;
            }
        }

        if (oddCount > 1) {
            return ansList;
        }

        Set<Character> charSet = new HashSet<>();
        boolean isRemovedOddCharOnce = false;
        for (char c : arr) {
            if (c == oddCountChar && !isRemovedOddCharOnce) {
                isRemovedOddCharOnce = true;
                countArr[c]--;
                continue;
            }
            charSet.add(c);
        }

        if (charSet.isEmpty()) {
            // 类似 a
            ansList.add(s);
        } else {
            backTrack(charSet, new StringBuilder());
        }

        return ansList;
    }
    
    public static void main(String[] args) {
        System.out.println(new Problem267().generatePalindromes("aabbccc"));
    }

}
