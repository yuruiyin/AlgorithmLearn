package doubleContest.round13;

import utils.PrintUtil;

import java.util.*;

public class Problem03 {

    private List<List<String>> ansList = new ArrayList<>();

    private void backTrack(String[] textArr, Map<String, List<String>> treeMap, int from, List<String> tmpList) {
        if (from == textArr.length) {
            ansList.add(new ArrayList<>(tmpList));
            return;
        }

        int i;
        List<String> oldTmpList = new ArrayList<>(tmpList);
        for (i = from; i < textArr.length; i++) {
            String word = textArr[i];
            if (!treeMap.containsKey(word)) {
                tmpList.add(word);
                continue;
            }

            List<String> list = treeMap.get(word);
            for (String str: list) {
                tmpList.add(str);
                backTrack(textArr, treeMap, i+1, tmpList);
                tmpList.remove(tmpList.size() - 1);
            }

            break;
        }

        if (i == textArr.length) {
            ansList.add(new ArrayList<>(tmpList));
        }

        tmpList.clear();
        tmpList.addAll(oldTmpList);
    }

    public List<String> generateSentences(List<List<String>> synonyms, String text) {
        Map<String, List<String>> treeMap = new HashMap<>();

        for (List<String> synonym: synonyms) {
            String word1 = synonym.get(0);
            String word2 = synonym.get(1);

            if (treeMap.containsKey(word1) && treeMap.containsKey(word2)) {
                List<String> tree1 = treeMap.get(word1);
                List<String> tree2 = treeMap.get(word2);
                if (tree1 == tree2) {
                    continue;
                }

                tree1.addAll(tree2);
                for (String word: tree2) {
                    treeMap.put(word, tree1);
                }
            } else if (treeMap.containsKey(word1) && !treeMap.containsKey(word2)) {
                List<String> tree1 = treeMap.get(word1);
                tree1.add(word2);
                treeMap.put(word2, tree1);
            } else if (!treeMap.containsKey(word1) && treeMap.containsKey(word2)) {
                List<String> tree2 = treeMap.get(word1);
                tree2.add(word1);
                treeMap.put(word1, tree2);
            } else {
                List<String> tree = new ArrayList<>();
                tree.add(word1);
                tree.add(word2);
                treeMap.put(word1, tree);
                treeMap.put(word2, tree);
            }
        }

        String[] textArr = text.split(" ");

        backTrack(textArr, treeMap,0, new ArrayList<>());

        List<String> ans = new ArrayList<>();

        for (List<String> list : ansList) {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < list.size(); i++) {
                if (i == list.size() - 1) {
                    sb.append(list.get(i));
                } else {
                    sb.append(list.get(i));
                    sb.append(' ');
                }
            }
            ans.add(sb.toString());
        }

        Collections.sort(ans);

        return ans;

    }
    
    public static void main(String[] args) {
        List<List<String>> synonyms = new ArrayList<>();
        List<String> list1 = new ArrayList<>(Arrays.asList("happy","joy"));
        List<String> list2 = new ArrayList<>(Arrays.asList("sad","sorrow"));
        List<String> list3 = new ArrayList<>(Arrays.asList("joy","cheerful"));
        synonyms.add(list1);
        synonyms.add(list2);
        synonyms.add(list3);
        String text = "I am happy today but was sad yesterday";
        PrintUtil.printStringList(new Problem03().generateSentences(synonyms, text));

    }
    
}
