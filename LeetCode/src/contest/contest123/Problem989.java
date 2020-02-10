package contest.contest123;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Problem989 {

    public List<Integer> addToArrayForm(int[] arr, int k) {
        int len = arr.length;
        List<Integer> kList = new ArrayList<>();

        while (k > 0) {
            kList.add(k % 10);
            k /= 10;
        }

        Collections.reverse(kList);

        int kSize = kList.size();
        int carry = 0;

        List<Integer> ansList = new ArrayList<>();

        int i, j;

        for (i = len - 1, j = kSize - 1; i >= 0 && j >= 0; i--, j--) {
            ansList.add((arr[i] + kList.get(j) + carry) % 10);
            carry = (arr[i] + kList.get(j) + carry) / 10;
        }

        if (i >= 0) {
            for (int ii = i; ii >= 0; ii--) {
                ansList.add((arr[ii] + carry) % 10);
                carry = (arr[ii] + carry) / 10;
            }
        }

        if (j >= 0) {
            for (int ii = j; ii >= 0; ii--) {
                ansList.add((kList.get(ii) + carry) % 10);
                carry = (kList.get(ii) + carry) / 10;
            }
        }

        if (carry == 1) {
            ansList.add(1);
        }

        Collections.reverse(ansList);

        return ansList;
    }

}
