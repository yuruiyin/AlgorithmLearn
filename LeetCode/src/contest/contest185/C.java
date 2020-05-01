package contest.contest185;

import java.util.*;

/**
 * A
 *
 * @author: yry
 * @date: 2020/4/19
 */
public class C {

    public int minNumberOfFrogs(String croakOfFrogs) {
        char[] arr = croakOfFrogs.toCharArray();
        int len = arr.length;

        if (len % 5 != 0) {
            return -1;
        }
        
        char[] charArr = new char[]{'c', 'r', 'o', 'a', 'k'};
        List<Character> list = new ArrayList<>();
        List<Integer>[] indexArr = new ArrayList[5];
        int[] charIndexArr = new int[128];
        for (int i = 0; i < 5; i++) {
            charIndexArr[charArr[i]] = i;
            indexArr[i] = new ArrayList<>();
        }

        for (char c: arr) {
            int curCharIndex = charIndexArr[c];
            int preCharIndex = (curCharIndex + 5 - 1) % 5;
            boolean isFound = false;
            if (indexArr[preCharIndex].size() > 0) {
                isFound = true;
                List<Integer> indexList = indexArr[preCharIndex];
                int index = indexList.get(indexList.size() - 1);
                list.set(index, c);
                indexArr[curCharIndex].add(index);
                indexList.remove(indexList.size() - 1);
            }

            if (!isFound) {
                if (c != 'c') {
                    return -1;
                }

                list.add(c);
                indexArr[curCharIndex].add(list.size() - 1);
            }
        }

        for (char c : list) {
            if (c != 'k') {
                return -1;
            }
        }

        return list.size();
    }

}
