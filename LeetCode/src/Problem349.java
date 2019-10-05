import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Problem349 {
    public int[] intersection(int[] nums1, int[] nums2) {
        Map<Integer, Boolean> map = new HashMap<>();

        for (int item: nums1) {
            map.put(item, true);
        }

        List<Integer> resList = new ArrayList<>();
        for (int item : nums2) {
            if (map.containsKey(item)) {
                resList.add(item);
                map.remove(item);
            }
        }

        int size = resList.size();
        int[] resArr = new int[size];

        for (int i = 0; i < size; i++) {
            resArr[i] = resList.get(i);
        }

        return resArr;
    }

    public static void main(String[] args) {
//        int[] ansList = new Problem349().intersection(new int[]{1,2,2,1}, new int[]{2,2});
        int[] ansList = new Problem349().intersection(new int[]{4,9,5}, new int[]{9,4,9,8,4});
        for (int item: ansList) {
            System.out.print(item + " ");
        }

    }
}
