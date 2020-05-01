package contest.contest185;

import java.util.*;

/**
 * A
 *
 * @author: yry
 * @date: 2020/4/19
 */
public class B {

    public List<List<String>> displayTable(List<List<String>> orders) {
        Map<String, Integer>[] countMap = new HashMap[501];
        Set<String> foodSet = new TreeSet<>();

        for (List<String> list : orders) {
            int table = Integer.parseInt(list.get(1));
            String food = list.get(2);
            foodSet.add(food);

            if (countMap[table] == null) {
                countMap[table] = new HashMap<>();
            }

            countMap[table].put(food, countMap[table].getOrDefault(food, 0) + 1);
        }

        List<List<String>> ansList = new ArrayList<>();
        List<String> firstLine = new ArrayList<>();
        firstLine.add("Table");
        firstLine.addAll(foodSet);
        ansList.add(firstLine);

        for (int i = 1; i < 501; i++) {
            if (countMap[i] == null) {
                continue;
            }

            Map<String, Integer> map = countMap[i];
            List<String> list = new ArrayList<>();
            list.add(i + "");
            for (String food : foodSet) {
                list.add(String.valueOf(map.getOrDefault(food, 0)));
            }

            ansList.add(list);
        }

        return ansList;
    }

}
