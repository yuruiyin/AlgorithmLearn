package contest.contest162;

import java.util.ArrayList;
import java.util.List;

public class Problem1255 {

    private int ansMax = Integer.MIN_VALUE;

    class Word {
        int score;
        int[] countArr;
        Word(int score, int[] countArr) {
            this.score = score;
            this.countArr = countArr;
        }
    }

    private void backTrack(int[] letterCountArr, List<Word> wordList, List<Word> tmpList, int from) {
        if (from == wordList.size()) {
            int score = 0;
            for (Word word: tmpList) {
                score += word.score;
            }

            if (score > ansMax) {
                ansMax = score;
            }
            return;
        }

        int[] countArr = new int[26];
        for (Word word: tmpList) {
            for (int i = 0; i < 26; i++) {
                countArr[i] += word.countArr[i];
            }
        }

        Word word = wordList.get(from);

        for (int i = 0; i < 26; i++) {
            countArr[i] += word.countArr[i];
        }

        boolean canChooseCurWord = true;
        for (int i = 0; i < 26; i++) {
            if (countArr[i] > letterCountArr[i]) {
                canChooseCurWord = false;
                break;
            }
        }

        if (canChooseCurWord) {
            // 选择当前单词
            tmpList.add(word);
            backTrack(letterCountArr, wordList, tmpList, from+1);
            tmpList.remove(tmpList.size() - 1);
            backTrack(letterCountArr, wordList, tmpList, from+1);
        } else {
            // 不选当前单词
            backTrack(letterCountArr, wordList, tmpList, from+1);
        }
    }

    public int maxScoreWords(String[] words, char[] letters, int[] score) {
        int[] letterCountArr = new int[26];
        for (char letter: letters) {
            letterCountArr[letter - 'a']++;
        }

        List<String> matchWords = new ArrayList<>();
        for (String word: words) {
            boolean isOk = true;
            int[] tmpCountArr = new int[26];
            for (int i = 0; i < word.length(); i++) {
                char c = word.charAt(i);
                tmpCountArr[c - 'a']++;
                if (tmpCountArr[c - 'a'] > letterCountArr[c - 'a']) {
                    isOk = false;
                    break;
                }
            }

            if (isOk) {
                matchWords.add(word);
            }
        }

        List<Word> wordList = new ArrayList<>();
        for (String word: matchWords) {
            int tmpScore = 0;
            int[] countArr = new int[26];
            for (int i = 0; i < word.length(); i++) {
                char c = word.charAt(i);
                tmpScore += score[c - 'a'];
                countArr[c - 'a']++;
            }

            wordList.add(new Word(tmpScore, countArr));
        }

        backTrack(letterCountArr, wordList, new ArrayList<>(), 0);

        return ansMax;
    }
    
    public static void main(String[] args) {
        
    }
    
}
