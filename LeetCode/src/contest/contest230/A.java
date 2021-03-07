package contest.contest230;

import java.util.List;

/**
 * A
 *
 * @author: yry
 * @date: 2021/2/28
 */
public class A {

    public int countMatches(List<List<String>> items, String ruleKey, String ruleValue) {
        //[typei, colori, namei]
        int ans = 0;
        for (List<String> list : items) {
            String type = list.get(0);
            String color = list.get(1);
            String name = list.get(2);
            if (ruleKey.equals("type")) {
                if (ruleValue.equals(type)) {
                    ans++;
                }
            } else if (ruleKey.equals("color")) {
                if (ruleValue.equals(color)) {
                    ans++;
                }
            } else {
                if (ruleValue.equals(name)) {
                    ans++;
                }
            }
        }

        return ans;
    }

}
