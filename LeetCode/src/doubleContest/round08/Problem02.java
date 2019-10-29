package doubleContest.round08;

import utils.PrintUtil;

import java.util.*;

public class Problem02 {

    private String[] getFirstAndLastWord(String phrase) {
        String[] words = phrase.split(" ");
        return new String[]{words[0], words[words.length - 1]};
    }

    public List<String> beforeAndAfterPuzzles(String[] phrases) {
        int n = phrases.length;

        Set<String> set = new HashSet<>();

        for (int i = 0; i < n; i++) {
            String[] firstAndLastWord = getFirstAndLastWord(phrases[i]);
            for (int j = i + 1; j < n; j++) {
                String[] firstAndLastWord2 = getFirstAndLastWord(phrases[j]);
                if (firstAndLastWord[0].equals(firstAndLastWord2[1])) {
                    String newPhrase;
                    if (firstAndLastWord[0].length() == phrases[i].length()) {
                        // 就一个单词
                        newPhrase = phrases[j];
                    } else {
                        newPhrase = phrases[j] + " " + phrases[i].substring(firstAndLastWord[0].length() + 1);
                    }
                    set.add(newPhrase);
                }

                if (firstAndLastWord[1].equals(firstAndLastWord2[0])) {
                    String newPhrase;
                    if (firstAndLastWord2[0].length() == phrases[j].length()) {
                        // 就一个单词
                        newPhrase = phrases[i];
                    } else {
                        newPhrase = phrases[i] + " " + phrases[j].substring(firstAndLastWord2[0].length() + 1);
                    }
                    set.add(newPhrase);
                }
            }
        }

        List<String> ansList = new ArrayList<>(set);

        Collections.sort(ansList);

        return ansList;
    }

    public static void main(String[] args) {
        List<String> ansList = new Problem02().beforeAndAfterPuzzles(new String[]{
                "writing code","code rocks"
        });
        PrintUtil.printStringList(ansList);

        List<String> ansList1 = new Problem02().beforeAndAfterPuzzles(new String[]{
                "mission statement",
                "a quick bite to eat",
                "a chip off the old block",
                "chocolate bar",
                "mission impossible",
                "a man on a mission",
                "block party",
                "eat my words",
                "bar of soap"
        });
        PrintUtil.printStringList(ansList1);

        List<String> ansList2 = new Problem02().beforeAndAfterPuzzles(new String[]{
                "a","b","a"
        });
        PrintUtil.printStringList(ansList2);
    }
}

//       示例 1：
//
//        输入：phrases = ["writing code","code rocks"]
//        输出：["writing code rocks"]

//        示例 2：
//
//        输入：phrases = ["mission statement",
//        "a quick bite to eat",
//        "a chip off the old block",
//        "chocolate bar",
//        "mission impossible",
//        "a man on a mission",
//        "block party",
//        "eat my words",
//        "bar of soap"]
//        输出：["a chip off the old block party",
//        "a man on a mission impossible",
//        "a man on a mission statement",
//        "a quick bite to eat my words",
//        "chocolate bar of soap"]

//        示例 3：
//
//        输入：phrases = ["a","b","a"]
//        输出：["a"]

//提示：
//
//        1 <= phrases.length <= 100
//        1 <= phrases[i].length <= 100
