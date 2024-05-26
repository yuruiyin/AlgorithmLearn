package doubleContest.round115;

import java.util.*;

public class D {

    private static final int MOD = 1000000007;

    private int[] countArr = new int[20000 + 1];

    private int len;

    private int[] arr;

    private int[] sufSumArr;

    private Map<Integer, Integer> memoMap;

    private int dp(int idx, int sum) {
        if (sum < 0) {
            return -1;
        }

        if (sum == 0) {
            if (idx < len && arr[idx] == 0) {
                return countArr[arr[idx]];
            }
            return 1;
        }

        if (idx == len) {
            return -1;
        }

        if (sufSumArr[idx] < sum) {
            return -2;
        }

        int key = idx * 20000 + sum;
        if (memoMap.containsKey(key)) {
            return memoMap.get(key);
        }

        int num = arr[idx];
        int ans = 0;
        for (int count = 0; count <= countArr[num]; count++) {
            int res = dp(idx + 1, sum - count * num);
            if (res == -2) {
                break;
            }
            if (res >= 0) {
                ans = (ans + res) % MOD;
            }
        }

        memoMap.put(key, ans);
        return ans;
    }

    private void calcSufSumArr() {
        sufSumArr = new int[len];
        sufSumArr[len - 1] = arr[len - 1] * countArr[arr[len - 1]];
        for (int i = len - 2; i >= 0; i--) {
            sufSumArr[i] = sufSumArr[i + 1] + arr[i] * countArr[arr[i]];
        }
    }

    public int countSubMultisets(List<Integer> nums, int l, int r) {
        int size = nums.size();
        for (int i = 0; i < size; i++) {
            countArr[nums.get(i)]++;
        }

        Set<Integer> set = new HashSet<>(nums);
        List<Integer> list = new ArrayList<>(set);
        Collections.sort(list);
        len = list.size();
        arr = new int[len];
        for (int i = 0; i < len; i++) {
            arr[i] = list.get(i);
        }

        calcSufSumArr();

        memoMap = new HashMap<>();
        int ans = 0;
        for (int i = l; i <= r; i++) {
            ans = (ans + dp(0, i)) % MOD;
            if (i == 0) {
                ans = (ans + 1) % MOD;
            }
        }

        return ans;
    }

    public static void main(String[] args) {
//        List<Integer> nums = new ArrayList<>();
//        for (int i = 0; i < 6; i++) {
//            nums.add(0);
//        }
//        System.out.println(new D().countSubMultisets(nums, 0, 0));

        List<Integer> nums = new ArrayList<>();
        for (int i = 0; i < 2; i++) {
            nums.add(1);
        }
        System.out.println(new D().countSubMultisets(nums, 2, 2));
    }

}
