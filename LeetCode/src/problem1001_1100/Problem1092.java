package problem1001_1100;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Problem1092 {

    private List<Character> strToCharList(String str) {
        List<Character> list = new ArrayList<>();
        for (int i = 0; i < str.length(); i++) {
            list.add(str.charAt(i));
        }
        return list;
    }

    public String shortestCommonSupersequence(String str1, String str2) {
        // 先求最长公共子序列
        int len1= str1.length();
        int len2 = str2.length();
        int[][] dp = new int[len1 + 1][len2 + 1];

        for (int i = 0; i < len1; i++) {
            int c1 = str1.charAt(i);
            for (int j = 0; j < len2; j++) {
                int c2 = str2.charAt(j);

                if (c1 == c2) {
                    dp[i+1][j+1] = dp[i][j] + 1;
                } else {
                    dp[i+1][j+1] = Math.max(dp[i+1][j], dp[i][j+1]);
                }
            }
        }

        int i = len1;
        int j = len2;
        List<Integer> lcsPath1 = new ArrayList<>();
        List<Integer> lcsPath2 = new ArrayList<>();
        while (dp[i][j] > 0) {
            if (dp[i][j] == dp[i-1][j]) {
                i--;
            } else if (dp[i][j] == dp[i][j-1]) {
                j--;
            } else if (dp[i][j] > dp[i-1][j-1]) {
                i--;
                j--;
                lcsPath1.add(i);
                lcsPath2.add(j);
            }
        }

        Collections.reverse(lcsPath1);
        Collections.reverse(lcsPath2);

        if (lcsPath1.isEmpty()) {
            return str1 + str2;
        }

        List<Character> ansList = new ArrayList<>();
        for (i = 0; i < lcsPath1.get(0); i++) {
            ansList.add(str1.charAt(i));
        }
        for (i = 0; i < lcsPath2.get(0); i++) {
            ansList.add(str2.charAt(i));
        }

        for (i = 0; i < lcsPath1.size();i++) {
            int index1 = lcsPath1.get(i);
            int index2 = lcsPath2.get(i);
            char curCommonChar = str1.charAt(index1);
            ansList.add(curCommonChar);
            if (i == lcsPath1.size() - 1) {
                if (index1 < len1 - 1) {
                    ansList.addAll(strToCharList(str1.substring(index1 + 1)));
                }

                if (index2 < len2 - 1) {
                    ansList.addAll(strToCharList(str2.substring(index2 + 1)));
                }
            } else {
                for (j = index1 + 1; j < lcsPath1.get(i+1); j++) {
                    ansList.add(str1.charAt(j));
                }
                for (j = index2 + 1; j < lcsPath2.get(i+1); j++) {
                    ansList.add(str2.charAt(j));
                }
            }
        }

        StringBuilder ansSb = new StringBuilder();

        for (Character c: ansList) {
            ansSb.append(c);
        }

        return ansSb.toString();
    }
    
    public static void main(String[] args) {
        System.out.println(new Problem1092().shortestCommonSupersequence("abac", "cab"));
    }
    
}
