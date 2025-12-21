package doubleContest.round153;

import java.util.ArrayList;
import java.util.List;

public class B {

    public int maxActiveSectionsAfterTrade(String s) {
        char[] arr = s.toCharArray();
        int n = s.length();
        List<int[]> oneIndexList = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (arr[i] == '1') {
                if (i == 0) {
                    oneIndexList.add(new int[]{0, 0});
                } else {
                    if (arr[i - 1] == '0') {
                        oneIndexList.add(new int[]{i, i});
                    } else {
                        oneIndexList.get(oneIndexList.size() - 1)[1] = i;
                    }
                }
            }
        }

        int[] preOneCountSumArr = new int[n];
        int[] sufOneCountSumArr = new int[n];
        preOneCountSumArr[0] = arr[0] == '1' ? 1 : 0;
        for (int i = 1; i < n; i++) {
            preOneCountSumArr[i] = preOneCountSumArr[i - 1] + (arr[i] == '1' ? 1 : 0);
        }

        sufOneCountSumArr[n - 1] = arr[n - 1] == '1' ? 1 : 0;
        for (int i = n - 2; i >= 0; i--) {
            sufOneCountSumArr[i] = sufOneCountSumArr[i + 1] + (arr[i] == '1' ? 1 : 0);
        }

        int ansMax = 0;
        int size = oneIndexList.size();
        for (int i = 0; i < size; i++) {
            int[] interval = oneIndexList.get(i);
            int l = interval[0];
            int r = interval[1];
            if (l == 0 || r == n - 1) {
                int other = 0;
                if (l > 0) {
                    other += preOneCountSumArr[l - 1];
                }
                if (r < n - 1) {
                    other += sufOneCountSumArr[r + 1];
                }
                ansMax = Math.max(ansMax, r - l + 1 + other);
            } else {
                int left = i == 0 ? 0 : oneIndexList.get(i - 1)[0];
                int right = i == size - 1 ? n - 1 : oneIndexList.get(i + 1)[1];
                int other = 0;
                if (left > 0) {
                    other += preOneCountSumArr[left - 1];
                }
                if (right < n - 1) {
                    other += sufOneCountSumArr[right + 1];
                }
                ansMax = Math.max(ansMax, right - left + 1 + other);
            }
        }

        return ansMax;
    }

}
