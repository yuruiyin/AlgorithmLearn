package lcci;

import java.util.*;

public class Lcci1707 {

    private Map<String, Integer> getNameToCountMap(String[] names) {
        Map<String, Integer> nameToCountMap = new HashMap<>();

        for (String nameAndCount : names) {
            int leftParenthesesIndex = nameAndCount.indexOf('(');
            String name = nameAndCount.substring(0 , leftParenthesesIndex);
            String count = nameAndCount.substring(leftParenthesesIndex + 1, nameAndCount.length() - 1);
            nameToCountMap.put(name, Integer.parseInt(count));
        }

        return nameToCountMap;
    }

    private Map<String, List<String>> getNameToTreeMap(String[] synonyms) {
        Map<String, List<String>> nameToTreeMap = new HashMap<>();

        for (String synonym : synonyms) {
            String towName = synonym.substring(1, synonym.length() - 1);
            String[] nameArr = towName.split(",");
            String name1 = nameArr[0];
            String name2 = nameArr[1];
            List<String> tree1 = nameToTreeMap.getOrDefault(name1, null);
            List<String> tree2 = nameToTreeMap.getOrDefault(name2, null);

            if (tree1 != null && tree2 != null) {
                if (tree1 == tree2) {
                    continue;
                }

                tree1.addAll(tree2);
                for (String tmpName : tree2) {
                    nameToTreeMap.put(tmpName, tree1);
                }
            } else if (tree1 != null) {
                tree1.add(name2);
                nameToTreeMap.put(name2, tree1);
            } else if (tree2 != null) {
                tree2.add(name1);
                nameToTreeMap.put(name1, tree2);
            } else {
                List<String> tree = new ArrayList<>();
                tree.add(name1);
                tree.add(name2);
                nameToTreeMap.put(name1, tree);
                nameToTreeMap.put(name2, tree);
            }
        }

        return nameToTreeMap;
    }

    public String[] trulyMostPopular(String[] names, String[] synonyms) {
        Map<String, Integer> nameToCountMap = getNameToCountMap(names);
        Map<String, List<String>> nameToTreeMap = getNameToTreeMap(synonyms);

        List<String> ansList = new ArrayList<>();
        Set<List<String>> set = new HashSet<>();
        for (String nameAndCount : names) {
            int leftParenthesesIndex = nameAndCount.indexOf('(');
            String name = nameAndCount.substring(0 , leftParenthesesIndex);
            List<String> tree = nameToTreeMap.getOrDefault(name, null);
            if (tree == null) {
                ansList.add(nameAndCount);
                continue;
            }

            if (set.contains(tree)) {
                continue;
            }

            String minName = null;
            int count = 0;
            for (int i = 0; i < tree.size(); i++) {
                String tmpName = tree.get(i);
                if (!nameToCountMap.containsKey(tmpName)) {
                    continue;
                }

                count += nameToCountMap.get(tmpName);
                if (minName == null || tmpName.compareTo(minName) < 0) {
                    minName = tmpName;
                }
            }

            ansList.add(minName + "(" + count + ")");
            set.add(tree);
        }

        int size = ansList.size();
        String[] ansArr = new String[size];
        for (int i = 0; i < size; i++) {
            ansArr[i] = ansList.get(i);
        }

        return ansArr;
    }

}
