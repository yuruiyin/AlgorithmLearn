package contest.contest184;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * A
 *
 * @author: yry
 * @date: 2020/4/12
 */
public class A {

    public List<String> stringMatching(String[] words) {
        int len = words.length;
        List<String> list = new ArrayList<>();
        for (int i = 0; i < len; i++) {
            for (int j = 0; j < len; j++) {
                if (i == j) {
                    continue;
                }

                if (words[j].contains(words[i])) {
                    list.add(words[i]);
                    break;
                }
            }
        }

        return list;
    }

}
