import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Problem350 {

    public int[] intersect(int[] nums1, int[] nums2) {
        Map<Integer, Boolean> isDone = new HashMap<>();
        int len2 = nums2.length;
        List<Integer> ansList = new ArrayList<>();

        for (int item1 : nums1) {
            for (int j = 0; j < len2; j++) {
                if (!isDone.containsKey(j) && item1 == nums2[j]) {
                    ansList.add(item1);
                    isDone.put(j, true);
                    break;
                }
            }
        }

        int size = ansList.size();
        int[] ansArr = new int[size];
        for (int i = 0; i < size; i++) {
            ansArr[i] = ansList.get(i);
        }

        return ansArr;
    }

    public static void main(String[] args) {
        int[] ansArr = new Problem350().intersect(new int[]{1,2,2,1}, new int[]{2, 2});
//        int[] ansArr = new Problem350().intersect(new int[]{4,9,5}, new int[]{9,4,9,8,4});


        for (int item : ansArr) {
            System.out.print(item + ",");
        }
    }
}
