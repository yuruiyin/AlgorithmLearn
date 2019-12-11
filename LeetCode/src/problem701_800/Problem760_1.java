package problem701_800;

import java.util.ArrayList;
import java.util.List;

public class Problem760_1 {

    public int[] anagramMappings(int[] arrA, int[] arrB) {
        int len = arrA.length;
        int[] ans = new int[len];
        List<Integer>[] indexListArr = new ArrayList[100001];

        for (int i = 0; i < len; i++) {
            int num = arrB[i];
            if (indexListArr[num] == null) {
                indexListArr[num] = new ArrayList<>();
            }
            indexListArr[num].add(i);
        }

        for (int i = 0; i < len; i++) {
            int num = arrA[i];
            List<Integer> indexList = indexListArr[num];
            if (indexList != null && !indexList.isEmpty()) {
                int size = indexList.size();
                ans[i] = indexListArr[num].get(size - 1);
                indexListArr[num].remove(size - 1);
            }
        }

        return ans;
    }

}
