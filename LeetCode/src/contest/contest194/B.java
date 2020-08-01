package contest.contest194;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * A
 *
 * @author: yry
 * @date: 2020/6/21
 */
public class B {

    public String[] getFolderNames(String[] names) {
        int n = names.length;
        String[] ansArr = new String[n];
        ansArr[0] = names[0];
        Map<String, Integer> indexMap = new HashMap<>();
        Set<String> set = new HashSet<>();
        set.add(names[0]);
        for (int i = 1; i < n; i++) {
            if (set.contains(names[i])) {
                if (!indexMap.containsKey(names[i])) {
                    int index = 1;
                    for (int j = 1; ;j++) {
                        String str = names[i] + "(" + j +")";
                        if (!set.contains(str)) {
                            index = j;
                            break;
                        }
                    }
                    ansArr[i] = names[i] + "(" + index +")"; ;
                    set.add(ansArr[i]);
                    indexMap.put(names[i], index);
                } else {
                    int index = indexMap.get(names[i]);
                    int newIndex = index + 1;
                    for (int j = index + 1; ;j++) {
                        String str = names[i] + "(" + j +")";
                        if (!set.contains(str)) {
                            newIndex = j;
                            break;
                        }
                    }
                    ansArr[i] = names[i] + "(" + newIndex + ")";
                    set.add(ansArr[i]);
                    indexMap.put(names[i], newIndex);
                }
            } else {
                ansArr[i] = names[i];
                set.add(names[i]);
            }
        }

        return ansArr;
    }

}
