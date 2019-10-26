package contest.contest102;

import java.util.ArrayList;
import java.util.List;

public class Problem905 {

    public int[] sortArrayByParity(int[] A) {

        int len = A.length;
        int[] ans = new int[len];
        List<Integer> list1 = new ArrayList<>();
        List<Integer> list2 = new ArrayList<>();

        for (int i = 0; i < len; i++) {
            if (A[i] % 2 == 0) {
                list1.add(A[i]);
            } else {
                list2.add(A[i]);
            }
        }

        int index = 0;
        for (Integer num : list1) {
            ans[index++] = num;
        }
        for (Integer num : list2) {
            ans[index++] = num;
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] arr = {3, 1, 2, 4};

        int[] ans = new Problem905().sortArrayByParity(arr);
        for (int i = 0; i < ans.length; i++) {
            System.out.println(ans[i]);
        }
    }

}
