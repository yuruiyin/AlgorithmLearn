package contest.contest196;

import java.util.ArrayList;
import java.util.List;

/**
 * D_1
 *
 * @author: yry
 * @date: 2020/7/5
 */
public class D_1 {

    public String minInteger(String num, int k) {
        char[] arr = num.toCharArray();
        int len = arr.length;

        List<Integer> numList = new ArrayList<>();

        for (char c : arr) {
            numList.add(c - '0');
        }

        StringBuilder ansSb = new StringBuilder();
        for (int i = 0; i < len - 1; i++) {
            int curNum = numList.get(i);
            int minNum = curNum;
            int minNumIdx = -1;
            for (int j = i + 1; j < len && j <= i + k; j++) {
                int tmpNum = numList.get(j);
                if (tmpNum < minNum) {
                    minNum = tmpNum;
                    minNumIdx = j;
                }
            }

            if (minNum < curNum) {
                ansSb.append(minNum);
                numList.remove(minNumIdx);
                numList.add(0, minNum);
                k -= (minNumIdx - i);
            } else {
                ansSb.append(curNum);
            }
        }

        int size = ansSb.length();
        for (int i = size; i < len; i++) {
            ansSb.append(numList.get(i));
        }

        return ansSb.toString();
    }

}
