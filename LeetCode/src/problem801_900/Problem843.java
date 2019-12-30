package problem801_900;

import java.util.ArrayList;
import java.util.List;

public class Problem843 {

    static class Master {
        int guess(String word) {
            return -1;
        }
    }

    private int calcMatchDegree(String word1, String word2) {
        int count = 0;
        for (int i = 0; i < 6; i++) {
            if (word1.charAt(i) == word2.charAt(i)) {
                count++;
            }
        }

        return count;
    }

    public void findSecretWord(String[] wordlist, Master master) {
        int len = wordlist.length;
        int[][] disArr = new int[len][len]; // 两两单词之间的距离

        for (int i = 0; i < len; i++) {
            for (int j = 0; j < len; j++) {
                int dis = calcMatchDegree(wordlist[i], wordlist[j]);
                disArr[i][j] = dis;
            }
        }

        List<Integer> possible = new ArrayList<>();
        for (int i = 0; i < len; i++) {
            possible.add(i);
        }

        int[] sumArr = new int[len];
        for (int i = 0; i < len; i++) {
            for (int j = 0; j < len; j++) {
                sumArr[i] += disArr[i][j];
            }
        }

        while (true) {
            int maxSumWordIndex = -1;
            int maxSum = 0;
            // 每次取最大的相似度和的那个单词去guess
            for (Integer wordIndex: possible) {
                if (sumArr[wordIndex] > maxSum) {
                    maxSum = sumArr[wordIndex];
                    maxSumWordIndex = wordIndex;
                }
            }

            String word = wordlist[maxSumWordIndex];
            int dis = master.guess(word);
            if (dis == 6) {
                return;
            }

            List<Integer> newPossible = new ArrayList<>();
            for (Integer i : possible) {
                if (disArr[maxSumWordIndex][i] == dis && !i.equals(maxSumWordIndex)) {
                    newPossible.add(i);
                }
            }

            possible = newPossible;

        }

    }
    
    public static void main(String[] args) {
        new Problem843().findSecretWord(new String[]{"acckzz","ccbazz","eiowzz","abcczz"}, new Master());
    }

}
