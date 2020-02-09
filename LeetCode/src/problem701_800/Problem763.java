package problem701_800;

import java.util.ArrayList;
import java.util.List;

public class Problem763 {

    public List<Integer> partitionLabels(String str) {
        char[] arr = str.toCharArray();
        int len = arr.length;

        List<Integer>[] indexListArr = new ArrayList[26];

        for (int i = 0; i < len; i++) {
            int charIndex = arr[i] - 'a';
            if (indexListArr[charIndex] == null) {
                indexListArr[charIndex] = new ArrayList<>();
            }

            indexListArr[charIndex].add(i);
        }

        List<Integer> ansList = new ArrayList<>();

        for (int i = 0; i < len;) {
            int from = i;
            int end = i;
            while (true) {
                char curChar = arr[from];
                List<Integer> indexList = indexListArr[curChar - 'a'];
                end = Math.max(end, indexList.get(indexList.size() - 1));
                if (end == from) {
                    break;
                }

                from++;
            }

            ansList.add(end - i + 1);
            i = end + 1;
        }

        return ansList;
    }

}
