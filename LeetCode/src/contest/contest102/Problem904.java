package contest.contest102;

import java.util.HashMap;
import java.util.Map;

public class Problem904 {

    private int getFirstMinIndex(Map<Integer, Integer> map) {
        int min = 40001;
        int removeKey = 0;
        for (Integer key : map.keySet()) {
            if (map.get(key) < min) {
                min = map.get(key);
                removeKey = key;
            }
        }
        map.remove(removeKey);
        return min;
    }

    public int totalFruit(int[] tree) {

        int max = 1;
        int len = tree.length;
        Map<Integer, Integer> map = new HashMap<>();
        int jStartIndex = 1;

        for (int i = 0; i < len; ) {
            if (!map.containsKey(tree[i])) {
                map.put(tree[i], i);
            }
            int j;
            for (j = jStartIndex; j < len; j++) {
                if (map.size() == 2 && !map.containsKey(tree[j])) {
                    // 前面已达到2种类型
                    max = Math.max(max, j - i);
                    int firstMinIndex = getFirstMinIndex(map);
                    i = firstMinIndex + 1;
                    jStartIndex = j + 1;
                    map.put(tree[j], j);
                    break;
                }
                map.put(tree[j], j);
            }

            if (j == len || j == len - 1) {
                // 到尾了
                max = Math.max(max, len - i);
                if (map.keySet().size() > 2) {
                    max--;
                }
                break;
            }

        }

        return max;

    }

    public static void main(String[] args) {
        int [] arr = {3,3,3,1,2,1,1,2,3,3,4};
//        int [] arr = {1, 2, 3, 2, 2};
//        int [] arr = {0, 1, 2, 2}; //3
//        int [] arr = {1, 2, 1}; //3
//        int [] arr = {6,2,1,1,3,6,6}; //3
//        int[] arr = {0,1,1,4,3};  // 3
//        int[] arr = {4,7,7,0,8,3,8,2,5};  //3

        System.out.println(new Problem904().totalFruit(arr));
    }

}
