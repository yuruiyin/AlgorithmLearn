package spring_2020_group;

import java.util.*;

/**
 * A
 *
 * @author: yry
 * @date: 2020/4/25
 */
public class D_1 {

    private static final int MAXN = (int) (1e6 + 5);

    private int[] nums;
    private int n;
    private Map<Long, Integer> memoMap;
    private List<Integer>[] indexListArr;

    public int gcd(int p, int q) {
        if (q == 0) {
            return p;
        }
        return gcd(q, p % q);
    }

    private int dp(int l, int r) {
        if (l == r || gcd(nums[l], nums[r]) > 1) {
            return 1;
        }

        long key = l * n + r;
        if (memoMap.containsKey(key)) {
            return memoMap.get(key);
        }

        int ans = Integer.MAX_VALUE;
        for (int i = l; i < r; i++) {
            ans = Math.min(ans, dp(l, i) + dp(i + 1, r));
        }

        memoMap.put(key, ans);
        return ans;
    }

    private void createIndexListArr() {
        indexListArr = new ArrayList[MAXN];
        for (int i = 0; i < n; i++) {
            int num = nums[i];
            if (indexListArr[num] == null) {
                indexListArr[num] = new ArrayList<>();
            }
            indexListArr[num].add(i);
        }
    }

    public int splitArray(int[] nums) {
        this.nums = nums;
        memoMap = new HashMap<>();
        this.n = nums.length;

        createIndexListArr();

        return dp(0, n - 1);
    }
    
    public static void main(String[] args) {
        int[] nums = new int[100000];
        Random random = new Random();
        for (int i = 0; i < 100000; i++) {
            nums[i] = random.nextInt(1000000) + 2;
        }

        System.out.println(new D_1().splitArray(nums));
    }

}
